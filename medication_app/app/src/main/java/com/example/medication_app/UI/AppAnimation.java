package com.example.medication_app.UI;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AppAnimation
{

   public static void inAnim(Context context, TextView textView, int anim)
   {
      Animation animation = AnimationUtils.loadAnimation(context, anim);
      textView.startAnimation(animation);
   }
}
