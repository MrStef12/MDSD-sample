/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

/**
 *
 * @author ditlev
 */
public class Robot {
    private String name;
    private Vector2 startpoint;
    private Mission mission;

    public Robot(String name, Vector2 startpoint, Mission mission) {
        this.name = name;
        this.startpoint = startpoint;
        this.mission = mission;
    }

    public String getName() {
        return name;
    }

    public Vector2 getStartpoint() {
        return startpoint;
    }

    public Mission getMission() {
        return mission;
    }
    
    
}
