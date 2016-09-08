package edu.hucare.viewgroup;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import edu.hucare.model.Schedule;
import edu.hucare.watering.R;

/**
 * Created by kuzon on 16-9-8.
 */
@EViewGroup(R.layout.schedule_details)
public class ScheduleView extends LinearLayout {

    @ViewById
    TextView schedule_id;

    @ViewById
    TextView schedule_date;

    @ViewById
    TextView schedule_water;

    @ViewById
    TextView schedule_status;

    public ScheduleView(Context context) {
        super(context);
    }

    public void bind(Schedule schedule) {
        schedule_id.setText(String.valueOf(schedule.getId()));
        schedule_date.setText(String.valueOf(schedule.getDate()));
        schedule_water.setText(String.valueOf(schedule.getWater()));
        schedule_status.setText(schedule.getStatus());
    }
}
