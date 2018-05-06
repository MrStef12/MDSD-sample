/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdefinitionsample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import robotdefinitionsample.models.Mission;
import robotdefinitionsample.models.MissionGenerator;
import robotdefinitionsample.models.Obstacle;
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
    
    private List<Robot> robots;
    private List<Obstacle> obstacles;
    private List<Shelf> shelfs;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        robots = new ArrayList<>();
        obstacles = new ArrayList<>();
        shelfs = new ArrayList<>();
        
        Shelf s1 = new Shelf("navn", new Vector2(4,5));
        

        Robot r = new Robot("name", new Vector2(0,0));
        r.setMission(MissionGenerator.Robot1(r));

        robots.add(r);
        
        grid.add(r, r.getPos().getX(), r.getPos().getY());
        
    }

    @FXML
    private void doStuff(MouseEvent event) {
        
        //Try to drag the text robot in the grid to trigger
        //this event
        tick();
    }
    
    private void tick() {
        for (Robot r : robots) {
            r.execute();
            grid.getChildren().remove(r);
            grid.add(r, r.getPos().getX(), r.getPos().getY());
        }
    }
    
}
