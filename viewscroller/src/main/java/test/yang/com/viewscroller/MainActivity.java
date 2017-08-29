package test.yang.com.viewscroller;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import test.yang.com.viewscroller.animation.MyView;
import test.yang.com.viewscroller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        this.binding.customViewWithParams.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
//        ObjectAnimator.ofFloat(this.binding.customViewWithParams, "translationX", 0, 300).setDuration(1000).start();
//        this.binding.customViewWithScroller.smoothScrollTo(-400);
//        MyView myView = new MyView(this.binding.btnClick);
//        ObjectAnimator.ofInt(myView,"width",500).setDuration(2000).start();

        //ValueAnimator不提供动画效果
        ValueAnimator mValueAnimator = ValueAnimator.ofFloat(0, 100);
        mValueAnimator.setTarget(this.binding.btnClick);
        mValueAnimator.setDuration(2000).start();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, "ValueAnimator = " + animation.getAnimatedValue());
            }
        });

        this.binding.btnClick.setOnClickListener(this);
        this.binding.tbButton.setEnabled(false);
    }

    private void skipActivity(Class activityName) {
        Intent intent = new Intent(this, activityName);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        skipActivity(AnimationActivity.class);
        this.binding.tbButton.setChecked(true);
    }
}
