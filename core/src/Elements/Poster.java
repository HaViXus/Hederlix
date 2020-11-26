package Elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Poster extends Sprite
{
	
	private Texture texture;
	private int degree;
	private TextureRegion region;

	public Poster(Texture texture, int x, int y, int ID)
	{
		
		region = new TextureRegion(texture);

		
		    int scale = 3;
			region.setRegion(0,0,texture.getWidth(),texture.getHeight());
			setRegion(region);
			
			if(ID == 300)
			{
				setRotation(15);
				scale = 6;
			}
			else if(ID == 301) setRotation(-15);
			else if(ID == 302) setRotation(10);
			else if(ID == 303) 
			{
				setRotation(-5);
				scale = 6;
			}
			else if(ID == 304) setRotation(-10);
		
		
		
		setBounds(x, y, region.getRegionWidth() * scale, region.getRegionHeight() * scale);
		
	}
	
}
