/**
 * Venmo implements PaymentMethod. Has several
 * attributes and can throw a PaymentFailedException
 * if there is not enough money.
 *
 * @author asundaresan6
 */
public class Venmo implements PaymentMethod {

    private String username;
    private String password;
    private double balance;

    /**
     * Creates new Venmo  account with the specified properties.
     * @param  username    The user's username.
     * @param  password   The user's password.
     * @param  balance The balance in the account.
     */
    public Venmo(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Tries to pay for the items using the balance in the Venmo account.
     * @param amount The cost of the items the user wants to buy.
     * @throws PaymentFailedException Will be thrown in there is not enough
     * money in the Venmo account.
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {

        if (balance - amount >= 0) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException(
                "There were not enough funds in your Venmo account.");
        }
    }
}