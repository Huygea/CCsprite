package levels;

/**
 * Created by fractal on 17.03.2017.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ccsprite.game.ClickClack;
import com.ccsprite.game.Controller;
import com.ccsprite.game.EnumClass;
import com.ccsprite.game.LevelSelection;
import com.ccsprite.game.LevelVariables;
import com.ccsprite.game.PauseStage;
import com.ccsprite.game.Randomizer;
import com.ccsprite.game.VariableCalls;
import com.ccsprite.game.allowedList;
import com.ccsprite.game.forbiddenList;

import java.util.ArrayList;
import java.util.Random;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.utils.Align.center;
import static com.ccsprite.game.EnumClass.state;
import static com.ccsprite.game.MyActorKucuk.nextGear;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;


public class Level1 extends ApplicationAdapter implements Screen {








   //LEVEL NUMBER
    int levelNumber = 1;

    int difficultyLevel = 2;
    private boolean crateGot = true;


    private int nextLevel = levelNumber +1;




    int goldAmount,bombAmount,oilAmount,bulletAmount;
    float WINTIMER = 0.5f;
    private int world_dotx_count;
    private int world_doty_count;
    //CREATURE CONTROL

    private float breakBlockTimer = 4;
    private Vector2[][] creaturePosition;
    Sprite levelPassSprite;
    private boolean goldBool = true;
    float elapsedTime = 0;
    private boolean buttonSet = true;

    private boolean crateBoolean;
    //CREATURE 1 VARIABLES
    private  float jumpDelay = 3;
    private Image creatureSprite;
    private  boolean jump = true;
    private Sprite hingeSprite;
    private Sprite [][] hingeArray;
    private boolean jumpDelayBoolean = true;
    private boolean explosionBool = false;
    private Sprite chestSprite;
    private Rectangle rec1,rec2;
    Label threetwoone;


    TextureRegion dark;
    TextureRegion star;
    TextureRegion button;
    TextureRegion timer;
    TextureRegion whiteBox;
    TextureRegion one;
    TextureRegion crossHair;
    TextureRegion crate;
    TextureRegion openChest;
    TextureRegion explosion;
    Texture youLose;
    TextureRegion bomb;
    Texture hingeTex;
    Texture youwinT;
    TextureRegion blowtorcht;

    private Texture kucuk, buyuk, orta, kucuk1, orta1, buyuk1, backGroundt;

    TextureRegion uiSkin;

    Texture explosions;
    Texture bulletHitTex;

    Skin skin;
    Skin smallSkin;

    TextureRegion[] bulletFrames;
    Animation<TextureRegion> bulletHit;

    TextureRegion[] animationFrames;
    Animation<TextureRegion> animation;
    private TextureAtlas texAtlas;


    private boolean crateHad=false;
    private boolean bullethit = false;
    private float crateDecay;
    private Vector2 [][] brokenHingeContainer;
    private boolean creatureSpawnBoolean = false;

    private float jumpFreq = 1;
    private int jumpTime = 8;
    private boolean isItJumping = true;
    private boolean isItInTheAir = true;
    private float spawnTimer = 10;
    private PauseStage pS;
    private float commenceCounter =400;

    //CREATURE 2 VARIABLES

    private  float jumpDelay2 = 4;
    private float checkTimer = 0.5f;
    private float checkTimer2= 0.2f;

    private float crateTimer;
    private Image creatureSprite2;
    private  boolean jump2 = true;
    private boolean jumpDelayBoolean2 = true;
    private Sprite [][] shadowSprite;


    private boolean creatureSpawnBoolean2 = false;

    private float jumpFreq2 = 1;
    private int jumpTime2 = 9;
    private boolean isItJumping2 = true;
    private boolean isItInTheAir2 = true;
    private float spawnTimer2 = 12;

    private float a2;
    private float b2;
    private float breakBlockTimer2= 6;

    private Vector2 [][] creaturePosition2;
    private int crX2 ;
    private int crY2 ;

    private boolean thumbDown = false;









    public static Vector2[]allowedListChest;
    final ClickClack game;

    private boolean winCondition  = false;
    private OrthographicCamera cam;
    private World world;
    public static Stage stage;
    public Viewport viewport;

    private float fadeIn = 200;
    private Random random;
    private static int rand;
    private static Sprite badsprite;
    static Vector2[][] pointCoordinates;
    public Array[] actorList;

    private final float WORLD_DOT_DISTANCE = 7.5f;
    private Controller controller;
    static int moveX = 0;
    static int moveY = 0;
    private float inputTime = 0;
    private Vector3 target;
    private float ispeed = 0;
    private Vector3 cameraPos;

    private Sprite sprite;
    private Sprite sprite2;
    private Vector3 [][][] spriteArray;
    private  Vector2 [][] isItRotating;
    private  Sprite [][] spriteContainer;
    private forbiddenList forbid;
    private Vector2 camMovementVector;
    private Vector2 newTouch;

    private Vector3 [][][] stuckCheckList;
    private boolean stuckCheck = false;
    private Vector3 [][][] stuckArray;
    private  int chosenState = 1;


    private Sprite youwin;


    private Sprite backGround;
    private float a;
    private float b;



    public ArrayList<Vector3> goalStarter;








    public Texture creatureTexture1, creatureTexture2;


    static int starterX =0;
    static int starterY =0;

    int starterGearType = 1;


    private boolean [][] isThisRolling;

    Sprite blowtorch;

    allowedList aList;

    Vector2 lastTouchedPos;
    public boolean isLevelPassed;


    Randomizer randomizer;
    private int crX;
    private int crY;
    Preferences prefs;

    InputMultiplexer im;
    LevelVariables lvlVar;

    public Level1(final ClickClack game) {
        this.game = game;

        init(game);

    }



    ArrayList <Integer> lvlArray = new ArrayList();

    public void init(final ClickClack game){
        VariableCalls.confirmBoolean = false;

        lvlVar = new LevelVariables();

        lvlArray = lvlVar.levelVarible(levelNumber);



        VariableCalls.gameStart = true;
        fadeIn = 300;
        commenceCounter = 400;


        //TEXTURES


        goalStarter = new ArrayList<>();
        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");
        kucuk = new Texture("small.png");
        orta = new Texture("medium.png");
        buyuk = new Texture("large.png");
       // bomb = texAtlas.findRegion("bomb");
        bomb = new Sprite(new Texture("bomb.png"));
        kucuk1 = new Texture("smallpin.png");
        orta1 = new Texture("mediumpin.png");
        buyuk1 = new Texture("largepin.png");
        backGroundt = new Texture("bg.png");
        hingeTex = new Texture("hinge.png");
        youwinT = new Texture("youwin.png");
        blowtorcht = new Sprite(new Texture("oil.png"));
        creatureTexture1 = new Texture("creature1.png");
        creatureTexture2 = new Texture("creature2.png");
        youLose = new Texture("youlose.png");
        explosion = texAtlas.findRegion("explosion");
        one = texAtlas.findRegion("one");
        whiteBox = texAtlas.findRegion("timerWhiteBox");
        timer = texAtlas.findRegion("timer");
        button = texAtlas.findRegion("button");
        dark = texAtlas.findRegion("dark");


        star = texAtlas.findRegion("star");

        openChest = texAtlas.findRegion("openCrate");




        uiSkin = texAtlas.findRegion("uiskin");






        crate = texAtlas.findRegion("crate");



        crossHair = new Sprite(new Texture("sniper.png"));



//SKIN AND ANIMATIONS

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.1f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.05f);
        explosions  =new Texture("explosion.png");

        bulletHitTex = new Texture("fireBullet.png");

        rec1 = new Rectangle();
        rec2 = new Rectangle();

        bulletFrames = new TextureRegion[4];
        TextureRegion [][] tempBulletFrames = TextureRegion.split(bulletHitTex,25,25);

        int indexb = 0;

        for(int j = 0; j<4; j++){

            bulletFrames[indexb++] = tempBulletFrames[0][j];
        }


        bulletHit = new Animation<TextureRegion>(1f/4f, bulletFrames);

        animationFrames = new TextureRegion[10];
        TextureRegion [][] tempFrames = TextureRegion.split(explosions,10,10);


        int index = 0;

        for(int i = 0; i<10;i++){


            animationFrames[index++] = tempFrames[0][i];
        }

        animation = new Animation<TextureRegion>(1f/10f, animationFrames);


















        prefs = Gdx.app.getPreferences("My Preferences");
        VariableCalls vd = new VariableCalls();
        EnumClass.state = EnumClass.State.RUN;
        threetwoone = new Label("", skin);

        random = new Random();


        goldAmount = prefs.getInteger("gold",100);
        bombAmount = prefs.getInteger("bomb",5);
        oilAmount = prefs.getInteger("oil",5);
        bulletAmount = prefs.getInteger("bullet",5);
        isLevelPassed = prefs.getBoolean(getClass().getName(),true);
        prefs.flush();

        //WORLD DOTS
        world_dotx_count = lvlVar.varList.get(3);
        world_doty_count = lvlVar.varList.get(4);




        //GOAL GEAR SETUP


        goalStarter = lvlVar.goalList;




        randomizer = new Randomizer();
        randomizer.setSelfReduction(difficultyLevel);
        VariableCalls.prevRand = randomizer.randomize();
        shadowSprite = new Sprite[world_dotx_count][world_doty_count];
        levelPassSprite = new Sprite(dark);
        //levelPassSprite.setSize(1,1);


        allowedListChest = new Vector2[(world_doty_count+1 )* (world_dotx_count+1) * 4];

        crateTimer = 5;
        crateDecay = 10;
        camMovementVector = new Vector2(0,0);
        lastTouchedPos = new Vector2(0,0);
        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        rand = randomizer.randomize();
        spriteArray = new Vector3[world_dotx_count][world_doty_count][1];
        isItRotating = new Vector2[world_dotx_count][world_doty_count];
        spriteContainer = new Sprite[world_dotx_count][world_doty_count];
        hingeArray = new Sprite[world_dotx_count][world_doty_count];
        brokenHingeContainer = new Vector2[world_dotx_count][world_doty_count];
        isThisRolling = new boolean[world_dotx_count][world_doty_count];




        stuckCheckList = new Vector3[world_dotx_count][world_doty_count][24];
        stuckArray = new Vector3[world_dotx_count][world_doty_count][24];

        forbid = new forbiddenList();








        if (rand == 1) {
            badsprite = new Sprite(kucuk);
            badsprite.setSize(5.5f, 5.5f);
        }
        if (rand == 2) {
            badsprite = new Sprite(orta);
            badsprite.setSize(10.8f, 10.8f);
        }
        if (rand == 3) {
            badsprite = new Sprite(buyuk);
            badsprite.setSize(16f, 16f);
        }



        controller = new Controller(game,levelNumber);


        pS = new PauseStage(game,levelNumber);


        youwin = new Sprite(youwinT);


        creatureSprite = new Image(creatureTexture1);
        creatureSprite.setSize(2.1f,1.8f/0.293f);
        creaturePosition = new Vector2[world_dotx_count][world_doty_count];

        creatureSprite2 = new Image(creatureTexture2);
        creatureSprite2.setSize(2.1f,1.8f/0.293f);
        creaturePosition2 = new Vector2[world_dotx_count][world_doty_count];

        blowtorch = new Sprite(blowtorcht);



        hingeSprite = new Sprite(hingeTex);
        hingeSprite.setSize(1f,1f);
        aList = new allowedList();

        worldGen(world_dotx_count, world_doty_count, WORLD_DOT_DISTANCE);



        boolean cbool = true;
        while(cbool) {




            crX2 = random.nextInt(world_dotx_count);
            crY2 = random.nextInt(world_doty_count);
            crX = random.nextInt(world_dotx_count);
            crY = random.nextInt(world_doty_count);

            if(brokenHingeContainer[crX][crY].x == 1000 && brokenHingeContainer[crX2][crY2].x == 1000 ){


                cbool = false;
            }

        }

        creatureSprite.setPosition(creaturePosition[crX][crY].x,creaturePosition[crX][crY].y);

        creatureSprite2.setPosition(creaturePosition2[crX2][crY2].x,creaturePosition2[crX2][crY2].y);


        cam = new OrthographicCamera(aspectRatio * WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        cam.setToOrtho(false);



        viewport = new FitViewport(WORLD_WIDTH/2 , VariableCalls.WORLD_HEIGHT/2,cam );
        stage = new Stage(viewport, game.batch);
        stage.addActor(creatureSprite);
        stage.addActor(creatureSprite2);
        chestSprite = new Sprite(new Texture("chest.png"));

        chestSprite.setPosition(1000,1000);
        controller.gearImg.setColor(Color.YELLOW);
        backGround = new Sprite(backGroundt);
        backGround.setSize(WORLD_WIDTH,VariableCalls.WORLD_HEIGHT);
        backGround.setPosition(-WORLD_WIDTH/4,-VariableCalls.WORLD_HEIGHT/4);

        a = creaturePosition[crX][crY].x;
        b = creaturePosition[crX][crY].y;

        a2 = creaturePosition2[crX2][crY2].x;
        b2 = creaturePosition2[crX2][crY2].y;

        im = new InputMultiplexer();

        im.addProcessor(controller.stage);
        im.addProcessor(stage);
        im.addProcessor(pS.stage);


        Gdx.input.setInputProcessor(im);
//CONTROLS ARE HERE

        for(int chestX = 0; chestX<world_dotx_count+1 * world_doty_count+1; chestX++){


            allowedListChest[chestX]=new Vector2(0,0);



        }


        crateBoolean = true;

        //ThumbDown and Drag Controls
        stage.addListener(new InputListener() {


            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                thumbDown = true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if(EnumClass.state == EnumClass.State.RUN && commenceCounter<1) {
                    thumbDown = false;
                    float scale = cam.viewportWidth / (float) (Gdx.graphics.getWidth());
                    newTouch = new Vector2(x, y);
                    camMovementVector = newTouch.cpy().sub(lastTouchedPos);
                    lastTouchedPos = newTouch;

                    cam.translate(camMovementVector.x * scale * prefs.getInteger("dragValue",6), camMovementVector.y * scale *prefs.getInteger("dragValue",6));


                    prefs.flush();

                }
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                lastTouchedPos.set(x, y);


                return true;
            }


        });

        if (VariableCalls.prevRand == 1) {
            nextGear = new Image(kucuk1);

            nextGear.setSize(5.5f*2, 5.5f*2);
        }
        if (VariableCalls.prevRand == 2) {
            nextGear = new Image(orta1);

            nextGear.setSize(10.8f*2, 10.8f*2);
        }
        if (VariableCalls.prevRand == 3) {
            nextGear = new Image(buyuk1);

            nextGear.setSize(16f*2, 16f*2);
        }

        nextGear.setPosition(15 - nextGear.getWidth()/2, VariableCalls.WORLD_HEIGHT-15 - nextGear.getHeight()/2);


        isItJumping = false;
        creatureSpawnBoolean = true;
        breakBlockTimer = 4;
        jumpDelayBoolean = false;

        jumpDelay = 3;
        isItInTheAir = false;


        jumpTime = 8;

        jump = true;

        isItJumping2 = false;
        isItInTheAir2 = false;
        creatureSpawnBoolean2 = true;

        jumpDelayBoolean2 = false;
        jumpDelay2 = 4;

        jumpTime2 = 8;
        jump2 = true;


        breakBlockTimer2 = 6;

        levelPassSprite.setSize(fadeIn,fadeIn);
        cam.position.set(pointCoordinates[(int)world_dotx_count/2][(int)(world_doty_count/2)],0);
        // levelPassSprite.setOrigin(levelPassSprite.getWidth()/2,levelPassSprite.getHeight()/2);
        levelPassSprite.setRotation(0);
        threetwoone.setPosition(cam.position.x - threetwoone.getWidth()/2, cam.position.y - threetwoone.getHeight()/2);

        levelPassSprite.setPosition(cam.position.x - levelPassSprite.getWidth()/2, cam.position.y - levelPassSprite.getHeight()/2);


    }



    private  void worldGen(int xDotNumber, int yDotNumber, float lengthBetween) {

        pointCoordinates = new Vector2[xDotNumber][yDotNumber];


        for (float xEx = 0; xEx < xDotNumber; xEx++) {
            for (float yEx = 0; yEx < yDotNumber; yEx++) {

                pointCoordinates[(int) xEx][(int) yEx] = new Vector2(xEx * lengthBetween, yEx * lengthBetween);
                creaturePosition[(int) xEx][(int) yEx] = new Vector2(xEx * lengthBetween, yEx * lengthBetween);
                creaturePosition2[(int) xEx][(int) yEx] = new Vector2(xEx * lengthBetween, yEx * lengthBetween);
                hingeArray[(int) xEx][(int) yEx] = hingeSprite;
                spriteArray[(int) xEx][(int) yEx][0] = new Vector3(0, 0, 0);
                isItRotating[(int) xEx][(int) yEx] = new Vector2(0, 0.5f);
                brokenHingeContainer[(int) xEx][(int) yEx] = new Vector2(1000, 1000);
                isThisRolling[(int) xEx][(int) yEx] = true;
                for (int sx = 0; sx < 24; sx++) {
                    stuckCheckList[(int) xEx][(int) yEx][sx] = new Vector3(0, 0, 0);
                    stuckArray[(int) xEx][(int) yEx][sx] = new Vector3(0, 0, 0);
                }
                for (int gType = 0; gType < 4; gType++) {
                    forbid.forbidList((int) xEx, (int) yEx, gType, (int) xEx, (int) yEx, 0);
                    aList.allowedList((int) xEx, (int) yEx, gType, (int) xEx, (int) yEx, 0);


                }


            }
        }

        //GENERATE THE WORLD

//STARTING GEAR

        for(int i = 0 ; i<lvlVar.brokenList.size(); i++)
        {
            brokenHingeContainer[(int)lvlVar.brokenList.get(i).x][(int)lvlVar.brokenList.get(i).y] = new Vector2(0,0);
        }

        starterGearType = lvlVar.varList.get(2);
        starterX = lvlVar.varList.get(0);
        starterY = lvlVar.varList.get(1);

        if (starterGearType == 1) {
            sprite = new Sprite(kucuk1);
            sprite.setSize(5.5f, 5.5f);
        }
        if (starterGearType == 2) {
            sprite = new Sprite(orta1);
            sprite.setSize(10.8f, 10.8f);
        }
        if (starterGearType == 3) {
            sprite = new Sprite(buyuk1);
            sprite.setSize(16f, 16f);
        }

        sprite.setPosition(pointCoordinates[starterX][starterY].x - sprite.getWidth() / 2, pointCoordinates[starterX][starterY].y - sprite.getHeight() / 2);


        spriteArray[starterX][starterY][0] = new Vector3(starterX, starterY, starterGearType);
        isItRotating[starterX][starterY] = new Vector2(1, 0.5f);
        spriteContainer[starterX][starterY] = sprite;
        if (starterGearType == 1) {
            forbid.forbidList(starterX, starterY, 1, starterX, starterY, 1);
            forbid.forbidList(starterX, starterY, 2, starterX, starterY, 2);
            forbid.forbidList(starterX, starterY, 3, starterX, starterY, 3);

            if (starterX + 1 < world_dotx_count)
                forbid.forbidList(starterX + 1, starterY, 3, starterX + 1, starterY, 3);
            if (starterY + 1 < world_doty_count)
                forbid.forbidList(starterX, starterY + 1, 3, starterX, starterY + 1, 3);
            if (starterX - 1 >= 0)
                forbid.forbidList(starterX - 1, starterY, 3, starterX - 1, starterY, 3);
            if (starterY - 1 >= 0)
                forbid.forbidList(starterX, starterY - 1, 3, starterX, starterY - 1, 3);


        }
        if (starterGearType == 2) {
            forbid.forbidList(starterX, starterY, 1, starterX, starterY, 1);
            forbid.forbidList(starterX, starterY, 2, starterX, starterY, 2);
            forbid.forbidList(starterX, starterY, 3, starterX, starterY, 3);

            if (starterX + 1 < world_dotx_count)
                forbid.forbidList(starterX + 1, starterY, 2, starterX + 1, starterY, 2);
            if (starterY + 1 < world_doty_count)
                forbid.forbidList(starterX, starterY + 1, 2, starterX, starterY + 1, 2);
            if (starterX - 1 >= 0)
                forbid.forbidList(starterX - 1, starterY, 2, starterX - 1, starterY, 2);
            if (starterY - 1 >= 0)
                forbid.forbidList(starterX, starterY - 1, 2, starterX, starterY - 1, 2);

            if (starterX + 1 < world_dotx_count)
                forbid.forbidList(starterX + 1, starterY, 3, starterX + 1, starterY, 3);
            if (starterY + 1 < world_doty_count)
                forbid.forbidList(starterX, starterY + 1, 3, starterX, starterY + 1, 3);
            if (starterX - 1 >= 0)
                forbid.forbidList(starterX - 1, starterY, 3, starterX - 1, starterY, 3);
            if (starterY - 1 >= 0)
                forbid.forbidList(starterX, starterY - 1, 3, starterX, starterY - 1, 3);

            if (starterX + 1 < world_dotx_count && starterY + 1 < world_doty_count) {
                forbid.forbidList(starterX + 1, starterY + 1, 3, starterX + 1, starterY + 1, 3);


            }

            if (starterY + 1 < world_doty_count && starterX - 1 >= 0) {
                forbid.forbidList(starterX - 1, starterY + 1, 3, starterX - 1, starterY + 1, 3);

            }

            if (starterX - 1 >= 0 && starterY - 1 >= 0) {
                forbid.forbidList(starterX - 1, starterY - 1, 3, starterX - 1, starterY - 1, 3);

            }

            if (starterY - 1 >= 0 && starterX < world_dotx_count) {
                forbid.forbidList(starterX + 1, starterY - 1, 3, starterX + 1, starterY - 1, 3);

            }


        }
        if (starterGearType == 3) {
            //System.ot.println("Working3");
            forbid.forbidList(starterX, starterY, 1, starterX, starterY, 1);
            forbid.forbidList(starterX, starterY, 2, starterX, starterY, 2);
            forbid.forbidList(starterX, starterY, 3, starterX, starterY, 3);

            if (starterX + 1 < world_dotx_count) {
                forbid.forbidList(starterX + 1, starterY, 1, starterX + 1, starterY, 1);
                forbid.forbidList(starterX + 1, starterY, 2, starterX + 1, starterY, 2);
                forbid.forbidList(starterX + 1, starterY, 3, starterX + 1, starterY, 3);


            }

            if (starterY + 1 < world_doty_count) {
                forbid.forbidList(starterX, starterY + 1, 1, starterX, starterY + 1, 1);
                forbid.forbidList(starterX, starterY + 1, 2, starterX, starterY + 1, 2);
                forbid.forbidList(starterX, starterY + 1, 3, starterX, starterY + 1, 3);

            }

            if (starterX - 1 >= 0) {
                forbid.forbidList(starterX - 1, starterY, 1, starterX - 1, starterY, 1);
                forbid.forbidList(starterX - 1, starterY, 2, starterX - 1, starterY, 2);
                forbid.forbidList(starterX - 1, starterY, 3, starterX - 1, starterY, 3);

            }

            if (starterY - 1 >= 0) {
                forbid.forbidList(starterX, starterY - 1, 1, starterX, starterY - 1, 1);
                forbid.forbidList(starterX, starterY - 1, 2, starterX, starterY - 1, 2);
                forbid.forbidList(starterX, starterY - 1, 3, starterX, starterY - 1, 3);

            }


            //LARGE CROSSES


            if (starterX + 1 < world_dotx_count && starterY + 1 < world_doty_count) {
                forbid.forbidList(starterX + 1, starterY + 1, 2, starterX + 1, starterY + 1, 2);
                forbid.forbidList(starterX + 1, starterY + 1, 3, starterX + 1, starterY + 1, 3);


            }

            if (starterY + 1 < world_doty_count && starterX - 1 >= 0) {
                forbid.forbidList(starterX - 1, starterY + 1, 2, starterX - 1, starterY + 1, 2);
                forbid.forbidList(starterX - 1, starterY + 1, 3, starterX - 1, starterY + 1, 3);

            }

            if (starterX - 1 >= 0 && starterY - 1 >= 0) {
                forbid.forbidList(starterX - 1, starterY - 1, 2, starterX - 1, starterY - 1, 2);
                forbid.forbidList(starterX - 1, starterY - 1, 3, starterX - 1, starterY - 1, 3);

            }

            if (starterY - 1 >= 0 && starterX < world_dotx_count) {
                forbid.forbidList(starterX + 1, starterY - 1, 2, starterX + 1, starterY - 1, 2);
                forbid.forbidList(starterX + 1, starterY - 1, 3, starterX + 1, starterY - 1, 3);

            }
        }

        if (starterGearType == 1) {
            if (starterX + 1 < world_dotx_count)
                aList.allowedList(starterX + 1, starterY, 2, starterX + 1, starterY, 2);
            if (starterY + 1 < world_doty_count)
                aList.allowedList(starterX, starterY + 1, 2, starterX, starterY + 1, 2);
            if (starterX - 1 >= 0)
                aList.allowedList(starterX - 1, starterY, 2, starterX - 1, starterY, 2);

            if (starterY - 1 >= 0)
                aList.allowedList(starterX, starterY - 1, 2, starterX, starterY - 1, 2);


            if (starterX + 1 < world_dotx_count && starterY + 1 < world_doty_count)
                aList.allowedList(starterX + 1, starterY + 1, 3, starterX + 1, starterY + 1, 3);
            if (starterY + 1 < world_doty_count && starterX - 1 >= 0)
                aList.allowedList(starterX - 1, starterY + 1, 3, starterX - 1, starterY + 1, 3);
            if (starterX - 1 >= 0 && starterY - 1 >= 0)
                aList.allowedList(starterX - 1, starterY - 1, 3, starterX - 1, starterY - 1, 3);

            if (starterY - 1 >= 0 && starterX + 1 < world_dotx_count)
                aList.allowedList(starterX + 1, starterY - 1, 3, starterX + 1, starterY - 1, 3);


        }

        if (starterGearType == 2) {

            if (starterX + 1 < world_dotx_count)
                aList.allowedList(starterX + 1, starterY, 1, starterX + 1, starterY, 1);
            if (starterY + 1 < world_doty_count)
                aList.allowedList(starterX, starterY + 1, 1, starterX, starterY + 1, 1);
            if (starterX - 1 >= 0)
                aList.allowedList(starterX - 1, starterY, 1, starterX - 1, starterY, 1);

            if (starterY - 1 >= 0)
                aList.allowedList(starterX, starterY - 1, 1, starterX, starterY - 1, 1);


            if (starterX + 1 < world_dotx_count && starterY + 1 < world_doty_count)
                aList.allowedList(starterX + 1, starterY + 1, 2, starterX + 1, starterY + 1, 2);
            if (starterY + 1 < world_doty_count && starterX - 1 >= 0)
                aList.allowedList(starterX - 1, starterY + 1, 2, starterX - 1, starterY + 1, 2);
            if (starterX - 1 >= 0 && starterY - 1 >= 0)
                aList.allowedList(starterX - 1, starterY - 1, 2, starterX - 1, starterY - 1, 2);

            if (starterY - 1 >= 0 && starterX + 1 < world_dotx_count)
                aList.allowedList(starterX + 1, starterY - 1, 2, starterX + 1, starterY - 1, 2);


        }

        if (starterGearType == 3) {
            if (starterX + 1 < world_dotx_count && starterY + 1 < world_doty_count)
                aList.allowedList(starterX + 1, starterY + 1, 1, starterX + 1, starterY + 1, 1);
            if (starterY + 1 < world_doty_count && starterX - 1 >= 0)
                aList.allowedList(starterX - 1, starterY + 1, 1, starterX - 1, starterY + 1, 1);
            if (starterX - 1 >= 0 && starterY - 1 >= 0)
                aList.allowedList(starterX - 1, starterY - 1, 1, starterX - 1, starterY - 1, 1);

            if (starterY - 1 >= 0 && starterX + 1 < world_dotx_count)
                aList.allowedList(starterX + 1, starterY - 1, 1, starterX + 1, starterY - 1, 1);


            if (starterX + 2 < world_dotx_count)
                aList.allowedList(starterX + 2, starterY, 3, starterX + 2, starterY, 3);
            if (starterX - 2 >= 0)
                aList.allowedList(starterX - 2, starterY, 3, starterX - 2, starterY, 3);
            if (starterY - 2 >= 0)
                aList.allowedList(starterX, starterY - 2, 3, starterX, starterY - 2, 3);

            if (starterY + 2 < world_doty_count)
                aList.allowedList(starterX, starterY + 2, 3, starterX, starterY + 2, 3);


        }


//GOAL GEAR

        for(int k = 0; k<goalStarter.size();k++)
        {
        if (goalStarter.get(k).z == 1) {
            sprite = new Sprite(kucuk1);
            sprite.setSize(5.5f, 5.5f);
        }
        if (goalStarter.get(k).z == 2) {
            sprite = new Sprite(orta1);
            sprite.setSize(10.8f, 10.8f);
        }
        if (goalStarter.get(k).z == 3) {
            sprite = new Sprite(buyuk1);
            sprite.setSize(16f, 16f);
        }

        sprite.setPosition(pointCoordinates[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y].x - sprite.getWidth() / 2, pointCoordinates[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y].y - sprite.getHeight() / 2);


        spriteArray[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y][0] = new Vector3((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, goalStarter.get(k).z);
        isItRotating[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y] = new Vector2(0, 0.5f);
        spriteContainer[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y] = sprite;
        if (goalStarter.get(k).z == 1) {
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3);

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count)
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3);
            if ((int)goalStarter.get(k).x - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).y - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3);


        }
        if (goalStarter.get(k).z == 2) {
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3);

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count)
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2);
            if ((int)goalStarter.get(k).x - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2);
            if ((int)goalStarter.get(k).y - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2);

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count)
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3);
            if ((int)goalStarter.get(k).x - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).y - 1 >= 0)
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3);

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count && (int)goalStarter.get(k).y + 1 < world_doty_count) {
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3);


            }

            if ((int)goalStarter.get(k).y + 1 < world_doty_count && (int)goalStarter.get(k).x - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3);

            }

            if ((int)goalStarter.get(k).x - 1 >= 0 && (int)goalStarter.get(k).y - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3);

            }

            if ((int)goalStarter.get(k).y - 1 >= 0 && (int)goalStarter.get(k).x < world_dotx_count) {
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3);

            }


        }
        if (goalStarter.get(k).z == 3) {
            //System.ot.println("Working3");
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 1);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 2);
            forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y, 3);

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count) {
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 1);
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2);
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 3);


            }

            if ((int)goalStarter.get(k).y + 1 < world_doty_count) {
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 1);
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 3);

            }

            if ((int)goalStarter.get(k).x - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 1);
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2);
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 3);

            }

            if ((int)goalStarter.get(k).y - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 1);
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 3);

            }


            //LARGE CROSSES


            if ((int)goalStarter.get(k).x + 1 < world_dotx_count && (int)goalStarter.get(k).y + 1 < world_doty_count) {
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3);


            }

            if ((int)goalStarter.get(k).y + 1 < world_doty_count && (int)goalStarter.get(k).x - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3);

            }

            if ((int)goalStarter.get(k).x - 1 >= 0 && (int)goalStarter.get(k).y - 1 >= 0) {
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3);

            }

            if ((int)goalStarter.get(k).y - 1 >= 0 && (int)goalStarter.get(k).x < world_dotx_count) {
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 2);
                forbid.forbidList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3);

            }
        }

        if (goalStarter.get(k).z == 1) {
            if ((int)goalStarter.get(k).x + 1 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 2);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 2);
            if ((int)goalStarter.get(k).x - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 2);

            if ((int)goalStarter.get(k).y - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 2);


            if ((int)goalStarter.get(k).x + 1 < world_dotx_count && (int)goalStarter.get(k).y + 1 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 3);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count && (int)goalStarter.get(k).x - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 3);
            if ((int)goalStarter.get(k).x - 1 >= 0 && (int)goalStarter.get(k).y - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 3);

            if ((int)goalStarter.get(k).y - 1 >= 0 && (int)goalStarter.get(k).x + 1 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 3);


        }

        if (goalStarter.get(k).z == 2) {

            if ((int)goalStarter.get(k).x + 1 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y, 1);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 1, 1);
            if ((int)goalStarter.get(k).x - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 1, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y, 1);

            if ((int)goalStarter.get(k).y - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 1, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 1, 1);


            if ((int)goalStarter.get(k).x + 1 < world_dotx_count && (int)goalStarter.get(k).y + 1 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 2);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count && (int)goalStarter.get(k).x - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 2);
            if ((int)goalStarter.get(k).x - 1 >= 0 && (int)goalStarter.get(k).y - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 2);

            if ((int)goalStarter.get(k).y - 1 >= 0 && (int)goalStarter.get(k).x + 1 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 2, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 2);


        }

        if (goalStarter.get(k).z == 3) {
            if ((int)goalStarter.get(k).x + 1 < world_dotx_count && (int)goalStarter.get(k).y + 1 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 1, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y + 1, 1);
            if ((int)goalStarter.get(k).y + 1 < world_doty_count && (int)goalStarter.get(k).x - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 1, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y + 1, 1);
            if ((int)goalStarter.get(k).x - 1 >= 0 && (int)goalStarter.get(k).y - 1 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 1, (int)goalStarter.get(k).x - 1, (int)goalStarter.get(k).y - 1, 1);

            if ((int)goalStarter.get(k).y - 1 >= 0 && (int)goalStarter.get(k).x + 1 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 1, (int)goalStarter.get(k).x + 1, (int)goalStarter.get(k).y - 1, 1);


            if ((int)goalStarter.get(k).x + 2 < world_dotx_count)
                aList.allowedList((int)goalStarter.get(k).x + 2, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x + 2, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).x - 2 >= 0)
                aList.allowedList((int)goalStarter.get(k).x - 2, (int)goalStarter.get(k).y, 3, (int)goalStarter.get(k).x - 2, (int)goalStarter.get(k).y, 3);
            if ((int)goalStarter.get(k).y - 2 >= 0)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 2, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y - 2, 3);

            if ((int)goalStarter.get(k).y + 2 < world_doty_count)
                aList.allowedList((int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 2, 3, (int)goalStarter.get(k).x, (int)goalStarter.get(k).y + 2, 3);


        }

    }
///////////////////////////////////











    }

    @Override
    public void pause() {
        EnumClass.state = EnumClass.State.PAUSE;

    }







    @Override
    public void resume() {
        EnumClass.state = EnumClass.State.RESUME;
    }

    @Override
    public void render(float delta) {

        rec1.setSize(creatureSprite.getWidth(),creatureSprite.getHeight());
        rec2.setSize(creatureSprite2.getWidth(),creatureSprite2.getHeight());

        rec1.setPosition(creatureSprite.getX(),creatureSprite.getY());
        rec2.setPosition(creatureSprite2.getX(),creatureSprite2.getY());

        switch (state) {
            case RUN: {
                VariableCalls.screen = game.getScreen();

                Gdx.input.setInputProcessor(im);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Gdx.gl.glClearColor(0, 0, 0, 1);
                stage.act(Gdx.graphics.getDeltaTime());
                controller.stage.act(Gdx.graphics.getDeltaTime());


                if (Gdx.input.isKeyJustPressed(Input.Keys.BACK) && VariableCalls.buttonCheck) {


                    EnumClass.state = EnumClass.State.PAUSE;


                }


                if (commenceCounter < 1)
                    inputUpdate(Gdx.graphics.getDeltaTime());


                cameraUpdate(Gdx.graphics.getDeltaTime());
                game.batch.setProjectionMatrix(cam.combined);

                checkTimer2 -= delta;
                if (checkTimer2 < 0) {
                    checkTimer2 = 0.2f;
                    for (int xLoc = 0; xLoc < world_dotx_count; xLoc++) {
                        for (int yLoc = 0; yLoc < world_doty_count; yLoc++) {


                            if (spriteArray[xLoc][yLoc][0].z != 0.0) {


                                if (spriteArray[xLoc][yLoc][0].z == 1.0) {


                                    //CHECK FOR LITTLE TO LARGE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 3 && isItRotating[xLoc + 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc + 1].y * -1);


                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 3 && isItRotating[xLoc + 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc - 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 3 && isItRotating[xLoc - 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc + 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 3 && isItRotating[xLoc - 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc - 1].y * -1);

                                        }
                                    }


                                    //CHECK FOR LITTLE TO MEDIUM


                                    if (xLoc + 1 < world_dotx_count) {
                                        if (spriteArray[xLoc + 1][yLoc][0].z == 2 && isItRotating[xLoc + 1][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc].y * -1);


                                        }
                                    }
                                    if (xLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc][0].z == 2 && isItRotating[xLoc - 1][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc].y * -1);

                                        }
                                    }
                                    if (yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 1][0].z == 2 && isItRotating[xLoc][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc + 1].y * -1);

                                        }
                                    }
                                    if (yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 1][0].z == 2 && isItRotating[xLoc][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc - 1].y * -1);

                                        }
                                    }


                                }

                                if (spriteArray[xLoc][yLoc][0].z == 2) {

                                    //CHECK FOR MIDDLE TO MIDDLE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 2 && isItRotating[xLoc + 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc + 1].y * -1);


                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 2 && isItRotating[xLoc + 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc - 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 2 && isItRotating[xLoc - 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc + 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 2 && isItRotating[xLoc - 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc - 1].y * -1);

                                        }
                                    }


                                    //CHECK FOR MEDIUM TO LITTLE


                                    if (xLoc + 1 < world_dotx_count) {
                                        if (spriteArray[xLoc + 1][yLoc][0].z == 1 && isItRotating[xLoc + 1][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc].y * -1);


                                        }
                                    }
                                    if (xLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc][0].z == 1 && isItRotating[xLoc - 1][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc].y * -1);

                                        }
                                    }
                                    if (yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 1][0].z == 1 && isItRotating[xLoc][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc + 1].y * -1);

                                        }
                                    }
                                    if (yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 1][0].z == 1 && isItRotating[xLoc][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc - 1].y * -1);

                                        }
                                    }


                                }

                                if (spriteArray[xLoc][yLoc][0].z == 3) {


                                    //CHECK FOR LARGE TO LITTLE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 1 && isItRotating[xLoc + 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc + 1].y * -1);


                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 1 && isItRotating[xLoc + 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 1][yLoc - 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 1 && isItRotating[xLoc - 1][yLoc + 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc + 1].y * -1);

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 1 && isItRotating[xLoc - 1][yLoc - 1].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 1][yLoc - 1].y * -1);

                                        }
                                    }


                                    //CHECK FOR LARGE TO LARGE


                                    if (xLoc + 2 < world_dotx_count) {
                                        if (spriteArray[xLoc + 2][yLoc][0].z == 3 && isItRotating[xLoc + 2][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc + 2][yLoc].y * -1);


                                        }
                                    }
                                    if (yLoc - 2 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 2][0].z == 3 && isItRotating[xLoc][yLoc - 2].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc - 2].y * -1);

                                        }
                                    }
                                    if (xLoc - 2 >= 0) {

                                        if (spriteArray[xLoc - 2][yLoc][0].z == 3 && isItRotating[xLoc - 2][yLoc].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc - 2][yLoc].y * -1);

                                        }
                                    }
                                    if (yLoc + 2 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 2][0].z == 3 && isItRotating[xLoc][yLoc + 2].x == 1 && isItRotating[xLoc][yLoc].x == 0) {

                                            isItRotating[xLoc][yLoc] = new Vector2(1, isItRotating[xLoc][yLoc + 2].y * -1);


                                        }
                                    }


                                }
                            }
                        }
                    }
                }
                //STUCK DETECTION
                for (int xLoc = 0; xLoc < world_dotx_count; xLoc++) {
                    for (int yLoc = 0; yLoc < world_doty_count; yLoc++) {
                        if (spriteArray[xLoc][yLoc][0].z != 0.0) {

                            checkTimer -= delta;
                            if (checkTimer < 0) {
                                checkTimer = 0.5f;
                                if (spriteArray[xLoc][yLoc][0].z == 1.0) {

                                    //CHECK FOR LITTLE TO LARGE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 3 && isItRotating[xLoc + 1][yLoc + 1].x == 1) {

                                            stuckCheckList[xLoc][yLoc][0].z = isItRotating[xLoc + 1][yLoc + 1].y;
                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 3 && isItRotating[xLoc + 1][yLoc - 1].x == 1) {

                                            stuckCheckList[xLoc][yLoc][1].z = isItRotating[xLoc + 1][yLoc - 1].y;
                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 3 && isItRotating[xLoc - 1][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][2].z = isItRotating[xLoc - 1][yLoc + 1].y;

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 3 && isItRotating[xLoc - 1][yLoc - 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][3].z = isItRotating[xLoc - 1][yLoc - 1].y;


                                        }
                                    }


                                    //CHECK FOR LITTLE TO MEDIUM


                                    if (xLoc + 1 < world_dotx_count) {
                                        if (spriteArray[xLoc + 1][yLoc][0].z == 2 && isItRotating[xLoc + 1][yLoc].x == 1) {

                                            stuckCheckList[xLoc][yLoc][4].z = isItRotating[xLoc + 1][yLoc].y;


                                        }
                                    }
                                    if (xLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc][0].z == 2 && isItRotating[xLoc - 1][yLoc].x == 1) {
                                            stuckCheckList[xLoc][yLoc][5].z = isItRotating[xLoc - 1][yLoc].y;

                                        }
                                    }
                                    if (yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 1][0].z == 2 && isItRotating[xLoc][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][6].z = isItRotating[xLoc][yLoc + 1].y;

                                        }
                                    }
                                    if (yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 1][0].z == 2 && isItRotating[xLoc][yLoc - 1].x == 1) {

                                            stuckCheckList[xLoc][yLoc][7].z = isItRotating[xLoc][yLoc - 1].y;
                                        }
                                    }


                                }

                                if (spriteArray[xLoc][yLoc][0].z == 2) {

                                    //CHECK FOR MIDDLE TO MIDDLE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 2 && isItRotating[xLoc + 1][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][8].z = isItRotating[xLoc + 1][yLoc + 1].y;


                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 2 && isItRotating[xLoc + 1][yLoc - 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][9].z = isItRotating[xLoc + 1][yLoc - 1].y;


                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 2 && isItRotating[xLoc - 1][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][10].z = isItRotating[xLoc - 1][yLoc + 1].y;

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 2 && isItRotating[xLoc - 1][yLoc - 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][11].z = isItRotating[xLoc - 1][yLoc - 1].y;

                                        }
                                    }


                                    //CHECK FOR MEDIUM TO LITTLE


                                    if (xLoc + 1 < world_dotx_count) {
                                        if (spriteArray[xLoc + 1][yLoc][0].z == 1 && isItRotating[xLoc + 1][yLoc].x == 1) {
                                            stuckCheckList[xLoc][yLoc][12].z = isItRotating[xLoc + 1][yLoc].y;


                                        }
                                    }
                                    if (xLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc][0].z == 1 && isItRotating[xLoc - 1][yLoc].x == 1) {
                                            stuckCheckList[xLoc][yLoc][13].z = isItRotating[xLoc - 1][yLoc].y;

                                        }
                                    }
                                    if (yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 1][0].z == 1 && isItRotating[xLoc][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][14].z = isItRotating[xLoc][yLoc + 1].y;

                                        }
                                    }
                                    if (yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 1][0].z == 1 && isItRotating[xLoc][yLoc - 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][15].z = isItRotating[xLoc][yLoc - 1].y;

                                        }
                                    }


                                }

                                if (spriteArray[xLoc][yLoc][0].z == 3) {


                                    //CHECK FOR LARGE TO LITTLE

                                    if (xLoc + 1 < world_dotx_count && yLoc + 1 < world_doty_count) {
                                        if (spriteArray[xLoc + 1][yLoc + 1][0].z == 1 && isItRotating[xLoc + 1][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][16].z = isItRotating[xLoc + 1][yLoc + 1].y;


                                        }
                                    }
                                    if (xLoc + 1 < world_dotx_count && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc + 1][yLoc - 1][0].z == 1 && isItRotating[xLoc + 1][yLoc - 1].x == 1) {

                                            stuckCheckList[xLoc][yLoc][17].z = isItRotating[xLoc + 1][yLoc - 1].y;
                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc + 1 < world_doty_count) {

                                        if (spriteArray[xLoc - 1][yLoc + 1][0].z == 1 && isItRotating[xLoc - 1][yLoc + 1].x == 1) {
                                            stuckCheckList[xLoc][yLoc][18].z = isItRotating[xLoc - 1][yLoc + 1].y;

                                        }
                                    }
                                    if (xLoc - 1 >= 0 && yLoc - 1 >= 0) {

                                        if (spriteArray[xLoc - 1][yLoc - 1][0].z == 1 && isItRotating[xLoc - 1][yLoc - 1].x == 1) {

                                            stuckCheckList[xLoc][yLoc][19].z = isItRotating[xLoc - 1][yLoc - 1].y;
                                        }
                                    }


                                    //CHECK FOR LARGE TO LARGE


                                    if (xLoc + 2 < world_dotx_count) {
                                        if (spriteArray[xLoc + 2][yLoc][0].z == 3 && isItRotating[xLoc + 2][yLoc].x == 1) {
                                            stuckCheckList[xLoc][yLoc][20].z = isItRotating[xLoc + 2][yLoc].y;


                                        }
                                    }
                                    if (yLoc - 2 >= 0) {

                                        if (spriteArray[xLoc][yLoc - 2][0].z == 3 && isItRotating[xLoc][yLoc - 2].x == 1) {

                                            stuckCheckList[xLoc][yLoc][21].z = isItRotating[xLoc][yLoc - 2].y;
                                        }
                                    }
                                    if (xLoc - 2 >= 0) {

                                        if (spriteArray[xLoc - 2][yLoc][0].z == 3 && isItRotating[xLoc - 2][yLoc].x == 1) {
                                            stuckCheckList[xLoc][yLoc][22].z = isItRotating[xLoc - 2][yLoc].y;

                                        }
                                    }
                                    if (yLoc + 2 < world_doty_count) {

                                        if (spriteArray[xLoc][yLoc + 2][0].z == 3 && isItRotating[xLoc][yLoc + 2].x == 1) {

                                            stuckCheckList[xLoc][yLoc][23].z = isItRotating[xLoc][yLoc + 2].y;


                                        }
                                    }


                                }


                                //STUCK DETECTION


                                for (int stuckx = 0; stuckx < world_dotx_count; stuckx++) {
                                    for (int stucky = 0; stucky < world_doty_count; stucky++) {
                                        int a = 0;
                                        for (int stuckz = 0; stuckz < 24; stuckz++) {


                                            if (stuckCheckList[stuckx][stucky][stuckz].z != 0) {

                                                stuckArray[stuckx][stucky][a].z = stuckCheckList[stuckx][stucky][stuckz].z;
                                                a++;
                                            }


                                        }


                                    }
                                }

                                for (int ha = 0; ha < 24; ha++) {
                                    if (stuckArray[xLoc][yLoc][ha].z != 0)
                                        if (stuckArray[xLoc][yLoc][0].z != stuckArray[xLoc][yLoc][ha].z || !isThisRolling[xLoc][yLoc]) {


                                            stuckCheck = true;


                                        } else {


                                            stuckCheck = false;
                                        }


                                }








                            }
                            if (stuckCheck) {
                                for (int stuckx = 0; stuckx < world_dotx_count; stuckx++) {
                                    for (int stucky = 0; stucky < world_doty_count; stucky++) {

                                        isItRotating[stuckx][stucky].x = 0;


                                    }

                                }


                            }

                            if (isItRotating[xLoc][yLoc].x == 1) {


                                if (!isThisRolling[xLoc][yLoc]) {

                                    isItRotating[xLoc][yLoc].x = 0;
                                    continue;


                                }
                                spriteContainer[xLoc][yLoc].setRotation(spriteContainer[xLoc][yLoc].getRotation() + isItRotating[xLoc][yLoc].y * -1);

                     /*   if(isItRotating[xLoc][yLoc].y <0){

                            spriteContainer[xLoc][yLoc].setColor(Color.RED);}

                            else{
                            spriteContainer[xLoc][yLoc].setColor(Color.BLUE);

                            }
*/


                            }


                        }
                    }
                }


                game.batch.begin();
                if(fadeIn<200)
                {
                    backGround.draw(game.batch);


                    if (explosionBool) {


                        Vector2 explosionLoc = new Vector2(pointCoordinates[moveX][moveY].x - 5, pointCoordinates[moveX][moveY].y - 5);
                        game.batch.draw(animation.getKeyFrame(elapsedTime, true), explosionLoc.x,explosionLoc.y);
                        elapsedTime += Gdx.graphics.getDeltaTime();

                        if (animation.isAnimationFinished(elapsedTime)) {
                            explosionBool = false;
                            elapsedTime = 0;

                        }

                    }

                    if (bullethit) {


                        Vector2 bullethitLoc = new Vector2(pointCoordinates[moveX][moveY].x - 12.5f, pointCoordinates[moveX][moveY].y - 12.5f);
                        game.batch.draw(bulletHit.getKeyFrame(elapsedTime, true), bullethitLoc.x,bullethitLoc.y);
                        elapsedTime += Gdx.graphics.getDeltaTime();

                        if (animation.isAnimationFinished(elapsedTime)) {
                            bullethit = false;
                            elapsedTime = 0;

                        }

                    }
                    //   game.batch.draw(animation.getKeyFrame(elapsedTime,true),pointCoordinates[moveX][moveY].x  ,pointCoordinates[moveX][moveY].y);

                    for (int drawx = 0; drawx < world_dotx_count; drawx++) {
                        for (int drawy = 0; drawy < world_doty_count; drawy++) {

                            if (brokenHingeContainer[drawx][drawy].x != 1000) {
                                continue;
                            }

                            hingeArray[drawx][drawy].setPosition(pointCoordinates[drawx][drawy].x - hingeSprite.getWidth() / 2, pointCoordinates[drawx][drawy].y - hingeSprite.getHeight() / 2);


                            hingeArray[drawx][drawy].draw(game.batch);


                        }
                    }


                    for (int drawx = 0; drawx < world_dotx_count; drawx++) {
                        for (int drawy = 0; drawy < world_doty_count; drawy++) {


                            if (spriteContainer[drawx][drawy] != null) {


                                spriteContainer[drawx][drawy].draw(game.batch);
                                spriteContainer[drawx][drawy].setOrigin(spriteContainer[drawx][drawy].getWidth() / 2, spriteContainer[drawx][drawy].getHeight() / 2);
                                //sp.get(0).setOrigin(sp.get(draw).getWidth()/2,sp.get(draw).getHeight()/2);
                            }
                        }
                    }

                    if (isItRotating[starterX][starterY].x == 1) {
                        spriteContainer[starterX][starterY].setRotation((spriteContainer[starterX][starterY].getRotation() + isItRotating[starterX][starterY].y * -1));

                    }




                    creatureSprite2.setPosition(a2 - creatureSprite2.getWidth() / 2, b2);
                    creatureSprite.setPosition(a - creatureSprite.getWidth() / 2, b);

                    badsprite.draw(game.batch);
                    creatureMovement(Gdx.graphics.getDeltaTime());
                    creatureMovement2(Gdx.graphics.getDeltaTime());


                    if ((forbid.forbiddenList[moveX][moveY][rand].z == rand || brokenHingeContainer[moveX][moveY].x != 1000)&& chosenState==1) {
                        badsprite.setColor(0.8f, 0, 0, 1);
                    } else {
                        if (aList.allowedList[moveX][moveY][rand].z == rand && chosenState ==1) {
                            badsprite.setColor(0, 1f, 0.5f, 1);
                        } else {
                            badsprite.setColor(1, 1, 1, 1);
                        }
                    }


                    ArrayList <Boolean> winBools = new ArrayList<>();
                    if(winBools.size() != goalStarter.size())
                    for(int g = 0; g<goalStarter.size();g++){
                        winBools.add(false);
                    }

                    for(int k = 0; k<goalStarter.size();k++) {
                        if (Math.abs(spriteContainer[(int)goalStarter.get(k).x][(int)goalStarter.get(k).y].getRotation()) > 5) {


                            winBools.set(k,true);
                            prefs.putBoolean(getClass().getName(), false);
                            prefs.flush();
                        }
                        else{
                            winBools.set(k,false);
                        }
                    }

                    for(int h= 0; h<winBools.size();h++){

                       winCondition =  areAllTrue(winBools);

                    }

                    //System.out.println(spriteContainer[starterX][starterY].getRotation());
                    if (winCondition) {
                        isItJumping2 = false;
                        isItInTheAir2 = false;
                        creatureSpawnBoolean2 = true;

                        jumpDelayBoolean2 = false;
                        jumpDelay2 = 4;

                        jumpTime2 = 8;
                        jump2 = true;


                        breakBlockTimer2 = 6;


                        isItJumping = false;
                        creatureSpawnBoolean = true;
                        spawnTimer = 10000;
                        spawnTimer2 = 10000;
                        breakBlockTimer = 4;
                        jumpDelayBoolean = false;

                        jumpDelay = 3;
                        isItInTheAir = false;


                        jumpTime = 8;

                        jump = true;

                        jumpDelayBoolean = false;
                        jumpDelayBoolean = false;


                    }


                    // System.out.println("GOLD: "+ goldAmount +"   prefgold: "+ prefs.getInteger("gold"));

                    if (winCondition) {
                        controller.stage.addActor(controller.winTable);





                        if(prefs.getInteger("passedlevel",1)<nextLevel) {
                            prefs.putInteger("passedlevel", nextLevel);
                            prefs.flush();
                        }
                        controller.timerCheck = false;

                        if (controller.stage.getRoot().findActor("uiElements") != null && controller.stage.getRoot().findActor("button") != null && controller.stage.getRoot().findActor("timer") != null) {
                            controller.stage.getRoot().findActor("button").remove();
                            controller.stage.getRoot().findActor("timer").remove();
                            controller.stage.getRoot().findActor("uiElements").remove();
                            System.out.println("works");


                            controller.whiteBox.setColor(0, 0, 0, 0);
                            controller.timer.setColor(0,0,0,0);
                        }

                        WINTIMER = WINTIMER - Gdx.graphics.getDeltaTime();
                        controller.game.font.draw(game.batch, "WAIT FOR:  " + WINTIMER, 0, 0);
                        if (isLevelPassed && goldBool) {
                            for (int winX = 0; winX < world_dotx_count; winX++) {
                                for (int winY = 0; winY < world_doty_count; winY++) {
                                    if (spriteContainer[winX][winY] != null) {
                                        if (isItRotating[winX][winY].x == 1) {


                                            prefs.putInteger("gold", prefs.getInteger("gold", 100) + 1);
                                            prefs.flush();


                                        } else {


                                            if (prefs.getInteger("gold") > 0) {
                                                prefs.putInteger("gold", prefs.getInteger("gold", 100) - 1);
                                                prefs.flush();


                                            }
                                        }
                                    }
                                }

                            }
                            goldBool = false;
                        }
                        controller.winCond = true;
                        if (WINTIMER < 0) {


                            VariableCalls.timeLeft = 100f;


                            if(isLevelPassed & crateHad) {

                                prefs.putInteger("chest", prefs.getInteger("chest", 0) + 1);
                                prefs.flush();
                                crateHad = false;
                            }





                            if(VariableCalls.gameEnd)
                                VariableCalls.fadeOut += delta * 100;

                            if (VariableCalls.fadeOut > 300) {

                                EnumClass.state = EnumClass.State.STOPPED;


                                // switchScreen(game, new LevelSelection(game));

                            }
                        }


                    }


                    if (controller.loseCond) {


                        controller.stage.addActor(controller.loseTable);



                        controller.timerCheck = false;

                        if (controller.stage.getRoot().findActor("uiElements") != null && controller.stage.getRoot().findActor("button") != null && controller.stage.getRoot().findActor("timer") != null) {
                            controller.stage.getRoot().findActor("button").remove();
                            controller.stage.getRoot().findActor("timer").remove();
                            controller.stage.getRoot().findActor("uiElements").remove();
                            controller.whiteBox.setColor(0, 0, 0, 0);

                            System.out.println("works");


                        }
                        buttonSet = false;

                        WINTIMER = WINTIMER - Gdx.graphics.getDeltaTime();
                        game.font.draw(game.batch, "WAIT FOR:  " + WINTIMER, 0, 0);

                        if (WINTIMER < 0) {



                            VariableCalls.timeLeft = 100f;

                            if(VariableCalls.gameEnd)
                                VariableCalls.fadeOut += delta * 100;

                            if (VariableCalls.fadeOut > 300) {


                                EnumClass.state = EnumClass.State.STOPPED;

                                // switchScreen(game, new LevelSelection(game));

                            }


                        }
                    }


                    // controller.game.font.dispose();
                    if (crateGot && isLevelPassed) {
                        if (crateBoolean) {
                            crateTimer -= delta;

                            int xE = 0;
                            for (int jCh = 0; jCh <world_dotx_count; jCh++) {
                                for (int kCh = 0; kCh < world_doty_count; kCh++) {
                                    for (int lCh = 0; lCh < 4; lCh++) {
                                        if (aList.allowedList[jCh][kCh][lCh] != null) {

                                            if (aList.allowedList[jCh][kCh][lCh] != new Vector3(0, 0, 0) && aList.allowedList[jCh][kCh][lCh].z != 0 && spriteArray[jCh][kCh][0].z == 0) {


                                                allowedListChest[xE] = new Vector2(aList.allowedList[jCh][kCh][lCh].x, aList.allowedList[jCh][kCh][lCh].y);
                                                xE++;

                                            }

                                        }

                                    }


                                }


                            }
                            chestSprite.setSize(5, 5);


                            int randX = random.nextInt(allowedListChest.length);


                            crateDecay = 10;
                            if (allowedListChest[randX] != null && allowedListChest[randX].x != 0 && allowedListChest[randX].y != 0) {


                                chestSprite.setPosition(pointCoordinates[(int) allowedListChest[randX].x][(int) allowedListChest[randX].y].x - chestSprite.getWidth() / 2, pointCoordinates[(int) allowedListChest[randX].x][(int) allowedListChest[randX].y].y - chestSprite.getHeight() / 2);
                            }

                        }


                        if (crateTimer < 0) {


                            System.out.println(String.valueOf(prefs.getInteger("chest")));


                            if (chestSprite.getX() != 0 && chestSprite.getY() != 0)
                                chestSprite.draw(game.batch);

                            crateBoolean = false;


                        }

                        if (!crateBoolean) {

                            crateDecay -= delta;

                            if (crateDecay < 0) {

                                crateTimer = 5;
                                crateBoolean = true;


                            }


                        }
                    }


                }
                if(VariableCalls.gameStart){



                    fadeIn -= delta*100;

                    levelPassSprite.setOrigin(levelPassSprite.getWidth()/2,levelPassSprite.getHeight()/2);
                    levelPassSprite.setPosition(cam.position.x - levelPassSprite.getWidth()/2, cam.position.y - levelPassSprite.getHeight()/2);
                    levelPassSprite.setSize(fadeIn,fadeIn);
                    levelPassSprite.setRotation(levelPassSprite.getRotation() + 4f);

                    System.out.println(cam.position.y+ "    " + (levelPassSprite.getY() + levelPassSprite.getWidth()/2));



                    if (fadeIn > 0) {
                        levelPassSprite.draw(game.batch);

                    }
                    else{
                        VariableCalls.gameStart = false;
                    }



                }

                if(VariableCalls.gameEnd){

                    levelPassSprite.setOrigin(levelPassSprite.getWidth()/2,levelPassSprite.getHeight()/2);
                    levelPassSprite.setPosition(pointCoordinates[moveX][moveY].x - levelPassSprite.getWidth()/2, pointCoordinates[moveX][moveY].y - levelPassSprite.getHeight()/2);
                    levelPassSprite.setSize(VariableCalls.fadeOut,VariableCalls.fadeOut);
                    levelPassSprite.setRotation(levelPassSprite.getRotation() + 4f);
                    levelPassSprite.draw(game.batch);

                    System.out.println(prefs.getInteger("gold"));

                }

                if(commenceCounter>300 && fadeIn<100){
                    threetwoone.setAlignment(center);
                    threetwoone.setText("3!");
                    threetwoone.draw(game.batch,1);

                }

                else if(commenceCounter<=300 && commenceCounter>200)
                {
                    threetwoone.setText("2!");
                    threetwoone.draw(game.batch,1);

                }
                else if(commenceCounter<=200 && commenceCounter>100) {
                    threetwoone.setText("1!");

                    threetwoone.draw(game.batch,1);


                }

                else if(commenceCounter<100 && commenceCounter>0){
                    threetwoone.setText("GO!");
                    threetwoone.draw(game.batch,1);



                }

                else{

                    VariableCalls.timeLeft -= delta;

                }


                game.batch.end();




                if(fadeIn<200) {
                    stage.draw();


                    if(commenceCounter<0)
                        controller.draw();
                }

                if(fadeIn<0 && commenceCounter>-5)
                {

                    commenceCounter -= delta*100;

                }

                //System.ot.println(Gdx.graphics.getDeltaTime());










                if (!controller.loseCond)
                    controller.     whiteBox.setSize(VariableCalls.timeLeft/2, 11 );
                if (VariableCalls.timeLeft < 0) {

                    controller.loseCond = true;


                }


                if (VariableCalls.timeLeft > 10) {
                    controller.whiteBox.setColor(0, 1, 0, 1);
                } else {
                    controller.whiteBox.setColor(1, 0, 0, 1);
                }


                if(VariableCalls.initBool) {
                    init(game);

                    VariableCalls.initBool = false;

                }


            }


            break;

            case STOPPED: {




                // game.setScreen(new LevelSelection(game));

                VariableCalls.gameEnd = false;
                dispose();


                break;}
            case PAUSE: {



                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                Gdx.gl.glClearColor(0, 0f, 0, 1);
                game.batch.setProjectionMatrix(cam.combined);

                Gdx.input.setInputProcessor(pS.stage);


                inputUpdate(Gdx.graphics.getDeltaTime());



                cameraUpdate(Gdx.graphics.getDeltaTime());


                if(Gdx.input.isKeyJustPressed(Input.Keys.BACK) && VariableCalls.buttonCheck){


                    EnumClass.state = EnumClass.State.RUN;



                }




                if(!controller.loseCond && !controller.winCond) {
                    if (prefs.getString("Left").equals("Left")) {

                        if (buttonSet) {
                            controller.stage.getRoot().findActor("button").setPosition(15, 15);
                        }
                        controller.stage.getRoot().findActor("uiElements").setPosition(15, VariableCalls.WORLD_HEIGHT / 2);


                    } else {
                        if (buttonSet) {

                            controller.stage.getRoot().findActor("button").setPosition(WORLD_WIDTH - 15, 15);
                        }
                        controller.stage.getRoot().findActor("uiElements").setPosition(WORLD_WIDTH - 15, VariableCalls.WORLD_HEIGHT / 2);


                    }


                }









                pS.stage.draw();

                pS.stage.act(Gdx.graphics.getDeltaTime());




            }


            break;



            case RESUME:{

                EnumClass.state = EnumClass.State.RUN;

            }
            break;
        }



    }
    public void creatureMovement(float Delta){

        if(jumpDelayBoolean) {


            jumpDelay = jumpDelay - Delta;
            //System.out.println(jumpDelay);

            if (jumpDelay < 0) {
                double random = Math.random();

                if (random < 0.25 && crX - 1 >= 0 && crY - 1 >= 0) {
                    crX--;
                    crY--;

                    jumpDelay = 3;
                    jump = true;
                }
                if (random < 0.5 && random > 0.25 && crX - 1 >= 0 && crY + 1 < world_doty_count) {
                    crX--;
                    crY++;

                    jumpDelay = 3;
                    jump = true;

                }
                if (random < 0.75 && random > 0.5 && crX + 1 < world_dotx_count && crY + 1 < world_doty_count) {
                    crX++;
                    crY++;

                    jumpDelay = 3;
                    jump = true;
                }
                if (random < 1 && random > 0.75 && crX + 1 < world_dotx_count && crY - 1 >= 0) {
                    crX++;
                    crY--;

                    jumpDelay = 3;
                    jump = true;
                }

            }


            a += (creaturePosition[crX][crY].x - a) * 3 * Delta;


            if ((creaturePosition[crX][crY].y - b) < 0) {
                b += (creaturePosition[crX][crY].y - b) * Interpolation.circleIn.apply(0.25f);
                //System.out.println("<0");
            } else if ((creaturePosition[crX][crY].y - b) > 0) {
                b += (creaturePosition[crX][crY].y - b) * Interpolation.circleOut.apply(Delta / 4);
                //System.out.println(">0");
            } else {
                b += (creaturePosition[crX][crY].y - b) * 1.05f * Interpolation.circleIn.apply(0.2f);

                //System.out.println("else");
            }


            if (jump && breakBlockTimer >0) {

                breakBlockTimer--;
                jump =false;
                //System.out.println(breakBlockTimer);



            }









            creatureSprite.setPosition(a - creatureSprite.getWidth() / 2, b);

        }

        if(breakBlockTimer<=0) {
            a += (creaturePosition[crX][crY].x - a) * 3 * Delta;


            if ((creaturePosition[crX][crY].y - b) < 0) {
                b += (creaturePosition[crX][crY].y - b) * Interpolation.circleIn.apply(0.25f);
                //System.out.println("<0");
            } else if ((creaturePosition[crX][crY].y - b) > 0) {
                b += (creaturePosition[crX][crY].y - b) * Interpolation.circleOut.apply(Delta / 4);
                //System.out.println(">0");
            } else {
                b += (creaturePosition[crX][crY].y - b) * 1.05f * Interpolation.circleIn.apply(0.2f);

                //System.out.println("else");
            }

            creatureSprite.setPosition(a - creatureSprite.getWidth() / 2, b);


            jumpDelayBoolean = false;
            jump = false;


            //System.out.println(jumpFreq);
            if (isItJumping) {


                creatureSprite.setOrigin(center);

                jumpFreq = jumpFreq - Delta;
                if (jumpFreq < 0) {
                    jumpTime--;
                    creatureSprite.setRotation(0);
                    if (isItInTheAir) {


                        creatureSprite.setRotation(creatureSprite.getRotation()-20f);
                        isItInTheAir = false;
                        jumpFreq = 1;


                    } else {
                        creatureSprite.setColor(Color.WHITE);
                        creatureSprite.setRotation(creatureSprite.getRotation()+20f);
                        isItInTheAir = true;
                        jumpFreq = 1;

                    }


                }


            }




            if (jumpTime < 0) {

                if (brokenHingeContainer[crX][crY].x != 1000 &&
                        brokenHingeContainer[crX][crY].y != 1000) {
                    jumpTime++;
                    creatureSprite.setRotation(0);
                }

                else{
                    jumpTime = 8;
                    isItJumping = false;
                    creatureSprite.setRotation(0);

                    breakBlockTimer = 4;

                    if (spriteContainer[crX][crY] == null) {

                        brokenHingeContainer[crX][crY].x = creaturePosition[crX][crY].x;
                        brokenHingeContainer[crX][crY].y = creaturePosition[crX][crY].y;
                    } else {
                        isThisRolling[crX][crY] = false;
                        spriteContainer[crX][crY].setColor(Color.BLACK);
                    }


                    creatureSpawnBoolean = true;
                }
            }

        }
        if(creatureSpawnBoolean) {


            b += (creaturePosition[crX][crY].y-300f - b) * Delta/3;
            creatureSprite.setPosition(a - creatureSprite.getWidth() / 2, b);
            spawnTimer = spawnTimer - Delta;


            //System.out.println("b = " + b);

            if (spawnTimer < 0) {

                creatureSprite.setColor(0,0,0,0);
                b = 1000;
                creatureSprite.setPosition(a - creatureSprite.getWidth() / 2, b);
                creatureSprite.setColor(Color.WHITE);


                creatureSprite.setColor(1,1,1,1);

                //System.out.println("spawnTimer  ="  + spawnTimer);
                int locationx = 2;
                int locationy = 2;
                boolean c2set = true;
                while(c2set){

                    locationx = random.nextInt(world_dotx_count) ;
                    locationy = random.nextInt(world_doty_count);


                    if(brokenHingeContainer[locationx][locationy].x == 1000){c2set = false;}



                }

                creatureSprite.setColor(Color.WHITE);

                b += (creaturePosition[locationx][locationy].y - b) * 3f * Interpolation.circleIn.apply(0.2f);

                a += (creaturePosition[locationx][locationy].x - a) * 3 * Delta;

                crX = locationx;
                crY= locationy;

                spawnTimer = 10;
                isItJumping = true;
                jumpDelayBoolean = true;
                creatureSpawnBoolean = false;
                jump = true;
                breakBlockTimer = 4;

            }

        }

    }





    public void creatureMovement2(float Delta){

        if(jumpDelayBoolean2) {


            jumpDelay2 = jumpDelay2 - Delta;
            //System.out.println(jumpDelay);

            if (jumpDelay2 < 0) {
                double random = Math.random();

                if (random < 0.25 && crX2 - 1 >= 0 && crY2 - 1 >= 0) {
                    crX2--;
                    crY2--;

                    jumpDelay2 = 3;
                    jump2 = true;
                }
                if (random < 0.5 && random > 0.25 && crX2 - 1 >= 0 && crY2 + 1 < world_doty_count) {
                    crX2--;
                    crY2++;

                    jumpDelay2 = 3;
                    jump2 = true;

                }
                if (random < 0.75 && random > 0.5 && crX2 + 1 < world_dotx_count && crY2 + 1 < world_doty_count) {
                    crX2++;
                    crY2++;

                    jumpDelay2 = 3;
                    jump2 = true;
                }
                if (random < 1 && random > 0.75 && crX2 + 1 < world_dotx_count && crY2 - 1 >= 0) {
                    crX2++;
                    crY2--;

                    jumpDelay2 = 3;
                    jump2 = true;
                }

            }


            a2 += (creaturePosition2[crX2][crY2].x - a2) * 3 * Delta;


            if ((creaturePosition2[crX2][crY2].y - b2) < 0) {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * Interpolation.circleIn.apply(0.25f);
                //System.out.println("<0");
            } else if ((creaturePosition2[crX2][crY2].y - b2) > 0) {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * Interpolation.circleOut.apply(Delta / 4);
                //System.out.println(">0");
            } else {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * 1.05f * Interpolation.circleIn.apply(0.2f);

                //System.out.println("else");
            }


            if (jump2 && breakBlockTimer2 >0) {

                breakBlockTimer2--;
                jump2 =false;
                //System.out.println(breakBlockTimer);




            }









            creatureSprite2.setPosition(a2 - creatureSprite2.getWidth() / 2, b2);

        }

        if(breakBlockTimer2<=0){
            a2 += (creaturePosition2[crX2][crY2].x - a2) * 3 * Delta;


            if ((creaturePosition2[crX2][crY2].y - b2) < 0) {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * Interpolation.circleIn.apply(0.25f);
                //System.out.println("<0");
            } else if ((creaturePosition2[crX2][crY2].y - b2) > 0) {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * Interpolation.circleOut.apply(Delta / 4);
                //System.out.println(">0");
            } else {
                b2 += (creaturePosition2[crX2][crY2].y - b2) * 1.05f * Interpolation.circleIn.apply(0.2f);

                //System.out.println("else");
            }

            creatureSprite2.setPosition(a2 - creatureSprite2.getWidth() / 2, b2);



            jumpDelayBoolean2 = false;
            jump2 = false;


            //System.out.println(jumpFreq);
            if(isItJumping2){

                creatureSprite2.setOrigin(center);

                jumpFreq2 = jumpFreq2-Delta;
                if (jumpFreq2<0) {
                    jumpTime2--;
                    creatureSprite2.setRotation(0);
                    if(isItInTheAir2) {

                        creatureSprite2.setRotation(creatureSprite.getRotation()-20f);
                        isItInTheAir2 = false;
                        jumpFreq2 = 1;

                    }
                    else{ creatureSprite2.setRotation(creatureSprite.getRotation()+20f);

                        isItInTheAir2 = true;
                        jumpFreq2 = 1;
                    }






                }



            }



            if(jumpTime2<0) {

                if (brokenHingeContainer[crX2][crY2].x != 1000 &&
                        brokenHingeContainer[crX2][crY2].y != 1000) {
                    jumpTime++;
                    creatureSprite2.setRotation(0);
                }


                else{
                    jumpTime2 = 9;
                    isItJumping2 = false;

                    creatureSprite.setRotation(0);

                    breakBlockTimer2 = 6;

                    if (spriteContainer[crX2][crY2] == null) {

                        brokenHingeContainer[crX2][crY2].x = creaturePosition[crX2][crY2].x;
                        brokenHingeContainer[crX2][crY2].y = creaturePosition[crX2][crY2].y;
                    } else {
                        isThisRolling[crX2][crY2] = false;

                        spriteContainer[crX2][crY2].setColor(Color.BLACK);
                    }


                    creatureSpawnBoolean2 = true;
                }
            }
        }
        if(creatureSpawnBoolean2) {


            b2 += (creaturePosition2[crX2][crY2].y-300f - b2) * Delta/3;
            creatureSprite2.setPosition(a2 - creatureSprite.getWidth() / 2, b2);
            spawnTimer2 = spawnTimer2 - Delta;


            //System.out.println("b = " + b);

            if (spawnTimer2 < 0) {

                creatureSprite2.setColor(0,0,0,0);
                b2 = 1000;
                creatureSprite2.setPosition(a2 - creatureSprite2.getWidth() / 2, b2);



                creatureSprite2.setColor(1,1,1,1);

                //System.out.println("spawnTimer  ="  + spawnTimer);
                int locationx = 1;
                int locationy = 1;

                boolean c2set = true;

                while(c2set){

                    locationx = random.nextInt(world_dotx_count) ;
                    locationy = random.nextInt(world_doty_count);


                    if(brokenHingeContainer[locationx][locationy].x == 1000){c2set = false;}



                }

                creatureSprite2.setColor(Color.WHITE);

                b2 += (creaturePosition2[locationx][locationy].y - b2) * 3f * Interpolation.circleIn.apply(0.2f);

                a2 += (creaturePosition2[locationx][locationy].x - a2) * 3 * Delta;

                crX2 = locationx;
                crY2= locationy;

                spawnTimer2 = 12;
                isItJumping2 = true;
                jumpDelayBoolean2 = true;
                creatureSpawnBoolean2 = false;
                jump2 = true;
                breakBlockTimer2 = 6;

            }

        }

    }

    public void inputUpdate(float Delta) {
/*

        if (controller.touchpad.getKnobPercentX() > 0.6f) {

            if (moveX >= 0 && moveX <= world_dotx_count - 1) {


                inputTime += Delta;
                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveX == world_dotx_count - 1) {
                    } else
                        moveX++;
                    inputTime = 0;
                }
            }


        }
        if (controller.touchpad.getKnobPercentX() < -0.6f) {
            if (moveX >= 0 && moveX <= world_dotx_count - 1) {

                inputTime += Delta;

                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveX == 0) {
                    } else
                        moveX--;
                    inputTime = 0;
                }
            }

        }
        if (controller.touchpad.getKnobPercentY() > 0.6f) {

            if (moveY >= 0 && moveY <= world_doty_count - 1) {

                inputTime += Delta;

                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveY == world_doty_count - 1) {
                    } else
                        moveY++;
                    inputTime = 0;
                }
            }

        }
        if (controller.touchpad.getKnobPercentY() < -0.6f) {

            if (moveY >= 0 && moveY <= world_doty_count - 1) {
                inputTime += Delta;
                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveY == 0) {
                    } else
                        moveY--;
                    inputTime = 0;
                }
            }

        }
*/

        if (controller.isUiElementsPressed()) {
            chosenState = 2;
            controller.gearImg.setColor(1,1,1,1);

            controller.blowtorchImg.setColor(1,1,1,1);

            controller.bombImg.setColor(Color.YELLOW);

            controller.crossHair.setColor(1,1,1,1);


            badsprite = new Sprite(bomb);
            badsprite.setSize(5, 5);


        }
        if(controller.isBlowtorchPressed()){

            chosenState= 3;

            controller.gearImg.setColor(1,1,1,1);

            controller.blowtorchImg.setColor(Color.YELLOW);

            controller.bombImg.setColor(1,1,1,1);

            controller.crossHair.setColor(1,1,1,1);



            badsprite = new Sprite(blowtorcht);

            badsprite.setSize(5,5);


        }

        if (controller.isGearPressed()) {

            chosenState = 1;
            controller.gearImg.setColor(Color.YELLOW);

            controller.blowtorchImg.setColor(1,1,1,1);

            controller.bombImg.setColor(1,1,1,1);

            controller.crossHair.setColor(1,1,1,1);




            if (rand == 1) {
                badsprite = new Sprite(kucuk);

                badsprite.setSize(5.5f, 5.5f);
            }

            if (rand == 2) {
                badsprite = new Sprite(orta);

                badsprite.setSize(10.8f, 10.8f);
            }
            if (rand == 3) {
                badsprite = new Sprite(buyuk);

                badsprite.setSize(16f, 16f);
            }

        }

        if (controller.isCrosshairPressed()) {
            chosenState = 4;

            controller.gearImg.setColor(1, 1, 1, 1);

            controller.blowtorchImg.setColor(1,1,1,1);

            controller.bombImg.setColor(1,1,1,1);

            controller.crossHair.setColor(Color.YELLOW);

            badsprite = new Sprite(crossHair);

            badsprite.setSize(5, 5);


        }


      /*  if (controller.isUpPressed()) {

            if (moveY >= 0 && moveY <= world_doty_count - 1) {

                inputTime += Delta;

                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveY == world_doty_count - 1) {
                    } else
                        moveY++;
                    inputTime = 0;
                }
            }


        }


        if (controller.isDownPressed()) {

            if (moveY >= 0 && moveY <= world_doty_count - 1) {
                inputTime += Delta;
                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveY == 0) {
                    } else
                        moveY--;
                    inputTime = 0;
                }

            }
        }


        if (controller.isRightPressed()) {


            if (moveX >= 0 && moveX <= world_dotx_count - 1) {


                inputTime += Delta;
                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveX == world_dotx_count - 1) {
                    } else
                        moveX++;
                    inputTime = 0;
                }
            }
        }


        if (controller.isLeftPressed()) {

            if (moveX >= 0 && moveX <= world_dotx_count - 1) {

                inputTime += Delta;

                if (inputTime > 0.2f && inputTime - Delta < 0.2f) {
                    if (moveX == 0) {
                    } else
                        moveX--;
                    inputTime = 0;
                }
            }


        }

*/

        if (controller.isButtonPressed() && commenceCounter<1) {

            if (brokenHingeContainer[moveX][moveY].x == 1000) {
                if (chosenState == 1) {


                    if (VariableCalls.buttonCheck) {


                        if (rand == 1) {
                            if (moveX + 1 < world_dotx_count)
                                aList.allowedList(moveX + 1, moveY, 2, moveX + 1, moveY, 2);
                            if (moveY + 1 < world_doty_count)
                                aList.allowedList(moveX, moveY + 1, 2, moveX, moveY + 1, 2);
                            if (moveX - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY, 2, moveX - 1, moveY, 2);

                            if (moveY - 1 >= 0)
                                aList.allowedList(moveX, moveY - 1, 2, moveX, moveY - 1, 2);


                            if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                aList.allowedList(moveX + 1, moveY + 1, 3, moveX + 1, moveY + 1, 3);
                            if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY + 1, 3, moveX - 1, moveY + 1, 3);
                            if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY - 1, 3, moveX - 1, moveY - 1, 3);

                            if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                aList.allowedList(moveX + 1, moveY - 1, 3, moveX + 1, moveY - 1, 3);


                        }

                        if (rand == 2) {

                            if (moveX + 1 < world_dotx_count)
                                aList.allowedList(moveX + 1, moveY, 1, moveX + 1, moveY, 1);
                            if (moveY + 1 < world_doty_count)
                                aList.allowedList(moveX, moveY + 1, 1, moveX, moveY + 1, 1);
                            if (moveX - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY, 1, moveX - 1, moveY, 1);

                            if (moveY - 1 >= 0)
                                aList.allowedList(moveX, moveY - 1, 1, moveX, moveY - 1, 1);


                            if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                aList.allowedList(moveX + 1, moveY + 1, 2, moveX + 1, moveY + 1, 2);
                            if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY + 1, 2, moveX - 1, moveY + 1, 2);
                            if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY - 1, 2, moveX - 1, moveY - 1, 2);

                            if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                aList.allowedList(moveX + 1, moveY - 1, 2, moveX + 1, moveY - 1, 2);


                        }

                        if (rand == 3) {
                            if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                aList.allowedList(moveX + 1, moveY + 1, 1, moveX + 1, moveY + 1, 1);
                            if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY + 1, 1, moveX - 1, moveY + 1, 1);
                            if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                aList.allowedList(moveX - 1, moveY - 1, 1, moveX - 1, moveY - 1, 1);

                            if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                aList.allowedList(moveX + 1, moveY - 1, 1, moveX + 1, moveY - 1, 1);


                            if (moveX + 2 < world_dotx_count)
                                aList.allowedList(moveX + 2, moveY, 3, moveX + 2, moveY, 3);
                            if (moveX - 2 >= 0)
                                aList.allowedList(moveX - 2, moveY, 3, moveX - 2, moveY, 3);
                            if (moveY - 2 >= 0)
                                aList.allowedList(moveX, moveY - 2, 3, moveX, moveY - 2, 3);

                            if (moveY + 2 < world_doty_count)
                                aList.allowedList(moveX, moveY + 2, 3, moveX, moveY + 2, 3);


                        }

                        if (forbid.forbiddenList[moveX][moveY][rand].z != rand) {
                            if (rand == 1) {


                                forbid.forbidList(moveX, moveY, 1, moveX, moveY, 1);
                                forbid.forbidList(moveX, moveY, 2, moveX, moveY, 2);
                                forbid.forbidList(moveX, moveY, 3, moveX, moveY, 3);

                                if (moveX + 1 < world_dotx_count)
                                    forbid.forbidList(moveX + 1, moveY, 3, moveX + 1, moveY, 3);
                                if (moveY + 1 < world_doty_count)
                                    forbid.forbidList(moveX, moveY + 1, 3, moveX, moveY + 1, 3);
                                if (moveX - 1 >= 0)
                                    forbid.forbidList(moveX - 1, moveY, 3, moveX - 1, moveY, 3);
                                if (moveY - 1 >= 0)
                                    forbid.forbidList(moveX, moveY - 1, 3, moveX, moveY - 1, 3);


                            }
                            if (rand == 2) {


                                forbid.forbidList(moveX, moveY, 1, moveX, moveY, 1);
                                forbid.forbidList(moveX, moveY, 2, moveX, moveY, 2);
                                forbid.forbidList(moveX, moveY, 3, moveX, moveY, 3);

                                if (moveX + 1 < world_dotx_count)
                                    forbid.forbidList(moveX + 1, moveY, 2, moveX + 1, moveY, 2);
                                if (moveY + 1 < world_doty_count)
                                    forbid.forbidList(moveX, moveY + 1, 2, moveX, moveY + 1, 2);
                                if (moveX - 1 >= 0)
                                    forbid.forbidList(moveX - 1, moveY, 2, moveX - 1, moveY, 2);
                                if (moveY - 1 >= 0)
                                    forbid.forbidList(moveX, moveY - 1, 2, moveX, moveY - 1, 2);

                                if (moveX + 1 < world_dotx_count)
                                    forbid.forbidList(moveX + 1, moveY, 3, moveX + 1, moveY, 3);
                                if (moveY + 1 < world_doty_count)
                                    forbid.forbidList(moveX, moveY + 1, 3, moveX, moveY + 1, 3);
                                if (moveX - 1 >= 0)
                                    forbid.forbidList(moveX - 1, moveY, 3, moveX - 1, moveY, 3);
                                if (moveY - 1 >= 0)
                                    forbid.forbidList(moveX, moveY - 1, 3, moveX, moveY - 1, 3);

                                if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                    forbid.forbidList(moveX + 1, moveY + 1, 3, moveX + 1, moveY + 1, 3);


                                }

                                if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                    forbid.forbidList(moveX - 1, moveY + 1, 3, moveX - 1, moveY + 1, 3);

                                }

                                if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                    forbid.forbidList(moveX - 1, moveY - 1, 3, moveX - 1, moveY - 1, 3);

                                }

                                if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                    forbid.forbidList(moveX + 1, moveY - 1, 3, moveX + 1, moveY - 1, 3);

                                }


                            }
                            if (rand == 3) {


                                forbid.forbidList(moveX, moveY, 1, moveX, moveY, 1);
                                forbid.forbidList(moveX, moveY, 2, moveX, moveY, 2);
                                forbid.forbidList(moveX, moveY, 3, moveX, moveY, 3);

                                if (moveX + 1 < world_dotx_count) {
                                    forbid.forbidList(moveX + 1, moveY, 1, moveX + 1, moveY, 1);
                                    forbid.forbidList(moveX + 1, moveY, 2, moveX + 1, moveY, 2);
                                    forbid.forbidList(moveX + 1, moveY, 3, moveX + 1, moveY, 3);


                                }

                                if (moveY + 1 < world_doty_count) {
                                    forbid.forbidList(moveX, moveY + 1, 1, moveX, moveY + 1, 1);
                                    forbid.forbidList(moveX, moveY + 1, 2, moveX, moveY + 1, 2);
                                    forbid.forbidList(moveX, moveY + 1, 3, moveX, moveY + 1, 3);

                                }

                                if (moveX - 1 >= 0) {
                                    forbid.forbidList(moveX - 1, moveY, 1, moveX - 1, moveY, 1);
                                    forbid.forbidList(moveX - 1, moveY, 2, moveX - 1, moveY, 2);
                                    forbid.forbidList(moveX - 1, moveY, 3, moveX - 1, moveY, 3);

                                }

                                if (moveY - 1 >= 0) {
                                    forbid.forbidList(moveX, moveY - 1, 1, moveX, moveY - 1, 1);
                                    forbid.forbidList(moveX, moveY - 1, 2, moveX, moveY - 1, 2);
                                    forbid.forbidList(moveX, moveY - 1, 3, moveX, moveY - 1, 3);

                                }


                                //LARGE CROSSES


                                if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                    forbid.forbidList(moveX + 1, moveY + 1, 2, moveX + 1, moveY + 1, 2);
                                    forbid.forbidList(moveX + 1, moveY + 1, 3, moveX + 1, moveY + 1, 3);


                                }

                                if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                    forbid.forbidList(moveX - 1, moveY + 1, 2, moveX - 1, moveY + 1, 2);
                                    forbid.forbidList(moveX - 1, moveY + 1, 3, moveX - 1, moveY + 1, 3);

                                }

                                if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                    forbid.forbidList(moveX - 1, moveY - 1, 2, moveX - 1, moveY - 1, 2);
                                    forbid.forbidList(moveX - 1, moveY - 1, 3, moveX - 1, moveY - 1, 3);

                                }

                                if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                    forbid.forbidList(moveX + 1, moveY - 1, 2, moveX + 1, moveY - 1, 2);
                                    forbid.forbidList(moveX + 1, moveY - 1, 3, moveX + 1, moveY - 1, 3);

                                }
                            }


                            if (rand == 1) {
                                sprite = new Sprite(kucuk1);
                                Random intRandom = new Random();
                                int colorCode = intRandom.nextInt(5);
                                if (colorCode == 0) {
                                    sprite.setColor(205f / 255f, 0, 120f / 255f, 1);
                                } else if (colorCode == 1) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 251f / 255f, 1);
                                } else if (colorCode == 2) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 38f / 255f, 1);
                                } else if (colorCode == 3) {
                                    sprite.setColor(255 / 255f, 158 / 255f, 84f / 255f, 1);
                                } else {
                                    sprite.setColor(255f / 255f, 128 / 255f, 85f / 255f, 1);
                                }
                                sprite.setSize(5.5f, 5.5f);
                            }
                            if (rand == 2) {
                                sprite = new Sprite(orta1);
                                Random intRandom = new Random();
                                int colorCode = intRandom.nextInt(5);
                                if (colorCode == 0) {
                                    sprite.setColor(205f / 255f, 0, 120f / 255f, 1);
                                } else if (colorCode == 1) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 251f / 255f, 1);
                                } else if (colorCode == 2) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 38f / 255f, 1);
                                } else if (colorCode == 3) {
                                    sprite.setColor(255 / 255f, 158 / 255f, 84f / 255f, 1);
                                } else {
                                    sprite.setColor(255f / 255f, 128 / 255f, 85f / 255f, 1);
                                }
                                sprite.setSize(10.8f, 10.8f);
                            }
                            if (rand == 3) {
                                sprite = new Sprite(buyuk1);
                                Random intRandom = new Random();
                                int colorCode = intRandom.nextInt(5);
                                if (colorCode == 0) {
                                    sprite.setColor(205f / 255f, 0, 120f / 255f, 1);
                                } else if (colorCode == 1) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 251f / 255f, 1);
                                } else if (colorCode == 2) {
                                    sprite.setColor(5f / 255f, 255 / 255f, 38f / 255f, 1);
                                } else if (colorCode == 3) {
                                    sprite.setColor(255 / 255f, 158 / 255f, 84f / 255f, 1);
                                } else {
                                    sprite.setColor(255f / 255f, 128 / 255f, 85f / 255f, 1);
                                }
                                sprite.setSize(16f, 16f);
                            }

                            sprite.setPosition(pointCoordinates[moveX][moveY].x - sprite.getWidth() / 2, pointCoordinates[moveX][moveY].y - sprite.getHeight() / 2);


                            spriteContainer[moveX][moveY] = sprite;
                            spriteArray[moveX][moveY][0] = new Vector3(pointCoordinates[moveX][moveY].x, pointCoordinates[moveX][moveY].y, rand);


                            if (chestSprite.getColor().a > 0 && chestSprite.getX() != 0 && chestSprite.getY() != 0 && chestSprite.getBoundingRectangle().overlaps(spriteContainer[moveX][moveY].getBoundingRectangle())) {

                                crateGot = false;
                                explosionBool = true;

                                crateHad = true;


                                System.out.println(prefs.getInteger("chest") + "Chest");
                                chestSprite.setAlpha(0);

                            }


                            if (rec1.overlaps(spriteContainer[moveX][moveY].getBoundingRectangle())) {


                                isItJumping = false;
                                creatureSpawnBoolean = true;
                                breakBlockTimer = 4;
                                jumpDelayBoolean = false;

                                jumpDelay = 3;
                                isItInTheAir = false;


                                jumpTime = 8;

                                jump = true;


                            }

                            if (rec2.overlaps(spriteContainer[moveX][moveY].getBoundingRectangle())) {
                                isItJumping2 = false;
                                isItInTheAir2 = false;
                                creatureSpawnBoolean2 = true;

                                jumpDelayBoolean2 = false;
                                jumpDelay2 = 4;

                                jumpTime2 = 8;
                                jump2 = true;


                                breakBlockTimer2 = 6;


                            }


                            rand = VariableCalls.prevRand;
                            VariableCalls.prevRand = randomizer.randomize();

                            if (VariableCalls.prevRand == 1) {
                                nextGear = new Image(kucuk1);

                                nextGear.setSize(5.5f * 2f, 5.5f * 2f);
                            }
                            if (VariableCalls.prevRand == 2) {
                                nextGear = new Image(orta1);

                                nextGear.setSize(10.8f * 2, 10.8f * 2);
                            }
                            if (VariableCalls.prevRand == 3) {
                                nextGear = new Image(buyuk1);

                                nextGear.setSize(16f * 2, 16f * 2);
                            }

                            nextGear.setPosition(15 - nextGear.getWidth() / 2, VariableCalls.WORLD_HEIGHT - 15 - nextGear.getHeight() / 2);


                            if (rand == 1) {
                                badsprite = new Sprite(kucuk);
                                badsprite.setSize(5.5f, 5.5f);
                            }

                            if (rand == 2) {
                                badsprite = new Sprite(orta);

                                badsprite.setSize(10.8f, 10.8f);
                            }
                            if (rand == 3) {
                                badsprite = new Sprite(buyuk);

                                badsprite.setSize(16f, 16f);
                            }


                        }


                        VariableCalls.buttonCheck = false;
                    }
                }

                if (chosenState == 2 && bombAmount >= 1) {

                    int a =goalStarter.size();
                    switch (a) {

                        case 1: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY] && spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        case 2: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY] && spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(1).x][(int)goalStarter.get(1).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        case 3: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(1).x][(int)goalStarter.get(1).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(2).x][(int)goalStarter.get(2).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        case 4: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY] &&  spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(1).x][(int)goalStarter.get(1).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(2).x][(int)goalStarter.get(2).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(3).x][(int)goalStarter.get(3).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        case 5: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY] &&  spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(1).x][(int)goalStarter.get(1).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(2).x][(int)goalStarter.get(2).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(3).x][(int)goalStarter.get(3).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(4).x][(int)goalStarter.get(4).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        case 6: {
                            if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null && spriteContainer[moveX][moveY] != spriteContainer[starterX][starterY] &&  spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(0).x][(int)goalStarter.get(0).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(1).x][(int)goalStarter.get(1).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(2).x][(int)goalStarter.get(2).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(3).x][(int)goalStarter.get(3).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(4).x][(int)goalStarter.get(4).y]&& spriteContainer[moveX][moveY] != spriteContainer[(int)goalStarter.get(5).x][(int)goalStarter.get(5).y])
                            {
                                prefs.putInteger("bomb", bombAmount - 1);
                                bombAmount -= 1;


                                prefs.flush();

                                controller.bombCount.setText(String.valueOf(bombAmount));
                                explosionBool = true;

                                if (spriteContainer[moveX][moveY] != null) {

                                    spriteContainer[moveX][moveY] = null;

                                    int forbidIndex = (int) spriteArray[moveX][moveY][0].z;

                                    if (forbidIndex == 1) {
                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 2);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 2);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 3);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 3);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 3);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 3);


                                    }

                                    if (forbidIndex == 2) {

                                        if (moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY, 1);
                                        if (moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 1, 1);
                                        if (moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY, 1);

                                        if (moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 1, 1);


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 2);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 2);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 2);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 2);


                                    }

                                    if (forbidIndex == 3) {
                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count)
                                            aList.allowedListDelete(moveX + 1, moveY + 1, 1);
                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY + 1, 1);
                                        if (moveX - 1 >= 0 && moveY - 1 >= 0)
                                            aList.allowedListDelete(moveX - 1, moveY - 1, 1);

                                        if (moveY - 1 >= 0 && moveX + 1 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 1, moveY - 1, 1);


                                        if (moveX + 2 < world_dotx_count)
                                            aList.allowedListDelete(moveX + 2, moveY, 3);

                                        if (moveX - 2 >= 0)
                                            aList.allowedListDelete(moveX - 2, moveY, 3);

                                        if (moveY - 2 >= 0)
                                            aList.allowedListDelete(moveX, moveY - 2, 3);

                                        if (moveY + 2 < world_doty_count)
                                            aList.allowedListDelete(moveX, moveY + 2, 3);


                                    }


                                    if (forbidIndex == 1) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);


                                    }
                                    if (forbidIndex == 2) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);

                                        if (moveX + 1 < world_dotx_count)
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);
                                        if (moveY + 1 < world_doty_count)
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);
                                        if (moveX - 1 >= 0)
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);
                                        if (moveY - 1 >= 0)
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }


                                    }
                                    if (forbidIndex == 3) {
                                        forbid.forbidListDelete(moveX, moveY, 1);
                                        forbid.forbidListDelete(moveX, moveY, 2);
                                        forbid.forbidListDelete(moveX, moveY, 3);

                                        if (moveX + 1 < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY, 1);
                                            forbid.forbidListDelete(moveX + 1, moveY, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY, 3);


                                        }

                                        if (moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX, moveY + 1, 1);
                                            forbid.forbidListDelete(moveX, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY, 1);
                                            forbid.forbidListDelete(moveX - 1, moveY, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY, 3);

                                        }

                                        if (moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX, moveY - 1, 1);
                                            forbid.forbidListDelete(moveX, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX, moveY - 1, 3);

                                        }


                                        //LARGE CROSSES


                                        if (moveX + 1 < world_dotx_count && moveY + 1 < world_doty_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY + 1, 3);


                                        }

                                        if (moveY + 1 < world_doty_count && moveX - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY + 1, 3);

                                        }

                                        if (moveX - 1 >= 0 && moveY - 1 >= 0) {
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX - 1, moveY - 1, 3);

                                        }

                                        if (moveY - 1 >= 0 && moveX < world_dotx_count) {
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 2);
                                            forbid.forbidListDelete(moveX + 1, moveY - 1, 3);

                                        }
                                    }

                                    if (!isThisRolling[moveX][moveY])
                                        isThisRolling[moveX][moveY] = true;

                                    for (int forbiddenRefreshX = 0; forbiddenRefreshX < world_dotx_count; forbiddenRefreshX++) {
                                        for (int forbiddenRefreshY = 0; forbiddenRefreshY < world_doty_count; forbiddenRefreshY++) {

                                            if (spriteContainer[forbiddenRefreshX][forbiddenRefreshY] != null) {

                                                float gearType = spriteArray[forbiddenRefreshX][forbiddenRefreshY][0].z;


                                                if (gearType == 1) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);


                                                }
                                                if (gearType == 2) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);

                                                    if (forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);


                                                }
                                                if (gearType == 3) {


                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 1, forbiddenRefreshX, forbiddenRefreshY, 1);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 2, forbiddenRefreshX, forbiddenRefreshY, 2);
                                                    forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY, 3, forbiddenRefreshX, forbiddenRefreshY, 3);

                                                    if (forbiddenRefreshX + 1 < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 1, forbiddenRefreshX + 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 2, forbiddenRefreshX + 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY, 3, forbiddenRefreshX + 1, forbiddenRefreshY, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 1, forbiddenRefreshX, forbiddenRefreshY + 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 2, forbiddenRefreshX, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY + 1, 3, forbiddenRefreshX, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 1, forbiddenRefreshX - 1, forbiddenRefreshY, 1);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 2, forbiddenRefreshX - 1, forbiddenRefreshY, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY, 3, forbiddenRefreshX - 1, forbiddenRefreshY, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 1, forbiddenRefreshX, forbiddenRefreshY - 1, 1);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 2, forbiddenRefreshX, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX, forbiddenRefreshY - 1, 3, forbiddenRefreshX, forbiddenRefreshY - 1, 3);

                                                    }


                                                    //LARGE CROSSES


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 3);


                                                    }

                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 3);

                                                    }

                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0) {
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 3);

                                                    }

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX < world_dotx_count) {
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 2);
                                                        forbid.forbidList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 3);

                                                    }


                                                    if (forbiddenRefreshX + 1 < world_dotx_count && forbiddenRefreshY + 1 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshY + 1 < world_doty_count && forbiddenRefreshX - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY + 1, 1);
                                                    if (forbiddenRefreshX - 1 >= 0 && forbiddenRefreshY - 1 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX - 1, forbiddenRefreshY - 1, 1);

                                                    if (forbiddenRefreshY - 1 >= 0 && forbiddenRefreshX + 1 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1, forbiddenRefreshX + 1, forbiddenRefreshY - 1, 1);


                                                    if (forbiddenRefreshX + 2 < world_dotx_count)
                                                        aList.allowedList(forbiddenRefreshX + 2, forbiddenRefreshY, 3, forbiddenRefreshX + 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshX - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX - 2, forbiddenRefreshY, 3, forbiddenRefreshX - 2, forbiddenRefreshY, 3);
                                                    if (forbiddenRefreshY - 2 >= 0)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY - 2, 3, forbiddenRefreshX, forbiddenRefreshY - 2, 3);

                                                    if (forbiddenRefreshY + 2 < world_doty_count)
                                                        aList.allowedList(forbiddenRefreshX, forbiddenRefreshY + 2, 3, forbiddenRefreshX, forbiddenRefreshY + 2, 3);
                                                }


                                            }

                                        }
                                    }


                                    for (int rotateCheckX = 0; rotateCheckX < world_dotx_count; rotateCheckX++) {
                                        for (int rotateChecky = 0; rotateChecky < world_doty_count; rotateChecky++) {

                                            isItRotating[rotateCheckX][rotateChecky].x = 0;


                                        }
                                    }


                                    for (int stuckListX = 0; stuckListX < world_dotx_count; stuckListX++) {
                                        for (int stuckListY = 0; stuckListY < world_doty_count; stuckListY++) {
                                            for (int stuckListZ = 0; stuckListZ < 24; stuckListZ++) {

                                                stuckCheckList[stuckListX][stuckListY][stuckListZ].z = 0;
                                                stuckArray[stuckListX][stuckListY][stuckListZ].z = 0;
                                            }
                                        }
                                    }
                                    stuckCheck = false;
                                    isItRotating[0][0].x = 1;
                                    spriteArray[moveX][moveY][0].z = 0;


                                }
                                VariableCalls.buttonCheck = false;
                            }

                            break;
                        }
                        default: {

                            break;
                        }
                    }
                    }


            }
                if (chosenState == 3 && oilAmount >= 1) {
                    if (VariableCalls.buttonCheck && spriteContainer[moveX][moveY] != null) {

                        prefs.putInteger("oil", oilAmount - 1);

                        oilAmount -= 1;
                        prefs.flush();


                        controller.oilCount.setText(String.valueOf(oilAmount));


                        if (spriteContainer[moveX][moveY] != null) {
                            spriteContainer[moveX][moveY].setColor(Color.WHITE);

                            isThisRolling[moveX][moveY] = true;

                            stuckCheck = false;
                            isItRotating[0][0].x = 1;


                        }
                        VariableCalls.buttonCheck = false;
                    }
                }


                if (chosenState == 4 && bulletAmount >= 1) {
                    if (VariableCalls.buttonCheck) {

                        prefs.putInteger("bullet", bulletAmount - 1);

                        bulletAmount -= 1;

                        prefs.flush();


                        bullethit = true;
                        controller.bulletCount.setText(String.valueOf(bulletAmount));

                        if(pointCoordinates[moveX][moveY].equals(creaturePosition[crX][crY]))
                        {

                            isItJumping = false;
                            creatureSpawnBoolean = true;
                            breakBlockTimer = 4;
                            jumpDelayBoolean = false;

                            jumpDelay = 3;
                            isItInTheAir = false;


                            jumpTime = 8;

                            jump = true;
                        }

                        if(pointCoordinates[moveX][moveY].equals(creaturePosition2[crX2][crY2]))
                        {

                            isItJumping2 = false;
                            isItInTheAir2 = false;
                            creatureSpawnBoolean2 = true;

                            jumpDelayBoolean2 = false;
                            jumpDelay2 = 4;

                            jumpTime2 = 8;
                            jump2 = true;


                            breakBlockTimer2 = 6;
                        }


                        VariableCalls.buttonCheck = false;
                    }
                }


            }

        }







    //end



















    public void cameraUpdate(float Delta) {

        cam.position.x = MathUtils.clamp(cam.position.x, -WORLD_DOT_DISTANCE/2,(world_dotx_count*WORLD_DOT_DISTANCE)+WORLD_DOT_DISTANCE/2);
        cam.position.y = MathUtils.clamp(cam.position.y, -WORLD_DOT_DISTANCE/2,(world_doty_count*WORLD_DOT_DISTANCE)+WORLD_DOT_DISTANCE/2);


        if(Math.round(cam.position.x / WORLD_DOT_DISTANCE)>=0 && Math.round(cam.position.x / WORLD_DOT_DISTANCE)< world_dotx_count)
            moveX = Math.round(cam.position.x / WORLD_DOT_DISTANCE);
        if(Math.round(cam.position.y / WORLD_DOT_DISTANCE)>=0 && Math.round(cam.position.y / WORLD_DOT_DISTANCE)<world_doty_count)
            moveY = Math.round(cam.position.y / WORLD_DOT_DISTANCE);

        target = new Vector3(pointCoordinates[moveX][moveY].x, pointCoordinates[moveX][moveY].y, 0);
        if (thumbDown){
            final float speed = Delta * 6;
            ispeed = 1.0f - speed;

            cameraPos = cam.position;


            cameraPos.scl(ispeed);
            target.scl(speed);
            cameraPos.add(target);


            cam.position.set(cameraPos);

        }




        badsprite.setPosition(cam.position.x-badsprite.getWidth()/2, cam.position.y - badsprite.getHeight()/2);









    }

    @Override
    public void show() {



    }




    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        controller.resize(width, height);
        pS.resize(width,height);

    }

    @Override
    public void hide() {

    }

    public boolean areAllTrue(ArrayList<Boolean> bools) {
        for (Boolean bool : bools) {
            if (!bool) return false;  // Return false if any element isn't true.
        }
        return true;
    }

    @Override
    public void dispose() {




        stage.dispose();



        controller.stage.dispose();
        controller.game.dispose();
        // game.font.dispose();
        pS.stage.dispose();

        texAtlas.dispose();
        skin.dispose();
        smallSkin.dispose();
        bulletHitTex.dispose();
        explosions.dispose();



    }
}