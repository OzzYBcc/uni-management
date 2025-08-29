package com.unipi.p23229.bscplh2024;

// η κλαση Secretary αναπαριστα εναν γραμματεα.
class Secretary extends Member {
    // η μεταβλητη tmima αναπαριστα το τμημα στο οποιο εργαζεται ο γραμματεας.
    private String tmima;

    // κατασκευαστης της κλασης Secretary.
    public Secretary(String memberId, String fullName, String email, String tmima) {
        super(memberId, fullName, email);
        this.tmima = tmima;
    }

    // μεθοδος για την επιστροφη του τμηματος στο οποιο εργαζεται ο γραμματεας.
    public String getTmima() {
        return tmima;
    }

    // μεθοδος για την ορισμο του τμηματος στο οποιο εργαζεται ο γραμματεας.
    public void setTmima(String tmima) {
        this.tmima = tmima;
    }

    // μεθοδος που επιστρεφει την πληροφορια του γραμματεα συμπεριλαμβανομενου του τμηματος.
    @Override
    public String toString() {
        return super.toString() + ", Department: " + tmima;
    }
}
