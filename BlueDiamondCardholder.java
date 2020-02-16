import java.text.DecimalFormat;
//import java.util.Arrays;
/**
 * This class contains an object that
 * will receive five purchase points
 * per dollar spent as well as a 10%
 * discount on the subtotal. A bonus
 * 2,500 points will be granted if 
 * purchases exceed $2,500.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class BlueDiamondCardholder extends DiamondCardholder
{
  // Instance variables
  
  /** Bonus points. */
   private int bonusPurchasePoints = 2500;
  
  // Constructor
  
  /**
   * Sets default values for the instance variables.
   *
   * @param acctNumber Command line arguments
   * @param name Command line arguments
   */
   public BlueDiamondCardholder(String acctNumber, String name) 
   {
      super(acctNumber, name);
      category = "Blue Diamond Cardholder";
      discountRate = .10;
   }
   
   // Methods
   
  /**
   * Returns the bonus points.
   *
   * @return The bonus points
   */
   public int getBonusPurchasePoints()
   {
      return bonusPurchasePoints;
   }
  
  /**
   * Sets a value to bonusPuchasePoints.
   *
   * @param bonusPurchasePointsIn Command line arguments
   */
   public void setBonusPurchasePoints(int bonusPurchasePointsIn)
   {
      bonusPurchasePoints = bonusPurchasePointsIn;
   }
   
  /**
   * Returns number of purchase points gained
   * with 5 point mulitplier.
   *
   * @return purchase points
   */
   public int purchasePoints()
   {
      double points = totalPurchases();
      int total = (int) points * 5;
      if (totalPurchases() > bonusPurchasePoints)
      {
         total += bonusPurchasePoints;
      }
      return total;
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
      output += "\n(includes " + newFormat3.format(discountRate);
      output += " discount rate applied to New Purchases)";
      if (totalPurchases() > 2500)
      {
         output += "\n(includes " + newFormat2.format(bonusPurchasePoints);
         output += " bonus points added to Purchase Points)";
      }
      return output;
   }
   
 
}