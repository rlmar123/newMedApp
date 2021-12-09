package com.example.medication_app.Model;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    private static final int HOURS = 24;

    public Medication()
    {
        // null
    }

    public Medication(String medication_name, String drug_nomenclature, int drug_dosage, int times_per_day, int quantity_total, int refills_left, int beginDate, int numOfDays)
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
}
