public class ThisTest{
  int a ;
  public ThisTest(){
    this(42);
  }
  public ThisTest(int a){
    this.a = a ;
  }

  public String toString(){
  /*  int a = 1;
    System.out.println(a);
    System.out.println(this.a);
    */
    String s = this.a + "/";
    return s ;
  }

  public static void main(String[] args) {
      ThisTest t = new ThisTest();
      System.out.println(t);
  }
}
