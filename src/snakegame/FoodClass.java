package snakegame;

import java.awt.Rectangle;

/**
 *
 * @author Juliet
 */
public class FoodClass {
     
    private int x;
    private int y;
    
    
    public FoodClass(SnakeClass player) {
        this.random_spawn(player);
    }
    
    //generating the food randomly inside the game box
    public void random_spawn(SnakeClass player) {
        
        boolean onSnake = true;
        
        while(onSnake) {
            onSnake = false;
            x = (int)(Math.random()* GameClass.width- 1);
            y = (int)(Math.random()* GameClass.height- 1);
            
            //going through all rectangles on the player's body and checking if x and y is inside the box
            for (Rectangle r : player.getBody()) {  
                if(r.x == x && r.y == y) {
                    onSnake = true;     
                 }        
            }  
        }
    }
    
    public int getX() {
        return x;
    }
    
     public void setX(int x) {
        this.x = x;
    }
     
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
}

