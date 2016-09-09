package edu.hucare.repository.impl;

import android.os.AsyncTask;

import org.androidannotations.annotations.EBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

import edu.hucare.model.Schedule;
import edu.hucare.model.TerminalDevice;
import edu.hucare.model.User;
import edu.hucare.repository.ScheduleRepository;
import edu.hucare.watering.LoginActivity;

/**
 * Created by kuzon on 16-9-8.
 */
@EBean
public class ScheduleImpl implements ScheduleRepository {

    private Schedule[] allSchedules;

    @Override
    public List<Schedule> findAll(TerminalDevice terminal) {
        try {

            GetAllDevices devices = new GetAllDevices();
            devices.execute(terminal);

            long time_out = 5000;
            long time_count = 0;

            while (!devices.isSuccessful()) {
                if (time_count > time_count) {
                    throw new Exception();
                }
                Thread.sleep(500);
                time_count += 500;
            }

            if (devices.isSuccessful()) {
                List<Schedule> schedules = new LinkedList<Schedule>();
                for (Schedule schedule : allSchedules) {
                    schedules.add(schedule);
                }
                return schedules;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class GetAllDevices extends AsyncTask<TerminalDevice, Void, Void> {

        private boolean isSuccessful = false;

        public boolean isSuccessful() {
            return isSuccessful;
        }

        protected Void doInBackground(TerminalDevice... devices) {
            try {

                final String url = "http://" + LoginActivity.host + "/device/" + devices[0].getId() + "/schedule";

                RestTemplate restTemplate = new RestTemplate();

                ResponseEntity<Schedule[]> schedules = restTemplate.getForEntity(url, Schedule[].class);
                allSchedules = schedules.getBody();
                isSuccessful = true;
            } catch (Exception e) {
                e.printStackTrace();
                isSuccessful = false;
            }
            return null;
        }
    }
}
