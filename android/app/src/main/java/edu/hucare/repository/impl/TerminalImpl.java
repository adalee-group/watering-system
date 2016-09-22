package edu.hucare.repository.impl;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import org.androidannotations.annotations.EBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.hucare.model.TerminalDevice;
import edu.hucare.model.User;
import edu.hucare.repository.TerminalRepository;
import edu.hucare.watering.LoginActivity;

/**
 * Created by Kuzon Chen on 8/8/2016.
 */
@EBean
public class TerminalImpl implements TerminalRepository {

    private static final int LOAD_SUCCESS = 0x1;

    private static class TerminalHandler extends Handler {
        private final WeakReference<GetAllDevices> weakReference;

        public TerminalHandler(GetAllDevices context) {
            weakReference = new WeakReference<GetAllDevices>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            GetAllDevices terminal = weakReference.get();
            if (terminal != null) {
                switch (msg.what) {

                }
            }
        }
    }

    // All devices
    TerminalDevice terminals[];

    // One devices
    TerminalDevice device;

    @Override
    public List<TerminalDevice> findAll() {

        new GetAllDevices().execute(LoginActivity.user);

        try {
            Thread.sleep(3000);
            List<TerminalDevice> devices = new LinkedList<>();

            for (TerminalDevice device : terminals) {
                devices.add(device);
            }

            return devices;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TerminalDevice findOne() {
        return null;
    }

    /**
     * Get all devices by RESTFul API
     *
     * @author Kuzon Chen
     */
    class GetAllDevices extends AsyncTask<User, User, TerminalDevice[]> {

        private final TerminalHandler handler = new TerminalHandler(this);

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected TerminalDevice[] doInBackground(User... users) {

            final String url = "http://" + LoginActivity.host + "/user/" + users[0].getId() + "/terminal";

            new Thread(new Runnable() {
                @Override
                public void run() {

                    RestTemplate restTemplate = new RestTemplate();

                    ResponseEntity<TerminalDevice[]> terminalDevices = restTemplate.getForEntity(url, TerminalDevice[].class);
                    terminals = terminalDevices.getBody();
                    Message msg = handler.obtainMessage(LOAD_SUCCESS, terminals);
                    handler.sendMessage(msg);
                }
            });

//            try {
//
//                final String url = "http://" + LoginActivity.host + "/user/" + users[0].getId() + "/terminal";
//
//                RestTemplate restTemplate = new RestTemplate();
//
//                ResponseEntity<TerminalDevice[]> terminalDevices = restTemplate.getForEntity(url, TerminalDevice[].class);
//                terminals = terminalDevices.getBody();
//                isSuccessful = true;
//                return terminals;
//            } catch (Exception e) {
//                e.printStackTrace();
//                isSuccessful = false;
//            }
            return null;
        }
    }

    /**
     * Get One Device by RESTFul API
     *
     * @author Kuzon Chen
     */
    class GetOneDevice extends AsyncTask<TerminalDevice, TerminalDevice, TerminalDevice> {

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected TerminalDevice doInBackground(TerminalDevice... devices) {
            try {

                final String url = "http://" + LoginActivity.host + "/device/" + devices[0].getId() + "/status";

                RestTemplate restTemplate = new RestTemplate();

                device = restTemplate.getForObject(url, TerminalDevice.class);
                isSuccessful = true;
                return device;
            } catch (Exception e) {
                e.printStackTrace();
                isSuccessful = false;
            }
            return null;
        }
    }
}
