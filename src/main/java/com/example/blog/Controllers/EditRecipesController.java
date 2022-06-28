package com.example.blog.Controllers;

import com.example.blog.models.Post;
import com.example.blog.repository.PostReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EditRecipesController {
    @Autowired
    private PostReposirory postReposirory;

    @GetMapping("/AllRecipes/{id}/edit")
    public String recipesEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postReposirory.existsById(id)) {
            return "redirect:/AllRecipes";
        }
        Optional<Post> post = postReposirory.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "recipesEdit";
    }

    @PostMapping("/AllRecipes/{id}/edit")
    public String recipePostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Post post = postReposirory.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        postReposirory.save(post);
        return "redirect:/AllRecipes";
    }

    @PostMapping("/AllRecipes/{id}/remove")
    public String recipePostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postReposirory.findById(id).orElseThrow();
        postReposirory.delete(post);
        return "redirect:/AllRecipes";
    }
}
