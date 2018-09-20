class primeNum {
	public static void main (String[] args){
		for (int i = 1; i <= 100; i++){
			// Prints number if prime
			if (checkPrime(i) == true)
				System.out.println(i);			
		}
	}

	public static boolean checkPrime(int n){
		// Less than 2, not prime
		if (n < 2)
			return false;

		else if (n > 2) {
			// If divisible by previous numbers, not prime
			for (int i = 2; i < n; i++){
				if (n % i == 0)
					return false;
			}
		}
		return true;			
	}
}