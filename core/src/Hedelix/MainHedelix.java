package Hedelix;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainHedelix extends ApplicationAdapter 
{
	
	SpriteBatch batch;
	public OrthographicCamera camera;
	private Preferences prefs;
	
	//public Game game;
	public AssetManager manager;
	public mainMenu MainMenu;
	
	
	
	public void create ()
	{
		batch = new SpriteBatch();
		
		camera = new OrthographicCamera(1296,720);
		camera.position.set(648,360,0);
		
		//game = new Game();
		//game.create();
		
		//frameLimit
		prefs = Gdx.app.getPreferences("Havix.Hederlix.settings.preferences");
		int maxFPS = prefs.getInteger("settings.maxFPS",20);
		int FPS = 0;
		if(maxFPS != 20) FPS = maxFPS*50 + 60;
		//frameLimit

		//gameIntro screen
		
		
		
		
		//load resources
		
		//TEXTURES
				manager = new AssetManager();
				manager.load("textures/blocks.png", Texture.class); //blockTexture
				manager.load("textures/Player.png", Texture.class); //playerTexture
				manager.load("textures/weapons.png", Texture.class); //weaponTexture
				manager.load("textures/mobs.png", Texture.class); //mobTexture
				manager.load("textures/effects.png", Texture.class); //effectTexture
				manager.load("textures/background.png", Texture.class);//backgroundTexture
				manager.load("textures/misc.png", Texture.class);//miscTexture
				manager.load("textures/eye.png", Texture.class);//eyeTexture
				manager.load("textures/enda.png", Texture.class);//End1Texture
				manager.load("textures/endb.png", Texture.class);//End2Texture;
				manager.load("textures/ewee.png", Texture.class);//eweeTexture;
				manager.load("textures/aybabtu.png", Texture.class);//aybabtuTexture
				manager.load("textures/sand.png", Texture.class);//sandTexture
				manager.load("textures/tfwyrch.png", Texture.class);//tfwyrchTexture
				manager.load("textures/dbwccy.png", Texture.class);//dbwccyTexture
				
				
				
				//MUSIC
				manager.load("Music/bossMusic.mp3", Music.class);
				manager.load("Music/mainMusic.mp3", Music.class);
				manager.load("Music/introMusic.mp3", Music.class);
				manager.load("Music/secretMusic.mp3", Music.class);
				manager.load("Music/gameMusic1.mp3", Music.class);
				manager.load("Music/gameMusic2.mp3", Music.class);
				manager.load("Music/gameMusic3.mp3", Music.class);
				manager.load("Music/gameMusic4.mp3", Music.class);
				manager.load("Music/gameMusic5.mp3", Music.class);
				manager.load("Music/gameMusic6.mp3", Music.class);
				manager.load("Music/gameMusic7.mp3", Music.class);
				
				
				
				//SOUNDS
				manager.load("Sounds/Explosion1.mp3", Sound.class); //Explosion1
				manager.load("Sounds/Explosion2.mp3", Sound.class); 
				manager.load("Sounds/Explosion3.mp3", Sound.class); 
				manager.load("Sounds/Explosion4.mp3", Sound.class); 
				manager.load("Sounds/Explosion5.mp3", Sound.class); 
				manager.load("Sounds/Hit.mp3", Sound.class);
				manager.load("Sounds/Jump1.mp3", Sound.class);
				manager.load("Sounds/Jump2.mp3", Sound.class);
				manager.load("Sounds/Jump3.mp3", Sound.class);
				manager.load("Sounds/PlayerShoot.mp3", Sound.class);
				manager.load("Sounds/Hitbox2.mp3", Sound.class);
				manager.load("Sounds/CheckPoint.mp3", Sound.class);
				manager.load("Sounds/PlayerDead.mp3", Sound.class);
				manager.load("Sounds/DoorBlueOpen.mp3", Sound.class);
				manager.load("Sounds/DoorRedOpen.mp3", Music.class);
				manager.load("Sounds/BlockButtonPresed.mp3", Sound.class);
				manager.load("Sounds/MobShoot1.mp3", Sound.class);
				manager.load("Sounds/MobShoot2.mp3", Sound.class);
				manager.load("Sounds/MobShoot3.mp3", Sound.class);
				manager.load("Sounds/MobShoot4.mp3", Sound.class);
				manager.load("Sounds/MobShoot5.mp3", Sound.class);
				manager.load("Sounds/MobShoot6.mp3", Sound.class);
				manager.load("Sounds/MobShoot7.mp3", Sound.class);
				manager.load("Sounds/MobShoot8.mp3", Sound.class);
				manager.load("Sounds/bossDead1.mp3", Sound.class);
				manager.load("Sounds/bossDead2.mp3", Sound.class);
				manager.load("Sounds/bossDead3.mp3", Sound.class);
				manager.load("Sounds/bossDead4.mp3", Sound.class);
				manager.load("Sounds/bossDead5.mp3", Sound.class);
				manager.load("Sounds/Flower.mp3", Sound.class);
				manager.load("Sounds/shake1.mp3", Sound.class);
				manager.load("Sounds/shake2.mp3", Sound.class);
				manager.load("Sounds/bossTowerExplode.mp3", Sound.class);
				manager.load("Sounds/bossTowerShoot.mp3", Sound.class);
			    manager.load("Sounds/glass.mp3", Sound.class);
				manager.load("Sounds/iron.mp3", Sound.class);
				manager.load("Sounds/redIron.mp3", Sound.class);
				
				
				manager.finishLoading();
	// end load resources
				
		MainMenu = new mainMenu(manager);
		
		
	}

	
	public void render ()
	{
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT );
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		
		MainMenu.render();
		
		batch.end();
	}
	
	
	
	public void dispose()
	{
		super.dispose();
	}
}
