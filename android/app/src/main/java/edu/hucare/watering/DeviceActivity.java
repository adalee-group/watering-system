package edu.hucare.watering;

import android.app.Activity;
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
        Toast.makeText(this, "Clicked:" + device.getId(), Toast.LENGTH_SHORT).show();
    }

}
