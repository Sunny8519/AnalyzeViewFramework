package test.yang.com.viewscroller.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/28 16:34
 */

public class ScrollerViewWithScroller extends View {
    private static final String TAG = ScrollerViewWithScroller.class.getSimpleName();
    private Scroller mScroller = null;

    public ScrollerViewWithScroller(Context context) {
        super(context);
        Log.i(TAG, "一个参数构造函数");
    }

    public ScrollerViewWithScroller(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mScroller = new Scroller(context);
        Log.i(TAG, "两个参数构造函数");
    }

    public ScrollerViewWithScroller(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i(TAG, "三个参数构造函数");
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Log.i(TAG, "computeScrollOffset = " + this.mScroller.computeScrollOffset());
        if (this.mScroller.computeScrollOffset()) {
            Log.i(TAG, "getCurrX() = " + this.mScroller.getCurrX() + " getCurrY() = " + this.mScroller.getCurrY());
            ((View) getParent()).scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX) {
        int scrollX = getScrollX();
        Log.i(TAG, "getScrollX() = " + scrollX);
        int delta = destX - scrollX;
        Log.i(TAG, "移动的偏移量 = " + delta);
        this.mScroller.startScroll(scrollX, 0, delta, 0, 1000);
        invalidate();
    }
}
