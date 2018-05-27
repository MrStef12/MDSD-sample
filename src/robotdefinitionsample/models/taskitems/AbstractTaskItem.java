/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.taskitems;

import robotdefinitionsample.interfaces.TaskItem;

/**
 *
 * @author stefh
 */
public abstract class AbstractTaskItem implements TaskItem {
    
    private int steps;

    public AbstractTaskItem(int steps) {
        this.steps = steps;
    }
    
    public void stepDone() {
        this.steps--;
    }

    @Override
    public boolean isDone() {
        return this.steps < 1;
    }
}
