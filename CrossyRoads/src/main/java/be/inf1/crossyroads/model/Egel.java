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

public class Egel
{
    /** 
     * x-coördinaat 
     */
    private double x;
    
    /** 
     * y-coördinaat 
     */ 

    private double y;
    
    /** 
     * straal van de egel 
     */
    private double straal;
    
    /**
     * snelheid van de egel in de x-richting. Om te beginnen is deze 0.
     */
    private double snelX = 0;
    
    /**
     * snelheid van de egel in de y-richting. Om te beginnen is deze 0.
     */
    private double snelY = 0;
    
    /** 
     * parameter voor of de egel kan bewegen en dus levend is. 
     */
    private boolean levend;
    
    /** 
     * constructor voor nieuwe egel; 
     * @param x het x-coördinaat van de egel 
     * @param y het y-coördinaat van de egel 
     * @param straal de straal van de egel 
     * @param levend wanneer egel levend is/kan bewegen 
     */
    public Egel(double x, double y, double straal, boolean levend)
    {
        this.x = x;
        this.y = y;
        this.straal = straal; 
        this.levend = levend;
    }
    
    /** 
     * default constructor 
     * De straal is 15. 
     * x staat in het midden. 
     * y staat vanonder(een y-positie die 30 zal zijn van de onderkant). 
     * de egel kan bewegen/is levend. 
     */
    public Egel()
    {
        straal = 15;
        x = Game.XRAND/2;
        y = Game.YRAND - 2 * straal;
        levend = true;
    }
    
    /** 
     * x-coördinaat 
     * @return x het x-coordinaat. 
     */
    public double getX()
    {
        return x;
    }
    
    /** 
     * x-coördinaat 
     * @param x x-coordinaat veranderen. 
     */
    public void setX(double x)
    {
        this.x = x;
    }
    
    /** 
     * y-coördinaat 
     * @return y het y-coordinaat.
     */
    public double getY()
    {
        return y;
    }
    
    /** 
     * y-coördinaat 
     * @param y y-coordinaat veranderen 
     */
    public void setY(double y)
    {
        this.y = y;
    }
    
    /** 
     * straal van de egel 
     * @return straal de straal van de egel. 
     */
    public double getStraal()
    {
        return straal;
    }

    /** 
     * straal van de egel 
     * @param straal straal van de egel veranderen 
     */
    public void setStraal(double straal)
    {
        this.straal = straal;
    }
    
    /** 
     * @return snelX de snelheid van de egel in de x-richting.
     */
    public double getSnelX()
    {
        return snelX;
    }
    
    /** 
     * verander de afstand die de egel afleft in de x-richitng.  
     * @param snelX de afstand in de x-richting. 
     */
    public void setSnelX(double snelX)
    {
        this.snelX = snelX;
    }
    
    /** 
     * @return snelY de snelheid van de egel in de y-richting. 
     */
    public double getSnelY()
    {
        return snelY;
    }
    
    /** 
     * verander de afstand die de egel afleft in de y-richitng.  
     * @param snelY de afstand in de y-richting 
     */
    public void setSnelY(double snelY)
    {
        this.snelY = snelY;
    }
    
    /** 
     * getter voor de toestand van de egel.
     * @return levend (true) als de egel kan bewegen. 
     */
    public boolean isLevend()
    {
        return levend;
    }
    
    /** 
     * setter om de toestand van de egel te veranderen. 
     * @param levend de mogelijkheid om te bewegen. 
     */
    public void setLevend(boolean levend)
    {
        this.levend = levend;
    }
    
    ///////////////////////////////////////// 
    //////////VERPLAATSING/////////////////// 
    /** 
     * snelheid van de egel. 
     * We gebruiken een constante zodat als we de egel sneller willen laten bewegen, we dit alleen hier moeten veranderen.
     */
    private int SPEED = 5;
    
    /** 
     * snelheid van de egel op 0 zetten. Deze functie is erbij gekomen omdat de egel bij aanrijding nog doorgaat in de laatst gebruikte richting.
     */
    public void setSpeedZero()
    {
        SPEED = 0;
    }
    
    /** 
     * de snelheid van de egel resetten. Als de egel terug wordt geplaatst zoals het begin.
     */
    public void resetSpeed()
    {
        SPEED = 5;
    }
    
    /** 
     * de methode die bij de timer van de egel zal worden opgeroepen. Bij elke tick van de timer wordt deze uitgevoerd.
     */
    public void tick()
    {
        x += getSnelX();
        y += getSnelY();
        //wanneer de egel buiten de randen probeert te geraken 
            if (x < getStraal()) x = getStraal();
            if (x > Game.XRAND - getStraal()) x = Game.XRAND- getStraal();
            if (y < getStraal()) y = getStraal();
            if (y > Game.YRAND - getStraal()) y = Game.YRAND - getStraal();
    }
    
    /** 
     * het omhoog verplaatsen van de egel. 
     */
    public void Omhoog()
    {
        setSnelY(0-SPEED);
    }
    
    /** 
     * het omlaag verplaatsen van de egel. 
     */
    public void Omlaag()
    {
        setSnelY(SPEED);
    }
    
    /** 
     * het naar links verplaatsen van de egel  
     */
    public void Links()
    {
        setSnelX(0-SPEED);
    }
    
    /** 
     * het naar rechts verplaatsen van de egel 
     */
    public void Rechts()
    {
        setSnelX(SPEED);
    }
    
    ////////////////////////////////////////// 
    /////////////RESETTEN///////////////////// 
    /** 
     * het resetten van de egel op de beginpositie en het terug levend maken.
     */
    public void resetEgel()
    {
        x = Game.XRAND/2;
        y = Game.YRAND - 2 * straal;
        setLevend(true);
    }
}