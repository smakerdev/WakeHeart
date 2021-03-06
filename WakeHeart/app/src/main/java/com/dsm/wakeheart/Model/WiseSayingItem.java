package com.dsm.wakeheart.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by parktaeim on 2017. 9. 5..
 */

public class WiseSayingItem {

    @SerializedName("description")
    public String wiseSaying;
    public String author;

    public String getWiseSaying() {
        return wiseSaying;
    }

    public void setWiseSaying(String wiseSaying) {
        this.wiseSaying = wiseSaying;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public WiseSayingItem(String wiseSaying, String author) {
        this.wiseSaying = wiseSaying;
        this.author = author;
    }
}
