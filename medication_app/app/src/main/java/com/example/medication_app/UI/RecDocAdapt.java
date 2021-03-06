package com.example.medication_app.UI;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medication_app.Model.Doctor;
import com.example.medication_app.R;

import java.util.List;
import java.util.Objects;

public class RecDocAdapt extends RecyclerView.Adapter<RecDocAdapt.ViewHolder> {
    private final List<Doctor> dList;
    private final Context context;
    private final OnContactClickListener contactClickListener;

    private Button doc_email_button = null;
    private Button doc_phone_button = null;

    public RecDocAdapt(List<Doctor> dList, Context context, OnContactClickListener onContactClickListener) {
        this.dList = dList;
        this.context = context;
        this.contactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_info_row, parent, false);

        return new ViewHolder(view, contactClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Doctor doctor = Objects.requireNonNull(dList.get(position));

        // convert to phone number format
        String phone_formtatted = doctor.getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

        holder.fname.setText(doctor.getFirstName());
        holder.lName.setText(doctor.getLastName());
        holder.email.setText(doctor.getEmail());
        holder.phone_number.setText(phone_formtatted);

    }

    public Doctor getNoteAt(int position) {
        return dList.get(position);
    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(dList.size());
    }

    public interface OnContactClickListener {
        void onContactClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView fname;
        public TextView lName;
        public TextView email;
        public TextView phone_number;
        OnContactClickListener onContactClickListener;

        public ViewHolder(@NonNull View itemView, OnContactClickListener onContactClickListener) {
            super(itemView);

            fname = itemView.findViewById(R.id.doc_first_info);
            lName = itemView.findViewById(R.id.doc_last_info);
            email = itemView.findViewById(R.id.info_email);
            phone_number = itemView.findViewById(R.id.info_phone_number);


            doc_phone_button = itemView.findViewById(R.id.the_phone_button);
            doc_email_button = itemView.findViewById(R.id.the_email_button);

            this.onContactClickListener = onContactClickListener;

            itemView.setOnClickListener(this);

            doc_phone_button.setOnClickListener(this);
            doc_email_button.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onContactClickListener.onContactClick(getAdapterPosition());

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

            } //end switch
        }
    }
}

