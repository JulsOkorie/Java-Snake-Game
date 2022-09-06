package snakegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class GameClass implements KeyListener{
    
    private SnakeClass player;
    private FoodClass food;
    private Graphics graphics;
    
    private JFrame window;
    
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;
    
    public GameClass() {
        window = new JFrame();
        
        player = new SnakeClass();
        food = new FoodClass(player);
        graphics = new Graphics(this);
        
        window.add(graphics);
        
        window.setTitle("Snake Game");
        window.setSize(width * dimension + 2, height * dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    //starting the game function
    public void startingTheGame() {
        graphics.state = "RUNNING";
    }
    
    //update the status of the game when it is running or not
    public void update() {
        if (graphics.state == "RUNNING") {
            if (check_food_collision()) {
                player.grow();food.random_spawn(player);
            }
            else if (check_wall_collision() || check_self_collision()) {
                graphics.state = "END";
            }
            else {
                player.move();
            }
        }
    }
    
    //method to ensure that when a player is killed off, he dies.
    //this method checks for collision against the wall, food, and head(body) of the snake. 
    //that is if the body of the snake touches its head(body), wall, or food.
    
    public boolean check_wall_collision() {
        if(player.getX() < 0 || player.getX() >= width * dimension || 
                player.getY() < 0 || player.getY() >= height * dimension) {
            return true;
        }
        return false;
    }
    
    public boolean check_food_collision() {
    if(player.getX() == food.getX() * dimension &&  
                player.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }
    
    public boolean check_self_collision() {
        for(int i =  1; i < player.getBody().size(); i++) {
            if(player.getX() == player.getBody().get(i).x &&
                    player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        //if keyboard is pressed
        if (graphics.state == "RUNNING") {
            //move up
            if(keyCode == KeyEvent.VK_W)  { 
                player.up();
            }
            //move down
            else if(keyCode == KeyEvent.VK_S)  {  
                player.down();
            }
            //move left
            else if(keyCode == KeyEvent.VK_A) {  
                player.left();
            }
            //move right
            else{
                player.right();
             }
        } 
        else {
            this.startingTheGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }
    
    public SnakeClass getPlayer() {
        return player;
    }
    
     public void setPlayer(SnakeClass player) {
        this.player = player;
    }
     
     public FoodClass getFood() {
        return food;
    }
     
     public void setFood(FoodClass food) {
        this.food = food;
    }
     
      public JFrame getWindow() {
        return window;
    }
      
      public void setWindow(JFrame window) {
        this.window = window;
    }
    
    
}
