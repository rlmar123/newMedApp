package com.example.medication_app.Model;

import android.content.Context;
import android.content.Intent;

import com.example.medication_app.util.CONSTANTS;

public class SendEmail
{

   public static void EmailIntent(String email_address, Context context)
   {
      Intent intent = new Intent(Intent.ACTION_SEND);
      intent.setType("text/plain");
      intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email_address});
      intent.putExtra(Intent.EXTRA_TEXT,"This is from the med app");
      intent.putExtra(Intent.EXTRA_SUBJECT,"This is from the med app");
      context.startActivity(intent);
   }
}
