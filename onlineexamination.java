import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = "Default Profile";
    }

    public void updateProfile(String newProfile) {
        this.profile = newProfile;
        System.out.println("Profile updated successfully!");
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password changed successfully!");
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Exam {
     static final String[] QUESTIONS = {
        "Question 1: What is the capital of France?",
        "Question 2: Which planet is known as the Red Planet?",
        "Question 3: What is the largest mammal?"
    };
    private String[] answers = {"Paris", "Mars", "Blue Whale"};
    private boolean[] answered = new boolean[QUESTIONS.length];
     int timer = 5; 

    public void selectAnswer(int questionNumber, String answer) {
        if (questionNumber >= 0 && questionNumber < QUESTIONS.length) {
            if (!answered[questionNumber]) {
                System.out.println("Selected answer for " + QUESTIONS[questionNumber] + ": " + answer);
                answered[questionNumber] = true;
            } else {
                System.out.println("You have already answered this question!");
            }
        } else {
            System.out.println("Invalid question number!");
        }
    }

    public void startExam() {
        System.out.println("Welcome! The exam has started.");
    }

    public void autoSubmit() {
        System.out.println("Time's up! Submitting the exam.");
        int unanswered = 0;
        for (boolean answer : answered) {
            if (!answer) {
                unanswered++;
            }
        }
        if (unanswered > 0) {
            System.out.println("You have " + unanswered + " unanswered question(s).");
    
        } else {
            System.out.println("All questions answered. Exam submitted successfully!");
        }
    }
}

 class onlineexamination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User("username", "password");
        Exam exam = new Exam();

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            System.out.println("Login successful!");
            user.updateProfile("New Profile");
            user.changePassword("newpassword");

            exam.startExam();
            for (int i = 0; i < Exam.QUESTIONS.length; i++) {
                System.out.println(Exam.QUESTIONS[i]);
                System.out.println("Enter your answer:");
                String answer = scanner.nextLine();
                exam.selectAnswer(i, answer);
                try {
                    Thread.sleep(exam.timer * 1000); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            exam.autoSubmit();
            user.logout();
        } else {
            System.out.println("Invalid credentials. Login failed!");
        }
    }
}