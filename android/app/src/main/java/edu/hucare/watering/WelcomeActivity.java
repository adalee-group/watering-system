package edu.hucare.watering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends AppCompatActivity {

    @Click
    void btnEnter() {
        Intent login = new Intent(this, LoginActivity_.class);
        startActivity(login);
    }
}
