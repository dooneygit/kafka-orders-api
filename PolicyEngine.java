import java.util.*;

public class PolicyEngine {
    static void rename(Policy policy) {
        policy.setHolder("Changed");
    }

    static void replace(Policy policy) {
        policy = new LifePolicy("New");
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

