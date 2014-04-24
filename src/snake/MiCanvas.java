/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author Martu
 */
public class MiCanvas extends Canvas implements KeyListener
{
    Snake snake;
    Comida manzana;
    int contador;
    MiCanvas(Snake snake, Comida manzana)
    {
        this.setBackground(Color.BLACK);
        this.setBounds(50, 50, 300, 300); /*Medidas para colocar la serpiente*/
        this.snake=snake;
        this.manzana = manzana;
        this.addKeyListener(this);
    }

    public void paint(Graphics g)
    {
        BufferedImage imagen = new BufferedImage (this.WIDTH, this.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        int a = manzana.getX()-5;
        int b = manzana.getX()+5;
        int c = manzana.getY()-5;
        int d = manzana.getY()+5;
        if(snake.getxCabeza()> a && snake.getxCabeza()< b && snake.getyCabeza() > c && snake.getyCabeza() < d ){
            /* Si chocan creamos una nueva manzana que asignamos a la anterior */
            Comida m = new Comida();
            manzana = m;
            m.draw(g);
            manzana.comido= true;
            snake.body++;
        } 
        snake.draw(g);
        manzana.draw(g);
        
        g.drawImage(imagen,0,0,this);
    }
 @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
            }
    public void actionPerformed(ActionEvent e) {
                Timer comida = (Timer)e.getSource();

        if(snake.getMov()== 'L'){
            snake.left();
            repaint();
        }
        if(snake.getMov()== 'R'){
            snake.right();
            repaint();
        }
        if(snake.getMov()== 'U'){
            snake.up();
            repaint();
        }
        if(snake.getMov()== 'D'){
            snake.down();
            repaint();
        }

    }
}
