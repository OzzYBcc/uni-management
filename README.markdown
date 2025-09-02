# Uni Management

## Overview
This project is a Java application designed to manage university members, including students, professors, secretaries, and administration staff. Developed as part of a Java course at the University of Piraeus, it features a superclass (`Member`) with four subclasses (`Professor`, `Secretary`, `Student`, `Administration`) and an `AdminApp` class with a menu-driven interface. The application supports adding, viewing, searching, editing, and deleting members, with data persistence using serialization.

## Technologies
- **Language**: Java
- **Standard Library**: `java.io` (for serialization), `java.util` (for `ArrayList` and `Scanner`)

## Features
- **Member Class**: Base class with attributes (AM, full name, email address) and serialization support.
- **Subclasses**:
  - `Professor`: Adds a lesson attribute.
  - `Secretary`: Adds a department attribute.
  - `Student`: Adds a lecture attribute.
  - `Administration`: Adds a position attribute.
- **AdminApp Class**: Provides a menu with 7 options:
  - View all members.
  - Add a new member (professor, secretary, student, or administration).
  - Search by name.
  - Search by ID.
  - Edit member details by ID.
  - Delete member by ID.
  - Exit and save data to "members.ser" via serialization.
- **Data Persistence**: Saves and loads member data using Java serialization.

## Installation
1. Clone the repository:
   ```
   git clone https://github.com/OzzYBcc/uni-management.git
   ```
2. Ensure Java Development Kit (JDK) is installed.
3. Compile the code with a Java compiler (e.g., javac):
   ```
   javac com/unipi/p23229/bscplh2024/*.java
   ```
4. Run the application:
   ```
   java com.unipi.p23229.bscplh2024.Main
   ```

## Usage
- **Sample Menu Output**:
  ```
  Menu:
  1. Προβολη ολων των διαθεσιμων καταγεγραμμενων μελων
  2. Προσθηκη νεου μελους
  3. Αναζητηση βασει ονοματος
  4. Αναζητηση βασει κωδικου
  5. Επεξεργασια στοιχειων μελους βασει κωδικου
  6. Διαγραφη μελους βασει κωδικου
  7. Εξοδος απο την εφαρμογη
  Επιλεξτε μια επιλογη: 
  ```
- **Sample Code Snippet (addNewMember Method)**:
  ```java
  private void addNewMember() {
      System.out.print("Εισαγετε κωδικο (AM): ");
      String am = scanner.nextLine();
      System.out.print("Εισαγετε ονομα: ");
      String fullName = scanner.nextLine();
      System.out.print("Εισαγετε email: ");
      String email = scanner.nextLine();
      System.out.print("Επιλεξτε τυπο μελους (1: Professor, 2: Secretary, 3: Student, 4: Administration): ");
      int type = scanner.nextInt();
      scanner.nextLine(); // Clear buffer
      String extraInfo;
      switch (type) {
          case 1: extraInfo = getLesson(); members.add(new Professor(am, fullName, email, extraInfo)); break;
          // ... (other cases)
      }
      System.out.println("Το μελος προσθεθηκε επιτυχως.");
  }
  ```
- Follow the prompts to add, search, or manage members, and select option 7 to exit and save.

## Contributing
Contributions are welcome! Enhance the interface (e.g., add GUI), add validation, or improve serialization by forking the repository and submitting a pull request.

## License
MIT License