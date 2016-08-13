package edu.hucare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Kuzon on 7/28/2016.
 */
@Entity
@Table(name = "terminal")
public class TerminalDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date lastContact;

    private String status;

    private String plant;

    private double moisture;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "terminal")
    private Set<Schedule> schedules;

    public TerminalDevice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
