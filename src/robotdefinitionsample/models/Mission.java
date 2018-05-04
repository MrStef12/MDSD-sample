/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.List;

/**
 *
 * @author ditlev
 */
public class Mission {
    private List<Task> mission;
    private int currentTask;
    
    public Mission() {
        currentTask = 0;
    }
    
    public Task getNextTask() {
        Task t = mission.get(currentTask);
        currentTask++;
        return t;
    }
    
}
