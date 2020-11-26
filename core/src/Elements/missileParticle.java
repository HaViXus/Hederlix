package Elements;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class missileParticle
{
	
	public float x,y;
	public int IDweapon, IDobject;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public int windowX, windowY;
	public float alphaTimer;
	
	
	private int frame;
	private float rotateAlpha;
	private float speedX, speedY, startYSpeed;

	
	public missileParticle(Texture texture,float x, float y, int IDweapon, int IDobject, int frame)
	{
		
		
		this.x = x;
		this.y = y;
		this.IDweapon = IDweapon;
		this.IDobject = IDobject;
		this.frame = frame;
		this.texture = texture;	
		region = new TextureRegion(texture);
		
		windowX =(int) x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		sprite = new Sprite();		
		
		setTexture();
		Random generator = new Random();
		
		if(IDweapon != 10)
		{
			if(IDobject % 2 == 0) speedX = -60* generator.nextFloat();
			else speedX = 60* generator.nextFloat();
			startYSpeed = 50 + 100 * generator.nextFloat();
		}
		else
		{
			if(IDobject % 2 == 0) speedX = -100* generator.nextFloat();
			else speedX = 100* generator.nextFloat();
			startYSpeed = 100 + 110 * generator.nextFloat();
		}
		
		rotateAlpha = - 150 + 300 * generator.nextFloat();
		if(rotateAlpha < 70 && rotateAlpha >= 0) rotateAlpha = 70;
		else if(rotateAlpha > -70 && rotateAlpha < 0) rotateAlpha = -70;
		
		
		
	}
	
	public void setTexture()
	{

		if(IDweapon == 1) //small shoot
		{
			region.setRegion(17 + 16 * frame,77,1,1);
			sprite.setBounds(x,y,3,3);
		}
		else if(IDweapon == 2)// large shoot
		{
			region.setRegion(80 + 3*IDobject/2 + 16 * frame,90 + 3*IDobject%2,3,3);
			sprite.setBounds(x,y,9,9);
		}
		else if(IDweapon == 3)// explosion shoot
		{
			region.setRegion(80 + 2*IDobject/2 + 16 * frame,76 + 2*IDobject%2,2,2);
			sprite.setBounds(x,y,6,6);
		}
		else if(IDweapon == 4)// speed shoot
		{
			region.setRegion(0 + 2*IDobject/2,77 + 2*IDobject%2,2,2);
			sprite.setBounds(x,y,6,6);
		}
		else if(IDweapon == 5)//boss weapon
		{
			region.setRegion(160 + 3*IDobject/2 + 16 * frame,74 + 3*IDobject%2,3,3);
			sprite.setBounds(x,y,6,6);
		}
		else if(IDweapon == 6)//boss weapon - kasete
		{
			region.setRegion(144 + 3*IDobject/2 ,106 + 3*IDobject%2,3,3);
			sprite.setBounds(x,y,6,6);
		}
		else if(IDweapon == 7)//boss weapon - mortal
		{
			region.setRegion(160 + 3*IDobject/2 + 16 * frame,105 + 3*IDobject%2,3,3);
			sprite.setBounds(x,y,6,6);
		}
		else if(IDweapon == 8 || IDweapon == 9)// boss weapon - spirale
		{
			region.setRegion(160 + 3*IDobject/2 + 16 * frame,89 + 3*IDobject%2,3,3);
			sprite.setBounds(x,y,6,6);
		}
		
		else if(IDweapon == 10)
		{
			if(IDobject >= 0 && IDobject <3) region.setRegion(49,85,2,2);
			else if(IDobject >= 3 && IDobject <6) region.setRegion(48,91,1,1);
			else region.setRegion(65,87,2,2);
			
			sprite.setBounds(x,y,3 * region.getRegionWidth(),3 * region.getRegionHeight());
		}
		
		sprite.setRegion(region);
		
		
	}
	
	public void missileParticleHandling()
	{
		
		if(alphaTimer < 3) alphaTimer += Gdx.graphics.getDeltaTime();
		if(alphaTimer > 3) alphaTimer = 3;
		
		
		float mnoznik =  Gdx.graphics.getDeltaTime();
		speedY -= 300 * mnoznik;
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
