package edu.hucare.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import edu.hucare.model.Schedule;
import edu.hucare.repository.impl.ScheduleImpl;
import edu.hucare.repository.impl.TerminalImpl;
import edu.hucare.viewgroup.ScheduleView;
import edu.hucare.viewgroup.ScheduleView_;
import edu.hucare.watering.DeviceActivity;

/**
 * Created by kuzon on 16-9-8.
 */
@EBean
public class ScheduleAdapter extends BaseAdapter {

    List<Schedule> schedules;

    @Bean(ScheduleImpl.class)
    ScheduleImpl repository;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        schedules = repository.findAll(DeviceActivity.terminal);
    }

    @Override
    public int getCount() {
        return schedules.size();
    }

    @Override
    public Schedule getItem(int position) {
        return schedules.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScheduleView scheduleView;
        if (convertView == null) {
            scheduleView = ScheduleView_.build(context);
        } else {
            scheduleView = (ScheduleView) convertView;
        }

        scheduleView.bind(getItem(position));

        return scheduleView;
    }
}
