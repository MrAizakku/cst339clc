package com.gcu.controllers;
import java.util.ArrayList;
import java.util.Date;
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
	
	public PostController() {
		this.categories = loadCategories();
	}

	private List<CategoryModel> loadCategories() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		list.add(new CategoryModel(2,"Dogs"));
		list.add(new CategoryModel(3,"Cats"));
		list.add(new CategoryModel(4,"Food"));
		list.add(new CategoryModel(5,"Politics"));
		return list;
	}
	

	@GetMapping("/all")
	public String postsAll(Model model) {
		model.addAttribute(new PostModel());
		//load posts into some array list
		List<PostModel> posts = new ArrayList<PostModel>();
		posts.add(new PostModel(0, "Test Post 1", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(1, "Test Post 2", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(2, "Test Post 3", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(4, "Test Post 4", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		model.addAttribute("page_title", "All Posts");
		model.addAttribute("posts", posts);
		return "postList";
	}

	@GetMapping("/myBlog")
	public String postsMy(Model model) {
		model.addAttribute(new PostModel());
		//load posts into some array list for this user only.
		List<PostModel> posts = new ArrayList<PostModel>();
		posts.add(new PostModel(0, "My Test Post 1", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(1, "My Test Post 2", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(2, "My Test Post 3", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		posts.add(new PostModel(4, "My Test Post 4", "testtesttesttesttest", null, null, 0, null, 0, null, "#dumb #test", null));
		model.addAttribute("page_title", "My Posts");
		model.addAttribute("posts", posts);
		return "postList";
	}
	
	@GetMapping("/{id}")
	public String postSingle(@PathVariable String id, Model model) {
		//check if id is int, if not return errorView. If int then cont.
		//load the post with ID = id
		PostModel post = new PostModel(0, "I am not yours.", 
				"I am not yours, not lost in you,\r\n"
				+ "Not lost, although I long to be\r\n"
				+ "Lost as a candle lit at noon,\r\n"
				+ "Lost as a snowflake in the sea.\r\n"
				+ "\r\n"
				+ "You love me, and I find you still\r\n"
				+ "A spirit beautiful and bright,\r\n"
				+ "Yet I am I, who long to be\r\n"
				+ "Lost as a light is lost in light.\r\n"
				+ "\r\n"
				+ "Oh plunge me deep in love—put out\r\n"
				+ "My senses, leave me deaf and blind,\r\n"
				+ "Swept by the tempest of your love,\r\n"
				+ "A taper in a rushing wind.", null, null, 0, null, 0, null, "#dumb #test", null);
		model.addAttribute(new CommentModel());
		model.addAttribute("post", post);
		return "postView";
	}

	@GetMapping("/new")
	public String postNew(Model model) {
		if(!model.containsAttribute("userData")) {
			return "index";
		}
		
		model.addAttribute(new PostModel());
		model.addAttribute("categories", categories);
		return "postNew";
	}
	
	@PostMapping("/doPost")
	public ModelAndView doPost(@Valid PostModel postModel, BindingResult bindingResult, Model model, @ModelAttribute("userData") UserModel user) {
		ModelAndView mv = new ModelAndView();
		
		setCategory_stringToObject(postModel, bindingResult);
		
		//printing object to console to test.
		System.out.println(String.format("The post is in Category: %s, and it contains Title: %s, Content: %s.", postModel.getCategory().getCategoryName(), postModel.getTitle(), postModel.getContent()));
		
		if (bindingResult.getFieldError("title") != null || bindingResult.getFieldError("content") != null || bindingResult.getFieldError("keywords") != null) {
			mv.addObject("categories", categories);
			mv.setViewName("postNew");
			return mv;
		}

		postModel.setDate(new Date());
		postModel.setAuthorID(user.getUserID());
		postModel.setUpdatedDate(postModel.getDate());
		postModel.setUpdatedBy(postModel.getAuthorID());
		
		//put post in DB for later views to pull for viewing.
		bservice.doPost(postModel);
		
		
		
		mv.addObject("newPost", postModel);
		mv.setViewName("index");
		return mv;
	}

	private void setCategory_stringToObject(PostModel postModel, BindingResult bindingResult) {
		//convert string selection back to object.
		String category = (String) bindingResult.getFieldValue("category"); //get the selection as string
		System.out.println("Category:" + category);
		//search the list for a match

		if(category == null) {
			postModel.setCategory(new CategoryModel(0, "Undefined"));
		}
		else {
			for (CategoryModel name : this.categories) {
				System.out.println("Searching... '" + name.getCategoryName()+ "'");
				System.out.println("comapring too... '" + category + "'");
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
