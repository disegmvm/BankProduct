import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankProductTests {
    @Test
    public void testDebitCardOperations() {
        DebitCard debitCard = new DebitCard("RUB", 1000.0, "Дебетовая карта");

        // Тест депозита
        debitCard.deposit(500.0);
        assertEquals(1500.0, debitCard.getBalance());

        // Тест снятия
        debitCard.withdraw(300.0);
        assertEquals(1200.0, debitCard.getBalance());

        // Тест снятия с отрицательной суммой
        try {
            debitCard.withdraw(-2.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }

        // Тест снятия с суммой меньше баланса
        try {
            debitCard.withdraw(2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть меньше текущего баланса", e.getMessage());
        }

        // Тест депозита с отрицательной суммой
        try {
            debitCard.deposit(-2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }
    }

    @Test
    public void testCurrencyDebitCardOperations() {
        CurrencyDebitCard currencyDebitCard = new CurrencyDebitCard("USD", 2000.0, "Валютная дебетовая карта");

        // Тест депозита
        currencyDebitCard.deposit(500.0);
        assertEquals(2500.0, currencyDebitCard.getBalance());

        // Тест снятия
        currencyDebitCard.withdraw(1000.0);
        assertEquals(1500.0, currencyDebitCard.getBalance());

        // Тест снятия с отрицательной суммой
        try {
            currencyDebitCard.withdraw(-2.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }

        // Тест снятия с суммой меньше баланса
        try {
            currencyDebitCard.withdraw(2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть меньше текущего баланса", e.getMessage());
        }

        // Тест депозита с отрицательной суммой
        try {
            currencyDebitCard.deposit(-2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }
    }

    @Test
    public void testCreditCardOperations() {
        CreditCard creditCard = new CreditCard("RUB", 1000.0, "Кредитная карта", 5.0);

        // Тест снятия (увеличивает задолженность)
        creditCard.withdraw(500.0);
        assertEquals(1500.0, creditCard.getBalance());

        // Тест депозита (уменьшает задолженность)
        creditCard.deposit(200.0);
        assertEquals(1300.0, creditCard.getBalance());

        // Тест задолженности после манипуляций с балансом (с учётом процентной ставки)
        assertEquals(1365.0, creditCard.checkDebt(), 0.01);

        // Тест вычисления задолженности
        CreditCard creditCard2 = new CreditCard("RUB", 500.0, "Кредитная карта", 10.0);
        assertEquals(550.0, creditCard2.checkDebt(), 0.01);

        // Тест снятия с отрицательной суммой
        try {
            creditCard.withdraw(-2.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }

        // Тест депозита с отрицательной суммой
        try {
            creditCard.deposit(-2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }
    }

    @Test
    public void testDepositAccountOperations() {
        DepositAccount depositAccount = new DepositAccount("USD", 1000.0, "Вклад");

        // Тест депозита
        depositAccount.deposit(500.0);
        assertEquals(1500.0, depositAccount.getBalance());

        // Тест закрытия вклада
        depositAccount.closeAccount();
        assertEquals(0.0, depositAccount.getBalance());

        // Тест депозита с отрицательной суммой
        try {
            depositAccount.deposit(-2000.0);
        } catch (IllegalArgumentException e) {
            assertEquals("Сумма должна быть больше нуля", e.getMessage());
        }
    }
}

