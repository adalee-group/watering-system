package edu.hucare.repository.impl;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import org.springframework.web.client.RestTemplate;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.hucare.model.User;
import edu.hucare.repository.UserRepository;

/**
 * Created by Kuzon on 8/7/2016.
 */
public class UserImpl implements UserRepository {

    private User user;

    private static final int LOAD_SUCCESS = 0x1;

    private final UserHandler handler = new UserHandler(this);

    private static class UserHandler extends Handler {
        private final WeakReference<UserImpl> weakReference;

        public UserHandler(UserImpl context) {
            weakReference = new WeakReference<UserImpl>(context);
        }


        @Override
        public void handleMessage(Message msg) {
            UserImpl userImpl = weakReference.get();
            if (userImpl != null) {
                switch (msg.what) {
                    case LOAD_SUCCESS:
                        userImpl.user = (User) msg.obj;
                        break;
                }
            }
        }
    }

    @Override
    public Set<User> findAll() {
        return null;
    }


    @Override
    public User findOne(String host, String email, String password) {
        final String url = "http://" + host + "/user/";
        final User origin = new User(0, email, null, password, null, null, null);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RestTemplate restTemplate = new RestTemplate();
                User user = restTemplate.postForObject(url, origin, User.class);
                Message msg = handler.obtainMessage(LOAD_SUCCESS, user);
                handler.sendMessage(msg);
            }
        }).start();
        return user;
    }


}

