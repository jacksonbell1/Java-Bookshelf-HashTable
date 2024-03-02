
public class Book
{
	private int bookId;
	private String bookName;
	
	/**
	 * Book constructor
	 *
	 * @param bookId sets bookId for this.bookId
	 * @param bookName sets bookName for this.bookName
	 */
	public Book(int bookId, String bookName)
	{
		this.bookId = bookId;
		this.bookName = bookName;
	}

	/**
	 * gets bookId
	 *
	 * @return bookId
	 */
	public int getBookId()
	{
		return bookId;
	}

	/**
	 * gets bookName
	 *
	 * @return bookName
	 */
	public String getBookName()
	{
		return bookName;
	}

	
	/**
	 * sets BookName
	 *
	 * @param bookName the name of book to be set
	 */
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	
	/**
	 * checks to see if two objects are equal
	 *
	 * @param obj the book obj to be compared to this book
	 * @return bool
	 */
	public boolean equals(Object obj)
	{
        if (this == obj) 
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Book other = (Book) obj;

        return bookId == other.bookId &&
               bookName.equals(other.bookName);
    }
	
	/**
	 * prints toString
	 *
	 * @return the toString
	 */
	public String toString()
	{
        return "Book{" + "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}




