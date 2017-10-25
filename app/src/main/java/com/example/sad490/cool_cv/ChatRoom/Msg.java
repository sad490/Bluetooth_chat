package com.example.sad490.cool_cv.ChatRoom;

/**
 * Created by sad490 on 17-9-29.
 */

public class Msg {
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;

    private int type;

    public Msg(String content, int type){
        this.content = content;
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public String getContent(){
        return this.content;
    }
}
