/**
 *
 * This program uses a hash table to sort 10 different books by
 * their 3 digit hash values. There is an array of bookNames which has
 * 22 different book names, and which have 22 keys generated for them.
 * they are sorted into a hash table of size 10 using a quadratic probing
 * function of i^2 + 3i + 1. once all 10 slots are filled, 5 books are removed.
 * a toString is called at the end to print the final hash table.
 * 
 *
 * @author     Jackson Bell
 * @contact    iw8820tp@go.minnstate.edu
 * @since      11/27/2023
 * 
 * Institution: Century College
 * Course:         CSCI 2082-01
 * 
 * Professor:     Mathew Nyamagwa
 *
 */

import java.util.Random;

public class Driver
{
	public static void main(String[] args)
	{
		String[] bookNames = new String[]
				             {"Harry Potter", "Toaru", "Aria", "Monogatari",
				              "Magi", "86", "Lord of the Rings", "The Prince",
				              "The Little Prince", "Re:zero", "WorldEnd",
				              "Bofuri", "GTO", "Spice & Wolf", "JoJo", 
				              "Mission: Yozakura Family", "Azumanga Daioh", 
				              "Hunter x Hunter", "Dragon Ball", "Steins;Gate", "Gintama",
				              "Oregairu"};
		
		 int[] keys = generateRandomKeys(bookNames.length);
		 
	     BookshelfHashtable bookshelfHashtable = new BookshelfHashtable(10);
	     
	     Random randomBook = new Random();
	     Random randomId = new Random();
	     
	     for (int i = 0, j = 0; i < 10; i++, j++)
	     {
	    	 Book book = new Book(keys[j], bookNames[j]);
	    	 
	    	 while (bookshelfHashtable.insert(book) == false)
	    	 {
	    		 book = new Book(keys[++j], bookNames[++j]);
	    	 }
	         bookshelfHashtable.insert(book);
	     }
	     
	     Random randomKeys = new Random();
	     int count = 0;
	     
	     int keySearch = keys[randomKeys.nextInt(keys.length)];
	     Book selectedBook = bookshelfHashtable.search(keySearch);
	     
	     while (count < 5)
	     {
		     if (selectedBook != null)
		     {
		         bookshelfHashtable.remove(selectedBook);
		         count++;
		     }
		     
		     if (count >= 5)
		     {
		    	 break;
		     }
		     
		     keySearch = keys[randomKeys.nextInt(keys.length)];
		     selectedBook = bookshelfHashtable.search(keySearch);
	     }
	     
	     System.out.println("Hashtable content: " + bookshelfHashtable.toString());
	}
	
	/**
	 * generates keys for the amount of books in the bookNames array
	 *
	 * @param size of the bookNames array
	 * @return the array of keys
	 */
	private static int[] generateRandomKeys(int size)
	{
		Random random = new Random();
	    int[] keys = new int[size];
	    for (int i = 0; i < size; i++)
	    {
	    	keys[i] = 100 + random.nextInt(900);
	    }
	    return keys;
	}
}




