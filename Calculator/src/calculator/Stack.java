package calculator;

public class Stack {
	private int[] stack;
	
	public Stack()	{
		stack = new int[4];
	}
	
	//Lägger till nbr i stacken
	public void add(int nbr)	{
		stack[0] = nbr;
	}
	
	//Hämtar ut talet som ligger på index index
	public int get(int index)	{
		return stack[index];
	}

	//Tömmer stacken på alla siffror
	public void clear()	{
		for (int i = 0; i < 4; i++)	{
			stack[i] = 0;
		}
	}
	
	
}
