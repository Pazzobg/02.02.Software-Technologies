package Java_Basics_Exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class E20_CountWorkingDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dateOne = scanner.nextLine();
        String dateTwo = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startDate = LocalDate.from(formatter.parse(dateOne));
        LocalDate endDate = LocalDate.from(formatter.parse(dateTwo));
        

        DateTime[] officialHolidays = AddOfficialHolidays();

        int workingDaysCounter = 0;

        for (DateTime currentDate = startDate; currentDate <= endDate; currentDate = currentDate.AddDays(1))
        {
            if (currentDate.DayOfWeek == DayOfWeek.Saturday || currentDate.DayOfWeek == DayOfWeek.Sunday)
            {
                continue;
            }

            bool isHoliday = false;

            for (int i = 0; i < officialHolidays.Length; i++)
            {
                DateTime tempHolidayCheck = officialHolidays[i];

                if (currentDate.Day == tempHolidayCheck.Day && currentDate.Month == tempHolidayCheck.Month)
                {
                    isHoliday = true;
                    break;
                }
            }

            if (!isHoliday)
            {
                workingDaysCounter++;
            }
        }

        Console.WriteLine(workingDaysCounter);
    }

    public static DateTime[] AddOfficialHolidays()
    {
        DateTime[] officialHolidaysArray = new DateTime[]
                {
                        new DateTime (2015, 1, 1),
                        new DateTime (2015, 3, 3),
                        new DateTime (2015, 5, 1),
                        new DateTime (2015, 5, 6),
                        new DateTime (2015, 5, 24),
                        new DateTime (2015, 9, 6),
                        new DateTime (2015, 9, 22),
                        new DateTime (2015, 11, 1),
                        new DateTime (2015, 12, 24),
                        new DateTime (2015, 12, 25),
                        new DateTime (2015, 12, 26)
                };

        return officialHolidaysArray;
    }
}
