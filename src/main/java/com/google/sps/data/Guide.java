package com.google.sps.data;

public class Guide {
    private final int id;
    private final String title;
    private final String description;
    private final String content;
    private final long timestamp;

    public Guide(int id, String title, String description, String content){
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }

    public Guide(int id, String title, String description, String content, long timestamp){
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}