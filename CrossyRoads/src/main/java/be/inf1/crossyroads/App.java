package be.inf1.crossyroads;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    
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
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("CrossyRoadsFXML"), 640, 800);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}