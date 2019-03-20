package testandroid.mvp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import testandroid.mvp.R;
import testandroid.mvp.ui.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    public static void startIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }
    private void init(){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_content,
                HomeFragment.newInstance(),
                HomeFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

    }
}
