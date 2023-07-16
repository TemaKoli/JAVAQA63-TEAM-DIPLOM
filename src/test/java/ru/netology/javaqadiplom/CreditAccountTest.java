package ru.netology.javaqadiplom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    /////////////////////////////////////////////метод Add/////////////////////////////////////////////////////
    @Test
    public void AddWithPositiveBalanceTest() {
        CreditAccount account = new CreditAccount(2_000, 6_000, 15);

        account.add(3_000);

        int expected = 5_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    ////////////////////////////////////////////метод yearChange//////////////////////////////////////////////////
    @Test
    public void yearChangePositiveBalanceTest() {
        CreditAccount account = new CreditAccount(1_000, 6_000, 10);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void yearChangeNegativeBalanceTest() {
        CreditAccount account = new CreditAccount(-1_000, 6_000, 10);

        int expected = -100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void yearChangeZeroBalanceTest() {
        CreditAccount account = new CreditAccount(0, 6_000, 10);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
}
