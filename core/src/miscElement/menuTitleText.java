package miscElement;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class menuTitleText 
{

	public String text;
	
	
	public int x,y;
	public int ID;
	public float scale;
	public Texture texture;
	public TextureRegion region;
		
	public ArrayList<Sprite> signs;
	public ArrayList<Sprite> background;
	
		
		
	public menuTitleText(int x, int y, String text, Texture texture, float scale)
	{
		
		this.x = x;
		this.y = y;
		this.text = text;
		this.texture = texture;
		this.scale = scale;
		
		signs = new ArrayList<Sprite>();
		region = new TextureRegion(texture);
		
		setScreenTitle();
		
	}
		
		
		
		private String chars[] =
			{
						
						"ABCDEFGHIJKLMNOP",
						"QRSTUVWXYZ ",
						"1234567890'"
						
			};
		
		
		
		public void setScreenTitle()
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
						if(xs>=0)
						{
							
							region.setRegion(0 + xs*16, 136 + ys*16,7,8);
							
							signs.get(0).setRegion(region);
							signs.get(0).setBounds(x + i*16*scale - 8*tmpWidth, y , 16 * scale, 16 * scale);
							
						}
					}
				
			}
		}
	
	public void render(SpriteBatch miscBatch)
	{
		for(int i=0;i<signs.size();i++) signs.get(i).draw(miscBatch);
	}
	
	public void dispose()
	{
		for(int i=0;i<signs.size();i=i) signs.remove(i);
	}
	
	
}
