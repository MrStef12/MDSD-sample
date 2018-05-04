/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Mission;
import robotdefinitionsample.models.Robot;
import robotdefinitionsample.models.Shelf;
import robotdefinitionsample.models.Vector2;

/**
 *
 * @author ditlev
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private GridPane grid;
    @FXML
    private Label Robot;
    
    private Map<String, Robot> robots;
    private Map<String, Label> robotsOnGrid;
    private Map<String, Label> obstacles;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robots = new HashMap<>();
        obstacles = new HashMap<>();
        robotsOnGrid = new HashMap<>();
        
        Shelf s1 = new Shelf("navn", new Vector2(4,5));
        Robot r = new Robot("name", new Vector2(4,5), new Mission());
        
        robots.put(r.getName(), r);
        Label l = new Label(r.getName());
        
        robotsOnGrid.put(r.getName(), l);
        
        grid.add(l, 0, 0);
        
    }

    @FXML
    private void doStuff(MouseEvent event) {
        
        //Try to drag the text robot in the grid to trigger
        //this event
        
        Label l = robotsOnGrid.get("name");
        
        grid.getChildren().remove(l);
        grid.add(l, 9, 9);
        
        System.out.println("relocate");
    }
    
}
