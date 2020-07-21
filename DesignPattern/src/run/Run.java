package run;

import builder.Book;

public class Run {
	public static void main(String[] args) {
		
		Book book = new Book.BookBuilder()
				.title("해리포터")
				.author("조앤롤링")
				.publisher("민음사")
				.page(450)
				.build();
		
		System.out.println(book);
		
		
		
		
		
	}
}
