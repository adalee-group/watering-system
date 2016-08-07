package edu.hucare.watering;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import org.androidannotations.annotations.EActivity;

import edu.hucare.model.User;

@EActivity(R.layout.activity_device)
public class DeviceActivity extends LinearLayout {


    String[] listDevice;

    private ListAdapter adapter;

    public DeviceActivity(Context context) {
        super(context);
    }

    public void bind(User user) {

    }

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
