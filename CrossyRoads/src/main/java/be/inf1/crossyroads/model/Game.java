/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.inf1.crossyroads.model;

import be.inf1.crossyroads.model.Autos;
import be.inf1.crossyroads.model.Egel;
import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Johannes Chopov
 */
public class Game {
    
    //Verdeling van de taak
    //Johannes Chopov 70%
    //Laurence Jorissen 30%
    
    /////////////////////////////////////////////////
    //GEMAAKT DOOR LAURENCE                        //
    //Egel                                         //
    //EgelView                                     //
    //Vlag                                         // 
    //VlagView                                     //
    //KaderView                                    // 
    //LayoutView                                   //
    //                                             //
    //GEMAAKT DOOR JOHANNES                        //
    //Auto                                         //
    //Autos                                        //
    //Game                                         //
    //AutoView                                     //
    //AutosView                                    //
    //GameView                                     //
    //CrossyRoadsFXMlController                    //
    //DoodException                                //
    //BeweegTimer                                  //
    /////////////////////////////////////////////////
    
    /**
     * het x-coordinaat van de rechterkant van het spel.
     */
    public static final int XRAND = 640;
    
    /**
     * het y-coordinaat van de onderkant van het spel.
     */
    public static final int YRAND = 700;
    
    /**
     * het model van de egel van het spel.
     */
    private Egel egel;
    
    /**
     * het model van de autos van het spel.
     */
    private Autos autos;
    
    /**
     * het model van de vlag van het spel.
     */
    private Vlag vlag;
    
    /**
     * huidige score van de speler.
     */
    private int score;
    
    /**
     * hoogste score van de speler sinds dat deze het spel heeft gestart.
     */
    private int hscore;
    
    /**
     * Constructor voor de game
     * @param egel het model van de egel.
     * @param autos het model van de autos(de array).
     * @param vlag het model van de vlag.
     * @param score de score van het spel.
     * @param hscore de hscore van het spel.
     */
    public Game(Egel egel, Autos autos, Vlag vlag ,int score, int hscore) {
        this.egel = egel;
        this.autos = autos;
        this.vlag = vlag;
        this.score = score;
        this.hscore = hscore;
    }

    /**
     * default constructor voor de game.
     * model van de egel wordt met een default constructor van de egel gemaakt.
     * model van de autos wordt met een default constructor van de autos gemaakt.
     * model van de vlag wordt met een default constructor van de vlag gemaakt.
     * score en hscore starten met 0.
     */
    public Game() {
        egel = new Egel();
        autos = new Autos();
        vlag = new Vlag();
        score = 0;
        hscore = 0;
    }
    
    /**
     * @return egel. De egel van het spel.
     */
    public Egel getEgel() {
        return egel;
    }

    /**
     * @return autos. De autos van het spel.
     */
    public Autos getAutos() {
        return autos;
    }

    /**
     * @return vlag, de vlag van het spel.
     */
    public Vlag getVlag() {
        return vlag;
    }

    /**
     * @return score, de score van het spel.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return hscore, de highscore van het spel.
     */
    public int getHscore() {
        return hscore;
    }
    
    /**
     * @param vlag the vlag to set
     */
    public void setVlag(Vlag vlag) {
        this.vlag = vlag;
    }
    
    /**
     * @param egel the egel to set
     */
    public void setEgel(Egel egel) {
        this.egel = egel;
    }

    /**
     * @param autos the autos to set
     */
    public void setAutos(Autos autos) {
        this.autos = autos;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * @param hscore the hscore to set
     */
    public void setHscore(int hscore) {
        this.hscore = hscore;
    }
    
    /**
     * Controle voor als de egel is aangereden. Is er een auto uit de Array die de egel heeft omgereden?
     * Als de egel is aangereden dan is de egel dood en zijn score wordt weer 0.
     */
    public void isEgelAangereden(){
        for (int i=0;i<autos.AANTALAUTOS;i++) {
            if (egel.getX()>=autos.getX(i) && egel.getX()<=autos.getX(i)+autos.getLengte(i)) {
                if (egel.getY()>=autos.getY(i)-egel.getStraal()*2/3 && 
                    egel.getY()<= autos.getY(i)+autos.getBreedte(i)+egel.getStraal()*2/3) {
                    egel.setLevend(false);
                    egel.setSnelX(0);
                    egel.setSnelY(0);
                    geluidDood();
                    
                    if (score > hscore) {hscore = score;}
                    setScore(0);
                    
                }
            }
        }
    }
    
    /**
     * het geluid dat je zal horen als de egel sterft.
     */
    //Deze code komt van een pdf-document gemaakt door Kris Aerts.
    public void geluidDood() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("sound.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
    }
    
    /**
     * het geluid dat je zal horen als de egel de vlag tikt.
     */
    //Deze code komt van een pdf-document gemaakt door Kris Aerts.
    public void geluidVlag() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("bling.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.05);
    }
    
    /**
     * Deze code controleert of de egel bij de vlag is en zet direct de egel terug op zijn spawn.
     * De score van het spel verhoogt ook met 1.
     */
    public void isEgelBijVlag(){
        if (vlag.getX()<=egel.getX()+egel.getStraal() && vlag.getX()>=egel.getX()-egel.getStraal()) {
            if (vlag.getY()>egel.getY()-egel.getStraal() && vlag.getY()<egel.getY()+egel.getStraal()) {
                geluidVlag();
                score += 1;
                egel.resetEgel();
            }
        }
    }
    
    /**
     * de tick die alle ticks van de modellen omvat.
     * Elke tik moet er ook gecontroleerd worden of de egel is aangereden, of als de egel bij de vlag is.
     */
    public void tick() {
        egel.tick();
        autos.tick();
        isEgelAangereden();
        isEgelBijVlag();
    }
}
