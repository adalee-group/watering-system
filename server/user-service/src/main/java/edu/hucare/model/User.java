package edu.hucare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kuzon on 7/28/2016.
 */
@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String email;

    private String name;

    private String password;

    @OneToMany(mappedBy = "user")
    private Set<ControlDevice> controlDevices;

    @OneToMany(mappedBy = "user")
    private Set<TerminalDevice> terminalDevices;

    @OneToMany(mappedBy = "user")
    private Set<Schedule> schedules;

    public User() {
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

    @JsonIgnore
    public Set<ControlDevice> getControlDevices() {
        return controlDevices;
    }

    @JsonIgnore
    public void setControlDevices(Set<ControlDevice> controlDevices) {
        this.controlDevices = controlDevices;
    }

    @JsonIgnore
    public Set<TerminalDevice> getTerminalDevices() {
        return terminalDevices;
    }

    @JsonIgnore
    public void setTerminalDevices(Set<TerminalDevice> terminalDevices) {
        this.terminalDevices = terminalDevices;
    }

    @JsonIgnore
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    @JsonIgnore
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
