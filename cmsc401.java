//Moriah Hammond
import java.util.Scanner;

public class cmsc401
{
    public static int findLineOfBestFit(int coord[],int k,int low,int high)
    {

        if(low == high){
            return coord[low];
        }

        int m = partition(coord,low,high);

        int length = m - low + 1;

        if(length == k){
            return coord[m];
        }

        if(length > k){
            return findLineOfBestFit(coord,k,low,m-1);
        }

        else {
            return findLineOfBestFit(coord,k-length,m+1,high);
        }

    }


    private static int partition(int coord[],int low, int high){
        int pivotValue = coord[high];

        while(low < high){
            while(coord[low] < pivotValue){
                low++;
            }

            while(coord[high] > pivotValue){
                high--;
            }

            if(coord[low] == coord[high]){
                low++;
            }
            else if(low < high){
                int temp = coord[low];
                coord[low] = coord[high];
                coord[high] = temp;
            }
        }
        return high;
    }

    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);

      final int   NUMBER_OF_HOUSES = sc.nextInt();
      sc.nextLine();

      int homeCoordinates[] = new int[NUMBER_OF_HOUSES];

      for(int i = 0; i < NUMBER_OF_HOUSES; i++){
             homeCoordinates[i] = sc.nextInt();
        }

      sc.close();

      System.out.println(findLineOfBestFit(homeCoordinates,(homeCoordinates.length)/2 + 1,0,homeCoordinates.length-1));


    }
}
