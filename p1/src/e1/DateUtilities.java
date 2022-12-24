package e1;

public class DateUtilities {



    public static boolean isLeap(int year) {

        if (year % 4 == 0 && year % 100 != 0) {

            return true;

        } else if (year % 400 == 0) {

            return true;

        } else {

            return false;
        }


    }

    public static int numberOfDays(int month, int year) {

        if(month > 12 || month < 0){
            throw  new IllegalArgumentException();
        }

        else if (month == 2) {

            if (isLeap(year)) return 29;
            else return 28;
        } else if ( month % 2 != 0 && month < 8 || month % 2 == 0&& month >= 8)  {

            return 31;

        } else {

            return 30;
        }


    }

    public static String convertToISODate(String dateText) {

        String[] parts = dateText.split(" ", 3);

        String month = parts[0];   //Mes
        String day = parts[1];     //Dia,
        String year = parts[2];     //año

        day = day.substring(0, day.length() - 1);

        month = switch (month) {
            case "January" -> "01";
            case "February" -> "02";
            case "March" -> "03";
            case "April" -> "04";
            case "May" -> "05";
            case "June" -> "06";
            case "July" -> "07";
            case "August" -> "08";
            case "September" -> "09";
            case "October" -> "10";
            case "November" -> "11";
            case "December" -> "12";
            default -> throw new IllegalArgumentException("Wrong Month");
        };
        return year + "-" + month + "-" + day;

    }


    public static boolean checkISODate(String ISODate) {

        String[] parts = ISODate.split("-", 3);

        int year = Integer.parseInt(parts[0]);   //Año
        int month = Integer.parseInt(parts[1]);     //mes
        int day = Integer.parseInt(parts[2]);     //dia

        for (char ch : ISODate.toCharArray()) {

            if (!Character.isDigit(ch) && ch != '-') {

                return false;
            }
        }
        if (month < 0 || day < 0 || year < 0 || month > 12) {

            return false;
        }
        if (day > numberOfDays(month, year)) {

            return false;
        }

        return true;
    }
}


