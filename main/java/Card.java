/**
 * Card implements PaymentMethod. Has several
 * attributes and can throw a PaymentFailedException
 * if there is not enough money.
 *
 * @author asundaresan6
 */
public abstract class Card implements PaymentMethod {

    private String ownerName;
    private double balance;

    /**
     * A constructor using the specified properties.
     * @param  ownerName    The name of the card holder.
     * @param  balance The balance in the account.
     */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Tries to pay for the items using the balance on the card.
     * @param amount The cost of the items the user wants to buy.
     * @throws PaymentFailedException Will be thrown in there is not enough
     * money on the card.
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {

        if (balance - amount >= 0) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException(
                "There were not enough funds on your card.");
        }
    }

}