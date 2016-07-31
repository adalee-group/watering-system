package edu.hucare.controller;

import edu.hucare.model.User;
import edu.hucare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kuzon on 7/28/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * User Repository
     */
    @Autowired
    private UserRepository repository;

    /**
     * Entrance of User Service
     * @return String "User Service"
     */
    @RequestMapping("")
    public String home() {
        return "User Service";
    }

    /**
     * User Login
     * Find user at databases by email
     * @param user
     * @return a user model if request info correct or null when incorrect
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User doLogin(@RequestHeader User user) {
        User u = repository.findByEmail(user.getEmail());
        if (u.equals(null)) {
            return null;
        } else if (u.getPassword().equals(user.getPassword())) {
            return u;
        } else {
            return null;
        }
    }

}
