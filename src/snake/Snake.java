/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/*
 * @author Martu
 */
public class Snake {
    /*Declaramos un array con LinkedList porque de esa forma podemos modificar elementos de ese array en cualquier posición */
    LinkedList <Rectangle> snake = new LinkedList();
    int lado=10;
    int body=5;
    char mov; /* Aqui almacenamos hacia donde se va a ir la serpiente */
    boolean crece;
    int xCabeza;
    int yCabeza;
    /*Constructor de la serpiente */
    Snake()
    {
        int x=150;
        int y=150;
        /* Creamos el cuerpo de la serpiente, para ello debemos crear un bucle que nos recorra la cantidad de cuadros que tiene
         * nuestra serpiente.
         */
        for(int i=0; i<body;i++)
        {
            Rectangle r = new Rectangle(x,y,lado, lado);
            snake.add(r);
            y+=10;
        }
        /* Si no come no crece: " LAS GALLINAS QUE ENTRAN POR LAS QUE SALEN " */
        crece=false;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.blue);
        for (int i=0;i<body;i++)
        {
            Rectangle r = snake.get(i);
            if (i == 0){
                xCabeza=r.x;
                yCabeza=r.y;
            }
            g.fillRect(r.x, r.y, r.width, r.height);
        }
    }
    
    /* Escribimos los comandos de dirección */
    public void left()
    {
        /*Seleccionamos el rectángulo del principio y lo retocamos */
        Rectangle r = new Rectangle(snake.getFirst());
       
        r.x-=lado;
        if(r.x<0)
        {
            r.x=300-lado;
        }
        /* Tenemos que borrar el último si no crece porque hemos dibujado uno nuevo */
        if(!crece)
        {
            snake.removeLast(); 
        }
        snake.add(0,r);
    }
    public void right()
    {
        /*Seleccionamos el rectángulo del principio y lo retocamos */
        Rectangle r = new Rectangle(snake.getFirst());
        r.x+=lado;
        if(r.x>300)
        {
            r.x=0;
        }
        /* Tenemos que borrar el último si no crece porque hemos dibujado uno nuevo */
        if(!crece)
        {
            snake.removeLast(); 
        }
        snake.add(0,r);
    }
    /*CUIDADO: Cuando subimos, el margen superior es 0px de alto y el inferior 300px de alto al inverso */
    public void up()
    {
        /*Seleccionamos el rectángulo del principio y lo retocamos */
        Rectangle r = new Rectangle(snake.getFirst());
        r.y-=lado;
        if(r.y<0)
        {
            r.y=300-lado;
        }
        /* Tenemos que borrar el último si no crece porque hemos dibujado uno nuevo */
        if(!crece)
        {
            snake.removeLast(); 
        }
        snake.add(0,r);
    }
    public void down()
    {
        /*Seleccionamos el rectángulo del principio y lo retocamos */
        Rectangle r = new Rectangle(snake.getFirst());
        r.y+=lado;
        if(r.y > 300)
        {
            r.y=0;
        }
        /* Tenemos que borrar el último si no crece porque hemos dibujado uno nuevo */
        if(!crece)
        {
            snake.removeLast(); 
        }
        snake.add(0,r);
    }
    public char getMov() {
        return mov;
    }

    public void setMov(char mov) {
        this.mov = mov;
    }

    public int getxCabeza() {
        return xCabeza;
    }

    public void setxCabeza(int xCabeza) {
        this.xCabeza = xCabeza;
    }

    public int getyCabeza() {
        return yCabeza;
    }

    public void setyCabeza(int yCabeza) {
        this.yCabeza = yCabeza;
    }
    
}
