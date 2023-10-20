
package javaapplication118;



//the code:
import java.util.*;
class ShortestPathMaze 
{
static int ROW = 5;
static int COL = 5;
 
// To store cell cordinates
static class Cell
{
 int x;
 int y;
 
 public Cell(int x, int y)
 {
 this.x = x;
 this.y = y; } 
};
// Declaring Queue to be used in BFS
static class queueNode {
 Cell pt; // Cell cordinates 
 int dist; // Cell's distance of from the source
 public queueNode(Cell pt, int dist){
 this.pt = pt;
 this.dist = dist; } };


// Check whether given cell(row,col) is a valid cell or not
static boolean checkValid(int row, int col) {
 return ((row >= 0) && (row < ROW) && (col >= 0) && (col < COL));
}
// These arrays show the 4 possible movement from a cell
static int rowNum[] = {-1, 0, 0, 1};
static int colNum[] = {0, -1, 1, 0};

// these arrays will help you travel in the 4 directions more easily
static int bfsLee(int mat[][], Cell src, Cell dest){
    // Function to find the shortest path between source cell and destination cell
    // Function to check if it is possible to go to position (row, col)
    // from the current position. The function returns false if (row, col)
    // is not a valid position or has a value 0 or already visited.

 // Checking if source and destination cell have value 1
 if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1)
 return -1;// -1 indicate no connection 
 boolean [][]visited = new boolean[ROW][COL];
 // Mark the source cell as visited
 visited[src.x][src.y] = true;
 // Create a queue for BFS
 Queue<queueNode> q = new LinkedList<>(); 
 // Distance of source cell is 0
 queueNode s = new queueNode(src, 0);//here the 0is the distance
 q.add(s); // Enqueue source cell
 // Performing BFS starting from source cell
 
 while (!q.isEmpty()) {
 queueNode curr = q.peek();
 Cell pt = curr.pt;
 // If we have reached the destination cell, return the final distance
 if (pt.x == dest.x && pt.y == dest.y)
 return curr.dist;
 q.remove();
 // Otherwise enqueue its adjacent cells with value 1
 for (int i = 0; i < 4; i++) {
 int row = pt.x + rowNum[i];
 int col = pt.y + colNum[i];
// Enqueue valid adjacent cell that is not visited
 if (checkValid(row, col) && 
 mat[row][col] == 1 && 
 !visited[row][col]) {
 visited[row][col] = true;
 queueNode Adjcell = new queueNode
 (new Cell(row, col),
 curr.dist + 1 );
 q.add(Adjcell); } } 
 }
 
 // Return -1 if destination cannot be reached
 return -1; }

// Driver Code
public static void main(String[] args) {
 int mat[][] = {
 { 1, 0, 1, 1, 1 },
 { 1, 0, 1, 0, 1 },
 { 1, 1, 1, 0, 1 },
 { 0, 0, 0, 0, 1 },
 { 1, 1, 1, 0, 1 }}; 
 
 Cell source = new Cell(0, 0);
 Cell dest = new Cell(2, 4);
 int dist = bfsLee(mat, source, dest);
 
 if (dist != -1)
 System.out.println("Length of the Shortest Path is " + dist);
 else
 System.out.println("Shortest Path doesn't exist");
 }
}




