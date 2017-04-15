package ctci.recursionDP;

/**
 * Created by raula on 3/1/2017.
 */
public class RobotInGrid {
    public static void main(String[] args) {
        boolean[][] grid = {{false,true,false},
                {false,false,true},
                {false,false,false}};

        System.out.println(getPath(grid,0,0,""));
    }

    private static boolean getPath(boolean[][] grid, int r, int c,String path) {
        if(r>=grid.length|| c>=grid[0].length ) return false;
        if(grid[r][c]) return false;
        if(r==grid.length-1&& c==grid[0].length-1){
            System.out.println(path);
            return true;
        }else{
            return getPath(grid,r+1,c,path+"d")||getPath(grid,r,c+1,path+"r");
        }


    }
}
