package Boss;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class bossEye 
{

	public Texture texture;
	public TextureRegion region;
	public float x, y;
	public Sprite spritePlatform, spriteEye, spriteEyeBackground;
	
	
	public Rectangle hitBox, dangerousHitBox; //standard hit box

	public int frameEye, frameBackground;
	public int shootAdded;
	
    public boolean isDestroyed = false;
    public float destroyTimer = 0;
    public int destroyExplosionNumber;
    public int wasDestroyExplosionNumber;
    
    public int width, height;
    
    public float angle;
    public int attack;
	
	public int HP;
	public float immortalTimer, textureTimer, activatedTimer, shootTimer, shootPauseTimer;
	public boolean isImmortal, isActivated;
	public boolean canShoot, wasShoot;
	private boolean textureLightReturn;
	
	private boolean isOnPosition, isAIM;
	private float eyeDegreeSpeed;
	
	//private Sprite test;
	
	
	public bossEye(Texture texture, float x, float y)
	{
		
		this.x = x;
		this.y= y;
		frameBackground = 0;
		frameEye = 0;
		
		this.texture = texture;
		region = new TextureRegion(texture);
		
		region.setRegion(64,192,48,48);
		spritePlatform = new Sprite(region);
		spritePlatform.setBounds(x, y, 288, 288);
		
		region.setRegion(176,0,16,16);
		spriteEye = new Sprite(region);
		spriteEye.setOrigin(30, 30);
		spriteEye.setBounds(x + 114, y + 114, 96, 96);
		
		region.setRegion(112,48,32,32);
		spriteEyeBackground = new Sprite(region);
		spriteEyeBackground.setOrigin(60, 60);
		spriteEyeBackground.setBounds(x + 84, y + 84, 192, 192);
		
		
		hitBox = new Rectangle();
		hitBox.set(x+96,y + 192, 96,96);
		
		dangerousHitBox = new Rectangle();
		dangerousHitBox.set(x + 96, y + 96, 96, 96);
		
		textureTimer = 0;
		shootAdded = 0;
		attack = 0;
		
		isActivated = false;
		isImmortal = false;
		textureLightReturn = false;
		HP = 75;
		
		isOnPosition = true;
		isAIM = true;
		eyeDegreeSpeed = 40;
		
		wasDestroyExplosionNumber = 0;
		destroyExplosionNumber = 0;
		
		width = 288;
		height = 288;
		
		shootPauseTimer = -3;
		
		
	//	region.setRegion(70,25,1,1);
	//	test = new Sprite(region);
	//	test.setBounds(x + 96, y + 96, 96, 96);
		
	}
	
	public void textureHandling()
	{

		if(isDestroyed == false)
		{
			spriteEye.setPosition(x + 114 + (int)(42 * Math.cos(angle * Math.PI / 180.0)), y + 114 + (int)(42 * Math.sin(angle * Math.PI / 180.0)));
			hitBox.setPosition(x + 114 + (int)(42 * Math.cos(angle * Math.PI / 180.0)), y + 114 + (int)(42 * Math.sin(angle * Math.PI / 180.0)));
		}
		
		
		if(isActivated == true && isDestroyed == false)
		{
			
			spriteEye.setRotation(angle + 135);
			spriteEyeBackground.setRotation(angle + 160);
			
			if(isImmortal == false)
			{
				
				if(HP > 60) frameEye = 0;
				else if( HP >45 && HP <= 60) frameEye = 1;
				else if(HP > 30 && HP <= 45) frameEye = 2;
				else if(HP > 15 && HP <= 30) frameEye = 3;
				else if( HP <=15) frameEye = 4;
				//frameEye = (int)(activatedTimer * 10/3.0);
				if(frameEye > 4) frameEye = 4;
				
				region.setRegion(176 - frameEye*16,0,16,16);
				spriteEye.setRegion(region);
				
				region.setRegion(112,48 + 32*frameEye,32,32);
				spriteEyeBackground.setRegion(region);
	
			}
			else
			{
				
				immortalTimer += Gdx.graphics.getDeltaTime();
				if(immortalTimer > 0.15)
				{
					immortalTimer = 0;
					isImmortal = false;
				}
				
				region.setRegion(112,16,16,16);
				spriteEye.setRegion(region);
			}
			
			float backgroundMultipler = 3 + (int)((75-HP)/2.0f);
			frameBackground = (int)(textureTimer * backgroundMultipler);
			if(frameBackground > 3)
			{
				textureTimer = 0;
				frameBackground = 0;
				if(textureLightReturn == false) textureLightReturn = true;
				else textureLightReturn = false;
			}
			
			
			if(textureLightReturn == false) region.setRegion(64,0 + 48 * frameBackground,48,48);
			else region.setRegion(64,192 - 48 * frameBackground,48,48);
			spritePlatform.setRegion(region);
			
			
			
		}
		
		if(isDestroyed == true)
		{
			region.setRegion(128,16,16,16);
			spriteEye.setRegion(region);
			spriteEye.setBounds(x + 114, y + 114, 96, 96);
		}
		
	}
	
	public void mobHandling(float playerX, float playerY)
	{
		
		if(activatedTimer <= 7 && isDestroyed == false) activatedTimer += Gdx.graphics.getDeltaTime();
		if(activatedTimer > 7f)
		{
			
			isActivated = true;
		}
		
		if(isActivated == false && isDestroyed == false)
		{
			float atan =(float) Math.atan((playerY+30 - (y + 144))/(float)(playerX+20 - (x + 144)));
			angle = (float)(atan*180/Math.PI) +180;
			if(playerX > x + 144 - 20)angle += 180;
		}
		
		
		
		if(isActivated == true && isDestroyed == false)
		{
			textureTimer += Gdx.graphics.getDeltaTime();
			shootTimer += Gdx.graphics.getDeltaTime();
			
			
			if(isAIM == true)
			{
			
				float atan =(float) Math.atan((playerY+30 - (y + 144))/(float)(playerX+20 - (x + 144)));
				angle = (float)(atan*180/Math.PI) +180;
				if(playerX > x + 144 - 20)angle += 180;
			}
			
			
			
			
			//angle = angle%360;
			isOnPosition = true;
			
			float mnoznik = Gdx.graphics.getDeltaTime();
			
			int shootAddedMax = 0;
			int maxShootPauseTimer = 0;
			float maxShootTimer = 0;
			
			
			if(attack >= 49) attack = 0;
			
			if(attack < 2) 
			{
				shootAddedMax = 20;
				maxShootPauseTimer = 7;
				maxShootTimer = 0.33f;
			}
			else if(attack >= 2 && attack <= 19)
			{
				shootAddedMax = 1;
				if(attack != 19) maxShootPauseTimer = 0;
				else maxShootPauseTimer = 10;
				maxShootTimer = 0.8f;
			}
			else if(attack == 20) 
			{
				shootAddedMax = 30;
				maxShootPauseTimer = 10;
				maxShootTimer = 0.33f;
			}
			else if(attack == 21 ) 
			{
				shootAddedMax = 10;
				maxShootPauseTimer = 7;
				maxShootTimer = 1f;
			}
			else if(attack == 22 ) 
			{
				isAIM = false;
				if(angle != 90)
				{
					
					isOnPosition = false;
					
					if(angle < 270 && angle > 90) angle -= eyeDegreeSpeed * mnoznik;
					else if(angle >= 270 || angle < 90) angle += eyeDegreeSpeed * mnoznik;
					
					if(angle%360 >89.5 && angle%360 < 91.5)
					{
						angle = 90;
						isOnPosition = true;
					}
				}
				shootAddedMax = 3;
				maxShootPauseTimer = 7;
				maxShootTimer = 3f;
			}
			
			
			else if(attack == 23 ) 
			{
				shootAddedMax = 10;
				maxShootPauseTimer = 7;
				maxShootTimer = 1f;
			}
			
			else if(attack == 24)
			{
				if(isAIM == true)
				{
					
					shootAddedMax = 15;
					maxShootPauseTimer = 10;
					maxShootTimer = 0.8f;
					
				}
			}
			
			else if(attack >= 25 && attack <= 26) 
			{
				shootAddedMax = 20;
				maxShootPauseTimer = 7;
				maxShootTimer = 0.33f;
			}
			
			else if(attack == 27)
			{
				if(isAIM == true)
				{
					
					shootAddedMax = 15;
					maxShootPauseTimer = 10;
					maxShootTimer = 0.8f;
					
				}
			}
			
			else if(attack == 28) 
			{
				shootAddedMax = 20;
				maxShootPauseTimer = 7;
				maxShootTimer = 0.33f;
			}
			else if(attack >= 29 && attack <= 49)
			{
				shootAddedMax = 1;
				if(attack != 48) maxShootPauseTimer = 0;
				else maxShootPauseTimer = 10;
				maxShootTimer = 0.8f;
			}
			
			
			
            if(attack != 22)
            {
            	
            	float atan =(float) Math.atan((playerY+30 - (y + 144))/(float)(playerX+20 - (x + 144)));
				float tmpAngle = (float)(atan*180/Math.PI) +180;
				if(playerX > x + 144 - 20)tmpAngle += 180;
				
                
            	
            	if(angle != tmpAngle)
            	{
            		isOnPosition = false;

            		angle += eyeDegreeSpeed * mnoznik * 3;
            	    //if(angle < 0) angle += 360;


            		if(angle%360 > tmpAngle%360 -0.5 && angle%360 < tmpAngle%360 + 0.5)
            		{
            			isAIM = true;
            		}
            	}
            }
			


			if(isOnPosition == true)
			{
				
		
				if(shootTimer >= maxShootTimer && shootAdded < shootAddedMax)
				{
					canShoot = true;
					shootAdded ++;
					shootTimer = 0;
				}
					
				if(shootAdded >= shootAddedMax)
				{
					shootPauseTimer += Gdx.graphics.getDeltaTime();
					
						if(shootPauseTimer >= maxShootPauseTimer)
						{
							shootPauseTimer = 0;
							shootAdded = 0;
							attack ++;
						}
					
					
					
				}
			}
			
			
				
			
			
			
			
		}
		
		
		
		
	}
	
	public void destroyHandling()
	{
		if(isDestroyed == true)
		{
			destroyTimer += Gdx.graphics.getDeltaTime();
			destroyExplosionNumber = (int)(destroyTimer/0.75f);
		}
	}
	
	public void draw(SpriteBatch batch)
	{
		
		
		spritePlatform.draw(batch);
		spriteEyeBackground.draw(batch);
		spriteEye.draw(batch);
	//	test.draw(batch);
		
	}
	
	
}
