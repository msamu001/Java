class Cartoon extends Book{
	protected String name;

	public Cartoon(String p, double r, int y, String n){
		super(p,r,y);
		name = n;
	}

	public double computeSalePrice(){
		if(super.regularPrice < 100){
			return super.regularPrice * 0.75;
		}
		else{
			return super.regularPrice * 0.65;
		}
	}
}