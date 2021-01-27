package scratch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * Class that explores the various things you can do with sub-arrays
 */
public class subarray 
{
	//Kadane’s Algorithm to find the maximum sub array
	public static void maxSubArray(int[] array)
	{
		int max = Integer.MIN_VALUE, subMax = 0;	//Initializes the final max and sub array max values 
		int tracker = 0, start = 0, end = 0;		//tracks the start and end indexes of the sub array 
		
		//loops thought the array to find the max sub array
		for(int i = 0 ; i < array.length; i++)
		{
			subMax = subMax + array[i];
			
			if(max < subMax)
			{
				//gets the start value of the sub array
				if(tracker == 0)
				{
					start = i;
					end = i;	//defaults the end value to be the same as the start
					//System.out.println("Start: " + start);
					tracker++;	
				}
				else if(tracker == 1)		//gets the end index of the sub-array
				{
					//found a value that index i that makes it a bigger sub-array
					end = i;
					//System.out.println("End: " + end);
				}
				
				max = subMax;
			}
			
			//if the sub array's sum becomes negative, then the process needs to be restarted to find 
			//another potential maximum sub-array
			if(subMax < 0)
			{
				subMax = 0;
				tracker = 0;
			}
		}
		
		int[] arr = new int[end-start+1];
		int c = 0;
		for(int j = start; j <= end; j++)
		{
			arr[c] = array[j];
			System.out.print(arr[c] + " ");
			c++;
		}
		
		System.out.println("\nMaximum value: " + max);
	}
	
	
	public static void main(String args[]) 
	{
		int[] a = {-90, 50, -2, -1, -9, -7};
		int[] b = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		maxSubArray(b);
	}
}
