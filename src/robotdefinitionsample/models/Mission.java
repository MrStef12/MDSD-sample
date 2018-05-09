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
import robotdefinitionsample.exceptions.NoShelfPickedUp;
import robotdefinitionsample.exceptions.PropertyNotSet;

/**
 *
 * @author ditlev
 */
public class Mission {
    private List<Task> mission;
    private int currentTask;
    private boolean done;
    private boolean failed;
    private GridPane grid;
    
    public Mission(GridPane grid) {
        mission = new ArrayList<>();
        currentTask = 0;
        done = false;
        failed = false;
        this.grid = grid;
    }
    
    public boolean isDone() {
        return done;
    }
    
    public void addTask(Task t) {
        mission.add(t);
    }
    
    public void addTaskAtCurrent(TaskItem t) {
        mission.get(currentTask).addTaskAtCurrent(t);
    }
    
    public void executeNext(DesiredProps props) {
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
            
            if (t.getRetries() < 3) {
                t.setRetry(true);
            } else {
                missionFailed();
            }
            
        } catch(NoShelfPickedUp e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No shelf");
            alert.setHeaderText("Robot cannot execute task");
            alert.setContentText("The robot did not have a shelf picked up");
            alert.showAndWait();
        } catch (PropertyNotSet e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid mode");
            alert.setHeaderText("Robot cannot execute task");
            alert.setContentText("The robot did not find the property");
            alert.showAndWait();
        } catch (Exception e) {
            
        }
        
        if (t.isDone()) {
            currentTask++;
        }
        if (currentTask == mission.size()) {
            done = true;
        }
    }

    private void missionFailed() {
        failed = true;
    }
    
    public boolean getFailed() {
        return failed;
    }
    
    //Called from TaskItem conditionAt()
    public boolean collision(String shelfName, DesiredProps props) {
        Shelf s = ObstacleDetection.getShelfAtPos(grid, props);
        if (s != null) {
            if (s.getName().equals(shelfName)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
