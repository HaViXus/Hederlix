package Elements;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class cloud
{

	public float x,y;
	public int ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
    public float textureTimer;
	
	private int frame;
	private float speedY;
	public boolean isEnd;
	
	
	
	public cloud(Texture texture, float x, float y, int ID)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
		this.texture = texture;	
		
		region = new TextureRegion(texture);
		sprite = new Sprite();

		region.setRegion(0,96,16,16);
		sprite.setRegion(region);
		
		sprite.setBounds(x, y, 48, 48);
		speedY = 10 + 20 * new Random().nextFloat();
	    
		
	}
	
	
	public void cloudsHandling()
	{		
		float FPS = Gdx.graphics.getDeltaTime();
		
		textureTimer += Gdx.graphics.getDeltaTime();
		frame = (int)(textureTimer*10);
		if(frame > 5) isEnd = true;
		
		y += speedY*FPS;
		
		region.setRegion(0 + 16*frame,96 + 16*ID,16,16);
		sprite.setRegion(region);
		sprite.setPosition(x, y);
		
		
	}
	
	public Sprite getTexture()
	{
		
		return sprite;
		
	}
	
	
	
	
}
