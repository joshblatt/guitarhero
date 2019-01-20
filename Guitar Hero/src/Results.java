import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Results extends JPanel
{
    //Song list button
    Button songList = new Button (250, 450, 100, 50, 0, -1, "New Song", "");
    @Override
    public void paintComponent(Graphics g)//Draw function
    {
	//Backgroud
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	
	//Score
	g.setColor(Color.white);
	drawCenteredString(g, "Score: " + GuitarHero.getScore(), new Rectangle(250, 250, 100, 100), getFont());
	
	//Draw songlist button
	songList.draw(g);
    }
    public void update()//Update function
    {
	songList.update();//Update button
    }
    
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) 
    {
	// Get the FontMetrics
	FontMetrics metrics = g.getFontMetrics(font);
	// Determine the X coordinate for the text
	int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	// Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	// Set the font
	g.setFont(font);
	// Draw the String
	g.drawString(text, x, y);
    }
}
