package com.example.medication_app.UI;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AppAnimation
{

   public static void theAnimation(Context context, View view, int anim)
   {
      Animation animation = AnimationUtils.loadAnimation(context, anim);
      view.startAnimation(animation);
   }
}
