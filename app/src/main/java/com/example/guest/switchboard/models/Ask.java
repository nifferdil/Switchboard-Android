package com.example.guest.switchboard.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Guest on 10/27/15.
 */
@Table(name = "ask", id = "_id")
public class Ask extends Model {

    @Column(name = "Content")
    private String mContent;


    public Ask() {
        super();
    }

    public Ask(String content) {
        mContent = content;

    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public static List<Ask> all() {
        return new Select()
                .from(Ask.class)
                .execute();
    }
}