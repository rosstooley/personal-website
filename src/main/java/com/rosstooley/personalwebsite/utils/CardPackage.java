package com.rosstooley.personalwebsite.utils;

import java.util.List;

public class CardPackage {
    private final String id;
    private final String title;
    private final List<StringPair> content;

    public CardPackage(String id, String title, List<StringPair> content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<StringPair> getContent() {
        return content;
    }
}
