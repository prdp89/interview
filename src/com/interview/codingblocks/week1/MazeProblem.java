package com.interview.codingblocks.week1;

//Explanation here : https://www.youtube.com/watch?v=MNQrDlaHAbw
//Task is to find path in a 2d array or maze. Zero means we are blocked, 1 means we can go further.
//We are maintaining a similar 2D array to store paths visited. We will backtrack on this Path matrix if we reach end or on a wrong path.


//Some code : https://drive.google.com/file/d/0B5h8pgrQfZnVS0k4QUV1QjMwVEE/view
public class MazeProblem {

    public static void main( String[] args ) {
        int n = 3;
        int maze[][] = {
                {
                        1, 1, 0
                },
                {
                        1, 1, 0
                },
                {
                        0, 1, 1
                }};

        findPath(maze, n);
    }

    private static void findPath( int[][] maze, int n ) {
        int path[][] = new int[3][3];

        findPath(maze, path, n, 0, 0);
    }

    //This method find all possible path in 3 * 3 MAZE
    //where x = rowIndex, y= columnIndex
    private static void findAllPath( int[][] maze, int[][] path, int n, int x, int y ) {

        //if bounds are out of reach
        if (x < 0 || x >= n || y < 0 || y >= n)
            return;

        //if we reach at the End of MAZE
        if (x == n - 1 && y == n - 1) {

            //assigning last path at MAZE[x][y] to path array
            path[x][y] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");

            return;
        }

        //maze[x][y] == 0 means : we are block to going forward
        //path[x][y] == 1 means : we are traversing on the same path, this will cause loop
        if (maze[x][y] == 0 || path[x][y] == 1) {
            return;
        }

        //otherwise, we can record the current cell of MAZE as visited and mark path[x][y] = 1
        path[x][y] = 1;

        // Right (x,y+1) = (i,j+1)
        findAllPath(maze, path, n, x, y + 1);

        //left
        findAllPath(maze, path, n, x, y - 1);

        // top
        findAllPath(maze, path, n, x - 1, y);

        // Down
        findAllPath(maze, path, n, x + 1, y);

        //we are backtracking from the current path by marking it as zero, if all matches false
        path[x][y] = 0;
    }

    //This method find single path in 3 * 3 MAZE
    private static boolean findPath( int[][] maze, int[][] path, int n, int x, int y ) {

        //if bounds are out of reach
        if (x < 0 || x >= n || y < 0 || y >= n)
            return false;

        //if we reach at the End of MAZE
        if (x == n - 1 && y == n - 1) {

            //assigning last path at MAZE[x][y] to path array
            path[x][y] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");

            return true;
        }

        //maze[x][y] == 0 means : we are block to going forward
        //path[x][y] == 1 means : we are traversing on the same path, this will cause loop
        if (maze[x][y] == 0 || path[x][y] == 1) {
            return false;
        }

        //otherwise, we can record the current cell of MAZE as visited and mark path[x][y] = 1
        path[x][y] = 1;

        // Right (x,y+1) = (i,j+1)
        if(findPath(maze, path, n, x, y + 1))
        {
            //we are backtracking from the current path if any match false by marking it as zero

            path[x][y] = 0;
            return true;
        }

        //left
        if(findPath(maze, path, n, x, y - 1)) {

            //we are backtracking from the current path if any match false by marking it as zero

            path[x][y] = 0;
            return true;
        }

        // top
        if(findPath(maze, path, n, x - 1, y)) {

            //we are backtracking from the current path if any match false by marking it as zero

            path[x][y] = 0;
            return true;
        }

        // Down
        if(findPath(maze, path, n, x + 1, y)) {

            //we are backtracking from the current path if any match false by marking it as zero

            path[x][y] = 0;
            return true;
        }

        //we are backtracking from the current path by marking it as zero, if we are not able to go anywhere(top,left,right, bottom)
        path[x][y] = 0;
        return false;
    }
}
