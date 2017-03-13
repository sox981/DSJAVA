import java.net.*;
import java.io.*;

class Nuke2{
  public static void main(String[] arg) throws Exception{
    InputStream text_keybd = System.in;
    InputStreamReader y = new InputStreamReader(text_keybd);
    BufferedReader input = new BufferedReader(new InputStreamReader(text_keybd));
    /*String x1 = "haha" ;
    */
    String text = input.readLine();
    String text_First_char = text.substring(0,1);
    String text_ThirdToEnd_char = text.substring(2);

    System.out.println(text); //repeat keybd input

    System.out.println(text_First_char + text_ThirdToEnd_char);
    /*System.out.println( text == System.in);
    */
    /*System.out.println(text_keybd==y.)
  }



}
