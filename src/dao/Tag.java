package dao;
 


	import java.time.LocalDate;



	public class Tag {
		private String isbn_13;
		private String tags_name;
		private String title;
		private String author;
		private LocalDate publishDate;
		
		private double price;
		
		private byte[] content;
		
		// Constructor used when date is specified
		public Tag(String isbn, String title, String author, byte[] content) {
			this.isbn_13 = isbn;
			this.title = title;
			this.author = author;
			this.publishDate = LocalDate.now(); //when a date is note specified th local date is used.
			this.content = content; 
		}
		
		
		// Constructor used when  date is specified
		public Tag (String isbn_13, String title, String author, LocalDate publishDate,  byte[] content) {
			this.isbn_13 = isbn_13;
			this.title = title;
			this.author = author;
			this.tags_name = null;
			this.publishDate = publishDate;
			this.content = content;
		}
		
		//default construtor
		public Tag() {
			this.isbn_13=null;
			this.title = null;
			this.author = null;
			this.tags_name = null; //added tag name to contructor
			this.publishDate=LocalDate.now();
			this.content=null;
			
			
		}
		public String getTags_names() {
			return tags_name;
		}
		public void setTagNames(String tags_name) {
			this.tags_name=tags_name;
		}
		public String getIsbn_13() {
			return isbn_13;
			
		}
		
		public void Setisbn_13(String isbn_13) {
			this.isbn_13=isbn_13;
		}
		public String getTitle() {
			return title;
			
		}
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public LocalDate getPublishDate() {
			return publishDate;
		}

		public void setPublishDate(LocalDate publishDate) {
			this.publishDate = publishDate;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public byte[] getContent() {
			return content;
		}

		public void setContent(byte[] content) {
			this.content = content;
		}
		
		

	}


