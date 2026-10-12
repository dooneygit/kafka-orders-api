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

    public static void main(String[] args) {
        
    }
}