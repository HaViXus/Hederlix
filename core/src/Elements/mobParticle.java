package Elements;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class mobParticle 
{

	public float x,y;
	public int IDmob, IDobject;
	public Texture texture;
	public TextureRegion region;
	public Sprite sprite;
	
	public int windowX, windowY;
	public float alphaTimer;
	public float maxAlphaTime;
	
	private float speedX, speedY, startYSpeed, fallSpeed;
	private float rotateAlpha;
	public boolean isDisappearing;

	
	public mobParticle(Texture texture,float x, float y, int IDmob, int IDobject)
	{
		
		
		this.x = x;
		this.y = y;
		this.IDmob = IDmob;
		this.IDobject = IDobject;
		this.texture = texture;	
		region = new TextureRegion(texture);
		
		windowX =(int) x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		sprite = new Sprite();		
		
		setTexture();
		Random generator = new Random();
		
		if(IDmob != 251)
		{
			if(IDobject % 2 == 0) speedX = -30 + -110* generator.nextFloat();
			else speedX = 30 + 110 * generator.nextFloat();
			
			startYSpeed = 90 + 70 * generator.nextFloat();
			fallSpeed = startYSpeed;
			maxAlphaTime = 4;
		}
		else
		{
			if(IDobject % 2 == 0) speedX = -5 + -240* generator.nextFloat();
			else speedX = 5 + 240 * generator.nextFloat();
			
			startYSpeed = 220 + 230 * generator.nextFloat();
			fallSpeed = startYSpeed;
			maxAlphaTime = 7;
		}
		
		rotateAlpha = - 150 + 300 * generator.nextFloat();
		if(rotateAlpha < 70 && rotateAlpha >= 0) rotateAlpha = 70;
		else if(rotateAlpha > -70 && rotateAlpha < 0) rotateAlpha = -70;
		isDisappearing = true;
		
	}
	
	public void setTexture()
	{
        if(IDmob == 1)
        {
        	if(IDobject == 0) region.setRegion(11,12,6,5);
			else if(IDobject == 1) region.setRegion(12,6,5,6);
			else if(IDobject == 2) region.setRegion(6,5,4,6);		
			else region.setRegion(0,12,5,6);
        }
        else if(IDmob == 200)// sandwitch
        {
        	if(IDobject == 0) region.setRegion(143,0,18,16);
        }
        else if(IDmob == 201) //shield
		{
			if(IDobject == 0) region.setRegion(28,124,4,4);
			else if(IDobject == 1) region.setRegion(51,113,5,4);
			else if(IDobject == 2) region.setRegion(0,105,2,23);		
			else region.setRegion(3,106,13,7);
		}
		else if(IDmob == 202)// rover
		{
			if(IDobject == 0) region.setRegion(3,69,10,5);
			else if(IDobject == 1 ) region.setRegion(5,72,2,2);
			else if(IDobject == 2) region.setRegion(5,71,3,3);
			else region.setRegion(0,73,16,7);		
		}
		else if(IDmob == 203)// shooter
		{
			if(IDobject == 0) region.setRegion(67,32,5,5);
			else if(IDobject == 1 ) region.setRegion(64,40,8,3);
			else if(IDobject == 2) region.setRegion(5,60,4,4);
			else region.setRegion(66,43,2,3);		
		}
		else if(IDmob == 204)// rocker
		{
			if(IDobject == 0) region.setRegion(67,48,5,5);
			else if(IDobject == 1 ) region.setRegion(64,56,8,3);
			else if(IDobject == 2) region.setRegion(5,60,4,4);
			else region.setRegion(66,59,2,3);		
		}
		else if(IDmob == 205)// height robot
		{
			if(IDobject == 0) region.setRegion(20,32,7,7);
			else if(IDobject == 1 ) region.setRegion(17,32,2,15);
			else if(IDobject == 2) region.setRegion(17,52,1,11);
			else if(IDobject == 3) region.setRegion(7,60,4,4);
			else if(IDobject == 4) region.setRegion(17,48,3,4);
			else if(IDobject == 5) region.setRegion(26,44,2,2);
			else region.setRegion(21,5,3,3);		
		}
		else if(IDmob == 206)// !!! kamikadze
		{
			if(IDobject == 0) region.setRegion(0,178,16,10);
			else if(IDobject == 1 ) region.setRegion(0,200,8,8);
			else if(IDobject == 2) region.setRegion(52,190,4,1);
			else if(IDobject == 3) region.setRegion(61,201,3,2);
			else if(IDobject == 4) region.setRegion(0,191,1,3);
			else if(IDobject == 5) region.setRegion(42,192,3,2);
			else region.setRegion(96,201,2,2);		
		}
		else if(IDmob == 207)// tnt kamikadze
		{
			if(IDobject == 0) region.setRegion(64,178,16,10);
			else if(IDobject == 1 ) region.setRegion(128,200,8,8);
			else if(IDobject == 2) region.setRegion(116,190,4,1);
			else if(IDobject == 3) region.setRegion(125,201,3,2);
			else if(IDobject == 4) region.setRegion(128,191,1,3);
			else if(IDobject == 5) region.setRegion(116,192,3,2);
			else region.setRegion(96,201,2,2);		
		}
		else if(IDmob == 210)// jumper
		{
			if(IDobject == 0) region.setRegion(48,20,4,6);
			else if(IDobject == 1 ) region.setRegion(48,28,6,4);
			else if(IDobject == 2) region.setRegion(52,16,7,4);
			else if(IDobject == 3) region.setRegion(57,23,2,2);
			else if(IDobject == 4) region.setRegion(60,23,5,2);
			else if(IDobject == 5) region.setRegion(50,22,1,2);
			else region.setRegion(59,22,3,1);		
		}
		else if(IDmob == 211)// jumper
		{
			if(IDobject == 0) region.setRegion(96,20,4,6);
			else if(IDobject == 1 ) region.setRegion(96,28,6,4);
			else if(IDobject == 2) region.setRegion(100,16,7,4);
			else if(IDobject == 3) region.setRegion(105,23,2,2);
			else if(IDobject == 4) region.setRegion(108,23,5,2);
			else if(IDobject == 5) region.setRegion(98,22,1,2);
			else region.setRegion(107,22,3,1);		
		}
		else if(IDmob >= 223 && IDmob <= 228)
		{
			
			if(IDmob >= 223 && IDmob <= 225)
			{
				if(IDobject == 0) region.setRegion(0 + 16 * (IDmob-223),0,3,3);
				else if(IDobject == 1 ) region.setRegion(12 + 16 * (IDmob-223),2,3,3);
				else if(IDobject == 2) region.setRegion(10 + 16 * (IDmob-223),4,3,3);
				else if(IDobject == 3) region.setRegion(8 + 16 * (IDmob-223),2,2,2);
				else if(IDobject == 4) region.setRegion(8 + 16 * (IDmob-223),2,2,2);
				else if(IDobject == 5) region.setRegion(10 + 16 * (IDmob-223),4,3,3);
				else if(IDobject == 6) region.setRegion(8 + 16 * (IDmob-223),2,4,2);
				else  region.setRegion(8 + 16 * (IDmob-223),2,3,2);
				
			}
			else if(IDmob == 226)
			{
				if(IDobject < 4) region.setRegion(34,18,2,2);				
				else if(IDobject == 5) region.setRegion(44,24,3,3);
				else if(IDobject == 6) region.setRegion(40,16,2,3);
				else if(IDobject == 7) region.setRegion(46,30,2,2);
				else region.setRegion(38,29,2,4);	
			}
			else
			{
				if(IDobject == 0) region.setRegion(48 + 16 * (IDmob-227),0,2,2);
				else if(IDobject == 1) region.setRegion(48 + 16 * (IDmob-227),0,4,2);
				else if(IDobject == 2) region.setRegion(49 + 16 * (IDmob-227),1,2,2);
				else if(IDobject == 3) region.setRegion(48 + 16 * (IDmob-227),0,3,3);
				else if(IDobject == 4) region.setRegion(52 + 16 * (IDmob-227),13,1,3);
				else if(IDobject == 5) region.setRegion(60 + 16 * (IDmob-227),2,2,2);
				else if(IDobject == 6) region.setRegion(60 + 16 * (IDmob-227),2,4,2);
				else region.setRegion(59 + 16 * (IDmob-227),12,3,2);	
			}
			
			
		}
		else if(IDmob >=212 && IDmob <= 215)// orange tower
		{
			if(IDobject == 0) region.setRegion(9,133,7,6);
			else if(IDobject == 1) region.setRegion(5,133,4,5);
			else if(IDobject == 2) region.setRegion(1,137,7,3);
			else region.setRegion(0,128,5,6);
			
		}
		else if(IDmob >=216 && IDmob <= 219)// orange tower
		{
			if(IDobject == 0) region.setRegion(9,149,7,6);
			else if(IDobject == 1) region.setRegion(5,149,4,5);
			else if(IDobject == 2) region.setRegion(1,144,5,6);
			else region.setRegion(0,153,7,3);
	
		}
		else if(IDmob >= 220 && IDmob<= 222)// bat orange, violet, blue
		{
			if(IDobject == 0) region.setRegion(9 + 64 * (IDmob-220),90,6,6);
			else if(IDobject == 1) region.setRegion(0 + 64 * (IDmob-220),88,9,8);
			else region.setRegion(15 + 64 * (IDmob-220),88,9,8);
			
		}
		else if(IDmob == 251)
		{
			if(IDobject < 2) region.setRegion(0,209,8,8);
			else if(IDobject >=2 && IDobject <5) region.setRegion(14,225,5,10);
			else if(IDobject >=5 && IDobject <7) region.setRegion(5,219,5,5);
			else if(IDobject >=7 && IDobject <10) region.setRegion(1,219,3,3);
			else if(IDobject >=10 && IDobject <14) region.setRegion(1,222,2,2);
			else if(IDobject >=14 && IDobject <18) region.setRegion(2,218,1,2);
			else if(IDobject == 18 ) region.setRegion(48,219,13,10);
			else region.setRegion(49,229,5,18);
		}
		
		
		
		sprite.setBounds(x,y,region.getRegionWidth() * 3,region.getRegionHeight() * 3);
		sprite.setOrigin(region.getRegionWidth() * 3/2, region.getRegionHeight() * 3/2);
		sprite.setRegion(region);
		
		
	}
	
	public void mobParticleHandling()
	{
		
			if(alphaTimer < maxAlphaTime) alphaTimer += Gdx.graphics.getDeltaTime();
			if(alphaTimer > maxAlphaTime) alphaTimer = maxAlphaTime;
		
		
		
		
		float mnoznik =  Gdx.graphics.getDeltaTime();
		speedY -= 550 * mnoznik;
		if(speedY  < -800) speedY = -800 ;
		fallSpeed += speedY * mnoznik;
		y+=fallSpeed * mnoznik;
		
		x += speedX * mnoznik;
		
		windowX = (int) x/1296;
		if(y < 0) windowY = -(int)(y/720) + 1;
		else windowY = -(int)(y/720);
		
		
		if(isDisappearing == true)sprite.setColor(1,1,1,1-alphaTimer/maxAlphaTime);
		
		sprite.setPosition(x, y);
		sprite.rotate(rotateAlpha * mnoznik);
		
	}
	
	public Sprite getTexture()
	{
		return sprite;
	}
	
}
