package test.yang.com.viewscroller.animation;

import android.view.View;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/28 17:58
 */

public class MyView {
    private View mView = null;

    public MyView(View mView) {
        this.mView = mView;
    }

    public int getWidth() {
        return this.mView.getLayoutParams().width;
    }

    public void setWidth(int width) {
        this.mView.getLayoutParams().width = width;
        this.mView.requestLayout();
    }
}
