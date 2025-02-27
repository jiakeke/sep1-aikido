import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Main.class.getName());
        System.out.println("===== Aikido Practice Tracker =====");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter start date (yyyy-mm-dd): ");
        String start = scanner.nextLine();
        AikidoTracker tracker = new AikidoTracker(name, start);

        while (true) {
            System.out.println("===== Menu =====");
            System.out.println("1. Add practice session");
            System.out.println("2. Check Kyu Eligibility");
            System.out.println("3. Exit");
            System.out.print("Choose your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter practice date (yyyy-mm-dd): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter practice duration (minutes): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();
                    tracker.addSession(date, duration);
                    break;
                case 2:
                    if (tracker.isEligibleForKyu()) {
                        System.out.println("Congratulations! " + name + " are eligible for Kyu graduation.");
                    } else {
                        System.out.println("Keep practicing! " + name + " is not eligible for Kyu graduation yet.");
                    };
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
