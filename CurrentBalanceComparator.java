import java.util.Comparator;
/**
 * This class implements the Comparator
 * interface which implements a method
 * that defines the ordering of Cardholder
 * objects based off the balance amount.
 *
 * Project 11
 * Marco Gonzalez - COMP1210 - 010
 * 12/05/2018
 */
public class CurrentBalanceComparator implements Comparator<Cardholder>
{
 /**
  * Sorts the Cardholder array from
  * highest balance to lowest balance.
  *
  * @return -1, 1, or 0
  * @param c1 Command line arguments
  * @param c2 Command line arguments
  */
   public int compare(Cardholder c1, Cardholder c2)
   {
      if (c1.currentBalance() > c2.currentBalance()) {
         return -1;
      }
      else if (c1.currentBalance() < c2.currentBalance()) {
         return 1;
      }
      else {
         return 0;
      }
   }
}