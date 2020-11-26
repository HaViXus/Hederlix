package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Checkpoint 
{

	public float x, y;
	public boolean isActivated;
	public int windowX, windowY;
	
	public Sprite sprite;
	public Texture texture;
	public TextureRegion region;
	
	public Rectangle hitBox;
	
	public Checkpoint(Texture texture,int x, int y) 
	{
		
		this.x = x;
		this.y= y;
		this.texture = texture;
		
		region = new TextureRegion(texture);
		region.setRegion(96,48,16,16);
		
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		
		windowX = x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		hitBox = new Rectangle();
		hitBox.set(x, y, 48, 48);
		isActivated = false;
		
	}
	
	public void handling()
	{
		
		if(isActivated == true) region.setRegion(112,48,16,16);
		else region.setRegion(96,48,16,16);
		sprite.setRegion(region);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;	
	}
	
}
