package com.miracle.partyapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class PhResponse {
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("controlCode")
    @Expose
    private String controlCode;

    public PhResponse(String message, String time, String controlCode) {
        this.controlCode = controlCode;
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getControlCode() {
        return controlCode;
    }

    public void setControlCode(String controlCode) {
        this.controlCode = controlCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhResponse that = (PhResponse) o;
        return Objects.equals(message, that.message) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, time, controlCode);
    }
}
