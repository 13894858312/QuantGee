import java.util.Scanner;

public class Main {
    public static void calculate(int m, int n) {
        boolean flag = false;

        for(int i=m; i<=n; ++i) {
            int a = i/100;
            int b = (i - a*100)/10;
            int c = i - a*100 - b*10;

            int temp = (int)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));

            if(temp == i) {
                System.out.println(i+" ");
                flag = true;
            }
        }

        if(!flag) {
            System.out.println("no");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            calculate(m, n);
        }
    }
}

