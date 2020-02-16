import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/**
 * This class runs through tests of
 * the DiamondCardholder class methods.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class DiamondCardholderTest {


   


   /** A test for getDiscountRate(). **/
   @Test public void testGetDiscountRate() 
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.getDiscountRate();
      System.out.println(dc + "\n");
      double test = dc.getDiscountRate();
      Assert.assertEquals(.05, test, .000001);
   }
   
   /** A test for setDiscountRate(). **/
   @Test public void testSetDiscountRate() 
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.setDiscountRate(.01);
      System.out.println(dc + "\n");
      double test = dc.getDiscountRate();
      Assert.assertEquals(.01, test, .000001);
   }
   
   /** A test for purchasePoints(). **/
   @Test public void testPurchasePoints() 
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.purchasePoints();
      System.out.println(dc + "\n");
      int test = dc.purchasePoints();
      Assert.assertEquals(1419, test);
   }
   
   /** A test for totalPurchases(). **/
   @Test public void testTotalPurchases() 
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.totalPurchases();
      System.out.println(dc + "\n");
      double test = dc.totalPurchases();
      Assert.assertEquals(473.1, test, .000001);
   }
   
   /** A test for toString(). **/
   @Test public void testToString() 
   {
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat");
      dc.addPurchases(34.5, 100.0, 63.50, 300.0);
      dc.setPrevBalance(1200.0);
      dc.purchasePoints();
      System.out.println(dc + "\n");
      String output = "Diamond Cardholder";
      output += "\nAcctNo/Name: 10002 Jones, Pat";
      output += "\nPrevious Balance: $1,200.00";
      output += "\nPayment: ($0.00)";
      output += "\nInterest: $12.00";
      output += "\nNew Purchases: $473.10";
      output += "\nCurrent Balance: $1,685.10";
      output += "\nMinimum Payment: $50.55";
      output += "\nPurchase Points: 1,419";
      output += "\n(includes 5.0%";
      output += " discount rate applied to New Purchases)";
      String test = dc.toString();
      Assert.assertEquals(output, test);
   }
   
   
}
