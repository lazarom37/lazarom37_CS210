// CS210 Assignment #3 "Circles"
// Marcus Lazaro
//This is the drawing circles assignment accompanied with the DrawingPanel.java file

import java.awt.*;

public class Illusion {
    public static void main(String[] args) {
        // This first part sets up the new window + canvas size, background color, and drawing pen
        DrawingPanel panel = new DrawingPanel(500,400);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();

        //3 figures, the ones without the grey boxes.
        //Integer values: Canvas positions values in x and y, size of figure, # of circles drawing within figure, type of graphics
        drawFigures(0, 0, 90, 3, g);
        drawFigures(120, 0, 90, 3, g);
        drawFigures(250, 50, 80, 5, g);

        //3 figures, the ones with the gray 1:1 boxes.
        //Integer values: Canvas positions values in x and y, size of figure, # of circles drawing within figure, rows/column amount, type of graphics
        drawBoxed(10, 120, 100, 10, 2, g);      //2 x 2
		drawBoxed(350, 20, 40, 5, 3, g);        //3 x 3
		drawBoxed(230, 160, 50, 5, 4, g);       //4 x 4
    }
    public static void drawFigures(int x, int y, int size, int figures, Graphics g) {
        //Uses inputted values from method call to determine size, sets colors of drawn figure
        g.setColor(Color.yellow);       //Fill color
        g.fillOval(x, y, size, size);
        g.setColor(Color.black);        //Line color

        //Draws the circles "int figures" times (the fourth value the method call makes, the one before "g")
        for (int i = 0; i < figures; i++) {
            g.drawOval(x + i * (size / figures / 2), y + i * (size / figures / 2), size - i * (size / figures), size - i * (size/figures));
        }
        //Draws the diamond-shape with four lines
        g.drawLine(x + size / 2, y, x, y + size / 2);
		g.drawLine(x, y + size / 2, x + size / 2, y + size);
		g.drawLine(x + size / 2, y + size, x + size, y + size / 2);
		g.drawLine(x + size, y + size / 2, x + size / 2, y);
    }
    public static void drawBoxed(int x, int y, int size, int figures, int dimensions, Graphics g){
        //This first part is for the boxed background of the figures
        g.setColor(Color.lightGray);                                //Determines color of box
        g.fillRect(x, y, size * dimensions, size * dimensions);     //Fills box with assigned color
        g.setColor(Color.black);                                    //Determines Line color of box
        g.drawRect(x, y, size * dimensions, size * dimensions);     //Draws box's line with assigned color
        
        //Calls the drawFigures method to fill in the appropriate number of figures within the boxed background, based on value of dimensions
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                drawFigures(x + j * size, y, size, figures, g);
            }
            y += size;
        }
    }
}