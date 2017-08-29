package test.yang.com.viewscroller.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/28 13:36
 */

public class ScrollerViewWithLayout extends View {
    private static final String TAG = ScrollerViewWithLayout.class.getSimpleName();
    private int startX = 0;
    private int startY = 0;

    public ScrollerViewWithLayout(Context context) {
        super(context);
    }

    public ScrollerViewWithLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerViewWithLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.i(TAG, "x = " + x);
        Log.i(TAG, "y = " + y);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.startX = x;//起始点X坐标
                this.startY = y;//起始点Y坐标
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - this.startX;//X方向偏移量
                int offsetY = y - this.startY;//Y方向偏移量
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }
}
