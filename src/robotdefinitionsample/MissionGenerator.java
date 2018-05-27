/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.interfaces.ICondition;
import robotdefinitionsample.interfaces.ITaskFetcher;
import robotdefinitionsample.interfaces.TaskItem;
import robotdefinitionsample.interfaces.TriggerItem;
import robotdefinitionsample.models.Mission;
import robotdefinitionsample.models.Pickupable;
import robotdefinitionsample.models.Vector2;
import robotdefinitionsample.models.taskitems.*;
import robotdefinitionsample.models.triggerItems.*;

/**
 *
 * @author stefh
 */
public class MissionGenerator {
    public Mission Robot1(GridPane grid) {
        List<TaskItem> items = new ArrayList<>();
        List<TriggerItem> triggers = new ArrayList<>();
        
        items.add(new Forward(5));
        triggers.add(new WhenAtPickupable("Shelf1", new ITaskFetcher() {
            @Override
            public void addTasks(List<TaskItem> items) {
                items.add(new Pickup());
                items.add(new Condition(new ICondition() {
                    @Override
                    public boolean checkCondition(int retries, Pickupable shelf, Map<String, Integer> properties) {
                        return properties.get("Weight") > 10;
                    }
                }).setIfTaskItems(new ITaskFetcher() {
                    @Override
                    public void addTasks(List<TaskItem> items) {
                        items.add(new Turn(true));
                        items.add(new Turn(false));
                    }
                }).setElseTaskItems(new ITaskFetcher() {
                    @Override
                    public void addTasks(List<TaskItem> items) {
                        items.add(new Forward(1));
                        items.add(new Backward(1));
                    }
                }));
                items.add(new Turn(false));
                items.add(new Forward(1));
                items.add(new Setdown());
                items.add(new Backward(1));
                items.add(new Turn(true));
            }
        }));
        
        return new Mission(new LinkedList<>(items), new LinkedList<>(triggers));
    }
    
    public Mission Robot2(GridPane grid) {
        List<TaskItem> items = new ArrayList<>();
        List<TriggerItem> triggers = new ArrayList<>();
        
        items.add(new Forward(5));
        items.add(new Backward(2));
        triggers.add(new WhenAtPos(new Vector2(0,1), new ITaskFetcher() {
            @Override
            public void addTasks(List<TaskItem> items) {
                items.add(new WaitUntilPickupable("Shelf1", new Vector2(2, 1), 20, Constants.OR.CANCEL));
            }
        }));
        triggers.add(new WhenAtPickupable("Shelf1", new ITaskFetcher() {
            @Override
            public void addTasks(List<TaskItem> items) {
                items.add(new Pickup());
            }
        }));
        
        return new Mission(new LinkedList<>(items), new LinkedList<>(triggers));
    }
}
