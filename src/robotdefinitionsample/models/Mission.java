/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ditlev
 */
public class Mission {
    private List<Task> mission;
    private int currentTask;
    
    public Mission() {
        mission = new ArrayList<>();
        currentTask = 0;
    }
    
    public void addTask(Task t) {
        mission.add(t);
    }
    
    public Task getNextTask() {
        Task t = mission.get(currentTask);
        if (t.done()) {
            currentTask++;
        }
        return t;
    }
    
}
