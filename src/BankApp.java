import java.util.Scanner;

public class BankApp {
    private static Account[] accounts = new Account[10];

    public static void main(String[] args) {

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 10000.0);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Введите ID счета (0-9): ");
            int id = scanner.nextInt();


            while (id < 0 || id >= accounts.length) {
                System.out.print("Некорректный ID. Пожалуйста, повторите ввод (0-9): ");
                id = scanner.nextInt();
            }

            boolean exit = false;
            while (!exit) {
                displayMenu();
// fhgbufgkgh
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Баланс равен: " + accounts[id].getBalance());
                        break;
                    case 2:
                        System.out.print("Введите сумму для снятия со счета: ");
                        double withdrawAmount = scanner.nextDouble();
                        accounts[id].withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Введите сумму для пополнения счета: ");
                        double depositAmount = scanner.nextDouble();
                        accounts[id].deposit(depositAmount);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Основное меню");
        System.out.println("1: проверить баланс счета");
        System.out.println("2: снять со счета");
        System.out.println("3: положить на счет");
        System.out.println("4: выйти");
        System.out.print("Введите пункт меню: ");
    }
}
