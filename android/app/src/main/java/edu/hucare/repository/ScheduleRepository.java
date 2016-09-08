package edu.hucare.repository;

import java.util.List;

import edu.hucare.model.Schedule;
import edu.hucare.model.TerminalDevice;

/**
 * Created by kuzon on 16-9-8.
 */
public interface ScheduleRepository {

    List<Schedule> findAll(TerminalDevice terminal);

}
