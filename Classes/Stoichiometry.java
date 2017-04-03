
/**
 * Write a description of class Stoichiometry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Stoichiometry
{
    public void Stoichiometry()
    {
        double UserGrams = 0;
        
    }
    public static void main (String[] args)
    {
            int UserCoefficient = 0;
            String UserString = "";
            
            int reactCount = 0;
            int molCount = 5;
            String[] molNames = new String [molCount];
            int[] molNums = new int[molCount];
            
            int UserIndex = 0;
            for(int i = 0; i < molNames.length; i++)
            {
                if(UserString == molNames[i])
                {
                    UserIndex = i;
                }     
            }
            int factor = UserCoefficient/molNums[UserIndex];
            for(int x = 0; x < molNums.length; x++)
            {
               molNums[x] = factor * molNums[x];
            }
            int y;
            for (y = 1; y < molCount; y++)
            {
                System.out.print(molNums[y-1] + molNames[y-1]);
                if(y==reactCount)
                {
                    System.out.print("->");
            
                }else{System.out.println("+");}
            }
            System.out.println(molNums[y]+molNames[y]);
            
    }
}
