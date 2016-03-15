//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
   private final int PANEL_WIDTH = 600;
   private final int PANEL_HEIGHT = 600;

   private final double SQ = Math.sqrt(253.0) / 6;

   private final int TOPX = 200, TOPY = 20;
   private final int LEFTX = 60, LEFTY = 300;
   private final int RIGHTX = 340, RIGHTY = 300;

   private double thetaLeft = 30;
   private double thetaRight = 30;
   private double ratio = .8;
   
   private int current; //current order

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
  

   public void drawFractal (int order, int startX1, int startY1, double length, double theta, double theta2, Graphics page)
   {
       length = length*ratio;
       
       //left branches
       page.drawLine((int)(startX1 - length*Math.sin(theta + order*thetaLeft)), (int)(startY1 + length*Math.cos(theta + order*thetaLeft)));
       
       //right branches
       page.drawLine((int)(startX1 + length*Math.sin(theta + order*thetaLeft)), (int)(startY1 + length*Math.cos(theta + order*thetaLeft)));
       order++;
       double theta1 = theta + thetaLeft;
       double theta2 = theta - thetaLeft; 
       
       int x2 = (int) startX1 - length*Math.sin(theta + order*thetaLeft);
       int y2 = (int) startY1 + length*Math.cos(theta - order*thetaLeft);
       drawFractal(order, x2, y2, length, theta1, page);
       
       int x3 = (int) startX1 + length*Math.sin(theta + order*thetaLeft);
       int y3 = (int) startY1 + length*Math.cos(theta - order*thetaLeft);
       drawFractal(order, x3, y3, length, theta2, page);
       
   }
   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      drawFractal (current, TOPX, TOPY, LEFTX, LEFTY, page);
      drawFractal (current, LEFTX, LEFTY, RIGHTX, RIGHTY, page);
      drawFractal (current, RIGHTX, RIGHTY, TOPX, TOPY, page);
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
