package edu.hucare.viewgroup;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import edu.hucare.model.TerminalDevice;
import edu.hucare.watering.R;

/**
 * Created by Kuzon on 8/7/2016.
 */
@EViewGroup(R.layout.device_item)
public class TerminalItemView extends LinearLayout {

    @ViewById
    TextView terminal_id;

    @ViewById
    TextView terminal_status;

    public TerminalItemView(Context context) {
        super(context);
    }

    public void bind(TerminalDevice device) {
        terminal_id.setText(String.valueOf(device.getId()));
        terminal_status.setText(device.getStatus());
    }
}
