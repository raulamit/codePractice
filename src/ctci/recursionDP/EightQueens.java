package ctci.recursionDP;

/**
 * Created by raula on 3/4/2017.
 */
public class EightQueens {
    public static void main(String[] args) {
        int[] board = new int[8];
//        System.out.println(validConfig(new boolean[][]{{false, true, false},{false, true, false},{true, false, false}}));
        printAllQueenPos(board,0);
    }

    private static void printAllQueenPos(int[] board, int row){
    	if(row>=board.length){
    		printBoard(board);
    		return;
    	}
    	else{
    		for(int c=1; c<=board.length; c++){
    			board[row]=c;
    	        if(!validConfig(board, row)) continue;
    			printAllQueenPos(board,row+1);
    			board[row]=0;
    		}
    	}
    }

    private static void printBoard(int [] board){
    	for (int i=0; i<board.length;i++){
    		for (int j=1; j<=board.length;j++){
    		    int out=0;
    		    if(board[i]==j) out=1;
    			System.out.print(out +" ");
    		}
    		System.out.println();
    	}
        System.out.println("\n");
    }



    private static boolean validConfig(int[] board, int row){
        for (int r=0; r<row; r++){
        	if(board[r]==board[row]) return false;
        	if(Math.abs(row-r) == Math.abs(board[row]- board[r])) return false;
        }
    	return true;
    }
}
