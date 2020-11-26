package Elements.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class StationarySaw 
{

	public Texture texture;
	public TextureRegion region;
	public Sprite Block,Stand, Stick,Saw;//, test;
	
	public float x,y;
	public float angleSaw, angleStand;
	
	public Rectangle hitbox;
	
	public StationarySaw(Texture texture, int x, int y, int additionalAngle)
	{
		this.x = x;
		this.y = y;
		this.texture = texture;
		
		hitbox = new Rectangle();
		hitbox.set(x + 3, y + 114, 37, 37);
		
		angleStand = 0 + additionalAngle;
		
		region = new TextureRegion(texture);
		region.setRegion(192, 48, 16, 16);
		
		Block = new Sprite(region);
		Block.setBounds(x, y, 48, 48);
		
		region.setRegion(208, 32, 4, 39);
		Stick = new Sprite(region);
		Stick.setBounds(x+18, y+18, 12, 117);
		Stick.setOrigin(6, 6);
		
		region.setRegion(192, 64, 16, 16);
		Stand = new Sprite(region);
		Stand.setBounds(x + 9, y + 9, 48, 48);
		Stand.setOrigin(15, 15);
		
		region.setRegion(192, 32, 16, 16);
		Saw = new Sprite(region);
		Saw.setOrigin(24, 24);
		Saw.setBounds(x, y + 111 , 48, 48);
		
		region.setRegion(2,2,1,1);
	//	test = new Sprite(region);
	//	test.setBounds(x +3, y + 114, 33, 33);

	}
	
	public void stationarySawHandling(float FPS)
	{
		if(FPS < 15) FPS = 15;
		angleStand -= 75 / FPS;
		angleSaw += 420/FPS;
		if(angleSaw > 360) angleSaw = 0;
		if(angleStand < 0) angleStand = 360;
		
		Saw.setRotation(angleSaw);
		Stand.setRotation(angleStand);
		Stick.setRotation(angleStand - 90);
		
		float posX = (float) Math.cos(angleStand*Math.PI/180 );
		float posY = (float) Math.sin(angleStand*Math.PI/180 );
		
		Saw.setPosition(x + posX*111, y + posY*111);
		hitbox.set(x + 1 + posX*111, y + 6  + posY * 114, 42, 42);
		//test.setPosition(x + 9 + posX*111, y + 6  + posY * 114);
		
		
	}
	
	public void draw(SpriteBatch batch)
	{
		Block.draw(batch);
		Stand.draw(batch);
		Stick.draw(batch);
		Saw.draw(batch);
		//test.draw(batch);
		
	}
	
	
}
