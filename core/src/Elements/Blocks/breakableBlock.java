package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class breakableBlock
{
	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	public int HP,frame;
	public float immortalTimer;
	
	
	public breakableBlock(Texture texture, int x, int y, int ID)
	{
		this.texture = texture;	
		this.x = x;
		this.y = y;
		this.ID = ID;
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();

		sprite.setBounds(x, y, 48, 48);
	    
	    hitBox.x = x;
	    hitBox.y = y;
	    hitBox.width = 48;
	    hitBox.height = 48;
		
		
		setProperties();
	}
	
	private void setProperties()
	{
		immortalTimer = 2;
		if(ID == 125)
		{
			HP = 5;
			region.setRegion(0,128,16,16);
		}
		else if(ID == 126)
		{
			HP = 10;	
			region.setRegion(32,144,16,16);
		}
		else if(ID == 127)
		{
			HP = 50;	
			region.setRegion(64,144,16,16);
		}
	   
		sprite.setRegion(region);
	}
	
	public void breakableBlockHandling()
	{
		if(immortalTimer < 0.15) immortalTimer += Gdx.graphics.getDeltaTime();
		if(ID == 125)
		{
		     region.setRegion(0 + 16* (5-HP), 128,16,16);
		}
		else if(ID == 126)
		{
			if(immortalTimer>= 0.15) region.setRegion(32,144,16,16);
			else region.setRegion(48,144,16,16);
		}
		else if(ID == 127)
		{
			if(immortalTimer>= 0.15) region.setRegion(64,144,16,16);
			else region.setRegion(80,144,16,16);
		}
		
		sprite.setRegion(region);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
