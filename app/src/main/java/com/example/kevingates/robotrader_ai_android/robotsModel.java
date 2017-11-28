package com.example.kevingates.robotrader_ai_android;

/**
 * Created by kevingates on 11/28/17.
 */
import java.util.ArrayList;

public class robotsModel {

    //declare private data instead of public to ensure the privacy of data field of each class
    private String id;
    private String name;
    private String robot_type;

    public robotsModel(String id,String name,String robot_type) {
        this.id = id;
        this.name = name;
        this.robot_type = robot_type;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getRobotType(){
        return robot_type;
    }

}
