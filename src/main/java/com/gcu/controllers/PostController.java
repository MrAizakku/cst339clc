package com.gcu.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.models.CategoryModel;
import com.gcu.models.PostModel;

@Controller
@SessionAttributes("userData")
@RequestMapping("/post")
public class PostController {
	private List<CategoryModel> categories;
	
	public PostController() {
		this.categories = loadCategories();
	}

	private List<CategoryModel> loadCategories() {
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		list.add(new CategoryModel(1,"Dogs"));
		list.add(new CategoryModel(2,"Cats"));
		list.add(new CategoryModel(3,"Food"));
		list.add(new CategoryModel(4,"Politics"));
		return list;
	}

	@GetMapping("/new")
	public String display(Model model) {
		model.addAttribute(new PostModel());
		model.addAttribute("categories", categories);
		return "postNew";
	}
	
	@PostMapping("/doPost")
	public ModelAndView doPost(@Valid PostModel postModel, BindingResult bindingResult, Model model) {
		ModelAndView mv = new ModelAndView();
		
		setCategory_stringToObject(postModel, bindingResult);
		
		//printing object to console to test.
		System.out.println(String.format("The post is in Category: %s, and it contains Title: %s, Content: %s.", postModel.getCategory().getCategoryName(), postModel.getTitle(), postModel.getContent()));
		
		if (bindingResult.getFieldError("title") != null || bindingResult.getFieldError("content") != null || bindingResult.getFieldError("keywords") != null) {
			mv.addObject("categories", categories);
			mv.setViewName("postNew");
			return mv;
		}
		//put post in DB for later views to pull for viewing.
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
