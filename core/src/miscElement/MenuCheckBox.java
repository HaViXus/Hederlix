package miscElement;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuCheckBox 
{

	private TextureRegion region;
	private Texture texture;
    private Sprite background, signSprite;
    private ArrayList<Sprite> signs;
    
    private String text;
    private int x,y;
    private int scale;
    
    public boolean isActivated;

	
	public MenuCheckBox(int x, int y,String text,Texture texture, boolean isActivated)
	{
		this.x = x;
		this.y= y;
		this.text = text;
		this.texture = texture;
		this.isActivated = isActivated;
		
		region = new TextureRegion(texture);
		signs = new ArrayList<Sprite>();
		
		
		scale = 4;
		
		
		region.setRegion(32,96,16,16);
		background = new Sprite(region);
		background.setBounds(x, y, 16 * scale, 16*scale);
		
		region.setRegion(48,96,16,16);
		signSprite = new Sprite(region);
		signSprite.setBounds(x, y, 16 * scale, 16*scale);
		
		setSings();
		update();
		isActivated = false;
		
		
	}
	
	
	private String chars[] =
	{
					
					"ABCDEFGHIJKLMNOP",
					"QRSTUVWXYZ "
					
	};
	
	public void setSings()
	{

		int xs, ys=0;
		
		for(int i=0;i<text.length();i++)
		{

				
				char ch = text.charAt(i);
				signs.add(0, new Sprite(texture));
				
				for(ys=0;ys<chars.length;ys++)
				{
					
					xs = chars[ys].indexOf(ch);
					if(xs>=0){
						
						if(isActivated == true) region.setRegion(0 + xs*16, 136 + ys*16,7,8);
						else 
						{
							if(ch != ' ') region.setRegion(0 + xs*16, 24 + ys*16,6,8);
							else region.setRegion(0 + xs*16, 24 + ys*16,0,0);
							
						}
						signs.get(0).setRegion(region);
						signs.get(0).setBounds(x + i*16*(scale-2) +  18*scale, y + 4 * scale , 16 * (scale-2), 16 * (scale-2));
						
					}
				}
			
			
		}
		
				
	}
	
	public void update()
	{
		if(isActivated == true) signSprite.setColor(1,1,1,1);
		else signSprite.setColor(1,1,1,0);	
	}
	
	public void render(SpriteBatch miscBatch)
	{
		
		background.draw(miscBatch);
		
		for(int i=0;i<signs.size();i++)
		{
			signs.get(i).draw(miscBatch);
		}
		
		signSprite.draw(miscBatch);
		
	}
	
}
