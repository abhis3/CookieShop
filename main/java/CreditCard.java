import java.time.LocalDate;
/**
 * CreditCard extends Card. Has several
 * attributes and can throw a PaymentFailedException
 * if the credit card is expired.
 *
 * @author asundaresan6
 */
public class CreditCard extends Card {

    private LocalDate expirationDate;

    /**
     * Creates new CreditCard with the specified properties.
     * @param  ownerName    The name of the card holder.
     * @param  balance The balance in the account.
     * @param  expirationDate The expiration date of the credit card.
     */
    public CreditCard(String ownerName,
                      double balance,
                      LocalDate expirationDate) {
        super(ownerName, balance);
        this.expirationDate = expirationDate;
    }

    /**
     * Checks whether the credit card is expired or not.
     * @param amount The cost of the items the user wants to buy.
     * @throws PaymentFailedException Will be thrown if the credit
     * card is expired.
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {

        if (expirationDate.isBefore(LocalDate.now())) {
            throw new CardExpiredException(expirationDate);
        } else {
            super.pay(amount);
        }

    }
}