package Elements.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class playerWeapon extends Rectangle
{

	public Texture texture;
	public TextureRegion region;
	public float textureTimer;
	public Sprite sprite;
	public int frame;
	
	public boolean isActivated;
	public boolean end;
	public int direction; //1 - left, 2 - right
	public int ID;
	
	public Rectangle hitBox;
	
	
	public playerWeapon(Texture texture, int ID)
	{
		this.ID = ID;
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();
		hitBox.height = 6;
		isActivated = false;
		
	}
	
	public void setCoord(float playerX, float playerY, boolean isJump, int direction)
	{
		
		
		if(isJump == false)
		{
			if(direction == 2)
			{
				this.x = playerX+ 48 * (1+ID);
				hitBox.width = 3 * (int)(textureTimer*100.0);
				hitBox.x = x;
				
			}
			else
			{
				this.x = playerX - 48 * (1+ID);
				hitBox.width = 3 * (int)(textureTimer*100.0);
				hitBox.x = x-3 * (int)(textureTimer*100.0) + 48;
				
			}
			
			this.y = playerY+27;
		}
		else
		{
			if(direction == 2) 
			{
				this.x = playerX + 48 * (1+ID); 
				hitBox.width = 3 * (int)(textureTimer*100.0);
				hitBox.x = x;
				
			}
			else 
			{
				this.x = playerX- 48 * (1+ID);
				hitBox.width = 3 * (int)(textureTimer*100.0);
				hitBox.x = x-3 * (int)(textureTimer*100.0)  + 48;
				
			}
			
			this.y = playerY+33;
		}
		
		hitBox.y = y + 3;
		
		
	
	}
	
	public void setPlayerDirection(int playerDirection)
	{
		
		direction = playerDirection;
		
	}
	
	public void handlingWeapon(int direction)
	{
		if(ID == 0)
		{
			if(isActivated == true && textureTimer < 0.16)
			{
				
				textureTimer += Gdx.graphics.getDeltaTime();
				if(textureTimer >= 0.17) textureTimer = 0.17f;
				frame = (int)(textureTimer*100.0);
				int textureY = frame/16;
				frame = frame %16;
				if(direction == 2) region.setRegion(0 + 16* frame,0 + 16 * textureY,16,16);
				else region.setRegion(0 + 16* frame,32 + 16 * textureY,16,16);
				
			}
			if(isActivated == false)
			{
				textureTimer =0;
			}
		}
		
		else if(ID == 1)
		{
			if(isActivated == true && textureTimer < 0.15)
			{
				end = false;
				textureTimer += Gdx.graphics.getDeltaTime();
				frame = (int)(textureTimer*100.0);
				int textureY = frame/16;
				if(direction == 2) region.setRegion(0 + 16* frame,0 + 16 * textureY,16,16);
				else region.setRegion(0 + 16* frame,32 + 16 * textureY,16,16);
				
				
			}
			else if(isActivated == true && textureTimer >=0.15)
			{
				isActivated = false;
				textureTimer =0;
				end = true;
			}
		}
		
		
		sprite.setRegion(region);
		
	}
	
	public Sprite getTexture()
	{
		
		sprite.setBounds(x, y, 48, 48);
		return sprite;
		
	}
	
	
}
