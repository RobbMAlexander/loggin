package com.robbmalexander.loggin.controller;

import com.robbmalexander.loggin.model.LogginUser;
import com.robbmalexander.loggin.repository.LogginUserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LogginUserController {
    @Autowired
    LogginUserRepository logginUserRepository;

    @GetMapping("/")
    public String getLoginPage(){
        return "index.html";
    }

    @GetMapping("/createAccount")
    public String getCreateAccountPage(){
        return "create-account.html";
    }

   @PostMapping("/createAccount")
    public RedirectView createAccount(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        LogginUser addedUser = new LogginUser(username, hashedPassword);
        logginUserRepository.save(addedUser);

        return new RedirectView("/");
    }

    @PostMapping("/login")
    public RedirectView login(String username, String password){
        LogginUser currentUser = logginUserRepository.findByUsername(username);
        if(currentUser == null) {
            return new RedirectView("/");
        }

        boolean correctPassword = BCrypt.checkpw(password, currentUser.getPassword());

        if (!correctPassword){
            return new RedirectView("/");
        } else {
            return new RedirectView("/posts/" + username);
        }



    }

}
