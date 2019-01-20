import javax.swing.JFrame;

public class GuitarHero
{
    private static JFrame frame;//Main JFrame
    private static int gameState;//Controls which scene is being displayed
    private static boolean running;//Boolean to see if the game is running
    private static Game game;//Game object
    private static SongList songList;//Song list object
    private static DifficultySelect difficultySelect;//Difficulty select object
    private static Results results;//Results object
    private static Keys keyListener;//Key listener 
    private static Mouse mouseListener;//Mouse listener
    private static int score, difficulty;//Integers for the score and difficulty
    private static String songFilePath;//String for the song's filepath

    public static void main(String[] args)
    {
	running = true;//Set running to true (so the game runs)
	score = 0;//Set score to 0
	difficulty = 2;//Set difficulty to medium
	songFilePath = "";//Set song filepath to nothing
	
	// JFrame
	frame = new JFrame();//Initialize frame
	frame.setTitle("Guitar Hero");//Set title
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Exit program on close
	frame.setLocationRelativeTo(null);//Turn off relative location
	frame.setResizable(false);//Make the frame not resizable
	frame.setSize(600, 600);//Set frame to 600 x 600

	// JPanel
	songList = new SongList();//Initialize song list
	difficultySelect = new DifficultySelect();//Initialize difficulty select
	game = new Game();//Initialize game
	results = new Results();//Initialize results
	
	keyListener = new Keys();//Initialize key listener
	mouseListener = new Mouse();//Initialize mosue listener
	
	frame.add(songList);//Add songlist to frame (the default frame)
	
	frame.addKeyListener(keyListener);//Add key listener to panel
	frame.addMouseListener(mouseListener);//Add mouse listener to panel

	frame.setVisible(true);//Make frame visible

	int frameRate = 60;//Set frame rate to 60 frames / second
	
	gameState = 0;//Set gamestate to 0 (the song list screen)
	
	// Game Loop
	while (running)//While the game is running
	{
	    if (gameState == 0)//If gamestate is 0
		songList.update();//Update song list
	    else if (gameState == 1)//If gamestate is 1
		difficultySelect.update();//UPdate difficulty select
	    else if (gameState == 2)//If gamestate is 2
		game.update();//Update game
	    else if (gameState == 3)//If gamestate is 3
		results.update();//Update results
	    frame.repaint();//Repaint frame
	    
	    try
	    {
		Thread.sleep(1000 / frameRate);//Set framerate to 60 fps
	    } 
	    catch (InterruptedException e)
	    {
		e.printStackTrace();
	    }
	}
    }
    
    public static Keys getKeyListener()//Function to obtain key listener
    {
	return keyListener;
    }
    public static Mouse getMouseListener()//Function to get mouse listener 
    {
	return mouseListener;
    }

    public static void setGameState(int newGameState)//Function to set a new gamestate (change the scene)
    {
	gameState = newGameState;//Set gamestate to the new gamestate
	
	//Remove everything from the scene
	frame.remove(songList);
	frame.remove(difficultySelect);
	frame.remove(game);
	frame.remove(results);	
	
	if (gameState == 0)//If gamestate is 0
	{
	    songList = new SongList();//Initialize song list
	    frame.add(songList);//Add songlist to frame
	}
	else if (gameState == 1)//If gamestate is 1
	{
	    difficultySelect = new DifficultySelect();//Initialize difficulty select
	    frame.add(difficultySelect);//Add difficulty select to frame
	}
	else if (gameState == 2)//If gamestate is 2
	{
	    game = new Game();//Initialize game
	    frame.add(game);//Add game to frame
	}
	else if (gameState == 3)//If gamestate is 3
	{
	    results = new Results();//Initialize results 
	    frame.add(results);//Add results to frame
	}
	
	frame.setVisible(true);//Make frame visible
	frame.repaint();//Repaint frame
	
    }
    public static int getGameState()//Function to obtain the current gamestate
    {
	return gameState;
    }
    public static void increaseScore()//Function to increase the score
    {
	score++;
    }
    public static void decreaseScore()//Function to decrease the score
    {
	score--;
    }
    public static int getScore ()//Function to get the score
    {
	return score;
    }
    public static void resetScore()//Function to reset the score
    {
	score = 0;
    }
    public static int getDifficulty ()//Function to get the current difficulty
    {
	return difficulty;
    }
    public static void setDifficulty (int newDifficulty)//Function to set the difficulty
    {
	difficulty = newDifficulty;
    }
    public static String getSong()//Function to get the current song
    {
	return songFilePath;
    }
    public static void setSong(String newSongFilePath)//Function to change the song
    {
	songFilePath = newSongFilePath;
    }

}
