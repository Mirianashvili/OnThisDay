import java.util.HashMap;

public class TimeGenerator {

    private static HashMap<String,Integer> getMonths(){
        HashMap<String,Integer> months = new HashMap<>();

        months.put("january",1);
        months.put("february",2);
        months.put("march",3);
        months.put("april",4);
        months.put("may",5);
        months.put("june",6);
        months.put("jule",7);
        months.put("august",8);
        months.put("september",9);
        months.put("october",10);
        months.put("november",11);
        months.put("december",12);

        return months;
    }

    public static String getTime(String month,int day) {
        HashMap<String,Integer> monthMap = getMonths();
        if(monthMap.containsKey(month.toLowerCase())){
            String dayString = String.valueOf(day);
            if(day < 10){
                dayString = "0" + dayString;
            }
            return new StringBuilder(month.toLowerCase())
                    .append("-")
                    .append(dayString)
                    .toString();
        }
        return " ";
    }

}
