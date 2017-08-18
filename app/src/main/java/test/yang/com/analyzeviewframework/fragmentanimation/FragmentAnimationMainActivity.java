package test.yang.com.analyzeviewframework.fragmentanimation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import test.yang.com.analyzeviewframework.R;
import test.yang.com.analyzeviewframework.databinding.FragmentAnimationActivityMainBinding;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/18 11:10
 */

public class FragmentAnimationMainActivity extends AppCompatActivity {
    public static final String TAG = FragmentAnimationMainActivity.class.getSimpleName();
    public static final String FRAGMENT_TAG = "fragment_tag";
    private FragmentAnimationActivityMainBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "FragmentAnimationMainActivity onCreate is called");
        this.binding = DataBindingUtil.setContentView(this, R.layout.fragment_animation_activity_main);
        skipFragment(new FirstFragment());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "FragmentAnimationMainActivity onRestart is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "FragmentAnimationMainActivity onStart is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "FragmentAnimationMainActivity onResume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "FragmentAnimationMainActivity onPause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "FragmentAnimationMainActivity onStop is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "FragmentAnimationMainActivity onDestroy is called");
    }

    private void skipFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_container, fragment, FRAGMENT_TAG);
        ft.commit();
    }
}
