class Book{
	protected String publisher;
	protected double regularPrice;
	protected int yearPublished;

	public Book(String p, double r, int y){
		publisher = p;
		regularPrice = r;
		yearPublished = y;
	}

	public double computeSalePrice(){
		return regularPrice;
	}
}