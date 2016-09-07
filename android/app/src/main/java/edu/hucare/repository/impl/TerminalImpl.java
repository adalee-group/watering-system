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
 * Created by Kuzon on 8/8/2016.
 */
@EBean
public class TerminalImpl implements TerminalRepository {

    TerminalDevice terminals[];

    @Override
    public List<TerminalDevice> findAll() {

        new GetDevices().execute(LoginActivity.user);

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


//        TerminalDevice terminal = new TerminalDevice();
//        terminal.setId(new Long(1));
//        terminal.setLastContact(new Date());
//        terminal.setStatus("OK");
//        terminal.setPlant("梅花");
//        terminal.setMoisture(0.8);
//
//        devices.add(terminal);
        return null;
    }

    class GetDevices extends AsyncTask<User, User, TerminalDevice[]> {

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected TerminalDevice[] doInBackground(User... users) {
            try {

                final String url = "http://192.168.10.108:1984/user/m" + users[0].getId() + "/terminal";

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


        protected void onPostExecute(String file_url) {
        }
    }
}
