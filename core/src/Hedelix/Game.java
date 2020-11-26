package Hedelix;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;
import com.badlogic.gdx.maps.Map;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
import com.sun.corba.se.impl.util.PackagePrefixChecker;
import com.sun.java.swing.plaf.windows.WindowsOptionPaneUI;
import com.sun.javafx.collections.ObservableSequentialListWrapper;
import com.sun.javafx.stage.WindowHelper;

import Boss.bossEye;
import Boss.bossMisc;
import Boss.bossRocket;
import Boss.bossTower;
import Elements.MassageRead;
import Elements.Poster;
import Elements.blockParticle;
import Elements.cloud;
import Elements.missileParticle;
import Elements.mobParticle;
import Elements.Blocks.Block;
import Elements.Blocks.BlockButton;
import Elements.Blocks.Checkpoint;
import Elements.Blocks.Door;
import Elements.Blocks.Explosion;
import Elements.Blocks.Flower;
import Elements.Blocks.ShootWall;
import Elements.Blocks.Sign;
import Elements.Blocks.Spikes;
import Elements.Blocks.StationarySaw;
import Elements.Blocks.TNT;
import Elements.Blocks.breakableBlock;
import Elements.Blocks.disappearingBlock;
import Elements.Blocks.greenBlock;
import Elements.Blocks.pulsingBlock;
import Elements.Mobs.Missile;
import Elements.Mobs.Mob;
import Elements.Mobs.MobWeapon;
import Elements.Mobs.bigMachine;
import Elements.Player.Player;
import Elements.Player.playerWeapon;
import Sound.MusicEffect;
import Sound.ShortSound;
import Sound.SoundEffect;
import miscElement.MenuButton;
import miscElement.menuText;
import miscElement.menuTitleText;

public class Game extends com.badlogic.gdx.Game
{
	
	SpriteBatch batch;
	SpriteBatch miscBatch;
	
	public OrthographicCamera camera;
	public OrthographicCamera miscCamera;
	
	
	int mapHeight = 195;
	int mapWidth = 405;
	
	int windowWidth = 27;
	int windowHeight = 15;
	
	int WindowX = 0;
	int WindowY = 0;
	
	int tmpWindowX;
	int tmpWindowY;
	
	int signsNumber;
	
	int tmpBrickNumber;
	
	float alpha = 0;
	
	
	int iFPS;
	int flowersCollected;
	float gameTime;
	float changeTimer;
	
	Sprite flowersIcon;
	
	boolean BlockButtonsActivatedAll;
	boolean isReading;
	boolean isTABPressed;
	int MobsNumber, tmpLastMobsNumber;
	int towerID;
	
	int MapID[][];
	Block Blocks[][];
	
	Texture blockTexture;
	Texture playerTexture;
	Texture weaponTexture;
	Texture mobTexture;
	Texture effectTexture;
	Texture backgroundTexture;
	Texture miscTexture;
	Texture eyeTexture;
	Texture end1Texture, end2Texture;
	Texture eweeTexture, aybabtuTexture, sandTexture, tfwyrchTexture, dbwccyTexture;
	
	AssetManager manager;
	
	Music soundDoorRedOpen;
	Music musicBoss;
	Music musicGame1,musicGame2,musicGame3,musicGame4,musicGame5,musicGame6,musicGame7;
	Music musicSecret;
	Music musicIntro;
	
	Sound soundExplosion1, soundExplosion2, soundExplosion3, soundExplosion4, soundExplosion5;
	Sound soundHit;
	Sound soundJump1, soundJump2, soundJump3;
	Sound soundPlayerShoot;
	Sound soundHitbox2;
	Sound soundCheckPoint;
	Sound soundPlayerDead;
	Sound soundDoorBlueOpen;
	Sound soundBlockButtonPresed;
	Sound soundMobShoot1, soundMobShoot2, soundMobShoot3, soundMobShoot4, soundMobShoot5, soundMobShoot6, soundMobShoot7, soundMobShoot8;
	Sound soundBossDead1, soundBossDead2, soundBossDead3, soundBossDead4, soundBossDead5;
    Sound soundFlower;
    Sound soundShake1, soundShake2;
    Sound soundBossTowerExplode, soundBossTowerShoot;
    Sound soundGlass, soundIron, soundRedIron;
 
    
    public float soundVolume, tmpSoundVolume, musicVolume, tmpMusicVolume;
	
	
	BitmapFont fontFPS;
	BitmapFont version;
	
	Player player;
	playerWeapon liane[];
	
	float cameraX = 0;
	float cameraY = 0;
	int movePlayerX, movePlayerY;
	
	float FirstFrameTime;
	
	ArrayList<StationarySaw> StationarySaws;
	ArrayList<Mob> Mobs;
	ArrayList<Explosion> Explosions; 
	ArrayList<SoundEffect> Sounds;
	ArrayList<ShortSound> ShortSounds;
	ArrayList<Checkpoint> Checkpoints;
	ArrayList<Flower> Flowers;
	ArrayList<TNT> TNTs;
	ArrayList<Spikes> Kolce;
	ArrayList<Door> Doors;
	ArrayList<BlockButton> BlockButtons;
	ArrayList<MobWeapon> MobWeapons;
	ArrayList<Missile> Missiles;
	ArrayList<ShootWall> ShootWalls;
	ArrayList<Sign> Signs;
	ArrayList<breakableBlock> breakableBlocks;
	ArrayList<disappearingBlock> disappearingBlocks;
	ArrayList<pulsingBlock> pulsingBlocks;
	ArrayList<greenBlock> greenBlocks;
	ArrayList<bigMachine> bigMachines;
	ArrayList<cloud> Clouds;
	ArrayList<missileParticle> missileParticles;
	ArrayList<mobParticle> mobParticles;
	ArrayList<blockParticle> blockParticles;
	
	
	ArrayList<Poster> posters;
	
	ArrayList<MusicEffect> musicEffects;
	
	
	ArrayList<Sprite> spriteTime;
	ArrayList<Sprite> spriteFlowersNumber;
	
	
	ArrayList<bossEye> BossEye;
	ArrayList<bossTower> BossTower;
	ArrayList<bossRocket> BossRocket;
	bossMisc bossHealthLine;
	
	
	int oldTimeNumber;
	int maxFlowerNumber;
	int oldFlowersNumber;
	
	MassageRead signText;
	
	Sprite curtain; 
	Sprite background;
	TextureRegion region;
	int BossNumber, bossGoldButton;
	
	int deadNumber;
	
	float endTimer;
	boolean isEndGame;
	int end;

	private float shakeCameraTimer;
	private float shakeCameraX, shakeCameraY;
	private boolean isShakeCamera;
	
	private boolean musicChange, wasMusicChange;
	private int gameMusicNumber;
	private boolean isSecretRoom, wasSescretRoom;
	
	Sprite endSprite;
	
	private Preferences prefsSettings;
	private Preferences prefsGame;
	private Options options;
	
	
	private int selectedNumber;
	private boolean isSelected, wasSelected;
	private boolean isGameMenu, isOptions;
	private ArrayList<MenuButton> gameButtons;
	private Sprite arrowSprite;
	
	public boolean isReturn;
	
	private menuText deadEndNumberText, timeEndText, pressZEnd, pressUp;
	private menuTitleText theEndTitleText;
	
	private boolean isFlowerCollected[]; 

	public boolean isContinue = false;
	
	
	
	
	
	

	@Override
	public void create()
	{
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera(1296,720);
		camera.position.set(648,360,0);
		
		miscBatch = new SpriteBatch();
		miscCamera = new OrthographicCamera(1296,720);
		miscCamera.position.set(648,360,0);
		
		MapID = new int[mapWidth][mapHeight];
		Blocks = new Block[windowWidth][windowHeight];
		
		
		
		blockTexture = manager.get("textures/blocks.png", Texture.class); //new Texture("textures/blocks.png");
		playerTexture = manager.get("textures/Player.png", Texture.class);
		weaponTexture = manager.get("textures/weapons.png", Texture.class);
		mobTexture = manager.get("textures/mobs.png", Texture.class);
		effectTexture = manager.get("textures/effects.png", Texture.class);
		backgroundTexture = manager.get("textures/background.png", Texture.class);
		miscTexture = manager.get("textures/misc.png", Texture.class);
		eyeTexture = manager.get("textures/eye.png", Texture.class);
		end1Texture = manager.get("textures/enda.png", Texture.class);
		end2Texture = manager.get("textures/endb.png", Texture.class);
		eweeTexture = manager.get("textures/ewee.png", Texture.class);
		aybabtuTexture = manager.get("textures/aybabtu.png", Texture.class);
		sandTexture = manager.get("textures/sand.png", Texture.class);
		tfwyrchTexture = manager.get("textures/tfwyrch.png", Texture.class);
		dbwccyTexture = manager.get("textures/dbwccy.png", Texture.class);
		
		musicBoss = manager.get("Music/bossMusic.mp3", Music.class);
		musicGame1 = manager.get("Music/gameMusic1.mp3", Music.class);
		musicGame2 = manager.get("Music/gameMusic2.mp3", Music.class);
		musicGame3 = manager.get("Music/gameMusic3.mp3", Music.class);
		musicGame4 = manager.get("Music/gameMusic4.mp3", Music.class);
		musicGame5 = manager.get("Music/gameMusic5.mp3", Music.class);
		musicGame6 = manager.get("Music/gameMusic6.mp3", Music.class);
		musicGame7 = manager.get("Music/gameMusic7.mp3", Music.class);
		musicIntro = manager.get("Music/introMusic.mp3", Music.class);
		musicSecret = manager.get("Music/secretMusic.mp3", Music.class);
		
		soundExplosion1 = manager.get("Sounds/Explosion1.mp3", Sound.class);
		soundExplosion2 = manager.get("Sounds/Explosion2.mp3", Sound.class);
		soundExplosion3 = manager.get("Sounds/Explosion3.mp3", Sound.class);
		soundExplosion4 = manager.get("Sounds/Explosion4.mp3", Sound.class);
		soundExplosion5 = manager.get("Sounds/Explosion5.mp3", Sound.class);
		soundHit = manager.get("Sounds/Hit.mp3", Sound.class);
		soundJump1 = manager.get("Sounds/Jump1.mp3", Sound.class);
		soundJump2 = manager.get("Sounds/Jump2.mp3", Sound.class);
		soundJump3 = manager.get("Sounds/Jump3.mp3", Sound.class);
		soundPlayerShoot = manager.get("Sounds/PlayerShoot.mp3", Sound.class);
		soundHitbox2 = manager.get("Sounds/Hitbox2.mp3", Sound.class);
		soundCheckPoint = manager.get("Sounds/CheckPoint.mp3", Sound.class);
		soundPlayerDead = manager.get("Sounds/PlayerDead.mp3", Sound.class);
		soundDoorBlueOpen = manager.get("Sounds/DoorBlueOpen.mp3", Sound.class);
		soundDoorRedOpen= manager.get("Sounds/DoorRedOpen.mp3", Music.class);
		soundBlockButtonPresed = manager.get("Sounds/BlockButtonPresed.mp3", Sound.class);
		soundMobShoot1 = manager.get("Sounds/MobShoot1.mp3", Sound.class);
		soundMobShoot2 = manager.get("Sounds/MobShoot2.mp3", Sound.class);
		soundMobShoot3 = manager.get("Sounds/MobShoot3.mp3", Sound.class);
		soundMobShoot4 = manager.get("Sounds/MobShoot4.mp3", Sound.class);
		soundMobShoot5 = manager.get("Sounds/MobShoot5.mp3", Sound.class);
		soundMobShoot6 = manager.get("Sounds/MobShoot6.mp3", Sound.class);
		soundMobShoot7 = manager.get("Sounds/MobShoot7.mp3", Sound.class);
		soundMobShoot8 = manager.get("Sounds/MobShoot8.mp3", Sound.class);
		soundBossDead1 = manager.get("Sounds/bossDead1.mp3", Sound.class);
		soundBossDead2 = manager.get("Sounds/bossDead2.mp3", Sound.class);
		soundBossDead3 = manager.get("Sounds/bossDead3.mp3", Sound.class);
		soundBossDead4 = manager.get("Sounds/bossDead4.mp3", Sound.class);
		soundBossDead5 = manager.get("Sounds/bossDead5.mp3", Sound.class);
		soundFlower = manager.get("Sounds/Flower.mp3", Sound.class);
		soundShake1 = manager.get("Sounds/shake1.mp3", Sound.class);
		soundShake2 = manager.get("Sounds/shake2.mp3", Sound.class);
		soundBossTowerExplode = manager.get("Sounds/bossTowerExplode.mp3", Sound.class);
		soundBossTowerShoot = manager.get("Sounds/bossTowerShoot.mp3", Sound.class);
		soundGlass = manager.get("Sounds/glass.mp3", Sound.class);
		soundIron = manager.get("Sounds/iron.mp3", Sound.class);
		soundRedIron = manager.get("Sounds/redIron.mp3", Sound.class);
		
		prefsSettings = Gdx.app.getPreferences("Havix.Hederlix.settings.preferences");
		prefsGame = Gdx.app.getPreferences("Havix.Hederlix.game.preferences");
		
		soundVolume = prefsSettings.getFloat("settings.soundVolume",0.5f) * 0.5f;	 
		musicVolume = prefsSettings.getFloat("settings.musicVolume",0.5f) * 0.5f;
		tmpSoundVolume = soundVolume;
		
		
		
		
		
		fontFPS = new BitmapFont();
		version = new BitmapFont();
		
		StationarySaws = new ArrayList<StationarySaw>();
		Mobs = new ArrayList<Mob>();
		Explosions = new ArrayList<Explosion>();
		Sounds = new ArrayList<SoundEffect>();
		ShortSounds = new ArrayList<ShortSound>();
		Checkpoints = new ArrayList<Checkpoint>();
		Flowers = new ArrayList<Flower>();
		TNTs = new ArrayList<TNT>();
		Kolce = new ArrayList<Spikes>();
		Doors = new ArrayList<Door>();
		BlockButtons = new ArrayList<BlockButton>();
		MobWeapons = new ArrayList<MobWeapon>();
		Missiles = new ArrayList<Missile>();
		ShootWalls = new ArrayList<ShootWall>();
		Signs = new ArrayList<Sign>();
		breakableBlocks = new ArrayList<breakableBlock>();
		disappearingBlocks = new ArrayList<disappearingBlock>();
		pulsingBlocks = new ArrayList<pulsingBlock>();
		greenBlocks = new ArrayList<greenBlock>();
		bigMachines = new ArrayList<bigMachine>();
		Clouds = new ArrayList<cloud>();
		missileParticles = new ArrayList<missileParticle>();
		mobParticles = new ArrayList<mobParticle>();
		blockParticles = new ArrayList<blockParticle>();
		
		posters = new ArrayList<Poster>();
		
		musicEffects = new ArrayList<MusicEffect>();
		
		BossEye = new ArrayList<bossEye>();
		BossTower = new ArrayList<bossTower>();
		BossRocket = new ArrayList<bossRocket>();
		bossHealthLine = new bossMisc(miscTexture);
	
		
		signText = new MassageRead(miscTexture);
		
		signsNumber = 0;
		
		tmpBrickNumber = 0;
		isReading = false;
		
		player = new Player(200,400,playerTexture);
		liane = new playerWeapon[2];
		liane[0] = new playerWeapon(weaponTexture,0);
		liane[1] = new playerWeapon(weaponTexture,1);
		
		
		
		region = new TextureRegion(blockTexture);
		region.setRegion(18,166,1,1);
		curtain = new Sprite(region);
		curtain.setBounds(0, 0, 1296, 720);
		
		
		endSprite = new Sprite();
    	endSprite.setRegion(region);
    	endSprite.setBounds(0, 0, 1296, 720);
	
		
		background = new Sprite(backgroundTexture);
		
		int backgroundWidth = backgroundTexture.getWidth();
		int backgroundHeight = backgroundTexture.getHeight();
		int backgroundScale = 64;
		
		isTABPressed = false;
		gameTime = 0;
		flowersCollected = 0;
		oldTimeNumber = 0;
		oldFlowersNumber = 0;
		
		region.setRegion(144,48,16,16);
		flowersIcon = new Sprite(region);
		flowersIcon.setBounds(1050, 650, 48, 48);
		
		spriteTime = new ArrayList<Sprite>();
		spriteFlowersNumber = new ArrayList<Sprite>();
		
		background.setBounds(0, 720  - backgroundHeight * backgroundScale , backgroundWidth * backgroundScale, backgroundHeight * backgroundScale);
		//background.setColor(0.33f,0.05f,0.5f,1f);
		
		FirstFrameTime = 0;
		isShakeCamera = false;
		
		musicChange = wasMusicChange = false;
		
		isGameMenu = false;
		isReturn = false;
		isOptions = false;
		
		isSelected = false;
		selectedNumber = 0;
		
		region.setTexture(miscTexture);
		region.setRegion(64,96,32,16);
		arrowSprite = new Sprite(region);
		arrowSprite.setBounds(1130, 500, 128, 64);
		
		gameButtons = new ArrayList<MenuButton>();
		gameButtons.add(0, new MenuButton(372, 400, "CONTINUE  ", miscTexture, true));
		gameButtons.add(1, new MenuButton(372, 320, "OPTIONS   ", miscTexture, true));
		gameButtons.add(2, new MenuButton(372, 240, "MAIN MENU ", miscTexture, true));
		gameButtons.add(3, new MenuButton(372, 160, "EXIT      ", miscTexture, true));
		
		options = new Options(miscTexture, mobTexture);
		
		isSecretRoom = wasSescretRoom = false;
		isEndGame = false;
		end = 0;
		endTimer = 0;
		deadNumber = 0;
		maxFlowerNumber = 0;
		gameMusicNumber = 0;
		
		String [] tmpText =
			{
					"PRES ARROW UP TO READ SIGN"
			};
		
		pressUp = new menuText(800, 650, tmpText, miscTexture, 2);
		
		
		
		loadMapImage();
		createBlocks();
		//obslugaOkna();
		
		if(isContinue == false)
		{
			String tmpFlowerCollected = "game.flowerCollected";
			for(int i =0;i<maxFlowerNumber;i++)
			{
				String tmp = tmpFlowerCollected + i;
				prefsGame.putBoolean(tmp, false);							 
			}
			
			prefsGame.putBoolean("game.isContinueLocked", true);	
			prefsGame.flush();
		}
		
		
		isFlowerCollected = new boolean[maxFlowerNumber];
		if(isContinue == true) continueGame();
		//wczytywanie gry
		
		
		wczytajOkno();
		
	}
	
	
	
	
	
	
	
	
	public void continueGame()
	{
		

		player.x = prefsGame.getFloat("game.CheckpointX",200);
		player.y = prefsGame.getFloat("game.CheckpointY",400);
		gameTime = prefsGame.getFloat("game.gameTime", 0);
		deadNumber = prefsGame.getInteger("game.deadNumber",0);
		
		

		String tmpFlowerCollected = "game.flowerCollected";
		for(int i =0;i<maxFlowerNumber;i++)
		{
			String tmp = tmpFlowerCollected + i;
			isFlowerCollected[i] = prefsGame.getBoolean(tmp, false);
			if(isFlowerCollected[i] == true)
			{
				flowersCollected++;
				Flowers.get(i).isActivated = true;
			}
			
			 
		}
		
	}
	
	
	
	
	
	
	
	
	public void loadManager(AssetManager manager)
	{
		this.manager = manager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void render()
	{
		
		if(isEndGame == false) update();
		if(isEndGame == true) endUpdate();
		
		
		
		if(isGameMenu == true) gameMenuUpdate();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		miscBatch.setProjectionMatrix(miscCamera.combined);
		
		batch.begin();
		
		background.draw(batch);
		
		for(int i=0;i<windowWidth;i++)
		{
			for(int j=0;j<windowHeight;j++)
			{
				if(Blocks[i][j].ID != 0) 
				{
					   Blocks[i][j].getTexture().draw(batch);				  
				}	
			}
		}
		
		for(int i = 0; i< ShootWalls.size();i++)
		{
			ShootWalls.get(i).getTexture().draw(batch);
		}
		
		for(int i = 0; i < Doors.size();i++) Doors.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < BlockButtons.size();i++) BlockButtons.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < breakableBlocks.size();i++) breakableBlocks.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < disappearingBlocks.size(); i++) disappearingBlocks.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < pulsingBlocks.size(); i++) pulsingBlocks.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < greenBlocks.size();i++)
		{
			if(greenBlocks.get(0).isActivated == false) break;
			greenBlocks.get(i).getTexture().draw(batch);	
		}
    		
		for(int i = 0; i < Kolce.size();i++) Kolce.get(i).getTexture().draw(batch);
		
		for(int i=0; i < posters.size();i++) posters.get(i).draw(batch);

			
		
		for(int i = 0; i < TNTs.size();i++) TNTs.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < Checkpoints.size();i++)
		{
			if(Checkpoints.get(i).windowX == WindowX && Checkpoints.get(i).windowY == WindowY) Checkpoints.get(i).getTexture().draw(batch);
		}
		
		for(int i = 0;i < Flowers.size();i++)
		{
		//	System.out.println(Flowers.get(i).x + " " + Flowers.get(i).y);
			if(Flowers.get(i).windowX == WindowX && Flowers.get(i).windowY == WindowY) 
			{		
				Flowers.get(i).getTexture().draw(batch);			
			}
		}
	//	System.out.println("-------" + player.x + " ------" + player.y);
		for(int i=0;i<Signs.size();i++)
		{
			if(Signs.get(i).windowX == WindowX && Signs.get(i).windowY == WindowY)
			{
				Signs.get(i).getTexture().draw(batch);
			}
		}
		
		for(int i=0;i<BossEye.size();i++) BossEye.get(i).draw(batch);
		
		for(int i=0;i<BossTower.size();i++) BossTower.get(i).getTexture().draw(batch);
			
		for(int i=0;i<BossRocket.size();i++) BossRocket.get(i).draw(batch);
		
		
		
		for(int i = 0; i < bigMachines.size();i++) bigMachines.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < Mobs.size();i++) Mobs.get(i).getTexture().draw(batch);
		
		for(int i = 0 ;i < 2;i++) if(liane[i].isActivated) liane[i].getTexture().draw(batch);
		
		for(int i = 0; i < Explosions.size();i++) Explosions.get(i).getTexture().draw(batch);
		
		if(player.isDead == false) player.getTexture().draw(batch);
		
		for(int i=0;i<Clouds.size();i++) Clouds.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < MobWeapons.size();i++) MobWeapons.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < Missiles.size();i++) Missiles.get(i).getTexture(batch);
		
		for(int i = 0; i < StationarySaws.size();i++) StationarySaws.get(i).draw(batch);
		
		for(int i = 0; i < missileParticles.size();i++) missileParticles.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < mobParticles.size();i++) mobParticles.get(i).getTexture().draw(batch);
		
		for(int i = 0; i < blockParticles.size();i++) blockParticles.get(i).getTexture().draw(batch);
		
		
		
		//fontFPS.draw(batch, "" + iFPS, 500, 500);
		batch.end();
		
		
		miscBatch.begin();
		
		if(isTABPressed == true) 
		{
			for(int i=0;i<spriteTime.size();i++) spriteTime.get(i).draw(miscBatch);
			for(int i=0;i<spriteFlowersNumber.size();i++) spriteFlowersNumber.get(i).draw(miscBatch); 
		
				
			version.draw(miscBatch,"v.1.0.0" , 1250, 25);	
			flowersIcon.draw(miscBatch);
		}
		
		//fontFPS.draw(miscBatch, "" + iFPS, 300, 0);
		
		//fontFPS.draw(miscBatch, "" + iFPS, 100, 0);
		if(isEndGame == true)
		{
			endSprite.draw(miscBatch);
			deadEndNumberText.render(miscBatch);
			timeEndText.render(miscBatch);
			theEndTitleText.render(miscBatch);
			pressZEnd.render(miscBatch);
			
		}
		if(WindowX == 0 && WindowY == 0) pressUp.render(miscBatch);
		if(BossNumber > 0) bossHealthLine.draw(miscBatch);
		signText.drawMassage(miscBatch);
		curtain.draw(miscBatch);
		
		
	
		if(isGameMenu == true)
		{
			for(int i=0;i<gameButtons.size();i++)
			{
				gameButtons.get(i).render(miscBatch);
				arrowSprite.draw(miscBatch);
			}
		}
		
		renderOtherScreen();
		
		miscBatch.end();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void update()
	{
		//Check FPS
		iFPS = (int) (1/Gdx.graphics.getRawDeltaTime());
		if(iFPS < 15) iFPS = 15;
		if(FirstFrameTime < 1)
		{
            FirstFrameTime += Gdx.graphics.getDeltaTime();
			//iFPS = 10000;
		}
		if(player.isDead == false && isEndGame == false)
		{
			
			if(alpha > 0) alpha -= 1 / (float)iFPS;
			if(alpha < 0) alpha = 0;
			
		} 
		
		musicHandling();
		soundHandling();
		shortSoundsHandling();
		//wasSescretRoom = false;
		//musicHandling();
		
		
		curtain.setColor(0,0,0, alpha);
		camera.position.set(648 + cameraX + 1296 * WindowX,360 + cameraY - 720 * WindowY,0);
		camera.update();
		miscCamera.update();
		
		
		
		player.collisionX = 0;
		player.collisionBottom = 0;
		player.collisionUp = 0;
		
		tmpLastMobsNumber = MobsNumber;
		
		if(isGameMenu == true) wasSelected = isSelected;
		sterowanie();
		
		
		
		if(isReading == false && isGameMenu == false)
		{
			
			BlockButtonsHandling();
			breakableBlocksHandling();
			disappearingBlocksHandling();
			pulsingBlocsHandling();
			greenBlocksHandling();
			obslugaMobow();
			bigMachinesHandling();
			obslugaMobWeapon();
			missilesHandling();
			stationarySawHandling();
			spikesHandling();
			DoorsHandling();	
			FlowersHandling();
			cloudsHandling();
			missileParticleHandling();
			blockParticleHandling();
			mobParticleHandling();
			bossHandling();
			
			obslugaTNT();
			
			
			gameTime += Gdx.graphics.getDeltaTime();
			setGameTime();
			setFlowersNumber();
			
			player.saveLastPosition();
			
			

			
			if(player.isDead == false && isReading == false && isGameMenu == false)
			{
				
				
				//if(player.collisionX == 0) player.x += player.speedX/(float)iFPS;
				playerWeaponHandling();
				
				//////////////////////KOLIZJE
				
				player.moveX(movePlayerX, iFPS);
				player.setX(player.x + player.speedX / (float)(iFPS));

				
				if(player.speedX < 0) kolizjaLewaGracza();	
				else if(player.speedX > 0) kolizjaPrawaGracza();
				
				player.correctPosition();
				
				
				player.moveY(movePlayerY, iFPS);
				player.setY(player.y + player.speedY / (float)(iFPS));
				
				
				 
				if(player.isWznoszenie == false) kolizjaDolnaGracza();	
				else kolizjaGornaGracza();
				
				player.correctPosition();
				
				///////////////////////KOLIZJE
				
				//Jump sound
				if(player.startJump == true) ShortSounds.add(0,new ShortSound(soundJump2, soundVolume));
				
			}
			
			
	        
			
			
			//soundHandling();
			checkpointHandling();
			effectsHandling();
			
			
		}
		
		//musicHandling();
		
		player.obslugaSmierci();
		
		resetujPoSmierci();
		obslugaOkna();

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void sterowanie()
	{
		
		movePlayerX = 0;
		movePlayerY = 0;
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) 
		{
			player.isShot = true;
		}
		
		if(Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W))
		{
			//cameraY += 10;
			movePlayerY = 1;
			
		}
		else if(Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S))
		{		
			//cameraY -= 10;
			movePlayerY = 2;

		}
		if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
		{
			//cameraX -= 10;
			movePlayerX = 1;
		}
		else if(Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) 
		{
			//cameraX += 10;
			movePlayerX = 2;
		}	
		
		if(Gdx.input.isKeyJustPressed(Keys.UP))
		{
			signsHandling();

		}
		
		if(Gdx.input.isKeyPressed(Keys.TAB))
		{
			isTABPressed = true;
		}
		else isTABPressed = false;
		
		if(isReading == false && isGameMenu == false) player.playerTextureMove(1/Gdx.graphics.getDeltaTime(), movePlayerX, movePlayerY);
		else
		{
			if(Gdx.input.isKeyJustPressed(Keys.Z))
			{
				signText.isActivated = false;
				isReading = false;
				
			}
		}
		
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER) && isGameMenu == true) isSelected = true;
		
		//if(Gdx.input.isKeyPressed(Keys.ESCAPE)) isReturn = true;
		
		if( isSelected == true && selectedNumber == 1)
		{
			
		}
		else if(Gdx.input.isKeyJustPressed(Keys.ESCAPE))
		{
			isSelected = false;
			selectedNumber = 0;
			
			if(isGameMenu == false) isGameMenu = true;
			else isGameMenu = false;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	public void gameMenuSterowanie()
	{
		if(isSelected == true && selectedNumber == 1)
		{
			
		}
		else
		{
			if(Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.W))
			{
					
					selectedNumber--;
					if(selectedNumber < 0) selectedNumber = 3;	
				
			}
			else if(Gdx.input.isKeyJustPressed(Keys.DOWN) || Gdx.input.isKeyJustPressed(Keys.S))
			{		
				
					selectedNumber++;
					if(selectedNumber > 3) selectedNumber = 0;
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void loadMapImage()
	{
		
		 
		  
		  FileHandle file=Gdx.files.internal("Level/map.txt");
		  String tmpMap = file.readString();
		  
		  int index = 0;
		  int liczba = 0;
		  int tmp;
		  
		  for(int i=0;i<mapHeight;i++)
		  {		  
			  for(int j=0;j<mapWidth;j++)
			  {		  
				  while(tmpMap.charAt(index) != ',')
				  {
					  
					  tmp = tmpMap.charAt(index) - '0';
					  liczba = liczba*10 + tmp;		  
					  index ++; 
					  if(liczba == 113)//Flower
						{
							//Flowers.add(Flowers.size(), new Flower(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY));			
						    Flowers.add(Flowers.size(), new Flower(blockTexture, j*48 , 720 - i*48 - 48));		
							maxFlowerNumber++;
							
							
							
						}
					  else if(liczba == 124)//signs
					  {
							
							Signs.add(0, new Sign(blockTexture, j*48, 720 - 48 - i*48 , signsNumber));
							liczba = 0;
							signsNumber ++;
							
					  }
					  else if(liczba == 310)//player
					  {
						  player.x = j*48;
						  player.y = 720 - i * 48;
						  
						  WindowX = j/windowWidth;
						  if(player.y >= 0) WindowY = -(int)(player.y/720);
						  else WindowY = -(int)(player.y/720) + 1;
						  
						  tmpBrickNumber = (WindowX + WindowY*5)%39;
						  
						  liczba = 0;
						  
					  }					  
					  
					  MapID[j][i] = liczba;
					 
					  
				  }  			  
				  
				  index ++;
				  liczba = 0;
			  }
			  index+= 2;
		  
		  }
		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void wczytajOkno()
	{
		//System.out.println(player.y + " " + WindowY);
		isSecretRoom = false;
 
		for(int i=0;i<windowHeight;i++)
		{
			for(int j=0;j<windowWidth;j++)
			{
				
				if(MapID[j + 27 * WindowX][i + 15*WindowY] >= 100 && MapID[j + 27 * WindowX][i + 15*WindowY] <200)
				{
					int ID = MapID[j + 27 * WindowX][i + 15*WindowY];
					int x = j*48 + 1296 * WindowX;
					int y = (windowHeight-1)*48 - i*48 - 720 * WindowY;
					
				
					
					if(ID >= 100 && ID<=103)
					{
						
						StationarySaws.add(0,new StationarySaw(mobTexture,x,y,90 * ID -100 )); //STATIONARY SAW
					}
					else if(ID == 110)//CHECKPOINT
					{
						Checkpoints.add(0, new Checkpoint(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, 0); //checkpoint
						MapID[j + 27 * WindowX][i + 15*WindowY] = 0;
						continue;
						
					}
					else if(ID == 111 || ID == 112)//TNT
					{
						
						TNTs.add(0, new TNT(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //TNT
						continue;
						
					}
					else if(ID == 113)//Flower
					{

						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, 0); //Flower
						MapID[j + 27 * WindowX][i + 15*WindowY] = 0;
						continue;
						
					}
					
					else if(ID >=115 && ID <= 118)//SPIKES
					{
						Kolce.add(0, new Spikes(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, 0); //SPIKES
						continue;
					}
					else if(ID >=120 && ID <= 121)//DOORS
					{
						Doors.add(0, new Door(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //DOORS
						continue;
					}
					else if(ID ==122 || ID == 136)//BUTTONS
					{
						BlockButtons.add(0, new BlockButton(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //BUTTONS
						
						if(ID ==136)
						{
							BlockButtons.get(0).setObjectNumber(bossGoldButton);
							bossGoldButton ++;
						}
						
						continue;
					}
					else if(ID ==123)//ShootWalls
					{
						ShootWalls.add(0, new ShootWall(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //ShootWalls
						continue;
					}
					else if(ID >= 125 && ID <= 127) //GLASS AND IRON
					{
						breakableBlocks.add(0, new breakableBlock(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //glass and iron
						continue;
					}
					else if(ID >=128 && ID <= 130) //DISAPPEARING BLOCK
					{
						disappearingBlocks.add(0, new disappearingBlock(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //glass and iron
						continue;
					}
					else if(ID >= 131 && ID <=134) //PULSING BLOCK
					{
						pulsingBlocks.add(0, new pulsingBlock(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //glass and iron
						continue;
					}
					else if(ID == 135)// GREEN BLOCK
					{
						greenBlocks.add(0, new greenBlock(blockTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY));
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID); //glass and iron
						continue;
					}
					
				}
				
				if(i!= 0)
				{
					if(MapID[j + 27 * WindowX][i + 15*WindowY] > 200)
					{
						int ID = MapID[j + 27 * WindowX][i + 15*WindowY];
						
						if(ID <= 250)
						{
							if(ID != 208 && ID != 209) MobsNumber ++;
							Mobs.add(0,new Mob(mobTexture));
							Mobs.get(0).setMob(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY + 0.03f, MapID[j + 27 * WindowX][i+ 15*WindowY]);		// + 0.03f - korekta ¿eby nie wpada³ w blok ni¿ej		
							Blocks[j][i].ID = 0;
							continue;
						}
						else if(ID > 250 && ID < 260)
						{
							MobsNumber ++;
							bigMachines.add(0, new bigMachine(mobTexture));
							bigMachines.get(0).setBigMachine(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY + 0.03f, MapID[j + 27 * WindowX][i+ 15*WindowY]);
							Blocks[j][i].ID = 0;
							continue;
							
						}
						
						else if(ID >= 300 && ID <= 304)
						{
							
							Texture tmpTexture = eweeTexture;
							
							if(ID == 300) tmpTexture = eweeTexture;
							else if(ID == 301)tmpTexture = aybabtuTexture;
							else if(ID == 302)tmpTexture = sandTexture;
							else if(ID == 303)tmpTexture = tfwyrchTexture;
							else if(ID == 304)tmpTexture = dbwccyTexture;
							
							
							posters.add(0, new Poster(tmpTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, ID));
							isSecretRoom = true;
							musicChange = true;
							Blocks[j][i].ID = 0;
							continue;
							
						}
						
						else
						{
							if(ID == 260) //bossEye
							{
								BossNumber ++;
								BossEye.add(0, new bossEye(eyeTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY));
								bossHealthLine.Create(BossEye.get(0).HP);
								Blocks[j][i].ID = 0;
								continue;
							}
							
							else if(ID == 261)//bossTower
							{
								MobsNumber ++;
								BossTower.add(0, new bossTower(eyeTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, towerID));
								towerID ++;
								Blocks[j][i].ID = 0;
								continue;
							}
							
							else if(ID == 262)// bossRocket
							{
								MobsNumber ++;
								BossRocket.add(0, new bossRocket(eyeTexture, j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, towerID));
								towerID ++;
								Blocks[j][i].ID = 0;
								continue;
							}
						}
						
					}
					
					
					
					
					
					if((MapID[j+ 27 * WindowX][i-1  + 15*WindowY] == 0  || (MapID[j+ 27 * WindowX][i-1  + 15*WindowY] >= 110 && MapID[j+ 27 * WindowX][i-1  + 15*WindowY] <= 190)
							|| MapID[j+ 27 * WindowX][i-1  + 15*WindowY]>200) && MapID[j+ 27 * WindowX][i + 15*WindowY] == 1 ) 
					{
						int tmpZmiana = (tmpBrickNumber * 2)%40;
						
						Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, MapID[j + 27 * WindowX][i+ 15*WindowY] + 1 + tmpZmiana);
					
						continue;
					}
				}
				if(MapID[j+ 27 * WindowX][i + 15*WindowY] == 1 )
				{
					int tmpZmiana = (tmpBrickNumber * 2)%40;
					//if(tmpZmiana % 2 == 0) tmpZmiana += 1;
					Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, MapID[j + 27 * WindowX][i+ 15*WindowY] + tmpZmiana);
					continue;
				}
				
				
				
				Blocks[j][i].set(j*48 + 1296 * WindowX, (windowHeight-1)*48 - i*48 - 720 * WindowY, MapID[j + 27 * WindowX][i+ 15*WindowY]);
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void createBlocks()
	{
		
		for(int i=0;i<windowWidth;i++)
		{
			
			for(int j=0;j<windowHeight;j++)
			{
				Blocks[i][j] = new Block(blockTexture);
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void obslugaOkna()
	{
		
		tmpWindowX = (int)(player.x / 1296);
		if(player.y >= 0) tmpWindowY = -(int)(player.y/720);
		else tmpWindowY = -(int)(player.y/720) + 1;
		
		if(player.x > WindowX * 1296 + 1284) player.x += 20;
		else if(player.x < WindowX * 1296 + 12) player.x -= 20;
		
		if(tmpWindowX != WindowX || tmpWindowY != WindowY)
		{	
			
			//if(isSecretRoom == true) isSecretRoom=false;
			//else isSecretRoom = true;
			
			
			
			WindowX = tmpWindowX;
			WindowY = tmpWindowY;
			tmpBrickNumber = (WindowX + WindowY*5)%56;
			
			if(WindowX == 14 && WindowY == 0)
			{
				if(musicChange == true) wasMusicChange = false;
				else wasMusicChange= true;
				isEndGame = true;
				end = 1;
				alpha = 1;
				curtain.setColor(0,0,0,alpha);
			}
			
			
			/*for(int i=0;i< Mobs.size();i=i) Mobs.remove(i);
			for(int i=0;i< StationarySaws.size();i=i) StationarySaws.remove(i);
			for(int i=0;i< Explosions.size();i=i) Explosions.remove(i);
			for(int i=0;i<TNTs.size();i=i) TNTs.remove(i);
			for(int i=0;i<Kolce.size();i=i) Kolce.remove(i);
			for(int i=0;i<Doors.size();i=i) Doors.remove(i);
			for(int i=0;i<BlockButtons.size();i=i) BlockButtons.remove(i);
			for(int i = 0; i< MobWeapons.size();i=i) MobWeapons.remove(i);
			for(int i = 0; i< Missiles.size();i=i) Missiles.remove(i);
			for(int i = 0; i< ShootWalls.size();i=i) ShootWalls.remove(i);
			for(int i = 0; i< breakableBlocks.size();i=i) breakableBlocks.remove(i);
			for(int i = 0; i< disappearingBlocks.size();i=i) disappearingBlocks.remove(i);
			for(int i = 0; i< pulsingBlocks.size();i=i) pulsingBlocks.remove(i);
			for(int i = 0; i< greenBlocks.size();i=i) greenBlocks.remove(i);
			for(int i = 0; i< bigMachines.size();i=i) bigMachines.remove(i);
			for(int i=0;i<Clouds.size();i=i) Clouds.remove(i);
			for(int i=0;i<missileParticles.size();i=i) missileParticles.remove(i);
			for(int i=0;i<BossEye.size();i=i) BossEye.remove(i);
			for(int i=0;i<BossTower.size();i=i) BossTower.remove(i);
			for(int i=0;i<BossRocket.size();i=i) BossRocket.remove(i);
			
			BlockButtonsActivatedAll = false;
			MobsNumber = 0;
			BossNumber = 0;
			bossGoldButton = 0;
			towerID = 0;*/
			
			clearMapFromObject();
			
			
			wczytajOkno();
			obslugaMobow();
			bigMachinesHandling();
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void resetujPoSmierci()
	{
		
		if(player.isDead == true)
		{
			liane[0].isActivated = false;
			liane[1].isActivated = false;
			liane[1].end = true;
			player.isShot = false;
			playerWeaponHandling();

		}
		
		if(player.deadTimer > 0.5 && alpha <1 && isEndGame == false)
		{
			
			alpha += 1 / (float) iFPS;
			if(alpha > 1) alpha = 1;
		}
		
		
		if(player.deadTimer > 2)
		{
			MobsNumber = 0;
			player.x = 300;
			player.y = 300;
			player.saveLastPosition();
			for(int i=0;i< Checkpoints.size();i++)
			{
				if(Checkpoints.get(i).isActivated == true)
				{
					WindowX = Checkpoints.get(i).windowX;
					WindowY = Checkpoints.get(i).windowY;
					player.x = Checkpoints.get(i).x;
					player.y = Checkpoints.get(i).y + 0.1f;

					break;
				}
			}
			
			
			player.playerTextureMove(iFPS, 0, 0);
				
		/*	for(int i=0;i< Mobs.size();i=i) Mobs.remove(i);
			for(int i=0;i< StationarySaws.size();i=i) StationarySaws.remove(i);
			for(int i=0;i< Explosions.size();i=i) Explosions.remove(i);
			for(int i=0;i<TNTs.size();i=i) TNTs.remove(i);
			for(int i=0;i<Kolce.size();i=i) Kolce.remove(i);
			for(int i=0;i<Doors.size();i=i) Doors.remove(i);
			for(int i=0;i<BlockButtons.size();i=i) BlockButtons.remove(i);
			for(int i = 0; i< MobWeapons.size();i=i) MobWeapons.remove(i);
			for(int i = 0; i< Missiles.size();i=i) Missiles.remove(i);
			for(int i = 0; i< ShootWalls.size();i=i) ShootWalls.remove(i);
			for(int i = 0; i< breakableBlocks.size();i=i) breakableBlocks.remove(i);
			for(int i = 0; i< disappearingBlocks.size();i=i) disappearingBlocks.remove(i);
			for(int i = 0; i< pulsingBlocks.size();i=i) pulsingBlocks.remove(i);
			for(int i = 0; i< greenBlocks.size();i=i) greenBlocks.remove(i);
			for(int i = 0; i< bigMachines.size();i=i) bigMachines.remove(i);
			for(int i=0;i<Clouds.size();i=i) Clouds.remove(i);
			for(int i=0;i<missileParticles.size();i=i) missileParticles.remove(i);
			for(int i=0;i<BossEye.size();i=i) BossEye.remove(i);
			for(int i=0;i<BossTower.size();i=i) BossTower.remove(i);
			for(int i=0;i<BossRocket.size();i=i) BossRocket.remove(i);*/
			
			clearMapFromObject();
			
			tmpBrickNumber = (WindowX + WindowY*5)%56;
			BlockButtonsActivatedAll = false;
			
			MobsNumber = 0;
			BossNumber = 0;
			bossGoldButton = 0;
			towerID = 0;
			
			wczytajOkno();
			obslugaMobow();
			bigMachinesHandling();
			stationarySawHandling();
			effectsHandling();
			player.isDead = false;
			player.deadTimer = 0;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void kolizjaLewaGracza()
	{
		
		int tmpX, tmpY;	
		
		for(float step=3;step<=45;step+=21)
		{
			
			tmpX = (int) (player.x/48.0) - 27*WindowX;
			//tmpY = (windowHeight - 1) - ((int) ((player.y + step)/48.0)) - 14*WindowY;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((player.y + step)/48.0))  - 14*WindowY;
			else  tmpY = (windowHeight) - ((int) ((player.y + step)/48.0))  - 15*WindowY;
			
			if(tmpX > windowWidth-1 || tmpX < 0 || tmpY < 0 || tmpY > windowHeight-1) continue; 
			sprawdzajKolizjeZObiektami(tmpX, tmpY);
			
			
			if(Blocks[tmpX][tmpY].ID != 0) 
			{
				player.collisionX = 1;
				
				if(Blocks[tmpX][tmpY].ID <128 || Blocks[tmpX][tmpY].ID >130) break;
			}

		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void kolizjaPrawaGracza()
	{
		int tmpX, tmpY;
		
		for(float step=3;step<=45;step+=21)
		{
			
			tmpX = (int) ((player.x + 48)/48.0) - 27*WindowX;
			//tmpY = (windowHeight - 1) - ((int) ((player.y + step)/48.0))-14*WindowY;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((player.y + step)/48.0))  - 14*WindowY;
			else  tmpY = (windowHeight) - ((int) ((player.y + step)/48.0))  - 15*WindowY;
			
			if(tmpX > windowWidth-1 || tmpX < 0 || tmpY < 0 || tmpY > windowHeight-1) continue; 
			sprawdzajKolizjeZObiektami(tmpX, tmpY);
			
			
			if(Blocks[tmpX][tmpY].ID != 0) 
			{
				player.collisionX = 2;
				if(Blocks[tmpX][tmpY].ID <128 || Blocks[tmpX][tmpY].ID >130) break;
			}

		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void kolizjaDolnaGracza()
	{
		
		int tmpX, tmpY;
		boolean tmpCollision = false;
		boolean cloudsAdded = false;
		
		for(int step=3;step<=45;step+=21)
		{
			
			tmpX = (int) ((player.x + step)/48.0) - 27*WindowX;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((player.y)/48.0))  - 14*WindowY;
			else  tmpY = (windowHeight) - ((int) ((player.y)/48.0))  - 15*WindowY;
			
			//System.out.println(tmpX + " " + tmpY);
			
			if(tmpX > windowWidth-1 || tmpX < 0 || tmpY < 0 || tmpY > windowHeight-1) continue; 
			
			sprawdzajKolizjeZObiektami(tmpX, tmpY);
			
			if(Blocks[tmpX][tmpY].ID != 0) 
			{
				
				if(player.speedY < -200 && cloudsAdded == false)
				{
					cloudsAdded = true;
					
					Random generator = new Random();
					float addX = 5*generator.nextFloat();
					Clouds.add(0, new cloud(effectTexture, player.x  + addX, player.y,1));
					addX = 15*generator.nextFloat();
					Clouds.add(0, new cloud(effectTexture, player.x -  16 + addX, player.y,0));
					addX = 15*generator.nextFloat();
					Clouds.add(0, new cloud(effectTexture, player.x + 16 + addX , player.y,0));
					addX = 5*generator.nextFloat();
					Clouds.add(0, new cloud(effectTexture, player.x + 39 + addX, player.y,1));
					
					
					
				}
				
				player.collisionBottom = 1;
				player.y = Blocks[tmpX][tmpY].y + 48;
				player.canJump = true;
				player.isJump = false;
				player.tmpIsJump = false;
				if(Blocks[tmpX][tmpY].ID <128 || Blocks[tmpX][tmpY].ID >130) break;
				else tmpCollision = true;
				
				
			}
			
			if(player.isJump == false && tmpCollision == false) player.canJump = false;
		

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void kolizjaGornaGracza()
	{
		
		int tmpX, tmpY;
		for(int step=3;step<=45;step+=21)
		{
			tmpX = (int) ((player.x + step)/48.0) - 27*WindowX;
			//tmpY = (windowHeight - 1) - ((int) ((player.y + 48)/48.0))  - 14*WindowY;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((player.y + 48)/48.0))  - 14*WindowY;
			else  tmpY = (windowHeight) - ((int) ((player.y + 48)/48.0))  - 15*WindowY;
			
			
			if(tmpX > windowWidth-1 || tmpX < 0 || tmpY < 0 || tmpY > windowHeight-1) continue; 
			sprawdzajKolizjeZObiektami(tmpX, tmpY);
			
			if(Blocks[tmpX][tmpY].ID != 0) 
			{
				
				player.collisionUp = 1;
				player.canJump = false;
				player.isJump = false;
				player.jumpTimer = -0.1f;
				if(Blocks[tmpX][tmpY].ID <128 || Blocks[tmpX][tmpY].ID >130) break;
				
			}

		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void sprawdzajKolizjeZObiektami(int tmpX, int tmpY)
	{
		if(Blocks[tmpX][tmpY].ID >= 128 && Blocks[tmpX][tmpY].ID <= 130)
		{
			for(int i=0;i<disappearingBlocks.size();i++)
			{
				if(tmpX == disappearingBlocks.get(i).tmpX && tmpY == disappearingBlocks.get(i).tmpY) disappearingBlocks.get(i).isActivated = true; 
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setGameTime()
	{
		
		String chars = "0123456789:";
		region.setTexture(miscTexture);
		
		String hours = ""; 
		if( (int)(gameTime /3600) <1) hours = "00";
		else if((int)(gameTime /3600) <10) hours = "0" + (int)(gameTime /3600);
		else hours = "" + (int)(gameTime /3600);
		
		String minutes = ""; 
		if( (int)(gameTime %3600)/60 <1) minutes = "00";
		else if((int)(gameTime %3600)/60 <10) minutes = "0" + (int)(gameTime %3600)/60;
		else minutes = "" + (int)(gameTime %3600)/60;
			
		String seconds = ""; 
		if( (int)(gameTime %60) <1) seconds = "00";	
		else if((int)(gameTime %60) <10) seconds = "0" + (int)(gameTime %60);		
		else seconds = "" + (int)(gameTime %60);
			
		
		
		String sTime =hours + ":" + minutes + ":" + seconds;
		
			
		if(sTime.length() != oldTimeNumber)
		{
			for(int i=0;i<spriteTime.size();i=i) spriteTime.remove(i); 
			oldTimeNumber = sTime.length();
			for(int i=0;i<oldTimeNumber;i++) spriteTime.add(0, new Sprite());
			
		}
		
		int xs;
		
		for(int i=0;i< sTime.length();i++)
		{
			
			char ch = sTime.charAt(i);
			xs = chars.indexOf(ch);
			
			if(xs>=0){
				
				if(ch == ':') region.setRegion(0 + xs*16, 7,9,9);
				else region.setRegion(0 + xs*16, 7,9,9);
				
				spriteTime.get(i).setRegion(region);
				spriteTime.get(i).setBounds(648 + i*32 - 16*sTime.length(), 600, 32, 32);
				
			}
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setFlowersNumber()
	{
		
		String chars[] =
		{
						
						"ABCDEFGHIJKLMNOP",
						"QRSTUVWXYZ,:?!()",
						"1234567890%/. "
						
		};
		
		String numberFlowers = flowersCollected + "/" + maxFlowerNumber;
		if(oldFlowersNumber != numberFlowers.length())
		{
			for(int i = 0;i<spriteFlowersNumber.size();i=i) spriteFlowersNumber.remove(i);
		    oldFlowersNumber = numberFlowers.length();
		    for(int i = 0; i < oldFlowersNumber;i++) spriteFlowersNumber.add(0, new Sprite());
			
		}
		
		region.setRegion(miscTexture);
		
		for(int i=0;i<numberFlowers.length();i++)
		{
			
			char ch = numberFlowers.charAt(i);
			
			for(int ys = 0;ys<chars.length;ys++)
			{
				int xs = chars[ys].indexOf(ch);
				if(xs >=0)
				{
					region.setRegion(0 + xs*16, 24 + ys*16,6,8);
					spriteFlowersNumber.get(i).setRegion(region);
					spriteFlowersNumber.get(i).setBounds(1150 + i*32 - 8*oldFlowersNumber, 655 , 32, 32);
				}
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void playerWeaponHandling()
	{
		
		if(player.isShot == true && liane[0].isActivated == false)
		{
			
			ShortSounds.add(0, new ShortSound(soundPlayerShoot,soundVolume));
			
			liane[0].isActivated = true;
			liane[0].setCoord(player.x, player.y,player.tmpIsJump, player.lastDirectionX);	
			liane[0].handlingWeapon(player.lastDirectionX);
		}
		
		if(liane[0].textureTimer > 0.16 && liane[1].end == false) liane[1].isActivated = true;
		if(liane[1].isActivated != true && liane[0].textureTimer > 0.16) liane[0].isActivated = false;
		if(liane[0].isActivated == false && liane[1].isActivated == false) liane[1].end = false;
		
		for(int i=0;i<2;i++)
		{			
			//System.out.println(liane[i].hitBox.x);
			if(liane[i].isActivated == true)
			{		
				liane[i].setCoord(player.x, player.y, player.tmpIsJump, player.lastDirectionX);
				
				for(int step=0;step <= liane[i].hitBox.width; step += 3)
				{
					int tmpX = (int)((step + liane[i].hitBox.x )/48.0)  - 27*WindowX;
					int tmpY; //= 14 - (int)((liane[i].hitBox.y + 3 )/48.0) - 14*WindowY;
					
					if(WindowY == 0) tmpY = 14 - (int)((liane[i].hitBox.y + 3 )/48.0) - 14*WindowY;
					else  tmpY = 15 - (int)((liane[i].hitBox.y + 3 )/48.0) - 15*WindowY;
					
					
					if(tmpX < 0 || tmpY <0 || tmpX >= windowWidth || tmpY >= windowHeight) continue;
					
					if(liane[i].hitBox.overlaps(Blocks[tmpX][tmpY].hitBox ) == true) 
					{
						int ID = Blocks[tmpX][tmpY].ID;
						if(ID == 111 || ID == 112 || ID == 122 || ID == 125 || ID == 126 || ID == 127 || ID == 136)
						{
							continue;
						}
						if(Blocks[tmpX][tmpY].ID != 0 )
						{
							
							liane[0].isActivated = false;
							liane[1].isActivated = false;
							liane[1].textureTimer = 0;
							liane[1].end = true;
						}
						
						
					}
					
					for(int k =0;k<Kolce.size();k++)
					{
						if(liane[i].hitBox.overlaps(Kolce.get(k).hitBox) == true) 
						{
							
								liane[0].isActivated = false;
								liane[1].isActivated = false;
								liane[1].textureTimer = 0;
								liane[1].end = true;				
													
						}
					}
				}
				
					
				for(int j=0;j<Missiles.size();j++)
                {
	
                	if(liane[i].hitBox.overlaps(Missiles.get(j).hitBox) == true && liane[i].isActivated == true)
                	{
                		Missiles.get(j).isActivated = true;
                		liane[0].isActivated = false;
						liane[1].isActivated = false;
						liane[1].textureTimer = 0;
						liane[1].end = true;
                	}
                	
                }
				
				
			}
				liane[i].handlingWeapon(player.lastDirectionX);	
				
			
			
		}
		
		if(liane[0].isActivated == false) player.isShot = false;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void obslugaMobWeapon()
	{
		for(int i = 0; i< MobWeapons.size();i++) 
		{
			
			MobWeapons.get(i).Handle();
			MobWeapons.get(i).move(iFPS);
			
			int tmpX = (int)((MobWeapons.get(i).x + 4.5)/48.0)  - 27*WindowX;
			int tmpY; //= (windowHeight - 1) - (int)((MobWeapons.get(i).y + 4.5 )/48.0) - 14*WindowY;
			if(WindowY == 0) tmpY =  (windowHeight - 1) - (int)((MobWeapons.get(i).y + 4.5 )/48.0) - 14*WindowY;
			else  tmpY =  (windowHeight ) - (int)((MobWeapons.get(i).y + 4.5 )/48.0) - 15*WindowY;
			
			
			if(tmpX <= -1 || tmpY <= -1 || tmpX >= windowWidth + 1 || tmpY >= windowHeight + 1)
			{
				if(MobWeapons.get(i).ID != 7)
				{
					MobWeapons.remove(i);
					i--;
				}
				else if(tmpY > 20) 
				{
					MobWeapons.remove(i);
					i--;
				}
				
				continue;
			}
			if(tmpX < 0 || tmpY <0 || tmpX >= windowWidth || tmpY >= windowHeight) continue;
			
			
			if(MobWeapons.get(i).hitBox.overlaps(player.hitBox) == true&& player.isDead == false)
			{
				
				playerDeadHandling();
				
			
				MobWeapons.remove(i);
				i--;
				continue;
			}
			
			
			
			if(Blocks[tmpX][tmpY].ID != 0 && Blocks[tmpX][tmpY].ID != 123 && Blocks[tmpX][tmpY].ID != 111 && Blocks[tmpX][tmpY].ID != 112)
			{
				if(MobWeapons.get(i).ID == 1 || MobWeapons.get(i).ID == 2 || MobWeapons.get(i).ID == 3 || MobWeapons.get(i).ID == 4 || MobWeapons.get(i).ID == 5 || MobWeapons.get(i).ID == 6 || MobWeapons.get(i).ID == 7 || MobWeapons.get(i).ID == 8 || MobWeapons.get(i).ID == 9)
				{
					
					if(MobWeapons.get(i).ID == 3)
					{
						ShortSounds.add(0, new ShortSound(soundExplosion4,soundVolume));
						int kat;
						float tmpX2, tmpY2;
						//Random generator = new Random();
						
						for(int j=0;j<4;j++)
						{
							kat = 45 + j*90;
							tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
							tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
							Explosions.add(0, new Explosion(effectTexture, MobWeapons.get(i).x - 15 + 6 * tmpX2, MobWeapons.get(i).y - 9 + 6 * tmpY2, 3));
							Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
							Explosions.get(0).angle = kat;
						}
					}
					
					else if(MobWeapons.get(i).ID == 6)
					{
						int removeX = 0;
						
						
							if(MobWeapons.get(i).angle >= 90 && MobWeapons.get(i).angle < 270) removeX = 0;
							else removeX = -6;
							MobWeapons.add(new MobWeapon(weaponTexture, MobWeapons.get(i).x + 5.5f + removeX, MobWeapons.get(i).y + 4.5f, 1));
							MobWeapons.get(MobWeapons.size() - 1).angle = 90;
							MobWeapons.add(new MobWeapon(weaponTexture, MobWeapons.get(i).x + 5.5f + removeX, MobWeapons.get(i).y + 4.5f, 1));
							MobWeapons.get(MobWeapons.size() - 1).angle = 270;
							MobWeapons.add(new MobWeapon(weaponTexture, MobWeapons.get(i).x - 5.5f + removeX, MobWeapons.get(i).y + 4.5f, 1));
							MobWeapons.get(MobWeapons.size() - 1).angle = 180;
							MobWeapons.add(new MobWeapon(weaponTexture, MobWeapons.get(i).x + 5.5f + removeX, MobWeapons.get(i).y + 4.5f, 1));
							MobWeapons.get(MobWeapons.size() - 1).angle = 0;	
				
					}
					
					else if(MobWeapons.get(i).ID == 7)
					{
						int kat;
						float tmpX2, tmpY2;
						//Random generator = new Random();
						
						for(int j=0;j<4;j++)
						{
							kat = 45 + j*90;
							tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
							tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
							Explosions.add(0, new Explosion(effectTexture, MobWeapons.get(i).x - 15 + 6 * tmpX2, MobWeapons.get(i).y - 0 + 6 * tmpY2, 3));
							Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
							Explosions.get(0).angle = kat;
						}
					}
					
					if(MobWeapons.get(i).ID != 4)
					{
						for(int j=0;j<4;j++) missileParticles.add(0, new missileParticle(weaponTexture, MobWeapons.get(i).x, MobWeapons.get(i).y, MobWeapons.get(i).ID, j, MobWeapons.get(i).frame));
					}
					else for(int j=0;j<2;j++) missileParticles.add(0, new missileParticle(weaponTexture, MobWeapons.get(i).x, MobWeapons.get(i).y, MobWeapons.get(i).ID, j, MobWeapons.get(i).frame));
					
					
					
					
					MobWeapons.remove(i);
					i--;
					continue;
				}
			}	
			
		/*	if(MobWeapons.get(i).ID == 7 && Blocks[tmpX][tmpY].ID == 123)
			{
				int kat;
				float tmpX2, tmpY2;
				//Random generator = new Random();
				
				for(int j=0;j<4;j++)
				{
					kat = 45 + j*90;
					tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
					tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
					Explosions.add(0, new Explosion(effectTexture, MobWeapons.get(i).x - 15 + 6 * tmpX2, MobWeapons.get(i).y - 0 + 6 * tmpY2, 3));
					Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
					Explosions.get(0).angle = kat;
				}
				
				MobWeapons.remove(i);
				i--;
				continue;
				
			}*/
			
			for(int j=0;j<TNTs.size();j++)
			{
				if(tmpX == TNTs.get(j).tmpX && tmpY == TNTs.get(j).tmpY)
				{
					TNTs.get(j).isActivated = true;
					TNTs.get(j).explodeTimer = 1;
					MobWeapons.remove(i);
					i--;
					continue;
					
				}
			}
				
				
				
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void obslugaMobow()
	{
		
		for(int i=0;i<Mobs.size();i++)
		{
			Mobs.get(i).saveLastPosition();
		
			kolizjeMoba(i);
			
			Mobs.get(i).mobHandling(player.x, player.y);
			
		//	if(Mobs.get(i).ID == 202) System.out.println(Mobs.get(i).hitBox1.x +" " +Mobs.get(i).hitBox1.y +" " +liane[0].hitBox.x + " " + liane[0].hitBox.y +" " +liane[1].hitBox.x + " " + liane[1].hitBox.y);
			
			////////////////////////////OBSLUGA OBRAZEN MOBA
			for(int k=0;k<2;k++)
			{
				if(liane[k].isActivated == true)
				{
                  //  System.out.println("C");
					if(Mobs.get(i).ID == 201 || Mobs.get(i).ID == 205 || Mobs.get(i).ID == 208 || Mobs.get(i).ID == 209) // Uderzenie w tarcze
					{
						if(liane[k].hitBox.overlaps(Mobs.get(i).hitBox2))
						{
							
							ShortSounds.add(0, new ShortSound(soundHitbox2,soundVolume));
							liane[0].isActivated = false;
							liane[1].isActivated = false;
							liane[1].textureTimer = 2;
							liane[0].textureTimer = 2;
							player.isShot = false;

							
							break;
						}
					}
					
					if(liane[k].hitBox.overlaps(Mobs.get(i).hitBox1))
					{
					//	System.out.println("D");
						if(Mobs.get(i).isImmortal == false)
						{
							Mobs.get(i).HP -= 1;
							Mobs.get(i).isImmortal = true;
							ShortSounds.add(0, new ShortSound(soundHit,soundVolume));
						}
						
					}
				}
				
				
			}
            ////////////////////////////OBSLUGA OBRAZEN MOBA
			
			Mobs.get(i).setTexture();
			
			if(player.hitBox.overlaps(Mobs.get(i).hitBox1) && player.isDead == false)
			{
				playerDeadHandling();
				
			}
			
			
			if(Mobs.get(i).canShoot == true)
			{
				
				if(Mobs.get(i).ID <212 || Mobs.get(i).ID > 219) Mobs.get(i).shootTimer = 0;
                Mobs.get(i).canShoot = false;
				if(Mobs.get(i).ID == 203)
				{
					ShortSounds.add(0, new ShortSound(soundMobShoot1,soundVolume));
					if( Mobs.get(i).direction == 2)
					{
						MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width, Mobs.get(i).y +18, 1));
						MobWeapons.get(0).angle = 0;
					}
					else
					{
						MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x , Mobs.get(i).y +18, 1));
						MobWeapons.get(0).angle = 180;
					}
				}
				else if(Mobs.get(i).ID == 204)
				{
					ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
					if( Mobs.get(i).direction == 2)
					{
						Missiles.add(0, new Missile(weaponTexture, Mobs.get(i).x + Mobs.get(i).width, Mobs.get(i).y +18));
						Missiles.get(0).angle = 0;
					}
					else
					{
						Missiles.add(0, new Missile(weaponTexture, Mobs.get(i).x , Mobs.get(i).y +18));
						Missiles.get(0).angle = 180;
					}
				}
				else if(Mobs.get(i).ID == 211)
				{
					ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
					
					for(int j=0;j<4;j++)
					{
						
							MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width, Mobs.get(i).y +18, 1));
							MobWeapons.get(0).angle = 45 + 90 *j;
						
						
					}
				}
				else if(Mobs.get(i).ID >= 212 && Mobs.get(i).ID <= 215)
				{
					ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
					
					int angle = 0;
					
	                if(Mobs.get(i).ID == 212)
	                {
	                	angle = 0;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width, Mobs.get(i).y +18, 2));
	                }
	                else if(Mobs.get(i).ID == 213)
	                {
	                	angle = 180;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x, Mobs.get(i).y +18, 2));
	                }
	                else if(Mobs.get(i).ID == 214)
	                {
	                	angle = 270;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + 15, Mobs.get(i).y , 2));
	                }
	                else if(Mobs.get(i).ID == 215)
	                {
	                	angle = 90;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + 15, Mobs.get(i).y + Mobs.get(i).height, 2));
	                }
	             
	                
					
					MobWeapons.get(0).angle = angle;
						
					
				}
				else if(Mobs.get(i).ID >= 216 && Mobs.get(i).ID <= 219)
				{
					ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
					
					int angle = 0;
					
	                if(Mobs.get(i).ID == 216)
	                {
	                	angle = 0;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width, Mobs.get(i).y +18, 3));
	                }
	                else if(Mobs.get(i).ID == 217)
	                {
	                	angle = 180;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x, Mobs.get(i).y +18, 3));
	                }
	                else if(Mobs.get(i).ID == 218)
	                {
	                	angle = 270;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + 18, Mobs.get(i).y , 3));
	                }
	                else if(Mobs.get(i).ID == 219)
	                {
	                	angle = 90;
	                	MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + 18, Mobs.get(i).y + Mobs.get(i).height, 3));
	                }
	             
	                
					
					MobWeapons.get(0).angle = angle;
						
					
				}
				else if(Mobs.get(i).ID == 221)
				{
					float atan =(float) Math.atan((player.y+30 - Mobs.get(i).y)/(float)(player.x+20 - Mobs.get(i).x));
					float angle = (float)(atan*180/Math.PI) + 180;
					if(player.x > Mobs.get(i).x-20)angle += 180;
					
					ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
					MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width/2, Mobs.get(i).y + Mobs.get(i).height/2, 1));
					MobWeapons.get(0).angle = angle;
					
				}
				else if(Mobs.get(i).ID >= 223 && Mobs.get(i).ID <= 228)
				{
					float atan =(float) Math.atan((player.y+5 - Mobs.get(i).y)/(float)(player.x+20 - Mobs.get(i).x));
					float angle = (float)(atan*180/Math.PI) + 180;
					if(player.x > Mobs.get(i).x-20)angle += 180;
					int tmpID = Mobs.get(i).ID;
					
					if(tmpID == 223)
					{
						ShortSounds.add(0, new ShortSound(soundMobShoot2,soundVolume));
						MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x - 6 + Mobs.get(i).width/2, Mobs.get(i).y - 6 + Mobs.get(i).height/2, 3));
						MobWeapons.get(0).angle = angle;
					}
					else if(tmpID == 224)
					{
						ShortSounds.add(0, new ShortSound(soundMobShoot4,soundVolume));
						MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width/2 - 6, Mobs.get(i).y - 6 + Mobs.get(i).height/2, 2));
						MobWeapons.get(0).angle = angle;
					}
					else if(tmpID == 225)
					{
						ShortSounds.add(0, new ShortSound(soundMobShoot5,soundVolume));
						Missiles.add(0, new Missile(weaponTexture, Mobs.get(i).x + Mobs.get(i).width/2 - 6, Mobs.get(i).y - 6 + Mobs.get(i).height/2));
						Missiles.get(0).angle = angle;
					}
					else if(tmpID == 226)
					{
						ShortSounds.add(0, new ShortSound(soundMobShoot5,soundVolume));
						MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + Mobs.get(i).width/2 - 6, Mobs.get(i).y - 6 + Mobs.get(i).height/2, 2));
						MobWeapons.get(0).angle = angle;
					}
					else if(tmpID == 227)
					{
						ShortSounds.add(0, new ShortSound(soundMobShoot5,soundVolume));
						Mobs.add(new Mob(mobTexture));
						Mobs.get(Mobs.size()-1).setMob( Mobs.get(i).x + Mobs.get(i).width/2, Mobs.get(i).y + Mobs.get(i).height/2, 221);
						Mobs.get(Mobs.size()-1).setTexture();
						MobsNumber ++;

					}
					else if(tmpID == 228)
					{
						
						ShortSounds.add(0, new ShortSound(soundMobShoot5,soundVolume));
						Mobs.add(new Mob(mobTexture));
						Mobs.get(Mobs.size()-1).setMob( Mobs.get(i).x + Mobs.get(i).width/2, Mobs.get(i).y + Mobs.get(i).height/2, 222);
						Mobs.get(Mobs.size()-1).setTexture();
						MobsNumber ++;
				
					}
					
					
				}
				
				
			}
			
			
			if(Mobs.get(i).HP <= 0)
			{
				if((Mobs.get(i).ID >= 201 && Mobs.get(i).ID <= 207)  || ( Mobs.get(i).ID >= 210 && Mobs.get(i).ID <= 228))
				{
					
					int ID = Mobs.get(i).ID;
				    if(	ID == 201)
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x, Mobs.get(i).y + 16, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
				    else if(ID == 202)
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x, Mobs.get(i).y - 6, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
				    else if(ID == 203 || ID == 204 || ID == 210 || Mobs.get(i).ID == 211 ||(ID >= 210 && ID <= 219))
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x, Mobs.get(i).y, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
				    else if(ID == 205)
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x, Mobs.get(i).y+24, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
				    else if(Mobs.get(i).ID == 206 || Mobs.get(i).ID == 207)
				    {
				    	
				    	if(ID == 207)
				    	{
				    		int kat;
							float tmpX2, tmpY2;
							Random generator = new Random();
							
							
							
				    		for(int j=0;j<8;j++)
							{
								kat = j*45;
								tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
								tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
								Explosions.add(0, new Explosion(effectTexture, Mobs.get(i).x + 16 * tmpX2, Mobs.get(i).y + 16 + 16 * tmpY2, 3));
								Explosions.get(0).tmpID = generator.nextInt(3);
								Explosions.get(0).angle = kat;
							}
				    		ShortSounds.add(0, new ShortSound(soundExplosion3,soundVolume));
				    	}
				    	else if(ID == 206)
				    	{
				    		int kat;
							float tmpX2, tmpY2;
							Explosions.add(new Explosion(effectTexture, Mobs.get(i).x, Mobs.get(i).y+20, 1));
							
				    		for(int j=0;j<8;j++)
							{
								kat = j*45;
								tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
								tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
								MobWeapons.add(0, new MobWeapon(weaponTexture, Mobs.get(i).x + 16 * tmpX2, Mobs.get(i).y + 16 + 16 * tmpY2, 2));
								MobWeapons.get(0).angle = kat;
							}
				    		ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    	}
				    }
				    else if(ID >=220 && ID <=222)
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x + 12, Mobs.get(i).y, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
				    else if(ID >=223 && ID<=228)
				    {
				    	Explosions.add(new Explosion(effectTexture, Mobs.get(i).x , Mobs.get(i).y, 1));
				    	ShortSounds.add(0, new ShortSound(soundExplosion1,soundVolume));
				    }
					
					
				}
				
				mobParticleNumberControll(i);
				MobsNumber--;
				Mobs.remove(i);			
			}
			
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mobParticleNumberControll(int i)
	{
		int ID = Mobs.get(i).ID;
		int number = 0;
		
		
		if(ID ==200) number = 0;
		else if(ID >= 201 && ID <= 204) number = 4;	
		else if(ID >= 205 && ID <= 211) number = 7;	
		else if(ID >= 212 && ID <=219) number = 4;
		else if(ID >= 220 && ID <=222) number = 3;
		else if(ID >= 223  && ID <=228) number = 8;
		
	
		for(int j =0;j<number;j++)
		{
			 mobParticles.add(0, new mobParticle(mobTexture, Mobs.get(i).x + Mobs.get(i).width/2, Mobs.get(i).y + Mobs.get(i).height/2, ID, j));
			// mobParticles.get(0).isDisappearing = false;
			
		}
		
	}

	
	public void bigMachineParticleNumberControll(int i)
	{
		int number = 0;
		int ID = bigMachines.get(i).ID;
		if(ID == 251) number = 20;
		Random generator = new Random();
		
		for(int j =0;j<number;j++)
		{
			int addX = -1 * generator.nextInt(2) + generator.nextInt(50);
			int addY = -1 * generator.nextInt(2) + generator.nextInt(30);
			mobParticles.add(0, new mobParticle(mobTexture, bigMachines.get(i).x + bigMachines.get(i).width/2 + addX, bigMachines.get(i).y + bigMachines.get(i).height/2 + addY, ID, j));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void kolizjeMoba(int i)
	{
		
		Mobs.get(i).moveX(player.x, iFPS);

		
		int tmpX, tmpY;
		
		//collision left
		for(float step = 0; step <= Mobs.get(i).height; step += Mobs.get(i).height/2)
		{
			
			//COLLISION LEFT
			tmpX = (int) ((Mobs.get(i).x)/48.0) - 27 * WindowX;
			//tmpY = (windowHeight - 1) - ((int) ((Mobs.get(i).y + step)/48.0)) - 14 * WindowY;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) ((Mobs.get(i).y + step)/48.0)) - 14 * WindowY;
			else  tmpY = (windowHeight ) - ((int) ((Mobs.get(i).y + step)/48.0)) - 15 * WindowY;
			
			if(tmpX <0 || tmpX >= windowWidth || tmpY < 0 || tmpY >= windowHeight) continue;
			
			
			
			if(Blocks[tmpX][tmpY].ID != 0 && Mobs.get(i).ID != 210 && Mobs.get(i).ID != 211) 
			{
				if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
				else  Mobs.get(i).direction = 1;				
	            Mobs.get(i).correctXPosition();
	            break;
				
			}
			else if(Blocks[tmpX][tmpY].ID != 0 &&( Mobs.get(i).ID == 210 || Mobs.get(i).ID == 211))
			{			
	            Mobs.get(i).correctXPosition();
	            break;
				
			}
			//brak bloku jako podlogi
			if(step == 0)
			{
				if(Mobs.get(i).ID == 201 || Mobs.get(i).ID == 202 || Mobs.get(i).ID == 203 || Mobs.get(i).ID == 204 || Mobs.get(i).ID == 205 || Mobs.get(i).ID == 206 || Mobs.get(i).ID == 207)
				{
					if(tmpY<14 && tmpX >0)
					{
						if(Blocks[tmpX][tmpY+1].ID == 0)
						{
							
					  	if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
					  	else  Mobs.get(i).direction = 1;
					  	Mobs.get(i).correctXPosition();
				          break;
						}
					}
					
				}
				
				
			}
			
			
			
			
		}
		
		//collision right
		for(float step = 0; step <= Mobs.get(i).height; step += Mobs.get(i).height/2)
		{
			//COLLISION RIGHT
			tmpX = (int) ((Mobs.get(i).x + Mobs.get(i).width )/48.0) - 27 * WindowX;
			//tmpY = (windowHeight - 1) - ((int) (((Mobs.get(i).y) + step)/48.0)) - 14 * WindowY;
			if(WindowY == 0) tmpY = (windowHeight - 1) - ((int) (((Mobs.get(i).y) + step)/48.0)) - 14 * WindowY;
			else  tmpY = (windowHeight) - ((int) (((Mobs.get(i).y) + step)/48.0)) - 15 * WindowY;
			
			
			if(tmpX <0 || tmpX >= windowWidth || tmpY < 0 || tmpY >= windowHeight) continue;
			
			
			if(Blocks[tmpX][tmpY].ID != 0 && Mobs.get(i).ID != 210 && Mobs.get(i).ID != 211) 
			{
				if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
				else  Mobs.get(i).direction = 1;				
	            Mobs.get(i).correctXPosition();
	            break;
				
			}
			else if(Blocks[tmpX][tmpY].ID != 0 &&( (Mobs.get(i).ID == 210 || Mobs.get(i).ID == 211 ) || (Mobs.get(i).ID >= 220 && Mobs.get(i).ID <= 222)))
			{			
	            Mobs.get(i).correctXPosition();
	            break;
				
			}
			
			if(step == 0)
			{
				if(Mobs.get(i).ID == 201 || Mobs.get(i).ID == 202 || Mobs.get(i).ID == 203 || Mobs.get(i).ID == 204 || Mobs.get(i).ID == 205 || Mobs.get(i).ID == 206 || Mobs.get(i).ID == 207)
				{
					if(tmpY<14 && tmpX <26)
					{
						if(Blocks[tmpX][tmpY+1].ID == 0)
						{
							if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
							else  Mobs.get(i).direction = 1;
							Mobs.get(i).correctXPosition();
				            break;
						}
					}
					
				}
			}
			
		}
		
		int ID = Mobs.get(i).ID;
		Mobs.get(i).moveY(player.y, iFPS);
		//collision Up & Down
		if(ID == 209 || ID == 210 || ID == 211 || (ID >=220 && ID <= 222))
		{
			
			for(float step = 0; step <= Mobs.get(i).width; step += Mobs.get(i).width/2)
			{
				
				
				//COLLISION UP
				tmpX = (int) ((Mobs.get(i).x + step)/48.0) - 27 * WindowX;
				//tmpY = (windowHeight - 1) - ((int) (((Mobs.get(i).y + Mobs.get(i).height))/48.0)) - 14 * WindowY;
				if(WindowY == 0) tmpY =  (windowHeight - 1) - ((int) (((Mobs.get(i).y + Mobs.get(i).height))/48.0)) - 14 * WindowY;
				else  tmpY =  (windowHeight) - ((int) (((Mobs.get(i).y + Mobs.get(i).height))/48.0)) - 15 * WindowY;
				
				
				if(tmpX <0 || tmpX >= windowWidth || tmpY < 0 || tmpY >= windowHeight) continue;
				
				
				if(Blocks[tmpX][tmpY].ID != 0 && ID == 209) 
				{
					
					if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
					else  Mobs.get(i).direction = 1;				
		            Mobs.get(i).correctYPosition();
		            break;
					
				}
				else if(Blocks[tmpX][tmpY].ID != 0 && (( ID ==210 || ID ==211) || (Mobs.get(i).ID >= 220 && Mobs.get(i).ID <= 222)))
				{
					 Mobs.get(i).correctYPosition();
					 Mobs.get(i).canJump = false;
				}
				
			}	
			
			for(float step = 0; step <= Mobs.get(i).width; step += Mobs.get(i).width/2)
			{
				//COLLISION DOWN
				tmpX = (int) ((Mobs.get(i).x + step)/48.0) - 27 * WindowX;
				//tmpY = (windowHeight - 1) - ((int) (((Mobs.get(i).y))/48.0)) - 14 * WindowY;
				if(WindowY == 0) tmpY =  (windowHeight - 1) - ((int) (((Mobs.get(i).y))/48.0)) - 14 * WindowY;
				else  tmpY =  (windowHeight) - ((int) (((Mobs.get(i).y))/48.0)) - 15 * WindowY;
				
				
				if(tmpX <0 || tmpX >= windowWidth || tmpY < 0 || tmpY >= windowHeight) continue;
				
				
				if(Blocks[tmpX][tmpY].ID != 0 && (ID == 209 || (Mobs.get(i).ID >= 220 && Mobs.get(i).ID <= 222) )) 
				{
					if(ID == 209)
					{
						if(Mobs.get(i).direction == 1) Mobs.get(i).direction = 2;
						else  Mobs.get(i).direction = 1;
					}
									
		            Mobs.get(i).correctYPosition();
		            break;
					
				}
				else if(Blocks[tmpX][tmpY].ID != 0 && ( ID ==210 || ID ==211))
				{
					 Mobs.get(i).correctYPosition();
					 Mobs.get(i).canJump = true;
					 Mobs.get(i).isJump = false;
					 Mobs.get(i).textureTimer = 0;
				}
				
			}	
			
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void effectsHandling()
	{
		
		for(int i=0;i<Explosions.size();i++)
		{

			Explosions.get(i).explosionHandling(iFPS);
			if(Explosions.get(i).ID == 3)
			{
				for(int j=0;j<TNTs.size();j++)
				{
					if(Explosions.get(i).hitBox.overlaps(TNTs.get(j).hitBox) == true) TNTs.get(j).isActivated = true;
				}
				
				for(int j=0;j<Mobs.size();j++)
				{
					if( Mobs.get(j).isImmortal == false && Mobs.get(j).ID != 204 &&  Mobs.get(j).ID != 225 && Explosions.get(i).hitBox.overlaps(Mobs.get(j).hitBox1) == true) 
					{
						Mobs.get(j).HP = 0;
					}
				}
			/*	for(int j=0;j<bigMachines.size();j++)
				{
					if( bigMachines.get(j).isImmortal == false && Explosions.get(i).hitBox.overlaps(bigMachines.get(j).hitBoxButton) == true) 
					{
						bigMachines.get(j).isImmortal = true;
						bigMachines.get(j).HP -=5;
					}
				}*/
				if(Explosions.get(i).hitBox.overlaps(player.hitBox) == true && player.isDead == false && Explosions.get(i).frame < 10)
				{
					player.isDead = true;
					ShortSounds.add(0, new ShortSound(soundPlayerDead,soundVolume));
					Explosions.add(i+1, new Explosion(effectTexture, player.x, player.y, 2));
					for(int j =0;j<4;j++) mobParticles.add(0, new mobParticle(playerTexture, player.x + 24, player.y + 24, 1, j));
				}
			}
			
			if(Explosions.get(i).isEnd == true) Explosions.remove(i);
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void stationarySawHandling()
	{
		
		for(int i=0;i<StationarySaws.size();i++)
		{
			StationarySaws.get(i).stationarySawHandling(iFPS);
			
			for(int k=0;k<2;k++)
			{
				if(liane[k].isActivated == true && liane[k].hitBox.overlaps(StationarySaws.get(i).hitbox))
				{
					ShortSounds.add(0, new ShortSound(soundHitbox2,soundVolume));
					liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
				
					k = 3;
				}
			}
			
			if(player.hitBox.overlaps(StationarySaws.get(i).hitbox) && player.isDead == false)
			{
				playerDeadHandling();
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void soundHandling()
	{
		
		for(int i=0;i<Sounds.size();i++)
		{

			if(Sounds.get(i).sound.isPlaying() == false)
			{
				Sounds.get(i).dispose();
				Sounds.remove(i);
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void checkpointHandling()
	{
		for(int i = 0;i<Checkpoints.size();i++)
		{
			if(Checkpoints.get(i).windowX == WindowX && Checkpoints.get(i).windowY == WindowY)
			{	
				
					if(Checkpoints.get(i).isActivated == false)
					{
						
						if(player.hitBox.overlaps(Checkpoints.get(i).hitBox) == true)
						{
							
							Checkpoints.get(i).isActivated = true;
							ShortSounds.add(0, new ShortSound(soundCheckPoint,soundVolume));
							prefsGame.putFloat("game.CheckpointX", Checkpoints.get(i).x);
							prefsGame.putFloat("game.CheckpointY", Checkpoints.get(i).y);	
							prefsGame.putBoolean("game.isContinueLocked", false);
							prefsGame.putFloat("game.gameTime", gameTime);
							
							prefsGame.flush();

							
							for(int k=0;k<Checkpoints.size();k++) //resetuj pozostale checkpointy
							{
								if(k != i) Checkpoints.get(k).isActivated = false;	
							}
							
							
						}	
					}
			}
			
			Checkpoints.get(i).handling();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void obslugaTNT()
	{
		
		for(int i=0;i< TNTs.size();i++)
		{
			
			TNTs.get(i).handlingTNT();
			
			for(int k=0;k<2;k++) //kolizja z lianami
			{
				if(liane[k].hitBox.overlaps(TNTs.get(i).hitBox) == true && liane[k].isActivated == true)
				{
					TNTs.get(i).isActivated = true;	
					TNTs.get(i).explodeTimer =0.4f;
				}
					
			}
			
			if(TNTs.get(i).isActivated == true  && TNTs.get(i).explodeTimer >0.3f)
			{
				int tmpX = (int)(TNTs.get(i).x % 1296)/48;
				int tmpY;// = (int)((windowHeight-1)*48 - ((TNTs.get(i).y %720)))/48;
				if(WindowY == 0) tmpY = (int)((windowHeight-1)*48 - ((TNTs.get(i).y %720)))/48;
				else  tmpY = ((int)((windowHeight-1)*48 - ((int)((windowHeight)*48 + ((TNTs.get(i).y %720))))))/48;
				if(tmpY < 0) tmpY *= -1;

				
				Blocks[tmpX][tmpY].ID = 0;
				
				//Sounds.add(0, new SoundEffect(soundExplosion3));
				ShortSounds.add(0, new ShortSound(soundExplosion3,soundVolume));
				int kat;
				float tmpX2, tmpY2;
				//Random generator = new Random();
				
				if( TNTs.get(i).ID == 111)
				{
					for(int j=0;j<8;j++)
					{
						kat = j*45;
						tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
						tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
						Explosions.add(0, new Explosion(effectTexture, TNTs.get(i).x + 16 * tmpX2, TNTs.get(i).y + 16 * tmpY2, 3));
						Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
						Explosions.get(0).angle = kat;
					}
				}
				
				else if( TNTs.get(i).ID == 112)
				{
					for(int j=0;j < 8; j++)
    				{
    					MobWeapons.add(0, new MobWeapon(weaponTexture, TNTs.get(i).x + 24, TNTs.get(i).y + 24 , 2));
            			MobWeapons.get(0).angle = j * 45;
    				}
				}
				
				
				TNTs.remove(i);
				i--;
				
			}
			if(i<0)i=0;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void spikesHandling()
	{
		for(int i=0;i<Kolce.size();i++)
		{
			if(player.hitBox.overlaps(Kolce.get(i).hitBox) && player.isDead == false)
			{
				playerDeadHandling();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void shortSoundsHandling()
	{
		for(int i=0;i<ShortSounds.size();i++)
		{ 
			ShortSounds.get(i).handling();
			if(ShortSounds.get(i).timer > 0.75) 
			{
				ShortSounds.get(i).dispose();
				ShortSounds.remove(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void musicHandling()
	{
		
		//if(isSecretRoom == true) isSecretRoom = false;
		//else isSecretRoom = true;
		if(BossNumber > 0 && isEndGame == false)
		{
			
			if(musicChange == false)
			{
				for(int i=0;i<musicEffects.size();i=i)
				{
					musicEffects.get(i).dispose();
					musicEffects.remove(i);
				}
				musicChange = true;
				
			}
			
			if(BossEye.get(0).isDestroyed == true && musicEffects.get(0).isDowning == false)
			{
				//System.out.println(x);
				musicEffects.get(0).setDowning(true);
			}
			
			if(BossEye.get(0).HP <= 0) musicEffects.get(0).sound.setLooping(false);
			
			if(musicEffects.size() == 0) 
			{
				musicEffects.add(0, new MusicEffect(musicBoss, musicVolume));
				musicEffects.get(0).sound.setLooping(true);
			}
			
		}
		
		else if(BossNumber == 0 && isEndGame == false )
		{

			if(musicEffects.size() > 0 && (musicChange == true || musicEffects.get(0).sound.isPlaying() == false || isSecretRoom != wasSescretRoom ))
			{
	
				
				for(int i=0;i<musicEffects.size();i=i)
				{
					musicEffects.get(i).dispose();
					musicEffects.remove(i);	
				}
				if(isSecretRoom != wasSescretRoom && isSecretRoom == true) gameMusicNumber --;
				musicChange = false;
				wasSescretRoom = isSecretRoom; 
			}
			
			
					if(musicEffects.size() == 0 && isSecretRoom == false)
					{

						Music tmpMusic = musicGame1;
						
						
						
						if(gameMusicNumber == 0) tmpMusic = musicGame1;
						else if(gameMusicNumber == 1) tmpMusic = musicGame2;
						else if(gameMusicNumber == 2) tmpMusic = musicGame3;
						else if(gameMusicNumber == 3) tmpMusic = musicGame4;
						else if(gameMusicNumber == 4) tmpMusic = musicGame5;
						else if(gameMusicNumber == 5) tmpMusic = musicGame6;
						else if(gameMusicNumber == 6) tmpMusic = musicGame7;
						
						
						
						gameMusicNumber++;
						if(gameMusicNumber > 6) gameMusicNumber = 0;
						musicEffects.add(0, new MusicEffect(tmpMusic, musicVolume));
						musicEffects.get(0).sound.setLooping(false);
						
						
					}
					
		
					if(musicEffects.size() == 0 && isSecretRoom == true)
					{
						musicEffects.add(0, new MusicEffect(musicSecret, musicVolume));
						musicEffects.get(0).sound.setLooping(true);
					}
			
			
			
			
		}
	
	
		wasMusicChange = musicChange;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void DoorsHandling()
	{
		
		for(int i=0;i<Doors.size();i++)
		{
			
			if(MobsNumber == 0 && tmpLastMobsNumber != MobsNumber) Sounds.add(0, new SoundEffect(soundDoorRedOpen, soundVolume));
			if(Doors.get(i).ID == 120)
			{
				if(BlockButtonsActivatedAll == true)
				{
					if(i == 0) ShortSounds.add(0, new ShortSound(soundDoorBlueOpen,soundVolume));
					int tmpX = (int)(Doors.get(i).x % 1296)/48;
					int tmpY; //= (int)((windowHeight-1)*48 - ((Doors.get(i).y %720)))/48;
					if(WindowY == 0)tmpY=  (int)((windowHeight-1)*48 - ((Doors.get(i).y %720)))/48;
					else tmpY = ((int)((windowHeight-1)*48 - ((int)((windowHeight)*48 + ((Doors.get(i).y %720))))))/48;
					Blocks[tmpX][tmpY].ID = 0;
					Doors.remove(i);
					i--;
					continue;
				}			
			}
			
			else if(Doors.get(i).ID == 121)
			{
				if(MobsNumber == 0)
				{
					
					int tmpX = (int)(Doors.get(i).x % 1296)/48;
					int tmpY; //= (int)((windowHeight-1)*48 - ((Doors.get(i).y %720)))/48;
					if(WindowY == 0)tmpY=  (int)((windowHeight-1)*48 - ((Doors.get(i).y %720)))/48;
					else tmpY = ((int)((windowHeight-1)*48 - ((int)((windowHeight)*48 + ((Doors.get(i).y %720))))))/48;
					Blocks[tmpX][tmpY].ID = 0;
					Doors.remove(i);
					i--;
					continue;
				}
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void BlockButtonsHandling()
	{
		BlockButtonsActivatedAll = true;
		for(int i=0;i<BlockButtons.size();i++)
		{
			for(int k=0;k<2;k++)
			{
				
				if(liane[k].hitBox.overlaps(BlockButtons.get(i).hitBox) == true && liane[k].isActivated == true && BlockButtons.get(i).isActivated == false )
				{
					ShortSounds.add(0, new ShortSound(soundBlockButtonPresed,soundVolume));
					BlockButtons.get(i).isActivated = true;
					BlockButtons.get(i).textureHandling();
					liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
				}
				else if(liane[k].hitBox.overlaps(BlockButtons.get(i).hitBox) == true && liane[k].isActivated == true)
				{				
					liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
					break;
				}
				
				
				if(BlockButtons.get(i).isActivated == true && BlockButtons.get(i).wasActivated == false && BlockButtons.get(i).ID == 136 )
				{
					
					BlockButtons.get(i).wasActivated = true;
					MobsNumber --;
					
					for(int j =0;j<BossTower.size();j++)
					{
						if(BlockButtons.get(i).objectNumber == BossTower.get(j).ID) BossTower.get(j).isDestroyed = true;
					}
					
					for(int j =0;j<BossRocket.size();j++)
					{
						if(BlockButtons.get(i).objectNumber == BossRocket.get(j).ID) BossRocket.get(j).isDestroyed = true;
					}
					
				}
				
				if(BlockButtons.get(i).isActivated == false) BlockButtonsActivatedAll = false;
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void FlowersHandling()
	{
		
		for(int i=0;i<Flowers.size();i++)
		{
			if(player.hitBox.overlaps(Flowers.get(i).hitBox) == true && Flowers.get(i).isActivated == false)
			{
				Flowers.get(i).isActivated = true;	
				ShortSounds.add(0,new ShortSound(soundFlower,soundVolume));
				flowersCollected ++;

				String tmpFlowerCollected = "game.flowerCollected" + i;
				prefsGame.putBoolean(tmpFlowerCollected, true);
				prefsGame.flush();
				
			}
				
		    Flowers.get(i).handling();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void missilesHandling()
	{
		
		for(int i=0;i < Missiles.size();i++)
		{
			Missiles.get(i).textureHandling();
			Missiles.get(i).move(player.x, player.y, iFPS);
			
			if(player.hitBox.overlaps(Missiles.get(i).hitBox) == true && player.isDead == false)
			{
				playerDeadHandling();
			}
			
			
			for(int step = 0 ; step<9 ; step++)
			{
				int tmpX = (int) ((Missiles.get(i).x)/48.0) - 27*WindowX;
				int tmpY; //= (windowHeight - 1) - ((int) ((Missiles.get(i).y + 48)/48.0))  - 14*WindowY;
				
				if(WindowY == 0)tmpY = (windowHeight - 1) - ((int) ((Missiles.get(i).y + 48)/48.0))  - 14*WindowY;
				else tmpY = (windowHeight ) - ((int) ((Missiles.get(i).y + 48)/48.0))  - 15*WindowY;
				
				
			//	if(tmpX==7 && tmpY== 5) System.out.println(tmpX +" "+ tmpY);
				
				tmpX += -1 + step/3;
				tmpY += -1 + step%3;
				
			//	if(i == 0) System.out.println(tmpX +" " + tmpY);
				
				if(tmpX <0 || tmpX >= windowWidth || tmpY < 0 || tmpY >= windowHeight) continue;
				
				if(Missiles.get(i).hitBox.overlaps(Blocks[tmpX][tmpY].hitBox) == true && Blocks[tmpX][tmpY].ID != 0)
				{
					Missiles.get(i).isActivated = true;
					
				}			
			}
			
			if(Missiles.get(i).isActivated == true)
			{
		        ShortSounds.add(0, new ShortSound(soundExplosion5,soundVolume));
				int kat;
				float tmpX2, tmpY2;
				Random generator = new Random();
				
				for(int j=0;j<8;j++)
				{
					kat = j*45;
					tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
					tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
					Explosions.add(0, new Explosion(effectTexture, Missiles.get(i).x + 12* (float)Math.cos((Missiles.get(i).angle + 90)*Math.PI/180.0) + 16 * tmpX2, Missiles.get(i).y + 18 * (float)Math.sin((Missiles.get(i).angle+90)*Math.PI/180.0) + 16 * tmpY2, 3));
					Explosions.get(0).tmpID = generator.nextInt(3);
					Explosions.get(0).angle = kat;
				}
				
				
				for(int j=0;j<7;j++) missileParticles.add(0, new missileParticle(weaponTexture,  Missiles.get(i).x, Missiles.get(i).y, 10, j, 0));
				
				Missiles.remove(i);
			}
			
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public void signsHandling()
    {
    	
    	for(int i=0;i<Signs.size();i++)
    	{
    		
    		if(WindowX == Signs.get(i).windowX && WindowY == Signs.get(i).windowY)
    		{
    			if(player.hitBox.overlaps(Signs.get(i).hitBox) == true)
    			{
    				signText.claerText();
    				signText.setID(Signs.get(i).ID);
    				signText.setSings();
    				signText.isActivated = true;
    				isReading = true;
    				break;
    			}
    		}
    		
    	}
    	
    }
	
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void breakableBlocksHandling()
    {
    	
    	for(int i=0;i<breakableBlocks.size();i++)
    	{
    		
    		for(int k=0;k<liane.length;k++)
    		{
    			
    			if(liane[k].isActivated == true && liane[k].hitBox.overlaps(breakableBlocks.get(i).hitBox) == true && breakableBlocks.get(i).immortalTimer >= 0.15)
    			{
    				breakableBlocks.get(i).HP--;
    				breakableBlocks.get(i).immortalTimer = 0;
    				ShortSounds.add(0, new ShortSound(soundHit, soundVolume));
    				
    				liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
    			}
    			
    		}
    		
    		breakableBlocks.get(i).breakableBlockHandling();
    		
    		if(breakableBlocks.get(i).HP <= 0 )
    		{
    			if(breakableBlocks.get(i).ID == 125) ShortSounds.add(0, new ShortSound(soundGlass, soundVolume));
    			else if(breakableBlocks.get(i).ID == 126) ShortSounds.add(0, new ShortSound(soundIron, soundVolume));
    			else if(breakableBlocks.get(i).ID == 127) ShortSounds.add(0, new ShortSound(soundRedIron, soundVolume));
    			
    			for(int j=0;j<4;j++) blockParticles.add(0, new blockParticle(blockTexture, breakableBlocks.get(i).x + 24, breakableBlocks.get(i).y + 24, breakableBlocks.get(i).ID, j));
    			
    			int tmpX = (breakableBlocks.get(i).x / 48) - WindowX*windowWidth;
    			int tmpY = (windowHeight-1) - ((breakableBlocks.get(i).y/48) + WindowY*windowHeight) ;
    			Blocks[tmpX][tmpY].ID = 0;
    			breakableBlocks.remove(i);
    		}
    		
    		
    	}
    	
    }
	
	
	
    
    
    
    
    
    
    
    
	
    
    
    
    public void disappearingBlocksHandling()
    {
    	
    	for(int i=0;i<disappearingBlocks.size();i++)
    	{
    		
    		disappearingBlocks.get(i).disappearingBlockHandling();
    		if(player.hitBox.overlaps(disappearingBlocks.get(i).hitBox) == true)
    		{
    			disappearingBlocks.get(i).isActivated = true;
    		}

    		if(disappearingBlocks.get(i).textureTimer > disappearingBlocks.get(i).maxTime)
    		{
    			int tmpX = (disappearingBlocks.get(i).x / 48) - WindowX*windowWidth;
    			int tmpY = (windowHeight-1) - ((disappearingBlocks.get(i).y/48) + WindowY*windowHeight) ;
    			Blocks[tmpX][tmpY].ID = 0;
    			disappearingBlocks.remove(i);
    		}
    		
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void pulsingBlocsHandling()
    {
    	
    	for(int i = 0; i < pulsingBlocks.size();i++)
    	{
    		int tmpX = pulsingBlocks.get(i).tmpX;
    		int tmpY = pulsingBlocks.get(i).tmpY;	
    		
    		if(pulsingBlocks.get(i).phase == 3 && pulsingBlocks.get(i).rTimer >= pulsingBlocks.get(i).maxStableTime && player.hitBox.overlaps(pulsingBlocks.get(i).hitBox) == false) pulsingBlocks.get(i).canShow = true;
    		
    		pulsingBlocks.get(i).pulsingBlockHandling();
    		
    		if(pulsingBlocks.get(i).isSolid == true) Blocks[tmpX][tmpY].ID = pulsingBlocks.get(i).ID;
    		else Blocks[tmpX][tmpY].ID = 0;
    			
    		
    		
    	}
    	
    }
    
	
    
    
    
    
    
    
    
    
    
	
    
    
    
    public void greenBlocksHandling()
    {
    	
    	for(int i=0;i<greenBlocks.size();i++)
    	{
    		if(greenBlocks.get(i).isActivated == false) break;
    		if(flowersCollected == maxFlowerNumber)
    		{
    			int tmpX = greenBlocks.get(i).tmpX;
    			int tmpY = greenBlocks.get(i).tmpY;
    			greenBlocks.get(i).isActivated = false;
    			Blocks[tmpX][tmpY].ID = 0;
    		}
    		
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void bigMachinesHandling()
    {
    	
    	for(int i=0;i<bigMachines.size();i++)
    	{
    		
    		for(int k = 0;k<2;k++)
    		{
    			boolean isTouched = false;
    			if(liane[k].hitBox.overlaps(bigMachines.get(i).hitBoxMachine) == true && liane[k].isActivated == true) isTouched = true;
    			else if(liane[k].hitBox.overlaps(bigMachines.get(i).hitBoxWeapon1) == true && liane[k].isActivated == true) isTouched = true;
    			else if(liane[k].hitBox.overlaps(bigMachines.get(i).hitBoxWeapon2) == true && liane[k].isActivated == true) isTouched = true;
    			else if(liane[k].hitBox.overlaps(bigMachines.get(i).hitBoxButton) == true && liane[k].isActivated == true)
    			{
    				isTouched = true;
    				bigMachines.get(i).isImmortal = true;
    				bigMachines.get(i).HP --;
    			}
    			
    			
    			if(isTouched == true )
    			{
    				ShortSounds.add(0, new ShortSound(soundHitbox2,soundVolume));
					liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
				
					k = 3;
    			}
    			
    				
    			
    			
    		}
    		
    		boolean isDead = false;
    		
    		if(player.hitBox.overlaps(bigMachines.get(i).hitBoxMachine) == true) isDead = true;
    		else if(player.hitBox.overlaps(bigMachines.get(i).hitBoxWeapon1) == true) isDead = true;
    		else if(player.hitBox.overlaps(bigMachines.get(i).hitBoxWeapon2) == true) isDead = true;
    		
    		
    		if(isDead == true && player.isDead == false)
    		{
    			playerDeadHandling();
    		}
    		
    		
    		bigMachines.get(i).setTexture();
    		
    		if(bigMachines.get(i).canShoot == true)
    		{
    			
    			ShortSounds.add(0, new ShortSound(soundMobShoot6,soundVolume));
    			
    			bigMachines.get(i).canShoot = false;
    			bigMachines.get(i).wasShoot = true;
    			MobWeapons.add(0, new MobWeapon(weaponTexture, bigMachines.get(i).x + 174, bigMachines.get(i).y + 93, 4));
    			MobWeapons.get(0).angle = 0;
    			MobWeapons.add(0, new MobWeapon(weaponTexture, bigMachines.get(i).x + 174, bigMachines.get(i).y + 9, 4));
    			MobWeapons.get(0).angle = 0;
    		}
    		
    		if(bigMachines.get(i).canShootMissile == true)
    		{
    			
    			ShortSounds.add(0, new ShortSound(soundMobShoot8,soundVolume));
    			
    			bigMachines.get(i).canShootMissile = false;
    			bigMachines.get(i).wasShootMissile = true;
    			Missiles.add(0, new Missile(weaponTexture, bigMachines.get(i).x + 24 + 48 * bigMachines.get(i).missileAdded-1, bigMachines.get(i).y + 78));
    		}
    		
    		if(bigMachines.get(i).HP <= 0) //big machine dead
    		{
    			int kat;
    			float tmpX2, tmpY2;
    			for(int j=0;j<8;j++)
				{
					kat = j*45;
					tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
					tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
					Explosions.add(0, new Explosion(effectTexture, bigMachines.get(i).x + bigMachines.get(i).width/2 - 40 + 32 * tmpX2, bigMachines.get(i).y + bigMachines.get(i).height/2 - 30 + 32 * tmpY2, 4));
					Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
					Explosions.get(0).angle = kat;
				}
    			bigMachineParticleNumberControll(i);
    			bigMachines.remove(i);
    			MobsNumber --;
    			i--;
    		}
    		
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    public void cloudsHandling()
    {
    	
    	for(int i=0;i<Clouds.size();i++)
    	{
    		
    		Clouds.get(i).cloudsHandling();
    		if(Clouds.get(i).isEnd == true)
    		{
    			Clouds.remove(i);
    			i--;
    		}
    		
    	}
    	
    }
    
    
    
    
    
    
    
    
    
    public void missileParticleHandling()
    {
    	
    	for(int i=0;i<missileParticles.size();i++)
    	{
    		
    		missileParticles.get(i).missileParticleHandling();
    		if(missileParticles.get(i).windowX != WindowX || missileParticles.get(i).windowY > WindowY || missileParticles.get(i).alphaTimer >= 3) 
    		{  	
    			missileParticles.remove(i);
    			i--;
    		}
  	
    	}
	
    }
    
    
    
    
    
    
    
    
    public void mobParticleHandling()
    {
    	
    	for(int i=0;i<mobParticles.size();i++)
    	{	
    		
    		mobParticles.get(i).mobParticleHandling();
    		if(mobParticles.get(i).windowX != WindowX || mobParticles.get(i).windowY > WindowY || mobParticles.get(i).alphaTimer >= mobParticles.get(i).maxAlphaTime) 
    		{  	
  
    			mobParticles.remove(i);
    			i--;
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    public void blockParticleHandling()
    {
    	
    	for(int i=0;i<blockParticles.size();i++)
    	{	
    		
    		blockParticles.get(i).blockParticleHandling();
    		if(blockParticles.get(i).windowX != WindowX || blockParticles.get(i).windowY > WindowY) 
    		{  	
    			blockParticles.remove(i);
    			i--;
    		}
    		
    		
    		
    	}
    	
    	
    }
    
    
    
    
    
    
    public void bossHandling()
    {
    	
    	for(int i=0;i<BossEye.size();i++)
    	{
  
    		BossEye.get(i).textureHandling();
    		BossEye.get(i).mobHandling(player.x, player.y);
    		
    		
    		if(BossEye.get(i).canShoot == true)
    		{
    		//	ShortSounds.add(0, new ShortSound(soundNyg,soundVolume));
    			ShortSounds.add(0, new ShortSound(soundBossTowerShoot,soundVolume* 0.2f));
    			BossEye.get(i).canShoot = false;
    			if(BossEye.get(i).attack <= 2 || BossEye.get(i).attack == 20  || BossEye.get(i).attack == 25 || BossEye.get(i).attack == 26 || BossEye.get(i).attack == 28)
    			{
    				MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
        					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 5));
        			MobWeapons.get(0).angle = BossEye.get(i).angle;
    			}
    			else if((BossEye.get(i).attack >= 2 && BossEye.get(i).attack <= 19) || (BossEye.get(i).attack >= 29 && BossEye.get(i).attack <= 49))
    			{
    				for(int j=0;j < 8; j++)
    				{
    					MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
            					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 3));
            			MobWeapons.get(0).angle = j * 45 + 10 * BossEye.get(i).attack;
    				}
    			}
    			else if(BossEye.get(i).attack == 21 ||  BossEye.get(i).attack == 23)
    			{
    				MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
        					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 6));
        			MobWeapons.get(0).angle = BossEye.get(i).angle;
    			}
    			else if(BossEye.get(i).attack == 22)
    			{
    				for(int j=0;j<20;j++)
    				{
    					MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
            					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 7));
    					MobWeapons.get(0).angle = BossEye.get(i).angle;
    				}
    			}
    			else if(BossEye.get(i).attack == 24 || BossEye.get(i).attack == 27)
    			{
    				for(int j=0;j < 12; j++)
    				{
    					if(BossEye.get(i).shootAdded % 2 == 0)
    					{
    						MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
                					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 8));
    					}
    					else
    					{
    						MobWeapons.add(0, new MobWeapon(weaponTexture, BossEye.get(i).x + 144 + (int)(64 * Math.cos(BossEye.get(i).angle * Math.PI / 180.0)),
                					BossEye.get(i).y + 144  + (int)(64 * Math.sin(BossEye.get(i).angle * Math.PI / 180.0)), 9));
    					}
    					
            			MobWeapons.get(0).angle = j * 30 + 20 * BossEye.get(i).shootAdded;
    				}
    				
        			
    			}
    			
    			
    		}
    		
    		
    		for(int k=0;k<2;k++)
    		{
    			
    			if(liane[k].hitBox.overlaps(BossEye.get(i).dangerousHitBox) == true && liane[k].isActivated == true)
    			{
    				ShortSounds.add(0, new ShortSound(soundHitbox2,soundVolume));
    				liane[0].isActivated = false;
					liane[1].isActivated = false;
					liane[1].textureTimer = 2;
					liane[0].textureTimer = 2;
					player.isShot = false;
					break;
    			}
    			
    			if(BossEye.get(i).isImmortal == false)
    			{
    				
        			if(liane[k].hitBox.overlaps(BossEye.get(i).hitBox) && liane[k].isActivated == true)
        			{
        				ShortSounds.add(0, new ShortSound(soundHit,soundVolume));
        				BossEye.get(i).HP --;
        				BossEye.get(i).isImmortal = true;
        			}
    			}
    			
    		}
    		
    		if(player.hitBox.overlaps(BossEye.get(i).dangerousHitBox) && player.isDead == false && BossEye.get(i).HP > 0)
    		{
    			playerDeadHandling();
    		}
    		
    		bossHealthLine.bossMiscHandling(BossEye.get(i).HP);
    		
    		if(BossEye.get(i).HP <= 0) BossEye.get(i).isDestroyed = true;
    		
    		
    		
    		//BOSS DEAD
    		
    		if(BossEye.get(i).isDestroyed == true)
    		{
    			shakeCamera();
    			BossEye.get(i).destroyHandling();
    			int explosionBossNumber = BossEye.get(i).destroyExplosionNumber;
    			
    			if(BossEye.get(i).destroyTimer > 3)
    			{
    				alpha = (BossEye.get(i).destroyTimer- 3) /3.0f;
    				soundVolume = tmpSoundVolume * (float)( 1f - (BossEye.get(i).destroyTimer- 3) /3.0f);
    				if(soundVolume<0) soundVolume = 0;
    			//	musicVolume = tmpMusicVolume * (float)( 1f - (BossEye.get(i).destroyTimer- 3) /3.0f);
    			}
    			
    			
    			if(explosionBossNumber != BossEye.get(i).wasDestroyExplosionNumber)
    			{
    				
    				
    				
    				int kat = 0, IDexplosion = 0;
    				float tmpX2, tmpY2;
    				float addX, addY;
    				
    				
    				
    				BossEye.get(i).wasDestroyExplosionNumber = explosionBossNumber;
    				
    				if(explosionBossNumber == 1)
    				{
    					
    					for(int j=0;j< Mobs.size();j++) Mobs.get(j).HP = 0;
    					for(int j=0;j<MobWeapons.size();j=j)
    					{
    						MobWeapons.remove(j);
    						
    					}
    					
    					ShortSounds.add(0, new ShortSound(soundBossDead2,soundVolume));
    					IDexplosion = 4;
    					addX = -60;
    					addY = -70;
    				}
    				else if(explosionBossNumber == 2)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead5,soundVolume));
    					IDexplosion = 4;
    					addX = 70;
    					addY = 80;
    				}
    				else if(explosionBossNumber == 3)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead4,soundVolume));
    					IDexplosion = 4;
    					addX = -110;
    					addY =  -120;
    				}
    				else if(explosionBossNumber == 4)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead5,soundVolume));
    					IDexplosion = 4;
    					addX = -30;
    					addY = 100;
    				}
    				else if(explosionBossNumber == 5)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead2,soundVolume));
    					IDexplosion = 4;
    					addX = -100;
    					addY = -54;
    				}
    				else if(explosionBossNumber == 6)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead1,soundVolume));
    					IDexplosion = 4;
    					addX = 33;
    					addY = 12;
    				}
    				else if(explosionBossNumber == 7)
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead3,soundVolume));
    					IDexplosion = 4;
    					addX = 95;
    					addY = -130;
    				}
    				else
    				{
    					ShortSounds.add(0, new ShortSound(soundBossDead5,soundVolume));
    					IDexplosion = 5;
    					addX = -90;
    					addY = -50;
    				}
    					
    				for(int j=0;j<8;j++)
    				{
    					kat = j*45;
    					tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
    					tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
    					Explosions.add(0, new Explosion(effectTexture, BossEye.get(i).x + BossEye.get(i).width/2 + 16 * tmpX2 + addX,  BossEye.get(i).y + BossEye.get(i).height/2 + 16 * tmpY2 + addY, IDexplosion));
    					Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
    					Explosions.get(0).angle = kat;
    				}
    					
    			}
    			
    			if(BossEye.get(i).destroyExplosionNumber >= 8 )
    			{
    				

    				if(musicChange == true) wasMusicChange = false;
    				else wasMusicChange= true;
    				isEndGame = true;
    				end = 2;
    				BossEye.remove(i);
    				
    			}
    			
    		}//BOSS DEAD
    		
    		
    	}
    	
    	for(int i=0;i<BossTower.size();i++)
    	{
    		
    		
    		BossTower.get(i).textureHandling(player.x, player.y);
    		if(BossTower.get(i).canShoot == true)
    		{
    			
    			ShortSounds.add(0, new ShortSound(soundBossTowerShoot,soundVolume));
    			
    			BossTower.get(i).canShoot = false;
    			MobWeapons.add(0, new MobWeapon(weaponTexture, BossTower.get(i).x + 96 + (int)(150 * Math.cos((BossTower.get(i).angle +90)* Math.PI / 180.0)),
    					BossTower.get(i).y + 150 + (int)(150 * Math.sin((BossTower.get(i).angle +90)* Math.PI / 180.0)), 5));
    			MobWeapons.get(0).angle = BossTower.get(i).angle + 90;
    		}
    		
    		if(player.hitBox.overlaps(BossTower.get(i).dangerousHitbox) == true && player.isDead == false) playerDeadHandling();
    		
    		
    		if(BossTower.get(i).isDestroyed == true)
    		{
    			
    			int kat;
                float tmpX2, tmpY2;
            	
            	for(int j=0;j<8;j++)
    			{
    				kat = j*45;
    				tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
    				tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
    				Explosions.add(0, new Explosion(effectTexture, BossTower.get(i).x +51 , BossTower.get(i).y + 75 , 5));
    				Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
    				Explosions.get(0).angle = kat;
    			}
    			
            	ShortSounds.add(0, new ShortSound(soundBossTowerExplode,soundVolume));
            	BossTower.remove(i);
    		}
            
    		
    	}
    	
        for(int i=0;i<BossRocket.size();i++)
        {
        	
        	BossRocket.get(i).textureHandling(player.x, player.y);
    		if(BossRocket.get(i).canShoot == true)
    		{
    			
    			ShortSounds.add(0, new ShortSound(soundMobShoot8,soundVolume));
    			
    			BossRocket.get(i).canShoot = false;
    			Missiles.add(0, new Missile(weaponTexture, BossRocket.get(i).x + 96 + (int)(216 * Math.cos((BossRocket.get(i).angle +90)* Math.PI / 180.0)),
    					BossRocket.get(i).y + 96 + (int)(216 * Math.sin((BossRocket.get(i).angle +90)* Math.PI / 180.0))));
    			Missiles.get(0).angle = BossRocket.get(i).angle + 90;
    		}
    		
    		if(player.hitBox.overlaps(BossRocket.get(i).dangerousHitbox) == true  && player.isDead == false) playerDeadHandling();
    		
    		
    		if(BossRocket.get(i).isDestroyed == true)
    		{
    			
    			int kat;
                float tmpX2, tmpY2;
            	
            	for(int j=0;j<8;j++)
    			{
    				kat = j*45;
    				tmpX2 = (float) Math.cos((kat* Math.PI/180.0));
    				tmpY2 = (float) Math.sin((kat* Math.PI/180.0));
    				Explosions.add(0, new Explosion(effectTexture, BossRocket.get(i).x +144 + 48 * tmpX2 + (int)(150 * Math.cos((BossRocket.get(i).angle +90)* Math.PI / 180.0)), 
    						BossRocket.get(i).y + 28 + 48 * tmpY2 + (int)(150 * Math.sin((BossRocket.get(i).angle +90)* Math.PI / 180.0)), 5));
    				Explosions.get(0).tmpID = j%3;//generator.nextInt(3);
    				Explosions.get(0).angle = kat;
    			}
            	
            	ShortSounds.add(0, new ShortSound(soundBossTowerExplode,soundVolume));
            	BossRocket.remove(i);
    		}
        	
        }
    	
    }
    
    
    
    public void shakeCamera()
    {
    	shakeCameraTimer += Gdx.graphics.getDeltaTime();
    	if(shakeCameraTimer > 0.1)
    	{
    		shakeCameraTimer =0;
    		if(shakeCameraY == 15)
    		{
    			shakeCameraY = -15;
    			ShortSounds.add(0, new ShortSound(soundShake1,soundVolume));
    		}
    		else
    		{
    			shakeCameraY = 15;
    			ShortSounds.add(0, new ShortSound(soundShake2,soundVolume));
    		}
    	}
    	camera.position.set(648 + cameraX + 1296 * WindowX + shakeCameraX,360 + cameraY - 720 * WindowY + shakeCameraY,0);
		camera.update();
    }
    
    
    
    public void endUpdate()
    {
    	
    	endTimer += Gdx.graphics.getDeltaTime();
    	if(endTimer >= 2 && endTimer <=12)
    	{
    		alpha = 1 - ((endTimer -2)/10.0f);
    		curtain.setColor(0,0,0, alpha);
    	}
    	
    	if(endTimer >= 54 && endTimer <= 64 && alpha < 1)
		{
    		alpha = ((endTimer -54)/10.0f);
    		if(alpha > 1) alpha = 1;
    		curtain.setColor(0,0,0, alpha);
		}
    	
    	if(endTimer > 64.5) isReturn = true;
    	
    	
    	if(musicEffects.size() == 0)
    	{
    		musicVolume = prefsSettings.getFloat("setting.musicVolume",0.5f);
    		musicEffects.add(0, new MusicEffect(musicIntro, musicVolume));
        	
    	}
    
    	
    	if(wasMusicChange != musicChange)
		{
			for(int j=0;j<musicEffects.size();j=j)
			{
				musicEffects.get(j).dispose();
				musicEffects.remove(j);					
			}
			
			prefsGame.putBoolean("game.isContinueLocked", true);
				
			wasMusicChange = musicChange;
			
			String hours = ""; 
			if( (int)(gameTime /3600) <1) hours = "00";
			else if((int)(gameTime /3600) <10) hours = "0" + (int)(gameTime /3600);
			else hours = "" + (int)(gameTime /3600);
			
			String minutes = ""; 
			if( (int)(gameTime %3600)/60 <1) minutes = "00";
			else if((int)(gameTime %3600)/60 <10) minutes = "0" + (int)(gameTime %3600)/60;
			else minutes = "" + (int)(gameTime %3600)/60;
				
			String seconds = ""; 
			if( (int)(gameTime %60) <1) seconds = "00";	
			else if((int)(gameTime %60) <10) seconds = "0" + (int)(gameTime %60);		
			else seconds = "" + (int)(gameTime %60);
				
			
			
			String sTime[] =
			{
						"TIME:" + hours + ":" + minutes + ":" + seconds
			};	
			String tmp1[] =
			{
						"ATTEMPTS:" + (deadNumber+1)
			};
			String tmp2[] =
			{
				        "PRESS Z TO EXIT"
			};

			deadEndNumberText = new menuText(300, 20,tmp1, miscTexture, 3);
			timeEndText = new menuText(372, 80,sTime, miscTexture, 3);
			pressZEnd = new menuText(1150, 10, tmp2, miscTexture, 1);
			
			if(end == 2) theEndTitleText = new menuTitleText(400, 680, "YOU DESTROYED FACTORY NUMBER 2358", miscTexture, 2);
			else if(end == 1) theEndTitleText = new menuTitleText(500, 680, "YOU SURVIVED", miscTexture, 3);
				
		}
    	
    	
    	
		
    	
    	if(end == 1)region.setTexture(end1Texture);   		
    	else region.setTexture(end2Texture);
    		
    	region.setRegion(0,0,128,90);
    	
    	endSprite.setRegion(region);
    	endSprite.setBounds(0, 0, 1296, 720);
    	
    	if(Gdx.input.isKeyPressed(Keys.Z)) isReturn = true;
     	
    }
    
    
    
    public void gameMenuUpdate()
    {
    	
    	gameMenuSterowanie();
    	updateSelected();
    	gameMenuHandling();
    	
    	
    }
    
    public void gameMenuHandling()
	{
		//if(isSelected != wasSelected) System.out.println(isSelected + " " + wasSelected);
		if(selectedNumber == 0 && isSelected == true && isSelected != wasSelected)//Game
		{
			isGameMenu = false;
			
		}
		else if(selectedNumber == 1 && isSelected == true  && isSelected != wasSelected)//CONTINUE
		{
			options.create(false);	
		}
		else if(selectedNumber == 2 && isSelected == true && isSelected != wasSelected)//OPTIONS
		{
			//save
			isReturn = true;
		}
		else if(selectedNumber == 3 && isSelected == true && isSelected != wasSelected)//EXIT
		{		
			//save
			Gdx.app.exit();
		}
		
		wasSelected = isSelected;
	}
	
	public void renderOtherScreen()
	{
		
		
		if(selectedNumber == 1 && isSelected == true)//OPTIONS
		{
            
			options.render(musicEffects.get(0));
			if(options.isReturn == true)
			{
				
				options.dispose();
				isSelected = false;
				
				musicVolume = prefsSettings.getFloat("settings.musicVolume",0.5f)/2.0f;
		        soundVolume = prefsSettings.getFloat("settings.soundVolume",0.5f)/2.0f;
			}
		}
	}
    
    
    public void updateSelected()
	{
		arrowSprite.setPosition(1000, 400 - 80 * selectedNumber);
		
		for(int i=0;i<gameButtons.size();i++)
		{
			if(i != selectedNumber) gameButtons.get(i).isActivated = false;
			else gameButtons.get(i).isActivated = true;
			gameButtons.get(i).update();
		}
	}
    
    
    
    public void playerDeadHandling()
    {
    	 
    	deadNumber++;
    	prefsGame.putInteger("game.deadNumber", deadNumber);
    	prefsGame.flush();
    	
    	player.isDead = true;
		ShortSounds.add(0, new ShortSound(soundPlayerDead,soundVolume));
		Explosions.add(0, new Explosion(effectTexture, player.x, player.y, 2));
		
		Random generator = new Random();
		float tmpX = -1 * generator.nextInt(2) * generator.nextFloat() * 16;
		float tmpY = -1 * generator.nextInt(2) * generator.nextFloat() * 16;
		for(int j =0;j<4;j++) mobParticles.add(0, new mobParticle(playerTexture, player.x + 24 + tmpX, player.y + 24 + tmpY, 1, j));
    	
    }
    
    public void clearMapFromObject()
    {
    	for(int i=0;i< Mobs.size();i=i) Mobs.remove(i);
		for(int i=0;i< StationarySaws.size();i=i) StationarySaws.remove(i);
		for(int i=0;i< Explosions.size();i=i) Explosions.remove(i);
		for(int i=0;i<TNTs.size();i=i) TNTs.remove(i);
		for(int i=0;i<Kolce.size();i=i) Kolce.remove(i);
		for(int i=0;i<Doors.size();i=i) Doors.remove(i);
		for(int i=0;i<BlockButtons.size();i=i) BlockButtons.remove(i);
		for(int i = 0; i< MobWeapons.size();i=i) MobWeapons.remove(i);
		for(int i = 0; i< Missiles.size();i=i) Missiles.remove(i);
		for(int i = 0; i< ShootWalls.size();i=i) ShootWalls.remove(i);
		for(int i = 0; i< breakableBlocks.size();i=i) breakableBlocks.remove(i);
		for(int i = 0; i< disappearingBlocks.size();i=i) disappearingBlocks.remove(i);
		for(int i = 0; i< pulsingBlocks.size();i=i) pulsingBlocks.remove(i);
		for(int i = 0; i< greenBlocks.size();i=i) greenBlocks.remove(i);
		for(int i = 0; i< bigMachines.size();i=i) bigMachines.remove(i);
		for(int i=0;i<Clouds.size();i=i) Clouds.remove(i);
		for(int i=0;i<missileParticles.size();i=i) missileParticles.remove(i);
		for(int i=0;i<blockParticles.size();i=i) blockParticles.remove(i);
		for(int i=0;i<mobParticles.size();i=i) mobParticles.remove(i);
		for(int i=0;i<BossEye.size();i=i) BossEye.remove(i);
		for(int i=0;i<BossTower.size();i=i) BossTower.remove(i);
		for(int i=0;i<BossRocket.size();i=i) BossRocket.remove(i);
		for(int i=0;i<posters.size();i=i) posters.remove(i);

		
		
		BlockButtonsActivatedAll = false;
		MobsNumber = 0;
		BossNumber = 0;
		bossGoldButton = 0;
		towerID = 0;
    }
    
	
	
	public void dispose()
	{
		
		clearMapFromObject();
		
		for(int i=0;i<musicEffects.size();i=i)
		{
			musicEffects.get(i).dispose();
			musicEffects.remove(i);
		}
		for(int i=0;i<ShortSounds.size();i=i)
		{
			ShortSounds.get(i).dispose();
			ShortSounds.remove(i);
		}
		for(int i=0;i<Sounds.size();i=i)
		{
			Sounds.get(i).dispose();
			Sounds.remove(i);
		}
	
	//	shortSoundsHandling();
        
     /*   soundDoorRedOpen.stop();
        soundDoorRedOpen.dispose();
		
		musicBoss.stop();
		musicGame1.stop();
		musicGame2.stop();
		musicGame3.stop();
		musicGame4.stop();
		musicGame5.stop();
		musicGame6.stop();
		musicGame7.stop();
		musicIntro.stop();
		musicSecret.stop();
		
		soundExplosion1.stop(); 
		soundExplosion2.stop();
		soundExplosion3.stop();
		soundExplosion4.stop();
		soundExplosion5.stop();
		soundHit.stop();
		soundJump1.stop();
		soundJump2.stop();
		soundJump3.stop();
		soundPlayerShoot.stop();
		soundHitbox2.stop();
		soundCheckPoint.stop();
		soundPlayerDead.stop();
		soundDoorBlueOpen.stop();
		soundBlockButtonPresed.stop();
		soundMobShoot1.stop(); soundMobShoot2.stop(); soundMobShoot3.stop(); soundMobShoot4.stop(); soundMobShoot5.stop(); soundMobShoot6.stop(); soundMobShoot7.stop(); soundMobShoot8.stop();
		soundBossDead1.stop(); soundBossDead2.stop(); soundBossDead3.stop(); soundBossDead4.stop(); soundBossDead5.stop();
	    soundFlower.stop();
	    soundShake1.stop(); soundShake2.stop();
	    soundBossTowerExplode.stop(); soundBossTowerShoot.stop();
	    
	    
	    musicBoss.dispose();
		musicGame1.dispose();
		musicGame2.dispose();
		musicGame3.dispose();
		musicGame4.dispose();
		musicGame5.dispose();
		musicGame6.dispose();
		musicGame7.dispose();
		musicIntro.dispose();
		musicSecret.dispose();
		
		
		soundExplosion1.dispose(); 
		soundExplosion2.dispose();
		soundExplosion3.dispose();
		soundExplosion4.dispose();
		soundExplosion5.dispose();
		soundHit.dispose();
		soundJump1.dispose();
		soundJump2.dispose();
		soundJump3.dispose();
		soundPlayerShoot.dispose();
		soundHitbox2.dispose();
		soundCheckPoint.dispose();
		soundPlayerDead.dispose();
		soundDoorBlueOpen.dispose();
		soundBlockButtonPresed.dispose();
		soundMobShoot1.dispose(); soundMobShoot2.dispose(); soundMobShoot3.dispose(); soundMobShoot4.dispose(); soundMobShoot5.dispose(); soundMobShoot6.dispose(); soundMobShoot7.dispose(); soundMobShoot8.dispose();
		soundBossDead1.dispose(); soundBossDead2.dispose(); soundBossDead3.dispose(); soundBossDead4.dispose(); soundBossDead5.dispose();
	    soundFlower.dispose();
	    soundShake1.dispose(); soundShake2.dispose();
	    soundBossTowerExplode.dispose(); soundBossTowerShoot.dispose();*/
		
		
	}

	

}
