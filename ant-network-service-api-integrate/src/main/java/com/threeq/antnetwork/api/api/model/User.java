package com.threeq.antnetwork.api.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Date 2017/5/4
 * @User three
 */
public class User {

    private String name;
    private String id;
    private LocalDate date;
    private LocalTime time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id)
                .append(", name: ").append(name)
                .append(", date: ").append(date)
                .append(", time: ").append(time)
                .append("}").toString();
    }

}
