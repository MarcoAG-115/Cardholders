import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
 * This class runs test for the
 * methods in CardholdersPart3App.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class CardholdersPart3AppTest {

   /** 
    * A test for the main method (no input).
    */
   @Test public void main1()
   {
      
      String[] args1 = {};
      CardholdersPart3App.main(args1);
      
      CardholdersPart3App app = new CardholdersPart3App();
   }
   
   /** 
    * A test for the main method (valid input).
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void main2() throws FileNotFoundException
   {
      
      String[] args2 = {"cardholder_data_3_exceptions.txt"};
      CardholdersPart3App.main(args2);
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      
      String test = obj.generateReport();
      test += obj.generateReportByName();
      test += obj.generateReportByCurrentBalance();
   }
   
   
   
   /** 
    * A test for the main method (invalid file).
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void main3() throws FileNotFoundException
   {
      boolean check = false;
      try 
      {
      
         String[] args3 = {"nofile.txt"};
         CardholdersPart3App.main(args3);
      
         CardholderProcessor obj = new CardholderProcessor();
         obj.readCardholderFile("nofile.txt");
         
         CardholdersPart3App app = new CardholdersPart3App(); 
      
      }
      catch (FileNotFoundException e)
      {
         check = true; 
      }
      
      Assert.assertEquals(true, check);
   }
   
   
   
}
