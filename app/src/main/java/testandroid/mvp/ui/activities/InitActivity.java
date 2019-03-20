package testandroid.mvp.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import testandroid.mvp.R;

public class InitActivity extends AppCompatActivity {
    private Activity self = this;
    public static void startIntent(Context context) {
        Intent intent = new Intent(context, InitActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
    }

    public void run(View view) {
        HomeActivity.startIntent(self);
    }
}
