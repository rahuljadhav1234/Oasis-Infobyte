import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {

    private static Map<String, String> userCredentials = new HashMap<>();
    private static Map<String, Reservation> reservations = new HashMap<>();

    public static void main(String[] args) {
      
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login\n2. Make Reservation\n3. Cancel Reservation\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Online Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void makeReservation(Scanner scanner) {
      
        Reservation reservation = new Reservation();

        System.out.print("Enter your name: ");
        reservation.setPassengerName(scanner.next());
        System.out.print("Enter train number: ");
        reservation.setTrainNumber(scanner.next());
        System.out.print("Enter class type: ");
        reservation.setClassType(scanner.next());
        System.out.print("Enter date of journey: ");
        reservation.setDateOfJourney(scanner.next());
        System.out.print("Enter source station: ");
        reservation.setSourceStation(scanner.next());
        System.out.print("Enter destination station: ");
        reservation.setDestinationStation(scanner.next());

     
        String reservationId = "R" + reservations.size();
        reservations.put(reservationId, reservation);

        System.out.println("Reservation successful! Your reservation ID is: " + reservationId);
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter reservation ID to cancel: ");
        String reservationId = scanner.next();

        if (reservations.containsKey(reservationId)) {
            reservations.remove(reservationId);
            System.out.println("Reservation with ID " + reservationId + " has been canceled.");
        } else {
            System.out.println("Invalid reservation ID. Please check and try again.");
        }
    }
}

class Reservation {
    private String passengerName;
    private String trainNumber;
    private String classType;
    private String dateOfJourney;
    private String sourceStation;
    private String destinationStation;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "passengerName='" + passengerName + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", classType='" + classType + '\'' +
                ", dateOfJourney='" + dateOfJourney + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                '}';
    }
}
