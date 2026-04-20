public class AddOnServiceApp {

    // ----------------------- SERVICE CLASS -----------------------
        private final String serviceName;
        private final double cost;

        public AddOnServiceApp(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public String getServiceName() {
            return serviceName;
        }

        public double getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return serviceName + " (₹" + cost + ")";
        }
    }