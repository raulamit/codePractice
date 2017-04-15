package ctci;

/**
 * Created by raula on 2/8/2017.
 */
public class InPlaceMatrixRotaion {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 20},
                {5, 6, 7, 8, 21},
                {8, 10, 11, 12, 22},
                {13, 14, 15, 16, 23},
                {24, 25, 26, 27, 28}};
        int matLength = mat.length;
        for (int i = 0; i < mat.length / 2; i++) {
            System.out.println(matLength);
            rotateLayerRight(i, matLength, mat);
            matLength -= 2;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateLayerLeft(int offset, int l, int[][] mat){
        for (int i = 0; i < 3; i++) {
            rotateLayerRight(offset, l, mat);
        }
    }


    private static void rotateLayerRight(int offset, int l, int[][] mat) {
        for (int i = 0; i < l - 1; i++) {
            int temp = mat[offset][offset + i];
            mat[offset][offset + i] = mat[offset + l - 1 - i][offset];
            mat[offset + l - 1 - i][offset] = mat[offset + l - 1][offset + l - 1 - i];
            mat[offset + l - 1][offset + l - 1 - i] = mat[offset + i][offset + l - 1];
            mat[offset + i][offset + l - 1] = temp;
        }
    }
}
