/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import robotdefinitionsample.interfaces.TaskItem;
import java.util.LinkedList;
import java.util.List;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.interfaces.TriggerItem;

/**
 *
 * @author stefh
 */
public class Mission {
    private boolean done;
    private LinkedList<TriggerItem> triggerQueue;
    private LinkedList<TaskItem> taskQueue;
    private List<TriggerItem> triggerList;
    private int retries;

    public Mission(LinkedList<TaskItem> taskQueue, List<TriggerItem> triggerList) {
        this.done = false;
        this.triggerQueue = new LinkedList<>();
        this.taskQueue = taskQueue;
        this.triggerList = triggerList;
        this.retries = 0;
    }
    
    public void executeNext(GridPane grid, DesiredProps props) {
        for (TriggerItem ti : triggerList) {
            if (ti.isTriggered(props) && !triggerQueue.contains(ti)) {
                triggerQueue.push(ti);
                break;
            }
        }
        if (taskQueue.isEmpty() || (!taskQueue.isEmpty() && taskQueue.peek().isDone())) {
            if (taskQueue.size() > 1) {
                taskQueue.pop();
            } else {
                this.done = true;
                return;
            }
        }
        
        if (!triggerQueue.isEmpty()) {
            TriggerItem item = triggerQueue.peek();
            item.execute(props);
            if (item.isDone()) triggerQueue.pop();
        } else {
            taskQueue.peek().execute(props);
        }
        if (!props.getItemsToAdd().isEmpty()) {
            taskQueue.addAll(props.getItemsToAdd());
            props.getItemsToAdd().clear();
        }
    }

    public boolean isDone() {
        return done;
    }

    public int getRetries() {
        return retries;
    }
    
    
}
