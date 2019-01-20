import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SongList extends JPanel
{
    int width = 125;//Width of button
    int height = 50;//Height of button
    
    Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 50);
    
    //All of the song buttons
    
    Button theAdventure = new Button(25, 100, width, height, 1, -1,  "The Adventure", "res/TheAdventure.aiff");
    Button elderlyWoman = new Button(25, 175, width, height, 1, -1,  "Elderly Woman", "res/ElderlyWoman.aiff");
    Button noDiggity = new Button(25, 250, width, height, 1, -1,  "No Diggity", "res/NoDiggity.aiff");
    Button getUp = new Button(25, 325, width, height, 1, -1,  "Get Up", "res/GetUp.aiff");
    Button harryPotter = new Button(25, 400, width, height, 1, -1,  "Harry Potter Remix", "res/HarryPotterRemix.aiff");
    Button cliffsOfDover = new Button(25, 475, width, height, 1, -1,  "Cliffs of Dover", "res/CliffsOfDover.aiff");
    
    
    Button hoops = new Button(165, 100, width, height, 1, -1,  "Hoops", "res/Hoops.aiff");
    Button mrBrightside = new Button(165, 175, width, height, 1, -1,  "Mr. Brightside", "res/MrBrightside.aiff");
    Button scarlettsHand = new Button(165, 250, width, height, 1, -1,  "Scarlett's Hand", "res/ScarlettsHand.aiff");
    Button theChain = new Button(165, 325, width, height, 1, -1,  "The Chain", "res/TheChain.aiff");
    Button heartless = new Button(165, 400, width, height, 1, -1,  "Heartless", "res/Heartless.aiff");
    Button blackBetty = new Button(165, 475, width, height, 1, -1,  "Black Betty", "res/BlackBetty.aiff");
    
    Button brainStew = new Button(305, 100, width, height, 1, -1,  "Brain Stew", "res/BrainStew.aiff");
    Button crazyTrain = new Button(305, 175, width, height, 1, -1,  "Crazy Train", "res/CrazyTrain.aiff");
    Button eyeOfTheTiger = new Button(305, 250, width, height, 1, -1,  "Eye Of The Tiger", "res/EyeOfTheTiger.aiff");
    Button feelGoodInc = new Button(305, 325, width, height, 1, -1,  "Feel Good Inc", "res/FeelGoodInc.aiff");
    Button hereIGoAgain = new Button(305, 400, width, height, 1, -1,  "Here I Go Again", "res/HereIGoAgain.aiff");
    Button one = new Button(305, 475, width, height, 1, -1,  "One", "res/One.aiff");
    
    Button knightsOfCydonia = new Button(445, 100, width, height, 1, -1,  "Knights of Cydonia", "res/KnightsOfCydonia.aiff");
    Button kashmir = new Button(445, 175, width, height, 1, -1,  "Kashmir", "res/Kashmir.aiff");
    Button plush = new Button(445, 250, width, height, 1, -1,  "Plush", "res/Plush.aiff");
    Button paperPlanes = new Button(445, 325, width, height, 1, -1,  "Paper Planes", "res/PaperPlanes.aiff");
    Button stolenDance = new Button(445, 400, width, height, 1, -1,  "Stolen Dance", "res/StolenDance.aiff");
    Button theMetal = new Button(445, 475, width, height, 1, -1,  "The Metal", "res/TheMetal.aiff");
    
    @Override
    public void paintComponent(Graphics g)//Draw function
    {
	//Background
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 600, 600);
	
	//Draw Title
	g.setColor(Color.white);
	g.setFont(f);
	g.drawString("Guitar Hero", 155, 65);
	
	//Draw all the buttons
	theAdventure.draw(g);
	elderlyWoman.draw(g);
	noDiggity.draw(g);
	getUp.draw(g);
	harryPotter.draw(g);
	cliffsOfDover.draw(g);
	
	hoops.draw(g);
	mrBrightside.draw(g);
	scarlettsHand.draw(g);
	theChain.draw(g);
	heartless.draw(g);
	blackBetty.draw(g);
	
	brainStew.draw(g);
	crazyTrain.draw(g);
	eyeOfTheTiger.draw(g);
	feelGoodInc.draw(g);
	hereIGoAgain.draw(g);
	one.draw(g);
	
	knightsOfCydonia.draw(g);
	kashmir.draw(g);
	plush.draw(g);
	paperPlanes.draw(g);
	stolenDance.draw(g);
	theMetal.draw(g);
	
    }
    public void update()//Update function
    {
	//Update all buttons
	
	theAdventure.update();
	elderlyWoman.update();
	noDiggity.update();
	getUp.update();
	harryPotter.update();
	cliffsOfDover.update();
	
	hoops.update();
	mrBrightside.update();
	scarlettsHand.update();
	theChain.update();
	heartless.update();
	blackBetty.update();
	
	brainStew.update();
	crazyTrain.update();
	eyeOfTheTiger.update();
	feelGoodInc.update();
	hereIGoAgain.update();
	one.update();
	
	knightsOfCydonia.update();
	kashmir.update();
	plush.update();
	paperPlanes.update();
	stolenDance.update();
	theMetal.update();
    }
}
