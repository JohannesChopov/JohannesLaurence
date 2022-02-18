/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.view;

import be.inf1.crossyroads.model.Vlag;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Johannes
 */
public class VlagView extends Region{
    /**
     * het model van de vlag.
     */
    private Vlag model;

    /**
     * constructor van de view van de vlag.
     * @param model 
     */
    public VlagView(Vlag model) {
        this.model = model;
        update();
    }
    
    /**
     * de update methode tekent de vlag relatief met de plaats van de coordinaten uit het model.
     */
    private void update() {
        Line stok = new Line(model.getX(), model.getY(), model.getX(), model.getY() - 50);
        stok.setStrokeWidth(5);
        Rectangle stof = new Rectangle(model.getX(), model.getY()-50, 30, 15);
        stof.setFill(Color.WHITE);
        getChildren().addAll(stok,stof);
    }
}
