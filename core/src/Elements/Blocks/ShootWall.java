package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class ShootWall
{

	public int x,y, ID;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public ShootWall(Texture texture, int x, int y)
	{
		this.texture = texture;	
		this.x = x;
		this. y = y;
		region = new TextureRegion(texture);
		region.setRegion(64,0,16,16);
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
