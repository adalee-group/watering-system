package edu.hucare.repository.impl;

import android.os.AsyncTask;

import org.springframework.web.client.RestTemplate;

import java.util.Set;

import edu.hucare.model.User;
import edu.hucare.repository.UserRepository;

/**
 * Created by Kuzon on 8/7/2016.
 */
public class UserImpl implements UserRepository {

    @Override
    public Set<User> findAll() {
        return null;
    }
}
