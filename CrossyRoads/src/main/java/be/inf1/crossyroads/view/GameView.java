/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.view;


import be.inf1.crossyroads.model.Game;
import javafx.scene.layout.Region;

/**
 *
 * @author Johannes
 */
public class GameView extends Region{
    private Game model;
    
    /**
     * de overkoepelende hoofdview van alle views.
     * @param model het overkoepelend model van de game. 
     */
    public GameView(Game model) {
        this.model = model;
        update();
    }
    
    /**
     * de update verwijdert alles van het spel en tekent het daarna helemaal opnieuw met de info van de bijhorende modellen.
     */
    public void update() {
        getChildren().clear();
        
        EgelView ev = new EgelView(model.getEgel());
        AutosView asv = new AutosView(model.getAutos());
        VlagView vv = new VlagView(model.getVlag());
        KaderView kv = new KaderView();
        LayoutView lv = new LayoutView();
        
        getChildren().addAll(lv,ev,vv,asv,kv);
    }
}
