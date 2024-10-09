import java.util.Scanner;

public class BankApp {
    // Массив для хранения нескольких банковских счетов
    private static Account[] accounts = new Account[10];

    public static void main(String[] args) {

        // Создаем несколько счетов
        accounts[0] = new Account("Семен", 1233, 1100); // Счет Семена
        for (int i = 1; i < accounts.length; i++) {
            accounts[i] = new Account("Клиент " + i, i, 10000.0); // Остальные счета для тестирования
        }

        Scanner scanner = new Scanner(System.in); // Создаем сканер для ввода с клавиатуры

        // Бесконечный цикл, чтобы программа работала постоянно
        while (true) {
            System.out.print("Введите ID счета (0-9): "); // Запрашиваем у пользователя ID счета
            int id = scanner.nextInt(); // Читаем введенный ID

            // Проверяем, что ID введен корректно
            while (id < 0 || id >= accounts.length) {
                System.out.print("Некорректный ID. Пожалуйста, повторите ввод (0-9): ");
                id = scanner.nextInt(); // Читаем повторный ввод
            }

            boolean exit = false; // Флаг для выхода из цикла
            while (!exit) {
                displayMenu(); // Показываем меню для действий

                int choice = scanner.nextInt(); // Читаем выбор пользователя

                // Обрабатываем выбор пользователя
                switch (choice) {
                    case 1:
                        // Отображаем имя владельца счета и баланс
                        System.out.println("Имя владельца счета: " + accounts[id].getName());
                        System.out.println("Баланс: " + accounts[id].getBalance());
                        break;
                    case 2:
                        // Снятие со счета
                        System.out.print("Введите сумму для снятия: ");
                        double withdrawAmount = scanner.nextDouble(); // Сумма для снятия
                        accounts[id].withdraw(withdrawAmount); // Снимаем деньги со счета
                        break;
                    case 3:
                        // Пополнение счета
                        System.out.print("Введите сумму для пополнения: ");
                        double depositAmount = scanner.nextDouble(); // Сумма для пополнения
                        accounts[id].deposit(depositAmount); // Пополняем счет
                        break;
                    case 4:
                        // Отображение процентного дохода за месяц
                        System.out.println("Процентный доход за месяц: " + accounts[id].getMonthlyInterest());
                        break;
                    case 5:
                        // Печать всех транзакций по счету
                        accounts[id].printTransactions();
                        break;
                    case 6:
                        // Выход из программы для этого счета
                        exit = true;
                        break;
                    default:
                        // Сообщение о некорректном выборе
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Основное меню");
        System.out.println("1: Проверить баланс");
        System.out.println("2: Снять со счета");
        System.out.println("3: Пополнить счет");
        System.out.println("4: Показать процентный доход за месяц");
        System.out.println("5: Показать все транзакции");
        System.out.println("6: Выйти");
        System.out.print("Выберите пункт меню: ");
    }
}