public class q3 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            // If tank is negative, it means we can't reach the next station
            if (tank < 0) {
                // Reset start to the next station and reset tank
                start = i + 1;
                tank = 0;
            }
        }
        
        // If totalGas is less than totalCost, it's impossible to complete the circuit
        if (totalGas < totalCost) {
            return -1;
        }
        
        return start;
    }
    
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Starting gas station index: " + canCompleteCircuit(gas, cost)); // Output: 3
    }
}
