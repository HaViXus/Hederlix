package Elements;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class blockParticle 
{


	public float x,y;
	public int IDBlock, IDobject;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public int windowX, windowY;
	public float alphaTimer;
	
	
	private float rotateAlpha;
	private float speedX, speedY, startYSpeed;

	
	public blockParticle(Texture texture,float x, float y, int IDBlock, int IDobject)
	{
		
		
		this.x = x;
		this.y = y;
		this.IDBlock = IDBlock;
		this.IDobject = IDobject;
		this.texture = texture;	
		region = new TextureRegion(texture);
		
		windowX =(int) x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		sprite = new Sprite();		
		
		setTexture();
		Random generator = new Random();
		
		if(IDBlock == 125)
		{
			if(IDobject % 2 == 0) speedX = -80* generator.nextFloat();
			else speedX = 80* generator.nextFloat();
			startYSpeed = 80 + 120 * generator.nextFloat();
		}
		else
		{
			if(IDobject % 2 == 0) speedX = -60* generator.nextFloat();
			else speedX = 60* generator.nextFloat();
			startYSpeed = 50 + 100 * generator.nextFloat();
		}
			
		
		
		
		rotateAlpha = - 150 + 300 * generator.nextFloat();
		if(rotateAlpha < 70 && rotateAlpha >= 0) rotateAlpha = 70;
		else if(rotateAlpha > -70 && rotateAlpha < 0) rotateAlpha = -70;
		
		
		
	}
	
	public void setTexture()
	{

		if(IDBlock == 125) //glass
		{
			region.setRegion(64 + 4*IDobject/2 ,128 + 4*IDobject/2,4,4);
			sprite.setBounds(x,y,16,16);
		}
		else if(IDBlock == 126)// iron
		{
			region.setRegion(32 + 4*IDobject/2,144 + 4*IDobject%2,4,4);
			sprite.setBounds(x,y,16,16);
		}
		else if(IDBlock == 127)// redIron
		{
			region.setRegion(64 + 4*IDobject/2,144 + 4*IDobject%2,4,4);
			sprite.setBounds(x,y,16,16);
		}
		
		sprite.setRegion(region);
		
		
	}
	
	public void blockParticleHandling()
	{
		
		if(alphaTimer < 3) alphaTimer += Gdx.graphics.getDeltaTime();
		if(alphaTimer > 3) alphaTimer = 3;
		
		
		float mnoznik =  Gdx.graphics.getDeltaTime();
		speedY -= 500 * mnoznik;
		if(speedY - startYSpeed < -800) speedY = -800 + startYSpeed;
		y+=(float)(startYSpeed + speedY) * mnoznik;
		
		x += speedX * mnoznik;
		
		windowX = (int) x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		sprite.setPosition(x, y);
		sprite.setColor(1,1,1,1-alphaTimer/3.0f);
		sprite.rotate(rotateAlpha * mnoznik);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}

	
}
