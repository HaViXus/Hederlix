package Boss;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class bossMisc 
{

	
	public int life, maxLife;
	
	public Texture texture;
	public TextureRegion region;
	
	public ArrayList<Sprite> spriteBackground;
	public Sprite spriteLife;
	
	private int tmpX;
	private int sizeScale = 9;
	
	
	public bossMisc(Texture texture)
	{
		
		this.texture = texture;
		region = new TextureRegion(texture);
		spriteBackground = new ArrayList<Sprite>();
		
	}
	
	public void Create(int maxLife)
	{
		
		this.maxLife = maxLife;
		life = maxLife;
		
		tmpX = (int)(636 - (maxLife*sizeScale)/2);
		
		//background left
		region.setRegion(32,70,4,10);
		spriteBackground.add(0, new Sprite(region));
		spriteBackground.get(0).setBounds(tmpX, 0, 4 * sizeScale, 10 * sizeScale);
		//background middle
		region.setRegion(36,70,4,10);
		spriteBackground.add(0, new Sprite(region));
		spriteBackground.get(0).setBounds(tmpX + 4 * sizeScale, 0, maxLife * sizeScale, 10*sizeScale);
		//background right
		region.setRegion(40,70,4,10);
		spriteBackground.add(0, new Sprite(region));
		spriteBackground.get(0).setBounds(tmpX + 4 * sizeScale + maxLife * sizeScale, 0, 4 * sizeScale, 10 * sizeScale);
		
		region.setRegion(48,76,1,4);
		spriteLife = new Sprite(region);
		spriteLife.setBounds(tmpX + 4 * sizeScale, 0 + 3 * sizeScale, maxLife * sizeScale, 4 * sizeScale);
		
	}
	
	public void bossMiscHandling(int life)
	{
		this.life = life;
		
		if(life<0) life = 0;
		spriteLife.setBounds(tmpX + 4 * sizeScale, 0 + 3 * sizeScale, life * sizeScale, 4 * sizeScale);
		
	}
	
	public void draw(SpriteBatch miscBatch)
	{
		if(life>0)
		{
			for(int i=0;i<spriteBackground.size();i++) spriteBackground.get(i).draw(miscBatch);
			spriteLife.draw(miscBatch);
		}
		
		
	}
	
	
}
