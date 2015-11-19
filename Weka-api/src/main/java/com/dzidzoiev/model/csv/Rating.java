package com.dzidzoiev.model.csv;

import java.util.function.Function;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class Rating extends JsonSerializable {
    Long userId;
    Long placeId;
    Float rating;
    Long timestamp;

    public Long getUserId() {
        return userId;
    }

    public Rating setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public Rating setPlaceId(Long placeId) {
        this.placeId = placeId;
        return this;
    }

    public Float getRating() {
        return rating;
    }

    public Rating setRating(Float rating) {
        this.rating = rating;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Rating setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public static Function<? super String[], Rating> getCSVMapper() {
        return (String[] s) -> new Rating()
                .setUserId(Long.parseLong(s[0]))
                .setPlaceId(Long.parseLong(s[1]))
                .setRating(Float.parseFloat(s[2]))
                .setTimestamp(Long.parseLong(s[3]));
    }
}
