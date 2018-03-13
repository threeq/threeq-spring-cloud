package me.threeq.boot.reactive.model;

import java.io.Serializable;

/**
 * @Date 2017/4/22
 * @User three
 */
public abstract class Entity<T> implements Serializable {
    private T id;
    private String name;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
