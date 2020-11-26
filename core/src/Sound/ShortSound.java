package Sound;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class ShortSound
{

	public Sound sound;
	public float timer;
	
	public ShortSound(Sound sound, float volume)
	{
		this.sound =sound;
		this.sound.play(volume);
	}
	
	 public void handling()
	 {
		 timer += Gdx.graphics.getDeltaTime();
	 }
	  
	
	
	public void dispose()
	{
		//this.sound.stop();
		//sound.dispose();
		
	}
	
	
}
