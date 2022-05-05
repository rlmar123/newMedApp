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

   // days for months
   public static final int LEAP = 28;
   public static final int THIRTY = 30;
   public static final int THIRTY_ONE = 31;

   // the date pattern for parsing
   public static final String DATE_PATTERN = "MM-dd-yyyy";

   // used in CalendarActivity
   public static final String SEL_BEGIN_DATE = "Select Begin Date";
   public static final String SEL_END_DATE = "Select End Date";

   public static final String BEGIN_TIME = "Begin Time";
   public static final String END_TIME = "End Time";

   // used in MicahActivity
   public static final String MICAH_INTRO = "Micah has been with RL3 software since 2020. He graduated from William Paterson with a BS in Computer Science." +
  " His passion is developing software. His hobbies include history, exercise, and guitar playing.  ......  ";

   public static final String MICAH_BODY = "Micah has a veterans mindset and deals with problems in a professional manner. Always eager to learn, Micah embraces new technologies with enthusiasm." +
  " Micah is orginally from Portland, Maine. He currently resides in Cheyenne, Wyoming.";


   public static final int MAX_PHONE_NUMBER_LENGTH = 14;

   // for animations
   public static final int ANIMATION_IN_RIGHT = R.anim.slide_in_right;
   public static final int ANIMATION_IN_LEFT = R.anim.slide_in_left;
   public static final int ANIMATION_IN_UP = R.anim.slide_in_up;
   public static final int ANIMATION_OUT_LEFT = R.anim.slide_out_left;
   public static final int ANIMATION_OUT_RIGHT = R.anim.slide_out_right;

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
