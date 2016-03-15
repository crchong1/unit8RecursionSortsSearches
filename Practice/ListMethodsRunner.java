import java.util.ArrayList;

public class ListMethodsRunner extends ListMethods
{
   public static void main(String[] args)
   {
      ArrayList<Integer> tempList = ListMethods.makeList(0);
      if (tempList.size() == 0)
      {
          System.out.println("The list is empty");
      }
      else
      {
         int i=100;
         makeList(i);
         
      }
   }
}