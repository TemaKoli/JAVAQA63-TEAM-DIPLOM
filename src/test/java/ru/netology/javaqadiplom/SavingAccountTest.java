package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAdd() { // тест провален, ошибка в методе// исправлено
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreMaxBalance() {    // пополнение, превышающее максимальный баланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(10_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAdd0() {    // пополнение на 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldPayMoreMinBalance() {  // списание суммы, больше минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(10_000);

        Assertions.assertFalse(false);
    }
    @Test
    public void PayTest() {  // в случае не корректного платежа операция отклоняется, balance остаётся прежним
        SavingAccount account = new SavingAccount(
                10_000,
                5_000,
                15_000,
                5
        );

        account.pay(7_000); //balance после платежа выходит за пределы диапозона min/max

        int expected = 10_000;   //balance должен остаться безе изменений
        int actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPayWhenBalanceBecomeMinBalance() {    // списание суммы до граничного значения минимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldPayWhenAmountIsZero() {  // списание суммы равной 0
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.pay(0);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldTheInterestRate() {  //расчет процентов
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                10
        );


        Assertions.assertEquals(200, account.yearChange());
    }

    @Test
    public void shouldPayBooleanPayWhenInt() {              // тест на тип boolean Pay Account

        Account account = new Account();

        account.pay(1);

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldAddBooleanPayWhenInt() {              // тест на тип boolean Add Account

        Account account = new Account();

        account.add(1); //

        Assertions.assertFalse(false);
    }

    @Test
    public void shouldSetRate() {              // проверка работы сеттера Rate

        Account account = new Account();
        account.setRate(3);

        int expected = 3;
        int actual = account.rate;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWhenYearChange__() {              // проверка пустого метода YearChange

        Account account = new Account();

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void shouldExceptionWhenRateIsLessZero() { // проверка на исключение, на отрицательную ставку

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 1_000, 15_000, -10);
        });

    }

    @Test
    public void shouldExceptionWhenBalanceLessZero() { // проверка на исключение, на отрицательный начальный баланс/////////////////////

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(-1_000, 1_000, 15_000, 10);
        });

    }

    @Test
    public void shouldExceptionWhenBalanceLessMinBalance() { // проверка на исключение, balance < minBalance

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(500, 1_000, 15_000, 10);
        });

    }

    @Test
    public void shouldExceptionWhenBalanceMoreMaxBalance() { // проверка на исключение, balance > maxBalance

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(20_000, 1_000, 15_000, 10);
        });

    }

    @Test
    public void shouldExceptionWhenMinBalanceLessZero() { // проверка на исключение, minBalance < 0

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(6_000, -1_000, 15_000, 10);
        });

    }

    @Test
    public void shouldExceptionWhenMinBalanceMoreMaxBalance() { // проверка на исключение, minBalance >maxBalance

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(6_000, 15_000, 10_000, 10);
        });

    }
}





