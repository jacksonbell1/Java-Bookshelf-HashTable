
public class BookshelfHashtable
{
	private Book[] table;
	private static final Book EMPTY_AFTER_REMOVAL = 
						 new Book(-1, "EMPTY AFTER REMOVAL");
	
	/**
	 * BookshelfHashtable constructor
	 *
	 * @param arraySize sets table array size for this.table
	 */
	public BookshelfHashtable(int arraySize)
	{
		this.table = new Book[arraySize];
	}
	
	/**
	 * takes bookId and returns the modulo hash value
	 *
	 * @param bookId used with modulo
	 * @return hashed bookId 
	 */
	public int hash(int bookId)
	{
		return bookId % table.length;
	}
	
	/**
	 * if collision occurs in insert, remove or search,
	 * used to find next bucket
	 *
	 * @param currentIndex the index of the current full bucket
	 * @param probeCount the # of times nextBucketIndex has been called
	 * @return nextIndex
	 */
	private int nextBucketIndex(int currentIndex, int probeCount)
	{
        int nextIndex = (currentIndex + (int) Math.pow(probeCount, 2) + 3 * probeCount + 1) % table.length;
        
        return nextIndex;
    }
	
	/**
	 * inserts a book into hash table using assigned key
	 *
	 * @param book object containing a book and its key
	 * @return boolean whether operation is successful or unsuccessful
	 */
	public boolean insert(Book book)
	{
		int bookId = book.getBookId();
        int hash = hash(bookId);
        int probeCount = 0;
        
        while (table[hash] != null && table[hash].getBookId() != bookId && table[hash] != EMPTY_AFTER_REMOVAL)
        {
            hash = nextBucketIndex(hash, ++probeCount);
            
            if (probeCount > 25)
            {
            	System.out.print("not able to insert key " + bookId + "\n");
            	return false;
            }
        }
		
        if (table[hash] == null || table[hash] == EMPTY_AFTER_REMOVAL)
        {
        	System.out.print(book + " Inserted at hash " + hash + "\n");
            table[hash] = book;
            return true;
        }
        
        return false;
	}
	
	/**
	 * removes a book from the hash table using given key
	 *
	 * @param book object containing a book and its key
	 * @return boolean whether operation is successful or unsuccessful
	 */
	public boolean remove(Book book)
	{
		int bookId = book.getBookId();
	    int hash = hash(bookId);
	    int probeCount = 0;
	
	    while (table[hash] != null)
	    {
	        if (table[hash].getBookId() == bookId)
	        {
	        	System.out.print(bookId + " removed\n");
	            table[hash] = EMPTY_AFTER_REMOVAL;
	            return true;
	        }
	        hash = nextBucketIndex(hash, ++probeCount);
	    }
	
	    return false;
	}
	
	/**
	 * searches for a book 
	 *
	 * @param bookId key to be used in comparison while searching
	 * @return book element table
	 */
	public Book search(int bookId)
	{
        int hash = hash(bookId);
        int probeCount = 0;

        while (table[hash] != null)
        {
            if (table[hash].getBookId() == bookId)
            {
            	System.out.print(bookId + " Found, ");
                return table[hash];
            }
            
            if (probeCount > 8) 
            {
            	System.out.print(bookId + " Not found\n");
                return null;
            }
            
            hash = nextBucketIndex(hash, ++probeCount);
        }
        return null;
    }
	
	/**
	 * prints toString
	 *
	 * @return toString result
	 */
	public String toString()
	{
		StringBuilder result = new StringBuilder("[");
		for (Book book : table)
	    {
			if (book == null)
	    	{
				result.append("EMPTY, ");
	        }
			else if (book == EMPTY_AFTER_REMOVAL)
			{
				result.append(EMPTY_AFTER_REMOVAL.getBookName() + ", ");
			}
	    	else
	        {
	    		result.append(book.toString()).append(", ");
	        }
	    }
	    if (result.length() > 1)
	    {
	    	result.setLength(result.length() - 2);
	    }
	      
	    result.append("]");
	    return result.toString();
	}
}


