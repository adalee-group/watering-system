package edu.hucare.model;

import java.util.Date;
import java.util.Set;

/**
 * Created by Kuzon on 8/6/2016.
 */
public class TerminalDevice {

    private Long id;

    private Date lastContact;

    private String status;

    private String plant;

    private double moisture;

    private User user;

    private Set<Schedule> schedules;

    public TerminalDevice() {
    }

    public TerminalDevice(Long id, Date lastContact, String status, String plant, double moisture, User user, Set<Schedule> schedules) {
        this.id = id;
        this.lastContact = lastContact;
        this.status = status;
        this.plant = plant;
        this.moisture = moisture;
        this.user = user;
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastContact() {
        return lastContact;
    }

    public void setLastContact(Date lastContact) {
        this.lastContact = lastContact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public double getMoisture() {
        return moisture;
    }

    public void setMoisture(double moisture) {
        this.moisture = moisture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "TerminalDevice{" +
                "id=" + id +
                ", lastContact=" + lastContact +
                ", status='" + status + '\'' +
                ", plant='" + plant + '\'' +
                ", moisture=" + moisture +
                ", user=" + user +
                ", schedules=" + schedules +
                '}';
    }
}
