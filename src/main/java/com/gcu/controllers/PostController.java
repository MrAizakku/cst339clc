package com.gcu.controllers;

import java.sql.Timestamp;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.models.CategoryModel;
import com.gcu.models.CommentModel;
import com.gcu.models.PostModel;
import com.gcu.models.UserModel;
import com.gcu.service.BusinessServiceInterface;

@Controller
@SessionAttributes("userData")
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private BusinessServiceInterface bservice;
	
	private List<CategoryModel> categories;

	@GetMapping("/all")
	public String postsAll(Model model) {
		//load posts into some array list
		List<PostModel> posts = this.bservice.getPosts();
		model.addAttribute("page_title", "All Posts");
		model.addAttribute("posts", posts);
		return "postList";
	}

	@GetMapping("/myBlog")
	public String postsMy(Model model) {
		//if user is in session
		if(model.getAttribute("userData") != null) {
			//load posts into some array list for this user only.
			List<PostModel> posts = this.bservice.getMyPosts(((UserModel) model.getAttribute("userData")).getUserID());
			model.addAttribute("page_title", "My Posts");
			model.addAttribute("posts", posts);
			return "postList";			
		} 
		//if no user in session, display all posts.
		return postsAll(model);
	}
	
	@GetMapping("/{id}")
	public String postSingle(@PathVariable String id, Model model) {
		//check if id is int, if not return errorView. If int then cont.
		//load the post with ID = id
		PostModel post = this.bservice.findByID(Integer.parseInt(id));
		model.addAttribute(new CommentModel());
		model.addAttribute("post", post);
		return "postView";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteSingle(@PathVariable String id, Model model) {
		//load the post with ID = id
		PostModel post = this.bservice.findByID(Integer.parseInt(id));
		if(((UserModel) model.getAttribute("userData")).getUserID() == post.getAuthorID()) {
			this.bservice.deletePostById(id);
		}
		return postsAll(model);
	}

	@GetMapping("/new")
	public String postNew(Model model) {
		if(!model.containsAttribute("userData")) {
			return "index";
		}
		
		this.categories = this.bservice.loadCategories();
		model.addAttribute(new PostModel());
		model.addAttribute("categories", categories);
		model.addAttribute("button","Create Post");
		return "postNew";
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editSingle(@PathVariable String id, Model model) {
		ModelAndView mv = new ModelAndView();
		PostModel post = this.bservice.findByID(Integer.parseInt(id));
		
		System.out.println("Post ID: " + post.getID() + " " + post.toString() );
		
		if(((UserModel) model.getAttribute("userData")).getUserID() == post.getAuthorID()) {
			this.categories = this.bservice.loadCategories();
			mv.addObject(post);
			mv.addObject("button","Update Post");
			mv.addObject("categories", categories);
			mv.setViewName("postNew");
		} else {
			mv.setViewName("index");
		}
		return mv;
	}
	
	@PostMapping("/doPost")
	public ModelAndView doPost(@Valid PostModel postModel, BindingResult bindingResult, Model model, @SessionAttribute("userData") UserModel user) {
		ModelAndView mv = new ModelAndView();
		setCategory_stringToObject(postModel, bindingResult);
		
		if (bindingResult.getFieldError("title") != null || bindingResult.getFieldError("content") != null || bindingResult.getFieldError("keywords") != null) {
			mv.addObject("categories", categories);
			mv.setViewName("postNew");
			return mv;
		}

		if(postModel.getID() == 0) { //ID only assigned once inserted into DB. if 0, new post.
			postModel.setDate(new Timestamp(System.currentTimeMillis()));
			postModel.setAuthorID(user.getUserID());
			postModel.setUpdatedDate(postModel.getDate());
			postModel.setUpdatedBy(postModel.getAuthorID());
			bservice.doPost(postModel);
		} else {					// if anything other than 0, ID has been loaded from the post
			postModel.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
			postModel.setUpdatedBy(user.getUserID());
			bservice.updatePost(postModel);
		}
		
		mv.addObject("newPost", postModel);
		mv.setViewName("index");
		return mv;
	}

	private void setCategory_stringToObject(PostModel postModel, BindingResult bindingResult) {
		//convert string selection back to object.
		String category = (String) bindingResult.getFieldValue("category"); //get the selection as string
		//System.out.println("Category:" + category);
		//search the list for a match

		if(category == null) {
			postModel.setCategory(new CategoryModel(0, "Undefined"));
		}
		else {
			for (CategoryModel name : this.categories) {
				//System.out.println("Searching... '" + name.getCategoryName()+ "'");
				//System.out.println("comapring too... '" + category + "'");
				if(name.getCategoryName().equals(category)) {
					//add object back to postModel.
					postModel.setCategory(name);
					System.out.println("Match!");
					break;
				}
			}
		}
	}
}
