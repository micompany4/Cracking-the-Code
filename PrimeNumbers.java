package scratch;

/*
 * class with one method to determine if a number is prime or not
 */
public class PrimeNumbers 
{
	public static void primeJudge(int arr[])
	{
		//loop through all the numbers in the array
		for(int i = 0; i < arr.length; i++)
		{
			//formatting purposes, each line will feature 8 numbers and its corresponding label
			if(i % 8 == 0 && i != 0)
			{
				System.out.println();
			}

			int limit = (int)Math.sqrt(arr[i]);		//the upper limit of our search for possible factors
													//ex) square root of 81 == 9. factor bigger than 9 is 27; 27 * 3 == 81
													//but 3 would have been covered in the search already since 3 < 9

			boolean composite = false;				//boolean to signal if the number is composite or not


			System.out.print(arr[i] + ": ");

			//check if the number is composite (not prime)
			//if the number is divisible by 2 and not 2 itself OR the number is 1, then it's composite
			if(arr[i] % 2 == 0 && arr[i] != 2 || arr[i] == 1)
			{
				System.out.print("Composite, ");
				composite = true;
			}
			else
			{
				//start at 3 because we tested 1 and 2 already
				//needs to be j <= limit because square numbers like 9, 25, etc where 3, 5 are the factors we're looking for
				for(int j = 3; j <= limit; j++)
				{
					if(arr[i] % j == 0)
					{
						System.out.print("Composite, ");
						composite = true;
						break;				//terminate the search, because we only need to find one factor 
					}
				}
			}

			//if the number is not composite, then it's gotta be prime
			if(!composite)
			{
				System.out.print("Prime, ");
			}

		}
	}


	public static void main(String args[])
	{
		//array to pass into the method, insert test cases here 
		int numbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				//50, 21, 24, 56, 31, 32, 49, 99, 100, 101, 102,
				//77, 65, 71, 67, 89, 94
		};

		primeJudge(numbers);
	}
}
