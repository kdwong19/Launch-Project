import java.util.*;
public class Calendar {
	Scanner scan = new Scanner(System.in);
	public char[] getTime()
	{
		String time = scan.next();
		return time.toCharArray();
		
	}
	public int timePos(char[] time)
	{
		if(time[2] == 58)
		{
			int digit1 = Character.getNumericValue(time[0]);
			int digit2 = Character.getNumericValue(time[1]);
			int hour = digit1*10 + digit2;
			int position = hour * 2;
			if(time[3] != 48)
			{
				position++;
			}
			return position;
		}
		else
		{
			int hour = Character.getNumericValue(time[0]);
			int position =  2*hour;
			if(time[2] != 48)
			{
				position++;
			}
			return position;
		}
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] calendar = new String[48];
		Calendar c = new Calendar();
		System.out.println("Enter in your go to sleep and wake up times");
		char[] time = c.getTime();
		int startTime = c.timePos(time);
		char[] time2 = c.getTime();
		int endTime = c.timePos(time2);
		for(int i = startTime; i < 48; i++)
		{
			calendar[i] = "SLEEP";
		}
		for(int i = 0; i < endTime; i++)
		{
			calendar[i] = "SLEEP";
		}
		boolean isDone = false;
		int j = 0;
		while(j == 0)
		{
			System.out.println("Enter in your class start and end time");
			time = c.getTime();
			startTime = c.timePos(time);
			time = c.getTime();
			endTime = c.timePos(time);
			System.out.println("Enter in your class name");
			String className = scan.next();
			if(className.equals("DONE")){
				j++;
			}
			for(int i = startTime; i < endTime && j == 0; i++)
			{
				if(calendar[i] != null)
				{
					System.out.println("Invalid");
					break;
				}
				else
				{
					calendar[i] = className;
				}
			}
			
		}
		System.out.println("Enter something you have to do");
		String assignment = scan.next();
		System.out.println("How long will it take?");
		double timeMinutes = scan.nextDouble();
		int timePositions = (int) Math.ceil(timeMinutes/30);
		System.out.println(timePositions);
		int startPosition = 0;
		for(int a = 0; a < 48 - timePositions; a++)
		{
			int counter = 0;
			for(int b = a; b < a + timePositions; b++)
			{
				if(calendar[b] == null)
				{
					counter++;
				}
				if(counter == timePositions)
				{
					startPosition = a;
				}
			}
		}
		for(int i = startPosition; i < startPosition + timePositions; i++)
		{
			calendar[i] = assignment;
		}
		for(int i = 0; i < 48; i++)
		{
			System.out.println(calendar[i]);
		}
		

	}

}
