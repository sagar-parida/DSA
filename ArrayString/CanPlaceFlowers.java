package DSA.ArrayString;

class CanPlaceFlowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {

                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean rightEmpty = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }

        return count == n;
    }
}