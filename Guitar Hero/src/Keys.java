import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener
{
    
    private boolean[] keys = new boolean[65535];

    public void keyTyped(KeyEvent e)
    {
	
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
	keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
	keys[e.getKeyCode()] = false;
    }
    

    public boolean isPressed(int keyCode) 
    {
	return keys[keyCode];
    }

}
