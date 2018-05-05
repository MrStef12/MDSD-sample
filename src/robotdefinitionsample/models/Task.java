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
public class Task {
    private String name;
    private List<TaskItem> items;
    
    public Task(String name) {
        this.name = name;
        items = new ArrayList<>();
    }
    
    public void addTask(TaskItem item) {
        items.add(item);
    }
}
