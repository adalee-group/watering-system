package edu.hucare.controller;

import edu.hucare.model.ControlDevice;
import edu.hucare.model.TerminalDevice;
import edu.hucare.model.User;
import edu.hucare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
     *
     * @return String "User Service"
     */
    @RequestMapping("")
    public String home() {
        return "User Service";
    }

    /**
     * User Login
     * Find user at databases by email
     *
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

    /**
     * Find a user by user id
     *
     * @param user_id
     * @return User
     */
    @RequestMapping(value = "/{user_id}")
    public User getUser(@PathVariable long user_id) {
        return repository.findOne(user_id);
    }

    /**
     * Get control devices from a user
     *
     * @param user_id
     * @return a group of  control devices
     */
    @RequestMapping(value = "/{user_id}/control")
    public Set<ControlDevice> getControl(@PathVariable long user_id) {
        User user = repository.findOne(user_id);
        return user.getControlDevices();
    }

    /**
     * Get terminal from a user
     *
     * @param user_id
     * @return a group of terminal
     */
    @RequestMapping(value = "/{user_id}/terminal")
    public Set<TerminalDevice> getTerminal(@PathVariable long user_id) {
        User user = repository.findOne(user_id);
        return user.getTerminalDevices();
    }
}
