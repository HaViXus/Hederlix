package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class disappearingBlock 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	

	public float textureTimer;
	public float maxTime;
	public boolean isActivated;
	public boolean isBreak;
	public int tmpX, tmpY;
	
	public disappearingBlock(Texture texture, int x, int y, int ID)
	{
		this.texture = texture;	
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();
		
		this.x = x;
		this.y = y;
		this.ID = ID;
		sprite.setBounds(x, y, 48, 48);
		
		int WindowX = (int)(x / 1296);
		int WindowY = 0;
		if(y >= 0) WindowY = -(int)(y/720);
		else WindowY = -(int)(y/720) + 1;
		
		int windowWidth = 27;
		int windowHeight = 15;
		
		tmpX = (x / 48) - WindowX*windowWidth;
		tmpY = (windowHeight-1) - ((y/48) + WindowY*windowHeight) ;
	    
	    hitBox.x = x;
	    hitBox.y = y;
	    hitBox.width = 48;
	    hitBox.height = 48;
		
	    isActivated = false;
	    isBreak = false;
		
		if(ID == 128)
		{
			maxTime = 1.5f;
			region.setRegion(64,48,16,16);
		}
		else if(ID == 129)
		{
			maxTime = 1;
			region.setRegion(80,48,16,16);
		}
		else if(ID == 130)
		{
			maxTime = 0.5f;
			region.setRegion(160,48,16,16);
		}
		
        sprite.setRegion(region);
		
	}
	
	public void disappearingBlockHandling()
	{
		
		if(isActivated == true)
		{
			textureTimer += Gdx.graphics.getDeltaTime();
			if(ID == 128)
			{
				sprite.setColor(1,1,1,1 - (textureTimer/1.5f));
			}
			else if(ID == 129)
			{
				sprite.setColor(1,1,1,1 - textureTimer);
			}
			else if(ID == 130)
			{
				sprite.setColor(1,1,1,1 - textureTimer*2.0f);
			}
			
			if(textureTimer > maxTime) isBreak = true;
			
			
		}
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
	
}
