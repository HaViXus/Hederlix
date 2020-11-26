package Hedelix;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader.ParticleType;

import Elements.mobParticle;
import Sound.MusicEffect;
import miscElement.MenuButton;
import miscElement.MenuCheckBox;
import miscElement.MenuSlider;
import miscElement.menuText;




public class Options
{

	public boolean isReturn, isSelected;
	private int selectedNumber;
	
	private OrthographicCamera miscCamera;
	private SpriteBatch miscBatch;
	
	private Sprite vrenchSprite1, vrenchSprite2;
	private Sprite arrowSprite;
	private Texture miscTexture;
	private Texture mobTexture;
	private TextureRegion region; 
	
	private ArrayList<Sprite> signs;
	private ArrayList<MenuSlider> menuSliders;
	private ArrayList<MenuCheckBox> menuCheckBoxs;

	
	private menuText MenuTextAuthor;
	private menuText MenuTextMusic;
	
	private MenuButton buttonReturn;
	
	private Preferences prefs;
	private boolean showAutors;
	
	
	private String textAuthor[] = 
	{	
				"HAVIX"	
	};
	
	private String textMusic[] = 
	{
		        "MUSIC: ERIC SKIFF",
		        "TRANSLATOR: DZIOBAKOSTA"
	};
	
	
	
	public Options(Texture miscTexture, Texture mobTexture)
	{
		this.miscTexture = miscTexture;	
		this.mobTexture = mobTexture;
		signs = new ArrayList<Sprite>();
		menuSliders = new ArrayList<MenuSlider>();
		
		prefs = Gdx.app.getPreferences("Havix.Hederlix.settings.preferences");
	
	}
	
	public void create(boolean showAutors)
	{
		
		miscBatch = new SpriteBatch();
		
		miscCamera = new OrthographicCamera(1296,720);
		miscCamera.position.set(648,360,0);
		miscCamera.update();
		
		region = new TextureRegion(miscTexture);
		
		region.setRegion(112, 111, 16, 17);
		vrenchSprite1 = new Sprite(region);
		vrenchSprite1.setBounds(1150, 590, 96 , 102);
		
		region.setRegion(96, 111, 16, 17);
		vrenchSprite2 = new Sprite(region);
		vrenchSprite2.setBounds(50, 590, 96 , 102);
		
		setScreenTitle(375, 600, "OPTIONS");
		
		region.setRegion(64,96,32,16);
		arrowSprite = new Sprite(region);
		arrowSprite.setBounds(1130, 500, 128, 64);
		
		float soundVolume = prefs.getFloat("settings.soundVolume",0.5f);
		float musicVolume = prefs.getFloat("settings.musicVolume",0.5f);
		int maxFPS = prefs.getInteger("settings.maxFPS",20);
		
		menuSliders.add(0, new MenuSlider(364, 500, 12, soundVolume, 1.0f, 0, "SOUNDS:", miscTexture));
		menuSliders.add(1, new MenuSlider(364, 400, 12, musicVolume, 1.0f, 0, "MUSIC:", miscTexture));
		menuSliders.add(2, new MenuSlider(364, 300, 12, maxFPS, 1000, 1, "NTH:", miscTexture));
		menuSliders.get(0).sliderHandlig();
		
		
		boolean isFullscreen = prefs.getBoolean("settings.fullscreen", false);
		boolean isVsync = prefs.getBoolean("settings.vSync", false);
		
		menuCheckBoxs = new ArrayList<MenuCheckBox>();
		menuCheckBoxs.add(0, new MenuCheckBox(224, 200, "FULLSCREEN", miscTexture, isFullscreen));
		menuCheckBoxs.add(1, new MenuCheckBox(870, 200, "VSYNC", miscTexture, isVsync));
		
		buttonReturn = new MenuButton(675, 100, "RETURN ", miscTexture, true);
		
		MenuTextAuthor = new menuText(1200, 20, textAuthor, miscTexture,2);
		MenuTextMusic = new menuText(380, 50, textMusic, miscTexture,2);

		isReturn = false;
		isSelected = false;
		selectedNumber = 0;
		
		this.showAutors = showAutors; 
		
	}
	
	
	public void render(MusicEffect menuMusicEffect)
	{
		
        update(menuMusicEffect);
		
		miscBatch.setProjectionMatrix(miscCamera.combined);
		
		miscBatch.begin();
		
		vrenchSprite1.draw(miscBatch);
		vrenchSprite2.draw(miscBatch);
		for(int i=0;i<signs.size();i++) signs.get(i).draw(miscBatch);
		for(int i=0;i<menuSliders.size();i++) menuSliders.get(i).render(miscBatch);
		for(int i=0;i<menuCheckBoxs.size();i++) menuCheckBoxs.get(i).render(miscBatch);
		buttonReturn.render(miscBatch);
		arrowSprite.draw(miscBatch);
		
		if(showAutors == true)
		{
			MenuTextAuthor.render(miscBatch);
			MenuTextMusic.render(miscBatch);
		}
		
		
		miscBatch.end();
		
     	//System.out.println("FPS: " + (int)(1.0/Gdx.graphics.getDeltaTime()) + " " + signs.size() + " " + menuSliders.size() + " " + menuCheckBoxs.size());
		
	}
	
	public void update(MusicEffect menuMusicEffect)
	{
		
		sterowanie(menuMusicEffect);
		updateSelected(menuMusicEffect);
		
	}
	
	
	public void sterowanie(MusicEffect menuMusicEffect)
	{
		if(Gdx.input.isKeyJustPressed(Keys.DOWN) || Gdx.input.isKeyJustPressed(Keys.S))
		{
			
			selectedNumber ++;
			if(selectedNumber > 5) selectedNumber = 0;
			
			updateSelected(menuMusicEffect);
		}
		else if(Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.W))
		{		
			selectedNumber --;
			if(selectedNumber <0) selectedNumber = 5;
			
			updateSelected(menuMusicEffect);
		}
		else if(Gdx.input.isKeyJustPressed(Keys.RIGHT) || Gdx.input.isKeyJustPressed(Keys.D))
		{			
			if(selectedNumber < 3 && menuSliders.get(selectedNumber).isLocked == false)
			{
				prefs.flush();
				menuSliders.get(selectedNumber).moveRight();
			}
			
		}
		else if(Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.A))
		{		
			if(selectedNumber < 3 && menuSliders.get(selectedNumber).isLocked == false)
			{
				prefs.flush();
				menuSliders.get(selectedNumber).moveLeft();
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.ENTER))
		{
			isSelected = true;
		}
	}
	
	public void updateSelected(MusicEffect menuMusicEffect)
	{
		if(selectedNumber < 3) arrowSprite.setPosition(1130, 500 - 100 * selectedNumber);
		else if(selectedNumber == 3) arrowSprite.setPosition(650, 500 - 100 * selectedNumber);
		else if(selectedNumber > 3)  arrowSprite.setPosition(1130, 500 - 100 * (selectedNumber-1));
		
		
			for(int i=0;i<menuSliders.size();i++)
			{
				
				
					if(i != selectedNumber) menuSliders.get(i).isActivated = false;
					else menuSliders.get(i).isActivated = true;
					menuSliders.get(i).update();
					
					prefs.putFloat("settings.soundVolume", menuSliders.get(0).value);
					prefs.putFloat("settings.musicVolume", menuSliders.get(1).value);
					prefs.putInteger("settings.maxFPS",(int)( menuSliders.get(2).jump));
					
					menuMusicEffect.sound.setVolume((menuSliders.get(1).value/2.0f) * 0.25f); 
					
					if(selectedNumber == 0)
					{
						
					}
					else if(selectedNumber == 1)
					{
						
					}
					
			}
		
		
			for(int i=0;i<menuCheckBoxs.size();i++)
			{
				
					if(i + 3 == selectedNumber)
					{
						if(isSelected == true)
						{
							if(menuCheckBoxs.get(i).isActivated == true)
							{
								menuCheckBoxs.get(i).isActivated = false;
							}
							else
							{
								menuCheckBoxs.get(i).isActivated = true;
							}
							menuCheckBoxs.get(i).update();
						}
						
						if(isSelected == true && selectedNumber == 3)
						{
							if(menuCheckBoxs.get(0).isActivated == false) Gdx.graphics.setDisplayMode(1296, 720, false);
							else Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
							prefs.putBoolean("settings.fullscreen",  menuCheckBoxs.get(0).isActivated);
							prefs.flush();
						}
						if(isSelected == true && selectedNumber == 4)
						{

							Gdx.graphics.setVSync(menuCheckBoxs.get(1).isActivated);
							//if(menuCheckBoxs.get(1).isActivated == true) menuSliders.get(2).isLocked = true;
							//else menuSliders.get(2).isLocked = false;
							prefs.putBoolean("settings.vSync",  menuCheckBoxs.get(1).isActivated);
							prefs.flush();
							
							
						}
						
					}
					
					
				
				
			}
			
		    if(selectedNumber!=5) buttonReturn.isActivated = false;
			else buttonReturn.isActivated = true;
		    buttonReturn.update();
		    
			
		    
		    
		    if(isSelected == true)
		    {
		    	prefs.flush();
		    	if(selectedNumber == 5) isReturn = true;
		    	
		    	isSelected = false;
		    }
		
	}
	
	
	
	private String chars[] =
	{
						
			"ABCDEFGHIJKLMNOP",
			"QRSTUVWXYZ "
						
	};
	
	
	public void setScreenTitle(int x, int y, String text)
	{

		int tmpWidth = 0;
		int xs, ys=0;
		
		int scale = 6;
		tmpWidth = text.length(); //max line length
		
		for(int i=0;i<text.length();i++)
		{
	
				char ch = text.charAt(i);
				signs.add(0, new Sprite(miscTexture));
				
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
	
	
	public void dispose()
	{
		for(int i=0;i<signs.size();i=i) signs.remove(i);	
		for(int i=0;i<menuSliders.size();i=i)
		{
			menuSliders.get(i).dispose();
			menuSliders.remove(i);
		}
		for(int i=0;i<menuCheckBoxs.size();i=i) menuCheckBoxs.remove(i);
		
		
		MenuTextAuthor.dispose();
		MenuTextMusic.dispose();
	}
	
	
	
}
