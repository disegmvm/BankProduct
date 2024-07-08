class CreditCard extends BankProduct implements CardOperations {
    private double interestRate;

    public CreditCard(String currency, double balance, String name, double interestRate) {
        super(currency, balance, name);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        this.balance -= amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance += amount;
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }

    public double checkDebt() {
        double debt = this.balance * (1 + interestRate / 100);
        return debt;
    }
}
