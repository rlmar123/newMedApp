package com.example.medication_app;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.medication_app.Model.Medication;
import com.example.medication_app.UI.RecMedAdapt;

import java.util.Objects;


public class FragmentTest extends Fragment
{


   public FragmentTest() { }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
   {
      View view = inflater.inflate(R.layout.home_fragment, container, false);


      return view;
   }






} // end Fragment