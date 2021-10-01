package com.example.new_med_app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Directs this class to be a table
@Entity(tableName = "the_medicine_table")

public class Medication
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "the_med_name_col")
    private String medication_name = null;

    @NonNull
    @ColumnInfo(name = "the_nomenclature_col")
    private String drug_nomenclature = null;

    @NonNull
    @ColumnInfo(name = "the_f_name_col")
    private String doc_first = null;

    @NonNull
    @ColumnInfo(name = "the_l_name_col")
    private String doc_last = null;

    @NonNull
    @ColumnInfo(name = "the_total_quantity_col")
    private int quantity_total = 0;

    @NonNull
    @ColumnInfo(name = "the_amount_col")
    private int quantity_left = 0;

    @NonNull
    @ColumnInfo(name = "the_refills_col")
    private int refills_left = 0;


    public Medication()
    {
        // null Finish medication row
    }

    public Medication(String medication_name, String drug_nomenclature, String doc_first, String doc_last, int quantity_left, int quantity_total, int refills_left)
    {
        this.medication_name = medication_name;
        this.drug_nomenclature = drug_nomenclature;

        this.doc_first = doc_first;
        this.doc_last = doc_last;

        this.quantity_left = quantity_left;
        this.quantity_total = quantity_total;

        this.refills_left = refills_left;
    }

    // setters

    public void setId(int id)
    {this.id = id;}

    public void setMedicationName(@NonNull String medication_name)
    {
        this.medication_name = medication_name;
    }

    public void setDrugNomenclature(@NonNull String drug_nomenclature)
    {
        this.drug_nomenclature = drug_nomenclature;
    }

    public void setFirstName(@NonNull String doc_first)
    {
        this.doc_first = doc_first;
    }

    public void setLastName(@NonNull String doc_last)
    {
        this.doc_last = doc_last;
    }

    public void setQuantityLeft(@NonNull int quantity_left)
    {
        this.quantity_left= quantity_left;
    }

    public void setQuantityTotal(@NonNull int quantity_total)
    {
        this.quantity_total= quantity_total;
    }

    // getters
    public String getMedicationName()
    {return this.medication_name;}

    public String getDrugNomenclature()
    {return this.drug_nomenclature;}

    public String getFirstName()
    {return this.doc_first;}

    public String getLastName()
    {return this.doc_last;}

    public int getQuantityLeft()
    {return this.quantity_left;}

    public int getQuantityTotal()
    {return this.quantity_total;}

} // end Medication
