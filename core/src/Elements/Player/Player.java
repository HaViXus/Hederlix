package Elements.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Player 
{
	
	public float x, y;
	private float lastX, lastY;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public float textureTimer;
	public float speedX, speedY;
	
	public boolean isGravity;
	public boolean canJump, isJump, tmpIsJump, isWznoszenie, startJump;
	
	public boolean isShot;
	public boolean isDead;
	public float deadTimer;
	
	
	public int collisionX = 0, collisionUp = 0, collisionBottom = 0; //ColiisionX: 1 - Left, 2 - Right 
	public int lastDirectionX = 2;
	
	private int frame = 0;
	private float startJumpY;
	private float startSpeedX;
	private float lastSpeedX;
	public float jumpTimer;
	
	public Rectangle hitBox;
	

	public Player(int x, int y, Texture texture)
	{
		
		this.x = x;
		this.y = y;
		this.texture = texture;
		
		lastX = x;
		lastY = y;
		
		region = new TextureRegion(texture);
		sprite = new Sprite();
		sprite.setBounds(x, y, 48, 48);
		
		isShot = false;
		
		hitBox = new Rectangle();
		
		
	}
	
	public void playerTextureMove(float FPS, int moveX, int moveY) // moveX 1 - left, 2 - right // moveY 1 -up, 2 - down
	{
		
       
		if(tmpIsJump == false)//if(speedY < 1 && speedY > -1 && isJump == false)
		{
			
			
			if(moveX != 0 )
			{
				
				textureTimer += Gdx.graphics.getDeltaTime();
				frame = (int)(textureTimer * 10);
				if(moveX ==2)
				{
					
					if(frame > 3)
					{
						frame = 0;
						textureTimer = 0;
					}
					if(isShot == false)
					{
						if(frame <3) region.setRegion(0 + 16*frame,16,16,16);
						else region.setRegion(16, 16, 16, 16);
					}
					else
					{
						if(frame <3) region.setRegion(0 + 16*frame,48,16,16);
						else region.setRegion(16, 48, 16, 16);
					}
					
					
					
				}
				else
				{
					
					if(frame > 3)
					{
						frame = 0;
						textureTimer = 0;
					}
					if(isShot == false)
					{
						if(frame <3) region.setRegion(0 + 16*frame,32,16,16);
						else region.setRegion(16, 32, 16, 16);
					}
					else
					{
						if(frame <3) region.setRegion(0 + 16*frame,64,16,16);
						else region.setRegion(16, 64, 16, 16);
					}
					
				}
				
				
			}
			else if(moveX == 0)
			{
				frame =0;
				textureTimer = 0;
				
				if(isShot == false)
				{
					if(lastDirectionX == 2)region.setRegion(0, 0, 16, 16);
					else region.setRegion(16, 0, 16, 16);
				}
				else
				{
					if(lastDirectionX == 2)region.setRegion(48, 64, 16, 16);
					else region.setRegion(64, 64, 16, 16);
				}
				
			}
			
		}
		
		else if(tmpIsJump == true)//else if(speedY<-1 || speedY > 1 || isJump == true)
		{
			if(isShot == false)
			{
				if(lastDirectionX == 2)
				{
					region.setRegion(64,0,16,18);
				}
				else
				{
					region.setRegion(80,0,16,18);
				}
			}
			else
			{
				if(lastDirectionX == 2)
				{
					region.setRegion(48,32,16,18);
				}
				else
				{
					region.setRegion(64,32,16,18);
				}
			}
			
			
			frame = 0;
			textureTimer = 0;
			
		}
        
		
		hitBox.set(x + 15, y, 18, 42);
		
		sprite.setRegion(region);
		if(tmpIsJump == true) sprite.setBounds(x, y, 48, 54);
		else sprite.setBounds(x, y, 48, 48);
		
	}
	
	public void moveX(int moveX, float FPS)
	{
		
        if(FPS < 15) FPS = 15;
        lastSpeedX = speedX;
		
		if(moveX == 1)
		{
			speedX -= 350/(float)FPS;
			lastDirectionX = 1;
		}
		else if(moveX == 2)
		{
			speedX += 350/(float)FPS;
			lastDirectionX = 2;
		}
		
		if(speedX > 250) speedX = 250;
		else if(speedX < -250) speedX = -250;
		
		
		if(moveX == 0 || (speedX>0 && moveX == 1) || (speedX <0 && moveX == 2)) 
		{
			
			if(speedX > 0) speedX -= 1200/(float)FPS;
			else if( speedX <0) speedX += 1200/(float) FPS;
			
			if((lastSpeedX>0 && speedX <0) || (lastSpeedX < 0 && speedX > 0))//(speedX > 0 && speedX < 0.001) || (speedX < 0 && speedX > -0.001)) 
			{
				
				speedX = 0;
				
			}
			
		}
		
	}
	
	
	public void moveY(int moveY, float FPS)
	{
		
		if(FPS < 15) FPS = 15;
		
		//gravity
		if(isJump==false) speedY -= 800/(float)FPS;
		if(speedY < -800) speedY = -800;
		
		
		
		jump(moveY, FPS);
		
		if(y > lastY) isWznoszenie = true;
		else isWznoszenie = false;
		
	}
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	
	
	public void saveLastPosition()
	{
		
		lastX = x;
		lastY = y;
		
	}
	
	public void correctPosition()
	{
		
		if(collisionBottom !=0 || collisionUp != 0)
		{
			
			y = lastY;
			speedY = 0;
			jumpTimer += Gdx.graphics.getDeltaTime();
					
		}
		else if(tmpIsJump == false && canJump == false)
		{
			//jumpTimer = 0;
		}
		
		if(collisionX != 0)
        {
        	
			x = lastX;    	
        	speedX = 0;      	
        	
        }
		
		
		
	}
	
	private void jump(int isKeyPressed, float FPS)
	{
		startJump = false;
		
		if(canJump == true && collisionUp == 0)
		{
			if(isJump == false && isKeyPressed == 1 && jumpTimer > 0.02f)
			{
				isJump = true;
				tmpIsJump = true;
				startJumpY = y;
				startSpeedX = speedX;
				startJump = true;
				if(startSpeedX<0) startSpeedX *= -1;
				y+=300/(float)FPS;;
			}
			else if(isJump== true)
			{
				
				if(isWznoszenie == true && isKeyPressed == 1 && y< startJumpY + 75 + startSpeedX/2.5f) y+= 300/(float)FPS;	
		        if(isWznoszenie == false)
		        {
		        	isJump = false;
		        	canJump = false;
		        	
		        }
			}		
			
		
		}
			
		
		
	}
	
	public void obslugaSmierci()
	{
		if(isDead == true) deadTimer += Gdx.graphics.getDeltaTime();
	}
	
	
	public Sprite getTexture()
	{
		
		return sprite;
		
	}
	
	
}
