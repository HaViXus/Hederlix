package Sound;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundEffect 
{

	public Music sound;
	public long ID;
	
	public SoundEffect(Music sound, float volume)
	{
	  this.sound =sound;
	  this.sound.setVolume(volume);
	  this.sound.play();
	  
	  
	  
	}
	
	public void dispose()
	{
		sound.stop();
		sound.dispose();
		
	}
	
	
}
