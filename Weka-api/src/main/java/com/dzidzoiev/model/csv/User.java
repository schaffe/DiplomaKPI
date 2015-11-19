package com.dzidzoiev.model.csv;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class User extends JsonSerializable {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
