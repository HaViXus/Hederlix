package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Door 
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public Door(Texture texture, int x, int y, int ID)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
		this.texture = texture;	
		region = new TextureRegion(texture);
		region.setRegion(144 + 16*(ID - 120), 0, 16,16);
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
