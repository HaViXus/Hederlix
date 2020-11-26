package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.renderers.IsometricStaggeredTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

public class pulsingBlock 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	public int tmpX, tmpY;
	
	public float alphaTime;
	public float solidTimer;
	public float maxStableTime;
	public float rTimer;
	public int phase; //1-is Show Stable, 2 - is Show Disappearing, 3 - isn't Show Stable 4 - isn't show appearing 
	public boolean isSolid, canShow, wasShow;

	
	
	public pulsingBlock(Texture texture,int x, int y, int ID)
	{
		this.texture = texture;	
		this.x = x;
		this.y = y;
		this.ID = ID;
		
		region = new TextureRegion(texture);
		sprite = new Sprite();
		hitBox = new Rectangle();
		
		
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
		
		alphaTime = 1f;
		
		if(ID == 131 || ID == 132)
		{
			maxStableTime = 1f;
			region.setRegion(96,128,16,16);
		}
		else if(ID == 133 || ID == 134)
		{
			maxStableTime = 0.5f;
			region.setRegion(112,128,16,16);
		}
		
		
		sprite.setRegion(region);
		
		isSolid = true;
		canShow = false;
		wasShow = false;
		if(ID %2 == 1) 
		{
			phase = 1;
			sprite.setColor(1,1,1,1);
		}
		else
		{
			phase = 3;
			sprite.setColor(1,1,1,0);
		}
		
		
	}
	
	public void pulsingBlockHandling()
	{
		
		if(rTimer < maxStableTime) rTimer += Gdx.graphics.getDeltaTime();
		if(rTimer > maxStableTime) rTimer = maxStableTime;
		
		float mnoznik = 1 / maxStableTime;
		
		if(rTimer >= maxStableTime && phase != 3)
		{
			phase ++;
			rTimer = 0;
		}
		else if( rTimer >= maxStableTime && phase == 3 && canShow == true)
		{
			phase ++;
			rTimer = 0;
		}
		
		if(phase > 4)
		{
			phase = 1;
			rTimer = 0;
		}
		
		if(phase == 1)
		{
			isSolid = true;
			
		}
		
		else if(phase == 2) 
		{
			sprite.setColor(1,1,1,1-rTimer * mnoznik);
		}
		else if(phase == 3)
		{
			isSolid = false;
		}
		else if(phase == 4)
		{
			isSolid = true;
			canShow = false;
			sprite.setColor(1,1,1,rTimer * mnoznik);
		}
		
	
			
		
		
		
	}
	
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
	
}
