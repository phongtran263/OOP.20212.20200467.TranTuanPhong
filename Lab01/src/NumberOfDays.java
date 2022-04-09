import java.util.Scanner;

public class NumberOfDays {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int Month = 0, Year = 0;
		boolean valid = false;
		int result = 0;
		String[][] MonthList = 	{	{"January"	, "Jan."	, "Jan"		, "1"},
									{"February"	, "Feb."	, "Feb"		, "2"},
									{"March"	, "Mar."	, "Mar"		, "3"},
									{"April"	, "Apr"		, "Apr."	, "4"},
									{"May"		, "May"		, "May"		, "5"},
									{"June"		, "Jun"		, "June"	, "6"},
									{"July"		, "Jul"		, "July"	, "7"},
									{"August"	, "Aug"		, "Aug."	, "8"},
									{"September", "Sept"	, "Sept."	, "9"},
									{"October"	, "Oct"		, "Oct."	, "10"},
									{"November"	, "Nov"		, "Nov."	, "11"},
									{"December"	, "Dec"		, "Dec."	, "12"},
								};
		int[] DaysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		while(!valid) {
			System.out.println("Input the month:");
			String InputMonth = scanner.nextLine();
			for(int month = 0; month <= 11; month++) {
				for(String name: MonthList[month]) {
					if(InputMonth.equals(name)) {
						Month = month;
						valid = true;
					}
				}
			}
		}
	
		valid = false;
		while(!valid) {
			System.out.println("Input the year:");
			Year = scanner.nextInt();
			if(Year >= 0) {
				valid = true;
			}
		}
		
		if(Year%4 == 0 && !(Year%100 == 0 && Year%400 != 0) && Month == 1) {
			result = DaysOfMonth[Month] + 1;
			
		}
		
		else {
			result = DaysOfMonth[Month];
		}
		
		System.out.println("This month has " + result + " days");
	}

}
