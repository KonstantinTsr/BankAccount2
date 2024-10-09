import java.util.Date;

public class Transaction {
    private Date date; // Дата транзакции
    private char type; // Тип транзакции: 'W' для снятия, 'D' для депозита
    private double amount; // Сумма транзакции
    private double balanceAfterTransaction; // Баланс после транзакции

    // Конструктор, создающий транзакцию с заданным типом, суммой и балансом после операции
    public Transaction(char type, double amount, double balanceAfterTransaction) {
        this.date = new Date(); // Автоматически присваиваем текущую дату транзакции
        this.type = type; // Тип операции: W — снятие, D — депозит
        this.amount = amount; // Сохраняем сумму транзакции
        this.balanceAfterTransaction = balanceAfterTransaction; // Запоминаем баланс после транзакции
    }

    // Метод для получения даты транзакции
    public Date getDate() {
        return date;
    }

    // Метод для получения типа транзакции
    public char getType() {
        return type;
    }

    // Метод для получения суммы транзакции
    public double getAmount() {
        return amount;
    }

    // Метод для получения баланса после транзакции
    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    // Метод для отображения информации о транзакции в удобном виде
    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", type=" + (type == 'W' ? "Withdrawal" : "Deposit") + // 'Withdrawal' для снятия, 'Deposit' для депозита
                ", amount=" + amount +
                ", balanceAfterTransaction=" + balanceAfterTransaction +
                '}';
    }
}