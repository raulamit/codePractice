package ctci.arraysAndStrings;

/**
 * Created by raula on 2/25/2017.
 */
public class InPlaceMatrixRotation {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4, 20},
                {5, 6, 7, 8, 21},
                {8, 10, 11, 12, 22},
                {13, 14, 15, 16, 23},
                {24, 25, 26, 27, 28}};
        
        int matLength = mat.length;
        rotateMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] mat) {
        for (int layer=0; layer<mat.length/2; layer++){
            rotateLayerRight(mat,layer);
        }
    }

    private static void rotateLayerRight(int[][] mat, int layer) {
        int layerLength= mat.length- 2*layer-1;
        for(int i=0;i<layerLength;i++){
            int temp= mat[layer][layer+i];
            mat[layer][layer+i]= mat[layer+layerLength-i][layer];
            mat[layer+layerLength-i][layer]= mat[layer+layerLength][layer+layerLength-i];
            mat[layer+layerLength][layer+layerLength-i]=mat[layer+i][layer+layerLength];
            mat[layer+i][layer+layerLength]=temp;
        }
    }
}
