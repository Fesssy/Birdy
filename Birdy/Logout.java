package com.example.myfirstapp;

import com.google.firebase.auth.FirebaseAuth;

public class Logout {
    public static void main(String[] args) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signOut();
    }
}
