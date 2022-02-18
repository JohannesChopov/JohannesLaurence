/** 
* To change this license header, choose License Headers in Project Properties.  
* To change this template file, choose Tools | Templates  
* and open the template in the editor.  
*/
package be.inf1.crossyroads.view;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**  
*  
* @author Johannes Chopov 
*/  

public class LayoutView extends Region{
    /** 
     * opmaak van de layout van het spel, wordt alleen getekend met de update. 
     * Deze zou ook in de constructor kunnen hebben staan.
     */
    public LayoutView() {
        update();
    }
    
     /** 
      * Het tekenen van de layout van het spel. De achtergrond dus. 
      */
    public void update() {
        //GRAS  
        Rectangle gras = new Rectangle(0, 0, 640, 800);
        gras.setFill(Color.GREEN);
        //WEG2  
        Rectangle weg2 = new Rectangle(0, 400-AutoView.BANDBREEDTE,
                640, 200+AutoView.BANDBREEDTE);
        weg2.setFill(Color.GRAY);
        //WEG1  
        Rectangle weg1 = new Rectangle(0, 100-AutoView.BANDBREEDTE,
                640, 200+AutoView.BANDBREEDTE);
        weg1.setFill(Color.GRAY);
        //TROTTOIR2  
        Rectangle trot3 = new Rectangle(0, 300, 640, 30);
        trot3.setFill(Color.GHOSTWHITE);
        trot3.setStroke(Color.GRAY);  
        trot3.setStrokeWidth(2);
        
        Rectangle trot4 = new Rectangle(0, 100-AutoView.BANDBREEDTE-30,
                640, 30);
        trot4.setFill(Color.GHOSTWHITE);
        trot4.setStroke(Color.GRAY);
        trot4.setStrokeWidth(2);
        
        //TROTTOIR1  
        Rectangle trot1 = new Rectangle(0, 600, 640, 30);
        trot1.setFill(Color.GHOSTWHITE);
        trot1.setStroke(Color.GRAY);
        trot1.setStrokeWidth(2);          

        Rectangle trot2 = new Rectangle(0, 400-AutoView.BANDBREEDTE-30,
                640, 30);
        trot2.setFill(Color.GHOSTWHITE);
        trot2.setStroke(Color.GRAY);
        trot2.setStrokeWidth(2);
        getChildren().addAll(gras,weg1,weg2,trot1,trot2,trot3,trot4);
    }
}
