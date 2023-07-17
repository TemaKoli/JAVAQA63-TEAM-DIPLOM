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
    @Test
    public void AddWithNegativeRateTest() {
        CreditAccount account = new CreditAccount(3_000, 6_000, 15);

        boolean expected = false;
        boolean actual = account.add(-3_000);

        Assertions.assertEquals(expected, actual);
    }

    ////////////////////////////////////////////метод yearChange//////////////////////////////////////////////////
    @Test
    public void yearChangePositiveBalanceTest() {
        CreditAccount account = new CreditAccount(1_000, 6_000, 10);

        account.pay(500);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void yearChangeNegativeBalanceTest() {
        CreditAccount account = new CreditAccount(1_000, 6_000, 10);

        account.pay(2000);

        int expected = -100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void yearChangeZeroBalanceTest() {
        CreditAccount account = new CreditAccount(0, 6_000, 5);

        account.pay(4000);

        int expected = -100;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void yearChangeMoreCreditLimitBalanceTest() {
        CreditAccount account = new CreditAccount(1000, 6_000, 5);

        account.pay(7000);

        int expected = 0;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

   ////////////////////////////////////////////////Тест исключения для rate///////////////////////////////////////////////
    @Test
    public void IllegalArgumentExceptionRateTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new CreditAccount(1000, 10000, -15);});
    }
    ////////////////////////////////////////////////Тест исключения для initialBalance///////////////////////////////////////////////
    @Test
    public void IllegalArgumentExceptionInitialBalanceTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new CreditAccount(-1000, 10000, 15);});
    }
    ////////////////////////////////////////////////Тест исключения для creditLimit///////////////////////////////////////////////
    @Test
    public void IllegalArgumentExceptionCreditLimitTest() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {new CreditAccount(1000, -10000, 15);});
    }
}
