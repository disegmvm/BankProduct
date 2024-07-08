class DepositAccount extends BankProduct {
    public DepositAccount(String currency, double balance, String name) {
        super(currency, balance, name);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double checkBalance() {
        return this.balance;
    }

    public void closeAccount() {
        this.balance = 0;
    }
}