package uz.showme.simpledagger2.screen.detalis.splash.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import uz.showme.simpledagger2.R;
import uz.showme.simpledagger2.screen.detalis.splash.SplashScreenActivity;

/**
 * Created by root on 3/10/18.
 */

public class SplashView {

    private View view;

    public SplashView(SplashScreenActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_splash_screen, parent, true);
        ButterKnife.bind(view, context);
    }

    public View constructView() {
        return view;
    }
}
