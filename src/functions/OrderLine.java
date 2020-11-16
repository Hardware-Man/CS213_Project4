package functions;
/**
 *Class to represent a single line in an order
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class OrderLine {
    private int lineNumber;
    private final Sandwich sandwich;
    private final double price;

    /**
     * Parametrized constructor to create an instance of OrderLine
     * @param lineNumber position in order
     * @param sandwich sandwich ordered
     * @param price price of sandwich
     */
    public OrderLine(int lineNumber,Sandwich sandwich,double price){
        this.lineNumber = lineNumber;
        this.sandwich = sandwich;
        this.price = price;
    }

    /**
     * Getter method for order sandwich
     * @return sandwich
     */
    public Sandwich getSandwich() {
        return sandwich;
    }

    /**
     * Getter method for line number
     * @return line number
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Setter method for line number
     * @param newLineNumber new line number
     */
    public void setLineNumber(int newLineNumber) {
        lineNumber = newLineNumber;
    }

    /**
     * Returns string representation of order line
     * @return string for line
     */
    @Override
    public String toString() {
        return lineNumber  + ", " + sandwich.toString()+ ", $" + price;
    }

    /**
     * Equals method to compare order lines
     * @param obj order line object
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderLine) {
            return (((OrderLine) obj).getLineNumber() == lineNumber) && obj.toString().equals(this.toString());
        }
        return false;
    }

}
