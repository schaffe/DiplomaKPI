package com.dzidzoiev.model.csv;

import java.util.function.Function;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class Place extends JsonSerializable {
    private Long placeId;
    private String name;
    private String attributes;

    public Long getPlaceId() {
        return placeId;
    }

    public Place setPlaceId(Long placeId) {
        this.placeId = placeId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Place setName(String name) {
        this.name = name;
        return this;
    }

    public String getAttributes() {
        return attributes;
    }

    public Place setAttributes(String attributes) {
        this.attributes = attributes;
        return this;
    }

    public static Function<? super String[], Place> getCSVMapper() {
        return (String[] s) -> new Place()
                .setPlaceId(Long.parseLong(s[0]))
                .setName(s[1])
                .setAttributes(s[2]);
    }
}
