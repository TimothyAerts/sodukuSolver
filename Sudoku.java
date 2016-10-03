package sudoku;



class Sudoku {
    private static final int SIZE = 9;     // size of the grid e.g. 9 -> 9x9
    private static final int DMAX = 9;     // max digit to be filled in 9 -> all digits \in {1,2,3,4,5,6,7,8,9}
    private static final int BOXSIZE = 3;  // size of the boxes e.g. 3 -> 3x3
    int[][] grid = new int[][] {
        { 0, 6, 0,  0, 0, 1,  0, 9, 4 },
        { 3, 0, 0,  0, 0, 7,  1, 0, 0 },
        { 0, 0, 0,  0, 9, 0,  0, 0, 0 },
        { 7, 0, 6,  5, 0, 0,  2, 0, 9 },
        { 0, 3, 0,  0, 2, 0,  0, 6, 0 },
        { 9, 0, 2,  0, 0, 6,  3, 0, 1 },
        { 0, 0, 0,  0, 5, 0,  0, 0, 0 },
        { 0, 0, 7,  3, 0, 0,  0, 0, 2 },
        { 4, 1, 0,  7, 0, 0,  0, 8, 0 },
    };
    
    int solutionnr = 0; //solution counter
    
    boolean givesConflict(int r, int  c, int d) {
        //TODO is there a conflict when we fill in d at position r,c?
        this.rowConflict(r, d);
        this.colConflict(c, d);
        this.boxConflict(r, c, d);
        
        return false;
    }
    
    boolean rowConflict(int r, int d) {
        //TODO is there a conflict in row r when we fill in d?
        for (int column = 0 ; column < SIZE ; column++) {
            if (grid[r][column] == d) {
                return false;
            }
        }
    //END TODO
    return true ;   
    }
    
    boolean colConflict(int c, int d) {
        //TODO is there a conflict in column c when we fill in d?
        for (int row = 0 ; row < SIZE ; row++) {
            if (grid[row][c] == d) {
                return false;
            }
        }
      return true;
    }
    
    boolean boxConflict(int rr, int cc, int d) {
        //TODO is there a conflict when we fill in d at position in the box of rr,cc?
        //Need to create something in order to make sure we only check box. 
        //IE if middle element we need to check left and right if left 2 right if right 2 left etc.
        int rowadj = (rr/BOXSIZE)*BOXSIZE ;
        int coladj = (cc/BOXSIZE)*BOXSIZE;
        
        for (int i = 0; i < BOXSIZE; i++){
            for (int j = 0;j < BOXSIZE; j++){
                if (grid[rowadj+i][coladj+j]!=grid[rr][cc] && 
                    grid[rowadj+i][coladj+j] == d) {
                    return false;
                }
            }
        }
        return true;    
        //END TODO
    }
        
    int[] findEmptySquare() {
        //TODO return the next empty square (See assignment).
        int[] emptycell = new int[2];
        for(int row=0;row<SIZE;row++){
            for (int column=0;column<SIZE;column++){
                if (grid[row][column] == 0){
                    emptycell[0] = row;
                    emptycell[1] = column;
                    return emptycell;
                }
            }
        }
        return null;  
    }
    
    void solve() {
        //TODO see (4)
        this.print();
        this.findEmptySquare();
        for (int d = 1; d <= DMAX; d++) {
        this.givesConflict(this.findEmptySquare()[0], this.findEmptySquare()[1], d);
        }
        //END TODO
    }
    
    // print the grid, 0s are printed as spaces
    void print() {
        //TODO print the grid, printing spaces instead of 0s.
        System.out.print("+-------------------+");
        for (int row = 0 ; row < SIZE ; row++) {
            if ((row % BOXSIZE == 0) && row !=0){
                System.out.println();
                System.out.println("---------------------");
            }else {
                System.out.println();
            }
            for (int column=0;column<SIZE;column++){
                if(column % BOXSIZE == 0){
                    System.out.print("|");
                }
                if (grid[row][column] == 0 && column != 8){
                    System.out.print("  ");
                }else if (grid[row][column] == 0 && column == 8) {
                    System.out.print(" ");
                }else {
                    if(column != 8){
                        System.out.print(grid[row][column]+" ");
                    }
                    else{
                        System.out.print(grid[row][column]);
                    }
                    
                }
                
                
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println("+-------------------+");
        
        
        //END TODO
    }
    
    //TODO extra methods
    
    
    
    //END TODO
    
    
    public static void main(String[] args) {
        new Sudoku().solve();
    }
}
            
       
    
    
                