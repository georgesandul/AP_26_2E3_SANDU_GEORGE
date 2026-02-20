package lab1;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {

        //1
        System.out.println("Hello World!");
        //2
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for(int i = 0; i < languages.length; i++){
            System.out.println(languages[i]);
        }
        //3
        int n = (int) (Math.random() * 1_000_000); // cu (int) inainte de Math fortam cast-ul din double in int
        System.out.println(n);
        //4
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.println(n);
        //5
        int sumOfDigits = 0;
        while(n != 0) {
            sumOfDigits = sumOfDigits + n % 10;
            n = n / 10;
        }
        System.out.println(sumOfDigits);
        int newResult = sumOfDigits;
        while(newResult/10 != 0){
            int sum = 0;
            while(newResult != 0){
                sum = sum + newResult%10;
                newResult = newResult/10;
            }
            newResult = sum;
        }
        System.out.println(newResult);
        System.out.println("Willi-nilly, this semester I will learn " + languages[newResult]);

        /*Boolean programOnline = true;
        while(programOnline){
            System.out.println("Welcome to my program!");
            int inputN = 0;

            Boolean inputGiven = true;
            if(args.length == 0){
                inputGiven = false;
                System.out.println("No input numbers given.");
            }

            if(inputGiven) {
                inputN = Integer.parseInt(args[0]);
                System.out.println("Passed number (if passed) at program start is: " + inputN);
            }

            int a = 5;
            System.out.println(a);
            String animal = "cat";
            System.out.println(animal);

            int[] ages = new int[4];
            for(int i = 0; i<4; i++){
                ages[i] = i;
                System.out.println(ages[i]);
            }

            int n;
            int m;

            // building a matrix
            System.out.println("Building a matrix. . . ");
            Scanner scanner = new Scanner(System.in);
            if(inputGiven && inputN != 0){
                n = inputN;
                System.out.println("'n' was chosen from the program input. 'n' is: " + n);
            }else{
                System.out.println("Enter value for n:");
                n = scanner.nextInt();
                System.out.println("You chose:" + n);
            }
            System.out.println("Enter value for m:");
            m = scanner.nextInt();
            System.out.println("You chose:" + m);

            int[][] matrixNm = new int[n][m];
            System.out.println("You created a matrix of size " + n + "x" + m);

            //adding numbers to the matrix

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.println("Enter number for row " + i + ", column " + j);
                    matrixNm[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Printing the matrix. . .");

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrixNm[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Matrix printed. Type 'clear' to flush the terminal and start again. Type 'quit' to quit.");

            String action = scanner.next();
            if(action.equals("clear")){
                for(int i = 0; i<=50; i++){
                    System.out.println();
                }
                System.out.println("Terminal cleared!");
            }else if(action.equals("quit")){
                System.out.println("quitting...");
                programOnline = false;
            }else{
                System.out.println("Invalid command");
            }
            scanner.close(); // closing the scanner
        }
        System.exit(0);
         */
    }
}