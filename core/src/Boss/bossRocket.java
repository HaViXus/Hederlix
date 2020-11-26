package Boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class bossRocket 
{

	public Texture texture;
	public TextureRegion region;
	public float x, y;
	public int ID, width, height;
	public Sprite spriteCannon, spritePlatform;
	
	public boolean canShoot;
	public int shootAdded, wasShootAdded;
	public float shootTimer;
	public float pauseShootTimer;
	
	public Rectangle dangerousHitbox;
	public float angle;
	
	public boolean isDestroyed = false;
	
	public bossRocket(Texture texture, float x, float y, int ID)
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
		
		region.setRegion(0,128,32,32);
		spritePlatform = new Sprite(region);	
		spritePlatform.setOrigin(16*6 , 16*6 );
		spritePlatform.setBounds(x, y, 32 * 6, 32 * 6);
		
		region.setRegion(0,160,32,64);
		spriteCannon = new Sprite(region);	
		spriteCannon.setOrigin(16*6 , 10f *6 );
		spriteCannon.setBounds(x, y + 36, 32 * 6, 64 * 6);
		
		pauseShootTimer = 3;
		
	}
	
	public void textureHandling(float playerX, float playerY)
	{
		if(pauseShootTimer >= 5f) shootTimer += Gdx.graphics.getDeltaTime();
		if(pauseShootTimer < 5f) pauseShootTimer += Gdx.graphics.getDeltaTime();
		
		float atan =(float) Math.atan((playerY+30 - (y + 96))/(float)(playerX+20 - (x + 96)));
		angle = (float)(atan*180/Math.PI) + 90;
		if(playerX > x + 96 - 20)angle += 180;
		
		
		
		if(shootTimer <0.15)
		{
			region.setRegion(0,160,32,64);
			wasShootAdded = shootAdded;
		}
		else 
		{
			if(wasShootAdded == shootAdded)
			{
				shootAdded ++;
				canShoot = true;
			}
			region.setRegion(32,160,32,64);
			if(shootTimer >= 0.25)
			{
				shootTimer = 0;
				if(shootAdded > 5)
				{
					shootAdded = 0;
					pauseShootTimer = 0;
				}
			}
		}
		
		
		spriteCannon.setRegion(region);
		spriteCannon.setRotation(angle);
		
	}
	
	public void draw(SpriteBatch batch)
	{
		spritePlatform.draw(batch);
		spriteCannon.draw(batch);
	}
	
}
