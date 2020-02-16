import org.junit.Assert;
//import static org.junit.Assert.*;
//import org.junit.Before;
import org.junit.Test;

/**
 * This class runs through tests of
 * the SapphireCardholder class
 * methods. Methods from the parent
 * class (Cardholder) are also tested.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class SapphireCardholderTest {


   


   /** A test for purchasePoints(). **/
   @Test public void testPurchasePoints() 
   {
      SapphireCardholder sc1 = new SapphireCardholder("10001", "Smith, Sam");
      sc1.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc1.setPrevBalance(1200.0);
      sc1.setPayment(200);
      sc1.purchasePoints();
      System.out.println(sc1 + "\n");
      int test = sc1.purchasePoints();
      Assert.assertEquals(548, test);
   }
   
   /** A test for getAcctNumber(). **/
   @Test public void testGetAcctNumber() 
   {
      SapphireCardholder sc2 = new SapphireCardholder("10001", "Smith, Sam");
      sc2.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc2.setPrevBalance(1200.0);
      sc2.setPayment(200);
      sc2.getAcctNumber();
      System.out.println(sc2 + "\n");
      String test = sc2.getAcctNumber();
      Assert.assertEquals("10001", test);
   }
   
   /** A test for setAcctNumber(). **/
   @Test public void testSetAcctNumber() 
   {
      SapphireCardholder sc3 = new SapphireCardholder("10001", "Smith, Sam");
      sc3.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc3.setPrevBalance(1200.0);
      sc3.setPayment(200);
      sc3.setAcctNumber("10002");
      System.out.println(sc3 + "\n");
      String test = sc3.getAcctNumber();
      Assert.assertEquals("10002", test);
   }
   
   /** A test for getName(). **/
   @Test public void testGetName() 
   {
      SapphireCardholder sc4 = new SapphireCardholder("10001", "Smith, Sam");
      sc4.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc4.setPrevBalance(1200.0);
      sc4.setPayment(200);
      sc4.getName();
      System.out.println(sc4 + "\n");
      String test = sc4.getName();
      Assert.assertEquals("Smith, Sam", test);
   }
   
   /** A test for setName(). **/
   @Test public void testSetName() 
   {
      SapphireCardholder sc5 = new SapphireCardholder("10001", "Smith, Sam");
      sc5.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc5.setPrevBalance(1200.0);
      sc5.setPayment(200);
      sc5.setName("Doe, John");
      System.out.println(sc5 + "\n");
      String test = sc5.getName();
      Assert.assertEquals("Doe, John", test);
   }
   
   /** A test for getPrevBalance(). **/
   @Test public void testGetPrevBalance() 
   {
      SapphireCardholder sc6 = new SapphireCardholder("10001", "Smith, Sam");
      sc6.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc6.setPrevBalance(1200.0);
      sc6.setPayment(200);
      sc6.getPrevBalance();
      System.out.println(sc6 + "\n");
      double test = sc6.getPrevBalance();
      Assert.assertEquals(1200.0, test, .00001);
   }
   
   
   /** A test for setPrevBalance(). **/
   @Test public void testSetPrevBalance() 
   {
      SapphireCardholder sc7 = new SapphireCardholder("10001", "Smith, Sam");
      sc7.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc7.setPrevBalance(1200.0);
      sc7.setPayment(200);
      sc7.setPrevBalance(1500.0);
      System.out.println(sc7 + "\n");
      double test = sc7.getPrevBalance();
      Assert.assertEquals(1500.0, test, .00001);
   }
   
   /** A test for getPayment(). **/
   @Test public void testGetPayment() 
   {
      SapphireCardholder sc8 = new SapphireCardholder("10001", "Smith, Sam");
      sc8.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc8.setPrevBalance(1200.0);
      sc8.setPayment(200);
      sc8.getPayment();
      System.out.println(sc8 + "\n");
      double test = sc8.getPayment();
      Assert.assertEquals(200, test, .00001);
   }
   
   /** A test for getPurchases(). **/
   @Test public void testGetPurchases() 
   {
      SapphireCardholder sc9 = new SapphireCardholder("10001", "Smith, Sam");
      sc9.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc9.setPrevBalance(1200.0);
      sc9.setPayment(200);
      sc9.getPurchases();
      System.out.println(sc9 + "\n");
      double[] test = sc9.getPurchases();
      double[] expected = {34.5, 100.0, 63.50, 350.0};
      Assert.assertArrayEquals(expected, test, .00001);
   }
   
   /** A test for setPurchases(). **/
   @Test public void testSetPurchases() 
   {
      SapphireCardholder sc10 = new SapphireCardholder("10001", "Smith, Sam");
      sc10.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc10.setPrevBalance(1200.0);
      sc10.setPayment(200);
      double[] newPurchases = {44.5, 200.0, 73.50, 450.0};
      sc10.setPurchases(newPurchases);
      System.out.println(sc10 + "\n");
      double[] test = sc10.getPurchases();
      double[] expected = {44.5, 200.0, 73.50, 450.0};
      Assert.assertArrayEquals(expected, test, .00001);
   }
   
   /** A test for addPurchases(). **/
   @Test public void testAddPurchases() 
   {
      SapphireCardholder sc11 = new SapphireCardholder("10001", "Smith, Sam");
      sc11.addPurchases(34.5, 100.0, 350.0);
      sc11.setPrevBalance(1200.0);
      sc11.setPayment(200);
      sc11.addPurchases(99.0);
      sc11.addPurchases();
      System.out.println(sc11 + "\n");
      double[] test = sc11.getPurchases();
      double[] expected = {34.5, 100.0, 350.0, 99.0};
      Assert.assertArrayEquals(expected, test, .00001);
   }
   
   /** A test for deletePurchases(). **/
   @Test public void testDeletePurchases() 
   {
      SapphireCardholder sc12 = new SapphireCardholder("10001", "Smith, Sam");
      sc12.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc12.setPrevBalance(1200.0);
      sc12.setPayment(200);
      sc12.deletePurchases(99.0);
      sc12.deletePurchases(34.5, 63.50);
      System.out.println(sc12 + "\n");
      double[] test = sc12.getPurchases();
      double[] expected = {100.0, 350.0};
      Assert.assertArrayEquals(expected, test, .00001);
   }
   
   /** A test for balance(). **/
   @Test public void testBalance() 
   {
      SapphireCardholder sc13 = new SapphireCardholder("10001", "Smith, Sam");
      sc13.addPurchases(34.5, 100.0, 63.50, 350.0);
      sc13.setPrevBalance(1200.0);
      sc13.setPayment(200);
      sc13.balance();
      System.out.println(sc13 + "\n");
      double test = sc13.balance();
      Assert.assertEquals(1758, test, .00001);
   }
}
