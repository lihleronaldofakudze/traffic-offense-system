import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Administrator administrator = new Administrator();

            System.out.println("Welcome to the Traffic Offense Database");
            System.out.println("........................................");
            System.out.println("Login, To Gain Access To The Database");
            System.out.println("........................................");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            boolean login = administrator.login(username, password);
            if (login) {
                System.out.println("Login Successful");
                System.out.println("........................................");
                System.out.println("1. Administrator");
                System.out.println("2. Divertion");
                System.out.println("3. Length");
                System.out.println("4. Police");
                System.out.println("5. Role");
                System.out.println("6. Routes");
                System.out.println("7. Traffic");
                System.out.println("8. Exit");
                System.out.println("........................................");
                System.out.print("Enter Your Choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        administratorMenu();
                        break;
                    case 2:
                        divertionMenu();
                        break;
                    case 3:
                        lengthMenu();
                        break;
                    case 4:
                        policeMenu();
                        break;
                    case 5:
                        roleMenu();
                        break;
                    case 6:
                        routesMenu();
                        break;
                    case 7:
                        trafficMenu();
                        break;
                    case 8:
                        System.out.println("Thank You For Using The Traffic Database");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }
        }
    }

    private static void trafficMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Traffic traffic = new Traffic();
            System.out.println("........................................");
            System.out.println("1. Add Traffic");
            System.out.println("2. View Traffic");
            System.out.println("3. Delete Traffic");
            System.out.println("4. Update Traffic");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    traffic.insert();
                    trafficMenu();
                    break;
                case 2:
                    traffic.select();
                    trafficMenu();
                    break;
                case 3:
                    traffic.delete();
                    trafficMenu();
                    break;
                case 4:
                    traffic.update();
                    trafficMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    trafficMenu();
                    break;
            }
        }
    }

    private static void routesMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Routes routes = new Routes();
            System.out.println("........................................");
            System.out.println("1. Add Routes");
            System.out.println("2. View Routes");
            System.out.println("3. Delete Routes");
            System.out.println("4. Update Routes");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    routes.insert();
                    routesMenu();
                    break;
                case 2:
                    routes.select();
                    routesMenu();
                    break;
                case 3:
                    routes.delete();
                    routesMenu();
                    break;
                case 4:
                    routes.update();
                    routesMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    routesMenu();
                    break;
            }
        }
    }

    private static void policeMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Police police = new Police();
            System.out.println("........................................");
            System.out.println("1. Add Police");
            System.out.println("2. View Police");
            System.out.println("3. Delete Police");
            System.out.println("4. Update Police");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    police.insert();
                    policeMenu();
                    break;
                case 2:
                    police.select();
                    policeMenu();
                    break;
                case 3:
                    police.delete();
                    policeMenu();
                    break;
                case 4:
                    police.update();
                    policeMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    policeMenu();
                    break;
            }
        }
    }

    private static void lengthMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Length length = new Length();
            System.out.println("........................................");
            System.out.println("1. Add Length");
            System.out.println("2. View Length");
            System.out.println("3. Delete Length");
            System.out.println("4. Update Length");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    length.insert();
                    lengthMenu();
                    break;
                case 2:
                    length.select();
                    lengthMenu();
                    break;
                case 3:
                    length.delete();
                    lengthMenu();
                    break;
                case 4:
                    length.update();
                    lengthMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    lengthMenu();
                    break;
            }
        }
    }

    private static void roleMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Role role = new Role();
            System.out.println("........................................");
            System.out.println("1. Add Role");
            System.out.println("2. View Role");
            System.out.println("3. Delete Role");
            System.out.println("4. Update Role");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    role.insert();
                    roleMenu();
                    break;
                case 2:
                    role.select();
                    roleMenu();
                    break;
                case 3:
                    role.delete();
                    roleMenu();
                    break;
                case 4:
                    role.update();
                    roleMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    roleMenu();
                    break;
            }
        }
    }

    private static void divertionMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Divertion divertion = new Divertion();
            System.out.println("........................................");
            System.out.println("1. Add Divertion");
            System.out.println("2. View Divertion");
            System.out.println("3. Delete Divertion");
            System.out.println("4. Update Divertion");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    divertion.insert();
                    divertionMenu();
                    break;
                case 2:
                    divertion.select();
                    divertionMenu();
                    break;
                case 3:
                    divertion.delete();
                    divertionMenu();
                    break;
                case 4:
                    divertion.update();
                    divertionMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    divertionMenu();
                    break;
            }
        }
    }

    private static void administratorMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            Administrator administrator = new Administrator();
            System.out.println("........................................");
            System.out.println("1. Add Administrator");
            System.out.println("2. View Administrator");
            System.out.println("3. Delete Administrator");
            System.out.println("4. Update Administrator");
            System.out.println("5. Exit");
            System.out.println("........................................");
            System.out.print("Enter Your Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    administrator.insert();
                    administratorMenu();
                    break;
                case 2:
                    administrator.select();
                    administratorMenu();
                    break;
                case 3:
                    administrator.delete();
                    administratorMenu();
                    break;
                case 4:
                    administrator.update();
                    administratorMenu();
                    break;
                case 5:
                    System.out.println("Thank You For Using The Traffic Database");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    administratorMenu();
                    break;
            }
        }
    }
}
