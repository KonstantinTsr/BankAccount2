import java.util.ArrayList;
import java.util.Date;

class Account {
    private String name; // Имя владельца счета
    private int id; // Идентификатор счета
    private double balance; // Баланс счета
    private static double annualInterestRate = 7.5; // Годовая процентная ставка, общая для всех счетов
    private Date dateCreated; // Дата создания счета
    private ArrayList<Transaction> transactions; // Список для хранения всех транзакций

    // Конструктор по умолчанию, создает "пустой" счет с нулевыми значениями
    public Account() {
        this("Unnamed", 0, 0.0); // Вызываем основной конструктор с дефолтными значениями
    }

    // Конструктор, принимающий имя клиента, id и баланс счета
    public Account(String name, int id, double balance) {
        this.name = name; // Сохраняем имя владельца счета
        this.id = id; // Устанавливаем id
        this.balance = balance; // Устанавливаем баланс
        this.dateCreated = new Date(); // Устанавливаем текущую дату как дату создания счета
        this.transactions = new ArrayList<>(); // Инициализируем список транзакций для этого счета
    }

    // Геттер для имени владельца счета
    public String getName() {
        return name;
    }

    // Геттер для id счета
    public int getId() {
        return id;
    }

    // Геттер для баланса счета
    public double getBalance() {
        return balance;
    }

    // Геттер для годовой процентной ставки (она общая для всех счетов)
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Сеттер для годовой процентной ставки (можем менять процентную ставку)
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    // Геттер для даты создания счета
    public Date getDateCreated() {
        return dateCreated;
    }

    // Метод для вычисления ежемесячных процентов, которые добавляются к балансу
    public double getMonthlyInterest() {
        return balance * (annualInterestRate / 12) / 100; // Процент = баланс * ставка / 12 месяцев
    }

    // Метод для снятия средств с счета
    public void withdraw(double amount) {
        // Проверяем, что сумма для снятия больше 0 и меньше или равна текущему балансу
        if (amount > 0 && amount <= balance) {
            balance -= amount; // Вычитаем сумму из баланса
            System.out.println("Снято: " + amount + ". Текущий баланс: " + balance); // Выводим сообщение о снятии
            transactions.add(new Transaction('W', amount, balance)); // Добавляем запись о транзакции снятия в список
        } else {
            // Если сумма некорректна, выводим ошибку
            System.out.println("Некорректная сумма снятия. Проверьте свой баланс.");
        }
    }

    // Метод для пополнения счета
    public void deposit(double amount) {
        // Проверяем, что сумма для пополнения больше 0
        if (amount > 0) {
            balance += amount; // Добавляем сумму к балансу
            System.out.println("Внесено: " + amount + ". Текущий баланс: " + balance); // Выводим сообщение о пополнении
            transactions.add(new Transaction('D', amount, balance)); // Добавляем запись о транзакции пополнения в список
        } else {
            // Если сумма некорректна, выводим ошибку
            System.out.println("Некорректная сумма пополнения.");
        }
    }

    // Метод для вывода всех транзакций по счету
    public void printTransactions() {
        System.out.println("Транзакции для счета: " + name + " (ID: " + id + ")");
        // Проходим по каждой транзакции и выводим ее
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}