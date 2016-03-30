/**
 * InvalidCookieException gets thrown
 * when a cookie is not on the menu of existing cookies.
 *
 * @author asundaresan6
 */
public class InvalidCookieException extends Exception {

    /**
     * Creates a new InvalidCookieException
     * by using constructor chaining.
     */
    public InvalidCookieException() {
        this("This Cookie is not on our menu...");
    }

    /**
     * Creates a new InvalidCookieException with the given message.
     * @param msg The message of the exception.
     */
    public InvalidCookieException(String msg) {
        super(msg);
    }
}