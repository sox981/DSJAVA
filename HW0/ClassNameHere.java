public class ClassNameHere {
   public static int max(int[] m) {
     int size = m.length ;
     int maxnum = m[0]  ;
     int i = 0 ;
     while( i <  size-1 ){
       int x ;
       x = m[i+1] - maxnum;
       if( x >= 0 ){
         maxnum = m[i+1];
       }else {
         maxnum = maxnum;
       }
       i++;
       /*System.out.println(maxnum);
       */
     }
       return maxnum ;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.println(max(numbers));
   }
}
