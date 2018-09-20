class ChildrenBook extends Book{
	protected int age;

	public ChildrenBook(String p, double r, int y, int a){
		super(p,r,y);
		age = a;
	}

	public double computeSalePrice(){
		if(age < 7){
			return super.regularPrice * 0.7;
		}
		else{
			return super.regularPrice * 0.8;
		}
	}
}