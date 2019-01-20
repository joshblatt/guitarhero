import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DifficultySelect extends JPanel
{
    //Diffiulty buttons
    Button easy = new Button (250, 25, 100, 50, 2, 1,  "Easy", "");
    Button medium = new Button (250, 100, 100, 50, 2, 2,  "Medium", "");
    Button hard = new Button (250, 175, 100, 50, 2, 3,  "Hard", "");
    Button extreme = new Button (250, 250, 100, 50, 2, 4,  "Extreme", "");
    
    @Override
    public void paintComponent(Graphics g)//Draw function
    {
	//Back ground
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	
	//Draw all buttons
	easy.draw(g);
	medium.draw(g);
	hard.draw(g);
	extreme.draw(g);
    }
    public void update()//Update function
    {
	//Update all buttons
	easy.update();
	medium.update();
	hard.update();
	extreme.update();
    }
}
