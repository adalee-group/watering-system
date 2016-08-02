package edu.hucare.controller;

import edu.hucare.model.Schedule;
import edu.hucare.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kuzon on 8/2/2016.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repository;

    /**
     * Create schedule
     *
     * @param schedule
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addSchedule(@ModelAttribute Schedule schedule) {
        repository.save(schedule);
    }

    /**
     * Remove schedule
     *
     * @param schedule_id
     */
    @RequestMapping(value = "/remove/{schedule_id}", method = RequestMethod.DELETE)
    public void removeSchedule(@PathVariable long schedule_id) {
        repository.delete(schedule_id);
    }

    /**
     * Update schedule
     *
     * @param schedule
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateSchedule(@ModelAttribute Schedule schedule) {
        repository.save(schedule);
    }
}
