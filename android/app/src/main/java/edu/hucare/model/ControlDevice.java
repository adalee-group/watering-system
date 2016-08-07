package edu.hucare.model;

import java.util.Set;

/**
 * Created by Kuzon on 8/6/2016.
 */
public class ControlDevice {

    private Long id;

    private String name;

    private User user;

    private Set<Schedule> schedules;

    public ControlDevice() {
    }

    public ControlDevice(Long id, String name, User user, Set<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ControlDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", schedules=" + schedules +
                '}';
    }
}
