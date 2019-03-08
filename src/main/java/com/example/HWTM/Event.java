package com.example.HWTM;

public class Event {
    private long event_id;
    private long user_id;
    private String host_name;
    private String type;
    private String event_time;
    private String event_date;
    private String event_address;
    private int numOfGuests;
    private int price;
    //private String[] totalGuests;
    private String description;
    private String url;

    public Event(){
    }

    public Event(long user_id, String host_name, String type, String event_time, String event_date, String event_address, String description, int numOfGuests, int price) {
        this.user_id = user_id;
        this.host_name = host_name;
        this.type = type;
        this.event_time = event_time;
        this.event_date = event_date;
        this.event_address = event_address;
        this.description = description;
        this.numOfGuests = numOfGuests;
        this.price = price;
        //this.totalGuests = totalGuests;
    }

    public Event(long event_id, long user_id, String host_name, String type, String event_time, String event_date, String event_address, String description, int numOfGuests, int price, String url) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.host_name = host_name;
        this.type = type;
        this.event_time = event_time;
        this.event_date = event_date;
        this.event_address = event_address;
        this.description = description;
        this.numOfGuests = numOfGuests;
        this.price = price;
        this.url = url;
        //this.totalGuests = totalGuests;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_address() {
        return event_address;
    }

    public void setEvent_address(String event_address) {
        this.event_address = event_address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
