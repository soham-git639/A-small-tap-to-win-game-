import javax.swing.*;
import javax.swing.Timer;

//import java.util.*;


import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements ActionListener,KeyListener {
    int bordWidth = 600;
    int bordHight = 300;
    int ballDiameter = 20;
    int ballY=150;
    int ballX = 300;

    public class Ball{
        int x;
        int y;
        Ball(int x , int y){
            this.x=x;
            this.y=y;
            
        }
    }
    Ball ball;
    //velocity
    int VelocityX;
    int accelaration=0;
    Timer gameLoop;
    Boolean gameOver = false;
    int player1Score = 0;
    int player2Score = 0;

    
    Game(){
        setPreferredSize(new Dimension(bordWidth, bordHight));
        setBackground(Color.black);
        ball = new Ball(5,5);
        addKeyListener(this);
        setFocusable(true);

        VelocityX = 0;
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
         
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
        g.setColor(Color.green);
        g.drawLine(50,0,50,600);
        g.setColor(Color.ORANGE);
        g.drawLine(550,0,550,600);
        //score 
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN , 15));

        g.drawString("Right plyer: " + String.valueOf((double) player1Score),10,40);
        g.drawString("Left plyer: " + String.valueOf((double) player2Score),500,40);
        if(gameOver){
            if(ballX < 45){
                g.drawString("Left player win",200,150);
            }
            else if(ballX >= 540){
                g.drawString("Right player win",200,150);
            }
            
        }


    }
    public void move(){
        ballX += VelocityX;
        if(ballX <= 45 || ballX >= 540){
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      repaint();
      move();
      if(gameOver){
        gameLoop.stop();
      }
    }

    @Override
    public void keyPressed(KeyEvent e){
          
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            
            accelaration = accelaration + 1;
            player1Score = player1Score + 1;
            VelocityX = Math.min(accelaration,50);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            
            accelaration = accelaration + 1;
            player2Score = player2Score + 1;
            VelocityX = -(Math.min(accelaration,50));

        }
        
    }



    @Override
    public void keyTyped(KeyEvent arg0) {
       
    }
    
}
