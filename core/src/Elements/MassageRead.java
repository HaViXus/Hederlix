package Elements;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class MassageRead 
{

	public String text[][] =
	{
			{

				"LETS BE CLEAR HERE: TWO TYPES OF THIS DOOR CAN BE IN",
				"ONE ROOM AT THE SAME TIME... NOTHING CHANGES AT ALL.",
				"ROBOTS STILL WANT TO KILL YOU, SO TEACH THEM WHO'S",
				"THEIR BOSS!"
				
				
				
			},
				
			{

				"HI!",
				"IT'S THE NEWEST FACTORY WHICH MADE",
				"BY ............. AND HIS ROBOTS.",
				"I'LL GIVE YOU SOME TIPS",
				"THAT CAN HELP YOU!",
				"WE BOTH WANT YOU TO REACH AS FAR AS YOU CAN :)"
			},
			
			{

				"SPIKES... ARE DANGEROUS AS THE REST OF", 
				"SURROUNDINGS HERE...",
				"",
				"AND ANOTHER TIP: THE POT THAT",
				"STANDS NEXT TO YOU IS A CHECKPOINT.",
				"IT'LL BE HELPFUL... LATER..."
			},
			
			{

				"'IT'S NOT A BUG, IT'S A FEATURE'!"
			},

			{

				"NOW, IF THAT HOLE NEXT TO YOU IS LOCKED... IT'S THE END OF YOUR HISTORY.",
				"ELSE, YOU CAN KEEP FINDING POTS TO BATTLE 'HIM'. IF YOU ARE HERE,",
				"KNOW THAT 'YOU'RE SMART, VERY SMART, YOU'RE A GENIUS,",
				"I APPPRECIATE YOU, YOU'RE LOYAL. BUT SERIOUSLY, I MUST SAY VERY, ",
				"VERY THANKS TO YOU FOR PLAYING MY GAME. I'M LEARING TO CREATE GAMES AND",
				"THIS WAS GOOD EXPERIENCE FOR ME AND NEXT GAME WILL BE BETTER.",
				"ONCE MORE: THANK FOR PLAYING! :)"
				
			
				
			},

			{

				"IF YOU ARE HERE, YOU PROBABLY KNOW",
				"HOW TO JUMP AND MOVE, NICE!",
				"SO... TUTORIAL IS THE LAST THING YOU NEED",
				"I DO NOT KNOW IF YOU NOTICED THAT, BUT",
				"THE FASTER YOU RUN, THE HIGHER YOU JUMP!",
				"IT MAY BE USEFUL."
				
				
			},

			{

				"SPIKES IN THE FACTORY CAN BY WEIRD BUT IT", 
				"ISN'T THE LAST WEIRD THING YOU' LL SEE",
				"THERE WILL BE THINGS EVEN WEIRDER."
				
			},

			{

				"I DIDN'T KNOW IF YOU NOTICE THAT, BUT YOUR WAY TO GET OUT OF THIS ROOM",
				"IS BLOCKED BY THESE RED DOORS. IF YOU'D LIKE TO DO THIS DIPLOMATIC WAY... GAME OVER...",
				"IF NOT... KILL THEM ALL!!!"
			},
			{

				"IN THIS YELLOW POT YOU HAVE DEAD BUSH. IF",
				"YOU FIND THEM ALL AND BRING THEM BACK TO LIFE, ",
				"PERHAPS YOU'LL INTEREST 'HIM' TO COME AND FIGHT WITH YOU.",
				"IF YOU HOLD TAB, YOU CAN SEE HOW MUCH POTS YOU HAVE GATHERED"
				
				
			},
			
			{

				"THIS IS BAT: 'DON'T TRY TO CATCH HIM' !",
				"WATCH OUT FOR HIS BLUE BROTHER, HE IS STRONGER,",
				"BECAUSE HE EVOLVED 'DON'T TRY TO CATCH HIM EITHER'!"
			},

			{
				

				"I HOPE YOU KNOW THAT, BUT YOU", 
				"CAN'T TOUCH THIS SAW."

			},

			{

				"I KNOW YOU DONT BELIVE ME BUT THIS BLUE 'THING'",
				"WITH WHITE STRIPES IS BOTH THE DOORS AND THE KEY",
				"TO UNLOCK THEM YOU NEED TO HIT THESE BLUE BUTTONS...",
				"I THINK I NEED BETTER GRAPHICS..."
			},

			{

				"WHEN SOMETHING SHOOTS: IT IS FUN... AND WHEN",
				"SOMETHING SHOOTS AND THE BULLET EXPLODES EQUALS", 
				"MORE FUN, ISN'T IT?"
			},

			{

				"THIS BIG MACHINE SHOOTS CANNONS AND ROCKETS, BUT",
				"LUCKILY FOR YOU, SMALL ROBOTS BUILD BIG ROBOTS,",
				"DON'T TRUST THEM, AND IMPLEMENT THEM AUTODESTRUCTION",
				"BUTTON... AND ANOTHER THING... YOU HAVE BAT NEST ",
				"UP TO YOU!"
			},
			{

				"NEXT ELEMENT TYPICAL TO PLATFORMER GAME IS THAT THERE IS NO",
				"REASON WHY SOMEONE WANTS IN HIS FACTORY BLOCKS, ",
				"WHICH DISAPPEAR WHEN YOU TOUCH THEM... NEVER MIND...",
				"LOOK WHICH COLOUR CAN HOLD YOU FOR LONGER TIME.",
				"THIS CAN BE VERY HELPFUL IN FUTURE GAME!"
			},
			
			{

				"THIS RED BLOCK IS SOMETHING NEW... HMMMM...",
				"WITH FAST FIRERATE AND READY TO KILL YOU... NOTHING NEW."
			},

			{

				"IT'S TIME TO TELL YOU A SECRET OF SUPER ADVANCED",
				"MECHANICS OF FIGHT IN THIS GAME: ",
				"SPACE: YOU HIT WITH CLIMBER 'IT GETS BIGGER",
				"WHEN YOU HIT SPACE :) ' YOU CAN HIT TWO TIMES IN ROW...  ",
				"WELL, YOU BETTER LEARN THIS AS FAST IS POSSIBLE ",
				"BECAUSE YOU'LL NEED THAT LATER.",
				"",
				"JUMPS LIKE THIS WILL BE MORE OFTEN NECESSERY IN THE GAME,",
				"IF YOU NEED IT, TRAIN HERE :)"
				

				
			},

			{

				"NOT EVERYTHING CAN BE SOLVED BY FORCE...",
				"IT MEANS... YOU DON'T SOLVE...",
				"THIS THING CAN USE FORCE AGAINST YOU"
			},

			{

				"THIS TALL ROBOT IS A TYPE OF A SECURITY WHO PATROLS AN AREA OF",  
				"FACTORY SINCE IT HAS BEEN BUILT. HE IS VERY TOUGH GUY BUT HE HAS A",
				"WEAK HEAD (DON'T DRINK KIDS)"
			},

			{

				"TAKE YOUR TIME, LATER THERE'LL BE NO TIME TO REST."
			},
			
			{

				"TNT: WE ALL KNOW WHAT THIS IS, OK... BE GENTLE WITH IT."

			},

			{

				"I KNOW THAT TWO LINES 'SNIFF' DON'T LOOK LIKE SHIELD, BUT",
				"TRUST ME: THIS ROBOT HOLDS A SHIELD!",
				"IF THIS IS NOT NECESSARY, DON'T FIGHT WITH THEM BUT IF THERE IS NO",
				"ESCAPE AND YOU MUST FIGHT STAB THESE MOTHERF..... IN THEIR BACK."
				
			},

			{

				"THIS PLACE IS SUPERDUPER SECRET ROOM ABANDONED", 
				"WHICH NO ONE SAW SINCE THIS FACTORY WAS BUILD.",
				"YOU CAN FIND HERE PROPAGANDA POSTERS",
				"FROM THAT TIME. I TELL YOU SOMETHING:",
				"THERE ARE 5 ROOMS LIKE THIS AND IN",
				"EVERY ROOM THERE IS A FLOWER POT.",
                "YOU NEED TO TAKE THEM WITH YOU IN ORDER TO FIGHT 'HIM'"
			},
			
			{

				"MOVE, MOVE, MOVE!"
			},

			{

				"YOU MIGHT BE WONDERING, WHO WAS DESIGNING THIS MAP",
				"SPIKES ON WALLS, FLOATING BLOCKS... OW... ", 
				"AND THERE ARE ROCKET LAUNCHERS UP TO YOU!"
			},

			{

				"THESE ORANGE DEVICES DIVERSIFIED",
				"YOUR FIGHT AGAINST OBSTACLES."
				
			},

			{

				"HOLD YOURSELF... IT'S NOT WORTH IT"
			},

			{

				"I DON'T KNOW WHY THIS SIGN IS PLACED SO FAR...",
				"DOESN'T MATTER... AS YOU HAVE ALREADY SEEN",
				"THAT SHOOTS EXPLOSIVE PROJECTILES."
				
			},
			{

				"ON YOU RIGHT THERE IS A CHECKPOINT. IT MIGHT BE USEFULL!"

			},
			
			{

				"YOU CAN'T DO THIS QUIETLY... AT LEAST, DO IT QUICK!"
			},

			{

				"THAT YELLOW GUY IS ABLE TO DESTROY YOU.... ",
				"IN FACT HIS ROCKETS, NOT HIM, BUT YOU CAN DESTROY", 
				"THAT ROCKET. BE CAREFUL!"
				
			},

			{

				"DISAPPEARING BLOCKS, BEACUASE THIS IS VERY", 
				"ORIGINAL AND NECESSARY IN THE FACTORY"
			
			},

			{

				"CONGRATULATIONS! IT WAS REALY HARD TRACK! ",
				"I RECOMMEND INURE IN FUTURE IT BE",
				"EVEN HARDER, BUT YOU CAN DO THIS!"
			},

			{

				"DON'T LET YOU TAKE "
			},
			{

				"NOW YOU CAN BE CAREFUL... AND FAST!"
			},
			
			{

				"THAT ORANGE THING IS THESE ROBOTS ART OF ENGINEERY. THIS",
				"WEAPON IS MOST ACCURATE IN THE WORLD! HITS EVERYTIME",
				"(WHEN YOU STAND)... SIMPLE CONCLUSION: DON'T STAND TOO LONG!"
			},

			{

				"I DON'T KNOW WHAT'S IN THERE, I KNOW MUCH AS YOU, BUT",
				"EXCLAMATION MARK DOES NOT MEANS ANYTHING GOOD.",
				"BE CAREFUL!"
			},

			{

				"BATS GET UPDATED!",
				"THEY ARE NOW ABLE TO SHOOT, BUT THEY",
				"AREN'T AS STRONG AS BLUE BATS!"
			},

			{

				"DON'T TOUCH ANYTHING IN HERE!"
			},

			{

				"YOU'RE DOING GREAT!",
				"YOU GOT REALLY FAR. WE GOT YELLOW HUGGERS AND",
				"HIS DARKER BROTHER IN HERE, WHO LIKES TO SHOOT HIS LEGS",
				"AND HANDS (WTF?)"
			},
			{

				"ANOTHER ABSURD OF THIS GAME: YOU CAN BREAK", 
				"THE STEEL AND IRON BLOCKS, BUT NOT BRICK BLOCKS.",
				"SUSPICIOUS..."

			},
				
			{
			
				"THAT ROBOTS LIKES TO BLOW THE SHIT UP.",
				"THEY ARE HAPPY THAT YOU CAME TO PLAY",
				"WITH THEM."
				
			},
			
			{

				"SEE THAT BLOCK. HE'S A TRAITOR!",
				"HE WON'T HELP YOU. HE SERVES TO",
				"ROBOTS! HIS BULLET WENT TO YOU",
				"I DON'T LIKE HIM :("
				
			},
			
			{

				"I DON'T KNOW WHAT IS THIS, BUT HE WANTS",
				"TO HUG YOU. DON'T LET HIM DO IT!"
			},

			{

				"IF YOU HAVE TO, BREAK THE GLASS"
			},

			{

				"     ???     "
			},

			{

				"THAT'S THE LAST SECRET ROOM. IF YOU ARE HERE,",
				"YOU DISCOVERED FIRST PART OF AN ANSWER..."
			},

			{

				"ON YOUR LEFT THERE IS A CHECKPOINT. GO THERE AND THEN TRY TO  ",
				"CATCH THE FLOWER. DON'T WASTE YOUR TIME ON WALLS AGAIN."
			},
			{

				"YOU MUST DESTROY THIS FLOOR, BUT DON'T",
				"BLOW UP YOURSELF."
			},
			
			{

				"QUIETLY, PRECISELY, YOU HAVE",
				"JUST ONE CHANCE!"
			},

			{

				"YOU FOUND ALL THE POSTS! YOU UNLOCKED THE SUPER SECRET BOSS",
				"FIGHT. CONGRATULATIONS! I THINK... IT'S THE LAST TIME I'M",
				"GIVING YOU ADVICE. WATCH OUT FOR HIS BIG GUNS. AND WATCH OUT",
				"FOR HIS RED WALLS. THEY ARE VERY STRONG. YOU MUST HIT THIS WALL",
				"FIFTY TIMES... IT'S NOT MY IDEA, I'M ONLY A SING... "
			},

			{
				"52"
			},
			
			{
				"DO YOU REALY WANT START NEW GAME? YOU'LL LOST",
			    "YOUR LAST GAME!",
				"",
				"            SPACE: YES     Z: NO"
			}

			
	};
	
	public int x,y;
	public int ID;
	public Texture texture;
	public TextureRegion region;
	public Rectangle hitBox;
	public ArrayList<Sprite> signs;
	public ArrayList<Sprite> background;
	
	public boolean isActivated;
	public float textureTimer;
	
	public MassageRead(Texture texture)
	{
		
        x=640;
        y = 552;
        
		this.texture = texture;	
		region = new TextureRegion(texture);
		region.setRegion(80,128,16,16);
		background = new ArrayList<Sprite>();
		hitBox = new Rectangle();
		signs = new ArrayList<Sprite>();
		isActivated = false;
		
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
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
		
		for(int i=0;i<text[ID].length;i++) if(text[ID][i].length() > tmpWidth) tmpWidth = text[ID][i].length(); //max line length
		
		for(int i=0;i<text[ID].length;i++)
		{
			
			
			
			for(int j=0;j<text[ID][i].length();j++)
			{	
				char ch = text[ID][i].charAt(j);
				signs.add(0, new Sprite(texture));
				for(ys=0;ys<chars.length;ys++)
				{
					
					xs = chars[ys].indexOf(ch);
					if(xs>=0){
						
						region.setRegion(0 + xs*16, 24 + ys*16,6,8);
						signs.get(0).setRegion(region);
						signs.get(0).setBounds(x + j*16 - 8*tmpWidth, y - i*16, 16, 16);
						
					}
				}
			}
			
		}
		
		if(ID != 52) setInfo(tmpWidth, ys);
		
		int tmpMaxY = text[ID].length + 3;
		
		for(int i=0;i <= tmpMaxY;i++)
		{
			for(int j = 0; j <= tmpWidth + 1; j++)
			{
				
				int change = 0;
				if(i==0) change = 0;
				else if(i == tmpMaxY) change = 2;
				else change = 1;
				
					if(j==0) region.setRegion(0, 64 + 8*change, 8, 8);
                    else if(j == tmpWidth + 1) region.setRegion(16, 64 + 8*change, 8, 8);
                    else region.setRegion(8, 64 + 8*change, 8, 8);
				
				
				background.add(0, new Sprite(region));
				background.get(0).setBounds(x - 16 + j*16 - 8*tmpWidth ,y + 16 - 16* i, 16, 16);
			}
		}
		
			
	}
	
	private void setInfo(int width, int ys)
	{
		
		String info = "PRESS Z";
		for(int i=0;i<info.length();i++)
		{
			char ch = info.charAt(i);
			signs.add(0, new Sprite(texture));
			for(int ysInfo=0;ysInfo<chars.length;ysInfo++)
			{
				
				int xs = chars[ysInfo].indexOf(ch);
				if(xs>=0){
					
					region.setRegion(0 + xs*16, 26 + ysInfo*16,6,7);
					signs.get(0).setRegion(region);
					signs.get(0).setBounds(x +8 * width + i*16 - 116, y - (text[ID].length)*16 - 24, 16, 16);
					
				}
				
			}
			
		}
		
		
	}
	
	public void claerText()
	{
		for(int i=0;i<background.size();i=i) background.remove(i);
		for(int i=0;i<signs.size();i=i) signs.remove(i);
	}
	
	public void drawMassage(SpriteBatch miscBatch)
	{
		if(isActivated == true)
		{
			
			for(int i=0;i<background.size();i++) background.get(i).draw(miscBatch);
			for(int i=0;i<signs.size();i++) signs.get(i).draw(miscBatch);		
			
		}
		
		
	}
	
}
