package com.unipi.p23229.bscplh2024;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// κλαση για την διαχειριση της εφαρμογης απο τον διαχειριστη
class AdminApp {
    // λιστα για την αποθηκευση των μελων
    private final List<Member> members = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    // ονομα αρχειου για αποθηκευση των μελων
    private static final String FILE_NAME = "members.ser";

    // μεθοδος για την εκκινηση της εφαρμογης
    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Προβολη ολων των διαθεσιμων καταγεγραμμενων μελων");
            System.out.println("2. Προσθηκη νεου μελους");
            System.out.println("3. Αναζητηση βασει ονοματος");
            System.out.println("4. Αναζητηση βασει κωδικου");
            System.out.println("5. Επεξεργασια στοιχειων μελους βασει κωδικου");
            System.out.println("6. Διαγραφη μελους βασει κωδικου");
            System.out.println("7. Εξοδος απο την εφαρμογη");

            System.out.print("Επιλεξτε μια επιλογη: ");
            var choice = scanner.nextInt();
            scanner.nextLine(); // καθαρισμος buffer

            switch (choice) {
                case 1:
                    viewAllMembers();
                    break;
                case 2:
                    addNewMember();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    editMember();
                    break;
                case 6:
                    deleteMember();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Εξοδος απο την εφαρμογη.");
                    serializeMembers();
                    break;
                default:
                    System.out.println("Ακυρη επιλογη, δοκιμαστε ξανα.");
                    break;
            }
        }
    }

    // μεθοδος για την προβολη ολων των μελων
    private void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println("Δεν υπαρχουν διαθεσιμα μελη.");
        } else {
            System.out.println("Λιστα ολων των μελων:");
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    // μεθοδος για την προσθηκη νεου μελους
    private void addNewMember() {
        System.out.println("Τι ειδους μελος θελετε να προσθεσετε;");
        System.out.println("1. Φοιτητης");
        System.out.println("2. Δασκαλος");
        System.out.println("3. Γραμματεια");
        System.out.println("4. Διοικηση");

        int memberType = scanner.nextInt();
        scanner.nextLine(); // καθαρισμος buffer

        System.out.print("Εισαγετε κωδικο μελους: ");
        String memberId = scanner.nextLine();

        System.out.print("Εισαγετε ονοματεπωνυμο: ");
        String fullName = scanner.nextLine();

        System.out.print("Εισαγετε email: ");
        String email = scanner.nextLine();

        switch (memberType) {
            case 1:
                System.out.print("Εισαγετε μαθημα φοιτητη: ");
                String course = scanner.nextLine();
                members.add(new Student(memberId, fullName, email, course));
                break;
            case 2:
                System.out.print("Εισαγετε μαθημα δασκαλου: ");
                String subject = scanner.nextLine();
                members.add(new Professor(memberId, fullName, email, subject));
                break;
            case 3:
                System.out.print("Εισαγετε τμημα γραμματειας: ");
                String department = scanner.nextLine();
                members.add(new Secretary(memberId, fullName, email, department));
                break;
            case 4:
                System.out.print("Εισαγετε θεση διοικησης: ");
                String position = scanner.nextLine();
                members.add(new Administration(memberId, fullName, email, position));
                break;
            default:
                System.out.println("Ακυρος τυπος μελους.");
                break;
        }

        System.out.println("Το μελος προστεθηκε επιτυχως.");
    }

    // μεθοδος για την αναζητηση μελους βασει ονοματος
    private void searchByName() {
        System.out.print("Εισαγετε το ονομα προς αναζητηση: ");
        String name = scanner.nextLine();

        List<Member> foundMembers = new ArrayList<>();

        for (Member member : members) {
            if (member.getFullName().equalsIgnoreCase(name)) {
                foundMembers.add(member);
            }
        }

        if (foundMembers.isEmpty()) {
            System.out.println("Δεν βρεθηκαν μελη με αυτο το ονομα.");
        } else {
            System.out.println("Βρεθηκαν τα παρακατω μελη:");
            for (Member member : foundMembers) {
                System.out.println(member);
            }
        }
    }

    // μεθοδος για την αναζητηση μελους βασει κωδικου
    private void searchById() {
        System.out.print("Εισαγετε τον κωδικο προς αναζητηση: ");
        String memberId = scanner.nextLine();

        boolean found = false;

        for (Member member : members) {
            if (member.getAm().equalsIgnoreCase(memberId)) {
                System.out.println("Βρεθηκε μελος:");
                System.out.println(member);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Δεν βρεθηκε μελος με αυτον τον κωδικο.");
        }
    }

    // μεθοδος για την επεξεργασια στοιχειων μελους
    private void editMember() {
        System.out.print("Εισαγετε τον κωδικο μελους που θελετε να επεξεργαστειτε: ");
        String memberId = scanner.nextLine();

        for (Member member : members) {
            if (member.getAm().equalsIgnoreCase(memberId)) {
                System.out.println("Επεξεργασια στοιχειων για το μελος:");
                System.out.println(member);

                System.out.print("Εισαγετε νεο ονοματεπωνυμο (η αφηστε κενο για να μην αλλαξει): ");
                String newFullName = scanner.nextLine();

                if (!newFullName.isEmpty()) {
                    member.setFullName(newFullName);
                }

                System.out.print("Εισαγετε νεο email (η αφηστε κενο για να μην αλλαξει): ");
                String newEmail = scanner.nextLine();

                if (!newEmail.isEmpty()) {
                    member.setEmailAddress(newEmail);
                }

                System.out.println("Τα στοιχεια του μελους ενημερωθηκαν.");
                return;
            }
        }

        System.out.println("Δεν βρεθηκε μελος με αυτον τον κωδικο.");
    }

    // μεθοδος για την διαγραφη μελους
    private void deleteMember() {
        System.out.print("Εισαγετε τον κωδικο μελους προς διαγραφη: ");
        String memberId = scanner.nextLine();

        Member memberToRemove = null;

        for (Member member : members) {
            if (member.getAm().equalsIgnoreCase(memberId)) {
                memberToRemove = member;
                break;
            }
        }

        if (memberToRemove != null) {
            members.remove(memberToRemove);
            System.out.println("Το μελος διαγραφηκε επιτυχως.");
        } else {
            System.out.println("Δεν βρεθηκε μελος με αυτον τον κωδικο.");
        }
    }

    // μεθοδος για την αποθηκευση των μελων σε αρχειο
    private void serializeMembers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(members);
            System.out.println("Τα μελη αποθηκευτηκαν επιτυχως.");
        } catch (IOException e) {
            System.err.println("Σφαλμα κατα την αποθηκευση των μελων: " + e.getMessage());
        }
    }

    // μεθοδος για την φορτωση των μελων απο αρχειο
    private List<Member> loadMembersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Member>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Δεν βρεθηκε το αρχειο. Δημιουργια νεας λιστας μελων.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Σφαλμα κατα τη φορτωση των μελων: " + e.getMessage());
            return null;
        }
    }
}
