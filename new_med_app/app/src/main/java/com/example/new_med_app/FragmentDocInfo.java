package com.example.new_med_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_med_app.Model.Medication;
import com.example.new_med_app.UI.RecyclerMedicationAdapt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class FragmentDocInfo extends Fragment
{
    private Button doc_save_button = null;

    // doc_popup.xml widget variables
    private EditText doc_first_name= null;
    private EditText doc_last_name= null;
    private EditText doc_email = null;
    private EditText doc_phone_number= null;

    private RecyclerView doc_recycler_view = null;
    private RecyclerMedicationAdapt recycler_adapter= null; // we need a new adapter!!!!!

    FloatingActionButton add_doc_button = null;

    //to build alert dialog
    private AlertDialog.Builder our_builder = null;
    private AlertDialog our_dialog = null;

    public FragmentDocInfo()
    {

    }




 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.doc_info_fragment, container, false);

        doc_recycler_view = view.findViewById(R.id.doc_test_recycler);
        doc_recycler_view.setHasFixedSize(true);
        doc_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Medication> our_medication_list = new ArrayList<>();
        add_doc_button = (FloatingActionButton) view.findViewById(R.id.add_doc_fab);

        // fab
        add_doc_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                createDocPopUp();
            }
        });


        // will delete
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn", "James", "Jones", 45, 45, 2 ));
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn", "James", "Jones", 45, 45, 2 ));
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn", "James", "Jones", 45, 45, 2 ));
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn", "James", "Jones", 45, 45, 2 ));
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn", "James", "Jones", 45, 45, 2 ));


        //setup recycler_adapter
        RecyclerMedicationAdapt recycler_adapter = new RecyclerMedicationAdapt(getActivity(), our_medication_list);
        doc_recycler_view.setAdapter(recycler_adapter);


        //keeps data up to date
        recycler_adapter.notifyDataSetChanged();

        return view;
    }

    private void createDocPopUp()
    {
        our_builder = new AlertDialog.Builder(getActivity());

        //make connection to popup.xml
        View update_pop_up = getLayoutInflater().inflate(R.layout.doc_pop_up, null);

        doc_first_name = update_pop_up.findViewById(R.id.first_name);
        doc_last_name = update_pop_up.findViewById(R.id.last_name);
        doc_email = update_pop_up.findViewById(R.id.doc_email);
        doc_phone_number = update_pop_up.findViewById(R.id.doc_phone_number);
      /*  doc_save_button = update_pop_up.findViewById(R.id.doc);

       *//* doc_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               *//**//* if((!list_medication_name.getText().toString().isEmpty()) && (!list_amount_per_dose.getText().toString().isEmpty()) && (!list_times_per_day.getText().toString().isEmpty()) && (!list_amount_of_pills.getText().toString().isEmpty()) && (!list_number_of_refills.getText().toString().isEmpty()))
                    Snackbar.make(v, list_medication_name.getText().toString(), Snackbar.LENGTH_LONG).show();

                else
                    Snackbar.make(v, "Missing a field!!!", Snackbar.LENGTH_LONG).show();*//**//*

            }
        });*/

        our_builder.setView(update_pop_up);

        //this displays the dialog
        our_dialog = our_builder.create();
        our_dialog.show();


    }

} // end Fragment