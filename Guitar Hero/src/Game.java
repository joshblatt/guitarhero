import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Game extends JPanel
{
    
    private static Note notes[][];//Array of notes
    int score = 0;//Score 
    
    //Booleans for each key
    private boolean pressed1 = false;
    private boolean pressed2 = false;
    private boolean pressed3 = false;
    private boolean pressed4 = false;
    private boolean pressed5 = false;
	
    //Booleans to see if notes are overlapping in each column
    private boolean anyOverlap1 = false;
    private boolean anyOverlap2 = false;
    private boolean anyOverlap3 = false;
    private boolean anyOverlap4 = false;
    private boolean anyOverlap5 = false;
    
    private MissedNote missedNote = new MissedNote();
    
    public Game()
    {
	notes = new Note[5][GuitarHero.getDifficulty() + 1];//Initialize notes
	
	GuitarHero.resetScore();//Reset score
	
	int space = 100;//Integer for spaces between notes
	int initialDistance = 75;//Integer for space between first note and the side of the frame
	for (int row = 0; row < notes.length; row++)//Loop through rows
	{
	    for(int col = 0; col < notes[row].length; col++)//Loop through columns
	    {
		if (notes[row][col] == null)//If the current note is not initialized
		    notes[row][col] = new Note(75, 50, 50, 1, Color.green);//Initialize it (this will change later)
		
		 if (row == 0)//If it is the first row
		 {
		     notes[row][col].setColor(Color.green);//Set the color to green
		 }
		 else if (row == 1)//if it is the second row
		 {
		     notes[row][col].setColor(Color.red);//Set the color to red
		 }
		 else if (row == 2)//If it is the third row
		 {
		     notes[row][col].setColor(Color.yellow);//Set the color to yellow
		 }
		 else if (row == 3)//If it is the fourth row
		 {
		     notes[row][col].setColor(Color.blue);//Set the color to blue
		 }
		 else if (row == 4)//If it is the fifth row
		 {
		     notes[row][col].setColor(Color.orange);//Set the color to red
		 }
		 
		 notes[row][col].setX(space * row + initialDistance);//Initialize x values
		 notes[row][col].setY(-(space * row + initialDistance));//Intialize y values
		 notes[row][col].setSpeed(GuitarHero.getDifficulty());//Initialize speed of notes based on difficulty
	    }
	}
	
    }
    @Override
    public void paintComponent(Graphics g)//Function to paint components
    {
	//Background
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);

	//Strings of guitar
	g.setColor(Color.white);
	g.drawLine(100, 0, 100, 600);
	g.drawLine(200, 0, 200, 600);
	g.drawLine(300, 0, 300, 600);
	g.drawLine(400, 0, 400, 600);
	g.drawLine(500, 0, 500, 600);
	
	//Draw each note
	for(int row = 0; row < notes.length; row++)
	{
	    for(int col = 0; col < notes[row].length; col++)
		notes[row][col].draw(g);
	}
	
	
	//Display score
	g.setColor(Color.WHITE);
	drawCenteredString(g, GuitarHero.getScore() + "", new Rectangle(25, 25, 25, 25), g.getFont());
	
	//Display area where notes should be pressed
	g.drawLine(0, 500, 600, 500);
	g.drawOval(475, 475, 50, 50);
	g.drawOval(375, 475, 50, 50);
	g.drawOval(275, 475, 50, 50);
	g.drawOval(175, 475, 50, 50);
	g.drawOval(75, 475, 50, 50);
    }

    public String randomMissedNote()
    {
	int num = (int)(Math.random() * 6);
	if (num == 0)
	    return "res/MissedNote1.aiff";
	else if (num == 1)
	    return "res/MissedNote2.aiff";
	else if (num == 2)
	    return "res/MissedNote3.aiff";
	else if (num == 3)
	    return "res/MissedNote4.aiff";
	else if (num == 4)
	    return "res/MissedNote5.aiff";
	else
	    return "res/MissedNote6.aiff";
	
    }

    public void update()//Update function
    {
	
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_1))//If 1 is pressed
	{
	    if (!pressed1)//If 1 isn't currently pressed
	    {
		pressed1 = true;//Set 1 is pressed to true
		for (int i = 0; i < notes[0].length; i++)//Loop through notes of row one
		{
		    if (notes[0][i].overlap())//If any notes are overlapping
		    {
			anyOverlap1 = true;//Set any overlap to true
		    }
		}
	    	if (!anyOverlap1)//If no notes are overlapping
	    	{
		    GuitarHero.decreaseScore();//Decrease the score (the user missed)
		    missedNote.play(randomMissedNote());//Play missed note sound
	    	}
	    }
	}
	else
	{
	    pressed1 = false;//Reset pressed1 to false (so it doesn't spam)
	    anyOverlap1 = false;//Reset any overlap 1 to false
	}
	
	
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_2))//If 2 is pressed
	{
	    if(!pressed2)//If 2 isn't currently pressed
	    {
		pressed2 = true;//Set 2 is pressed to true
		for (int i = 0; i < notes[1].length; i++)//Loop through notes of row two
		{
		    if (notes[1][i].overlap())//If any notes are overlapping
			anyOverlap2 = true;//Set any overlap to true
		}
		if (!anyOverlap2)//If no notes are overlapping
		{
		    GuitarHero.decreaseScore();//Decrease the score (the user missed)
		    missedNote.play(randomMissedNote());//Play missed note sound
		}
	    }
	}
	else
	{
	    pressed2 = false;//Reset pressed2 to false (so it doesn't spam)
	    anyOverlap2 = false;//Reset any overlap 2 to false
	}
	
	
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_3))//If 3 is pressed
	{
	    if (!pressed3)//If 3 isn't currently pressed
	    {
		pressed3 = true;//Set 3 is pressed to true
		for (int i = 0; i < notes[2].length; i++)//Loop through notes of row three
		{
		    if (notes[2][i].overlap())//If any notes are overlapping
		    anyOverlap3 = true;//Set any overlap to true
		}
		if (!anyOverlap3)//If no notes are overlapping
		{
		    GuitarHero.decreaseScore();//Decrease the score (the user missed)
		    missedNote.play(randomMissedNote());//Play missed note sound
	    	}
	    }
	}
	else
	{
	    pressed3 = false;//Reset pressed3 to false (so it doesn't spam)
	    anyOverlap3 = false;//Reset any overlap 3 to false
	}
	
	
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_4))//If 4 is pressed
	{
	    if (!pressed4)//If 4 isn't currently pressed
	    {
		pressed4 = true;//Set 4 is pressed to true
		for (int i = 0; i < notes[3].length; i++)//Loop through notes of row four
		{
		    if (notes[3][i].overlap())//If any notes are overlapping
			anyOverlap4 = true;//Set any overlap to true
		}
		if (!anyOverlap4)//If no notes are overlapping
		{
		    GuitarHero.decreaseScore();//Decrease the score (the user missed)
		    missedNote.play(randomMissedNote());//Play missed note sound
		}
	    }
	}
	else
	{
	    pressed4 = false;//Reset pressed4 to false (so it doesn't spam)
	    anyOverlap4 = false;//Reset any overlap 4 to false
	}
	
	
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_5))//If 5 is pressed
	{
	    if (!pressed5)//If 5 isn't currently pressed
	    {
		pressed5 = true;//Set 5 is pressed to true
		for (int i = 0; i < notes[4].length; i++)//Loop through notes of row five
		{
		    if (notes[4][i].overlap())//If any notes are overlapping
		    anyOverlap5 = true;//Set any overlap to true
		}
		if (!anyOverlap5)//If no notes are overlapping
		{
		    GuitarHero.decreaseScore();//Decrease the score (the user missed)
		    missedNote.play(randomMissedNote());//Play missed note sound
		}
	    }
	}
	else
	{
	    pressed5 = false;//Reset pressed5 to false (so it doesn't spam)
	    anyOverlap5 = false;//Reset any overlap 5 to false
	}
	
	for(int row = 0; row < notes.length; row++)
	{
	    for(int col = 0; col < notes[row].length; col++)
		notes[row][col].update();//Update all notes
	}
	
	
    }
    
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font)//Function to draw centered text
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
    public static Note[][] getNotes()//Function to get all the notes (positions, etc)
    {
	return notes;
    }
}
