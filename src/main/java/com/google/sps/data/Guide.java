package com.google.sps.data;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Guide {
    private final long id;
    private final String title;
    private final String description;
    private final String content;
    private final String category;
    private final long timestamp;

    public Guide(String title, String description, String content, String category){
        this.id = -1;

        if(!validIndexedString(title))
            throw new IllegalArgumentException("Invalid title");
        this.title = Jsoup.clean(title, Whitelist.none());

        if(!validIndexedString(description))
            throw new IllegalArgumentException("Invalid description");
        this.description = Jsoup.clean(description, Whitelist.none());

        if(!validUnindexedString(content))
            throw new IllegalArgumentException("Invalid content");
        this.content = Jsoup.clean(content, Whitelist.none());

        if(!validIndexedString(category))
            throw new IllegalArgumentException("Invalid category");
        this.category = Jsoup.clean(category, Whitelist.none());

        this.timestamp = System.currentTimeMillis();
    }

    public Guide(long id, String title, String description, String content, String category, long timestamp){
        this.id = id;

        if(!validIndexedString(title))
            throw new IllegalArgumentException("Invalid title");
        this.title = Jsoup.clean(title, Whitelist.none());

        if(!validIndexedString(description))
            throw new IllegalArgumentException("Invalid description");
        this.description = Jsoup.clean(description, Whitelist.none());

        if(!validUnindexedString(content))
            throw new IllegalArgumentException("Invalid content");
        this.content = Jsoup.clean(content, Whitelist.none());

        if(!validIndexedString(category))
            throw new IllegalArgumentException("Invalid category");
        this.category = Jsoup.clean(category, Whitelist.none());

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

    private boolean nullOrEmptyString(String str){
        if(str == null) return true;
        if(str.equals("")) return true;
        return false;
    }

    private boolean smallerThan1500bytes(String str){
        if(title.getBytes().length > 1500) return false;
        return true;
    }

    private boolean validIndexedString(String str){
        if(nullOrEmptyString(str) && smallerThan1500bytes(str)) return false;
        return true;
    }

    private boolean validUnindexedString(String str){
        if(nullOrEmptyString(str)) return false;
        return true;
    }
}