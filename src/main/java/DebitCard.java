class DebitCard extends BankProduct implements CardOperations {
    public DebitCard(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Сумма не может быть отрицательной");
        }
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }
}
