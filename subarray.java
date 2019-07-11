package scratch;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class subarray 
{
	//Kadane’s Algorithm to find the maximum sub array
	public static void maxArray(int[] array)
	{
		int[] arr = new int[array.length];
		int max = Integer.MIN_VALUE, subMax = 0;	//Initializes the final max and sub array max values 
		int counter = 0;
		int tracker = 0, start = 0, end = 0;		//tracks the start and end indexes of the sub array 
		
		//loops thought the array to find the max sub array
		for(int i = 0 ; i < array.length; i++)
		{
			subMax = subMax + array[i];
			arr[counter++] = array[i];
			
			if(max < subMax)
			{
				//gets the start value of the sub array
				if(tracker == 0)
				{
					start = i;
					//System.out.println("Start: " + start);
					tracker++;
					
				}
				else if(tracker == 1)		//gets the end index of the sub array
				{
					end = i;
					//System.out.println("End: " + end);
					tracker++;
				}
				
				//System.out.println(subMax);
				max = subMax;
				//System.out.println(max);
				
			}
			
			//if the sub array becomes negative, then the process needs to be restarted to find 
			//another potential sub array
			if(subMax < 0)
			{
				subMax = 0;
				arr = new int[array.length];
				counter = 0;
				tracker = 0;
			}
			
		}
		
		//prints out the values from the given array that together creates the max sub array
		//prints out the sum of the sub array
		int c = start;
		for(int j = start; j <= end; j++)
		{
			System.out.println("Index: " + c + " Value: " + array[j]);
			c++;
		}
		System.out.println("Maximum value: " + max);
		
	}
	
	
	
	public static void main(String args[]) 
	{
		int[] a = {-6, 2, -4, 1, 3, -1, 5, -1};
		int[] b = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		maxArray(b);
	}
}
