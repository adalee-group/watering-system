package edu.hucare.repository;

import java.util.Set;

import edu.hucare.model.User;

/**
 * Created by Kuzon on 8/6/2016.
 */
public interface UserRepository {
    Set<User> findAll();
}
