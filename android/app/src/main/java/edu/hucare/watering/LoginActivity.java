package edu.hucare.watering;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.hucare.model.User;
import edu.hucare.repository.impl.UserImpl;

/**
 * A login screen that offers login via email/password.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {

    public static String host;

    public static User user;


    // UI references.
    @ViewById
    EditText etHost;

    @ViewById
    EditText etEmail;

    @ViewById
    EditText etPassword;

    @Click
    void btnSignIn() {

        host = etHost.getText().toString();

        try {
            User origin = new User();
            origin.setEmail(etEmail.getText().toString());
            origin.setPassword(etPassword.getText().toString());

            DoLogin doLogin = new DoLogin();
            doLogin.execute(origin);

            long time_out = 5000;
            long time_count = 0;

            while (!doLogin.isSuccessful()) {
                if (time_count > time_count) {
                    Toast.makeText(getApplicationContext(), "请求超时", Toast.LENGTH_SHORT).show();
                }
                Thread.sleep(500);
                time_count += 500;
            }

            if (doLogin.isSuccessful()) {
                Intent intent = new Intent(this, DeviceActivity_.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "用户名密码错误", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "系统错误", Toast.LENGTH_SHORT).show();
        }


    }

    class DoLogin extends AsyncTask<User, User, User> {

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected User doInBackground(User... users) {
            try {

                final String url = "http://" + host + "/user/";

                RestTemplate restTemplate = new RestTemplate();

                User user = restTemplate.postForObject(url, users[0], User.class);
                isSuccessful = true;
                LoginActivity.user = user;
                return user;
            } catch (Exception e) {
                e.printStackTrace();
                isSuccessful = false;
            }
            return null;
        }


        protected void onPostExecute(String file_url) {
        }
    }

}

