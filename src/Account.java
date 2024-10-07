import java.util.Scanner;

class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снято: " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Некорректная сумма снятия. Проверьте свой баланс.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("На счет внесено: " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Некорректная сумма внесения.");
        }
    }
}

