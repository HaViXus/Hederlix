package miscElement;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuSlider 
{

	private TextureRegion region;
	private Texture texture;
    private ArrayList<Sprite> background;
    private ArrayList<Sprite> signs;
    private Sprite sliderSprite;
    
    private String text;
    private int x,y,width, type;
    private int scale;
    private float maxValue; 
    
    public float value;
    public int jump;
    
    public boolean isActivated;
    public boolean isVisible;
    public boolean isLocked;
	
	public MenuSlider(int x, int y, int width,float value, float maxValue, int type, String text,Texture texture)
	{
		this.x = x;
		this.y= y;
		this.text = text;
		this.texture = texture;
		this.maxValue = maxValue;
		this.width = width;
		this.type = type;
        this.value = value;
		
		region = new TextureRegion(texture);
		signs = new ArrayList<Sprite>();
		background = new ArrayList<Sprite>();
		
		
		
		scale = 4;
		jump = (int)((float)(value/maxValue)*20);
		
		if(type == 1)
		{
			jump = (int)value;
			this.value = 60 + 50*jump;
		}
		
		
		region.setRegion(64,80,6,16);
		sliderSprite = new Sprite(region);
		sliderSprite.setBounds(x, y - 8*(scale+ 0.5f),12*scale, 21*(scale+ 0.5f));
		sliderHandlig();
		
		isActivated = false;
		isVisible = true;
		isLocked = false;
		
		//setSings();
		update();
		
	}
	
	
	private String chars[] =
		{
					
					"ABCDEFGHIJKLMNOP",
					"QRSTUVWXYZ,:?!()",
					"1234567890%/. "
					
		};
	
	public void setSings()
	{

		int tmpWidth = 0;
		String tmpText = "";
		int xs, ys=0;
		
		
		if(type == 0) tmpText = text + (int)((float)(value/maxValue)*100) + "%"; //percent
		else if(type == 1)
		{
			if(jump != 20) tmpText = text + (int)(value);
			else tmpText = text + "NO LIMIT";
		}
		
		tmpWidth = tmpText.length(); //max line length
		
		for(int i=0;i<tmpText.length();i++)
		{

				
				char ch = tmpText.charAt(i);
				signs.add(0, new Sprite(texture));
				
				for(ys=0;ys<chars.length;ys++)
				{
					
					xs = chars[ys].indexOf(ch);
					if(xs>=0){
						
									
						region.setRegion(0 + xs*16, 24 + ys*16,6,8);
							
						
						signs.get(0).setRegion(region);
						signs.get(0).setBounds(x + i*16*scale - 8*tmpWidth, y , 16 * scale, 16 * scale);
						
					}
				}
			
			
		}
		
		
			for(int i = 0; i <= width + 1; i++)
			{
					
					
					if(i==0) region.setRegion(32, 84, 8, 12);
	                else if(i == width + 1) region.setRegion(48, 84 , 8, 12);
	                else region.setRegion(40, 84, 8, 12);
					
					
				background.add(0, new Sprite(region));
				background.get(0).setBounds(x - 16 + i*16*scale - 32*scale ,y - 4 * (scale-1) - 2, 16 * scale, 16 * (scale+1));
			}
		
		
				
	}
	
	public void update()
	{
		for(int i=0;i<signs.size();i=i) signs.remove(i);
		for(int i=0;i<background.size();i=i) background.remove(i);
		setSings();
		
		if(isActivated == true  && isLocked == false) region.setRegion(80,80,6,16);
		else region.setRegion(64,80,6,16);
		sliderSprite.setRegion(region);
	}
	
	public void sliderHandlig()
	{

		if(isActivated == true) region.setRegion(80,80,6,16);
		else region.setRegion(64,80,6,16);
		sliderSprite.setRegion(region);
			
		int tmpX = 0;
		tmpX = x + (int)(((width * 16 * scale + 3 * scale) *(float)(jump/19.0))) + 2 * scale;
		sliderSprite.setPosition(tmpX - 32*scale - 16, y - 6*scale + 4);
		
	}
	
	public void moveRight()
	{
		
		
		if(jump<20)
		{
			jump ++;
			if(type == 0) value = (float)((jump/20.0) * maxValue); 
			else if(type == 1) value = 60 +  (float)((jump/20.0) * maxValue); 
			
			update();
			sliderHandlig();
			setSings();
		}
		
	}
	
	public void moveLeft()
	{
		
		if(jump>0)
		{
			jump --;
			if(type == 0) value = (float)((jump/20.0) * maxValue); 
			else if(type == 1) value = 60 +  (float)((jump/20.0) * maxValue); 
			
			update();
			sliderHandlig();
			setSings();
		}
		
	}
	
	public void render(SpriteBatch miscBatch)
	{
		
		
		
		for(int i=0;i<background.size();i++)
		{
			if(isLocked == true) background.get(i).setColor(0.3f,0.3f,0.3f,1.0f);
			else background.get(i).setColor(1f,1f,1f,1.0f);
			
			background.get(i).draw(miscBatch);
		}
		
		if(isLocked == true) sliderSprite.setColor(0.3f,0.3f,0.3f,1.0f);
		else sliderSprite.setColor(1f,1f,1f,1.0f);
		
		sliderSprite.draw(miscBatch);
		
		for(int i=0;i<signs.size();i++)
		{
			if(isLocked == true) signs.get(i).setColor(0.3f,0.3f,0.3f,1.0f);
			else signs.get(i).setColor(1f,1f,1f,1.0f);

			signs.get(i).draw(miscBatch);
		}
		
		
		
		
	}
	
	public void dispose()
	{
		for(int i=0;i<signs.size();i=i) signs.remove(i);
		for(int i=0;i<background.size();i=i) background.remove(i);
	}
	
}
