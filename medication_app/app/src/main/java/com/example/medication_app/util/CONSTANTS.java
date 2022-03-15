package com.example.medication_app.util;

import com.example.medication_app.R;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CONSTANTS
{
   public static final String CURRENT = "CURRENT";
   public static final String SELECTED = "SELECTED";

   public static final String COUNT = "COUNT";

   // for opening fragment
   public static final String ANSWER = "ANSWER";
   public static final String HOME = "HOME";
   public static final String DOCTOR = "DOCTOR";
   public static final String APPOINTMENT = "APPOINTMENT";
   public static final String ABOUT_US = "ABOUT_US";

   public static final int DAY_OFFSET = 0;
   public static final int DIVIDE_BY = 100;

   public static final int YEAR_LEAP = 634;
   public static final int YEAR_REG = 635;

   // Dec 31 2022
   public static final int MAX_DAY = 22365;

   // for months
   public static final int LEAP = 28;
   public static final int THIRTY = 30;
   public static final int THIRTY_ONE = 31;

   public static final int MAX_PHONE_NUMBER_LENGTH = 14;

   // for animations
   public static final int ANIMATION_RIGHT = R.anim.slide_in_right;
   public static final int ANIMATION_LEFT = R.anim.slide_in_left;
   public static final int ANIMATION_UP = R.anim.slide_in_up;

   // test string
   public static final String TEST_STRING = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

   // add days for each month
   public static HashMap <Integer, Integer> loadDays()
   {
      HashMap <Integer, Integer> calendar_days = new HashMap<>();

      // Jan
      calendar_days.put(1, CONSTANTS.THIRTY_ONE);
      // Feb
      calendar_days.put(2, CONSTANTS.LEAP);
      // Mar
      calendar_days.put(3, CONSTANTS.THIRTY_ONE);
      // Apr
      calendar_days.put(4, CONSTANTS.THIRTY);
      // May
      calendar_days.put(5, CONSTANTS.THIRTY_ONE);
      // Jun
      calendar_days.put(6, CONSTANTS.THIRTY);
      // Jul
      calendar_days.put(7, CONSTANTS.THIRTY_ONE);
      // Aug
      calendar_days.put(8, CONSTANTS.THIRTY_ONE);
      // Sep
      calendar_days.put(9, CONSTANTS.THIRTY);
      // Oct
      calendar_days.put(10, CONSTANTS.THIRTY_ONE);
      // Nov
      calendar_days.put(11, CONSTANTS.THIRTY);
      // Dec
      calendar_days.put(12, CONSTANTS.THIRTY_ONE);

      return calendar_days;
   }

} // end CONSTANTS
