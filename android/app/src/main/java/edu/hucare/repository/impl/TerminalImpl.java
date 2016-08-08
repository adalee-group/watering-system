package edu.hucare.repository.impl;

import org.androidannotations.annotations.EBean;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.hucare.model.TerminalDevice;
import edu.hucare.repository.TerminalRepository;

/**
 * Created by Kuzon on 8/8/2016.
 */
@EBean
public class TerminalImpl implements TerminalRepository {
    @Override
    public List<TerminalDevice> findAll() {
        TerminalDevice terminal = new TerminalDevice();
        terminal.setId(new Long(1));
        terminal.setLastContact(new Date());
        terminal.setStatus("OK");
        terminal.setPlant("梅花");
        terminal.setMoisture(0.8);

        List<TerminalDevice> devices = new LinkedList<>();
        devices.add(terminal);
        return devices;
    }
}
