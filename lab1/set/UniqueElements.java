package set;

import java.util.ArrayList;

public class UniqueElements {
	public static void main(String[] args) {
		int[] vektor = new int[] { 2, 7, 8, 5, 6, 3, 9, 9, 0, 4, 5, 6, 6, 4 };
		int[] fantasi = uniqueElements(vektor);
//		System.out.println(fantasi.length);
		for(int i = 0; i<fantasi.length; i++)	{
			System.out.print(fantasi[i]);	
		}
		System.out.println();

	}

	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> max = new MaxSet<Integer>();
	//	MaxSet<Integer> transfer = new MaxSet<Integer>();
		for (int nbr : ints) {
			max.add(nbr);
		}
		//max.addAll(transfer);
		int[] result = new int[max.size()];
		for (int i = result.length-1; i >= 0; i--) {
			result[i] = max.getMax();
			max.remove(max.getMax());
		}
	 return result;
	}
}
