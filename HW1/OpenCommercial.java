/*
import java.net.*;
import java.io.*;

class OpenCommercial {
    public static void main(String[] arg) throws Exception {
        System.out.println("Please enter the web page name :");
        /*InputStream System.in = new InputStream();

        InputStreamReader isr_keyb = new InputStreamReader(System.in);
        BufferedReader webname = new BufferedReader(isr_keyb);
        String X = webname.readLine();

        System.out.println("https://" + X + ".com");
        System.out.println("Here are the contents:");

        URL u = new URL("https://people.eecs.berkeley.edu/~jrs/61b/lec/15");
        InputStream ins = u.openStream();
        InputStreamReader isr = new InputStreamReader(ins);
        BufferedReader contents = new BufferedReader(isr);

        static void ReadWebtext(int i){
          if(i < 1){
            return;
          }
          String text = contents.readLine();
          ReadWebtext(i-1);
          System.out.println(text);

        }


    }
}
*/
/* OpenCommercial.java */

import java.net.*;
import java.io.*;

/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

    BufferedReader keyboard;
    String inputLine;

    keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();
    System.out.println("https://" + inputLine + ".com");
    /* Replace this comment with your solution.  */
    String webname = "https://"+"www." + inputLine + ".com" ;
    System.out.println("Here are the contents:");
    URL u = new URL(webname);
    InputStream ins = u.openStream();
    InputStreamReader isr = new InputStreamReader(ins);
    BufferedReader contents = new BufferedReader(isr);
    ReadWebtext(5, contents);

  }
    public static void ReadWebtext(int i, BufferedReader line) throws Exception{
      if(i < 1){
        return;
      }
      String text = line.readLine();
      ReadWebtext(i-1,line );
      System.out.println(text);
  }




}
