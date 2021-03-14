import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        MyMain m = new MyMain(args);
    }
}

class MyMain {
    void pr(String s) { System.out.println(s); }

    int numGroups(int oddCount) {

        int g = 0;
        while (oddCount >= 2) {
            g++;
            oddCount -= 2;

            if (oddCount == 0) break;

            g++;
            oddCount -= 1;
        }

        if (oddCount == 1) {
            if (g == 0)
                g = 1;
            else if (g % 2 == 0) { // E O E O
                g = g - 1;
            } else {  // E O E
                g += 1;
            }

        } else if (oddCount == 2) {
            if (g == 0)
                g = 1;
            else if (g % 2 == 0) {  // E O E O
                g++;
            } else {  // E O E
                g++;
            }
        }
        return g;
    }



    MyMain(String args[]) {

        int oddCount = 0;
        int evenCount = 0;

        Scanner sc = new Scanner(System.in);

        int numinputs = sc.nextInt();
        for (int i=0; i< numinputs; ++i) {
            int k = sc.nextInt();
            if (k % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }

        int total = 0;
        if (oddCount == evenCount) {
            total = oddCount + evenCount;
        } else if (oddCount < evenCount) {
            total = 2 * oddCount + 1;
        } else  if (evenCount == 0) {
            total = numGroups(oddCount);
        } else {
            total = 2*evenCount;
            int left = oddCount - evenCount;
            total += numGroups(left);
        }

        pr("" + total);
    }
}



