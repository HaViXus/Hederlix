package Sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicEffect
{

	public Music sound;
	public long ID;
	
	public float volume, startVolume;
	public float downTimer, growTimer;
	public boolean isDowning;
	public boolean isGrowing;
	
	public MusicEffect(Music sound, float volume)
	{
		
	  this.volume = volume * 0.25f;
	  this.sound =sound;
	  this.sound.setVolume(this.volume);
	  this.sound.setLooping(true);
	  this.sound.play();

	  isDowning = false;
	  isGrowing = false;
	}
	
	public void setDowning(boolean isDowning)
	{
		this.isDowning = isDowning;
		startVolume = sound.getVolume();
	}
	
	public void setGrowing(boolean isGrowing, float startVolume)
	{
		this.isGrowing = isGrowing;
		this.startVolume = startVolume;
	}
	
	public void downingHandling()
	{
		if(isDowning == true)
		{
			if(downTimer < 4) downTimer += Gdx.graphics.getDeltaTime();
			if(downTimer > 4) downTimer = 4;
			volume = startVolume -(startVolume * (downTimer/4.0f));
			if(volume<0) volume = 0;
			this.sound.setVolume(volume);
			
		}
	}
	
	public void growingHandling()
	{
		if(isGrowing == true)
		{
			if(growTimer < 4) growTimer += Gdx.graphics.getDeltaTime();
			if(growTimer > 4) growTimer = 4;
			volume = startVolume * (growTimer/4.0f);
			this.sound.setVolume(volume);
		}
	}
	
	public void dispose()
	{
		
		sound.stop();
        sound.dispose();
		
	}
	
}
