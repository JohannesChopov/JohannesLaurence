/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.view;

import javafx.scene.layout.Region;
import javafx.scene.shape.Line;

/**
 *
 * @author Johannes
 */
public class KaderView extends Region{
     /** 
     * omkaderen van de randen van het spel 
     */
    public KaderView(){
        update();
    }
    /** 
     * plaatsen van de kader van het spel. Bij deze view wordt er niks verwijderd.
     */
    public void update(){
        //LIJN BOVEN SCORE 
        Line l1 = new Line(0, 700, 640, 700);
        l1.setStrokeWidth(5);
        
        //LINKERBORDER 
        Line l2 = new Line(0, 0, 0, 700);
        l2.setStrokeWidth(5); 

        //RECHTERBORDER 
        Line l3 = new Line(640, 0, 640, 700);
        l3.setStrokeWidth(5); 

        //BOVENBORDER 
        Line l4 = new Line(0, 0, 640, 0);
        l4.setStrokeWidth(5);
        
        //RECHTSONDER 
        Line l5 = new Line(640, 700, 640, 800);
        l5.setStrokeWidth(5);
        
        //LINKSONDER 
        Line l6 = new Line(0,700,0,800);
        l6.setStrokeWidth(5);
        
        getChildren().addAll(l1,l2,l3,l4,l5,l6);
    }
}
