package com.example.blog.Controllers;


import com.example.blog.models.Post;
import com.example.blog.repository.PostReposirory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AllRecipesController {

    @Autowired
    private PostReposirory postReposirory;

    @GetMapping("/AllRecipes")
    public String Recipes(Model model) {
        Iterable<Post> posts = postReposirory.findAll();
        model.addAttribute("posts", posts);
        return "AllRecipes";
    }
    @GetMapping("/AllRecipes/{id}")
    public String recipesDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postReposirory.existsById(id)){
            return "redirect:/AllRecipes";
        }
        Optional<Post> post = postReposirory.findById(id);
        ArrayList <Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "recipesDetails";
    }
}