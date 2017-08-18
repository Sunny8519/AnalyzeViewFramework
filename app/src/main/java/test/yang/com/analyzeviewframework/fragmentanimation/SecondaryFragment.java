package test.yang.com.analyzeviewframework.fragmentanimation;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.yang.com.analyzeviewframework.R;
import test.yang.com.analyzeviewframework.databinding.FragmentSecondViewBinding;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/18 11:18
 */

public class SecondaryFragment extends Fragment {
    private FragmentSecondViewBinding binding = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onAttach is called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onCreate is called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onCreateView is called");
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_view, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onActivityCreated is called");
    }

    /*以上生命周期方法对应Activity中的Created阶段*/

    @Override
    public void onStart() {
        super.onStart();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onStart is called");
    }

    /*以上生命周期方法对应Activity中的Started阶段*/

    @Override
    public void onResume() {
        super.onResume();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onResume is called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onPause is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onStop is called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onDestroyView is called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onDestroy is called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(FragmentAnimationMainActivity.TAG, "SecondaryFragment onDetach is called");
    }
}
