package com.example.new_med_app.Model;

public class Doctor
{
    private String first_name;
    private String last_name;

    private String address;
    private String city_state;

    private String phone_number;


    public Doctor()
    {
        // null
    }

    public Doctor(String first_name, String last_name, String address, String city_state, String phone_number)
    {
        this.first_name = first_name;
        this.last_name = last_name;

        this.address = address;
        this.city_state = city_state;

        this.phone_number = phone_number;

    }

    public String getFirstName()
    {return first_name;}

    public String getLastName()
    {return last_name;}

    public String getAddress()
    {return address;}

    public String getCityState()
    {return city_state;}

    public String getPhoneNumber()
    {return phone_number;}
}
