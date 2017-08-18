package test.yang.com.analyzeviewframework.fragmentanimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.yang.com.analyzeviewframework.R;
import test.yang.com.analyzeviewframework.databinding.FragmentFirstViewBinding;

/**
 * @author NiYang
 * @Description:
 * @date 2017/8/18 11:17
 */

public class FirstFragment extends Fragment implements View.OnClickListener {
    private FragmentFirstViewBinding binding = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onAttach is called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onCreate is called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onCreateView is called");
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_view, container, false);
        this.binding.btnSkip.setOnClickListener(this);
        return this.binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onActivityCreated is called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onStart is called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onResume is called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onPause is called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onStop is called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onDestroyView is called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onDestroy is called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onDetach is called");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(FragmentAnimationMainActivity.TAG, "FirstFragment onActivityResult is called");
    }

    private void skipFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.main_container, fragment, FragmentAnimationMainActivity.FRAGMENT_TAG);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                skipFragment(new SecondaryFragment());
                break;
            default:
                break;
        }
    }
}
