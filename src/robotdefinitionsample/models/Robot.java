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
    private Mission mission;
    private String name;
    private Shelf pickedUpshelf;

    public Robot(String name, Vector2 startpoint) {
        super();
        this.pos = startpoint;
        this.name = name;
    }
    
    public void setMission(Mission m) {
        this.mission = m;
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
    
    public Shelf getShelf() {
        return pickedUpshelf;
    }

    @Override
    public void execute(GridPane grid) {
        if (mission.isDone()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No more tasks");
            alert.setHeaderText("No more tasks");
            alert.setContentText("The robot \"" + getName() + "\" has no more tasks in its mission to execute.");
            alert.showAndWait();
        } else if (mission.getFailed()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Failed");
            alert.setHeaderText("The mission failed");
            alert.setContentText("The robot \"" + getName() + "\" execution failed");
            alert.showAndWait();
        } else {
            DesiredProps props = new DesiredProps(getPos(), (int)getRotate());
            mission.executeNext(props);
            if (!props.isDiscarded()) {
                setPos(props.getPos());
                setRotate(props.getRotation());
                if(ObstacleDetection.getShelfAtPos(grid, props) != null) {
                    if(ObstacleDetection.getShelfAtPos(grid, props).getName().equals(props.getShelfNameToPickUp())) {
                        if(pickedUpshelf == null) {
                            pickedUpshelf = ObstacleDetection.getShelfAtPos(grid, props);
                        }
                    }
                }
                if(pickedUpshelf != null){
                    pickedUpshelf.setPos(props.getPos());
                }
            }
        }
    }

    @Override
    public void move(GridPane grid) {
        grid.getChildren().remove(this);
        grid.add(this, this.getPos().getX(), this.getPos().getY());
    }
}
