package Practice;

import java.util.Scanner;

public class StarProgram$2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows to print stars:");
        int row = sc.nextInt();
        for(int i=row;i>0;i--){
            for (int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
