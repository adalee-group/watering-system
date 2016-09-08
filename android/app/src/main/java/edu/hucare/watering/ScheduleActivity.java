package edu.hucare.watering;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import edu.hucare.adapter.ScheduleAdapter;

@EActivity(R.layout.activity_schedule)
public class ScheduleActivity extends Activity {

    @ViewById
    ListView schedule_list;

    @Bean
    ScheduleAdapter adapter;

    @AfterViews
    void bindAdapter() {
        schedule_list.setAdapter(adapter);
    }

}
