package test.yang.com.viewscroller.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/28 14:48
 */

public class ScrollerViewWithLayoutParams extends View {
    private static final String TAG = ScrollerViewWithLayoutParams.class.getSimpleName();
    private int startX = 0;
    private int startY = 0;

    public ScrollerViewWithLayoutParams(Context context) {
        super(context);
    }

    public ScrollerViewWithLayoutParams(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerViewWithLayoutParams(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.startX = x;
                this.startY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - this.startX;
                int offsetY = y - this.startY;
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) getLayoutParams();
                params.leftMargin = getLeft() + offsetX;
                params.topMargin = getTop() + offsetY;
                params.rightMargin = getRight() - offsetX;
                params.bottomMargin = getBottom() - offsetY;
                setLayoutParams(params);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }
}
