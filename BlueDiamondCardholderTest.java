import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/**
 * This class runs through tests of
 * the BlueDiamondCardholder class methods.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class BlueDiamondCardholderTest 
{

   /** A test for getBonusPurchasePoints(). **/
   @Test public void testGetBonusPurchasePoints() 
   {
      BlueDiamondCardholder bdc = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bdc.setPrevBalance(1200.0);
      System.out.println(bdc + "\n");
      int test = bdc.getBonusPurchasePoints();
      Assert.assertEquals(2500, test);
   }
   
   /** A test for setBonusPurchasePoints(). **/
   @Test public void testSetBonusPurchasePoints() 
   {
      BlueDiamondCardholder bdc = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bdc.setPrevBalance(1200.0);
      bdc.setBonusPurchasePoints(50);
      System.out.println(bdc + "\n");
      int test = bdc.getBonusPurchasePoints();
      Assert.assertEquals(50, test);
   }
   
   /** A test for purchasePoints(). **/
   @Test public void testPurchasePoints() 
   {
      BlueDiamondCardholder bdc = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bdc.setPrevBalance(1200.0);
      bdc.purchasePoints();
      System.out.println(bdc + "\n");
      int test = bdc.purchasePoints();
      Assert.assertEquals(2690, test);
   }
   
   /** A test for purchasePoints2(). **/
   @Test public void testPurchasePoints2() 
   {
      BlueDiamondCardholder bdc2 = 
         new BlueDiamondCardholder("10004", "Jenkins, Jordan");
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      bdc2.purchasePoints();
      System.out.println(bdc2 + "\n");
      int test = bdc2.purchasePoints();
      Assert.assertEquals(47500, test);
   }
   
   /** A test for toString(). **/
   @Test public void testToString() 
   {
      BlueDiamondCardholder bdc = 
         new BlueDiamondCardholder("10003", "King, Kelly");
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0);
      bdc.setPrevBalance(1200.0);
      System.out.println(bdc + "\n");
      String output = "Blue Diamond Cardholder";
      output += "\nAcctNo/Name: 10003 King, Kelly";
      output += "\nPrevious Balance: $1,200.00";
      output += "\nPayment: ($0.00)";
      output += "\nInterest: $12.00";
      output += "\nNew Purchases: $538.20";
      output += "\nCurrent Balance: $1,750.20";
      output += "\nMinimum Payment: $52.51";
      output += "\nPurchase Points: 2,690";
      output += "\n(includes 10.0%";
      output += " discount rate applied to New Purchases)";
      String test = bdc.toString();
      Assert.assertEquals(output, test);
   }
   
   /** A test for toString2(). **/
   @Test public void testToString2() 
   {
      BlueDiamondCardholder bdc2 = 
         new BlueDiamondCardholder("10004", "Jenkins, Jordan");
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      bdc2.purchasePoints();
      System.out.println(bdc2 + "\n");
      String output = "Blue Diamond Cardholder";
      output += "\nAcctNo/Name: 10004 Jenkins, Jordan";
      output += "\nPrevious Balance: $1,200.00";
      output += "\nPayment: ($0.00)";
      output += "\nInterest: $12.00";
      output += "\nNew Purchases: $9,000.00";
      output += "\nCurrent Balance: $10,212.00";
      output += "\nMinimum Payment: $306.36";
      output += "\nPurchase Points: 47,500";
      output += "\n(includes 10.0%";
      output += " discount rate applied to New Purchases)";
      output += "\n(includes 2,500";
      output += " bonus points added to Purchase Points)";
      String test = bdc2.toString();
      Assert.assertEquals(output, test);
   }
   
   
}
