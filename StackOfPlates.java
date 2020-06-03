package scratch;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {

	private int max;
	private ArrayList<Stack> masterStack = new ArrayList<Stack>();
	public StackOfPlates(int maxPlates)
	{
		max = maxPlates;
		masterStack.add(new Stack<Integer>());
	}
	
	public void push(int plate)
	{
		Stack<Integer> currentStack = masterStack.get(masterStack.size()-1);
		if(currentStack.size() >= max)
		{
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(plate);
			masterStack.add(newStack);
		}
		else
		{
			currentStack.push(plate);
		}
	}
	
	public int pop()
	{
		Stack<Integer> currentStack = masterStack.get(masterStack.size()-1);
		int plate = currentStack.pop();
		
		if(currentStack.isEmpty())
		{
			masterStack.remove(masterStack.size()-1);
		}
		
		return plate;
	}
	
	
	public static void main(String args[])
	{
		StackOfPlates diner = new StackOfPlates(3);
		
		diner.push(1);
		diner.push(2);
		diner.push(3);
		diner.push(4);
		diner.push(5);
		diner.pop();
		diner.push(6);
		diner.push(7);
		diner.push(8);
		diner.pop();
		diner.push(9);
		
		for(int i = 0; i < diner.masterStack.size(); i++)
		{
			System.out.print("Stack " + i + " contents: ");
			for(int j =0; j < diner.masterStack.get(i).size(); j++)
			{
				System.out.print(diner.masterStack.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
}
