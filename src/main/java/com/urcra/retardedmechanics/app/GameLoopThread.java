package com.urcra.retardedmechanics.app;
import android.graphics.Canvas;
import android.util.Log;


public class GameLoopThread extends Thread {
    static final long FPS = 1000;
    private GameView view;
    private boolean running = false;

    public GameLoopThread(GameView view) {
        this.view = view;
    }



    public void setRunning(boolean run) {
        running = run;
    }



    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/60D;

        int ticks = 0;
        int frames = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;

        boolean shouldRender;
        long now;


        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/nsPerTick;
            lastTime = now;
            shouldRender = true;

            while(delta >= 1){
                ticks++;
                tick();
                delta-=1;
                shouldRender = true;
            }
            /*
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            if(shouldRender){
                render();
                frames++;
            }

            if(System.currentTimeMillis() - lastTimer > 1000){
                lastTimer += 1000;
                Log.d("framesdebugging", Integer.toString(ticks) + " ticks, " + Integer.toString(frames) + " frames, ");
                frames = 0;
                ticks = 0;
            }


        }
        stop();
    }

    private void tick() {
        view.tick();
    }

    private void render(){
        Canvas c = null;
        try {
            c = view.getHolder().lockCanvas();
            synchronized (view.getHolder()) {
                view.render(c);
            }
        } finally {
            if (c != null) {
                view.getHolder().unlockCanvasAndPost(c);
            }
        }

    }



/*
    @Override
    public void run() {
        long ticksPS = 1000 / FPS;
        int fpsc = 0;
        long startTime;
        long sleepTime;
        while (running) {
            Canvas c = null;
            startTime = System.currentTimeMillis();
            try {
                c = view.getHolder().lockCanvas();

                synchronized (view.getHolder()) {
                    view.render(c);
                    fpsc++;
                }
            } finally {
                if (c != null) {
                    view.getHolder().unlockCanvasAndPost(c);
                }
            }
            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0) {
                    sleep(sleepTime);
                    Log.d("ADebugTag", "Value: " + Integer.toString(fpsc));
                    fpsc=0;
                }else {
                    sleep(10);
                }
            } catch (Exception e) {}
        }
    }*/
}