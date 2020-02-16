//import java.util.Arrays;
/**
 * This class overrides the abstract
 * method from Cardholder.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class SapphireCardholder extends Cardholder
{
  // Constructor

  /**
   * Sets default values for the instance variables.
   *
   * @param acctNumber Command line arguments
   * @param name Command line arguments
   */
   public SapphireCardholder(String acctNumber, String name) 
   {
      super(acctNumber, name);
      category = "Sapphire Cardholder";
   }
   
  /**
   * Returns number of purchase points gained.
   *
   * @return purchase points
   */
   public int purchasePoints()
   {
      int total = (int) totalPurchases();
      return total;
   }
   
 
} 
