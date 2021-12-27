package com.example.medication_app;

// import static MedicationViewModel.changeArray;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medication_app.Model.Medication;
import com.example.medication_app.Model.MedicationViewModel;
import com.example.medication_app.R;
import com.example.medication_app.UI.RecMedAdapt;
import com.example.medication_app.util.CONSTANTS;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class FragmentHome extends Fragment implements RecMedAdapt.OnContactClickListener
{
    private Button medicine_save_button = null;

    // add_popup.xml widget variables
    private EditText list_medication_name= null;
    private EditText list_medication_nomenclature = null;
    private EditText list_amount_per_dose = null;
    private EditText list_hours_per_day = null;
    private EditText list_amount_of_pills = null;
    private EditText list_number_of_refills = null;

    private EditText list_number_of_days = null;

    private RecyclerView home_recycler_view = null;
    private RecMedAdapt recycler_adapter= null;

    //to build alert dialog
    private AlertDialog.Builder our_builder = null;
    private AlertDialog our_dialog = null;

    private MedicationViewModel medicationViewModel;
    private LiveData<List<Medication>> medList;

    FloatingActionButton add_meds_button = null;
    private int day;

    public FragmentHome() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        home_recycler_view = (RecyclerView) view.findViewById(R.id.home_test_recycler);
        home_recycler_view.setHasFixedSize(true);
        home_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        add_meds_button = (FloatingActionButton) view.findViewById(R.id.add_med_fab);

        home_recycler_view.setHasFixedSize(true);
        home_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

        setDay();

        medicationViewModel =  new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(MedicationViewModel.class);

        medicationViewModel.getToday(day).observe(this, medications ->
        {
            recycler_adapter = new RecMedAdapt(medications, getActivity(), this);
            home_recycler_view.setAdapter(recycler_adapter);
        });

        // this does the swiping action
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT)
        {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
            {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {medicationViewModel.delete(recycler_adapter.getMedAt(viewHolder.getAdapterPosition()));}

        }).attachToRecyclerView(home_recycler_view);

        add_meds_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {createAddPopUp();}
        });

        return view;
    }

    // pop up menus
    private void createAddPopUp()
    {
        our_builder = new AlertDialog.Builder(getActivity());

       //make connection to popup.xml
       View the_pop_up = getLayoutInflater().inflate(R.layout.add_pop_up, null);

       connectToXML(the_pop_up);

       medicine_save_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v)
            {
                if((!list_medication_name.getText().toString().isEmpty()) &&
                   (!list_medication_nomenclature.getText().toString().isEmpty()) &&
                   (!list_amount_per_dose.getText().toString().isEmpty()) &&
                   (!list_hours_per_day.getText().toString().isEmpty()) &&
                   (!list_amount_of_pills.getText().toString().isEmpty()) &&
                   (!list_number_of_refills.getText().toString().isEmpty()) &&
                   (!list_number_of_days.getText().toString().isEmpty()))
                {
                    int dose = Integer.parseInt(list_amount_per_dose.getText().toString());
                    int hours = Integer.parseInt(list_hours_per_day.getText().toString());
                    int pills = Integer.parseInt(list_amount_of_pills.getText().toString());
                    int refills = Integer.parseInt(list_number_of_refills.getText().toString());
                    int days = Integer.parseInt(list_number_of_days.getText().toString());

                    // today's date in string
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                    String test =  LocalDate.now().format(formatter).toString();

                    Medication medication = new Medication(list_medication_name.getText().toString(), list_medication_nomenclature.getText().toString(), test, dose, hours, pills, refills, MedicationViewModel.getCurrentJulianDate(), days);
                    MedicationViewModel.insert(medication);

                    our_dialog.dismiss();
                }

                else
                {
                    Snackbar.make(v, "Missing a field!!!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        our_builder.setView(the_pop_up);

        //this displays the dialog
        our_dialog = our_builder.create();
        our_dialog.show();
    }

    public void setDay()
    {
        if(getArguments() != null)
        {
            if(getArguments().getString(CONSTANTS.COUNT).equals(CONSTANTS.CURRENT))
                day = MedicationViewModel.getCurrentJulianDate();

            else if(getArguments().getString(CONSTANTS.COUNT).equals(CONSTANTS.SELECTED))
                day = MedicationViewModel.getSelectedJulianDate();
        }
    }

    @Override
    public void onContactClick(int position) {Medication medication = Objects.requireNonNull(medicationViewModel.todays_list.getValue()).get(position); }

    private void connectToXML(View add_pop_up)
    {
       list_medication_name = add_pop_up.findViewById(R.id.medication_name);
       list_medication_nomenclature = add_pop_up.findViewById(R.id.medication_nomenclature);
       list_amount_per_dose= add_pop_up.findViewById(R.id.amount_per_dose);
       list_hours_per_day = add_pop_up.findViewById(R.id.times_per_day);
       list_amount_of_pills = add_pop_up.findViewById(R.id.amount_of_pills);
       list_number_of_refills = add_pop_up.findViewById(R.id.number_of_refills);

       list_number_of_days = add_pop_up.findViewById(R.id.number_of_days);
       medicine_save_button = add_pop_up.findViewById(R.id.med_save_button);
    }

} // end Fragment