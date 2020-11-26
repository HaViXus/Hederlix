package Elements.Mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class bigMachine
{

	public Texture texture;
	public TextureRegion region;
	public float x, y;
	public float lastX, lastY;
	public Sprite sprite;
	
	private float missileTimer;
	private float shootTimer;
	private float shootPauseTimer;
	private float missilePauseTimer;
	
	private int shootAdded;
	public int missileAdded;
	
	public int ID;
	public float width, height;
	
	public Rectangle hitBoxMachine,hitBoxWeapon1,hitBoxWeapon2, hitBoxButton; 
	
	public int HP;
	public float immortalTimer;
	public boolean isImmortal;
	public boolean canShoot, wasShoot;
	public boolean canShootMissile, wasShootMissile;
	
	public boolean isShoot, isMissile;
	
	public bigMachine(Texture texture)
	{
		
		this.texture = texture;
		region = new TextureRegion(texture);
		sprite = new Sprite();
	}
	
	public void setBigMachine(float x, float y, int ID)
	{
		
		this.x = x;
		this.y= y;
		this.ID = ID;
		lastX = x;
		lastY = y;

		isImmortal = false;
		
		hitBoxMachine = new Rectangle();
		hitBoxWeapon1 = new Rectangle();
		hitBoxWeapon2 = new Rectangle();
		hitBoxButton = new Rectangle();
		
		hitBoxMachine.set(x,y,144,141);
		hitBoxWeapon1.set(x+144,y,33,30);
		hitBoxWeapon2.set(x+144,y+87,33,30);
		hitBoxButton.set(x+144,y+33,15,54);
		
		shootAdded = 0;
		missileAdded = 0;
		
		wasShoot = false;
		wasShootMissile = false;
		canShoot = false;
		canShootMissile = false;
		
		sprite.setBounds(x, y, 192, 144);
		
		HP = 10;
		width = 183;
		height = 141;
		
		
	}
	
	
	public void setTexture()
	{
		
		
		if(shootPauseTimer < 5) shootPauseTimer += Gdx.graphics.getDeltaTime();
		if(missilePauseTimer < 10) missilePauseTimer += Gdx.graphics.getDeltaTime();
		
		
		
		if(shootAdded < 20 && shootPauseTimer >= 5)
		{
			
			shootTimer += Gdx.graphics.getDeltaTime();
			if(shootTimer >= 0.1 && wasShoot == false)
			{
				canShoot = true;
				shootAdded ++;
			}
			if(shootTimer >= 0.3)
			{
				shootTimer = 0;
				wasShoot = false;
				
			}
		}
		else if(shootAdded >= 19)
		{
			shootAdded = 0;
			shootPauseTimer = 0;
		}
		
		
		
		
		if(missileAdded < 3 && missilePauseTimer >= 10)
		{
			
			missileTimer += Gdx.graphics.getDeltaTime();
			if(missileTimer >= 0.3)
			{
				canShootMissile = true;
				missileAdded ++;
				missileTimer = 0;
				
			}
			
		}
		else if(missileAdded >= 3)
		{
			missileAdded = 0;
			missilePauseTimer = 0;
		}
		
		
		if(isImmortal == false)
		{
			if(shootTimer <= 0.2) region.setRegion(0,208,61,48);
			else region.setRegion(64,208,61,48);
		}
		else
		{
			immortalTimer += Gdx.graphics.getDeltaTime();
			
			if(shootTimer < 0.2) region.setRegion(128,208,61,48);
			else region.setRegion(192,208,61,48);
			
			if(immortalTimer > 0.15)
        	{
        		immortalTimer=0;
        		isImmortal = false;
        	}
		}
		
		sprite.setRegion(region);
		
		
		
	}
	
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
	
}
