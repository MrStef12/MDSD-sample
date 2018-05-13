/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import robotdefinitionsample.interfaces.ICondition;
import robotdefinitionsample.interfaces.IConditionTasks;
import java.util.ArrayList;
import java.util.List;
import robotdefinitionsample.DesiredProps;
import robotdefinitionsample.exceptions.InvalidMove;
import robotdefinitionsample.exceptions.NoShelfPickedUp;

/**
 *
 * @author ditlev
 */
public class TaskItem {
    
    //Direction values
    private final int right = 0;
    private final int up = 270;
    private final int left = 180;
    private final int down = 90;
    
    private Robot robot;
    private ActionCondition ac;
    private boolean done;
    private int ticksToGo;
    private String atShelfName;
    private String shelfToPickUp;
    private ICondition conditionChecker;
    private List<TaskItem> ifTaskItems;
    private List<TaskItem> elseTaskItems;
    
    public TaskItem(Robot robot, ActionCondition ac) {
        this.robot = robot;
        this.ac = ac;
        this.done = false;
        this.ticksToGo = 1;
    }
    
    public ActionCondition getAction() {
        return ac;
    }
    
    public void executeCommand(DesiredProps props) throws NoShelfPickedUp, InvalidMove, Exception {
        //Maybe some general code can be done here.
        
        switch (ac) {
            case FORWARD:
                forward(props);
                break;
            case TURN_CW:
                turnCW(props);
                break;
            case TURN_CCW:
                turnCCW(props);
                break;
            case BACKWARD:
                backward(props);
                break;
            case CONDITION:
                condition(props);
                break;
            case CONDITIONAT:
                conditionAt(props);
                break;
            case PICKUP:
                pickUp(props);
                break;
        }
    }
    
    public boolean isDone() {
        return done;
    }
    
    private void forward(DesiredProps props) {
       
        int currentDirection = (int) robot.rotateProperty().get();

	        switch (currentDirection) {
	            case right:
	                props.setPos(robot.getPos().add(1, 0));
	                ticksToGo--;
	                break;
	            case left:
	                props.setPos(robot.getPos().add(-1, 0));
	                ticksToGo--;
	                break;
	            case up:
	                props.setPos(robot.getPos().add(0, -1));
	                ticksToGo--;
	                break;
	            case down:
	                props.setPos(robot.getPos().add(0, 1));
	                ticksToGo--;
	                break;
	        }

	        if (ticksToGo == 0) {
                done = true;
            }
    }
    
    private void backward(DesiredProps props) {
    	int currentDirection = (int) robot.rotateProperty().get();
        
    	while(ticksToGo > 0) {
	    	switch (currentDirection) {
	        case right:
	            props.setPos(robot.getPos().add(-ticksToGo, 0));
	            ticksToGo--;
	            break;
	        case left:
	            props.setPos(robot.getPos().add(ticksToGo, 0));
	            ticksToGo--;
	            break;
	        case up:
	            props.setPos(robot.getPos().add(0, ticksToGo));
	            ticksToGo--;
	            break;
	        case down:
	            props.setPos(robot.getPos().add(0, -ticksToGo));
	            ticksToGo--;
	            break;
	    	}
    	}

        if (ticksToGo == 0) {
            done = true;
        }
    }
    
    private void turnCW(DesiredProps props) {
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
        case right:
            props.setRotation(down);
            break;
        case left:
            props.setRotation(up);
            break;
        case up:
            props.setRotation(right);
            break;
        case down:
            props.setRotation(left);
            break;
        }  
        
        done = true;
    }
    
    private void turnCCW(DesiredProps props) {
        int currentDirection = (int) robot.rotateProperty().get();
        
        switch (currentDirection) {
        case right:
            props.setRotation(up);
            break;
        case left:
        	props.setRotation(down);
            break;
        case up:
        	props.setRotation(left);
            break;
        case down:
        	props.setRotation(right);
            break;
        }
        
        done = true;
    }

    private void pickUp(DesiredProps props) {
        props.setShelfNameToPickUp(shelfToPickUp);
        done = true;
    }
    
    public TaskItem setTicksToGo(int speed) {
    	this.ticksToGo = speed;
    	return this;
    }
    
    public void incrementTicksToGo() {
        ticksToGo++;
    }
    
    public TaskItem setAtShelfName(String shelfName) {
        this.atShelfName = shelfName;
        return this;
    }

    public TaskItem setShelfToPickUp(String shelfToPickUp) {
        this.shelfToPickUp = shelfToPickUp;
        return this;
    }
    
    private void condition(DesiredProps props) throws Exception {
        Shelf s = robot.getShelf();
        if (conditionChecker.checkCondition(robot.getMission().getCurrentTask().getRetries(), s, s != null ? s.getShelfProperties() : null)) {
            conditionProcessTasks(ifTaskItems, props);
        } else {
            conditionProcessTasks(elseTaskItems, props);
        }
        done = true;
    }
    
    private void conditionProcessTasks(List<TaskItem> items, DesiredProps props) throws Exception {
        for (int i=items.size()-1; i>=0; i--) {
            TaskItem ti = items.get(i);
            if (i == 0) {
                ti.executeCommand(props);
            } else {
                robot.getMission().addTaskAtCurrent(ti);
            }
        }
    }
    
    public TaskItem setConditionChecker(ICondition checker) {
        conditionChecker = checker;
        return this;
    }

    public TaskItem setIfTaskItems(IConditionTasks tasks) {
        List<TaskItem> list = new ArrayList<>();
        tasks.addTasks(list);
        this.ifTaskItems = list;
        return this;
    }

    public TaskItem setElseTaskItems(IConditionTasks tasks) {
        List<TaskItem> list = new ArrayList();
        tasks.addTasks(list);
        this.elseTaskItems = list;
        return this;
    }

    private void conditionAt(DesiredProps props) throws Exception {
        if (atShelfName != null) {
            if (robot.getMission().collision(atShelfName, props)) {
                // the first taskitem should be added last.
                // As in the taskitems steps is reversed
                conditionProcessTasks(ifTaskItems, props);
            } else {
                conditionProcessTasks(elseTaskItems, props);
            }
            done = true;
        } else {
            throw new Exception("Custom exception no shelf name set");
        }
    }
}
