package ncs.test2;

public class BookTest {

	public static void main(String[] args) {
		Book bookArray [] = new Book[5];

		for(int i=0;i<bookArray.length;i++)
		{
			bookArray[i] = new Book();
		}

		bookArray[0].setCategory("IT");
		bookArray[0].setBookName("SQL Plus");
		bookArray[0].setBookPrice(50000);
		bookArray[0].setBookDiscountRate(5);
		
		bookArray[1].setCategory("IT");
		bookArray[1].setBookName("Java 2.0");
		bookArray[1].setBookPrice(40000);
		bookArray[1].setBookDiscountRate(3);
		
		bookArray[2].setCategory("IT");
		bookArray[2].setBookName("JSP Servlet");
		bookArray[2].setBookPrice(60000);
		bookArray[2].setBookDiscountRate(6);
		
		bookArray[3].setCategory("Nobel");
		bookArray[3].setBookName("davincicode");
		bookArray[3].setBookPrice(30000);
		bookArray[3].setBookDiscountRate(10);
		
		bookArray[4].setCategory("IT");
		bookArray[4].setBookName("cloven hoof");
		bookArray[4].setBookPrice(50000);
		bookArray[4].setBookDiscountRate(15);
		
		double total = 0;
		
		for(int i=0; i<bookArray.length; i++)
		{
			System.out.println(bookArray[i].getCategory()+" "+bookArray[i].getBookName()+
					" "+bookArray[i].getBookPrice()+"원 "+bookArray[i].getBookDiscountRate()+"%");
			total += bookArray[i].getBookPrice();
		}
		System.out.println("\n 책 가격의 합:"+total);
	}

}
