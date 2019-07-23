package scratch;

//question 1.5
public class One_Away 
{
	
	//a function that checks for a single edit between two strings
	//the three types of edits are one character insert, delete, or replacement
	//returns true if one or no edits were found
	//ex) of one edits: pale, pales; pale, ple; pale, bale
	public static boolean isEdited(String s1, String s2)
	{
		
		//checks to see if the two strings' lengths are off by only one character
		if((s1.length() - s2.length() == 1) || (s1.length() - s2.length() == -1))
		{
			int length = 0;							//variable to hold the length of the shorter string
			int edit = 0;							//counts how many edits are occurring
			
			//determines the longer length between the two strings
			if(s1.length() - s2.length() == 1)
			{
				length = s1.length();
				for(int i = 0; i < length; i++)
				{
					try
					{
						//compares the characters to see if they are the same or not 
						if(!s1.substring(i, i+1).equals(s2.substring(i, i+1)))
						{
							edit++;
						}
					}
					//catches the expected out of bounds exception and adds to the edited total
					catch(StringIndexOutOfBoundsException e)
					{
						edit++;
					}
				}
			}
			else
			{
				length = s2.length();
				for(int i = 0; i < length; i++)
				{
					try
					{
						//compares the characters to see if they are the same or not 
						if(!s1.substring(i, i+1).equals(s2.substring(i, i+1)))
						{
							edit++;
						}
					}
					//out of bounds exception expected, add to the total
					catch(StringIndexOutOfBoundsException e)			
					{
						edit++;
					}
				}
				
			}
			
			System.out.println("number of edits: " + edit);
			
			
			if(edit <= 1)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		//if the two strings are the same length, then compare the characters 
		//to see if there is only one replaced character
		//logically, if they are the same length then, the edit must be a replace
		//on top of that, there can only be one replacement
		
		int counter = 0;												//counts the edits
		for(int i = 0; i < s1.length(); i++)
		{
			//compare the substrings to similarity
			if(!s1.substring(i, i+1).equals(s2.substring(i, i+1)))
			{
				counter++;
			}
		}
		
		System.out.println("number of edits: " + counter);
		
		if(counter <= 1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static void main(String args[])
	{
		String first = "holo";
		String sec = "hello";
		
		System.out.println(first + ", " + sec + " -> " + isEdited(first, sec));
	}
}
