package edu.hucare.repository;

import edu.hucare.model.TerminalDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Kuzon on 8/2/2016.
 */
@Repository
public interface TerminalDeviceRepository extends CrudRepository<TerminalDevice, Long> {
}
