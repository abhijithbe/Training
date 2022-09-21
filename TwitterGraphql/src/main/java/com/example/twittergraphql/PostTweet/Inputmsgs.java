package com.example.twittergraphql.PostTweet;
/**
 * return type class
 * @author abhijith.be
 */
public class Inputmsgs {
    private String msg;
    public String getMsg() {
        if (msg==null){
            return "success";
        }
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
