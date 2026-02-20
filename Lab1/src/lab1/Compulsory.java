package lab1;

public class Compulsory {

    public void solve(String[] args){
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
    }
}
