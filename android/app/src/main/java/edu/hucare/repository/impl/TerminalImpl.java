package edu.hucare.repository.impl;

import android.os.AsyncTask;

import org.androidannotations.annotations.EBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected TerminalDevice[] doInBackground(User... users) {
            try {

                final String url = "http://" + LoginActivity.host + "/user/" + users[0].getId() + "/terminal";

                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<TerminalDevice[]> terminalDevices = restTemplate.getForEntity(url, TerminalDevice[].class);
                terminals = terminalDevices.getBody();
                isSuccessful = true;
                return terminals;
            } catch (Exception e) {
                e.printStackTrace();
                isSuccessful = false;
            }
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
