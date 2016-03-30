import java.time.LocalDate;

/**
 * Demo shows how CheckoutPage works. It shows that it
 * handles server errors as well as other errors.
 *
 * @author asundaresan6
 */
public class Demo {
    /**
     * The main method that tests a host of different errors.
     * @param  args  The various arguments being utilized.
     */
    public static void main(String[] args) {

        System.out.println(
            "Testing when there are enough funds to pay (Venmo):");

        try {
            CheckoutPage checkTest = new CheckoutPage();
            Cookie checkCookie = new Cookie("Cookie Cake", 123456789, 21.99);
            checkTest.addToCart(checkCookie);

            Venmo test = new Venmo("asundaresan6", "testVenmo", 30.0);
            checkTest.payForCart(test);

        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
        ////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println(
            "Testing when there are enough funds to pay (Credit Card):");

        try {
            CheckoutPage checkTest2 = new CheckoutPage();
            Cookie checkCookie2 = new Cookie("Cookie Cake", 123456789, 21.99);
            checkTest2.addToCart(checkCookie2);

            CreditCard test2 = new CreditCard(
                "Abhinav Sundaresan", 30.0, LocalDate.of(2017, 11, 20));
            checkTest2.payForCart(test2);

        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (CardExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
        /////////////////////////////////////////////////////////
        System.out.println();
        System.out.println(
            "Testing when there are NOT enough funds to pay (Venmo):");

        try {
            CheckoutPage checkTest = new CheckoutPage();
            Cookie checkCookie = new Cookie("Cookie Cake", 123456789, 21.99);
            checkTest.addToCart(checkCookie);

            Venmo test = new Venmo("asundaresan6", "testVenmo", 10.0);
            checkTest.payForCart(test);

        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        /////////////////////////////////////////////////////////
        System.out.println();
        System.out.println(
            "Testing when there are NOT enough funds to pay (Credit Card):");

        try {
            CheckoutPage checkTest2 = new CheckoutPage();
            Cookie checkCookie2 = new Cookie("Cookie Cake", 123456789, 21.99);
            checkTest2.addToCart(checkCookie2);

            CreditCard test2 = new CreditCard(
                "Abhinav Sundaresan", 10.0, LocalDate.of(2017, 11, 20));
            checkTest2.payForCart(test2);


        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (CardExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        /////////////////////////////////////////////////////////
        System.out.println();
        System.out.println("Testing when the user's credit card is expired:");

        try {
            CheckoutPage checkTest2 = new CheckoutPage();
            Cookie checkCookie2 = new Cookie("Cookie Cake", 123456789, 21.99);
            checkTest2.addToCart(checkCookie2);

            CreditCard test2 = new CreditCard(
                "Abhinav Sundaresan", 100.0, LocalDate.of(2014, 11, 20));
            checkTest2.payForCart(test2);

        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (CardExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        /////////////////////////////////////////////////////////
        System.out.println();
        System.out.println(
            "Testing when the user tries to buy a cookie that does not exist:");

        try {
            CheckoutPage checkTest3 = new CheckoutPage();
            Cookie checkCookie3 = new Cookie("Cookie Cake", 123456788, 21.99);
            checkTest3.addToCart(checkCookie3);

            CreditCard test3 = new CreditCard(
                "Abhinav Sundaresan", 100.0, LocalDate.of(2017, 11, 20));
            checkTest3.payForCart(test3);

        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (CardExpiredException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCookieException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        /////////////////////////////////////////////////////////
        System.out.println();
        System.out.println(
            "Testing when the user cannot connect to the server:");

        try {
            while (true) {
                Server.getValidCookies();
            }
        } catch (ServerException e) {
            System.out.println(e.getMessage());
        }
    }
}