package Hedelix;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sun.jndi.toolkit.url.Uri;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import Elements.MassageRead;
import Elements.mobParticle;
import Sound.MusicEffect;
import miscElement.MenuButton;
import miscElement.menuText;

public class mainMenu 
{

	Sprite background;
	Sprite logoSprite, arrowSprite;
	Sprite YTLogo;
	
	public AssetManager manager;
	
	private Texture mobTexture;
	private Texture backgroundTexture;
	private Texture miscTexture;
	
	private TextureRegion region;
	
	private SpriteBatch miscBatch,batch;
	private OrthographicCamera camera, miscCamera;
	
	private float cameraSpeed;
	private float cameraAddX, cameraAddY;
	
	public int cameraDirection;
	public int logoDirection;
	
	public float logoAngle;
	
	private ArrayList<MenuButton> menuButtons;
	private ArrayList<mobParticle> mobParticles;
	
	private float soundVolume;
	
	private float musicVolume;
	private MusicEffect menuMusicEffect;
	private Music mainMusic;
	
	public int selectedNumber;
	public boolean isSelected, wasSelected;
	private boolean isContinueLocked;
	
	private menuText MenuTextAuthor, MenuTexthelp;
	
	private Preferences prefs, prefsGame;
	private float particlesTimer;
	private float maxParticleTime1, maxParticleTime2;
	
	private Random generator;
	
	private MassageRead warningText;
	private boolean isWarningDisplay, isChoice, canPlay;
	
	Game game;
	Options options;
	
	private String textAuthor[] = 
	{	
			"HAVIX",		
	};
	private String stringHelp[] =
	{
			"HELP"	
	};
	
	
	
	public mainMenu(AssetManager manager)
	{
		this.manager = manager;
		prefs = Gdx.app.getPreferences("Havix.Hederlix.settings.preferences");
		prefsGame = Gdx.app.getPreferences("Havix.Hederlix.game.preferences");
		
		
		
		boolean isFullscreen = prefs.getBoolean("settings.fullscreen", false);
		boolean isVsync = prefs.getBoolean("settings.vSync", false);

		mobTexture = manager.get("textures/mobs.png", Texture.class);
		backgroundTexture = manager.get("textures/background.png", Texture.class);
		miscTexture = manager.get("textures/misc.png", Texture.class);
		
		miscBatch = new SpriteBatch();
		batch = new SpriteBatch();
		
		int backgroundWidth = backgroundTexture.getWidth();
		int backgroundHeight = backgroundTexture.getHeight();
		int backgroundScale = 64;
		
		region = new TextureRegion(miscTexture);
		
		background = new Sprite(backgroundTexture);
		background.setBounds(0, 720  - backgroundHeight * backgroundScale , backgroundWidth * backgroundScale, backgroundHeight * backgroundScale);
		
		region.setRegion(0,112,96,16);
		logoSprite = new Sprite(region);
		logoSprite.setBounds(144, 550, 1008, 144);
		logoSprite.setOrigin(1008/2, 144/2);
		
		region.setRegion(64,96,32,16);
		arrowSprite = new Sprite(region);
		arrowSprite.setBounds(1000, 400, 128, 64);
		
		region.setRegion(96,80,26,17);
		YTLogo = new Sprite(region);
		YTLogo.setBounds(10, 20, 156, 132);
		
		
		logoAngle = 0;
		logoDirection = 2;
		
		camera = new OrthographicCamera(1296,720);
		camera.position.set(648,360,0);
		camera.update();
		cameraDirection = 2;
		
		miscCamera = new OrthographicCamera(1296,720);
		miscCamera.position.set(648,360,0);
		miscCamera.update();
		
		selectedNumber = 0;
		isSelected = wasSelected = false;
		
		menuButtons = new ArrayList<MenuButton>();
		menuButtons.add(0, new MenuButton(372, 400, "START GAME", miscTexture, true));
		menuButtons.add(1, new MenuButton(372, 320, "CONTINUE  ", miscTexture, true));
		menuButtons.add(2, new MenuButton(372, 240, "OPTIONS   ", miscTexture, true));
		menuButtons.add(3, new MenuButton(372, 160, "EXIT      ", miscTexture, true));
		
		menuButtons.get(0).isActivated = true;
		menuButtons.get(0).update();
		
		isContinueLocked = prefsGame.getBoolean("game.isContinueLocked", true);
		menuButtons.get(1).isLocked = isContinueLocked;
		
		MenuTextAuthor = new menuText(1200, 20, textAuthor, miscTexture,2);
		MenuTexthelp = new menuText(320, 60, stringHelp, miscTexture, 4);
		
		
		Gdx.graphics.setVSync(isVsync);
		
		if(isFullscreen == false) Gdx.graphics.setDisplayMode(1296, 720, false);
		else Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode().width, Gdx.graphics.getDesktopDisplayMode().height, true);
		
		mobParticles = new ArrayList<mobParticle>();
		maxParticleTime1 = 0;
		maxParticleTime2 = 0.05f;
		generator = new Random();
		
		musicVolume = prefs.getFloat("settings.musicVolume",0.5f)/2.0f;
        soundVolume = prefs.getFloat("settings.soundVolume",0.5f)/2.0f;
		
		mainMusic = manager.get("Music/mainMusic.mp3", Music.class);
		menuMusicEffect = new MusicEffect(mainMusic, musicVolume);
	//	System.out.println(menuMusicEffect.sound.getVolume());
		
		
		warningText = new MassageRead(miscTexture);
		isChoice = false;
		
		if(isContinueLocked == false) canPlay = false;
		else canPlay = true;
		

		game = new Game();
		options = new Options(miscTexture, mobTexture);
	}
	
	public void render()
	{
		
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		miscBatch.setProjectionMatrix(miscCamera.combined);
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		background.draw(batch);
		batch.end();
		
		miscBatch.begin();
	
		for(int i=0;i<mobParticles.size();i++) mobParticles.get(i).getTexture().draw(miscBatch);
		
		if(isSelected == false)
		{
			
			logoSprite.draw(miscBatch);
			for(int i=0;i<menuButtons.size();i++) menuButtons.get(i).render(miscBatch);	
			arrowSprite.draw(miscBatch);
			YTLogo.draw(miscBatch);
		}
		
		if(isWarningDisplay == true)
		{
		    warningText.drawMassage(miscBatch);
		}
		
		MenuTextAuthor.render(miscBatch);
		MenuTexthelp.render(miscBatch);
		//render other screen
		renderOtherScreen();
		
		
		
		miscBatch.end();
		
		
		
		
		
		
	}
	
	public void update()
	{
		
		if(isContinueLocked == true) canPlay = true;
		
		
		if(isSelected == true && selectedNumber == 0 && isContinueLocked == false && isChoice == false && canPlay == false)
		{
			isWarningDisplay = true;
		}
	    else if(isSelected == true && selectedNumber == 2)
		{
			cameraUpdate();
			particleHandling();
		}
		else if(isSelected == false)
		{	
			
			cameraUpdate();
			logoSpriteHandling();
			sterowanie();
			particleHandling();
		}
		
		if(isSelected == true && isChoice == false && canPlay == false && selectedNumber == 0)
		{
			sterowanie();
			particleHandling();
			cameraUpdate();
		}
		
		if(isSelected == true && selectedNumber == 1 && isContinueLocked == true)
		{
			isSelected = false;
			removeParticles();
		}
		
		if(isWarningDisplay == true) warningHandling();
		
		menuHandling();
	}
	
	public void sterowanie()
	{
		if(isWarningDisplay == false)
		{
			if(Gdx.input.isKeyJustPressed(Keys.DOWN) || Gdx.input.isKeyJustPressed(Keys.S))
			{
				
				selectedNumber ++;
				if(selectedNumber > 4) selectedNumber = 0;
				
				updateSelected();
			}
			else if(Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.W))
			{		
				selectedNumber --;
				if(selectedNumber <0) selectedNumber = 4;
				
				updateSelected();
			}
			if(Gdx.input.isKeyJustPressed(Keys.ENTER))
			{
				isSelected = true;
			}
		}
		else
		{
			
			if(Gdx.input.isKeyJustPressed(Keys.Z))
			{
				isChoice = false;
				isWarningDisplay = false;
				isSelected = false;
				
			}
			else if(Gdx.input.isKeyJustPressed(Keys.SPACE) )
			{		
				isChoice = true;
				isWarningDisplay = false;
				canPlay = true;
			}
		}
		
	}
	
	public void cameraUpdate()
	{
		if(cameraAddY  <720 - (backgroundTexture.getHeight()-64) * 64) cameraDirection = 1;
		else if(cameraAddY + 720 >  0) cameraDirection = 2;
		
		if(cameraDirection == 1) cameraSpeed = 100 * Gdx.graphics.getDeltaTime();
		else cameraSpeed = -100 * Gdx.graphics.getDeltaTime();
		cameraAddX -= cameraSpeed;
		cameraAddY += cameraSpeed;
		
		camera.position.set(648 + cameraAddX ,360 + cameraAddY ,0);
		camera.update();
	}
	
	public void logoSpriteHandling()
	{
		if(logoAngle < -7) logoDirection = 2;
		else if(logoAngle > 7) logoDirection = 1;
		if(logoDirection == 1) logoAngle -= 7 * Gdx.graphics.getDeltaTime();
		else logoAngle += 7 * Gdx.graphics.getDeltaTime();
		logoSprite.setRotation(logoAngle);
	}
	
	public void updateSelected()
	{
		
		if(selectedNumber <= 3) arrowSprite.setPosition(1000, 400 - 80 * selectedNumber);
		else arrowSprite.setPosition(450, 55);
		
		for(int i=0;i<menuButtons.size();i++)
		{
			if(i != selectedNumber) menuButtons.get(i).isActivated = false;
			else menuButtons.get(i).isActivated = true;
			menuButtons.get(i).update();
		}
	}
	
	public void menuHandling()
	{
		
		if(selectedNumber == 0 && isSelected == true && isSelected != wasSelected && canPlay == true)//Game
		{
			isChoice = false;
			wasSelected = isSelected;
			menuMusicEffect.sound.stop();
			game.loadManager(manager);
			game.isContinue = false;
			game.create();	
		}
		else if(selectedNumber == 1 && isSelected == true && isContinueLocked == false && isSelected != wasSelected)//CONTINUE
		{
			isChoice = false;
			wasSelected = isSelected;
			menuMusicEffect.sound.stop();
			game.loadManager(manager);
			game.isContinue = true;
			game.create();	
			
		}
		else if(selectedNumber == 2 && isSelected == true && isSelected != wasSelected)//OPTIONS
		{
			isChoice = false;
			wasSelected = isSelected;
			options.create(true);
			
		}
		else if(selectedNumber == 3 && isSelected == true && isSelected != wasSelected)//EXIT
		{		
			Gdx.app.exit();
		}
		else if(selectedNumber == 4 && isSelected == true && isSelected != wasSelected)
		{
			
			Gdx.net.openURI("https://www.youtube.com/watch?v=Vg2hiWRkQb4&list=PL5A7s9noozoTDqpC5XI9bg4_VSVv2iU8i");
			isSelected = false;
		}
		
		
	}
	
	public void renderOtherScreen()
	{
		if(selectedNumber == 0 && isSelected == true && canPlay == true)//Game
		{
			game.render();
			if(game.isReturn == true)
			{
				game.clearMapFromObject();
				game.dispose();
				isSelected = wasSelected  = false;
				menuMusicEffect.sound.play();
				
				musicVolume = prefs.getFloat("settings.musicVolume",0.5f)/2.0f;
		        soundVolume = prefs.getFloat("settings.soundVolume",0.5f)/2.0f;
		        isContinueLocked = prefsGame.getBoolean("game.isContinueLocked", true);
		        menuButtons.get(1).isLocked = isContinueLocked;
		        canPlay = false;
			}
		}
		else if(selectedNumber == 1 && isSelected == true && isContinueLocked == false)//CONTINUE
		{
			game.render();
			if(game.isReturn == true)
			{
				game.clearMapFromObject();
				game.dispose();
				isSelected = wasSelected =  false;
				canPlay = false;
				menuMusicEffect.sound.play();
				
				musicVolume = prefs.getFloat("settings.musicVolume",0.5f)/2.0f;
		        soundVolume = prefs.getFloat("settings.soundVolume",0.5f)/2.0f;
		        isContinueLocked = prefsGame.getBoolean("game.isContinueLocked", true);
		        menuButtons.get(1).isLocked = isContinueLocked;
			}
		}
		else if(selectedNumber == 2 && isSelected == true)//OPTIONS
		{

			options.render(menuMusicEffect);
			if(options.isReturn == true)
			{
				options.dispose();
				isSelected = wasSelected  = false;
				
				musicVolume = prefs.getFloat("settings.musicVolume",0.5f)/2.0f;
		        soundVolume = prefs.getFloat("settings.soundVolume",0.5f)/2.0f;

			}
		}
	}
	
	
	public void mobParticleAdd()
	{
		int ID = 0;
		int number = 0;
		int tmpX = 0, tmpY = 800;
		
		Random generator = new Random();
		
		tmpX = 0 + generator.nextInt(1296);
		
		int los = generator.nextInt(25);	
		if(los == 0) ID = 200 + generator.nextInt(29);
		else ID = 201 + generator.nextInt(28);
		
		if(ID ==200) number = 1;
		else if(ID >= 201 && ID <= 204) number = 4;	
		else if(ID >= 205 && ID <= 211) number = 7;	
		else if(ID >= 212 && ID <=219) number = 4;
		else if(ID >= 220 && ID <=222) number = 3;
		else if(ID >= 223  && ID <=228) number = 8;
		
		if(ID == 208 || ID == 209) number = 0;
			
		for(int j =0;j<number;j++)
		{
			mobParticles.add(0, new mobParticle(mobTexture,tmpX, tmpY, ID, j));
		    mobParticles.get(0).isDisappearing = true;
				
		}
		
	}
	
	public void particleHandling()
	{
		particlesTimer += Gdx.graphics.getDeltaTime();
		
		if(particlesTimer > maxParticleTime1 && mobParticles.size() < 120)
		{
			mobParticleAdd();
			particlesTimer = 0;
			maxParticleTime1 = 0.1f + generator.nextFloat() * 0.4f;
		}
		else if(particlesTimer > maxParticleTime2 && mobParticles.size() < 120)
		{
			mobParticleAdd();
			particlesTimer = 0;
			maxParticleTime2 = 0.1f + generator.nextFloat() * 0.4f;
		}
		
		
		for(int i=0;i<mobParticles.size();i++)
		{
			mobParticles.get(i).mobParticleHandling();
			if(mobParticles.get(i).y < -20) 
			{
				mobParticles.remove(i);
				i--;
			}
		}
	}
	
	  public void warningHandling()
	   {

	    	warningText.claerText();
	    	warningText.setID(52);
	    	warningText.setSings();
	    	warningText.isActivated = true;	        			
	    	
	   }
	
	public void removeParticles()
	{
		for(int i=0;i<mobParticles.size();i=i) mobParticles.remove(i);	
	}
	
}
