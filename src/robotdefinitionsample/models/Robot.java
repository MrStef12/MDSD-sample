/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.DesiredProps;

/**
 *
 * @author ditlev
 */
public class Robot extends Label {
    private Vector2 pos;
    private Mission mission;

    public Robot(String name, Vector2 startpoint) {
        super(name);
        this.pos = startpoint;
    }
    
    public void setMission(Mission m) {
        this.mission = m;
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
    
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }
    
    public void execute(GridPane grid) {
        if (mission.isDone()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No more tasks");
            alert.setHeaderText("No more tasks");
            alert.setContentText("The robot \"" + getName() + "\" has no more tasks in its mission to execute.");
            alert.showAndWait();
        } else {
            DesiredProps props = new DesiredProps(getPos(), (int)getRotate());
            mission.executeNext(props);
            setPos(props.getPos());
            setRotate(props.getRotation());
        }
    }
}
