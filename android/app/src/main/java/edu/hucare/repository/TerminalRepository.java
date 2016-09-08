package edu.hucare.repository;

import java.util.List;

import edu.hucare.model.TerminalDevice;

/**
 * Created by Kuzon on 8/8/2016.
 */
public interface TerminalRepository {

    List<TerminalDevice> findAll();

    TerminalDevice findOne();

}
