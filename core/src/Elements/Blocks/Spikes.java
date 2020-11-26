package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Spikes 
{

	public int x,y;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	public Rectangle hitBox;
	
	public Spikes (Texture texture, int x, int y, int ID)
	{
		this.x = x;
		this.y = y;
		this.texture = texture;	
		region = new TextureRegion(texture);
		region.setRegion(80 + 16 * (ID-115),0,16,16);
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		hitBox = new Rectangle();
		if(ID == 115) hitBox.set(x,y,48,24);
		else if(ID == 116) hitBox.set(x,y + 24,48,24);
		else if(ID == 117) hitBox.set(x,y,24,48);
		else if(ID == 118) hitBox.set(x + 24,y,24,48);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
