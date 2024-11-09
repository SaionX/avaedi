package es.caib.avaedi.at4forms.front.util;

import java.util.ArrayList;
import java.util.Random;

/*
 *************************************
 **   Written by: Bradley Koelper   **
 **               Locke37 </d.i.c>  **
 **                                 **
 **       NoRepeatRandom.java       **
 **                                 **
 **          For use on:            **
 **      </dream.in.code.net>       **
 **        Snippets Section         **
 *************************************
 */

/*
 *  This class is used for generating integers that are not
 *  going to have repeat values.
 *
 *  All of the getNextInt() methods are identical except
 *  for the generation part from the Random class.  I've
 *  only commented the first getNextInt() method because
 *  it looked more confusing with them on the other two.
 *  And it's the same code, just a different method call.
 *
 */
public class NoRepeatRandom {
	private ArrayList<Integer> numbers; // Integer array for holding repeat checking data
	private Random gen;

	public NoRepeatRandom()
	{
		numbers = new ArrayList<Integer>();
		gen = new Random();
	}
	

	public int getNextInt() // get a random integer, no bounds
	{
		int temp = gen.nextInt();

		if (numbers.isEmpty())
			numbers.add(temp); // add the number to the list

		else
		{
			while (!isAvailable(temp)) // loop while 'temp' is a repeaat number
				temp = gen.nextInt();
		}

		numbers.add(temp); // add 'temp' to the list

		return temp; // return 'temp'
	}

	public int getNextInt(int max) // get a random integer between 0 and 'max', not including max
	{
		int temp = gen.nextInt(max);

		if (numbers.isEmpty()) {
			numbers.add(temp);
		} else {
			while (!isAvailable(temp)) {
				temp = gen.nextInt(max);
			}
		}

		numbers.add(temp);
		return temp;
	}


	public int getNextInt(int min, int max) // generate a number between min and max, not including max
	{
		int temp = gen.nextInt(max - min) + min;

		if (numbers.isEmpty())
			numbers.add(temp);

		else
		{
			while (!isAvailable(temp))
				temp = gen.nextInt(max - min) + min;
		}

		numbers.add(temp);

		return temp;
	}

	private boolean isAvailable(int check) // check to see if 'check' is a repeat number
	{
		for (int x = 0; x < numbers.size(); x++)
			if (check == numbers.get(x).intValue())
				return false;

		return true;
	}

	public void wipeInts() // clear the repeat list
	{
		numbers.clear();
	}
	
	
	/**
	 * @return the numbers
	 */
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}


	/**
	 * @param numbers the numbers to set
	 */
	public void setNumbers(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
}