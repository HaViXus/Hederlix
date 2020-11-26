package Elements.Blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class BlockButton
{

	public int x,y;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	public boolean isActivated, wasActivated; 
	public float textureTimer;
	public int frame;
	
	public int objectNumber;
	public int ID;
	
	public BlockButton(Texture texture, int x, int y, int ID)
	{
		this.texture = texture;	
		this.ID = ID;
		region = new TextureRegion(texture);
		
		if(ID == 122)region.setRegion(144, 16, 16, 16);
		else if(ID == 136) region.setRegion(144, 32, 16, 16);
			
		
		
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		hitBox = new Rectangle();
		hitBox.set(x,y,48,48);
		
		
		isActivated = false;
		wasActivated = false;
	}
	
	public void setObjectNumber(int number)
	{
		objectNumber = number;
	}
	
	public void textureHandling()
	{
		
		if(isActivated == true) 
		{	
			if(ID == 122) region.setRegion(160 , 16, 16, 16);
			else if(ID == 136) region.setRegion(160 , 32, 16, 16);
			sprite.setRegion(region);
		}
		
	}
	
	public Sprite getTexture()
	{
		
		return sprite;
		
	}
	
}
