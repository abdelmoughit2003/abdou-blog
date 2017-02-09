package com.codeup.models;

/**
 * Created by abdelmoughit on 2/8/2017.
 */
public class Post{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
    public String title;
    public String body;


    public Post(String title,String body) {
        this.title=title;
        this.body=body;
    }
    public Post() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



}
