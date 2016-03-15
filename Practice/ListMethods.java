import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = new ArrayList(100);

      if (n <= 0)  // The smallest list we can make
      {
          tempList.add(1);
      }
      else        // All other size lists are created here
      {
          makeList(n-1);
          tempList.add(n);
      }
      return tempList;
   }
}