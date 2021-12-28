package com.example.medication_app.util;

import java.util.HashMap;

public class CONSTANTS
{
   public static final String CURRENT = "CURRENT";
   public static final String SELECTED = "SELECTED";

   public static final String COUNT = "COUNT";

   public static final int DAY_OFFSET = 0;
   public static final int DIVIDE_BY = 100;
   public static final int YEAR = 365;

   // for months
   public static final int LEAP = 28;
   public static final int THIRTY = 30;
   public static final int THIRTY_ONE = 31;

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
