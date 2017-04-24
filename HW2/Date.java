/* Date.java */

import java.io.*;


class Date {

  /* Put your private data fields here. */
  public int month;
  public int day;
  public int year;

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
    if(isValidDate(month, day, year)){
      this.month = month;
      this.day = day;
      this.year = year;
    }else{
      System.out.println("Error!!! the date is invalid!");
      System.exit(0);
    }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
   String[] date = s.split("/");
   month = Integer.parseInt(date[0]);
   day = Integer.parseInt(date[1]);
   year = Integer.parseInt(date[2]);

   if(!isValidDate(month, day, year)){
     System.out.println("Error!!! the date is invalid!");
     System.exit(0);
   }
  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    boolean isp_1 = year%4 == 0 && year%100 !=0 ;
    boolean isp_2 = year%400 == 0 ;
    if(isp_1 == true || isp_2 == true){
      return true;
    }else{
      return false;
    }

                          // replace this line with your solution
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    switch(month){                             // replace this line with your solution
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      case 2:
        if(isLeapYear(year)){
          return 29;
        }else{
          return 28;
        }

      default:
        return 31;
    }
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    if(year >= 0 && (month >= 1 && month <= 12)){
      switch(month){                             // replace this line with your solution
        case 4:
        case 6:
        case 9:
        case 11:
          if(day <= 30 && day >= 1){
            return true;
          }else{
            return false;
          }
       case 2:
          /*System.out.println("isLeapYear =" + isLeapYear(year));*/
          if(isLeapYear(year)){
            if(day <=29 && day >= 1){
              return true;
            }else{
              return false;
            }
          }else{
            /*System.out.println(day);*/
            if(day <=28 && day >= 1){
              return true;
            }else{
              /*System.out.println(isLeapYear(year));*/
              return false;
            }
          }

        default:
          if(day <= 31 && day >= 1){
            return true;
          }else{
            return false;
          }
      }                        // replace this line with your solution
    }else{
      return false;
    }
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are expressed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    String date_text = month + "/"+ day +"/" + year;
    return date_text;                     // replace this line with your solution
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d.
   */
  public boolean isBefore(Date d) {
    // replace this line with your solution
    int y_dif = d.year - this.year ;
    int m_dif = d.month - this.month ;
    int d_dif = d.day - this.day ;

    if(y_dif > 0){                      //year-d behind year-this is ture
      return true;
    }else if(y_dif < 0){
      return false;                     //year-d behind year-this is false
    }

    if(m_dif > 0){                      //month-d behind month-this is ture
      return true;
    }else if(m_dif < 0){
      return false;                     //month-d behind month-this is false
    }

    if(d_dif > 0){                      //day-d behind day-this is ture
      return true;
    }else if(d_dif < 0){
      return false;                     //day-d behind day-this is false
    }
    System.out.println(this + " & " + d +" both the dates is the same date");
    return false;

  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d.
   */
  public boolean isAfter(Date d) {
    boolean sameday = ((this.day - d.day) == 0);
    return !(this.isBefore(d) || sameday);
                        // replace this line with your solution

  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is used only for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    int this_dsims = 0 ;
      for(int i = 1 ; i < this.month; i++ ){
        this_dsims = this_dsims + daysInMonth(i, this.year);
      }
      int days = this_dsims + this.day;
      return days;

                              // replace this line with your solution
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {

    Date d1 = new Date("12/31/0");    // the start of passed year
    Date d2 = new Date("12/31/0");    // the start of passed year

    int thisYearDays_pass = 0 ;
    int dYearDays_pass = 0 ;

    //add all this.days in passed years -->accomulate
    for(int i = 0 ; i < this.year; i++ ){
      d1.year = i ;
      thisYearDays_pass = thisYearDays_pass + d1.dayInYear();
    }
    //add all d.days in passed years
    for(int j = 0 ; j < d.year; j++ ){
      d2.year = j ;
      dYearDays_pass = dYearDays_pass + d2.dayInYear();
    }


    int day_diff = (thisYearDays_pass + this.dayInYear()) -
                   (dYearDays_pass + d.dayInYear());
    return day_diff;            // replace this line with your solution

  }

  public static void main(String[] argv) {
    /*System.out.println("\nTesting constructors.");
    Date d0 = new Date("0/28/2001");
    System.out.println("Date should be 2/28/2001: " + d0);
    */
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */
    /*System.out.println("Is 1984 leap year? " + isLeapYear(1984));
    System.out.println("Feb has " + daysInMonth(2,1984) + " days");
    System.out.println("Feb has " + daysInMonth(2,1981) + " days");
    System.out.println("1/21/1984 is "+ isValidDate(1, 21, 1984));
    System.out.println("1/31/1984 is "+ isValidDate(1, 31, 1984));
    System.out.println("13/21/1984 is "+ isValidDate(13, 21, 1984));
    System.out.println("1/45/1984 is "+ isValidDate(1, 45, 1984));
    System.out.println("1/3/-200 is "+ isValidDate(1, 3, -200));
    System.out.println("2/29/1981 is "+ isValidDate(2, 29, 1981));
    System.out.println("2/29/1984 is "+ isValidDate(2, 29, 1980));
    System.out.println("2/28/1981 is "+ isValidDate(2, 28, 1981));
    System.out.println("2/30/1981 is "+ isValidDate(2, 30, 1981));
    System.out.println("2/-30/1981 is "+ isValidDate(2, -30, 1981));

    System.out.println("Is 1981 leap year? " + isLeapYear(1981));
    System.out.println("Feb has " + daysInMonth(2,1981) + " days");

    System.out.println("Is 100 leap year? " + isLeapYear(100));
    System.out.println("Jun has " + daysInMonth(6,1984) + " days");

    System.out.println("Is 400 leap year? " + isLeapYear(400));
    System.out.println("Oct has " + daysInMonth(10,1984) + " days");
    */


    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " +
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " +
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " +
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " +
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " +
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " +
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " +
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " +
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " +
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " +
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " +
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " +
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " +
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " +
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " +
                       d5.difference(d4));

  }
}
