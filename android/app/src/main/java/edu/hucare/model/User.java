package edu.hucare.model;

import java.util.Set;

/**
 * Created by Kuzon on 8/6/2016.
 */
public class User {

    private long id;

    private String email;

    private String name;

    private String password;

    private Set<ControlDevice> controlDevices;

    private Set<TerminalDevice> terminalDevices;

    private Set<Schedule> schedules;

    public User() {
    }

    public User(long id, String email, String name, String password, Set<ControlDevice> controlDevices, Set<TerminalDevice> terminalDevices, Set<Schedule> schedules) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.controlDevices = controlDevices;
        this.terminalDevices = terminalDevices;
        this.schedules = schedules;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ControlDevice> getControlDevices() {
        return controlDevices;
    }

    public void setControlDevices(Set<ControlDevice> controlDevices) {
        this.controlDevices = controlDevices;
    }

    public Set<TerminalDevice> getTerminalDevices() {
        return terminalDevices;
    }

    public void setTerminalDevices(Set<TerminalDevice> terminalDevices) {
        this.terminalDevices = terminalDevices;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", controlDevices=" + controlDevices +
                ", terminalDevices=" + terminalDevices +
                ", schedules=" + schedules +
                '}';
    }
}
