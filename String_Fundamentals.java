package scratch;

//question 1.1
public class String_Fundamentals 
{

	//checks to see if all letters in a string are unique
	public static boolean unique(String str)
	{
		String letter = "";
		
		//for loop that iterates through the whole string 
		for(int i = 0; i < str.length(); i++)
		{
			
			letter = str.substring(i, i+1);		//sets the letter to be searched for
			
			//checks the current letter against the rest of the string
			if(str.substring(i+1, str.length()).contains(letter) && str.substring(0, i).contains(letter))
			{
				return false;
			}

		}

		return true;
	}

	//checks to see if one string is a permutation of another string
	//ex dog and god would return true
	public static boolean perm(String s1, String s2)
	{
		//checks to see if the two strings are the same length
		//if they aren't then they can't possibly be a permutation of one another
		if(s1.length() != s2.length())
		{
			return false;
		}
		
		//convert the two strings to character arrays
		char[] string1 = s1.toCharArray();
		char[] string2 = s2.toCharArray();
		
		//sorts the two character arrays
		java.util.Arrays.sort(string1);
		java.util.Arrays.sort(string2);
		
		//converts the character arrays to strings
		String a = new String(string1);
		String b = new String(string2);
		
		//compares the two strings to see if they are equal after sorting
		return a.equals(b);
	}
	
	public static void main(String args[])
	{
		String ex = "dog";
		String ss = "god";
		
		System.out.println("Unique character in " + ex + "?: " + unique(ex));
		System.out.println("Is " + ss + " a permutation of " + ex + "?: " + perm(ss, ex));
	}
}
