package com.example.springboot.model;

public class Admin
{
    // static variable single_instance of type Singleton
    private static Admin single_instance = null;

    private boolean hasConnection;

    // private constructor restricted to this class itself
    private Admin()
    {
    }

    public void setConnection(String password)
    {
        hasConnection = password.equals("123456");
    }

    public boolean isConnected()
    {
        return hasConnection;
    }

    // static method to create instance of Singleton class
    public static Admin getInstance()
    {
        if (single_instance == null)
            single_instance = new Admin();

        return single_instance;
    }
}
