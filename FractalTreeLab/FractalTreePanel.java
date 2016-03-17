//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
   private final int PANEL_WIDTH = 1800;
   private final int PANEL_HEIGHT = 1500;
   private Graphics2D page; 

   private final int startX = 650, startY = 180;
   private final double startLength = 200;
   private double thetaLeft = 30.0;
   private double thetaRight = 40.0;
   private double ratio = .8;
   private int current;
   private int counter=0;
   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public FractalTreePanel (int currentOrder)
   { 
      
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
  

   public void drawFractal (double startX1, double startY1, double length, double theta, Graphics2D page)
   {
       length = length*ratio;
       if (length < 3)
       {
           return;
       }
       //left angle
       double theta2 = theta - thetaLeft;
       
       //right angle
       double theta3 = theta + thetaRight; 
       
       double x2 = startX1 + length*Math.sin(Math.toRadians(theta2));
       double y2 = startY1 + length*Math.cos(Math.toRadians(theta2));
       
       double x3 = startX1 + length*Math.sin(Math.toRadians(theta3));
       double y3 = startY1 + length*Math.cos(Math.toRadians(theta3));
       
       //left branches
       page.draw(new Line2D.Double(startX1, startY1, x2, y2));
       
       //right branches
       page.draw(new Line2D.Double(startX1, startY1, x3, y3));
       
       counter++;
       if(counter%13 == 0)
       {
           page.setColor (Color.blue);
       }
       else if (counter%13 == 1)
       {
           page.setColor (Color.cyan);
       }
       else if (counter%13 == 2)
       {
           page.setColor (Color.gray);
       }
       else if(counter%13 == 3)
       {
           page.setColor (Color.green);
       }
       else if(counter%13 == 4)
       {
           page.setColor (Color.magenta);
       }
       else if (counter%13 == 5)
       {
           page.setColor (Color.pink);
       }
       else if(counter%13 == 6)
       {
           page.setColor (Color.white);
       }
       else if(counter%13 == 7)
       {
           page.setColor (Color.orange);
       }
       else if (counter%13 == 8)
       {
           page.setColor (Color.yellow);
       }
       else if(counter%13 == 9)
       {
           page.setColor (Color.lightGray);
       }
       else if(counter%13 == 10)
       {
           page.setColor (Color.darkGray);
       }
       else if (counter%13 == 11)
       {
           page.setColor (Color.black);
       }
       else if(counter%13 == 12)
       {
           page.setColor (Color.red);
       }
      
       drawFractal(x2, y2, length, theta2, page);
       drawFractal(x3, y3, length, theta3, page);
   }
   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics graphics)
   {
      Graphics2D page = (Graphics2D) graphics;
      super.paintComponent(page);

      page.setColor (Color.red);

      page.draw(new Line2D.Double(startX, startY, startX, startY + startLength));
      drawFractal(startX, startY + startLength, startLength, 0, page);
      
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
