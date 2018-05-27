/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models.taskitems;

import java.util.ArrayList;
import java.util.List;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.interfaces.ICondition;
import robotdefinitionsample.models.Pickupable;
import robotdefinitionsample.interfaces.TaskItem;
import robotdefinitionsample.interfaces.ITaskFetcher;

/**
 *
 * @author stefh
 */
public class Condition extends AbstractTaskItem {
    
    private ICondition condition;
    private List<TaskItem> ifTasks;
    private List<TaskItem> elseTasks;

    public Condition() {
        super(1);
        this.ifTasks = new ArrayList<>();
        this.elseTasks = new ArrayList<>();
    }
    
    public Condition setIfTaskItems(ITaskFetcher tasks) {
        tasks.addTasks(ifTasks);
        return this;
    }
    
    public Condition setElseTaskItems(ITaskFetcher tasks) {
        tasks.addTasks(elseTasks);
        return this;
    }

    @Override
    public void execute(DesiredProps props) {
        Pickupable pickedUp = props.getRobot().getPickedUp();
        if (condition.checkCondition(
                props.getRobot().getMission().getRetries(),
                pickedUp,
                pickedUp != null ? pickedUp.getShelfProperties() : null
        )) {
            props.addItemsToAdd(ifTasks);
        } else {
            props.addItemsToAdd(elseTasks);
        }
        stepDone();
    }
    
}
