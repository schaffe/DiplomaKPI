package com.dzidzoiev.model.csv;

import com.dzidzoiev.utils.Json;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public abstract class JsonSerializable {
    @Override
    public String toString() {
        return Json.toJson(this);
    }
}
