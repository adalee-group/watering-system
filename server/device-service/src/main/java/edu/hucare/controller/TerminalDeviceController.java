package edu.hucare.controller;

import edu.hucare.model.Schedule;
import edu.hucare.model.TerminalDevice;
import edu.hucare.repository.TerminalDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by Kuzon on 8/2/2016.
 */
@RestController
//@RequestMapping("/terminal")
public class TerminalDeviceController {

    @Autowired
    private TerminalDeviceRepository repository;

    /**
     * Add a terminal
     *
     * @param device
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDevice(TerminalDevice device) {
        repository.save(device);
    }

    /**
     * Remove a terminal
     *
     * @param device_id
     */
    @RequestMapping(value = "/remove/{device_id}", method = RequestMethod.DELETE)
    public void removeDevice(@PathVariable long device_id) {
        repository.delete(device_id);
    }

    /**
     * Get device status
     *
     * @param device_id
     */
    @RequestMapping(value = "/{device_id}/status", method = RequestMethod.GET)
    public TerminalDevice getStatus(@PathVariable long device_id) {
        return repository.findOne(device_id);
    }

    /**
     * Terminal status report
     *
     * @param device
     */
    @RequestMapping(value = "/status", method = RequestMethod.PUT)
    public void setStatus(@ModelAttribute TerminalDevice device) {
        repository.save(device);
    }

    @RequestMapping(value = "/{device_id}/schedule", method = RequestMethod.GET)
    public Set<Schedule> getSchedule(@PathVariable long device_id) {
        TerminalDevice device = repository.findOne(device_id);
        return device.getSchedules();
    }
}
