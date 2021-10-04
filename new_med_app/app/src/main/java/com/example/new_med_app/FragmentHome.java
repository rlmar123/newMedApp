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


public class FragmentHome extends Fragment
{
    private Button medicine_save_button = null;

    // add_popup.xml widget variables
    private EditText list_medication_name= null;
    private EditText list_amount_per_dose= null;
    private EditText list_times_per_day = null;
    private EditText list_amount_of_pills= null;
    private EditText list_number_of_refills= null;

    private RecyclerView recycler_view = null;
    private RecyclerMedicationAdapt recycler_adapter= null;

    //to build alert dialog
    private AlertDialog.Builder our_builder = null;
    private AlertDialog our_dialog = null;


    FloatingActionButton add_meds_button = null;

    public FragmentHome()
    {

    }




 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.test_recycler);
        add_meds_button = (FloatingActionButton) view.findViewById(R.id.add_med_fab);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ArrayList<Medication> our_medication_list = new ArrayList<>();

        add_meds_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAddPopUp();
            }
        });

        // will delete
        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn",  45, 45, 2 ));

        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn",  45, 45, 2 ));

        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn",  45, 45, 2 ));

        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn",  45, 45, 2 ));

        our_medication_list.add(new Medication("Tylenol", "Acetimono[pehn",  45, 45, 2 ));

        //setup recycler_adapter
        RecyclerMedicationAdapt recycler_adapter = new RecyclerMedicationAdapt(getActivity(), our_medication_list);
        recyclerView.setAdapter(recycler_adapter);


        //keeps data up to date
        recycler_adapter.notifyDataSetChanged();


        return view;
    }

    // pop up menus
    private void createAddPopUp()
    {
        our_builder = new AlertDialog.Builder(getActivity());

        //make connection to popup.xml
        View add_pop_up = getLayoutInflater().inflate(R.layout.add_pop_up, null);


        list_medication_name = add_pop_up.findViewById(R.id.medication_name);
        list_amount_per_dose= add_pop_up.findViewById(R.id.amount_per_dose);
        list_times_per_day = add_pop_up.findViewById(R.id.times_per_day);
        list_amount_of_pills = add_pop_up.findViewById(R.id.amount_of_pills);
        list_number_of_refills = add_pop_up.findViewById(R.id.number_of_refills);

        medicine_save_button = add_pop_up.findViewById(R.id.med_save_button);





        our_builder.setView(add_pop_up);

        //this displays the dialog
        our_dialog = our_builder.create();
        our_dialog.show();

        medicine_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((!list_medication_name.getText().toString().isEmpty()) && (!list_amount_per_dose.getText().toString().isEmpty()) && (!list_times_per_day.getText().toString().isEmpty()) && (!list_amount_of_pills.getText().toString().isEmpty()) && (!list_number_of_refills.getText().toString().isEmpty()))
                    Snackbar.make(v, list_medication_name.getText().toString(), Snackbar.LENGTH_LONG).show();

                else
                    Snackbar.make(v, "Missing a field!!!", Snackbar.LENGTH_LONG).show();

            }
        });



    }

} // end Fragment