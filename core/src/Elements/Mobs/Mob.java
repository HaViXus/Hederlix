package Elements.Mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Mob 
{
	
	public Texture texture;
	public TextureRegion region;
	public float x, y;
	public float lastX, lastY;
	public Sprite sprite;
	public float textureTimer;
	public float shootTimer;
	public int ID;
	public float width, height;
	
	public Rectangle hitBox1; //standard hit box
	public Rectangle hitBox2; //additional hit box when mob has smaller hit box to damage then hit box to give damage or if need other hit box to other function
	
	public int collisionX; // 1-left, 2 - right
	public int collisionY; // 1 - up, 2 - down
	public int lastDirection; // 1 - left, 2 - right
	public int direction;
	private int frame;
	
	public boolean isDestroyed = false;
	
	public int HP;
	public float immortalTimer;
	public boolean isImmortal;
	public boolean canShoot, wasShoot;
	
	public boolean isJump, canJump;
	public boolean startJump;
	public float speedY, speedX;
	
	public Mob(Texture texture)
	{
		
		this.texture = texture;
		region = new TextureRegion(texture);
		sprite = new Sprite();
		textureTimer = 0;
	}
	
	public void setMob(float x, float y, int ID)
	{
		
		this.x = x;
		this.y= y;
		this.ID = ID;
		lastX = x;
		lastY = y;
		lastDirection = 2;
		direction = 2;
		frame = 0;
		isImmortal = false;
		
		hitBox1 = new Rectangle();
		
		if(ID % 2 == 1)
		{
			if(ID == 201) //TARCZOWNIK
			{
				width = 45;
				height = 60;
				HP = 3;				
				
				hitBox1.set(x, y, 42, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 203)//STRZELEC
			{
				width = 27;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x, y, 27, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 205)//WYSOKI
			{
				width = 27;
				height = 95;
				HP = 1;				
				
				hitBox1.set(x, y, 27, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 207)//KAMIKADZE TNT
			{
				width = 48;
				height = 87;
				HP = 1;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 209) //MINA PIONOWA
			{
				width = 42;
				height = 42;
				HP = 1;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 211) //SKOCZEK
			{
				width = 45;
				height = 45;
				HP = 3;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
				
				isJump = false;
				canJump = true;
	
			}
		}
		else
		{
			if(ID == 202) //£AZIK
			{
				width = 48;
				height = 36;
				HP = 1;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 204)//RAKIETOWIEC
			{
				width = 27;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x, y, 27, height);
				hitBox2 = new Rectangle();
				shootTimer = 3;
	
			}
			else if(ID == 206)//KAMIKADZE !!!
			{
				width = 48;
				height = 87;
				HP = 1;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 208) //MINA POZIOMA
			{
				width = 42;
				height = 42;
				HP = 1;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
	
			}
			else if(ID == 210) //SKOCZEK
			{
				width = 45;
				height = 45;
				HP = 3;				
				
				hitBox1.set(x, y, 48, height);
				hitBox2 = new Rectangle();
				
				isJump = false;
				canJump = true;
	
			}
			
		}
		
		if(ID >=212 && ID <=215) //DZIA£KO POMARAÑCZOWE
		{
			wasShoot = false;
			if(ID == 212) //PRAWO
			{
				width = 36;
				height = 42;
				HP = 3;				
				
				hitBox1.set(x, y + 3, 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 213) //LEWO
			{
				width = 36;
				height = 42;
				HP = 3;				
				
				hitBox1.set(x + 12, y + 3, 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 214) //DOL
			{
				width = 42;
				height = 36;
				HP = 3;				
				
				hitBox1.set(x+3, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 215) //GORA
			{
				width = 42;
				height = 36;
				HP = 3;				
				
				hitBox1.set(x+3, y + 12, 48, height);
				hitBox2 = new Rectangle();
			}
			
			
		}
		
		else if(ID >=216 && ID <=219) //DZIA£KO POMARAÑCZOWE
		{
			wasShoot = false;
			if(ID == 216) //PRAWO
			{
				width = 36;
				height = 42;
				HP = 3;				
				
				hitBox1.set(x, y + 3, 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 217) //LEWO
			{
				width = 36;
				height = 42;
				HP = 3;				
				
				hitBox1.set(x + 12, y + 3, 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 218) //DOL
			{
				width = 42;
				height = 36;
				HP = 3;				
				
				hitBox1.set(x+3, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 219) //GORA
			{
				width = 42;
				height = 36;
				HP = 3;				
				
				hitBox1.set(x+3, y + 12, 48, height);
				hitBox2 = new Rectangle();
			}
			
			
		}
		else if(ID >=220 && ID <=222) //BATS
		{
			wasShoot = false;
			if(ID == 220) //ORANGE
			{
				width = 72;
				height = 24;
				HP = 1;				
				
				hitBox1.set(x, y , 72, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 221) //VIOLET
			{
				width = 72;
				height = 24;
				HP = 3;				
				
				hitBox1.set(x , y , 72, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 222) //BLUE
			{
				width = 72;
				height = 24;
				HP = 5;				
				
				hitBox1.set(x, y , 72, height);
				hitBox2 = new Rectangle();
			}
			
			
		}
		else if(ID >=223 && ID <=228) //Show Tower Blocks
		{
			wasShoot = false;
			if(ID == 223) //CYAN
			{
				width = 48;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 224) //ORANGE
			{
				width = 48;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x , y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 225) //GREEN
			{
				width = 48;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 226) //RED
			{
				width = 48;
				height = 45;
				HP = 2;				
				
				hitBox1.set(x, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 227) //GRAY
			{
				width = 48;
				height = 45;
				HP = 5;				
				
				hitBox1.set(x, y , 48, height);
				hitBox2 = new Rectangle();
			}
			else if(ID == 228) //BLUE
			{
				width = 48;
				height = 45;
				HP = 3;				
				
				hitBox1.set(x, y , 48, height);
				hitBox2 = new Rectangle();
			}
			
			
		}
		
		
	}
	
	public void setTexture()
	{
		
		textureTimer += Gdx.graphics.getDeltaTime();
		
		if(ID%2 == 1)
		{
			if(ID == 201)
			{
			
	            if(isImmortal == false)
	            {
	            	
	            	frame = (int)((textureTimer*10) % 2);
					if(frame > 1)
					{
						frame =0;
						textureTimer =0;
					}
					
					
					if(direction == 2)
					{
						region.setRegion(48 + 16 * frame, 96, 16, 32);
						//hitBox2.set(x + 42, y, 6, 96);
					}
					else
					{
						region.setRegion(0 + 16 * frame, 96, 16, 32);
						//hitBox2.set(x, y, 6, 96);
					}
	            	
	            }	
	            else
	            {
	            	
	            	immortalTimer += Gdx.graphics.getDeltaTime();
	            	
	            	if(direction == 2)
	            	{
	            		region.setRegion(80, 96, 16, 32);
						hitBox2.set(x + 42, y, 6, 96);
	            	}
	            	else
	            	{
	            		region.setRegion(32, 96, 16, 32);
						hitBox2.set(x, y, 6, 96);
	            	}
	            	
	            	textureTimer = 0;
	            	frame =0;
	            	if(immortalTimer > 0.15)
	            	{
	            		immortalTimer=0;
	            		isImmortal = false;
	            	}
	            	
	            }
	            sprite.setBounds(x, y, 48, 96);
			}
			else if(ID == 203)
			{
				
				 if(isImmortal == false)
		            {
		            	
		            	frame = (int)((textureTimer*10) % 2);
						if(frame > 1)
						{
							frame =0;
							textureTimer =0;
						}
						
						
						if(direction == 1)
						{
							region.setRegion(64 + 16 * frame, 32, 16, 16);
						}
						else
						{
							region.setRegion(112 + 16 * frame, 32, 16, 16);						
						}
		            	
		            }	
		            else
		            {
		            	
		            	immortalTimer += Gdx.graphics.getDeltaTime();
		            	
		            	if(direction == 1)
		            	{
		            		region.setRegion(96, 32, 16, 16);

		            	}
		            	else
		            	{
		            		region.setRegion(144, 32, 16, 16);

		            	}
		            	
		            	textureTimer = 0;
		            	frame =0;
		            	if(immortalTimer > 0.15)
		            	{
		            		immortalTimer=0;
		            		isImmortal = false;
		            	}
		            	
		            }
		            sprite.setBounds(x, y, 48, 48);
				
			}
			
			else if(ID == 205)
			{
			
	            
	            	frame = (int)((textureTimer*10) % 2);
					if(frame > 1)
					{
						frame =0;
						textureTimer =0;
					}
					
					
					if(direction == 2)
					{
						region.setRegion(32 + 16 * frame, 32, 16, 32);
						hitBox2.set(x, y, 42, 72);
					}
					else
					{
						region.setRegion(0 + 16 * frame, 32, 16, 32);
						hitBox2.set(x, y, 48, 72);
					}
					sprite.setBounds(x, y, 48, 96);
			}
			else if(ID == 207)
			{
				
		            	frame = (int)((textureTimer*10) % 2);
						if(frame > 1)
						{
							frame =0;
							textureTimer =0;
						}
						
						
						if(direction == 1)
						{
							region.setRegion(64 + 16 * frame, 176, 16, 32);
						}
						else
						{
							region.setRegion(96 + 16 * frame, 176, 16, 32);						
						}
		            	
		            	
		           
		            sprite.setBounds(x, y, 48, 96);
				
			}
			else if(ID == 209)
			{
				
				        if(textureTimer < 1) frame = (int)((textureTimer*5));
				        else if(textureTimer >= 1 && textureTimer < 2)
				        {
				        	frame = 4- (int)( (textureTimer-1)*5);
				        }
				        else
				        {
				        	frame = 0;
				        	textureTimer = 0;
				        }
						
							region.setRegion(128 + 16 * frame, 128, 16, 16);
       
		            sprite.setBounds(x, y, 48, 48);
				
			}
			else if(ID == 211)
			{
				frame = (int)((textureTimer));	 
				if(textureTimer > 2) textureTimer = 2;
				 if(isImmortal == false)
		            {
		            	
		            	           	
						if(frame <2) region.setRegion(96 + 16 * frame, 16, 16, 16);		
						else region.setRegion(96 + 16 * frame, 15, 16, 17);		
		            	
		            }	
		            else
		            {
		            	
		            	immortalTimer += Gdx.graphics.getDeltaTime();
		            	
						if(frame <2) region.setRegion(144 + 16 * frame, 16, 16, 16);		
						else region.setRegion(144 + 16 * frame, 15, 16, 17);	

		            	if(immortalTimer > 0.15)
		            	{
		            		immortalTimer=0;
		            		isImmortal = false;
		            	}
		            	
		            }
				 
				 if(frame < 2) sprite.setBounds(x, y, 48, 48);
		         else sprite.setBounds(x, y, 48, 51);
				 
				 if(textureTimer>= 2)
				 {
					 if(isJump == false) startJump = true;
					 else startJump = false;
					 isJump = true;
				 }
				 if(textureTimer == 2 && isJump == false) textureTimer = 0;
				
				
			}
	            	
		}
		else
		{
			if(ID == 202)
			{		            
	            	
	            	frame = (int)((textureTimer*10) % 2);
					if(frame > 1)
					{
						frame =0;
						textureTimer =0;
					}
					
					
					if(direction == 2)
					{
						region.setRegion(0 + 16 * frame, 64, 16, 16);
						hitBox2.set(x + 42, y, 6, 96);
					}
					else
					{
						region.setRegion(32 + 16 * frame, 64, 16, 16);
						hitBox2.set(x, y, 6, 96);
					}
					
					sprite.setBounds(x, y, 48, 48);			
			}
			else if(ID == 204)
			{
				
				 if(isImmortal == false)
		            {
		            	
		            	frame = (int)((textureTimer*10) % 2);
						if(frame > 1)
						{
							frame =0;
							textureTimer =0;
						}
						
						
						if(direction == 1)
						{
							region.setRegion(64 + 16 * frame, 48, 16, 16);
						}
						else
						{
							region.setRegion(112 + 16 * frame, 48, 16, 16);						
						}
		            	
		            }	
		            else
		            {
		            	
		            	immortalTimer += Gdx.graphics.getDeltaTime();
		            	
		            	if(direction == 1)
		            	{
		            		region.setRegion(96, 48, 16, 16);

		            	}
		            	else
		            	{
		            		region.setRegion(144, 48, 16, 16);

		            	}
		            	
		            	textureTimer = 0;
		            	frame =0;
		            	if(immortalTimer > 0.15)
		            	{
		            		immortalTimer=0;
		            		isImmortal = false;
		            	}
		            	
		            }
		            sprite.setBounds(x, y, 48, 48);
				
			}
			
			else if(ID == 206)
			{
				
		            	frame = (int)((textureTimer*10) % 2);
						if(frame > 1)
						{
							frame =0;
							textureTimer =0;
						}
						
						
						if(direction == 1)
						{
							region.setRegion(0 + 16 * frame, 176, 16, 32);
						}
						else
						{
							region.setRegion(32 + 16 * frame, 176, 16, 32);						
						}
		            	
		            	
		           
		            sprite.setBounds(x, y, 48, 96);
				
			}
			else if(ID == 208)
			{
				
				        if(textureTimer < 1) frame = (int)((textureTimer*5));
				        else if(textureTimer >= 1 && textureTimer < 2)
				        {
				        	frame = 4- (int)( (textureTimer-1)*5);
				        }
				        else
				        {
				        	frame = 0;
				        	textureTimer = 0;
				        }

						region.setRegion(128 + 16 * frame, 128, 16, 16);
       
		            sprite.setBounds(x, y, 48, 48);
		            
				
			}
			else if(ID == 210)
			{
				frame = (int)((textureTimer));
            	if(textureTimer > 2) textureTimer = 2;
            	
				 if(isImmortal == false)
		            {
		            	
		            	
						if(frame <2) region.setRegion(48 + 16 * frame, 16, 16, 16);		
						else region.setRegion(48 + 16 * frame, 15, 16, 17);		
		            	
		            }	
		            else
		            {
		            	
		            	immortalTimer += Gdx.graphics.getDeltaTime();

						if(frame <2) region.setRegion(144 + 16 * frame, 16, 16, 16);		
						else region.setRegion(144 + 16 * frame, 15, 16, 17);	

		            	if(immortalTimer > 0.15)
		            	{
		            		immortalTimer=0;
		            		isImmortal = false;
		            	}
		            	
		            }
				 
				 if(frame < 2) sprite.setBounds(x, y, 48, 48);
		         else sprite.setBounds(x, y, 48, 51);
				 
				 if(textureTimer>= 2)
				 {
					 isJump = true;
				 }
				 if(textureTimer == 2 && isJump == false) textureTimer = 0;
				
				
			}
		}
		
		if(ID >= 212 && ID <=215)
		{
			
			
				if(isImmortal == false)
	            {
	            	
	            	frame = (int)((textureTimer*2/3.0));
	            	if(textureTimer >= 1.5 && canShoot == true)
	            	{
	            		wasShoot = true;
	            	}
	            	if(textureTimer >= 1.6)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            		wasShoot = false;
	            	}
					region.setRegion(0 + 32 * (ID - 212) + 16 * frame, 128, 16, 16);		
	            	
	            }	
	            else
	            {
	            	
	            	immortalTimer += Gdx.graphics.getDeltaTime();
	            	
	            	frame = (int)((textureTimer*2/3.0));	
	            	if(textureTimer >= 1.5 && canShoot == true)
	            	{
	            		wasShoot = true;
	            	}
	            	if(textureTimer >= 1.6)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            		wasShoot = false;
	            	}
	            	region.setRegion(0 + 32 * (ID - 212) + 16 * frame, 160, 16, 16);	

	            	if(immortalTimer > 0.15)
	            	{
	            		immortalTimer=0;
	            		isImmortal = false;
	            	}
	            	
	            }
			 
			 if(frame < 2) sprite.setBounds(x, y, 48, 48);
	         else sprite.setBounds(x, y, 48, 48);
			
			
		}
		else if(ID >= 216 && ID <=219)
		{
			
			
				if(isImmortal == false)
	            {
	            	
	            	frame = (int)((textureTimer/2.5));
	            	if(textureTimer >= 2.5 && canShoot == true)
	            	{
	            		wasShoot = true;
	            	}
	            	if(textureTimer >= 2.6)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            		wasShoot = false;
	            	}
					region.setRegion(0 + 32 * (ID - 216) + 16 * frame, 144, 16, 16);		
	            	
	            }	
	            else
	            {
	            	
	            	immortalTimer += Gdx.graphics.getDeltaTime();
	            	
	            	frame = (int)((textureTimer*2/3.0));	
	            	if(textureTimer >= 2.5 && canShoot == true)
	            	{
	            		wasShoot = true;
	            	}
	            	if(textureTimer >= 2.6)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            		wasShoot = false;
	            	}
	            	region.setRegion(0 + 32 * (ID - 216) + 16 * frame, 160, 16, 16);	

	            	if(immortalTimer > 0.15)
	            	{
	            		immortalTimer=0;
	            		isImmortal = false;
	            	}
	            	
	            }
			 
			 if(frame < 2) sprite.setBounds(x, y, 48, 48);
	         else sprite.setBounds(x, y, 48, 48);
			
			
		}
		
		else if(ID >= 220 && ID <=222)
		{
			
			
				if(isImmortal == false)
	            {
	            	
	            	frame = (int)((textureTimer*5));
	            	if(frame > 1)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            	}
					region.setRegion(0 + 64 * (ID - 220) + 32 * frame, 80, 32, 16);		
	            	
	            }	
	            else
	            {
	            	
	            	immortalTimer += Gdx.graphics.getDeltaTime();
	            	
	            	frame = (int)((textureTimer*5));

	            	if(frame>1)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            	}
	            	region.setRegion(192 + 32 * frame, 80, 32, 16);	

	            	if(immortalTimer > 0.15)
	            	{
	            		immortalTimer=0;
	            		isImmortal = false;
	            	}
	            	
	            }
			 
			sprite.setBounds(x, y, 96, 48);
	     
			
			
		}
		else if(ID >= 223 && ID <=228)
		{
			
			
				if(isImmortal == false)
	            {
	            	
	            	frame = 0;
	            	if(frame > 1)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            	}
	            	if(ID >= 223 && ID <= 225) region.setRegion(0 + 16 * (ID - 223),0, 16, 16);	
	            	else if(ID == 226) region.setRegion(32,16,16,16);
	            	else if(ID == 227 || ID == 228) region.setRegion(48 + 16 * (ID - 227),0,16,16);
	            	
	            }	
	            else
	            {
	            	
	            	immortalTimer += Gdx.graphics.getDeltaTime();
	            	
	            	frame = 0;

	            	if(frame>1)
	            	{
	            		textureTimer = 0;
	            		frame = 0;
	            	}
	            	if(ID == 223) region.setRegion(0, 16, 16, 16);	
	            	else if(ID == 224 || ID == 225) region.setRegion(16, 16, 16, 16);
	            	else if(ID == 226) region.setRegion(112, 0, 16, 16);
	            	else if(ID == 227 || ID == 228) region.setRegion(96, 0, 16, 16);

	            	if(immortalTimer > 0.15)
	            	{
	            		immortalTimer=0;
	            		isImmortal = false;
	            	}
	            	
	            }
			 
			sprite.setBounds(x, y, 48, 48);
	     
			
			
		}
		
		sprite.setRegion(region);
		
		
		
	}
	
	public void mobHandling(float playerX, float playerY)
	{
		
		if(ID%2 == 1)
		{
			
			if(ID == 203)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 3) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 211)
			{
				if(isJump == false)
				{
					if(playerX > x) direction = 2;
					else direction = 1;
				}
				
				if(startJump == true) canShoot = true;
				
				
			}
			else if(ID == 221)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 3) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 223)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 3) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 225)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 5) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 227)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 12)canShoot = true;	
				else canShoot = false;
				
				
			}
			
		}
		else if(ID%2 == 0)
		{
			
			if(ID == 204)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 5) canShoot = true;
				else canShoot = false;
				
			}
			else if(ID == 210)
			{
				if(isJump == false)
				{
					if(playerX > x) direction = 2;
					else direction = 1;
				}
				
				
			}
			else if(ID == 224)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 3) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 226)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 0.9f) canShoot = true;
				else canShoot = false;
			}
			else if(ID == 228)
			{
				shootTimer += Gdx.graphics.getDeltaTime();
				if(shootTimer > 10f) canShoot = true;
				else canShoot = false;
			}
			
		}
		
		if(ID >=212 && ID <= 215)
		{
			shootTimer += Gdx.graphics.getDeltaTime();
			if(shootTimer >= 1.6) shootTimer = 0;
			if(shootTimer > 1.5 && wasShoot == false) canShoot = true;
			else canShoot = false;
		}
		else if(ID >=216 && ID <= 219)
		{
			shootTimer += Gdx.graphics.getDeltaTime();
			if(shootTimer >= 2.6) shootTimer = 0;
			if(shootTimer > 2.5 && wasShoot == false) canShoot = true;
			else canShoot = false;
		}
		
		
	}
	
	public void moveX(float playerX, float FPS)
	{
		
		if(FPS < 15) FPS = 15;
		if(ID%2 == 1)
		{
			
			
			if(ID == 201)
			{
				if(direction == 2)
				{
					x+= 220 / FPS;
					hitBox1.set(x, y, 42, 66);
					hitBox2.set(x + 42, y, 6,69);
					
				}
				else
				{
					x-= 220 / FPS;
					hitBox1.set(x + 6, y, 42, 66);
					hitBox2.set(x, y, 6,69);
				}
			}
			else if(ID == 203)
			{
				if(direction == 2)
				{
					x+= 130 / FPS;
					hitBox1.set(x, y, 27, 48);				
				}
				else
				{
					x-= 130 / FPS;
					hitBox1.set(x + 6, y, 27, 48);
				}
			}
			else if(ID == 205)
			{
				if(direction == 2)
				{
					x+= 130 / FPS;
					hitBox1.set(x, y, 27, 96);	
					hitBox2.set(x, y, 48, 72);
				}
				else
				{
					x-= 130 / FPS;
					hitBox1.set(x, y, 27, 96);
					hitBox2.set(x, y, 48, 72);
				}
			}
			else if(ID == 207)
			{
				if(direction == 2)
				{
					x+= 100 / FPS;
					hitBox1.set(x, y, 48, 90);				
				}
				else
				{
					x-= 100 / FPS;
					hitBox1.set(x, y, 48, 90);
				}
			}
			else if(ID == 211)
			{
				if(direction == 2 && isJump == true)
				{
					x+= 200 / FPS;
					hitBox1.set(x + 3 ,y + 3, 42, 42);	

				}
				else if(direction == 1 && isJump == true)
				{
					x-= 200 / FPS;
					hitBox1.set(x + 3 , y + 3 , 42, 42);

				}
			}
			
			
		}
		
		else
		{
			
			if(ID == 202)
			{
				if(direction == 2)
				{
					x+= 250 / FPS;
					hitBox1.set(x, y, 48, 36);
					
					
				}
				else
				{
					x-= 250 / FPS;
					hitBox1.set(x + 6, y, 48,36);
					
				}
			}
			else if(ID == 204)
			{
				if(direction == 2)
				{
					x+= 130 / FPS;
					hitBox1.set(x, y, 27, 48);				
				}
				else
				{
					x-= 130 / FPS;
					hitBox1.set(x + 6, y, 27, 48);
				}
			}
			else if(ID == 206)
			{
				if(direction == 2)
				{
					x+= 100 / FPS;
					hitBox1.set(x, y, 48, 90);				
				}
				else
				{
					x-= 100 / FPS;
					hitBox1.set(x, y, 48, 90);
				}
			}
			else if(ID == 208)
			{
				if(direction == 2)
				{
					x+= 120 / FPS;
					hitBox1.set(x + 3 ,y + 3, 42, 42);	
					hitBox2.set(x, y, 48, 48);
				}
				else
				{
					x-= 120 / FPS;
					hitBox1.set(x + 3 , y + 3 , 42, 42);
					hitBox2.set(x, y, 48, 48);
				}
			}
			else if(ID == 210)
			{
				if(direction == 2 && isJump == true)
				{
					x+= 200 / FPS;
					hitBox1.set(x + 3 ,y + 3, 42, 42);	

				}
				else if(direction == 1 && isJump == true)
				{
					x-= 200 / FPS;
					hitBox1.set(x + 3 , y + 3 , 42, 42);

				}
			}
			
			
		}
		
		if(ID >= 220 && ID <= 222)
		{
			
			if(x > playerX + 20) speedX -= 250/FPS;
			else if(x<playerX + 20) speedX+=250/FPS;

			
			if(speedX > 100) speedX = 100;
			else if(speedX < -100) speedX = -100;
			
			hitBox1.set(x ,y ,72 ,48 );
            x+= speedX / FPS;			
		}
		
		
	}
	
	public void moveY(float playerY, float FPS)
	{
		if(ID % 2 == 1)
		{
			if(ID == 209)
			{
				if(direction == 2)
				{
					y+= 120 / FPS;
					hitBox1.set(x + 3 ,y + 3, 42, 42);	
					hitBox2.set(x, y, 48, 48);
				}
				else
				{
					y-= 120 / FPS;
					hitBox1.set(x + 3 , y + 3 , 42, 42);
					hitBox2.set(x, y, 48, 48);
				}
			}
			else if(ID == 211)
			{
				if(isJump == true && canJump == true)
				{	
					speedY -= 300/(float)FPS;
					if(speedY < -800) speedY = -800;
					y+=(float)((300 + speedY)/(float)FPS);
				}
				else if(canJump == false && isJump == true)
				{
					speedY -= 300/(float)FPS;
					if(speedY < -800) speedY = -800;
					y+=(speedY/(float)FPS);
				}
				else
				{
					speedY = 0;	
				}
				
				
			}
		}
		else if(ID % 2 == 0)
		{
			if(ID == 210)
			{
				if(isJump == true && canJump == true)
				{	
					speedY -= 300/(float)FPS;
					if(speedY < -800) speedY = -800;
					y+=(float)((300 + speedY)/(float)FPS);
				}
				else if(canJump == false && isJump == true)
				{
					speedY -= 300/(float)FPS;
					if(speedY < -800) speedY = -800;
					y+=(speedY/(float)FPS);
				}
				else
				{
					speedY = 0;	
				}
				
				
			}
		}
		
		if(ID >= 220 && ID <= 222)
		{
			
			if(y>playerY +30) speedY-=250/FPS;
			else if(y<playerY + 30) speedY+=250/FPS;
			
			if(speedY > 100) speedY = 100;
			else if(speedY < -100) speedY = -100;
			
			hitBox1.set(x ,y ,72 ,48 );
			y+= speedY / FPS;	
			
		}
	}
	
	public void saveLastPosition()
	{
		lastX = x;
		lastY = y;
	}
	
	public void correctXPosition()
	{
		x = lastX;
	}
	
	public void correctYPosition()
	{
		y = lastY;
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
	

}
