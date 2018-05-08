/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.exceptions.InvalidMove;

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
    
    public void executeNext(DesiredProps props) {
        Task t = mission.get(currentTask);
        try {
            t.executeNext(props);
        } catch(InvalidMove e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No more tasks");
            alert.setHeaderText("No more tasks");
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
