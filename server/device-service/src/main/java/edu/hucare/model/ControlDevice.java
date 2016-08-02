package edu.hucare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kuzon on 7/28/2016.
 */
@Entity
@Table(name = "control")
public class ControlDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "control")
    private Set<Schedule> schedules;

    public ControlDevice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @JsonIgnore
    public void setUser(User user) {
        this.user = user;
    }

    @JsonIgnore
    public Set<Schedule> getSchedules() {
        return schedules;
    }

    @JsonIgnore
    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
