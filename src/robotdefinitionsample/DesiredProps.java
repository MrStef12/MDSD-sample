/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.interfaces.TaskItem;
import robotdefinitionsample.models.Vector2;
import robotdefinitionsample.models.taskitems.Constants;

/**
 *
 * @author stefh
 */
public class DesiredProps {
    
    private Robot robot;
    private GridPane grid;
    private Vector2 pos;
    private int rotation;
    private boolean discarded;
    private boolean shouldPickUp;
    private boolean shouldSetDown;
    private List<TaskItem> itemsToAdd;
    private Constants.OR waitOr;

    public DesiredProps(Robot robot, GridPane grid, Vector2 pos, int rotation) {
        this.robot = robot;
        this.grid = grid;
        this.pos = pos;
        this.rotation = rotation;
        this.discarded = false;
        this.shouldPickUp = false;
        this.shouldSetDown = false;
        this.itemsToAdd = new ArrayList<>();
    }
    
    public void addItemToAdd(TaskItem item) {
        this.itemsToAdd.add(item);
    }
    
    public void addItemsToAdd(List<TaskItem> items) {
        this.itemsToAdd.addAll(items);
    }

    public Robot getRobot() {
        return robot;
    }

    public GridPane getGrid() {
        return grid;
    }
    
    public Vector2 getPos() {
        return pos;
    }

    public int getRotation() {
        return rotation;
    }

    public boolean isDiscarded() {
        return discarded;
    }

    public boolean shouldPickUp() {
        return shouldPickUp;
    }

    public boolean shouldSetDown() {
        return shouldSetDown;
    }

    public List<TaskItem> getItemsToAdd() {
        return itemsToAdd;
    }

    public Constants.OR getWaitOr() {
        return waitOr;
    }

    public void setPos(int x, int y) {
        this.pos = new Vector2(x, x);
    }
    
    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setDiscarded(boolean discarded) {
        this.discarded = discarded;
    }

    public void setShouldPickUp(boolean shouldPickUp) {
        this.shouldPickUp = shouldPickUp;
    }

    public void setShouldSetDown(boolean shouldSetDown) {
        this.shouldSetDown = shouldSetDown;
    }

    public void setWaitOr(Constants.OR waitOr) {
        this.waitOr = waitOr;
    }
}
