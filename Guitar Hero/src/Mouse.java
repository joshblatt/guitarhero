import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{
    private boolean mouseClick;//Boolean to see if the mouse is clicked
    private int x, y;
    @Override
    public void mouseClicked(MouseEvent e)
    {
	
    }

    @Override
    public void mousePressed(MouseEvent e)//Function if mouse is pressed
    {
	mouseClick = true;//Set mouse click to true
	x = e.getX();//Get the x value of the mouse
	y = e.getY();//Get the y value of the mouse
    }

    @Override
    public void mouseReleased(MouseEvent e)//If mouse is realased
    {
	mouseClick = false;//Set mouse click to false
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
	
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
	
    }
    public boolean isPressed()//Function to see if the mouse is clicked
    {
	return mouseClick;
    }
    public int returnX()//Function to return x of mouse
    {
	return x;
    }
    public int returnY()//Function to return y of mouse
    {
	return y;
    }

}
