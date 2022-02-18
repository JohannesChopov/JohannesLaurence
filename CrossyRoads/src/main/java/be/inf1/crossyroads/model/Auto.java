/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.model;

/**
 *
 * @author Johannes Chopov
 */
public class Auto {
    /**
     * x-coordinaat van de auto.
     */
    private double x;
    
    /**
     * y-coordinaat van de auto.
     */
    private double y;
    
    /**
     * lengte van de auto (grootte in de x richting)
     */
    private double lengte;
    
    /**
     * breedte van de auto (grootte in de y-rcihting)
     */
    private double breedte;
    
    /**
     * rijnummer/rang van de auto. Deze parameter is nuttig voor de Array van meerdere autos
     */
    private int rang;
    
    /**
     * De snelheid van de auto.
     */
    private double v;
    
    /**
     * richting van de auto. 1 is naar rechts, -1 is naar links. alleen deze twee waarden worden gebruikt. 
     */
    private int r;
    
    /**
     * Constructor voor de auto
     * @param x x-coordinaat van de auto
     * @param y y-coordinaat van de auto
     * @param lengte grootte in de x richintg
     * @param breedte groote in de y-richting
     * @param rang het rijnummer van de auto. Nuttig voor de array.
     * @param v de snelheid van de auto.
     * @param r de richting van de auto.
     */
    public Auto(double x, double y, double lengte, double breedte, int rang, double v, int r) {
        this.x = x;
        this.y = y;
        this.lengte = lengte;
        this.breedte = breedte;
        this.rang = rang;
        this.v = v;
        this.r = r;
    }
    
    /**
     * default constructor van de auto..
     * het x-coordinaat van de auto start buiten het beeld van de fxml.
     * @param rang het rijnummer van de auto, dit gaat voor de opstelling van de wegen belangrijk zijn door de Array.
     * Het rangnummer bepaalt de richting van de auto en het y-coordinaat. 
     * Als de auto rangnummer 0 tot en met 3 heeft rijdt deze van rechts naar links, daarom is r -1. Deze bevindt zich op de bovenste weg
     * Als de auto rangnummer 4 tot en met 7 heeft rijdt deze van links naar rechts, daarom is r 1. Deze bevindt zich op de onderste weg
     * lengte van de auto is 120
     * breedte van de auto is 50
     * v de snelheid van de auto die bij het opstarten random wordt gegenereerd met RandomSnelheid.
     */
    public Auto(int rang) {
        this.rang = rang;
        if (rang<4) {
            y = 100 + rang*50;
            r = -1;
            x = Game.XRAND - r*RandomAfstand();
        }
        if (rang>=4) {
            y = 400 + (rang-4)*50;
            r = 1;
            x = -1*lengte - r*RandomAfstand();
        }
        
        lengte = 100;
        breedte = 40;
        v = RandomSnelheid();
    }
    
    /**
     * methode om een random afstand te genereren.
     * @return een willekeurige afstand.
     */
    public double RandomAfstand() {
        return Math.random()*1000 + 200;
    }
    
    /**
     * Methode voor een random waarde te genereren voor de snelheid. 
     * Deze kon ook direct in de constructor, maar deze ziet er properder uit.
     * De richting bepaalt of de snelheid tegenover de y-as positief of negatief is (of de auto naar links of naar rechts gaat rijden).
     * @return een random waarde voor de snelheid van de auto.
     */
    public double RandomSnelheid() {
        return ((Math.random()*13 + 10)*r);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////GETTERS AND SETTERS/////////////////////////////////

    /**
     * x-coordinaat van de auto.
     * @return de x-coordinaat van de auto
     */
    public double getX() {
        return x;
    }

    /**
     * y-coordinaat van de auto
     * @return de y-coordinaat van de auto
     */
    public double getY() {
        return y;
    }

    /**
     * lengte van de auto (grootte in de x richting)
     * @return de lengte van de auto.
     */
    public double getLengte() {
        return lengte;
    }

    /**
     * breedte van de auto (grootte in de y-rcihting)
     * @return de breedte van de auto.
     */
    public double getBreedte() {
        return breedte;
    }
    
    /**
     * de richting van de auto. Naar rechts of naar links.
     * @return de richting r (1 of -1).
     */
    public int getRichting() {
        return r;
    }
    
    /**
     * rijnummer van de auto. Deze parameter is nuttig voor de Array van meerdere autos
     * @return de rang van de auto.
     */
    public int getRang() {
        return rang;
    }

    /**
     * De snelheid van de auto.
     * @return de snelheid
     */
    public double getV() {
        return v;
    }
    
    /**
     * x-coordinaat van de auto.
     * @param x die gezet wordt.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * y-coordinaat van de auto.
     * @param y de y die gezet wordt.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * lengte van de auto (grootte in de x richting)
     * @param lengte de lengte om te zetten.
     */
    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    /**
     * breedte van de auto (grootte in de y-rcihting)
     * @param breedte de breedte om te zetten.
     */
    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    /**
     * rijnummer/rang van de auto. Deze parameter is nuttig voor de Array van meerdere autos
     * @param rang de rang om te zetten.
     */
    public void setRang(int rang) {
        this.rang = rang;
    }

    /**
     * De setter voor de snelheid van de auto.
     * @param v de snelheid die om te zetten.
     */
    public void setV(double v) {
        this.v = v;
    }
    
    /**
     * De setter van de richting van de auto.
     * @param r de richting om te zetten. OPGELET: alleen 1 of -1: 1 naar rechts en -1 naar links.
     */
    public void setRichting(int r) {
        this.r = r;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////TICKS EN DE REST//////////////////////////////////////////////
    
    /**
     * de auto verandert van positie met een snelheid v.
     */
    public void beweging() {
        x = x + v;
    }
    
    /**
     * De methode die bij de timer van de auto zal opgeroepen worden.
     * de auto wordt steeds teruggezet naar een random positie voor de y-as als deze een random bepaalde afstand heeft afgelegd,
     * zo lijkt het alsof er steeds een andere, nieuwe auto voorbijrijdt.
     * Ook de snelheid wordt opnieuw random bepaald als de auto terugkeert naar de beginpositie.
     */
    public void Tick() {
        
        beweging();
        
        if (r == 1) {
            if (x > (Game.XRAND + RandomAfstand())) {
                x = -1 * lengte - RandomAfstand();
                v = RandomSnelheid();
            }
        }
        
        if (r == -1) {
            if (x+getLengte()<-1*RandomAfstand()) {
                x = Game.XRAND + RandomAfstand();
                v = RandomSnelheid();
            }
        }
    }
}