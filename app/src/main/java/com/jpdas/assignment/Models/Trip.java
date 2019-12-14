package com.jpdas.assignment.Models;

public class Trip
{
    private String from,to,currency,currency_symbol;
    private long from_time,to_time;
    private int value,trip_duration_min;

    public Trip(String from, String to, long from_time, long to_time, int trip_duration_min, int value, String currency, String currency_symbol) {
        this.from = from;
        this.to = to;
        this.from_time = from_time;
        this.to_time = to_time;
        this.trip_duration_min = trip_duration_min;
        this.value = value;
        this.currency = currency;
        this.currency_symbol = currency_symbol;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public long getFrom_time() {
        return from_time;
    }

    public void setFrom_time(long from_time) {
        this.from_time = from_time;
    }

    public long getTo_time() {
        return to_time;
    }

    public void setTo_time(long to_time) {
        this.to_time = to_time;
    }

    public int getTrip_duration_min() {
        return trip_duration_min;
    }

    public void setTrip_duration_min(int trip_duration_min) {
        this.trip_duration_min = trip_duration_min;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }
}
