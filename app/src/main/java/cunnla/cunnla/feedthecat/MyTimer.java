package cunnla.cunnla.feedthecat;

/**
 * Created by Kate on 3/28/2018.
 */

import android.os.CountDownTimer;

/**
 * Created by Kate on 3/14/2018.
 */

public class MyTimer extends CountDownTimer {

    ITickable iTickable;
    int catFace = cunnla.cunnla.feedthecat.R.drawable.cateat;
    String buttonText = "Feed the Cat!";
    long millis = 20000;


    MyTimer (long millisInFuture, long countDownInterval, ITickable iTickable) {
        super(millisInFuture, countDownInterval);
        this.iTickable = iTickable;
    }


    public void onFinish () {
       // iTickable.onTimerEvent("Finished!", cunnla.cunnla.feedthecat.R.drawable.catfinish, cunnla.cunnla.feedthecat.R.drawable.buttonfinish);
        iTickable.onTimerEvent("Restart!", cunnla.cunnla.feedthecat.R.drawable.catfinish, cunnla.cunnla.feedthecat.R.drawable.buttonfinish);
    }

    public void onTick(long millisInFuture) {
        //iTickable.onTimerEvent("Millisecond Until Finished: " + String.valueOf(millisInFuture / 1000), catFace, cunnla.cunnla.feedthecat.R.drawable.buttonfeed);
        iTickable.onTimerEvent("Feed the Cat!", catFace, cunnla.cunnla.feedthecat.R.drawable.buttonfeed);

        // Drawing the cat's face
        if  (millisInFuture > 19000)  {
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat1;
        } else
        if  ((millisInFuture > 17000) && (millisInFuture < 19000))  {
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat2;
        } else
        if  ((millisInFuture > 15000) && (millisInFuture < 17000))  {
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat3;
        } else
        if  ((millisInFuture > 13000) && (millisInFuture < 15000))  {
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat4;
        } else
        if ((millisInFuture > 10000) && (millisInFuture < 13000)){
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat5;
        } else
        if ((millisInFuture > 7000) && (millisInFuture < 10000)){
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat6;
        } else
        if ((millisInFuture > 4000) && (millisInFuture < 7000)){
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat7;
        } else
        if ((millisInFuture > 1000) && (millisInFuture < 4000)){
            catFace = cunnla.cunnla.feedthecat.R.drawable.cat8;
        } else
        if (millisInFuture < 1000) {
            catFace = cunnla.cunnla.feedthecat.R.drawable.catfinish;
        }

        // setting the timer parameter
        if ((millisInFuture > 2000) && (millisInFuture < 20000)) {
            millis = millisInFuture;
        } else
        {
            millis = 20000;  //restart on finish
        }


    }




}
