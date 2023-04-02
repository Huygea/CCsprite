package com.ccsprite.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.utils.TextureBinder;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

import levels.Level5;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.utils.Align.center;

/**
 * Created by fractal on 06.04.2017.
 */

public class ShopClass implements Screen {
final ClickClack game;
    Stage stage;
    Viewport viewport;
    OrthographicCamera camera;
    Table table;
    Image chest, bomb, sniper, oil,gold;
    static Label header, chestLabel, bombLabel, sniperLabel, oilLabel, goldLabel;
    Preferences prefs;
    static String yazi;
    float shake = 2;
    float display = 3;

    int selector, rareIndicator;
    private boolean spriteShow = true;
    private boolean awardShow  = false;

    TextButton openChest,buyOneBomb,buyOneBullet, buyOneOil, buyGold, buyTenBombs, buyTenBullets,buyTenOils;


    Image crossHair, bombC,backGroundt,hingeTex,blowtorcht
            ;
    TextureRegion uiSkin;
    Texture cratecolorful,crateblue, cratepurple,crateorange,createwhite,openedboxorange,openedboxpurple,openedboxwhite,openedboxblue;

    Label award;
    Skin skin;
    Skin smallSkin;


    TextButton.TextButtonStyle textButtonStyle;
    ShopDialog dPane;
    Random random;
    Sprite closedChest, openedChest;
    TextureAtlas texAtlas;
    public ShopClass(final ClickClack  game) {
        this.game = game;
        prefs = Gdx.app.getPreferences("My Preferences");


        textButtonStyle = new TextButton.TextButtonStyle();
        prefs.getInteger("chest", 0);
        prefs.putInteger("chest",100);
        prefs.getInteger("bomb", 5);
        prefs.getInteger("bullet", 5);
        prefs.getInteger("oil",5);
        prefs.getInteger("gold",100);

        prefs.flush();


        texAtlas = new TextureAtlas("texPacked/texPacked.atlas");


        bomb = new Image(new Texture("bomb.png"));
        backGroundt = new Image(new Texture("bg.png"));
        oil = new Image(new Texture("oil.png"));
        sniper = new Image(new Texture("sniper.png"));
        gold = new Image(new Texture("gold.png"));



        uiSkin = texAtlas.findRegion("uiskin");
        chest = new Image (new Texture("chestcolorful.png"));

        cratecolorful = new Texture("chestcolorful.png");
        createwhite = new Texture("chestwhite.png");
        crateblue = new Texture("chestblue.png");
        crateorange = new Texture("chestorange.png");
        cratepurple = new Texture("chestpurple.png");
//TODO
        openedboxblue = new Texture("openedboxblue.png");
        openedboxorange = new Texture("openedboxorange.png");
        openedboxpurple = new Texture("openedboxpurple.png");
        openedboxwhite = new Texture("openedboxwhite.png");





//SKIN AND ANIMATIONS

        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));



        skin.getFont("default-font").getData().setScale(0.1f);



        smallSkin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas("uiskin.atlas"));







        smallSkin.getFont("default-font").getData().setScale(0.05f);




        closedChest = new Sprite(cratecolorful);
        openedChest = new Sprite(openedboxwhite);

        textButtonStyle.font = smallSkin.getFont("default-font");
        textButtonStyle.downFontColor = new Color(0.2f,0.4f,0,1);
        textButtonStyle.fontColor = Color.WHITE;


        float aspectRatio = (float) (Gdx.graphics.getHeight() / Gdx.graphics.getWidth());

        // controller = new Controller(game);

        camera = new OrthographicCamera(aspectRatio * VariableCalls.WORLD_WIDTH, VariableCalls.WORLD_HEIGHT);
        camera.setToOrtho(false);
        viewport = new FitViewport(VariableCalls.WORLD_WIDTH , VariableCalls.WORLD_HEIGHT,camera );
        stage = new Stage(viewport, game.batch);

        table = new Table();
        table.setPosition(VariableCalls.WORLD_WIDTH/2 - table.getWidth()/2, VariableCalls.WORLD_HEIGHT/2 - table.getHeight()/2);




        header = new Label("WELCOME TO THE GEAR SHOP", smallSkin);
        chestLabel = new Label(String.valueOf(prefs.getInteger("chest",0)), skin);
        bombLabel = new Label(String.valueOf(prefs.getInteger("bomb",5)), skin);
        sniperLabel = new Label(String.valueOf(prefs.getInteger("bullet",5)), skin);
        oilLabel = new Label(String.valueOf(prefs.getInteger("oil",5)), skin );
        goldLabel  = new Label(String.valueOf(prefs.getInteger("gold" , 100)), skin);


        prefs.flush();
        chestLabel.setAlignment(center);
        bombLabel.setAlignment(center);
        sniperLabel.setAlignment(center);
        oilLabel.setAlignment(center);
        goldLabel.setAlignment(center);
        award = new Label("", smallSkin);
        openChest = new TextButton("Open a\nPresent", smallSkin);
        buyOneBomb = new TextButton("Buy 1", smallSkin);
        buyOneBullet = new TextButton("Buy 1", smallSkin);

        buyOneOil = new TextButton("Buy 1", smallSkin);

        buyTenBombs = new TextButton("Buy 10", smallSkin);
        buyTenBullets = new TextButton("Buy 10", smallSkin);

        buyTenOils = new TextButton("Buy 10", smallSkin);
        buyGold = new TextButton("Get More\nGold", smallSkin);


        openChest.setStyle(textButtonStyle);
        buyOneBomb.setStyle(textButtonStyle);
        buyOneBullet.setStyle(textButtonStyle);
        buyOneOil.setStyle(textButtonStyle);
        buyTenBombs.setStyle(textButtonStyle);
       buyTenBullets.setStyle(textButtonStyle);
        buyTenOils.setStyle(textButtonStyle);
        buyGold.setStyle(textButtonStyle);


        random = new Random();

        table.add(header).colspan(5).pad(5);
        table.add().row();
        table.add(chest).size(40).height(40);
        table.add(bomb).size(40).height(40);
        table.add(sniper).size(40).height(40);
        table.add(oil).size(40).height(40);
        table.add(gold).size(40).height(40);

        table.add().row();

        table.add(chestLabel).size(40).height(10).pad(5,1,1,1);
        table.add(bombLabel).size(40).height(10).pad(5,1,1,1);
        table.add(sniperLabel).size(40).height(10).pad(5,1,1,1);
        table.add(oilLabel).size(40).height(10).pad(5,1,1,1);
        table.add(goldLabel).size(40).height(10).pad(5,1,1,1);

        table.add().row();

        table.add(openChest).size(40).height(20).pad(10,0,0,0);
        table.add(buyOneBomb).size(40).height(10);
        table.add(buyOneBullet).size(40).height(10);
        table.add(buyOneOil).size(40).height(10);
        table.add(buyGold).size(40).height(20).pad(10,0,0,0);

        table.add().row();

        table.add().size(40).height(10);
        table.add(buyTenBombs).size(40).height(10);
        table.add(buyTenBullets).size(40).height(10);
        table.add(buyTenOils).size(40).height(10);
        table.add().size(40).height(10);



        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);


        stage.getRoot().getColor().a = 0;
        stage.getRoot().addAction(fadeIn(0.5f));
        buyOneBomb.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {


                if (!awardShow) {

                    if (prefs.getInteger("gold", 100) >= 10) {
                        prefs.putInteger("gold", prefs.getInteger("gold", 100) - 10);
                        prefs.putInteger("bomb", prefs.getInteger("bomb", 5) + 1);
                        prefs.flush();
                        bombLabel.setText(String.valueOf(prefs.getInteger("bomb")));
                        goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                    }


                }
            }
        });

       buyOneOil.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {


                if (!awardShow) {
                    if (prefs.getInteger("gold", 100) >= 10) {
                        prefs.putInteger("gold", prefs.getInteger("gold", 100) - 10);
                        prefs.putInteger("oil", prefs.getInteger("oil", 5) + 1);
                        prefs.flush();
                        oilLabel.setText(String.valueOf(prefs.getInteger("oil")));
                        goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                    }
                }
            }
        });


        buyOneBullet.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {


                if (!awardShow) {
                    if (prefs.getInteger("gold", 100) >= 10) {
                        prefs.putInteger("gold", prefs.getInteger("gold", 100) - 10);
                        prefs.putInteger("bullet", prefs.getInteger("bullet", 5) + 1);
                        prefs.flush();
                        sniperLabel.setText(String.valueOf(prefs.getInteger("bullet")));
                        goldLabel.setText(String.valueOf(prefs.getInteger("gold")));
                    }
                }
            }
        });

       buyTenBombs.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dPane = new ShopDialog(game);

                if (!awardShow) {
                    if (prefs.getInteger("gold", 100) >= 100) {

                        ShopDialog.dialogHeader = "Buy 10 bombs for \n100 gold?";
                        stage.addActor(dPane.quitGameConfirm(1));
                    }
                }
            }
        });

        buyTenOils.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dPane = new ShopDialog(game);

                if (!awardShow) {
                    if (prefs.getInteger("gold", 100) >= 100) {

                        ShopDialog.dialogHeader = "Buy 10 oil for 100 gold?";
                        stage.addActor(dPane.quitGameConfirm(3));
                    }
                }
            }
        });


        buyTenBullets.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                dPane = new ShopDialog(game);
                if (!awardShow) {

                    if (prefs.getInteger("gold", 100) >= 100) {
                        ShopDialog.dialogHeader = "Buy 10 bullets for \n100 gold?";
                        stage.addActor(dPane.quitGameConfirm(2));
                    }
                }

            }
        });


        openChest.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                if(prefs.getInteger("chest",0)>0 && !awardShow){

                    prefs.putInteger("chest", prefs.getInteger("chest",0)-1);
                    prefs.flush();

                    chestLabel.setText(String.valueOf(prefs.getInteger("chest")));

                if (!awardShow) {
                    selector = random.nextInt(4);
                    rareIndicator = random.nextInt(100);
                    System.out.println("RANDOM = " + selector);
                    yazi = ("Type= " + selector + "  Indicator= " + rareIndicator);
                    chestLabel.setText(String.valueOf( prefs.getInteger("chest",0)));

                    if(rareIndicator<=50)
                    {
                       closedChest.set(new Sprite(createwhite));
                       openedChest.set(new Sprite(openedboxwhite));



                    }
                        if (rareIndicator > 50 && rareIndicator <= 90)
                        {
                            closedChest.set(new Sprite(crateblue));
                            openedChest.set(new Sprite(openedboxblue));

                        }
                            if (rareIndicator > 90 && rareIndicator < 99)
                            {
                                closedChest.set(new Sprite(cratepurple));
                                openedChest.set(new Sprite(openedboxpurple));



                            }
                    if (rareIndicator == 99 || rareIndicator == 100)
                            {

                                closedChest.set(new Sprite(crateorange));
                                openedChest.set(new Sprite(openedboxorange));



                            }

                    switch (selector) {

                        case 0: {

                            if (rareIndicator <= 50) {

                                int goldAm = random.nextInt(10) + 10;
                                yazi = ("Gold + " + goldAm);

                                prefs.putInteger("gold", prefs.getInteger("gold", 100) + goldAm);
                                prefs.flush();


                            } else if (rareIndicator > 50 && rareIndicator <= 90) {

                                int goldAm = random.nextInt(20) + 20;
                                yazi = ("Gold + " + goldAm);

                                prefs.putInteger("gold", prefs.getInteger("gold", 100) + goldAm);
                                prefs.flush();


                            } else if (rareIndicator > 90 && rareIndicator < 99) {

                                int goldAm = random.nextInt(20) + 40;
                                yazi = ("Gold + " + goldAm);

                                prefs.putInteger("gold", prefs.getInteger("gold", 100) + goldAm);
                                prefs.flush();

                            } else if (rareIndicator == 99 || rareIndicator == 100) {

                                int goldAm = random.nextInt(50) + 100;
                                yazi = ("Gold + " + goldAm);

                                prefs.putInteger("gold", prefs.getInteger("gold", 100) + goldAm);
                                prefs.flush();

                            }
                            break;
                        }

                        case 1: {


                            if (rareIndicator <= 50) {

                                int goldAm = 1;
                                yazi = ("Bomb + " + goldAm);

                                prefs.putInteger("bomb", prefs.getInteger("bomb", 5) + goldAm);
                                prefs.flush();
                            } else if (rareIndicator > 50 && rareIndicator <= 90) {

                                int goldAm = random.nextInt(1) + 2;
                                yazi = ("Bomb + " + goldAm);

                                prefs.putInteger("bomb", prefs.getInteger("bomb", 5) + goldAm);
                                prefs.flush();

                            } else if (rareIndicator > 90 && rareIndicator < 99) {

                                int goldAm = random.nextInt(3) + 3;
                                yazi = ("Bomb + " + goldAm);

                                prefs.putInteger("bomb", prefs.getInteger("bomb", 5) + goldAm);
                                prefs.flush();

                            } else if (rareIndicator == 99 || rareIndicator == 100) {

                                int goldAm = 10;
                                yazi = ("Bomb + " + goldAm);

                                prefs.putInteger("bomb", prefs.getInteger("bomb", 5) + goldAm);
                                prefs.flush();

                            }

                            break;
                        }

                        case 2: {


                            if (rareIndicator <= 50) {

                                int goldAm = 1;
                                yazi = ("Oil + " + goldAm);

                                prefs.putInteger("oil", prefs.getInteger("oil", 5) + goldAm);
                                prefs.flush();
                            } else if (rareIndicator > 50 && rareIndicator <= 90) {

                                int goldAm = random.nextInt(1) + 2;
                                yazi = ("Oil + " + goldAm);

                                prefs.putInteger("oil", prefs.getInteger("oil", 5) + goldAm);
                                prefs.flush();


                            } else if (rareIndicator > 90 && rareIndicator < 99) {

                                int goldAm = random.nextInt(3) + 3;
                                yazi = ("Oil + " + goldAm);

                                prefs.putInteger("oil", prefs.getInteger("oil", 5) + goldAm);
                                prefs.flush();

                            } else if (rareIndicator == 99 || rareIndicator == 100) {

                                int goldAm = 10;
                                yazi = ("Oil + " + goldAm);

                                prefs.putInteger("oil", prefs.getInteger("oil", 5) + goldAm);
                                prefs.flush();

                            }

                            break;
                        }

                        case 3: {

                            if (rareIndicator <= 50) {

                                int goldAm = 1;
                                yazi = ("Bullet + " + goldAm);

                                prefs.putInteger("bullet", prefs.getInteger("bullet", 5) + goldAm);
                                prefs.flush();
                            } else if (rareIndicator > 50 && rareIndicator <= 90) {

                                int goldAm = random.nextInt(1) + 2;
                                yazi = ("Bullet + " + goldAm);

                                prefs.putInteger("bullet", prefs.getInteger("bullet", 5) + goldAm);
                                prefs.flush();


                            } else if (rareIndicator > 90 && rareIndicator < 99) {
                                int goldAm = random.nextInt(3) + 3;
                                yazi = ("Bullet + " + goldAm);

                                prefs.putInteger("bullet", prefs.getInteger("bullet", 5) + goldAm);
                                prefs.flush();


                            } else if (rareIndicator == 99 || rareIndicator == 100) {

                                int goldAm = 10;
                                yazi = ("Bullet + " + goldAm);

                                prefs.putInteger("bullet", prefs.getInteger("bullet", 5) + goldAm);
                                prefs.flush();

                            }


                            break;
                        }


                    }

                    awardShow = true;
                }
            }

            }
        });
    }



    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {



        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());

if(awardShow){
        if(spriteShow){

            game.batch.begin();

            closedChest.setSize(120, 120*0.886f );
            closedChest.setPosition(VariableCalls.WORLD_WIDTH/2 - closedChest.getWidth()/2, VariableCalls.WORLD_HEIGHT/2 - closedChest.getHeight()/2);
            closedChest.draw(game.batch);
            shake -= delta;
            closedChest.setOrigin(closedChest.getWidth()/2,closedChest.getHeight()/2);
            closedChest.setRotation((float)Math.sin(10000*delta));

            game.batch.end();
        }


        if(shake<0) {

            spriteShow = false;
            game.batch.begin();

            display -= delta;
            openedChest.setSize(150, 150*0.97f);
            openedChest.setPosition(VariableCalls.WORLD_WIDTH / 2 - openedChest.getWidth() / 2, VariableCalls.WORLD_HEIGHT / 2 - openedChest.getHeight() / 2);
            openedChest.draw(game.batch);
            award.setPosition(openedChest.getX() + openedChest.getWidth()/2 - 10, openedChest.getY()+openedChest.getHeight()/2);
            award.setText(yazi);
            closedChest.setRotation(0);

            award.draw(game.batch, 1);

            game.batch.end();

            if (display < 0) {

                oilLabel.setText(String.valueOf(prefs.getInteger("oil",5)));
                bombLabel.setText(String.valueOf(prefs.getInteger("bomb",5)));


                sniperLabel.setText(String.valueOf(prefs.getInteger("bullet",5)));
                goldLabel.setText(String.valueOf(prefs.getInteger("gold",100)));

                prefs.flush();
                shake = 2;
                display = 3;

                awardShow = false;
                spriteShow = true;

            }
        }
        }


        camera.update();
        if(Gdx.input.isKeyJustPressed(Input.Keys.BACK) && !awardShow && VariableCalls.buttonCheck){


            switchScreen(game, new MainMenuScreen(game));


            VariableCalls.buttonCheck =false;

        }

    }



    public void switchScreen(final ClickClack game, final Screen newScreen){
        stage.getRoot().getColor().a = 1;
        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(fadeOut(0.5f));
        sequenceAction.addAction(run(new Runnable() {
            @Override
            public void run() {
                game.setScreen(newScreen);
                VariableCalls.buttonCheck =true;
                dispose();

            }
        }));
        stage.getRoot().addAction(sequenceAction);

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
        texAtlas.dispose();
    }
}
