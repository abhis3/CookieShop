/**
 * NotEnoughFundsException gets thrown
 * when there is not enough money to pay the required amount.
 *
 * @author asundaresan6
 */
public class NotEnoughFundsException extends PaymentFailedException {

    /**
     * Creates a new NotEnoughFundsException with the given message.
     * @param msg The message of the exception.
     */
    public NotEnoughFundsException(String msg) {
        super(msg);
    }

}