package edu.hucare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kuzon on 7/28/2016.
 */
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date date;

    private double water;

    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private TerminalDevice terminal;

    @ManyToOne
    private ControlDevice control;

    public Schedule() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public TerminalDevice getTerminal() {
        return terminal;
    }

    @JsonIgnore
    public void setTerminal(TerminalDevice terminal) {
        this.terminal = terminal;
    }

    @JsonIgnore
    public ControlDevice getControl() {
        return control;
    }

    @JsonIgnore
    public void setControl(ControlDevice control) {
        this.control = control;
    }
}
