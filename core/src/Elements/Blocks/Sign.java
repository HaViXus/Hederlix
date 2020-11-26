package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Sign 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	public int windowX, windowY;
	
	public float textureTimer;
	
	private int frame;
	
	public Sign(Texture texture, int x, int y, int ID)
	{
		
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.texture = texture;	
		region = new TextureRegion(texture);
		region.setRegion(80,128,16,16);
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		hitBox = new Rectangle();
		hitBox.set(x, y, 48, 48);
		
		windowX = x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
       
	}
	
	public Sprite getTexture()
	{
		
		return sprite;
		
	}
	
	
}
