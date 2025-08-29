package com.unipi.p23229.bscplh2024;

// η κλαση Administration αναπαριστα ενα μελος της διοικησης.
class Administration extends Member {
    // η μεταβλητη position αναπαριστα τη θεση του μελους της διοικησης.
    private String position;

    // κατασκευαστης της κλασης administration.
    public Administration(String am, String fullName, String emailAddress, String position) {
        super(am, fullName, emailAddress);
        this.position = position;
    }

    // μεθοδος για την επιστροφη της θεσης του μελους της διοικησης.
    public String getPosition() {
        return position;
    }

    // μεθοδος για τον ορισμο της θεσης του μελους της διοικησης.
    public void setPosition(String position) {
        this.position = position;
    }

    // μεθοδος που επιστρεφει την πληροφορια του μελους της διοικησης συμπεριλαμβανομενης της θεσης.
    @Override
    public String toString() {
        return super.toString() + ", Position: " + position;
    }
}
