import java.time.LocalDate;

/**
 * CardExpiredException gets thrown
 * when the card being used is expired.
 *
 * @author asundaresan6
 */
public class CardExpiredException extends PaymentFailedException {

    /**
     * Creates a new CardExpiredException with the given information.
     * @param expirationDate The expiration date of type LocalDate.
     */
    public CardExpiredException(LocalDate expirationDate) {
        super("Card expired on " + expirationDate.toString());
    }

}