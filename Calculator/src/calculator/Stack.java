package calculator;

public class Stack {
	private int[] stack;
	
	public Stack()	{
		stack = new int[4];
	}
	
	//L�gger till nbr i stacken
	public void add(int nbr)	{
		stack[0] = nbr;
	}
	
	//H�mtar ut talet som ligger p� index index
	public int get(int index)	{
		return stack[index];
	}

	//T�mmer stacken p� alla siffror
	public void clear()	{
		for (int i = 0; i < 4; i++)	{
			stack[i] = 0;
		}
	}
	
	
}
