package com.urcra.retardedmechanics.app;
import android.content.Context;

import android.graphics.Bitmap;

import android.graphics.BitmapFactory;

import android.graphics.Canvas;

import android.graphics.Color;

import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import android.view.SurfaceView;

import com.urcra.retardedmechanics.app.entities.BulletController;
import com.urcra.retardedmechanics.app.entities.CircleEnemyController;
import com.urcra.retardedmechanics.app.entities.EnemySpawner;
import com.urcra.retardedmechanics.app.entities.Player;
import com.urcra.retardedmechanics.app.entities.PowerupController;
import com.urcra.retardedmechanics.app.entities.TerrainController;
import com.urcra.retardedmechanics.app.gfx.Background;
import com.urcra.retardedmechanics.app.gfx.ImageLoader;
import com.urcra.retardedmechanics.app.gfx.ImageManager;
import com.urcra.retardedmechanics.app.gfx.SpriteSheet;


public class GameView extends SurfaceView {

    private Bitmap bmp;
    private Paint paint;
    private SurfaceHolder holder;
    private GameLoopThread gameLoopThread;
    private Sprite sprite;
    private static Renderer renderer;
    private Bitmap spriteSheet;

    private ImageManager im;

    private static Player player;
    private static BulletController bc;
    private static Background background;
    private static CircleEnemyController cec;
    private static EnemySpawner espawn;
    private static CollisionDetecter coldet;
    private static ScoreCounter score;
    private static PowerupController puc;
    private static TerrainController tec;

    public static int HEIGHT = 200, WIDTH = 200, SCALE = 2;
    private long lastShot;
    private long lastTouch;
    private boolean isset = false;



    public GameView(Context context) {

        super(context);

        gameLoopThread = new GameLoopThread(this);

        holder = getHolder();


        holder.addCallback(new SurfaceHolder.Callback() {


            @Override

            public void surfaceDestroyed(SurfaceHolder holder) {

                boolean retry = true;

                gameLoopThread.setRunning(false);

                while (retry) {

                    try {

                        gameLoopThread.join();

                        retry = false;

                    } catch (InterruptedException e) {

                    }

                }

            }


            @Override

            public void surfaceCreated(SurfaceHolder holder) {

                gameLoopThread.setRunning(true);

                gameLoopThread.start();

            }


            @Override

            public void surfaceChanged(SurfaceHolder holder, int format,

                                       int width, int height) {
            }

        });

        //init();

        /*

        Delete this!

        */

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        sprite = new Sprite(this,bmp);

        renderer = new Renderer();

    }

    public static Renderer getRenderer(){
        return renderer;
    }

    private void init() {
        ImageLoader loader = new ImageLoader();
        spriteSheet = loader.load(this.getResources(),R.drawable.spritesheet);

        SpriteSheet ss = new SpriteSheet(spriteSheet);

        im = new ImageManager(ss);

        player = new Player(50, 30, im);
        bc = new BulletController(im);
        background = new Background(im);
        cec = new CircleEnemyController(im);
        puc = new PowerupController(im);
        tec = new TerrainController(im);
        coldet = new CollisionDetecter(player, bc, cec, puc, tec);
        espawn = new EnemySpawner(im, cec, puc, tec);
        score = new ScoreCounter();

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(16);
    }


    protected void render(Canvas canvas) {

        if (isset == false){
            this.WIDTH = canvas.getWidth();
            this.HEIGHT = canvas.getHeight();
            this.SCALE = 2;
            this.isset = true;
            init();
            im.initimg(SCALE);
        }

        canvas.drawColor(Color.BLACK);
        sprite.render(canvas);
        background.render(canvas);
        player.render(canvas);
        bc.render(canvas);
        cec.render(canvas);
        puc.render(canvas);
        tec.render(canvas);
        score.render(paint, canvas);




    }

    public void tick(){
        player.tick();
        bc.tick();
        background.tick();
        cec.tick();
        puc.tick();
        tec.tick();
        espawn.tick();
        coldet.tick();
    }


    // CONTROL MANAGING Jump and shoot seperate
    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (true) {
            synchronized (getHolder()) {
                    if ((event.getX() <= WIDTH/2 ) && System.currentTimeMillis() - lastTouch > 100) {
                        player.jump();
                        lastTouch = System.currentTimeMillis();
                }else if (event.getX() >= WIDTH/2 && System.currentTimeMillis() - lastShot > 50){
                        player.shoot();
                        lastShot = System.currentTimeMillis();
                    }
            }
        }
        return true;
    }
    */
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (true){
            synchronized (getHolder()){
                if (System.currentTimeMillis() - lastTouch > 100){
                    player.jump();
                    player.shoot();
                    lastTouch = System.currentTimeMillis();
                }
            }
        }
        return true;
    }

    public static Player getPlayer(){
        return player;
    }
    public static BulletController getBullets(){
        return bc;
    }
    public static Background getBack(){
        return background;
    }
    public static CircleEnemyController getCec(){
        return cec;
    }
    public static PowerupController getPuc(){
        return puc;
    }
    public static TerrainController getTec(){
        return tec;
    }
    public static EnemySpawner getSpawner(){
        return espawn;
    }
    public static ScoreCounter getscorecounter(){
        return score;
    }




}