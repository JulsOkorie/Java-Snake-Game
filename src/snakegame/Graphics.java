package snakegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{

    private Timer t = new Timer(100, this);
    public String state;
    
    private SnakeClass snake;
    private FoodClass food;
    private GameClass game;
    
    public Graphics(GameClass g) {
        t.start();
        state = "START";
        
        game =  g;
        snake = g.getPlayer();
        food = g.getFood();
        
        //add a keyListener to the game
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }
    
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        
        Graphics2D grap2D = (Graphics2D) g;
        
                
        //box color
        grap2D.setColor(Color.MAGENTA);
        grap2D.fillRect(0, 0, GameClass.width * GameClass.dimension + 5,
                GameClass.height * GameClass.dimension + 5);

        
        if(state == "START") {
            grap2D.setColor(Color.white);
            grap2D.drawString("Press Any Key", GameClass.width/2 * GameClass.dimension - 40, 
                    GameClass.height/2 * GameClass.dimension - 20);
        }
        else if(state == "RUNNING") {
            //food color
            grap2D.setColor(Color.cyan);
            grap2D.fillOval(food.getX() * GameClass.dimension, food.getY() * GameClass.dimension, GameClass.dimension, GameClass.dimension);

            //snake color
            grap2D.setColor(Color.yellow);
            //to draw every single body part of the snake
            for(Rectangle r : snake.getBody()) {
                grap2D.fill(r);
            }
        }   
        else {
            grap2D.setColor(Color.white);
            grap2D.drawString("Your Score: " + (snake.getBody().size() - 3), 
                    GameClass.width/2 * GameClass.dimension - 40, 
                    GameClass.height/2 * GameClass.dimension - 20);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      repaint();
      game.update();
    }
    
}
