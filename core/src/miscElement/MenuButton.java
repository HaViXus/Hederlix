package miscElement;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuButton 
{
	
	private TextureRegion region;
	private Texture texture;
    private ArrayList<Sprite> background;
    private ArrayList<Sprite> signs;
    
    private String text;
    private int x,y;
    private int scale;
    
    public boolean isActivated;
    public boolean isBackground;
    public boolean isVisible;
    public boolean isLocked;
	
	public MenuButton(int x, int y,String text,Texture texture, boolean isBackground)
	{
		this.x = x;
		this.y= y;
		this.text = text;
		this.texture = texture;
		this.isBackground = isBackground;
		
		region = new TextureRegion(texture);
		signs = new ArrayList<Sprite>();
		background = new ArrayList<Sprite>();
		
		scale = 4;
		
		setSings();
		isActivated = false;
		isVisible = true;
		isLocked = false;
		
		
	}
	
	
	private String chars[] =
	{
					
					"ABCDEFGHIJKLMNOP",
					"QRSTUVWXYZ "
					
	};
	
	public void setSings()
	{

		int tmpWidth = 0;
		int xs, ys=0;
		
		tmpWidth = text.length(); //max line length
		
		for(int i=0;i<text.length();i++)
		{

				
				char ch = text.charAt(i);
				signs.add(0, new Sprite(texture));
				
				for(ys=0;ys<chars.length;ys++)
				{
					
					xs = chars[ys].indexOf(ch);
					if(xs>=0){
						
						if(isActivated == true && isLocked == false) region.setRegion(0 + xs*16, 136 + ys*16,7,8);
						else 
						{
							if(ch != ' ') region.setRegion(0 + xs*16, 24 + ys*16,6,8);
							else region.setRegion(0 + xs*16, 24 + ys*16,0,0);
							
						}
						signs.get(0).setRegion(region);
						signs.get(0).setBounds(x + i*16*scale - 8*tmpWidth, y , 16 * scale, 16 * scale);
						
					}
				}
			
			
		}
		
		if(isBackground)
		{
			for(int i = 0; i <= tmpWidth + 1; i++)
			{
					
					
					if(i==0) region.setRegion(0, 100, 8, 12);
	                else if(i == tmpWidth + 1) region.setRegion(16, 100 , 8, 12);
	                else region.setRegion(8, 100, 8, 12);
					
					
				background.add(0, new Sprite(region));
				background.get(0).setBounds(x - 16 + i*16*scale - 32*scale ,y - 4 * (scale-1) - 2, 16 * scale, 16 * (scale+1));
			}
		}
		
				
	}
	
	public void update()
	{
		for(int i=0;i<signs.size();i=i) signs.remove(i);
		for(int i=0;i<background.size();i=i) background.remove(i);
		setSings();
	}
	
	public void render(SpriteBatch miscBatch)
	{
		
		
		
		for(int i=0;i<background.size();i++)
		{
			if(isLocked == true) background.get(i).setColor(0.3f,0.3f,0.3f,1.0f);
			else background.get(i).setColor(1f,1f,1f,1.0f);
			
			background.get(i).draw(miscBatch);
		}
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
