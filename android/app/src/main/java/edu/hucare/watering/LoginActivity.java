package edu.hucare.watering;

import android.app.Activity;
import android.widget.ImageView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Kuzon on 8/4/2016.
 */
@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {

    @ViewById
    ImageView ImgBackground;
}
