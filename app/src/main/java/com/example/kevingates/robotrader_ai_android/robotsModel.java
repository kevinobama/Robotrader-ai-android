package com.example.kevingates.robotrader_ai_android;

/**
 * Created by kevingates on 11/28/17.
 */
import java.util.ArrayList;

public class robotsModel {

    //declare private data instead of public to ensure the privacy of data field of each class
    private String name;
//    private String country;
//    private String buy;
//    private String sell;

    public robotsModel(String name) {
        this.name = name;
//        this.country = country;
//        this.buy = buy;
//        this.sell = sell;
    }

    public String getName(){
        return name;
    }

}
