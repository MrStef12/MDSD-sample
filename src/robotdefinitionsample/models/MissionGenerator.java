/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample.models;

import java.util.Map;
import javafx.scene.layout.GridPane;

/**
 *
 * @author ditlev
 */
public class MissionGenerator {
    
    
    public Mission Robot1(Robot r, GridPane grid) {
        Mission m = new Mission(grid);
        Task t = new Task("asd");
        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
        t.addTask(new TaskItem(r, ActionCondition.CONDITIONAT)
                .setAtShelfName("Shelf1")
                .setIfTaskItems(
                        new TaskItem(r, ActionCondition.BACKWARD),
                        new TaskItem(r, ActionCondition.BACKWARD)
                )
        );
//        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
//        t.addTask(new TaskItem(r, ActionCondition.FORWARD));
//        t.addTask(new TaskItem(r, ActionCondition.PICKUP).setShelfToPickUp("Shelf1"));
//        t.addTask(new TaskItem(r, ActionCondition.TURN_CW));
//        t.addTask(new TaskItem(r, ActionCondition.FORWARD).setTicksToGo(2));
//        t.addTask(new TaskItem(r, ActionCondition.TURN_CCW));
//        t.addTask(new TaskItem(r, ActionCondition.BACKWARD));
        m.addTask(t);
        return m;
    }

    public Mission Robot2(Robot r, GridPane grid) {
        Mission m = new Mission(grid);
        Task t = new Task("asd");
        
        t.addTask(new TaskItem(r, ActionCondition.TURN_CCW));
        t.addTask(new TaskItem(r, ActionCondition.TURN_CCW));
        
        t.addTask(new TaskItem(r, ActionCondition.FORWARD).setTicksToGo(2));
        t.addTask(new TaskItem(r, ActionCondition.CONDITION)
                .setConditionChecker(new ICondition() {
                    @Override
                    public boolean checkCondition(int retries, Shelf shelf, Map<String, Property> properties) {
                        return 10 > 3;
                    }
                })
                .setIfTaskItems(
                    new TaskItem(r, ActionCondition.TURN_CCW),
                    new TaskItem(r, ActionCondition.TURN_CCW)
                )
        );
        t.addTask(new TaskItem(r, ActionCondition.BACKWARD));
        
        m.addTask(t);
        return m;
    }
    
}
