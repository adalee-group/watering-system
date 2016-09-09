package edu.hucare.watering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
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

    @Click
    void fabAddSchedule() {
        Intent intent = new Intent(this, ModifyScheduleActivity_.class);
        startActivity(intent);
    }

}
