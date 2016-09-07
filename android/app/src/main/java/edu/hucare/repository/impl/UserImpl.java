package edu.hucare.repository.impl;

import android.os.AsyncTask;

import org.springframework.web.client.RestTemplate;

import java.util.Set;

import edu.hucare.model.User;
import edu.hucare.repository.UserRepository;

/**
 * Created by Kuzon on 8/7/2016.
 */
public class UserImpl extends AsyncTask<User, User, User> implements UserRepository {

    private User origin;
    private User result;

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public User findOne(User user) {
        this.origin = user;
        return doInBackground();
    }

    @Override
    protected User doInBackground(User... params) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    final String url = "http://192.168.10.108:1984/user/";

                    RestTemplate restTemplate = new RestTemplate();

                    result = restTemplate.postForObject(url, origin, User.class);
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        return result;
    }
}
