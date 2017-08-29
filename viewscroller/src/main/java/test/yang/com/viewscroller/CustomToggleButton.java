package test.yang.com.viewscroller;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/29 18:06
 */

public class CustomToggleButton extends LinearLayout {
    private static final String TAG = CustomToggleButton.class.getSimpleName();
    private String mLeftText = null;
    private String mRightText = null;
    private float mLeftTextSize = 0f;
    private float mRightTextSize = 0f;
    private Drawable mToggleButtonBackground = null;
    private ToggleButton mToggleButton = null;

    public CustomToggleButton(Context context) {
        this(context, null);
    }

    public CustomToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CustomToggleButton);
            this.mLeftText = typedArray.getString(R.styleable.CustomToggleButton_leftText);
            this.mRightText = typedArray.getString(R.styleable.CustomToggleButton_rightText);
            this.mLeftTextSize = typedArray.getDimension(R.styleable.CustomToggleButton_leftTextSize, 28f);
            this.mRightTextSize = typedArray.getDimension(R.styleable.CustomToggleButton_rightTextSize, 28f);
            this.mToggleButtonBackground = typedArray.getDrawable(R.styleable.CustomToggleButton_toggleButtonBackground);
            typedArray.recycle();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() {
            @Override
            public void run() {
                initView();
            }
        });
    }

    private void initView() {
        productTextView(this.mLeftText, this.mLeftTextSize);
        this.mToggleButton = new ToggleButton(getContext());
        this.mToggleButton.setBackgroundDrawable(this.mToggleButtonBackground);
        addView(this.mToggleButton);
        productTextView(this.mRightText, this.mRightTextSize);
    }

    private void productTextView(String text, float textSize) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setTextSize(textSize);
        addView(textView);
    }
}
