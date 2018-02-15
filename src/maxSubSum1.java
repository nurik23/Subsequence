import java.util.Random;
import java.util.Date;
class maxSubSum1 {
    public static int maxSubSum1(int[] num) {
        int maxSum = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++)
                    thisSum += num[k];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println(elapsedTimeSec);
        return maxSum;
    }

    public static int maxSubSum2(int[] num) {
        int maxSum = 0;
        for (int i = 0; i < num.length; i++) {
            int thisSum = 0;
            for (int j = i; j < num.length; j++) {
                thisSum += num[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println(elapsedTimeSec);
        return maxSum;
    }

    public static void main(String[] args) {
        int size = 10;
        int[] num = new int[size];
        Random rand = new Random();
        for (int k = 1; k <= size; k++) {
            int n = rand.nextInt(50) + 1;
            num[k - 1] = n;
        }
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println(elapsedTimeSec);
        System.out.println(maxSubSum1(num));
        System.out.println(maxSubSum2(num));
        System.out.println(maxSumRec(num,0,num.length-1));
        System.out.println(maxSubSum4(num));

    }


    private static int maxSumRec(int[] num, int left, int right) {
        if (left == right) // Base case
            if (num[left] > 0)
                return num[left];
            else
                return 0;
        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(num, left, center);
        int maxRightSum = maxSumRec(num, center + 1, right);
        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += num[i];
            if (leftBorderSum > maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }
        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += num[i];
            if (rightBorderSum > maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return maxLeftSum;
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println(elapsedTimeSec);

    }

    public static int maxSubSum4(int[] num){
        int maxSum = 0, thisSum = 0;
            for(int j = 0;j< num.length ;j++){
            thisSum += num[j];
            if (thisSum > maxSum)
                maxSum = maxSum;
            else if (thisSum < 0)
                thisSum = 0;
            }
            return maxSum;
        long start = System.currentTimeMillis();
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        float elapsedTimeSec = elapsedTimeMillis/1000F;
        System.out.println(elapsedTimeSec);
        }

    }