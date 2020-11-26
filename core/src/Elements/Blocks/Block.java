package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Block 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	public float textureTimer;
	
	private int frame;
	
	public Block(Texture texture)
	{
		this.texture = texture;	
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();
		
		
		region.setRegion(64,16,1,1);
		sprite.setRegion(region);
		
	}
	
	public void set(int x, int y, int ID)
	{
		
		
		this.x = x;
		this.y = y;
		this.ID = ID;
		sprite.setBounds(x, y, 48, 48);
	    
	    hitBox.x = x;
	    hitBox.y = y;
	    hitBox.width = 48;
	    hitBox.height = 48;
		
		
		setTexture();
		
		
	}
	
	public void setTexture()
	{
		
		if(ID%2 == 1)
		{
			
			if(ID<16)region.setRegion(0,0 + 16 * (int)(ID/2),16,16);
			else if(ID >16 && ID <32) region.setRegion(32,0 + 16 * (int)((ID%17)/2),16,16);
			else if(ID >32 && ID <40) region.setRegion(64,64 + 16 * (int)((ID%33)/2),16,16);
			else if(ID >40 && ID <48) region.setRegion(96,64 + 16 * (int)((ID%41)/2),16,16);
			else if(ID >48 && ID <56) region.setRegion(128,64 + 16 * (int)((ID%49)/2),16,16);
			else region.setRegion(64,16,1,1);
          
				
		}
		else
		{
			
			if(ID<=16)region.setRegion(16,0 + 16 * (int)((ID-1)/2),16,16);
			else if(ID >16 && ID <=32) region.setRegion(48,0 + 16 * (int)((ID%17)/2),16,16);
			else if(ID >32 && ID <=40) region.setRegion(80,64 + 16 * (int)((ID%33)/2),16,16);
			else if(ID >40 && ID <=48) region.setRegion(112,64 + 16 * (int)((ID%41)/2),16,16);
			else if(ID >48 && ID <=56) region.setRegion(144,64 + 16 * (int)((ID%49)/2),16,16);
			else region.setRegion(64,16,1,1);
					   

				
			
		}	
		
		
			
		
		
		
		sprite.setRegion(region);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
