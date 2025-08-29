package com.unipi.p23229.bscplh2024; // Ορίζει το πακέτο της κλάσης Main

import java.io.*; // Εισάγει την Java I/O βιβλιοθήκη για επεξεργασία αρχείων

import java.util.ArrayList; // Εισάγει την κλάση ArrayList από την Java Collections Framework

import java.util.List; // Εισάγει την κλάση List από την Java Collections Framework

import java.util.Scanner; // Εισάγει την κλάση Scanner για ανάγνωση εισόδου από το χρήστη

public class Main { // Δήλωση της κλάσης Main
    public static void main(String[] args) { // Η μέθοδος main, η είσοδος του προγράμματος
        AdminApp menu = new AdminApp(); // Δημιουργία νέου αντικειμένου της κλάσης AdminApp
        menu.start(); // Κλήση της μεθόδου start() για να ξεκινήσει η εκτέλεση της εφαρμογής
    }
}
