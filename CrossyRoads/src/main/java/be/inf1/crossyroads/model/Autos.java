/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.model;

import be.inf1.crossyroads.model.Auto;

/**
 *
 * @author Johannes Chopov
 */
public class Autos {
    /**
     * Array autos met daarin autos.
     */
    private Auto[] autos;
    
    /**
     * De hoeveelheid autos
     */
    public static final int AANTALAUTOS = 8;
    
    /**
     * De constructor van de Array van autos.
     * de for-loop maakt steeds een nieuwe auto door gebruik te maken van een rangnummer.
     */
    public Autos() {
        autos = new Auto[AANTALAUTOS];
        for (int i=0; i<AANTALAUTOS; i++) {
            autos[i] = new Auto(i);
        }
    }
    
    /**
     * Deze methode gaat over elke auto van de Array en voert de tick uit.
     */
    public void tick() {
        for (int i=0; i<AANTALAUTOS; i++) {
            autos[i].Tick();
        }
    }
    
    /**
     * getter van het x-coordinaat voor een bepaalde auto uit de Array.
     * @param i de rang van de auto.
     * @return het x-coordinaat van de auto met deze rang.
     */
    public double getX(int i) {
        return autos[i].getX();
    }
    
    /**
     * getter van het y-coordinaat voor een bepaalde auto uit de Array.
     * @param i de rang van de auto.
     * @return het y-coordinaat van de auto met deze rang.
     */
    public double getY(int i) {
        return autos[i].getY();
    }
    
    /**
     * getter van de lengte van een bepaalde auto uit de Array.
     * @param i de rang van de auto.
     * @return de lengte van de auto met deze rang.
     */
    public double getLengte(int i) {
        return autos[i].getLengte();
    }
    
    /**
     * getter van de breedte van een bepaalde auto uit de Array.
     * @param i de rang van de auto.
     * @return de breedte van de auto met deze rang.
     */
    public double getBreedte(int i) {
        return autos[i].getBreedte();
    }
    
    /**
     * getter voor de auto op een bepaalde rang.
     * Dit is nuttig voor de view van dit model.
     * @param i de rang van de auto die je wil hebben.
     * @return de auto op de rang i.
     */
    public Auto getAutoRang(int i) {
        return autos[i];
    }
}