package functions;

import java.util.ArrayList;

/**
 *Class representing an entire Order
 *
 * @author Kaivalya Mishra, Ridwanur Sarder
 */
public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderLines = new ArrayList<>();

    /**
     * Default constructor for order
     */
    public Order(){
        lineNumber = 0;
    }

    /**
     * Getter method for order lines
     * @return Arraylist of order lines
     */
    public ArrayList<OrderLine> getOrderLines(){
        return orderLines;
    }

    /**
     * Adds an order line to the order
     * @param obj order line instance
     * @return true if success, false if fail
     */
    @Override
    public boolean add(Object obj) {
        if (obj instanceof OrderLine) {
            lineNumber++;
            ((OrderLine) obj).setLineNumber(lineNumber);
            return orderLines.add((OrderLine) obj);
        }
        return false;
    }

    /**
     * Removes an order line from the order
     * @param obj order line instance
     * @return true if success, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if (obj instanceof OrderLine) {
            if (orderLines.contains(obj)) {
                lineNumber--;
                orderLines.subList(orderLines.indexOf(obj), orderLines.size()).
                        forEach(orderLine -> orderLine.setLineNumber(orderLine.getLineNumber()-1));
                return orderLines.remove(obj);
            }
        }
        return false;
    }

    /**
     * Clears an entire order and resets lineNumber
     */
    public void clear(){
        orderLines.clear();
        lineNumber = 0;
    }
}
