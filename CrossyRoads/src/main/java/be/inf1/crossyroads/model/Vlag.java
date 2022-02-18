/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.model;
/** 
* 
* @author Laurence Jorissen 
*/
public class Vlag {
    /** 
     * x-coördinaat van de vlag
     */
    private double x;
    
    /** 
     * y-coördinaat van de vlag
     */
    private double y;
    
    /** 
     * vaste constante positie voor de y-coördinaat van de vlag. 
     */
    private static final double VLAGPOSITIE_Y = 60;
    
    /////////////////////////////////////////////////// 
    ///////////CONSTRUCTOREN/////////////////////////// 
    /** 
     * constructor voor de vlag 
     *  
     * @param x 
     * @param y 
     */
    public Vlag(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /** 
     * constructor voor de positie van de vlag 
     * In de x-richting in het midden van het veld.
     * In de y-richting op de vaste gegeven positie VLAGPOSITIE_Y.
     */
    public Vlag(){
        x = Game.XRAND/2;
        y = VLAGPOSITIE_Y;
    }
    //////////////////////////////////////////////////// 
    ///////////////GETTERS AND SETTERS////////////////// 
    /** 
     * @return x het x-coordinaat van de vlag. 
     */
    public double getX() {
        return x;
    }
    
    /** 
     * de x om te zetten.
     * @param x het nieuwe x-coordinaat van de vlag.  
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /** 
     * @return y het y-coordinaat van de vlag.
     */
    public double getY() {
        return y;
    }
    
    /** 
     * de y om te zetten.
     * @param y het nieuwe y-coordinaat van de vlag.
     */
    public void setY(double y) {
        this.y = y;
    }
} 
