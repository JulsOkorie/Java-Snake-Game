package snakegame;

import java.awt.Rectangle;
import java.util.ArrayList;

public class SnakeClass {
    private ArrayList<Rectangle> body;
    private int width = GameClass.width;
    private int height = GameClass.height;
    private int dimension = GameClass.dimension;
    
    private String move; //NOTHING, UP, DOWN, LEFT, RIGHT
    
    
    public SnakeClass() {
        body = new ArrayList<>();
        
        Rectangle temp = new Rectangle(GameClass.dimension, GameClass.dimension);
        temp.setLocation(GameClass.width/2 * GameClass.dimension, GameClass.height/2 * GameClass.dimension);
        body.add(temp);
        
        temp = new Rectangle(dimension, dimension);
        temp.setLocation((width/2- 1) * dimension, (height/2) * dimension);
        body.add(temp);
        
        temp = new Rectangle(dimension, dimension);
        temp.setLocation((width/2- 2) * dimension, (height/2) * dimension);
        body.add(temp);
        
        move = "NOTHING";
    }
    
    
    public void move() {
        if(move != "NOTHING") {
            Rectangle first = body.get(0);
            Rectangle rect = new Rectangle(GameClass.dimension, GameClass.dimension);
            
            if(move == "UP") {
                rect.setLocation(first.x, first.y - GameClass.dimension);
            }
            else if (move == "DOWN") {
                rect.setLocation(first.x, first.y + GameClass.dimension);
            }
            
            else if (move == "LEFT") {
                rect.setLocation(first.x - GameClass.dimension, first.y);
            }
            
            else  {
                rect.setLocation(first.x + GameClass.dimension, first.y);
            }
            
            body.add(0, rect);
            body.remove(body.size() - 1);
        }
    }
    
    public void grow() {
            Rectangle first = body.get(0);
            Rectangle rect = new Rectangle(GameClass.dimension, GameClass.dimension);

            if(move == "UP") {
                rect.setLocation(first.x, first.y - GameClass.dimension);
            }
            else if (move == "DOWN") {
                rect.setLocation(first.x, first.y + GameClass.dimension);
            }
            
            else if (move == "LEFT") {
                rect.setLocation(first.x - GameClass.dimension, first.y);
            }
            
            else  {
                rect.setLocation(first.x + GameClass.dimension, first.y);
            }
            
            body.add(0, rect);
    }
    
    public ArrayList<Rectangle> getBody() {
        return body;
    }
    
    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }
    
    public int getX() {
        return body.get(0).x;
    }
    
     public int getY() {
        return body.get(0).y;
    }
    
    public void up(){
        if(move != "DOWN") {
            move = "UP";
        }
    }
    public void down(){
        if(move != "UP") {
             move = "DOWN";
        }
    }
    public void left(){
        if(move != "RIGHT") {
             move = "LEFT";
        }
    }
    public void right(){
        if(move != "LEFT") {
             move = "RIGHT";
        }
    }
    
}
