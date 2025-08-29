package com.unipi.p23229.bscplh2024;

// η κλαση Professor αναπαριστα εναν καθηγητη.
class Professor extends Member {
    // η μεταβλητη lesson αναπαριστα το μαθημα που διδασκει ο καθηγητης.
    private String lesson;

    // κατασκευαστης της κλασης Professor.
    public Professor(String memberId, String fullName, String email, String lesson) {
        super(memberId, fullName, email);
        this.lesson = lesson;
    }

    // μεθοδος για την επιστροφη του μαθηματος που διδασκει ο καθηγητης.
    public String getLesson() {
        return lesson;
    }

    // μεθοδος για την ορισμο του μαθηματος που διδασκει ο καθηγητης.
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    // μεθοδος που επιστρεφει την πληροφορια του καθηγητη συμπεριλαμβανομενου του μαθηματος.
    @Override
    public String toString() {
        return super.toString() + ", Lesson: " + lesson;
    }
}
