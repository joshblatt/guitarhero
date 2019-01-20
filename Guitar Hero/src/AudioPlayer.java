import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer implements LineListener 
{

    private Clip audioClip;

    public void play(String audioFilePath) //Function to play song
    {
	File audioFile = new File(audioFilePath);

	try 
	{
	    AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // Get file as stream
	    AudioFormat format = audioStream.getFormat(); // Get format
	    DataLine.Info info = new DataLine.Info(Clip.class, format); // Get data info

	    audioClip = (Clip) AudioSystem.getLine(info); // Initialize clip
	    audioClip.addLineListener(this); // Set listener
	    audioClip.open(audioStream); // Open stream
	} 
	catch (UnsupportedAudioFileException e) 
	{
	    System.out.println("The specified audio file is not supported.");
	    e.printStackTrace();
	} 
	catch (LineUnavailableException e) 
	{
	    System.out.println("The audio line for playing back is unavailable.");
	    e.printStackTrace();
	} 
	catch (IOException e) 
	{
	    System.out.println("An error occured playing the audio file.");
	    e.printStackTrace();
	}
		
	audioClip.start(); // Start
    }
	
    public boolean isPlaying()//Function to see if audio is played
    {
	return audioClip.isOpen();
    }
	
    public void stop() //Function to stop song
    {
	audioClip.close();
    }
	
    @Override
    public void update(LineEvent e) //Update function
    {
	LineEvent.Type type = e.getType();
		
	if (type == LineEvent.Type.START) 
	{
	    //System.out.println("Playback started.");
	} 
	else if (type == LineEvent.Type.STOP) 
	{
	    //audioClip.close();
	    //System.out.println("Playback completed.");
	    GuitarHero.setGameState(3);
	}
    }

}