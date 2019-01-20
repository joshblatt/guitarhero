import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class Button extends JPanel
{
    private int x, y, w, h, newGameState, difficulty;//Integers for x, y, w, h, the new game state, and the difficulty
    private String message, filepath;//String for message
    private boolean mousePressed = false;//Boolean to see if the mouse is presseed
    private AudioPlayer song = new AudioPlayer();//Audio player for the song
    
    //Intialize variables
    public Button (int x, int y, int w, int h, int newGameState, int difficulty, String message, String filepath)
    {
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
	this.newGameState = newGameState;
	this.difficulty = difficulty;
	this.message = message;
	this.filepath = filepath;
    }
    public void draw(Graphics g)//Draw function for button
    {
	//Draw rectangle for button
	g.setColor(Color.CYAN);
	g.drawRect(x, y, w, h);
	
	//Draw centered text with the mesage
	drawCenteredString(g, message, new Rectangle(x, y, w, h), getFont());
    }
    public void update()//Update function
    {
	if (GuitarHero.getMouseListener().isPressed())//If the mouse is pressed
	{
	    if (!mousePressed)//If the mouse is not currently pressed
	    {
		//If the mouse is within the button
		if (GuitarHero.getMouseListener().returnX() >= x && GuitarHero.getMouseListener().returnX() <= x + w && GuitarHero.getMouseListener().returnY() >= y + 25 && GuitarHero.getMouseListener().returnY() <= y + h + 25)
		{
		    
		    mousePressed = true;//Set mouse pressed to true
		    if (difficulty == -1)//If it is a song button
		    {
			GuitarHero.setSong(filepath);//Set the song to the file path
		    }
		    else//If it is a difficulty button
		    {
			GuitarHero.setDifficulty(difficulty);//Set difficulty
			song.play(GuitarHero.getSong());//Play current song
		    }
		    GuitarHero.setGameState(newGameState);//Set new game state
		}
	    }  
	}
	else//If the mouse is pressed
	{
	    mousePressed = false;//Set mouse pressed to false
	}
	
    }
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) //Function to draw centered text
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
