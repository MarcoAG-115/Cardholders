import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
* This class runs test for the
* methods in CardholderProcessor.
*
* Project 11
* Marco Gonzalez - COMP1210 - 010
* 12/05/2018
*/
public class CardholderProcessorTest {


   /** A test for getCardholdersArray. **/
   @Test public void getCardholdersArrayTest() 
   {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(548);
      sc.setPrevBalance(1200.0);
      sc.setPayment(200.0);
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.addCardholder(sc);
      Cardholder[] test = obj.getCardholdersArray();
      
      Assert.assertEquals(true, sc.equals(test[0]) );
   }
   
   /** A test for getInvalidRecordsArray. **/
   @Test public void getInvalidRecordsArrayTest() 
   {
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.addInvalidRecord("1;10005;Smith, Pam;110p.0;200.0;"
                              + "34.5;100.0;63.50;350.0 *** invalid numeric value ***");
      String[] test = obj.getInvalidRecordsArray();
      String expected = "1;10005;Smith, Pam;110p.0;200.0;34.5"
                           + ";100.0;63.50;350.0 *** invalid numeric value ***";
      Assert.assertEquals(true, expected.equals(test[0]));
   }
   
   /** A test for addCardholder. **/
   @Test public void addCardholderTest() 
   {
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam");
      sc.addPurchases(548);
      sc.setPrevBalance(1200.0);
      sc.setPayment(200.0);
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.addCardholder(sc);
      Cardholder[] test = obj.getCardholdersArray();
      
      Assert.assertEquals(true, sc.equals(test[0]) );
   }
   
   /** A test for addInvalidRecord. **/
   @Test public void addInvalidRecordTest() 
   {
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.addInvalidRecord("1;10005;Smith, Pam;110p.0;200.0;"
                              + "34.5;100.0;63.50;350.0 *** invalid numeric value ***");
      String[] test = obj.getInvalidRecordsArray();
      String expected = "1;10005;Smith, Pam;110p.0;200.0;34.5"
                           + ";100.0;63.50;350.0 *** invalid numeric value ***";
      Assert.assertEquals(true, expected.equals(test[0]));
   }
   
   
   
   /** 
    * A test for readCardholderFile. 
    *
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void readCardholderFileTest() throws FileNotFoundException
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.purchasePoints();
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      Cardholder[] test = obj.getCardholdersArray();
      
      Assert.assertEquals(true, dc.equals(test[0]) );
   }
   
   
   /** 
    * A test for generateReport. 
    *
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void generateReportTest() throws FileNotFoundException
   {
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      Cardholder[] test = obj.getCardholdersArray();
      obj.generateReport();
      
      Assert.assertEquals(true, test.length == 4);
   }
   
   /** 
    * A test for generateReportByName. 
    *
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void generateReportByNameTest() 
      throws FileNotFoundException
   {
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      Cardholder[] test = obj.getCardholdersArray();
      obj.generateReportByName();
      
      Assert.assertEquals(true, test.length == 4);
   }
   
   /** 
    * A test for generateReportByCurrentBalance. 
    *
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void generateReportByCurrentBalanceTest() 
      throws FileNotFoundException
   {
      
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      Cardholder[] test = obj.getCardholdersArray();
      obj.generateReportByCurrentBalance();
      
      CardholderProcessor obj1 = new CardholderProcessor();
      obj1.readCardholderFile("cardholder_data_3_exceptions.txt");
      obj1.generateReportByCurrentBalance();
      Assert.assertEquals(true, test.length == 4);
   }
   
   /** 
    * A test for compare. 
    *
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void compareTest()
   {
      CurrentBalanceComparator comp = new CurrentBalanceComparator();
      
      SapphireCardholder sc1 = new SapphireCardholder("10001", "Smith, Sam");
      sc1.addPurchases(548);
      sc1.setPrevBalance(99.0);
      sc1.setPayment(200.0);
      
      SapphireCardholder sc2 = new SapphireCardholder("10001", "Smith, Sam");
      sc2.addPurchases(548);
      sc2.setPrevBalance(1200.0);
      sc2.setPayment(200.0);
      
      Cardholder c1 = sc1;
      Cardholder c2 = sc2;
      comp.compare(c1, c2);
      
      SapphireCardholder sc3 = new SapphireCardholder("10001", "Smith, Sam");
      sc1.addPurchases(548);
      sc1.setPrevBalance(1200.0);
      sc1.setPayment(200.0);
      
      SapphireCardholder sc4 = new SapphireCardholder("10001", "Smith, Sam");
      sc2.addPurchases(548);
      sc2.setPrevBalance(1200.0);
      sc2.setPayment(200.0);
      
      Cardholder c3 = sc3;
      Cardholder c4 = sc4;
      int test = comp.compare(c3, c4);
      int expected = 0;
      Assert.assertEquals(expected, test);
   }
   
   /** 
    * A test for the main method 
    * (catch exceptions in readCardholder file).
    * @throws FileNotFoundException for File Scanner
    */
   @Test public void exceptionTest() throws FileNotFoundException
   {
      CardholderProcessor obj = new CardholderProcessor();
      obj.readCardholderFile("cardholder_data_3_exceptions.txt");
      String[] test = obj.getInvalidRecordsArray();
      boolean check = false;
      if (test.length == 5)
      {
         check = true;
      }
      
      Assert.assertEquals(true, check);
   }
   
   
   
}
