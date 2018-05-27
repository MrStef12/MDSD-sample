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
import robotdefinitionsample.ObstacleDetection;
import robotdefinitionsample.interfaces.IMoveable;

/**
 *
 * @author ditlev
 */
public class Robot extends Label implements IMoveable {
    private Vector2 pos;
    private String name;
    private Pickupable pickedUp;
    private Mission mission;
    
    public Robot(String name, Vector2 startpoint, Mission mission) {
        super();
        this.pos = startpoint;
        this.name = name;
        this.mission = mission;
    }

    public String getName() {
        return name;
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
    
    public Pickupable getPickedUp() {
        return pickedUp;
    }

    @Override
    public void execute(GridPane grid) {
        if (!mission.isDone()) {
            DesiredProps props = new DesiredProps(this, grid, getPos(), (int)getRotate());
            mission.executeNext(grid, props);
            if (!props.isDiscarded()) {
                setPos(props.getPos());
                setRotate(props.getRotation());
                if (props.shouldPickUp()) {
                    pickedUp = ObstacleDetection.getShelfAtPos(grid, props);
                } else if (props.shouldSetDown()) {
                    pickedUp = null;
                }
                if(pickedUp != null){
                    pickedUp.setPos(props.getPos());
                }
            }
        }
        if (mission.isDone()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No more tasks");
            alert.setHeaderText("No more tasks");
            alert.setContentText("The robot \"" + getName() + "\" has no more tasks in its mission to execute.");
            alert.showAndWait();
        }
    }

    @Override
    public void move(GridPane grid) {
        grid.getChildren().remove(this);
        grid.add(this, this.getPos().getX(), this.getPos().getY());
    }
}
