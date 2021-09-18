package com.gcu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.DataAccessInterface;
import com.gcu.models.PostModel;

@RestController
@RequestMapping("/service")
public class PostRestService {
	@Autowired
	DataAccessInterface<PostModel> service;
	
	@GetMapping(path="/posts", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<PostModel> getPosts() {
		return service.findAll();
	}
	
	@GetMapping(path="/posts/{string_id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public PostModel getPostsById(@PathVariable("string_id") String sid) {
	  try {
		  int id = Integer.parseInt(sid);
		  return service.findById(id);
	  } catch (NumberFormatException e) {
		  return null;
	  }
	}
}
