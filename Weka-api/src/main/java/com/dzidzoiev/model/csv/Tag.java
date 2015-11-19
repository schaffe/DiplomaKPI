package com.dzidzoiev.model.csv;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class Tag extends JsonSerializable {
    Long userId;
    Long placeId;
    String tag;
    Long timestamp;

    public Long getUserId() {
        return userId;
    }

    public Tag setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public Tag setPlaceId(Long placeId) {
        this.placeId = placeId;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Tag setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Tag setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
