package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class greenBlock 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	
	public int tmpX, tmpY;
	public boolean isActivated;
	
	public greenBlock(Texture texture, int x, int y)
	{
		this.texture = texture;	
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();
		
		this.x = x;
		this.y = y;

		sprite.setBounds(x, y, 48, 48);
		
		int WindowX = (int)(x / 1296);
		int WindowY = 0;
		if(y >= 0) WindowY = -(int)(y/720);
		else WindowY = -(int)(y/720) + 1;
		
		int windowWidth = 27;
		int windowHeight = 15;
		
		tmpX = (x / 48) - WindowX*windowWidth;
		if(WindowY == 0) tmpY = (windowHeight-1) - ((y/48) + WindowY*windowHeight);
		else tmpY = (windowHeight-1) - ((y/48) + WindowY*windowHeight);
		
		
	    
	    hitBox.x = x;
	    hitBox.y = y;
	    hitBox.width = 48;
	    hitBox.height = 48;
		
	    isActivated = true;
	    
	    region.setRegion(0,144,16,16);
	    sprite.setRegion(region);
	    
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
