/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import javafx.scene.control.Label;

/**
 *
 * @author ditlev
 */
public class Robot extends Label {
    private Vector2 pos;
    private Mission mission;

    public Robot(String name, Vector2 startpoint, Mission mission) {
        super(name);
        this.pos = startpoint;
        this.mission = mission;
    }

    public String getName() {
        return this.getText();
    }
    
    public Vector2 getPos() {
        return pos;
    }

    public Mission getMission() {
        return mission;
    }
    
    public void execute() {
        Task t = mission.getNextTask();
        
    }
}
