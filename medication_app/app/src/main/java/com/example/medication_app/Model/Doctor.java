package com.example.medication_app.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctor_table")
public class Doctor
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "f_name")
    private String firstName;

    @ColumnInfo(name = "l_name")
    private String lastName;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "city_state")
    private String cityState;

    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    @ColumnInfo(name = "email")
    private String email;


    public Doctor()
    {
        // null
    }

    public Doctor(@NonNull String firstName, @NonNull String lastName, String address, String city_state, @NonNull String phone_number, @NonNull String email)
    {
        // id is created by db

        this.firstName = firstName;
        this.lastName = lastName;

        this.address = address;
        this.cityState = city_state;

        this.phoneNumber = phone_number;
        this.email = email;

    }

    public int getId()
    {return id;}

    public String getFirstName()
    {return firstName;}

    public String getLastName()
    {return lastName;}

    public String getAddress()
    {return address;}

    public String getCityState()
    {return cityState;}

    public String getPhoneNumber()
    {return phoneNumber;}

    public String getEmail()
    {return email;}


    // setters
    public void setId(int id)
    {this.id = id;}

    public void setFirstName(String firstName)
    {this.firstName = firstName;}

    public void setLastName(String lastName)
    {this.lastName = lastName;}

    public void setAddress(String address)
    {this.address = address;}

    public void setCityState(String cityState)
    {this.cityState = cityState;}

    public void setPhoneNumber(String phoneNumber)
    {this.phoneNumber = phoneNumber;}

    public void setEmail(String email)
    {this.email = email;}



} // end Doctor class
