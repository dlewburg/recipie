package com.dlewburg.Recipie.controllers;

import com.dlewburg.Recipie.models.SiteUser;
import com.dlewburg.Recipie.repos.SiteUserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class RecipeController {
    @Autowired
    SiteUserRepo siteUserRepo;
    @GetMapping("recipe")
    public String getRecipe(HttpServletRequest request, Model m) {
        HttpSession session = request.getSession();
        String userName = session.getAttribute("userName").toString();

        // authenticate user
        if(userName != null){
            m.addAttribute("userName", userName);
            SiteUser siteUser = siteUserRepo.getSiteUserByUsername(userName);
            return "recipe.html";
        }
        return "login.html";
    }
}
