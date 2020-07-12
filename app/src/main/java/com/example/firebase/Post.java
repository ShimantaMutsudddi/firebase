package com.example.firebase;

public class Post
{
    String title;
    String auther;
    String description;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", auther='" + auther + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
