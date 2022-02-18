package be.inf1.crossyroads;

import be.inf1.crossyroads.model.Game;
import be.inf1.crossyroads.timertask.BeweegTimer;
import be.inf1.crossyroads.view.GameView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class CrossyRoadsFXMlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startKnop;

    @FXML
    private AnchorPane paneel;

    @FXML
    private Text scoreTekst;
    
    @FXML
    private Text hscoreTekst;
    
    /**
     * het overkoepelend model van de game.
     */
    private Game model;
    
    /**
     * de overkoepelende view van de game.
     */
    private GameView view;
    
    /**
     * de timer die op het begin van de game zal starten;
     */
    private Timer beweegTimer;
    
    /**
     * de mediaplayer die gebruikt gaat worden voor muziek in de game af te spelen.
     * Het idee voor een datamember te maken hiervoor komt met de hulp van Lowie Van Vyve.
     */
    private MediaPlayer liedjespeler;
    
    /**
     * het initialiseren van de game.
     */
    @FXML
    void initialize() {
        model = new Game();
        view = new GameView(model);
        paneel.getChildren().add(view);
        
        speelMuziek();
        
        startKnop.setOnAction(a->start());
        startKnop.setTranslateY(model.YRAND/2);
        
        view.setOnKeyPressed(this::beweeg);
        view.setOnKeyReleased(this::stop);
        view.setFocusTraversable(true);
        
        scoreTekst.setText("SCORE : 0");
        hscoreTekst.setText("HIGHSCORE : 0");
        
    }
    
    /**
     * methode om muziek af te spelen. Dankzij Kris Aerts die een pdf hierover heeft gedeeld.
     */
    public void speelMuziek() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("music.mp3");
        Media media = new Media(resource.toString());
        liedjespeler = new MediaPlayer(media);
        liedjespeler.setAutoPlay(true);
        liedjespeler.setVolume(0.1);
        // DE MUZIEK KOMT VAN FARMINGSIMULATOR ALS WE AAN BRONVERMELDING ZOU MOETEN DOEN VOOR GELUIDEN.
    }
    
    /**
     * de methode die wordt opgeroepen bij het indrukken van de startknop.
     * een timer wordt hier gemaakt.
     */
    public void start() {
        BeweegTimer task1 = new BeweegTimer(model,this);
        beweegTimer = new Timer(true);
        beweegTimer.schedule(task1, 1, 20);
        
        startKnop.setDisable(true);
        startKnop.setVisible(false);
    }
    
    /**
     * Het updaten van de view en de tekst van de fxml updaten.
     */
    public void update() {
        view.update();
        scoreTekst.setText("SCORE : " + model.getScore());
        hscoreTekst.setText("HIGHSCORE : " + model.getHscore());
    }
    
    /**
     * Een methode die een exception maakt als de egel dood is. Deze exception is nodig zodat de speler niet meer kan bewegen bij het doodgaan.
     */
    public void controleerBeweegmogelijkheid() {
        if (model.getEgel().isLevend()==false) {
            throw new DoodException("Je bent dood, druk op spatie om opniew te starten");
        }
    }
    
    /**
     * De methode voor de keyevents als er een toets wordt ingedrukt.
     * Als de egel dood is dan zorgt de exception ervoor dat de egel niet meer kan bewegen.
     * @param e het keyevent.
     */
    public void beweeg(KeyEvent e) {
        try {controleerBeweegmogelijkheid();    
            switch (e.getCode()) {
                case Z:
                    model.getEgel().Omhoog();
                    break;
                case S:
                    model.getEgel().Omlaag();
                    break;
                case Q:
                    model.getEgel().Links();
                    break;
                case D:
                    model.getEgel().Rechts();
                    break;
            }
        }
        catch (DoodException d) {
            System.out.println(d.getMessage());
        }
    }
    
    /**
     * De methode die bij het loslaten van de keys de egel ook doet stoppen met bewegen.
     * Hierin hebben we ook de resetknop gezet in de vorm van de spatiebalk.
     * @param e het keyevent e.
     */
    public void stop(KeyEvent e) {
        switch (e.getCode()) {
            case Z:
                model.getEgel().setSnelY(0);
                break;
            case S:
                model.getEgel().setSnelY(0);
                break;
            case Q:
                model.getEgel().setSnelX(0);
                break;
            case D:
                model.getEgel().setSnelX(0);
                break;
            case SPACE:
                model.getEgel().resetEgel();
                model.setScore(0);
                break;
        }
    }
}