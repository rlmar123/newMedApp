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
        Log.d("from onBind", " " + medication.getMedicationName());
    /*    holder.med_nomenclature.setText("Dimetapp");
        holder.doc_first.setText("DOC FIRST!!!!!");
        holder.doc_last.setText("DOC LAST!!!!!");
        holder.quantity_left.setText(medication.getQuantityLeft());
        holder.num_of_refills.setText(medication.getRefillsLeft());*/

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
        public TextView quantity_left = null;
        public TextView num_of_refills = null;

        OnContactClickListener onContactClickListener;

        public ViewHolder(@NonNull View itemView, OnContactClickListener onContactClickListener) {
            super(itemView);

            med_name = itemView.findViewById(R.id.med_name);
            med_nomenclature = itemView.findViewById(R.id.nomenclature);
            doc_first = itemView.findViewById(R.id.doc_first);
            doc_last = itemView.findViewById(R.id.doc_last);


            quantity_left = itemView.findViewById(R.id.quantity_left);
            num_of_refills = itemView.findViewById(R.id.refills_text);

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

