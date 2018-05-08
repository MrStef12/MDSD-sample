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
    
    public void addTask(TaskItem item) {
        items.add(item);
    }
    
    public boolean isDone() {
        return done;
    }
    
    public void executeNext(DesiredProps props) throws InvalidMove {
        TaskItem currentTaskItem = items.get(currentTask);
        if (!shouldRetry) {
            while(currentTaskItem.isDone()) {
                currentTask++;
                currentTaskItem = items.get(currentTask);
            }    
        } else {
            retries++;
            currentTaskItem.incrementTicksToGo();
            shouldRetry = false;
        }
        
        currentTaskItem.executeCommand(props);
        
        if (currentTask == items.size()) {
            done = true;
        }
    }
    
    public void setRetry(boolean b) {
        this.shouldRetry = b;
    }
    
    public int getRetries() {
        return retries;
    }
}
