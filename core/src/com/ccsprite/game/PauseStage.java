package com.ccsprite.game;
/*
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.ccsprite.game.VariableCalls.WORLD_HEIGHT;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;


public class PauseStage {

    Viewport viewport;
    public Stage stage;
    OrthographicCamera camera;
   public static Label dragPoint;
    public static Label uiSide;

    Preferences prefs;
    String stringA;
    public final ClickClack game;
    Image ui, opt, drag, sag1, sol1,sag2,sol2;
    Table optionsTable;
    public boolean rightPressed = false;

    private boolean leftPressed = false;
    public boolean psButtonCheck = true;
    private boolean rightSide = false;
    private boolean leftSide = false;
    String stringR,stringL;


    public boolean isRightSide() {
        return rightSide;
    }

    public boolean isLeftSide() {
        return leftSide;
    }

    public PauseStage(final ClickClack game) {
        this.game = game;
        prefs = Gdx.app.getPreferences("My Preferences");




        stringA = String.valueOf(prefs.getInteger("dragValue", 6));
        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());


        stringL = prefs.getString("Left", "Left");
        prefs.flush();
        camera = new OrthographicCamera(aspectRatio * WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        viewport = new FitViewport(VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_HEIGHT, camera);
        stage = new Stage(viewport, game.batch);


        dragPoint = new Label(stringA , skin);


        uiSide = new Label(stringL, skin);

        ui = new Image(uiAlign);
        opt = new Image(options);
        drag = new Image(dragspeed);

        sag1 = new Image(sagok);

        sol1 = new Image(solok);

        sag2 = new Image(sagok);

        sol2 = new Image(solok);
        optionsTable = new Table();

        optionsTable.setOrigin(optionsTable.getWidth()/2, optionsTable.getHeight()/2);

        optionsTable.setPosition(WORLD_WIDTH/2, WORLD_HEIGHT/2);




        optionsTable.add().size(10).height(20);
        optionsTable.add(opt).size(50).height(20);

        optionsTable.add().size(10).height(20);

        optionsTable.add().pad(5).row();

        optionsTable.add(drag).size(40).height(20);
        optionsTable.add();
        optionsTable.add(sag1).size(40).height(20);
        optionsTable.add(dragPoint).size(40).height(20);
        optionsTable.add(sol1).size(40).height(20);
        optionsTable.add().pad(5).row();
        optionsTable.add(ui).size(40).height(20);
        optionsTable.add();
        optionsTable.add(sag2).size(40).height(20);
        optionsTable.add(uiSide).size(40).height(20);
        optionsTable.add(sol2).size(40).height(20);

        stage.addActor(optionsTable);
        optionsTable.setName("options");




        Gdx.input.setInputProcessor(stage);



       sag1.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                System.out.println("touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
                psButtonCheck = true;
            }
        });

        sol1.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                System.out.println("touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
                psButtonCheck = true;
            }
        });


        sag2.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightSide = true;
                System.out.println("touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightSide = false;
                psButtonCheck = true;
            }
        });

        sol2.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftSide = true;
                System.out.println("touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftSide = false;
                psButtonCheck = true;
            }
        });



    }



    public boolean isLeftPressed() {
        return leftPressed;
    }

    public  void resize(int width, int height){

        viewport.update(width,height);
    }
    public void draw() {



        stage.draw();
        game.batch.begin();

        game.font.draw(game.batch,"LABEL", 10,10);

        game.batch.end();


    }


    public boolean isRightPressed() {
        return rightPressed;
    }
}
*/

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.ccsprite.game.VariableCalls.WORLD_HEIGHT;
import static com.ccsprite.game.VariableCalls.WORLD_WIDTH;



/**
 * Created by fractal on 03.04.2017.
 */

public class PauseStage implements Screen {


    public static Stage stage;
    Viewport viewport;
    OrthographicCamera camera;
    Preferences prefs;
    String stringA;
    String stringL;
    Label dragPoint,uiSide,opt,dragSpeed,buttonAlign;
    Table optionsTable;
    TextButton.TextButtonStyle textButtonStyle;
    TextButton leftSpeed,rightSpeed,leftUi,rightUi, resume, quit,restart;
    Controller controller;
    final ClickClack game;
    TextureRegion uiSkin;

 

    Skin skin;
    Skin smallSkin;
    public PauseStage(final ClickClack game) {

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.2f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        smallSkin.getFont("default-font").getData().setScale(0.1f);


        this.game = game;
        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());

        // controller = new Controller(game);

        camera = new OrthographicCamera(aspectRatio * VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        camera.setToOrtho(false);
        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);


        textButtonStyle = new TextButton.TextButtonStyle();

        Gdx.input.setInputProcessor(stage);




        prefs = Gdx.app.getPreferences("My Preferences");


        stringA = "  "+String.valueOf(prefs.getInteger("dragValue", 6));


        stringL = prefs.getString("Left", "Left");
        prefs.flush();



        textButtonStyle.font = smallSkin.getFont("default-font");
        textButtonStyle.downFontColor = new Color(0.2f,0.4f,0,1);
        textButtonStyle.fontColor = Color.YELLOW;



        leftSpeed = new TextButton("<", skin);
        rightSpeed = new TextButton(">", skin);

        leftUi = new TextButton("<", skin);

        rightUi = new TextButton(">", skin);
        restart = new TextButton("Restart", skin);

        quit = new TextButton("Quit", smallSkin);

        resume = new TextButton("Back", smallSkin);

        leftSpeed.setStyle(textButtonStyle);
        rightSpeed.setStyle(textButtonStyle);

        rightUi.setStyle(textButtonStyle);
        leftUi.setStyle(textButtonStyle);

        quit.setStyle(textButtonStyle);
        restart.setStyle(textButtonStyle);

        resume.setStyle(textButtonStyle);



        controller = new Controller(game);




        uiSide = new Label(stringL, smallSkin);
        dragPoint = new Label(stringA, smallSkin);
        opt = new Label("Options", smallSkin);
        dragSpeed = new Label("Drag Sensitivity", smallSkin);
        buttonAlign = new Label("UI Alignment", smallSkin);



        optionsTable = new Table();

        optionsTable.setOrigin(optionsTable.getWidth()/2, optionsTable.getHeight()/2);

        optionsTable.setPosition(WORLD_WIDTH/2, WORLD_HEIGHT/2);

        optionsTable.center();




        optionsTable.add().size(10).height(20);
        optionsTable.add(opt).size(50).height(20);

        optionsTable.add().size(10).height(20);

        optionsTable.add().pad(5).row();

        optionsTable.add(dragSpeed).size(30).height(20);
        optionsTable.add();
        optionsTable.add(leftSpeed).size(10).height(20);
        optionsTable.add(dragPoint).size(30).height(20).center();
        optionsTable.add(rightSpeed).size(10).height(20);
        optionsTable.add().row();
        optionsTable.add(buttonAlign).size(30).height(20);
        optionsTable.add();


        optionsTable.add(leftUi).size(10).height(20);
        optionsTable.add(uiSide).size(30).height(20).center();
        optionsTable.add(rightUi).size(10).height(20);


        optionsTable.add().row();

        optionsTable.add(resume).size(30).height(20).center();
        optionsTable.add(restart).size(30).height(20).center();
        optionsTable.add();

        optionsTable.add(quit).size(30).height(20).center();

        stage.addActor(optionsTable);
        optionsTable.setName("options");




        Gdx.input.setInputProcessor(stage);

        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));

        leftSpeed.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {



                System.out.println("touched");
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (prefs.getInteger("dragValue", 6) >1 ) {

                    prefs.putInteger("dragValue", prefs.getInteger("dragValue", 6) - 1);
                    prefs.flush();
                    dragPoint.setText("  "+String.valueOf(prefs.getInteger("dragValue",6)));

                    prefs.flush();

                }

            }
        });

        rightSpeed.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (prefs.getInteger("dragValue", 6) <10 ) {

                    controller.stage.getRoot().findActor("button").setPosition(15,15);




                    prefs.putInteger("dragValue", prefs.getInteger("dragValue", 6) + 1);
                    prefs.flush();
                    dragPoint.setText("  "+String.valueOf(prefs.getInteger("dragValue",6)));

                    prefs.flush();

                }
            }
        });


        leftUi.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                prefs.putBoolean("side",true);
                prefs.flush();
   //controller.stage.getRoot().findActor("button").setPosition(15,15);
                //controller.stage.getRoot().findActor("uiElements").setPosition(15, VariableCalls.WORLD_HEIGHT/2);
                prefs.flush();
                prefs.putString("Left", "Left");
                prefs.flush();
                uiSide.setText(prefs.getString("Left"));

            }
        });


        resume.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                EnumClass.state = EnumClass.State.RUN;

            }
        });
        rightUi.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                prefs.putBoolean("side",false);
                prefs.flush();


                //  controller.stage.getRoot().findActor("button").setPosition(WORLD_WIDTH - 15,15);
                //    controller.stage.getRoot().findActor("uiElements").setPosition(WORLD_WIDTH - 15, VariableCalls.WORLD_HEIGHT/2);
//
                prefs.flush();
                prefs.putString("Left", "Right");

                prefs.flush();
                uiSide.setText(prefs.getString("Left"));

            }
        });

        quit.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                DialogPane dPane = new DialogPane(game);
                stage.addActor(dPane.quitGameConfirm(1));


            }
        });


       restart.addListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                DialogPane dPane = new DialogPane(game);
                stage.addActor(dPane.quitGameConfirm(2));


            }
        });


    }

    @Override
    public void show() {

    }
    public void switchScreen(final ClickClack game, final Screen newScreen){
        stage.getRoot().getColor().a = 1;
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(fadeOut(0.5f));
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
    public void render(float delta) {

        game.batch.begin();



        game.batch.end();

        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

        camera.update();
    }

    @Override
    public void resize(int width, int height) {

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

        stage.dispose();
        skin.dispose();
        smallSkin.dispose();
    }
}
