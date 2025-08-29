package com.unipi.p23229.bscplh2024;

import java.io.*;

// η κλαση Member αναπαριστα ενα μελος.
class Member implements Serializable {
    // η μεταβλητη am αναπαριστα τον αριθμο μητρωου του μελους.
    protected String am;
    // η μεταβλητη fullName αναπαριστα το πληρες ονομα του μελους.
    protected String fullName;
    // η μεταβλητη emailAddress αναπαριστα τη διευθυνση email του μελους.
    protected String emailAddress;

    // κατασκευαστης της κλασης Member.
    public Member(String am, String fullName, String emailAddress) {
        this.am = am;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    // μεθοδος για την επιστροφη του αριθμου μητρωου του μελους.
    public String getAm() {
        return am;
    }

    // μεθοδος για την επιστροφη του πληρους ονοματος του μελους.
    public String getFullName() {
        return fullName;
    }

    // μεθοδος για τον ορισμο του πληρους ονοματος του μελους.
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // μεθοδος για τον ορισμο της διευθυνσης email του μελους.
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // μεθοδος για την επιστροφη της διευθυνσης email του μελους.
    public String getEmailAddress() {
        return emailAddress;
    }

    // μεθοδος που επιστρεφει μια συμπληρωμενη περιγραφη του μελους.
    @Override
    public String toString() {
        return "AM: " + am + ", Full Name: " + fullName + ", Email Address: " + emailAddress;
    }
}
