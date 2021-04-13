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

    private static boolean emptyString(String str){
        return str.equals("");
    }

    private static boolean moreThan1500bytes(String str){
        if(str.getBytes().length > 1500) return true;
        return false;
    }

    private static void badParameterError(String parameter, String errorMsg){
        throw new Error("The following parameter " + errorMsg + ": " + parameter, 400);
    }

    public static void validate(Guide guide){
        String errorMsg = "cannot be empty";

        if(emptyString(guide.title))
            badParameterError("title", errorMsg);
        else if(emptyString(guide.description))
            badParameterError("description", errorMsg);
        else if(emptyString(guide.content))
            badParameterError("content", errorMsg);
        else if(emptyString(guide.category))
            badParameterError("category", errorMsg);

        errorMsg = "cannot be more than 1500 bytes";

        if(moreThan1500bytes(guide.title))
            badParameterError("title", errorMsg);
        else if(moreThan1500bytes(guide.description))
            badParameterError("description", errorMsg);
        else if(moreThan1500bytes(guide.category))
            badParameterError("category", errorMsg);
    }
}