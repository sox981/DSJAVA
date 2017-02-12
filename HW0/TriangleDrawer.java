/*HW0 Exercise 1b*/
public class TriangleDrawer{

  public static void DrawTriangle( int N ) {
    int col = 0 ;
  /*  int size = N ;
  */
    while(col < N){
      int row = 0 ;
      while(row <= col  ){
        System.out.print("*");
        row ++ ;
      }
        System.out.println();
      col ++;

    }
    System.out.println(col);
  }

  public static void main(String[] args) {
    DrawTriangle(5);
  }
}
