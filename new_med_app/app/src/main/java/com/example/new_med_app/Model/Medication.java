package com.example.new_med_app.Model;

import androidx.annotation.NonNull;
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

    @ColumnInfo(name = "quantity_total")
    private int quantityTotal;

    @ColumnInfo(name = "quantity_left")
    private int quantityLeft;

    @ColumnInfo(name = "refills_left")
    private int refillsLeft;


    public Medication()
    {
        // null
    }

    public Medication(String medication_name, String drug_nomenclature, int quantity_left, int quantity_total, int refills_left)
    {
        this.medicationName = medication_name;
        this.drugNomenclature = drug_nomenclature;

        this.quantityLeft = quantity_left;
        this.quantityTotal = quantity_total;

        this.refillsLeft = refills_left;
    }

    // setters
    public void setId(int id) {this.id = id;}

    public void setMedicationName(String medication_name) {medicationName = medication_name;}

    public void setDrugNomenclature(String drug_nomenclature) {drugNomenclature = drug_nomenclature;}

    public void setQuantityLeft(int quantity_left) {quantityLeft = quantity_left;}

    public void setQuantityTotal(int quantity_total) {quantityTotal = quantity_total;}

    public void setRefillsLeft(int refills_left) {refillsLeft = refills_left;}

    // getters
    public int getId() {return id;}

    public String getMedicationName() {return medicationName;}

    public String getDrugNomenclature() {return drugNomenclature;}

    public int getQuantityLeft() {return quantityLeft;}

    public int getQuantityTotal() {return quantityTotal;}

    public int getRefillsLeft() {return refillsLeft;}
}
