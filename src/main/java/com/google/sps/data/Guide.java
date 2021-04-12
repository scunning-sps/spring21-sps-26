package com.google.sps.data;

public class Guide {
    private final long id;
    private final String title;
    private final String description;
    private final String content;
    private final String category;
    private final long timestamp;
    private Error error = null;

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

    public Error getError(){
        return error;
    }

    private boolean emptyString(String str){
        if(str.equals("")) return true;
        return false;
    }

    private boolean moreThan1500bytes(String str){
        if(title.getBytes().length > 1500) return true;
        return false;
    }

    public boolean isInvalid(){
        String errorMsg = "The following parameter cannot be empty: ";
        String parameter = null;

        if(emptyString(title))
            parameter = "title";
        else if(emptyString(description))
            parameter = "description";
        else if(emptyString(content))
            parameter = "content";
        else if(emptyString(category))
            parameter = "category";

        if(parameter != null){
            this.error = new Error(errorMsg + parameter, 400);
            return true;
        }

        errorMsg = "The following parameter cannot be more than 1500 bytes: ";

        if(moreThan1500bytes(title))
            parameter = "title";
        else if(moreThan1500bytes(description))
            parameter = "description";
        else if(moreThan1500bytes(category))
            parameter = "category";

        if(parameter != null){
            this.error = new Error(errorMsg + parameter, 400);
            return true;
        }


        return false;
    }
}