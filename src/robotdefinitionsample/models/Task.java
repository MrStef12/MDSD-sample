/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.ArrayList;
import java.util.List;
import robotdefinitionsample.DesiredProps;

/**
 *
 * @author ditlev
 */
public class Task {
    private String name;
    private List<TaskItem> items;
    private int currentTask;
    private boolean done;
    
    public Task(String name) {
        this.name = name;
        items = new ArrayList<>();
        currentTask = 0;
        done = false;
    }
    
    public void addTask(TaskItem item) {
        items.add(item);
    }
    
    public boolean isDone() {
        return done;
    }
    
    public void executeNext(DesiredProps props) {
        TaskItem currentTaskItem = items.get(currentTask);
        
        currentTaskItem.executeCommand(props);
        if (currentTaskItem.isDone()) {
            currentTask++;
        }
        
        if (currentTask == items.size()) {
            done = true;
        }
    }
}
