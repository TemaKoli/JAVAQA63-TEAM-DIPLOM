package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    @Test
    public void shouldNegativeBalance() {
        SavingAccount account = new SavingAccount(
                -1_000,
                1_000,
                10_000,
                5
        );
        account.getBalance();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance()
        );
    }

    @Test
    public void shouldNegativeMinBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                -1_000,
                10_000,
                5
        );

        account.getMinBalance();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getMinBalance()
        );
    }

    @Test
    public void shouldNegativeMaxBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                -1_000,
                5
        );

        account.getMaxBalance();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getMaxBalance()
        );
    }
    @Test
    public void shouldMinBalanceMoreMax2() {
        SavingAccount account = new SavingAccount(
                1_000,
                10_000,
                5_000,
                5
        );

        account.pay(500);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.pay()
        );
    }
    @Test
    public void shouldPayAmount() {
        SavingAccount account = new SavingAccount(
                5_000,
                3_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldAddBalance() {
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
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(
                -200,
                0,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }
}
