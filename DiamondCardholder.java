import java.text.DecimalFormat;
//import java.util.Arrays;
/**
 * This class contains an object that will
 * receibe three purchase points per dollar
 * spent as well as a 5% discount on the 
 * subtotal.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class DiamondCardholder extends Cardholder
{
      // Instance Variables
   
      /** The discount rate. */
   protected double discountRate = .05;
      
      // Constructor

      /**
       * Sets default values for the instance variables.
       *
       * @param acctNumber Command line arguments
       * @param name Command line arguments
       */
   public DiamondCardholder(String acctNumber, String name) 
   {
      super(acctNumber, name);
      category = "Diamond Cardholder";
   }
       
       //Methods
   
       /**
        * Returns the discount rate.
        *
        * @return The discount rate
        */
   public double getDiscountRate()
   {
      return discountRate;
   }
   
       /**
        * Sets a value to the discount rate.
        *
        * @param discountRateIn Command line arguments
        */
   public void setDiscountRate(double discountRateIn)
   {
      discountRate = discountRateIn;
   }
        
       /**
        * Returns number of purchase points gained
        * with 3 point mulitplier.
        *
        * @return purchase points
        */
   public int purchasePoints()
   {
      double purchase = totalPurchases();
      int total = (int) purchase * 3;
      return total;
   }
        
       /**
        * Returns total items in purchase array
        * with discount applied.
        *
        * @return array number size
        */
   public double totalPurchases()
   {
      double total = 0;
      for (int i = 0; i < purchases.length; i++)
      {
         total = total + purchases[i];
      }
      return total - (total * discountRate);
   }
        
      /**
       * Returns output.
       *
       * @return output
       */
   public String toString()
   {
      DecimalFormat newFormat1 = new DecimalFormat("$#,##0.00");
      DecimalFormat newFormat2 = new DecimalFormat("#,##0");
      DecimalFormat newFormat3 = new DecimalFormat("0.0%");
      String output = category;
      output += "\nAcctNo/Name: " + acctNumber + " " + name;
      output += "\nPrevious Balance: " + newFormat1.format(prevBalance);
      output += "\nPayment: (" + newFormat1.format(payment) + ")";
      output += "\nInterest: " + newFormat1.format(interest());
      output += "\nNew Purchases: " + newFormat1.format(totalPurchases());
      output += "\nCurrent Balance: " + newFormat1.format(currentBalance());
      output += "\nMinimum Payment: " + newFormat1.format(minPayment());
      output += "\nPurchase Points: " + newFormat2.format(purchasePoints());
      output += "\n(includes " + newFormat3.format(getDiscountRate());
      output += " discount rate applied to New Purchases)";
      return output;
   }
   
 
}