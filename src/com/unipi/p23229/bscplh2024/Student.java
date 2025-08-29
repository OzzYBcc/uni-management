package com.unipi.p23229.bscplh2024;

// η κλαση Student αναπαριστα εναν φοιτητη.
class Student extends Member {
    // η μεταβλητη lecture αναπαριστα το μαθημα που παρακολουθει ο φοιτητης.
    private String lecture;

    // κατασκευαστης της κλασης Student.
    public Student(String memberId, String fullName, String email, String lecture) {
        super(memberId, fullName, email);
        this.lecture = lecture;
    }

    // μεθοδος για την επιστροφη του μαθηματος που παρακολουθει ο φοιτητης.
    public String getLecture() {
        return lecture;
    }

    // μεθοδος για την ορισμο του μαθηματος που παρακολουθει ο φοιτητης.
    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    // μεθοδος που επιστρεφει την πληροφορια του φοιτητη συμπεριλαμβανομενου του μαθηματος.
    @Override
    public String toString() {
        return super.toString() + ", Lecture: " + lecture;
    }
}
