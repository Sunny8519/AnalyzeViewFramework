package test.yang.com.viewscroller;

import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import test.yang.com.viewscroller.databinding.ActivityAnimationViewBinding;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/29 11:28
 */

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = AnimationActivity.class.getSimpleName();
    private ActivityAnimationViewBinding binding = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_animation_view);
        this.binding.btnAlpha.setOnClickListener(this);
    }

    private void createAlphaAnimationByValueAnimator() {
        //第一步，创建一个ValueAnimator,调用ofFloat()方法来初始化，并设置透明度变化的起始值和结束值
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(1, 0);
        //设置从起始值变化到结束值所用时间
        valueAnimator.setDuration(2000);
        valueAnimator.start();
        /*第二步，给ValueAnimator设置监听器，监听值变化过程，通过getAnimatedValue拿到变化的值，并手动更新控件的变化*/
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, "alpha value = " + animation.getAnimatedValue());
                binding.ivHouse.setAlpha((Float) animation.getAnimatedValue());
            }
        });
    }

    @Override
    public void onClick(View v) {
        createAlphaAnimationByValueAnimator();
    }
}
