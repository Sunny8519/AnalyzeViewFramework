package test.yang.com.viewscroller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/29 18:06
 */

public class CustomToggleButton extends LinearLayout {

    public CustomToggleButton(Context context) {
        this(context, null);
    }

    public CustomToggleButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToggleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView() {

    }
}
