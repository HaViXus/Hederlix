package Elements.Mobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Missile 
{

	public Texture texture;
	public TextureRegion region;
	public float textureTimer;
	public Sprite sprite;
	public Sprite tmp;
	public int frame;
	public float x, y;
	public float angle;
	public float speedX, speedY, speedDelta;
	
	
	public int direction; //1 - left, 2 - right
	public int ID;
	
	public Rectangle hitBox;
	public boolean isActivated = false;
	
	
	//public Sprite test;	
	public Missile(Texture texture,float x, float y)
	{
		this.x = x;
		this.y = y;
		this.texture = texture;
			
			region = new TextureRegion(texture);
			region.setRegion(16, 80, 16, 16);
			hitBox = new Rectangle();
			hitBox.set(x,y,15,15);
			speedDelta = 300;
	
		
		//sprite.setOrigin(originX, originY);
		sprite = new Sprite(region);
		sprite.setBounds(x, y, 48, 48);
		sprite.setOrigin(2, 6);
		
		region.setRegion(5,89,1,1);
		tmp = new Sprite(region);
		
		region.setRegion(3,85,1,1);
		textureHandling();
		//test = new Sprite(region);
		//test.setBounds(x,y,15,15);
		
	}
	
	public void textureHandling()
	{
		textureTimer += Gdx.graphics.getDeltaTime();
		frame = (int)(textureTimer * 10);
		if(frame > 3)
		{
			frame =0;
			textureTimer = 0;
		}
		sprite.setRegion(16 + 16*frame, 80, 16, 16);
		sprite.setRotation(angle);
		
		//tmp.setBounds(x + 12* (float)Math.cos((angle + 90)*Math.PI/180.0),y + 18 * (float)Math.sin((angle+90)*Math.PI/180.0), 15, 15);
		hitBox.setPosition(x + 10* (float)Math.cos((angle + 90)*Math.PI/180.0), y + 18 * (float)Math.sin((angle+90)*Math.PI/180.0));
		//test.setPosition(x + 10* (float)Math.cos((angle + 90)*Math.PI/180.0), y + 18 * (float)Math.sin((angle+90)*Math.PI/180.0));
		
	}
	
	public void move(float playerX, float playerY, float FPS)
	{
		float atan =(float) Math.atan((playerY+30 - y)/(float)(playerX+20 - x));
		angle = (float)(atan*180/Math.PI) + 90;
		if(playerX > x-20)angle += 180;
		
		
		//speedX += 10000 * (float)Math.cos(angle*Math.PI/180);
		//speedY += 10000 * (float)Math.sin(angle*Math.PI/180);
		
		if(x > playerX + 20) speedX -= 700/FPS;
		else if(x<playerX + 20) speedX+=700/FPS;
		if(y>playerY +30) speedY-=700/FPS;
		else if(y<playerY + 30) speedY+=700/FPS;
		
		if(speedX > 200) speedX = 200;
		else if(speedX < -200) speedX = -200;
		if(speedY > 200) speedY = 200;
		else if(speedY < -200) speedY = -200;
		
		
		x += speedX/FPS;
		y += speedY/FPS;
		
		
		
		sprite.setPosition(x, y);
		
	}
	
	public void getTexture(SpriteBatch batch)
	{
		sprite.draw(batch);
		tmp.draw(batch);
	//	test.draw(batch);
	}
	
}
