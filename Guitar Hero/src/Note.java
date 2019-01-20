import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Note
{
    private int x, y, size, speed;//Integers for x, y, size, and speed
    private Color color;//Color of note
    //Set all of the key presses to false
    private boolean pressed1 = false;
    private boolean pressed2 = false;
    private boolean pressed3 = false;
    private boolean pressed4 = false;
    private boolean pressed5 = false;
    
    private Note notes [][] = Game.getNotes();//Array of notes with their positions
    private boolean noteOverlap = false;//Set note overlap to false
    
    //Initialize all of the variables 
    public Note (int x, int y, int size, int speed, Color color)
    {
	this.x = x;
	this.y = y;
	this.size = size;
	this.speed = speed;
	this.color = color;
    }
    public Color getColor()//Function to get the color
    {
	return color;
    }
    public int getX ()//Function to get x
    {
	return x;
    }
    public int getY()//Function to get y
    {
	return y;
    }
    public int getSpeed()//Function to get speed
    {
	return speed;
    }
    public void setColor(Color newColor)//Function to set the color
    {
	color = newColor;
    }
    public void setX(int newX)//Function to set x
    {
	x = newX;
    }
    public void setY(int newY)//Function to set y
    {
	y = newY;
    }
    public void setSpeed(int newSpeed)//Function to set speed
    {
	speed = newSpeed;
    }
    public boolean overlap ()//Function to check for overlap
    {
	if (y >= 425 && y <= 525)//If overlapping
	{
	    return true;//Return true
	}
	return false;//Otherwise return false
    }
    public void notesOverlap()//Function to check to see if notes are overlapping with each other
    {
	do
	{
	    noteOverlap = false;//Default note overlap to false
	    for (int i = 0; i < notes[0].length; i++)//Loop through notes
	    {
		//If any of the notes are overlapping in any of the rows
		if (x == 75 && Math.abs(notes[0][i].getY() - y) <= 50 && Math.abs(notes[0][i].getY() - y) != 0)
		    noteOverlap = true;
		else if (x == 175 && Math.abs(notes[1][i].getY() - y) <= 50 && Math.abs(notes[1][i].getY() - y) != 0)
		    noteOverlap = true;
		else if (x == 275 && Math.abs(notes[2][i].getY() - y) <= 50 && Math.abs(notes[2][i].getY() - y) != 0)
		    noteOverlap = true;
		else if (x == 375 && Math.abs(notes[3][i].getY() - y) <= 50 && Math.abs(notes[3][i].getY() - y) != 0)
		    noteOverlap = true;
		else if (x == 475 && Math.abs(notes[4][i].getY() - y) <= 50 && Math.abs(notes[4][i].getY() - y) != 0)
		    noteOverlap = true;
		    
		if (noteOverlap)//If notes are overlapping
		{
		    y = -size - (int)(Math.random() * 600);//Rerandomize y
		}	
	    }
	} while(noteOverlap);//Continue to run this while notes are overlapping
    }
    public void draw (Graphics g)//Draw function
    {
	//Draw note of correct color
	g.setColor(color);
	g.fillOval(x, y, size, size);
    }
    public void update()//Update function
    {
	int randomSize = 600;//Range of numbers for random y values
	
	y += speed;//Increase y by speed each frame
	if (y > 600)//If a note is off the screen
	{
	    y = -size - (int)(Math.random() * randomSize);//Randomize y
	    notesOverlap();//Check for note overlap
	    GuitarHero.decreaseScore();//Decrease score
	}
	
	//If 1 is pressed, the color of the note is green, and it is in the correct zone
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_1) && color.equals(Color.GREEN) && overlap())
	{
	    if (!pressed1)//If 1 is not pressed
	    {
		pressed1 = true;//1 is now pressed

		if (overlap())//If it is in the correct zone
		{
		    y = -size - (int)(Math.random() * randomSize);//Randomize y
		    notesOverlap();//Check for note overlap
		    GuitarHero.increaseScore();//Increase score
		}
		else//If not in the correct zone
		{
		    GuitarHero.decreaseScore();//Decrease score
		}
	    }
	} 
	else//If 1 is already pressed
	{
	    pressed1 = false;//Set pressed 1 to false
	}
	
	//If 2 is pressed, the color of the note is red, and it is in the correct zone
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_2) && color.equals(Color.RED) && overlap())
	{
	    if (!pressed2)//If 2 is not pressed
	    {
		pressed2 = true;//2 is now pressed

		if (overlap())//If it is in the correct zone
		{
		    y = -size - (int)(Math.random() * randomSize);//Randomize y
		    notesOverlap();//Check for note overlap
		    GuitarHero.increaseScore();//Increase score
		}
		else//If not in the correct zone
		    GuitarHero.decreaseScore();//Decrease score
	    }
	} 
	else//If 2 is already pressed
	{
	    pressed2 = false;//Set pressed 2 to false
	}
	
	//If 3 is pressed, the color of the note is yellow, and it is in the correct zone
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_3) && color.equals(Color.YELLOW) && overlap())
	{
	    if (!pressed3)//If 3 is not pressed
	    {
		pressed3 = true;//3 is now pressed
		
		if (overlap())//If it is in the correct zone
		{
		    y = -size - (int)(Math.random() * randomSize);//Randomize y
		    notesOverlap();//Check for note overlap
		    GuitarHero.increaseScore();//Increase score
		}
		else//If not in the correct zone
		    GuitarHero.decreaseScore();//Decrease score
	    }
	} 
	else//If 3 is already pressed
	{
	    pressed3 = false;//Set pressed 3 to false
	}
	
	//If 4 is pressed, the color of the note is blue, and it is in the correct zone
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_4) && color.equals(Color.BLUE) && overlap())
	{
	    if (!pressed4)//If 4 is not pressed
	    {
		pressed4 = true;//4 is now pressed
		
		if (overlap())//If it is in the correct zone
		{
		    y = -size - (int)(Math.random() * randomSize);//Randomize y
		    notesOverlap();//Check for note overlap
		    GuitarHero.increaseScore();//Increase score
		}
		else//If not in the correct zone
		    GuitarHero.decreaseScore();//Decrease score
	    }
	} 
	else//If 4 is already pressed
	{
	    pressed4 = false;//Set pressed 4 to false
	}
	
	//If 5 is pressed, the color of the note is orange, and it is in the correct zone
	if (GuitarHero.getKeyListener().isPressed(KeyEvent.VK_5) && color.equals(Color.ORANGE) && overlap())
	{
	    if (!pressed5)//If 5 is not pressed
	    {
		pressed5 = true;//5 is now pressed
		
		if (overlap())//If it is in the correct zone
		{
		    y = -size - (int)(Math.random() * randomSize);//Randomize y
		    notesOverlap();//Check for note overlap
		    GuitarHero.increaseScore();//Increase score
		}
		else//If not in the correct zone
		    GuitarHero.decreaseScore();//Decrease score
	    }
	} 
	else//If 5 is already pressed
	{
	    pressed5 = false;//Set pressed 5 to false
	}
    }

}
