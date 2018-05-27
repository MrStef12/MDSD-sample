/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.triggerItems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.interfaces.ITaskFetcher;
import robotdefinitionsample.interfaces.TaskItem;
import robotdefinitionsample.interfaces.TriggerItem;
import robotdefinitionsample.models.taskitems.Constants;

/**
 *
 * @author stefh
 */
public abstract class WhenAt implements TriggerItem {
    
    private LinkedList<TaskItem> taskQueue;

    public WhenAt(ITaskFetcher fetcher) {
        List<TaskItem> items = new ArrayList<>();
        fetcher.addTasks(items);
        this.taskQueue = new LinkedList<>(items);
    }
    
    @Override
    public void execute(DesiredProps props) {
        if(!taskQueue.isEmpty()) {
            if (!taskQueue.peek().isDone()) {
                taskQueue.peek().execute(props);
            }
            if (taskQueue.peek().isDone()) {
                taskQueue.pop();
            }
        }
        if (props.getWaitOr() == Constants.OR.CANCEL) {
            taskQueue.clear();
        }
        if (!props.getItemsToAdd().isEmpty()) {
            taskQueue.addAll(0, props.getItemsToAdd());
            props.getItemsToAdd().clear();
        }
    }

    @Override
    public boolean isTriggered(DesiredProps props) {
        return isAtDestination(props) && !taskQueue.isEmpty();
    }
    
    @Override
    public boolean isDone() {
        return taskQueue.isEmpty();
    }
    
    public abstract boolean isAtDestination(DesiredProps props);
}
