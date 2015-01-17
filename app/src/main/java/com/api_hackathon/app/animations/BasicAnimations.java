package com.api_hackathon.app.animations;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.api_hackathon.app.R;

/**
 * Created by USER on 17-01-2015.
 */
public class BasicAnimations {
    private Context context;
    public Animation zoomIn, fade, rotate,translate,flip;
    public BasicAnimations(Context context) {
        this.context = context;
        zoomIn = AnimationUtils.loadAnimation(context, R.anim.zoom_in);
        fade = AnimationUtils.loadAnimation(context, R.anim.fade);
        rotate = AnimationUtils.loadAnimation(context, R.anim.rotate);
        translate = AnimationUtils.loadAnimation(context, R.anim.translate);
    }


}
