package miscElement;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class menuText 
{

	public String text[];
		
		
	public int x,y;
	public int ID;
	public float scale;
	public Texture texture;
	public TextureRegion region;
		
	public ArrayList<Sprite> signs;
	public ArrayList<Sprite> background;
	
		
		
	public menuText(int x, int y, String text[], Texture texture, float scale)
	{
		
		this.x = x;
		this.y = y;
		this.text = text;
		this.texture = texture;
		this.scale = scale;
		
		signs = new ArrayList<Sprite>();
		region = new TextureRegion(texture);
		
		setSings();
		
	}
		
		
		
		private String chars[] =
			{
						
						"ABCDEFGHIJKLMNOP",
						"QRSTUVWXYZ,:?!()",
						"1234567890%/.' "
						
			};
		
		
		
	public void setSings()
	{

		int tmpWidth = 0;
		int xs, ys=0;
		
		for(int i=0;i<text.length;i++) if(text[i].length() > tmpWidth) tmpWidth = text[i].length(); //max line length
		
		for(int i=0;i<text.length;i++)
		{

			for(int j=0;j<text[i].length();j++)
			{	
				char ch = text[i].charAt(j);
				signs.add(0, new Sprite(texture));
				for(ys=0;ys<chars.length;ys++)
				{
					
					xs = chars[ys].indexOf(ch);
					if(xs>=0){
						
						region.setRegion(0 + xs*16, 24 + ys*16,6,8);
						signs.get(0).setRegion(region);
						signs.get(0).setBounds(x + j*16*scale - 8*tmpWidth*scale, y - i*16*scale, 16*scale, 16*scale);
						
					}
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
