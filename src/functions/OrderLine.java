package functions;

public class OrderLine {
    private int lineNumber;
    private Sandwich sandwich;
    private double price;

    public OrderLine(int lineNumber,Sandwich sandwich,double price){
        this.lineNumber = lineNumber;
        this.sandwich = sandwich;
        this.price = price;
    }

    public void setSandwich(Sandwich sandwich) {
        price = sandwich.price();
        this.sandwich = sandwich;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int newLineNumber) {
        lineNumber = newLineNumber;
    }

    @Override
    public String toString() {
        return lineNumber  + ", " + sandwich.toString()+ ", " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderLine) {
            return (((OrderLine) obj).getLineNumber() == lineNumber) && obj.toString().equals(sandwich.toString());
        }
        return false;
    }

}
