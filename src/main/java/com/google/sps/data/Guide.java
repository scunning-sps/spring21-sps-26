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
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }
}