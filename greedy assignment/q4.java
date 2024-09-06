public class q4 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        
        return count >= n;
    }
    
    public static void main(String[] args) {
        int[] flowerbed1 = {1,0,0,0,1};
        int n1 = 1;
        System.out.println("Can place flowers: " + canPlaceFlowers(flowerbed1, n1)); // Output: true
        
        int[] flowerbed2 = {1,0,0,0,1};
        int n2 = 2;
        System.out.println("Can place flowers: " + canPlaceFlowers(flowerbed2, n2)); // Output: false
    }
}
