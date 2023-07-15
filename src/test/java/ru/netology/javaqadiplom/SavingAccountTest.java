package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                0,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }
}
