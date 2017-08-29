package test.yang.com.viewscroller.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/28 16:10
 */

public class ScrollerViewWithScroll extends View {
    private int startX = 0;
    private int startY = 0;

    public ScrollerViewWithScroll(Context context) {
        super(context);
    }

    public ScrollerViewWithScroll(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerViewWithScroll(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }
        return true;
    }
}
