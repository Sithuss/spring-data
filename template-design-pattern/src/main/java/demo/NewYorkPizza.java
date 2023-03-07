package demo;

public class NewYorkPizza extends PizzaTemplate{
    @Override
    public void prepared() {
        System.out.println("New York Pizza:: prepared.");
    }

    @Override
    public void bake() {
        System.out.println("New York Pizza:: baked.");

    }

    @Override
    public void topping() {
        System.out.println("New York Pizza:: topping.");

    }

    @Override
    public void serve() {
        System.out.println("New York Pizza:: serve..");

    }

    @Override
    public void checkBill() {
        System.out.println("New York Pizza:: check bill.");

    }
}
