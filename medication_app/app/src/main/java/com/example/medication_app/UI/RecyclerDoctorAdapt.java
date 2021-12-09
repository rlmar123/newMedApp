package com.example.medication_app.UI;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medication_app.Model.Doctor;
import com.example.medication_app.R;

import java.util.List;

public class RecyclerDoctorAdapt extends RecyclerView.Adapter<RecyclerDoctorAdapt.ViewHolder>
{
    private Context the_context = null;
    private List<Doctor> list_of_doctors = null;

    //to build alert dialog
    private AlertDialog.Builder confirm_builder = null;
    private AlertDialog confirm_dialog = null;

    private LayoutInflater the_inflater = null;


    private Button doc_email_button = null;
    private Button doc_phone_button = null;

    // RecyclerViewAdapt Constructor
    public RecyclerDoctorAdapt(Context context, List<Doctor> the_list)
    {
        the_context = context;
        list_of_doctors = the_list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //connection to my_list_row.xml
        View the_view = LayoutInflater.from(the_context).inflate(R.layout.doc_info_row, parent, false);
        return new ViewHolder(the_view, the_context);
    }

    //this is how the list populates as you scroll on and off the screen
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Doctor doctor = list_of_doctors.get(position);

        holder.first.setText(doctor.getFirstName());
        holder.last.setText(doctor.getLastName());
    }

    @Override
    public int getItemCount() {
        return list_of_doctors.size();
    }

    //magic happens here
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView first = null;
        public TextView last = null;



        public int id;

        public ViewHolder(@NonNull View itemView, Context the_ctx)
        {
            super(itemView);
            the_context = the_ctx;

            first = itemView.findViewById(R.id.doc_first_info);
            last = itemView.findViewById(R.id.doc_last_info);
            doc_phone_button = itemView.findViewById(R.id.the_phone_button);
            doc_email_button = itemView.findViewById(R.id.the_email_button);

            /*
            itemColor = itemView.findViewById(R.id.color_text);
            itemSize = itemView.findViewById(R.id.item_size);
            dateAdded = itemView.findViewById(R.id.date_item_added);

             */




            doc_phone_button.setOnClickListener(this);
            doc_email_button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            int pos = getAdapterPosition();
            Doctor click_item = list_of_doctors.get(pos);

            switch (v.getId())
            {
                case R.id.the_phone_button:

                    Toast.makeText(the_context, "phone", Toast.LENGTH_LONG).show();

                    Intent the_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "777-222-2222"));
                    the_context.startActivity(the_intent);


                break;

                case R.id.the_email_button:

                 Toast.makeText(the_context, "Email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,"This is from the med app");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"This is from the med app");
                    the_context.startActivity(intent);
                    break;

            } //end switch
        }

        private void listEditItem(final Doctor edit_item)
        {
            final EditText edit_baby_item;
            final EditText edit_item_quantity;
            final EditText edit_item_color;
            final EditText edit_item_size;


           /* TextView edit_title = null;
            Button edit_save_button = null;

            confirm_builder = new AlertDialog.Builder(the_context);

            the_inflater = LayoutInflater.from(the_context);

            //make connection to confrimation_pop_up.xml
            View edit_pop_up = the_inflater.inflate(R.layout.the_popup, null);

            //make connection to popup.xml widgets
            edit_baby_item = edit_pop_up.findViewById(R.id.the_baby_item);
            edit_item_quantity = edit_pop_up.findViewById(R.id.the_item_quantity);
            edit_item_color = edit_pop_up.findViewById(R.id.the_item_color);
            edit_item_size = edit_pop_up.findViewById(R.id.the_item_size);

            edit_title = edit_pop_up.findViewById(R.id.title);
            edit_save_button = edit_pop_up.findViewById(R.id.the_save_button);

            edit_title.setText("Edit the Item");
            edit_save_button.setText("Update");

            edit_baby_item.setText("Item: " + edit_item.getName());

            edit_item_quantity.setText( "Quantity: " + Integer.toString(edit_item.getQuantity()));
            edit_item_color.setText("Color " + edit_item.getColor());
            edit_item_size.setText("Size: " + Integer.toString(edit_item.getSize()));


            confirm_builder.setView(edit_pop_up);

            //this displays the dialog
            confirm_dialog = confirm_builder.create();
            confirm_dialog.show();*/

           /* edit_save_button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                 //   theDB save_db = new theDB(the_context);

                    String name = edit_baby_item.getText().toString().trim();
                    String new_item_color = edit_item_color.getText().toString().trim();


                    int the_quantity = Integer.parseInt(edit_item_quantity.getText().toString().trim());
                    int new_item_size = Integer.parseInt(edit_item_size.getText().toString().trim());


                    edit_item.setName(name);
                    edit_item.setQuantity(the_quantity);
                    edit_item.setColor(new_item_color);
                    edit_item.setSize(new_item_size);

                    //      the_new_item

                    if ((!edit_baby_item.getText().toString().isEmpty()) && (!edit_item_quantity.getText().toString().isEmpty()) && (!edit_item_color.getText().toString().isEmpty()) && (!edit_item_size.getText().toString().isEmpty()))
                    {
                        save_db.updateItem(edit_item);

                        //very important. screen wont update automatically!!!
                        notifyItemChanged(getAdapterPosition(), edit_item);
                    }

                    else
                        Snackbar.make(v, "Missing a field!!!", Snackbar.LENGTH_LONG).show();

                    confirm_dialog.dismiss();

                }

            }); */

        }

        private void listdeleteItem(final Doctor del_obj)
        {

            /*confirm_builder = new AlertDialog.Builder(the_context);

            the_inflater = LayoutInflater.from(the_context);

            //make connection to confrimation_pop_up.xml
            View confirm_pop_up = the_inflater.inflate(R.layout.confrimation_pop_up, null);

            //connect to confrimation_pop_up.xml widget
            the_no_button = confirm_pop_up.findViewById(R.id.no_button);
            the_yes_button = confirm_pop_up.findViewById(R.id.yes_button);

            confirm_builder.setView(confirm_pop_up);

            //this displays the dialog
            confirm_dialog = confirm_builder.create();
            confirm_dialog.show();

            the_yes_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    int position = getAdapterPosition();
                    theDB delete_db = new theDB(the_context);

                    delete_db.deleteItem(del_obj);

                    list_of_meds.remove(position);
                    notifyItemRemoved(position);

                    confirm_dialog.dismiss();

                }
            });

            the_no_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    confirm_dialog.dismiss();
                }
            }); */

        }

    } //end ViewHolder

}


