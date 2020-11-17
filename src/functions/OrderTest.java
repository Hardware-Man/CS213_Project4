package functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getOrderLines() {
        Order test = new Order();
        assertEquals(0,Order.lineNumber);
        Sandwich testSandwich = new Chicken();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        assertEquals(1,Order.lineNumber);
        test.remove(new OrderLine(1,testSandwich,testSandwich.price()));
        assertEquals(0,Order.lineNumber);
    }

    @Test
    void add() {
        Order test = new Order();
        Sandwich testSandwich = new Chicken();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        assertEquals((new OrderLine(1,new Chicken(),new Chicken().price())).toString(),test.getOrderLines().get(0).toString());
        testSandwich = new Fish();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        assertEquals((new OrderLine(1,new Chicken(),new Chicken().price())).toString(),test.getOrderLines().get(0).toString());
        assertEquals((new OrderLine(2,new Fish(),new Fish().price())).toString(),test.getOrderLines().get(1).toString());
    }

    @Test
    void remove() {
        Order test = new Order();
        Sandwich testSandwich = new Chicken();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        testSandwich = new Fish();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        assertEquals(2,test.getOrderLines().size());
        test.remove(new OrderLine(2,testSandwich,testSandwich.price()));
        assertEquals((new OrderLine(1,new Chicken(),new Chicken().price())).toString(),test.getOrderLines().get(0).toString());
    }

    @Test
    void clear() {
        Order test = new Order();
        Sandwich testSandwich = new Chicken();
        test.add(new OrderLine(0,testSandwich,testSandwich.price()));
        assertEquals(1,test.getOrderLines().size());
        test.clear();
        assertEquals(0,test.getOrderLines().size());
    }
}