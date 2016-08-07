package edu.hucare.model;

import java.util.Date;

/**
 * Created by Kuzon on 8/6/2016.
 */
public class Schedule {

    private Long id;

    private Date date;

    private double water;

    private String status;

    private TerminalDevice terminal;

    private ControlDevice control;

    public Schedule() {
    }

    public Schedule(Long id, Date date, double water, String status, TerminalDevice terminal, ControlDevice control) {
        this.id = id;
        this.date = date;
        this.water = water;
        this.status = status;
        this.terminal = terminal;
        this.control = control;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public TerminalDevice getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalDevice terminal) {
        this.terminal = terminal;
    }

    public ControlDevice getControl() {
        return control;
    }

    public void setControl(ControlDevice control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date=" + date +
                ", water=" + water +
                ", status='" + status + '\'' +
                ", terminal=" + terminal +
                ", control=" + control +
                '}';
    }
}
