/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.view;

import be.inf1.crossyroads.model.Autos;
import javafx.scene.layout.Region;

/**
 *
 * @author Johannes Chopov
 */
public class AutosView extends Region{
    /**
     * het model van de autos (Array). 
     */
    private Autos model;

    /**
     * constructor van de view van alle autos.
     * @param autos het model van de autos.
     */
    public AutosView(Autos autos) {
        this.model = autos;
        update();
    }
    
    /**
     * de update tekent steeds opnieuw de autos relatief met hun x en y coordinaten.
     * voor elke auto van de array tekent de update een nieuwe auto, met zijn coordinaten.
     */
    public void update() {
        for (int i = 0; i < Autos.AANTALAUTOS; i++) {
            AutoView view = new AutoView(model.getAutoRang(i));
            view.update();
            getChildren().add(view);
        }
    }
}
