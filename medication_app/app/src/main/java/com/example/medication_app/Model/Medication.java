package com.example.medication_app.Model;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.medication_app.util.CONSTANTS;

import java.util.HashMap;

@Entity(tableName = "medication_table")
public class Medication
{
   @PrimaryKey(autoGenerate = true)
   private int id;

   @ColumnInfo(name = "med_name")
   private String medicationName;

   @ColumnInfo(name = "drug_nomenclature")
   private String drugNomenclature;

   // number of pills
   @ColumnInfo(name = "drug_dosage")
   private int drugDosage;

   @ColumnInfo(name = "num_of_times")
   private int timesPerDay;

   @ColumnInfo(name = "quantity_total")
   private int quantityTotal;

   @ColumnInfo(name = "quantity_left")
   private int quantityLeft;

   @ColumnInfo(name = "refills_left")
   private int refillsLeft;

   @ColumnInfo(name = "begin_date")
   private int beginDate;

   @ColumnInfo(name = "num_of_days")
   private int numOfDays;

   @ColumnInfo(name = "end_date")
   private int endDate;

   @ColumnInfo(name = "begin_string")
   private String beginDateString = null;

   @ColumnInfo(name = "end_string")
   private String endDateString;

   public Medication()
   {
      // null
   }

   public Medication(String medication_name, String drug_nomenclature, String YYYYMMDD, int drug_dosage, int times_per_day, int quantity_total, int refills_left, int beginDate, int numOfDays)
   {
      this.medicationName = medication_name;
      this.drugNomenclature = drug_nomenclature;
      this.drugDosage = drug_dosage;
      this.timesPerDay = times_per_day;

      // same at the beginning
      this.quantityTotal = quantity_total;
      this.quantityLeft = quantity_total;

      this.refillsLeft = refills_left;

      this.beginDate = beginDate;
      this.numOfDays = numOfDays;

      this.endDate = (this.beginDate) + (this.numOfDays - 1);

      calcStringEndDate(YYYYMMDD);
      Log.d("FROM MEDICATION", "CONSTRUCTOR " + this.beginDateString);
   }


   private void quantityLeftDecrement()
   {
      // always ZERO
      if (quantityLeft <= 0)
         quantityLeft = 0;

      else
         quantityLeft--;
   }


   // setters
   public void setId(int id) {this.id = id;}

   public void setMedicationName(String medication_name) {medicationName = medication_name;}

   public void setDrugNomenclature(String drug_nomenclature) {drugNomenclature = drug_nomenclature;}

   public void setDrugDosage(int drug_dosage) {drugDosage = drug_dosage;}

   public void setTimesPerDay(int times_per_day) {timesPerDay = times_per_day;}

   public void setQuantityTotal(int quantity_total) {quantityTotal = quantity_total;}

   public void setQuantityLeft(int quantity_left) {quantityLeft = quantity_left;}

   public void setRefillsLeft(int refills_left) {refillsLeft = refills_left;}

   public void setBeginDate(int beginDate) {this.beginDate = beginDate;}

   public void setNumOfDays(int numOfDays) {this.numOfDays = numOfDays;}

   public void setEndDate(int endDate) {this.endDate = endDate;}

   public void setBeginDateString(String beginDateString) {this.beginDateString = beginDateString;}

   public void setEndDateString(String endDateString) {this.endDateString = endDateString;}

   // getters
   public int getId() {return id;}

   public String getMedicationName() {return medicationName;}

   public String getDrugNomenclature() {return drugNomenclature;}

   public int getDrugDosage() {return drugDosage;}

   public int getTimesPerDay() {return timesPerDay;}

   public int getQuantityLeft() {return quantityLeft;}

   public int getQuantityTotal() {return quantityTotal;}

   public int getRefillsLeft() {return refillsLeft;}

   public int getBeginDate() {return this.beginDate;}

   public int getNumOfDays() {return this.numOfDays;}

   public int getEndDate() {return this.endDate;}

   public String getBeginDateString() {return this.beginDateString;}

   public String getEndDateString() {return this.endDateString;}

   private void calcStringEndDate(String the_date)
   {
      HashMap<Integer, Integer> the_days = new HashMap<>();
      the_days = CONSTANTS.loadDays();

      int year, month, day, max;
      int test_date, end_date;
      int original_date = Integer.parseInt(the_date);

      String string_year;
      String string_month;
      String string_day;

      String string_end_date;

      day = original_date % CONSTANTS.DIVIDE_BY;
      original_date = original_date / CONSTANTS.DIVIDE_BY;

      month = original_date % CONSTANTS.DIVIDE_BY;
      year = original_date / CONSTANTS.DIVIDE_BY;

      // store beginning date
      string_month = Integer.toString(month);
      string_day = Integer.toString(day);
      string_year = Integer.toString(year);

      this.beginDateString = string_month + "/" + string_day + "/" + string_year;
      Log.d("FROM MEDICATION", "BEGIN " + this.beginDateString);

      max = the_days.get(month);

      test_date = day + (numOfDays - 1);

      if(test_date > max)
      {
         end_date = test_date - max;
         Log.d("FROM MEDICATION", "DATE WORKS !!!!! " + year);
         Log.d("FROM MEDICATION", "MAX " + max);
      }

      else
      {
         end_date = test_date;
         Log.d("FROM MEDICATION", "DATE WORKS !!!!! " + end_date);
         Log.d("FROM MEDICATION", "MAX " + year);
      }

      // store end date
      string_month = Integer.toString(month);
      string_day = Integer.toString(end_date);
      string_year = Integer.toString(year);

      this.endDateString = string_month + "/" + string_day + "/" + string_year;
      Log.d("FROM MEDICATION", "string_end_date " + this.endDateString);
   }

} // end Medication class
