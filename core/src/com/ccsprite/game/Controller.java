package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import levels.Level1;

import static com.ccsprite.game.MyActorKucuk.nextGear;
import static com.ccsprite.game.VariableCalls.WORLD_HEIGHT;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;
import static com.ccsprite.game.VariableCalls.fadeOut;
import static com.ccsprite.game.VariableCalls.world_doty_count;


public class Controller extends Stage {

    public Viewport viewport;
    public Stage stage;
    boolean crosshairPressed,upPressed, downPressed, leftPressed, rightPressed,buttonPressed,uiElementsPressed,gearPressed,blowtorchPressed;
    OrthographicCamera camera;
    public Label bombCount,bulletCount,oilCount,goldCount;
    public Table winTable, loseTable;
    private TextButton resButton, nextLevel, lSelection,resButton2,lSelection2;




    Image buttonA;
    public Image crossHair;
    public Sprite whiteBox;
    Image timer;
    public Image bombImg;
    public Image gearImg;
    public Image blowtorchImg;
    Table button;
    MyActorKucuk actor;
   public boolean winCond = false;
    public boolean loseCond = false;
    Image winSprite;
    public int gold;
    Image loseSprite;
    Preferences prefs;
   public Table uiElements;
    public boolean timerCheck = true;
    ScreenEnum scE;


    TextureRegion dark,star,buttonC,timerC,whiteBoxC,one,crossHairC,crate,openChest, explosion,youLose,kucuk,orta,buyuk,bomb,kucuk1,orta1,buyuk1,backGroundt,hingeTex,youwinT,blowtorcht,creatureTexture
            ;
    TextureRegion uiSkin;


    Skin skin;
    Skin smallSkin;

    public final ClickClack game;
    Vector2 touch, newTouch;
    int selector;
    private TextureAtlas texAtlas;

    public boolean isCrosshairPressed() {
        return crosshairPressed;
    }

    @Override
    public void dispose() {


        skin.dispose();
        smallSkin.dispose();
        texAtlas.dispose();
        stage.dispose();
    }

    public  Controller (final ClickClack game){





        this.game=game;
        prefs = Gdx.app.getPreferences("My Preferences");
        actor =new MyActorKucuk(game);


        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");
        kucuk = texAtlas.findRegion("kucuktamam");
        orta = texAtlas.findRegion("ortatamam");
        buyuk = texAtlas.findRegion("BuyukDisliTamamdir");
        bomb = texAtlas.findRegion("bomb");
        kucuk1 = texAtlas.findRegion("kucuksteampunk");
        orta1 = texAtlas.findRegion("ortasteampunk");
        buyuk1 = texAtlas.findRegion("buyuksteampunk");
        backGroundt = texAtlas.findRegion("background");
        hingeTex = texAtlas.findRegion("hinge");
        youwinT = texAtlas.findRegion("youwin");
        blowtorcht = texAtlas.findRegion("blowtorch");
        creatureTexture = texAtlas.findRegion("cyclops");
        youLose = texAtlas.findRegion("youLose");
        explosion = texAtlas.findRegion("explosion");
        one = texAtlas.findRegion("one");
        whiteBoxC = texAtlas.findRegion("timerWhiteBox");
        timerC = texAtlas.findRegion("timer");
        buttonC = texAtlas.findRegion("button");
        dark = texAtlas.findRegion("dark");


        star = texAtlas.findRegion("star");

        openChest = texAtlas.findRegion("openCrate");




        uiSkin = texAtlas.findRegion("uiskin");






        crate = texAtlas.findRegion("crate");



        crossHairC = texAtlas.findRegion("crosshair");



//SKIN AND ANIMATIONS

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.2f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.1f);





        bombCount = new Label(String.valueOf(prefs.getInteger("bomb",5)), smallSkin);
        bulletCount = new Label(String.valueOf(prefs.getInteger("bullet",5)), smallSkin);

        scE = new ScreenEnum(game);
        touch = new Vector2();
        winTable = new Table();
        loseTable = new Table();
        resButton = new TextButton("Restart", smallSkin);
        resButton2 = new TextButton("Restart", smallSkin);
        newTouch = new Vector2(0,0);

        lSelection2 = new TextButton("Level \nSelection", smallSkin);

        nextLevel = new TextButton("Next \nLevel", smallSkin);
        lSelection = new TextButton("Level \nSelection", smallSkin);
        oilCount = new Label(String.valueOf(prefs.getInteger("oil",5)), smallSkin);

        goldCount = new Label(String.valueOf("Gold " + prefs.getInteger("gold",100)), smallSkin);


        prefs.flush();
        winSprite = new Image(youwinT);
        loseSprite = new Image(youLose);
        gold = prefs.getInteger("gold", 100);
        game.font.getData().setScale(0.3f);

        winTable.add(winSprite).pad(5).size(60,60).colspan(3);
        winTable.row().pad(5);
        winTable.add(nextLevel).size(50,20).pad(4);

        winTable.add(resButton).size(50,20).pad(4);
        winTable.add(lSelection).size(50,20).pad(4);

        winTable.debug();


        loseTable.add(loseSprite).pad(5).size(60,60).colspan(3);
        loseTable.row().pad(5);
        loseTable.add(resButton2).size(50,20).pad(4);
        loseTable.add();
        loseTable.add(lSelection2).size(50,20).pad(4);

        loseTable.debug();

        camera = new OrthographicCamera();
        viewport = new FitViewport(VariableCalls.WORLD_WIDTH,VariableCalls.WORLD_HEIGHT, camera);
        stage = new Stage(viewport, game.batch);


        Gdx.input.setInputProcessor(stage);
        Table timerTable = new Table();
        Table table = new Table();

        table.left().bottom();

        button =new Table();
        uiElements = new Table();

        if(prefs.getBoolean("side", true))
        {
            uiElements.setPosition(15, VariableCalls.WORLD_HEIGHT/2);
            button.setPosition(15,15);
            prefs.flush();
        }

        else{
            uiElements.setPosition(WORLD_WIDTH - 15, VariableCalls.WORLD_HEIGHT/2);
            button.setPosition(viewport.getWorldWidth() - 15,15);
            prefs.flush();
        }
        button.setName("button");



            buttonA = new Image(buttonC);
            bombImg = new Image (bomb);
            gearImg = new Image(kucuk1);

            blowtorchImg =new Image(blowtorcht);

            whiteBox = new Sprite(whiteBoxC);
            timer = new Image(timerC);
            crossHair = new Image(crossHairC);












        gearImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gearPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                VariableCalls.buttonCheck = true;
                gearPressed = false;

            }
        });


        blowtorchImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               blowtorchPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                VariableCalls.buttonCheck = true;
                blowtorchPressed = false;

            }
        });

        bombImg.addListener(new InputListener() {


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                uiElementsPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                VariableCalls.buttonCheck  =true;
                uiElementsPressed = false;
            }





        });



        crossHair.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                crosshairPressed = true;
                return true;


            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                VariableCalls.buttonCheck = true;
                crosshairPressed = false;
            }
        });

        buttonA.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {






                buttonPressed = true;






                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                VariableCalls.buttonCheck  =true;
                buttonPressed = false;
            }
        });

/*
        upImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return  true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                upPressed = false;
            }
        });

        downImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                return  true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        });

        leftImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return  true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });

        rightImg.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return  true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });
*/

        button.add();
        button.add(buttonA).size(30,30);
        button.add();

        stage.addActor(button);

       // timerTable.add(timer).size(25,10);
       // timerTable.add().pad(0,5,0,5);
        timerTable.add().pad(5);
        timerTable.add(timer).size(15, whiteBox.getHeight());

        timerTable.add().pad(5);
        whiteBox.setSize((1/VariableCalls.timeDivider)*VariableCalls.timeLeft * 100, 10 );
        whiteBox.setPosition(WORLD_WIDTH/2 - 50, WORLD_HEIGHT-125);

        timerTable.setPosition(whiteBox.getX()-10,whiteBox.getY() + 5);
        timerTable.setName("timer");


        stage.addActor(timerTable);







        uiElements.add(blowtorchImg).size(16,16).pad(1);
        uiElements.add(oilCount);
        uiElements.add().row();

        uiElements.add(crossHair).size(16,16).pad(1);
        uiElements.add(bulletCount);
        uiElements.add().row();


        uiElements.add(bombImg).size(16,16).pad(1);
        uiElements.add(bombCount);
        uiElements.add().row();

        uiElements.add(gearImg).size(16,16).pad(1);

        stage.addActor(uiElements);

        uiElements.setName("uiElements");


       // uiElements.setPosition(VariableCalls.WORLD_WIDTH/2, VariableCalls.WORLD_HEIGHT-125);
/*
winSprite.setSize(WORLD_WIDTH/4, WORLD_HEIGHT/4);
    winSprite.setPosition(WORLD_WIDTH/2 - winSprite.getWidth()/2, WORLD_HEIGHT/2 - winSprite.getHeight()/2);


        loseSprite.setSize(WORLD_WIDTH/4, WORLD_HEIGHT/4);
       loseSprite.setPosition(WORLD_WIDTH/2 - winSprite.getWidth()/2, WORLD_HEIGHT/2 - winSprite.getHeight()/2);
*/

        stage.addActor(actor);

        nextGear.setPosition(15 - nextGear.getWidth()/2, VariableCalls.WORLD_HEIGHT-15 - nextGear.getHeight()/2);


        winTable.setPosition(viewport.getWorldWidth()/2 - winTable.getWidth()/2, viewport.getWorldHeight()/2 - winTable.getHeight()/2);

        loseTable.setPosition(viewport.getWorldWidth()/2 - loseTable.getWidth()/2, viewport.getWorldHeight()/2 - loseTable.getHeight()/2);



        resButton.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5)){

                    selector = 1;
                    VariableCalls.gameEnd = true;

                }

            }
        });

        resButton2.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5)){

                    selector = 1;
                    VariableCalls.gameEnd = true;



                }

            }
        });
       nextLevel.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5)){
                    selector = 3 ;

                    VariableCalls.gameEnd = true;


                }

            }
        });
       lSelection2.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5)){

                    selector = 2;
                    VariableCalls.gameEnd = true;


                }


            }
        });

        lSelection.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);

                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if((Math.abs(newTouch.x - touch.x)<5 ||Math.abs(newTouch.y - touch.y)<5)){

                    selector = 2;
                    VariableCalls.gameEnd = true;


                }


            }
        });

    }



    public void draw(){


        stage.draw();
        game.batch.begin();

        prefs.flush(


        );




        if(timerCheck)
        whiteBox.draw(game.batch);


        if(winCond){

            actor.remove();



        }

        if(VariableCalls.fadeOut >300){


            switch (selector){



                case 1: {



                    VariableCalls.fadeOut =0;
                    VariableCalls.gameEnd = false;
                    game.getScreen().dispose();

                    game.setScreen(scE.levelSwitcher(VariableCalls.levelNum, game));
                      //  game.setScreen(new MainMenuScreen(game));
                    break;


                }

                case 2:{

                    VariableCalls.fadeOut =0;
                    VariableCalls.gameEnd = false;
                    game.getScreen().dispose();

                    game.setScreen(new LevelSelection(game));
                    //  game.setScreen(new MainMenuScreen(game));
                    break;

                }
                case 3:{

                    VariableCalls.fadeOut =0;
                    VariableCalls.gameEnd = false;
                    game.getScreen().dispose();

                    game.setScreen(scE.levelSwitcher(VariableCalls.levelNum+1, game));


                }

                default:{break;}

            }

        }

        if(loseCond){

            actor.remove();
        }

        game.batch.end();

    }

    public  void resize(int width, int height){

        viewport.update(width,height);
    }






    public boolean isButtonPressed() {
        return buttonPressed;
    }


    public boolean isUiElementsPressed() {
        return uiElementsPressed;
    }

    public boolean isGearPressed() {
        return gearPressed;
    }

    public boolean isBlowtorchPressed() {
        return blowtorchPressed;
    }
}

