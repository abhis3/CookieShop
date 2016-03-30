import java.util.ArrayList;

/**
 * CheckoutPage has several attributes and can throw a
 * a variety of exceptions based on the situation. Does things
 * such as adds items to a cart and pays for them.
 *
 * @author asundaresan6
 */
public class CheckoutPage {

    private ArrayList<Cookie> validCookies;
    private ArrayList<Cookie> cart;

    /**
     * Constructor that catches ServerException
     * and keeps trying until it gets validCookies.
     */
    public CheckoutPage() {
        while (validCookies == null) {
            try {
                validCookies = Server.getValidCookies();
            } catch (ServerException e) {
                System.out.println(e.getMessage());
            }
        }
        cart = new ArrayList<Cookie>();
    }

    /**
     * Tries to add a given cookie to the cart.
     * @param cookie A Cookie that represents a specific cookie.
     * @throws InvalidCookieException Will be thrown if the cookie is
     * is not on the menu (CSV File).
     */
    public void addToCart(Cookie cookie) throws InvalidCookieException {
        if (validCookies.contains(cookie)) {
            //validCookies.indexOf(Cookie cookie);
            int holder = validCookies.indexOf(cookie);
            cart.add(validCookies.get(holder));
        } else {
            throw new InvalidCookieException();
        }
    }

    /**
     * Gets the total price of all the items in the cart.
     * @return sum A double that represents the cost of the entire cart.
     */
    public double getTotalPrice() {
        double sum = 0;
        for (Cookie onecookie : cart) {
            sum = sum + onecookie.getPrice();
        }
        return sum;
    }

    /**
     * Tries to pay for the cart using a specific payment method.
     * If successful, it empties the cart.
     * @param method The PaymentMethod that will be used to pay for the cart.
     * @throws PaymentFailedException Will be thrown if there is an
     * error while paying for the cart.
     */
    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        method.pay(getTotalPrice());
        cart.clear();
        if (method instanceof Venmo) {
            System.out.println("Venmo Payment Successful.");
        } else if (method instanceof CreditCard) {
            System.out.println("Credit Card Payment Successful.");
        }
    }
}