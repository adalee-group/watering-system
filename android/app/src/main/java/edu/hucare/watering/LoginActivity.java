package edu.hucare.watering;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.hucare.model.User;

/**
 * A login screen that offers login via email/password.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {


    // UI references.
    @ViewById
    EditText etEmail;

    @ViewById
    EditText etPassword;

    @Click
    void btnSignIn() {

        try {
            User origin = new User();
            origin.setEmail(etEmail.getText().toString());
            origin.setPassword(etPassword.getText().toString());
            new DoLogin().execute(origin);
            Intent intent = new Intent(this, DeviceActivity_.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public User login() {
        final String url = "http://192.168.10.108:1984/user/";
        User origin = new User();
        origin.setEmail(etEmail.getText().toString());
        origin.setPassword(etPassword.getText().toString());

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        User user = restTemplate.postForObject(url, origin, User.class);

        return user;
    }

    class DoLogin extends AsyncTask<User, User, User> {


        protected User doInBackground(User... users) {

            try {

                final String url = "http://192.168.10.108:1984/user/";


                RestTemplate restTemplate = new RestTemplate();

                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

                User user = restTemplate.postForObject(url, users[0], User.class);
                return user;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }


        protected void onPostExecute(String file_url) {
        }
    }

}

