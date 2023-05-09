package com.dlewburg.Recipie.controllers;

import com.dlewburg.Recipie.models.SiteUser;
import com.dlewburg.Recipie.repos.SiteUserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.mindrot.jbcrypt.BCrypt;

@Controller
public class AuthenticationController {
    @Autowired
    SiteUserRepo siteUserRepo;

    @GetMapping("/{message}")
    public String getHome() {
        return "login.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(String userName, String password) {
        // hash password (not working)
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        // create new user (with the hashed password)
        SiteUser newUser = new SiteUser(userName, password);

        // save to DB(db red not working)
        siteUserRepo.save(newUser);

        // redirect

        return new RedirectView("/");
    }

    // post mapping for login

    @PostMapping("/login")
    public String login(HttpServletRequest request, String userName, String password) {
        // find user by username
        SiteUser siteUser = siteUserRepo.getSiteUserByUsername(userName);

        // conditional ito check if they are a registered users (if not redirect to splash page)
        // if already registered, check password for accuracty (if not redirect to splash page)
        // if valid password, pame a session and log them in
//            if(siteUser != null) {
//                if(BCrypt.checkpw(password, siteUser.getPassword())){
//                    HttpSession session = request.getSession();
//                    session.setAttribute("userName", userName);
//                    return new RedirectView("/recipe.html");
//                }
//                    return new RedirectView("/?message=Invalid Password");
//        }
//                return new RedirectView("/?message=Invalid Password");
//    }
        return ("/");
    }
}
