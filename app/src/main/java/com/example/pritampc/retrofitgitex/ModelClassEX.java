package com.example.pritampc.retrofitgitex;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pritamPC on 1/29/2018.
 */

public class ModelClassEX {

    @SerializedName("userId")
    String userid;

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;

    public String getUserid() {
        return userid;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
