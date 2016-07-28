package edu.hucare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kuzon on 7/28/2016.
 */
@RestController
public class UserController {

    @RequestMapping("/")
    public String home() {
        return "User Service";
    }

}
