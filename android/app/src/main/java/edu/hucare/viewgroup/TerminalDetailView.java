package edu.hucare.viewgroup;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import edu.hucare.watering.R;

/**
 * Created by kuzon on 16-9-8.
 */
@EViewGroup(R.layout.device_details)
public class TerminalDetailView extends LinearLayout {

    @ViewById
    TextView id_value;

    @ViewById
    TextView date_value;

    @ViewById
    TextView water_value;

    public TerminalDetailView(Context context) {
        super(context);
    }
}
