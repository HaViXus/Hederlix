package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import jdk.nashorn.internal.objects.annotations.SpecializedFunction;

public class Explosion 
{

	public float x;
	public float y;
	public int ID;
	public float textureTimer;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public boolean isDangerous;
	public boolean isEnd;
	public Rectangle hitBox;
	public int tmpID = 0;
	public int angle;
	public float speed;
	
	public int frame;
	
	public Explosion(Texture texture, float x, float y, int ID)
	{
		
		this.x = x;
		this.y = y;
		this.ID = ID;
		region = new TextureRegion(texture);
		sprite = new Sprite();
		frame = 0;
		if(ID == 1)
		{	
			isDangerous = false;	
			sprite.setBounds(x, y, 48, 48);
		}
		else if(ID == 2)
		{
				
			isDangerous = false;	
			sprite.setBounds(x, y, 48, 48);
			
		}
		else if(ID == 3)
		{
				
			isDangerous = true;	
			sprite.setBounds(x, y, 48, 48);
			speed = 80;
			hitBox = new Rectangle();
			hitBox.set(x+3, y+3, 42 , 42);
			
		}
		
		else if(ID == 4)
		{
				
			isDangerous = false;	
			sprite.setBounds(x, y, 96, 96);
			speed = 200;
			hitBox = new Rectangle();
			hitBox.set(x+3, y+3, 42 , 42);
			
		}
		
		else if(ID == 5)
		{
				
			isDangerous = false;	
			sprite.setBounds(x, y, 192, 192);
			speed = 200;
			hitBox = new Rectangle();
			hitBox.set(x+3, y+3, 42 , 42);
			
		}
		
		region.setRegion(8, 10, 1, 1);	
		sprite.setRegion(region);
		
	}
	
	public void explosionHandling(float FPS)
	{
		
		textureTimer += Gdx.graphics.getDeltaTime();
		frame = (int)(textureTimer*25);
		
		if(ID == 1)
		{
			if(frame > 11) isEnd = true;
			if(isEnd == false)
			{		
				region.setRegion(0 + 16*frame, 0, 16, 16);	
				sprite.setRegion(region);
			}
			
			
		}
		else if(ID == 2)
		{
			if(frame > 11) isEnd = true;
			if(isEnd == false)
			{		
				region.setRegion(0 + 16*frame, 32, 16, 16);	
				sprite.setRegion(region);
			}
			
			
		}
		else if(ID == 3)
		{
			if(frame > 14) isEnd = true;
			if(isEnd == false)
			{		
				region.setRegion(0 + 16*frame, 48 + 16 * tmpID, 16, 16);	
				x += speed * (float) Math.cos((angle* Math.PI/180.0))/FPS;
				y += speed * (float) Math.sin((angle* Math.PI/180.0))/FPS;
				hitBox.set(x+3, y+3, 42 , 42);
				sprite.setRegion(region);
				sprite.setPosition(x,y);
			}
		}
		else if(ID == 4 || ID == 5)
		{
			if(frame > 14) isEnd = true;
			if(isEnd == false)
			{		
				region.setRegion(0 + 16*frame, 48 + 16 * tmpID, 16, 16);	
				x += speed * (float) Math.cos((angle* Math.PI/180.0))/FPS;
				y += speed * (float) Math.sin((angle* Math.PI/180.0))/FPS;
				hitBox.set(x+3, y+3, 42 , 42);
				sprite.setRegion(region);
				sprite.setPosition(x,y);
			}
		}
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
	
	
	
}
