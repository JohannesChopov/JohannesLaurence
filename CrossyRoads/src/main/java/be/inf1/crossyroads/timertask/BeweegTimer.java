/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.timertask;

import be.inf1.crossyroads.CrossyRoadsFXMlController;
import be.inf1.crossyroads.model.Game;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author Johannes
 */
public class BeweegTimer extends TimerTask{
    
    /**
     * het model van de game.
     */
    private Game model;
    
    /**
     * de controller van de applicatie
     */
    private CrossyRoadsFXMlController controller;

    /**
     * de constructor van de timertask;
     * @param model het model dat je gaat gebruiken voor de tick
     * @param controller de controller waar de game wordt geupdate.
     */
    public BeweegTimer(Game model, CrossyRoadsFXMlController controller) {
        this.model = model;
        this.controller = controller;
    }
    
    /**
     * Het werken van de timer. ELke tick wordt de model.tick() uitgevoerd en wordt de controller geupdate.
     */
    @Override
    public void run() {
        model.tick();
        Platform.runLater(controller::update);
    }
}
