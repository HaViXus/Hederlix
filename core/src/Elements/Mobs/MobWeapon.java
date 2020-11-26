package Elements.Mobs;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MobWeapon 
{

	public Texture texture;
	public TextureRegion region;
	public float textureTimer;
	public Sprite sprite;
	public int frame;
	public float x, y;
	public float angle;
	public float speed;
	
	private float speedX, speedY;
	
	
	public int direction; //1 - left, 2 - right
	public int ID;
	
	public Rectangle hitBox;
	
	
	public MobWeapon(Texture texture,float x, float y, int ID)
	{
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.texture = texture;
		
		if(ID == 1)//small weapon
		{
			region = new TextureRegion(texture);
			region.setRegion(16 + 16*frame, 64, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,9,9);
			speed = 300;
		}
		else if(ID == 2)// large weapon
		{
			region = new TextureRegion(texture);
			region.setRegion(80 + 16*frame, 80, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,18,18);
			speed = 150;
		}
		else if(ID == 3)// explode weapon
		{
			region = new TextureRegion(texture);
			region.setRegion(80 + 16*frame, 64, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,12,12);
			speed = 120;
		}
		else if(ID == 4)//large weapon fast
		{
			region = new TextureRegion(texture);
			region.setRegion(0, 64, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,16,16);
			speed = 300;
		}
		else if(ID == 5)// boss weapon
		{
			region = new TextureRegion(texture);
			region.setRegion(0, 64, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,16,16);
			speed = 350;
		}
		else if(ID == 6)// boss weapon - kasete
		{
			region = new TextureRegion(texture);
			region.setRegion(144, 96, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,21,21);
			speed = 300;
		}
		else if(ID == 7)// boss weapon - mortal
		{
			region = new TextureRegion(texture);
			region.setRegion(160, 96, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,21,21);
			
			Random generator = new Random();
			if(generator.nextInt(2) == 1)speedX = -250 *generator.nextFloat();
			else speedX = 250 *generator.nextFloat();
			speedY = 300 + 150 * generator.nextFloat();
		}
		else if(ID == 8 || ID == 9)// boss weapon - spirale //left && right
		{
			region = new TextureRegion(texture);
			region.setRegion(160, 80, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,18,18);
			speed = 150;
		}
		
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
	}
	
	public void Handle()
	{
		
		textureTimer += Gdx.graphics.getDeltaTime();
		frame = (int) (textureTimer * 10);
		
		if(ID == 1)
		{	
			if(frame > 3)
			{
				frame = 0;
				textureTimer = 0;
			}
			region.setRegion(16 + 16*frame, 64, 16, 16);	
		}
		else if(ID == 2)
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
			region.setRegion(80 + 16*frame, 80, 16, 16);	
		}
		else if(ID == 3)
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
			region.setRegion(80 + 16*frame, 64, 16, 16);	
		}
		else if(ID == 5)
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
			region.setRegion(160 + 16*frame, 64, 16, 16);	
		}
		else if(ID == 7)
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
			region.setRegion(160 + 16*frame, 96, 16, 16);	
		}
		else if(ID == 8 || ID == 9)
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
			region.setRegion(160 + 16*frame, 80, 16, 16);	
		}
		
		
		sprite.setRegion(region);
	}
	
	public void move(float FPS)
	{
		if(ID >= 1 && ID <= 6)
		{
			x += speed * Math.cos(angle*Math.PI/180.0) /FPS;
			y += speed * Math.sin(angle*Math.PI/180.0) /FPS;
		}
		else if(ID == 7)
		{
			if(speedY > -800) speedY -= 100/FPS;
			if(speedY < -800) speedY = -800;
			x += speedX/FPS;
			y += speedY/FPS;
		}
		else if(ID == 8 || ID == 9)
		{
			
			if(ID == 8) angle += 50/FPS;
			else angle -= 50/FPS;
			
			speed += 50.0/(float)FPS;
			
			x +=(float) (speed * Math.cos(angle*Math.PI/180.0) /FPS) ;
			y +=(float) (speed * Math.sin(angle*Math.PI/180.0) /FPS);
		}
		hitBox.setPosition(x,y);
		sprite.setPosition(x, y);
	}
	
	public Sprite getTexture()
	{
		return sprite;	
	}
	
	
}
