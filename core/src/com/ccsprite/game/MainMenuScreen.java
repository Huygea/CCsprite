package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;

/**
 * Created by fractal on 16.03.2017.
 */

public class MainMenuScreen implements Screen {


    Preferences prefs;
    Stage stage;
    Viewport viewport;
    private Image options,  exit, play,shop,backgroundmain;

    private TextureAtlas tAtlas;
    private Vector2 newTouch,touch;
    Sound click;
    Sprite loaderGear;






    final ClickClack game;

    OrthographicCamera camera;

    DialogPane dPane;



    public MainMenuScreen(final ClickClack game){
        input.setCatchBackKey(true);
        this.game=game;







        newTouch = new Vector2();
        touch = new Vector2();


        tAtlas = new TextureAtlas("texPacked/packMan.atlas");
        options =new Image( tAtlas.findRegion("options"));
        exit = new Image(tAtlas.findRegion("exit"));
        play =new Image( tAtlas.findRegion("play"));
        shop = new Image(tAtlas.findRegion("shop"));
        backgroundmain = new Image(tAtlas.findRegion("backgroundmain"));




        loaderGear = new Sprite(tAtlas.findRegion("loadingGear"));

        loaderGear.setOrigin(loaderGear.getWidth()/2, loaderGear.getHeight()/2);
        loaderGear.setScale(0.3f);

        loaderGear.setPosition(0,0);




        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
        prefs = Gdx.app.getPreferences("My Preferences");
        prefs.getInteger("chest",0);
        prefs.getInteger("bomb", 5);
        prefs.getInteger("oil",5);
        prefs.getInteger("bullet",5);
        prefs.getInteger("gold",100);


        prefs.flush();


        camera = new OrthographicCamera(aspectRatio * WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        camera.setToOrtho(false);


        dPane = new DialogPane(game);

        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);
        input.setInputProcessor(stage);


        backgroundmain.setSize(VariableCalls.WORLD_WIDTH,VariableCalls.WORLD_HEIGHT);
        options.setSize(48.5f,49);
        exit.setSize(48,49);
        play.setSize(48,49);
        shop.setSize(48,49);



        System.out.println(options.getWidth() + "   " + options.getHeight() + "  ex" + exit.getWidth()+"  "+ exit.getHeight()+"   pl" + play.getWidth()+"   "+play.getHeight() + "  sh" + shop.getWidth()+  "  "+shop.getHeight());


        click = Gdx.audio.newSound(Gdx.files.internal("click.mp3"));


        play.setPosition(55-play.getWidth()/2,65-play.getHeight()/2);
        play.setOrigin(play.getWidth()/2,play.getHeight()/2);

        shop.setPosition(105-shop.getWidth()/2, 87-shop.getHeight()/2);
        shop.setOrigin(shop.getWidth()/2,shop.getHeight()/2);

        options.setPosition(155-options.getWidth()/2, 65-options.getHeight()/2);
        options.setOrigin(options.getWidth()/2, options.getHeight()/2);

        exit.setPosition(204-exit.getWidth()/2, 85-exit.getHeight()/2);
        exit.setOrigin(exit.getWidth()/2,exit.getHeight()/2);



        shop.setScale(0.98f);
        shop.setScale(1/0.98f);


       play.setScale(0.98f);
        play.setScale(1/0.98f);


        options.setScale(0.98f);
        options.setScale(1/0.98f);


        exit.setScale(0.98f);
        exit.setScale(1/0.98f);


//To Start a Task:

        backgroundmain.setPosition(0,0);


        exit.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


               exit.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                exit.setScale(1f/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 && Math.abs(newTouch.y - touch.y)<20) )

                {


                    stage.addActor(dPane.quitGameConfirm(0));


                }

            }
        });
        shop.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


               shop.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                shop.setScale(1/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {


                    switchScreen(game, new ShopClass(game));


                }

            }
        });
        play.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


                play.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                play.setScale(1f/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {


                    switchScreen(game,new LevelSelection(game));


                }

            }
        });

        options.addListener(new InputListener(){

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {

                newTouch = new Vector2(x,y);

            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                touch.set(x,y);


                options.setScale(0.98f);
                click.play(1.0f);


                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                click.play(1.0f);

                options.setScale(1f/0.98f);

                if((Math.abs(newTouch.x - touch.x)<20 &&Math.abs(newTouch.y - touch.y)<20) )

                {



                    switchScreen(game, new OptionsMenu(game));

                }

            }
        });





        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));

        stage.addActor(backgroundmain);
        stage.addActor(play);
        stage.addActor(options);

        stage.addActor(exit);
        stage.addActor(shop);

    }
    @Override
    public void render(float delta){



            Gdx.gl.glClearColor(0, 0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

      camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        stage.draw();

        game.batch.begin();






        game.batch.end();


        stage.act();

        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK) && VariableCalls.buttonCheck){


            stage.addActor(dPane.quitGameConfirm(0));



        }



    }
    public void switchScreen(final ClickClack game, final Screen newScreen){




        stage.getRoot().getColor().a = 1;
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(fadeOut(0.5f));

/*
        if(stage.getRoot().getColor().a  <=  0.30f) {
            bigGear.setAlpha(stage.getRoot().getColor().a);
            smallGear.setAlpha(stage.getRoot().getColor().a);

        }*/
        sequenceAction.addAction(run(new Runnable() {
            @Override
            public void run() {
                game.setScreen(newScreen);
                dispose();

            }
        }));
        stage.getRoot().addAction(sequenceAction);

    }


    @Override
    public void show() {
    }



    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);


    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        tAtlas.dispose();
        click.dispose();

        stage.dispose();
        //tileSkin.dispose();
        //skinDialog.dispose();



    }


}
