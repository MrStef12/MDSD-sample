/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.exceptions.InvalidMove;
import robotdefinitionsample.ObstacleDetection;

/**
 *
 * @author ditlev
 */
public class Mission {
    private List<Task> mission;
    private int currentTask;
    private boolean done;
    
    public Mission() {
        mission = new ArrayList<>();
        currentTask = 0;
        done = false;
    }

    public boolean isDone() {
        return done;
    }
    
    public void addTask(Task t) {
        mission.add(t);
    }
    
    public void executeNext(GridPane grid, DesiredProps props) {
        Task t = mission.get(currentTask);
	try {
            t.executeNext(props);
            if (ObstacleDetection.detect(grid, props)) {
                props.setDiscarded(true);
                throw new InvalidMove();
            }
	} catch(InvalidMove e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid mode");
            alert.setHeaderText("Robot cannot execute task");
            alert.setContentText("The robot hit an invalid move");
            alert.showAndWait();
        }
        if (t.isDone()) {
            currentTask++;
        }
        if (currentTask == mission.size()) {
            done = true;
        }
    }
}
