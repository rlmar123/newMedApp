package com.example.medication_app.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medication_app.Model.Medication;
import com.example.medication_app.R;

import java.util.List;
import java.util.Objects;

public class RecMedAdapt extends RecyclerView.Adapter<RecMedAdapt.ViewHolder> {
    private final List<Medication> medicationList;
    private final Context context;
    private final OnContactClickListener contactClickListener;

    public RecMedAdapt(List<Medication> medicationList, Context context, OnContactClickListener onContactClickListener)
    {
        this.medicationList = medicationList;
        this.context = context;
        this.contactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medication_row, parent, false);

        return new ViewHolder(view, contactClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Medication medication = Objects.requireNonNull(medicationList.get(position));

        holder.med_name.setText(medication.getMedicationName());
        holder.med_nomenclature.setText(medication.getDrugNomenclature());

        holder.doc_first.setText("Napoleon");
        holder.doc_last.setText(" Dynamite!!!!!");

        holder.quantity_total.setText("Total Pills : " + medication.getQuantityTotal());
        holder.num_of_refills.setText("Refills Left : " + medication.getRefillsLeft());

        holder.dosage.setText(Integer.toString(medication.getDrugDosage()) + " pills " + medication.getTimesPerDay() + " times per day");

        holder.date_start.setText("Start : " +medication.getBeginDateString());
        holder.date_end.setText("End : " + medication.getEndDateString());
        holder.med_image.setBackgroundResource(R.drawable.ic_baseline_local_hospital_24);
    }

    public Medication getMedAt(int position) {
        return medicationList.get(position);
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(medicationList.size());
    }

    public interface OnContactClickListener {
        void onContactClick(int position);
    }

    // MAGIC HAPPENS HERE!!!!!!
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView med_name = null;
        public TextView med_nomenclature = null;
        public TextView doc_first = null;
        public TextView doc_last = null;
        public TextView quantity_total = null;
        public TextView num_of_refills = null;
        public TextView dosage = null;
        public TextView date_start = null;
        public TextView date_end = null;
        public ImageView med_image = null;

        OnContactClickListener onContactClickListener;

        public ViewHolder(@NonNull View itemView, OnContactClickListener onContactClickListener) {
            super(itemView);

            // connect to xml widgets in medication_row
            med_name = itemView.findViewById(R.id.med_name);
            med_nomenclature = itemView.findViewById(R.id.nomenclature);

            doc_first = itemView.findViewById(R.id.doc_first);
            doc_last = itemView.findViewById(R.id.doc_last);

            quantity_total = itemView.findViewById(R.id.quantity_total);
            num_of_refills = itemView.findViewById(R.id.refills_text);
            dosage = itemView.findViewById(R.id.dosage_text);
            date_start = itemView.findViewById(R.id.start_text);
            date_end = itemView.findViewById(R.id.end_text);

            med_image = itemView.findViewById(R.id.med_image);

            this.onContactClickListener = onContactClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view)
        {
            onContactClickListener.onContactClick(getAdapterPosition());

        }
    }
}

