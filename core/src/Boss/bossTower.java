package Boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class bossTower 
{

	public Texture texture;
	public TextureRegion region;
	public float x, y;
	public int ID, width, height;
	public Sprite sprite;
	
	public boolean canShoot;
	public int shootAdded, wasShootAdded;
	public float shootTimer;
	public float pauseShootTimer;
	
	public Rectangle dangerousHitbox;
	public float angle;
	
	public boolean isDestroyed = false;
	
	public bossTower(Texture texture, float x, float y, int ID)
	{
		
		this.x = x;
		this.y= y;
		this.texture = texture;
		this.ID = ID;
		
		region = new TextureRegion(texture);
		canShoot = false;
		shootAdded = 0;
		wasShootAdded = 0;
		
		dangerousHitbox = new Rectangle();
		dangerousHitbox.set(x, y, 32 * 6, 32 * 6);
		
		width = 32 * 6;
		height =  67 * 6;
		
		
		region.setRegion(0,0,32,67);
		sprite = new Sprite(region);	
		sprite.setOrigin(16*6 , 26.5f *6 );
		sprite.setBounds(x, y, 32 * 6, 67 * 6);
		
		
		
	}
	
	public void textureHandling(float playerX, float playerY)
	{
		if(pauseShootTimer >= 3f) shootTimer += Gdx.graphics.getDeltaTime();
		if(pauseShootTimer < 3f) pauseShootTimer += Gdx.graphics.getDeltaTime();
		
		float atan =(float) Math.atan((playerY+30 - (y + 150))/(float)(playerX+20 - (x + 96)));
		angle = (float)(atan*180/Math.PI) + 90;
		if(playerX > x + 96 - 20)angle += 180;
		
		
		
		if(shootTimer <0.10)
		{
			region.setRegion(0,0,32,67);
			wasShootAdded = shootAdded;
		}
		else 
		{
			if(wasShootAdded == shootAdded)
			{
				shootAdded ++;
				canShoot = true;
			}
			region.setRegion(32,0,32,67);
			if(shootTimer >= 0.15)
			{
				shootTimer = 0;
				if(shootAdded > 30)
				{
					shootAdded = 0;
					pauseShootTimer = 0;
				}
			}
		}
		
		
		sprite.setRegion(region);
		sprite.setRotation(angle);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
