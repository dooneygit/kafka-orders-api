public class PolicyEngine {

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

    class LifePolicy extends Policy {
        LifePolicy(String holder) {
            super(holder);
        }

        @Override
        double monthlyPremium() {
            return 50.0;
        }
    }

    class CarPolicy extends Policy {
        CarPolicy(String holder) {
            super(holder);
        }

        @Override
        double monthlyPremium() {
            return 120.0;
        }
    }
    
    public static void main(String[] args) {
        
    }
}