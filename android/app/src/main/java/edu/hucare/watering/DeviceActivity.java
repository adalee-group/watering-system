package edu.hucare.watering;

import android.app.Activity;
import android.widget.ListAdapter;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_device)
public class DeviceActivity extends Activity {


    String[] listDevice;

    private ListAdapter adapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_device);
////        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//
//        adapter = new ArrayAdapter<String>(this, R.layout.content_device, listDevice);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }


}
