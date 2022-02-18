/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates 
* and open the template in the editor. 
*/ 

package be.inf1.crossyroads.view;
import be.inf1.crossyroads.model.Egel;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

/** 
* 
* @author Laurence Jorissen 
*/
public class EgelView extends Region
{
    /** 
     * model van de egel 
     */
    private Egel model;
    
    /** 
     * constructor van de view van de egel.
     * @param model bijhorend model van de view 
     */
    public EgelView(Egel model)
    {
        this.model = model;
        update();
    }
    
    /** 
     * de update tekent de egel steeds opnieuw relatief met zijn coordinaten.
     * Als de egel dood is dan verwijdert de update eerst de tekening, tekent bloedvlekken en maakt hij de kleur van de egel rood.
     */
    public void update()
    {
        Circle c = new Circle(model.getX(), model.getY(), model.getStraal(),
                Color.BURLYWOOD);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(3);
        
        getChildren().addAll(c);
        //bij dode egel 
        if (model.isLevend() == false)
        {
            getChildren().clear();
            c.setFill(Color.RED);
            
            Ellipse bloedvlek1 = new Ellipse(model.getX()+5,
                    model.getY(), 40, 20);
                bloedvlek1.setFill(Color.RED);
                
            Ellipse bloedvlek2 = new Ellipse(model.getX() + 30,
                    model.getY() - 10, 10, 15);
                bloedvlek2.setFill(Color.RED);
            
            Ellipse bloedvlek3 = new Ellipse(model.getX() + 40,
                    model.getY() + 10, 15, 8);
                bloedvlek3.setFill(Color.RED);
                
            getChildren().addAll(bloedvlek1,bloedvlek2,bloedvlek3,c);
        }
    }
} 