class NumRev
{
	public static void main(String[] args)
	{
		int num = 4321;

		String numStr = String.valueOf(num);

		char[] numChar = numStr.toCharArray();
		
		for(int i = 0; i < numStr.length() - 1; i++)
		{
			for(int j = 0; j+i < numStr.length() - 1; j++)
			{
				char temp = numChar[j+1];
				numChar[j+1] = numChar[j];
				numChar[j] = temp;
			}
		}

		System.out.println(numChar);
	}
}