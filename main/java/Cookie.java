/**
 * Item class represents an item, having name, weight, price, and barcode.
 *
 * @author dmeyer31
 * @author asundaresan6
 */
public class Cookie {

    private String name;
    private double idNumber;
    private double price;

    /**
     * Creates a new item with the specified identification number. Initializes
     * name as null and price as 0.0.
     * @param  idNumber The identification number of the product.
     */
    public Cookie(double idNumber) {
        this(null, idNumber, 0.0);
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  idNumber The identification number of the item.
     * @param  price   The price of the item in USD.
     */
    public Cookie(String name, double idNumber, double price) {
        this.name = name;
        this.idNumber = idNumber;
        this.price = price;
    }

    /**
     * Gets the price of the cookie.
     * @return  price  The price of the cookie.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Equals method that compares items based on
     * their id and name.
     * @param  o    The object the cookie is being compared to.
     * @return  A boolean indicating whether the two objects are equal
     * based on their name and field.
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cookie)) {
            return false;
        }
        Cookie casted = (Cookie) o;
        return (this.name.equals(casted.name))
            && (this.idNumber == (casted.idNumber));
    }

}
