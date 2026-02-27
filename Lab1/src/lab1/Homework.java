package lab1;

public class Homework {
    public void solve(){
        int n = 35;
        int m = 1500; //we get outofmemory at around 18k
        if(n < 100){
            int[][] firstMatrix = matrixWhite(n);
            draw(firstMatrix, "rectangle");
            String result = image(firstMatrix);
            System.out.println(result);
        }else{
            long startTime = System.currentTimeMillis();

            int[][] firstMatrix = matrixWhite(n);
            draw(firstMatrix, "rectangle");
            String result = image(firstMatrix);

            long endTime = System.currentTimeMillis();
            System.out.println("time in milliseconds: " + (endTime - startTime));
        }
        if(m < 100){
            int[][] secondMatrix = matrixBlack(m);
            draw(secondMatrix, "circle");
            String result2 = image(secondMatrix);
            System.out.println(result2);
        }else{
            long startTime2 = System.currentTimeMillis();

            int[][] secondMatrix = matrixBlack(m);
            draw(secondMatrix, "circle");
            String result2 = image(secondMatrix);

            long endTime2 = System.currentTimeMillis();
            System.out.println("time in milliseconds for 2nd matrix: " + (endTime2 - startTime2));
        }
    }

    public int[][] matrixWhite(int n) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 255;
            }
        }
        return matrix;
    }

    public int[][] matrixBlack(int n) {
        int[][] matrix = new int[n][n];
        return matrix;
    }

    public void draw(int[][] matrix, String shape) {
        if(shape.equals("circle")){
            int length = matrix.length;
            int centerX = length / 2;
            int centerY = length / 2;
            int radius = length / 4; // half the grid

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {

                    int dx = i - centerX; // distanta de la punctul curent la centru
                    int dy = j - centerY;

                    if ((dx * dx) + (dy * dy) <= (radius * radius)) {
                        matrix[i][j] = 255;
                    }
                }
            }

        } else {
            int length = matrix.length;
            for(int i = length/4; i <= length - length/4; i++){ // left line
                matrix[i][length/4] = 0;
            }
            for(int i = length/4; i <= length - length/4; i++){
                matrix[i][length-length/4] = 0; // right line
            }
            for(int j = length/4; j <= length - length/4; j++){
                matrix[length/4][j] = 0; // top line
            }
            for(int j = length/4; j <= length - length/4; j++){
                matrix[length-length/4][j] = 0; // bottom line
            }
        }
    }

    public String image(int[][] matrix) {
        StringBuilder imageString = new StringBuilder();
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    imageString.append("\u2588\u2588"); // Dark
                } else {
                    imageString.append("\u2591\u2591"); // Light
                }
            }
            imageString.append("\n");
        }
        return imageString.toString();
    }
}