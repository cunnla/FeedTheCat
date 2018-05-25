package cunnla.cunnla.feedthecat;
import android.content.ClipData;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener, ITickable {


    TextView countText;   // this will show how many seconds remains on the timer
    TextView todoText;    // this is just an information text on the screen telling the user what to do
    ImageView imageCat;
    ImageView imageFish;
    MyTimer myTimer;
    long millis = 20000;

    private static final String TAG = "myLogs";


    public void onTimerEvent(String s, int catFace, int feedButtonImage){
       // countText.setText(s);
        todoText.setText(s);
        imageCat.setImageResource(catFace);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cunnla.cunnla.feedthecat.R.layout.activity_main);

        // find all the views
        countText = (TextView) findViewById(cunnla.cunnla.feedthecat.R.id.countText);
        todoText = (TextView) findViewById(cunnla.cunnla.feedthecat.R.id.todoText);
        imageCat = (ImageView) findViewById(cunnla.cunnla.feedthecat.R.id.imageCat);
        imageFish = (ImageView) findViewById(cunnla.cunnla.feedthecat.R.id.imageFish);

        // присвоим обработчики для картинок: рыбы и кота
        imageFish.setOnTouchListener(this);
        imageCat.setOnDragListener(this);

    }

    @Override
    public boolean onDrag(View v, DragEvent dragEvent) {

        final int action = dragEvent.getAction();

        switch(action) {
            case DragEvent.ACTION_DRAG_STARTED:
                // cancel the old countDownTimer. The cat opens the mouth
                if(myTimer!=null){
                    millis = myTimer.millis;
                    myTimer.cancel();
                    Log.d(TAG, "Timer has stopped");
                }
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                //if the cat gets the fish, we create a new timer with a bigger time
                myTimer = new MyTimer(millis+1000, 1000, MainActivity.this);
                myTimer.start();
                Log.d(TAG, "Timer has started");
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                //if the cat does not get the fish, we create a new timer with the same time
                if (!dragEvent.getResult()) {   //if the drag result is false
                    Log.d(TAG, "getResult is working");
                    myTimer = new MyTimer(millis, 1000, MainActivity.this);
                    myTimer.start();
                }
                break;
            default:
                break;
        }
        return true;

    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(imageFish);
            imageFish.startDrag(data, shadowBuilder, imageFish, 0);
            imageCat.setImageResource(cunnla.cunnla.feedthecat.R.drawable.cateat);
            // imView.setVisibility(View.INVISIBLE);   //if you want the object to disappear after the drag and drop
            return true;
        }
        else {
            return false;
        }
    }
}
