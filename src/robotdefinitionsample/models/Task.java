/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.ArrayList;
import java.util.List;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.exceptions.InvalidMove;
import robotdefinitionsample.exceptions.NoShelfPickedUp;

/**
 *
 * @author ditlev
 */
public class Task {
    private String name;
    private List<TaskItem> items;
    private int currentTask;
    private boolean done;
    private int retries;
    private boolean shouldRetry;
    
    public Task(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.currentTask = 0;
        this.done = false;
        this.retries = 0;
        this.shouldRetry = false;
    }
    
    //anonymously task comes generaly from a TaskItem
    public Task() {
        this.items = new ArrayList<>();
        this.currentTask = 0;
        this.done = false;
        this.retries = 0;
        this.shouldRetry = false;
    }
    
    public Task add(TaskItem item) {
        items.add(item);
        return this;
    }
    
    public boolean isDone() {
        return done;
    }
    
    public void executeNext(DesiredProps props) throws InvalidMove, NoShelfPickedUp, Exception {
        TaskItem currentTaskItem = items.get(currentTask);
        if (!shouldRetry) {
            while(currentTaskItem.isDone() && currentTask < items.size() - 1) {
                currentTask++;
                currentTaskItem = items.get(currentTask);
            }    
        } else {
            retries++;
            currentTaskItem.incrementTicksToGo();
            shouldRetry = false;
        }
        
        currentTaskItem.executeCommand(props);
        
        if (currentTask == items.size() - 1) {
            done = true;
        }
    }
    
    public void setRetry(boolean b) {
        this.shouldRetry = b;
    }
    
    public int getRetries() {
        return retries;
    }

    void addTaskAtCurrent(TaskItem t) {
        items.add(currentTask + 1, t);
    }
}
