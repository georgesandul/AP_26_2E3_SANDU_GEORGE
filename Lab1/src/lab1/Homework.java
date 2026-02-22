package lab1;

public class Homework {
    public void solve(){
        int n = 20;
        int[][] firstMatrix = matrixWhite(n);
        draw(firstMatrix, "rectangle");
        image(firstMatrix);
        int m = 20;
        int[][] secondMatrix = matrixBlack(m);
        draw(secondMatrix, "circle");
        image(secondMatrix);
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
            int matrixMidpoint = length/2;
            matrix[matrixMidpoint][matrixMidpoint/2] = 67;    //guidepoint mijloc STANGA
            matrix[matrixMidpoint][matrixMidpoint + matrixMidpoint/2] = 67;   //guidepoint mijloc DREAPTA
            matrix[matrixMidpoint/2][matrixMidpoint] = 67;    //guidepoint mijloc SUS
            matrix[matrixMidpoint + matrixMidpoint/2][matrixMidpoint] = 67;    //guidepoint mijloc JOS

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

    public void image(int[][] matrix) {
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
        System.out.println(imageString.toString());
    }
}