import java.util.*;

public class PolicyEngine {
    static void rename(Policy policy) {
        policy.setHolder("Changed");
    }

    static void placeOrder(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Order amount must be positive");
        }

        System.out.println("Order placed");
    }

    public static void main(String[] args) {
        LifePolicy lifePolicy = new LifePolicy("Dooney");
        lifePolicy.print();

        CarPolicy carPolicy = new CarPolicy("Dooney");
        carPolicy.print();

        List<Policy> policies = new ArrayList<>();
        policies.add(lifePolicy);
        policies.add(carPolicy);

        for(Policy policy : policies) {
            System.out.println("Holder: " + policy.getHolder());
            System.out.println("Monthly premium: " + policy.monthlyPremium());
        }

        rename(lifePolicy);
        lifePolicy.print();

        try {
            placeOrder(50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Order attempt finished");
        }
    }
}

abstract class Policy {
    private String holder;

    Policy(String holder) {
        this.holder = holder;
    }

    public String getHolder() {
        return holder;
    }
    
    public void setHolder(String holder) {
        this.holder = holder;
    }

    abstract double monthlyPremium();
}

class LifePolicy extends Policy implements Printable{
    LifePolicy(String holder) {
        super(holder);
    }

    @Override
    double monthlyPremium() {
        return 50.0;
    }

    @Override
    public void print() {
        System.out.println("Life Policy for " + getHolder());
    }
}

class CarPolicy extends Policy implements Printable {
    CarPolicy(String holder) {
        super(holder);
    }

    @Override
    double monthlyPremium() {
        return 120.0;
    }

    @Override
    public void print() {
        System.out.println("Car Policy for " + getHolder());
    }
}

interface Printable {
    void print();
}

