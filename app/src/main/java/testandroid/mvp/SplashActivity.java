package testandroid.mvp;

import android.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


import testandroid.mvp.ui.activities.InitActivity;

public class SplashActivity extends AppCompatActivity {
    private Activity self = this;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        runSplash();
    }

    private void runSplash() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                InitActivity.startIntent(self);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_TIME_OUT);
    }
}
