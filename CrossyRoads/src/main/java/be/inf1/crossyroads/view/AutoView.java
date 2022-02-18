/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.view;

import be.inf1.crossyroads.model.Auto;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Johannes
 */
public class AutoView extends Region{
    private Auto model;
    
    /**
     * grootte van de band in de y-richting
     */
    public static final int BANDBREEDTE = 5;
    
    /**
     * plaats van de band tegenover de randen van de auto.
     */
    public static final int BANDAXIS = 10;
    
    /**
     * grootte van de band in de x-richting
     */
    public static final int BANDLENGTE = 20;
    
    /**
     * afstand van de vooruit tegenover de voorkant van de auto. 
     */
    public static final int VOORRUITAFSTANDX = 40;
    
    /**
     * afstand van de vooruit tegenover de zijkant van de auto.
     */
    public static final int VOORRUITAFSTANDY = 5;
    
    /**
     * de lengte van de vooruit vanuit bovenaanzicht
     */
    public static final int VOORRUITHOOGTE = 10;
    
    
    public static double voorruitplaats;
    
    /**
     * constructor van de view.
     * @param model het model van de auto.
     */
    public AutoView(Auto model) {
        this.model = model;
        update();
    }
    
    /**
     * de update tekent steeds opnieuw de auto relatief met zijn x-en y-coordinaten.
     */
    public void update() {
        /**
         * Het grote deel van de auto op basis van parameters uit het model.
         */
        Rectangle body = new Rectangle(model.getX(), model.getY(),
                                        model.getLengte(), model.getBreedte());
            body.setFill(Color.ORANGE);
            body.setStroke(Color.BLACK);
            body.setStrokeWidth(2);
        
        /**
         * Het achterste paar banden van de auto.  
         */
        Rectangle achtersteBanden = new Rectangle(model.getX()+BANDAXIS, model.getY()-BANDBREEDTE,
                                                BANDLENGTE, model.getBreedte()+2*BANDBREEDTE);
            achtersteBanden.setFill(Color.BLACK);
            
        /**
         * Het voorste paar banden van de auto.
         */
        Rectangle voorsteBanden = new Rectangle(model.getX()+model.getLengte()-BANDAXIS-BANDLENGTE, 
                                                    model.getY()-BANDBREEDTE, BANDLENGTE, 
                                                    model.getBreedte()+2*BANDBREEDTE);
            voorsteBanden.setFill(Color.BLACK);
        
            
        //Belangrijk voor de x-plaats van de voorruit.    
        if (model.getRichting() == 1) voorruitplaats = model.getLengte()-VOORRUITAFSTANDX;
        else voorruitplaats = VOORRUITAFSTANDX - VOORRUITHOOGTE;
        
        /**
         * De voorruit van de auto.
         */
        Rectangle voorruit = new Rectangle(model.getX()+voorruitplaats,
                                            model.getY()+VOORRUITAFSTANDY, VOORRUITHOOGTE, model.getBreedte()-2*VOORRUITAFSTANDY);
            voorruit.setFill(Color.LIGHTBLUE);
            voorruit.setStroke(Color.BLACK);
        
        /**
         * Als de auto buiten het zichtbaar veld bevindt stopt de view met deze te tekenen.
         * Als deze er nog in zit natuurlijk wel.
         */
            if (model.getX()<640) getChildren().addAll(voorsteBanden,achtersteBanden,
                                                        body,voorruit);
    }
}
