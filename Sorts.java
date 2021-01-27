package scratch;

/*
 * A collection of sorting algorithms 
 */
public class Sorts {
	
	//where the actual sorting in mergesort occurs 
	//returns the position of the pivot and everything sorted relative to the pivot's position
	public static int partition(int a[], int l, int h)
	{
		int pivot = a[l];		//pivot is the first element in the array
		int left = l;
		int right = h;
		
		//loop through the array until the left and right indices cross each other
		//resulting in nothing left to swap and the location of the pivot
		while (left < right)
		{
			//find an element left of the pivot that should be to the right of the pivot
			//element on the left is greater than pivot
			while(a[left] <= pivot)
			{
				left++;
			}
			//find an element right of the pivot that should be to the left of the pivot
			//element on the right is less than or equal to the pivot
			while(a[right] > pivot)
			{
				right--;
			}
			
			//make the swap so that the two numbers are on the correct sides of the pivot
			if(left < right)
			{
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
			}
		}
		
		//found the location of the pivot so put it in its correct spot in the array
		int temp = a[l];
		a[l] = a[right];
		a[right] = temp;
		
		return right;		//the index of the pivot
	}
	
	//com'on man this is fundamental, everybody does it this way
	public static void quicksort(int a[], int low, int high)
	{
		if(low < high)
		{
			int p = partition(a, low, high);	//pivot is in the correct spot after partition, so no need to do more to it
			quicksort(a, low, p-1);				//sort from beginning to pre-pivot
			quicksort(a, p+1, high);			//sort from post-pivot to end
		}
	}
	
	//very much like quicksort, this is where the acutal sorting of numbers occur 
	//mergesort divides the array down to its smallest form and merge, merges them together by ascending order
	public static void merge(int a[], int low, int mid, int high)
	{
		//sizes for the two divided arrays
		int n1 = mid - low + 1;		//left array includes the middle element
		int n2 = high - mid;
		
		//temp arrays for the divided main array split in the middle
		int left[] = new int[n1+1];
		int right[] = new int[n2+1];
		//fill in the left and right arrays from the main array
		for(int i = 0; i < n1; i++)
		{
			left[i] = a[low + i];
		}
		for(int i = 0; i < n2; i++)
		{
			right[i] = a[mid+i+1];		//right array does not include the middle element, hence the +1
		}
		//make the last elements of the left/right array infinity so when one side reaches its end,
		//it will always choose the other
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		int l = 0;
		int r = 0;
		for(int k = low; k <= high; k++)
		{
			//select the smaller number of the two sub arrays
			if(left[l] <= right[r])
			{
				a[k] = left[l];
				l++;
			}
			else
			{
				a[k] = right[r];
				r++;
			}
		}
		
	}
	
	//I think everybody invokes mergesort this way
	public static void mergesort(int a[], int low, int high)
	{
		if(low < high)
		{
			int middle = low + (high-low) / 2;	//protects against overflow 
			mergesort(a, low, middle);
			mergesort(a, middle+1, high);
			merge(a, low, middle, high);
		}
	}
	
	//ahh, simple yet classic
	public static void insertionsort(int a[])
	{
		//iterate over the array starting from index 1
		for(int i = 1; i < a.length; i++)
		{
			int key = a[i];
			int j = i-1;
			
			//insert bigger numbers ahead of the key until your at the beginning of the array or you found a smaller number
			while(j >= 0 && a[j] > key)
			{
				a[j+1]= a[j];
				j--;
			}
			//place the key in its correct location
			a[j+1] = key;
			//everything left of the key is sorted
		}
	}
	
	//usually aren't gonna use this since its always O(n^2)
	//start from the beginning, search for smallest, swap, increment, repeat
	public static void selectionsort(int a[])
	{
		//work your way down the array starting from the very beginning
		for(int i = 0; i < a.length-1; i++)
		{
			int minIdx = i;
			//look for the smallest element right of i
			for(int j = i+1; j < a.length; j++)
			{
				//update the index of the smallest number
				if(a[j] < a[minIdx])
				{
					minIdx = j;
				}
			}
			
			//swap the number at i with the smallest number found 
			//everything left of i is sorted
			int temp = a[minIdx];
			a[minIdx] = a[i];
			a[i] = temp;
		}
	}
	
	public static void main(String[] args)
	{
		int arr[] = {10, 15, 4, 8, 7, 12, 3, 6,};
		
		//quicksort(arr, 0, arr.length-1);
		mergesort(arr, 0, arr.length-1);
		
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}
