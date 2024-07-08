class CreditCard extends BankProduct implements CardOperations {
    private double interestRate;

    public CreditCard(String currency, double balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        // баланс = задолженность
        this.balance -= amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        this.balance += amount;
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    public double checkDebt() {
        // задолженность с учётом процентной ставки
        return this.balance * (1 + interestRate / 100);
    }
}