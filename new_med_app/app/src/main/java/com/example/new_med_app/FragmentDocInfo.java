package com.example.new_med_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_med_app.Model.Doctor;
import com.example.new_med_app.Model.DoctorViewModel;
import com.example.new_med_app.Model.Medication;
import com.example.new_med_app.UI.RecDocAdapt;
import com.example.new_med_app.UI.RecyclerDoctorAdapt;
import com.example.new_med_app.UI.RecyclerMedicationAdapt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentDocInfo extends Fragment implements RecDocAdapt.OnContactClickListener
{
    private Button doc_save_button = null;
    private Button doc_email_button = null;
    private Button doc_phone_button = null;

    // doc_popup.xml widget variables
    private EditText doc_first_name= null;
    private EditText doc_last_name= null;
    private EditText doc_email = null;
    private EditText doc_phone_number= null;

    private RecyclerView doc_recycler_view = null;
    private RecyclerDoctorAdapt recycler_adapter = null;
    public RecDocAdapt recDocAdapt = null;
    private ArrayList<Doctor> our_doc_list = null;

    FloatingActionButton add_doc_button = null;

    //to build alert dialog
    private AlertDialog.Builder our_builder = null;
    private AlertDialog our_dialog = null;

    private static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    private static final int MAX_PHONE_NUMBER_LENGTH = 10;
    private static final String TAG = "Clicked";
    public static final String CONTACT_ID = "contact_id";
    private DoctorViewModel doctorViewModel;

    private LiveData<List<Doctor>> docList;



    public FragmentDocInfo()
    {
        // null
    }




 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.doc_info_fragment, container, false);

        doc_recycler_view = view.findViewById(R.id.doc_test_recycler);
        doc_recycler_view.setHasFixedSize(true);
        doc_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));

       doctorViewModel =  new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(DoctorViewModel.class);


       doctorViewModel.getDoctors().observe(this, doctors ->
       {

           Toast.makeText(getActivity(), "fragment doc " + doctors.size() , Toast.LENGTH_LONG).show();



           recDocAdapt = new RecDocAdapt(doctors, getActivity(), this);
           doc_recycler_view.setAdapter(recDocAdapt);


      });

    //    our_doc_list = new ArrayList<>();
        add_doc_button = (FloatingActionButton) view.findViewById(R.id.add_doc_fab);


        // fab
        add_doc_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                createDocPopUp();


         //       Intent intent = new Intent(getContext(), getActivity().getClass());
         //       startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);

                Log.d("TAG", "onCreate"+ "button!!!!!!!!");

            }
        });

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

        doc_save_button = update_pop_up.findViewById(R.id.doc_save_button);

        doc_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // no fields are missing
                if((!doc_first_name.getText().toString().isEmpty()) && (!doc_last_name.getText().toString().isEmpty()) && (!doc_email.getText().toString().isEmpty()) && (!doc_phone_number.getText().toString().isEmpty()))
                {
                    // phone number equals 10 digits
                    if(doc_phone_number.getText().toString().length() == MAX_PHONE_NUMBER_LENGTH)
                    {

                        Doctor doctor = new Doctor(doc_first_name.getText().toString(), doc_last_name.getText().toString(), "123 State ST", "kjhkjkjk", doc_phone_number.getText().toString(), doc_email.getText().toString());

                        DoctorViewModel.insert(doctor);

                        our_dialog.dismiss();
                       Snackbar.make(v, "Phone number must be 10 digits!", Snackbar.LENGTH_LONG).show();
                    }

                    // phone number does not equal 10 digits
                    else
                        Snackbar.make(v, "Phone number must be 10 digits!", Snackbar.LENGTH_LONG).show();

                }

               // field is missing
                else
                    Snackbar.make(v, "Missing a field!!!", Snackbar.LENGTH_LONG).show();

            }
        });

        our_builder.setView(update_pop_up);

        //this displays the dialog
        our_dialog = our_builder.create();
        our_dialog.show();



       /* new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run()
            {
                Intent myIntent = new Intent(getActivity(), getActivity().getClass());

                our_dialog.dismiss();

                startActivity(myIntent);

                //kills previous activity
                getActivity().finish();

            }
        }, 1500); */


    }

    @Override
    public void onContactClick(int position) {
        Doctor doctor = Objects.requireNonNull(doctorViewModel.allDocs.getValue()).get(position);
        Log.d(TAG, "onContactClick: " + doctor.getId());
    }
} // end Fragment