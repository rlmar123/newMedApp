package com.example.new_med_app.UI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_med_app.Model.Doctor;
import com.example.new_med_app.Model.Medication;
import com.example.new_med_app.R;

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView med_name = null;
        public TextView med_nomenclature = null;
        public TextView doc_first = null;
        public TextView doc_last = null;
        public TextView quantity_total = null;
        public TextView num_of_refills = null;
        public TextView dosage = null;

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


            this.onContactClickListener = onContactClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view)
        {
            onContactClickListener.onContactClick(getAdapterPosition());

            /*
           Doctor temp_doc = dList.get(getAdapterPosition());

            switch (view.getId())
            {
                case R.id.the_phone_button:

                    // convert to phone number format
                    String phone_formtatted = temp_doc.getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

                    Intent the_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone_formtatted));
                    context.startActivity(the_intent);
                    break;

                case R.id.the_email_button:

                    Toast.makeText(context.getApplicationContext(), "Email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,"This is from the med app");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"This is from the med app");
                    context.startActivity(intent);
                    break;

            } //end switch*/
        }
    }
}

