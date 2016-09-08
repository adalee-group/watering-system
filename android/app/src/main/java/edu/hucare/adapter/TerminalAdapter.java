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

import edu.hucare.model.TerminalDevice;
import edu.hucare.repository.impl.TerminalImpl;
import edu.hucare.viewgroup.TerminalItemView;
import edu.hucare.viewgroup.TerminalItemView_;

/**
 * Created by Kuzon on 8/7/2016.
 */
@EBean
public class TerminalAdapter extends BaseAdapter {

    List<TerminalDevice> devices;

    @Bean(TerminalImpl.class)
    TerminalImpl repository;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        devices = repository.findAll();
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public TerminalDevice getItem(int i) {
        return devices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TerminalItemView terminalItemView;
        if (view == null) {
            terminalItemView = TerminalItemView_.build(context);
        } else {
            terminalItemView = (TerminalItemView) view;
        }

        terminalItemView.bind(getItem(i));

        return terminalItemView;
    }
}
