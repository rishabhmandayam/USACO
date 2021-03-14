import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	// write your code here
        MyMain m = new MyMain(args);
    }
}

class MyMain {
    void pr(String s) { System.out.println(s); }
    MyMain(String args[]) {
        Scanner sc = new Scanner(System.in);

        String alpha = sc.next();
        String farmerWord = sc.next();
        char letters[] = farmerWord.toCharArray();
        char cowletters[] = alpha.toCharArray();

        int prevPos = 27;
        int numPasses = 0;

        for (int i = 0; i< letters.length; ++i) {

            int thisPos = alpha.indexOf(letters[i]);

            boolean didnewpass = thisPos <= prevPos;

            if (didnewpass) {
                numPasses += 1;
            }

            prevPos = thisPos;

        }

        pr("" + numPasses);
    }
}



