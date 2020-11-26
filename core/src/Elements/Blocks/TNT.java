package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class TNT 
{

	public float x;
	public float y;
	public int ID;
	public float textureTimer;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public Rectangle hitBox;
	
	public boolean isActivated = false;
	public float explodeTimer;
	
	public int tmpX, tmpY;

	
	public TNT(Texture texture, int x, int y, int ID)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
		this.texture = texture;
		region = new TextureRegion(texture);
		
		if(ID == 111) region.setRegion(16, 160, 16, 16);
		else if(ID == 112) region.setRegion(16, 144, 16, 16);
		
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		isActivated = false;
		
		
		int WindowX = (int)(x / 1296);
		int WindowY = 0;
		if(y >= 0) WindowY = -(int)(y/720);
		else WindowY = -(int)(y/720) + 1;
		
		int windowWidth = 27;
		int windowHeight = 15;
		
		tmpX = (x / 48) - WindowX*windowWidth;
		tmpY = (windowHeight-1) - ((y/48) + WindowY*windowHeight) ;
		//if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((y)/48.0))  - 14*WindowY;
		//else  tmpY = (windowHeight) - ((int) ((y)/48.0))  - 15*WindowY;
		
		hitBox = new Rectangle();
		hitBox.set(x,y,48,48);
	}
	
	public void handlingTNT()
	{
		if(isActivated == true) explodeTimer += Gdx.graphics.getDeltaTime();
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
