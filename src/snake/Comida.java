package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/*
 * @author Martu
 */
public class Comida {

    LinkedList<Rectangle> manzana = new LinkedList();
    /* Hacemos esta fórmula para evitar que salgan posiciones tipo: 235 o 148, 
    * que la serpiente no podría pasar por ella. Al multiplicar por 30, y luego a diez
    * el número siempre va a ser entero.
    */
        int x;
        int y;
        boolean comido = false;

    public boolean isComido() {
        return comido;
    }

    public void setComido(boolean comido) {
        this.comido = comido;
    }

    /* Posición de la manzana en pantalla */
    public Comida() {
        this.x=(int)((Math.random()*30)*10);
        this.y=(int)((Math.random()*30)*10);
        Rectangle r = new Rectangle (x,y,10,10);
        manzana.add(r);
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
        
public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(x, y, 10, 10);
    }
}

