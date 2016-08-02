package edu.hucare.controller;

import edu.hucare.model.ControlDevice;
import edu.hucare.repository.ControlDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kuzon on 8/2/2016.
 */
@RestController
@RequestMapping("/control")
public class ControlDeviceController {

    @Autowired
    private ControlDeviceRepository repository;

    /**
     * Add a control
     * @param device
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDevice(ControlDevice device) {
        repository.save(device);
    }

    /**
     * Remove a control
     * @param device_id
     */
    @RequestMapping(value = "/remove/{device_id}", method = RequestMethod.DELETE)
    public void removeDevice(@PathVariable long device_id) {
        repository.delete(device_id);
    }

    /**
     * Update a control like rename
     * @param device
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void setStatus(@ModelAttribute ControlDevice device) {
        repository.save(device);
    }


}
