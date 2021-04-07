package com.google.sps.data;

public class Guide {
    private final long id;
    private final String title;
    private final String description;
    private final String content;
    private final String category;
    private final long timestamp;

    public Guide(String title, String description, String content, String category){
        this.id = -1;
        this.title = title;
        this.description = description;
        this.content = content;
        this.category = category;
        this.timestamp = System.currentTimeMillis();
    }

    public Guide(long id, String title, String description, String content, String category, long timestamp){
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.category = category;
        this.timestamp = timestamp;
    }

    public long getId() {
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

    public String getCategory() {
        return category;
    }

    public long getTimestamp() {
        return timestamp;
    }
}