package Bank.Products;

class DebitCard extends BankProduct implements CardOperations {
    public DebitCard(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Сумма должна быть меньше текущего баланса");
        }
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }
}