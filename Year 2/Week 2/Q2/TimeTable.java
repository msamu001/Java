class TimeTable{

	public static void main(String[] args){

		for(int i = 0; i < 13; i++){
			for(int j = 0; j < 13; j++){

				int temp;

				// Stops first row from being 0
				if(i == 0)
					temp = 1*j;

				// Stops first collumn from being 0
				else if(j == 0)
					temp = 1*i;

				// Calculates timetable values
				else
					temp = i*j;

				// Prints X in the top left corner of the timetable
				if(temp == 0)
					System.out.printf("%4c", 'X');

				// Prints values of the timetable
				else
					System.out.printf("%4d", temp);
			}
			System.out.println();
		}
	}
}