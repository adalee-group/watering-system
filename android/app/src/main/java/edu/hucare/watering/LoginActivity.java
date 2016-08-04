package edu.hucare.watering;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

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
        Toast.makeText(getApplicationContext(), "Button is clicked", Toast.LENGTH_LONG).show();
    }

}

