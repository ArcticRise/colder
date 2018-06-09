package userinterface;

import java.util.Vector;

import javafx.beans.property.SimpleStringProperty;

//==============================================================================
public class BookTableModel
{
    private final SimpleStringProperty bookId;
	private final SimpleStringProperty author;
	private final SimpleStringProperty title;
	private final SimpleStringProperty pubYear;
	private final SimpleStringProperty status;
    

	//----------------------------------------------------------------------------
	public BookTableModel(Vector<String> pData)
	{
        bookId  =  new SimpleStringProperty(pData.elementAt(0));
        author  =  new SimpleStringProperty(pData.elementAt(1));
        title =  new SimpleStringProperty(pData.elementAt(2));
        pubYear =  new SimpleStringProperty(pData.elementAt(3));
        status =  new SimpleStringProperty(pData.elementAt(4));
       

	}

public String getBookId() {
        return bookId.get();
    }
public void setBookId(String number) {
        bookId.set(number);
    }

    public String getAuthor() {
        return author.get();
    }
   public void setAuthor(String number) {
        author.set(number);
    }

     public String getTitle() {
        return title.get();
    }
   public void setTitle(String number) {
        title.set(number);
    }

    public String getPubYear() {
        return pubYear.get();
    }
   public void setPubYear(String number) {
        pubYear.set(number);
    }

    public String getStatus() {
        return status.get();
    }
   public void setStatus(String number) {
        status.set(number);
    }
   }


