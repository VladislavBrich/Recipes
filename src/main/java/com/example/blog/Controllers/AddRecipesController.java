package com.example.blog.Controllers;

import com.example.blog.models.Post;
import com.example.blog.repository.PostReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddRecipesController {
    @Autowired
    private PostReposirory postReposirory;

    @GetMapping("/AllRecipes/add")
    public String recipesAdd(Model model) {
        return "recipesAdd";
    }
    @PostMapping("/AllRecipes/add")
    public String recipePostAdd (@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title,anons,full_text);
        postReposirory.save(post);
        return "redirect:/AllRecipes";
    }
}
