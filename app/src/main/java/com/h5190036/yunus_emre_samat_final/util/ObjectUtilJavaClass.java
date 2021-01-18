package com.h5190036.yunus_emre_samat_final.util;

import com.google.gson.Gson;
import com.h5190036.yunus_emre_samat_final.model.MarkaModelJavaClass;

public class ObjectUtilJavaClass {

    public  static String markaToJsonString(MarkaModelJavaClass markaModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(markaModel);
    }

    public  static MarkaModelJavaClass jsonStringToMarka(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString, MarkaModelJavaClass.class);
    }
}