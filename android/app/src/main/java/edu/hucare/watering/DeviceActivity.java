package edu.hucare.watering;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import edu.hucare.adapter.TerminalAdapter;
import edu.hucare.model.TerminalDevice;

@EActivity(R.layout.activity_device)
public class DeviceActivity extends Activity {

    public static TerminalDevice terminal;

    @ViewById
    ListView device_list;

    @Bean
    TerminalAdapter adapter;

    @AfterViews
    void bindAdapter() {
        device_list.setAdapter(adapter);
    }

    @ItemClick
    void deviceListItemClicked(TerminalDevice device) {
        terminal = device;
        Toast.makeText(this, "Clicked:" + device.getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ScheduleActivity_.class);
        startActivity(intent);
    }

}
