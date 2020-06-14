package squashTA.resources.seleniumTests.src.main.java.org.squashtest.ta.selenium.automatisation.outils;

import org.openqa.selenium.WebElement;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class FonctionsUtiles {

    private static StringTokenizer stringTokenizer;
    private static String chaine;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static LocalDate dateTime;
    private static GregorianCalendar gregorianCalendar = new GregorianCalendar();

    public static String getMountFromDate(String str){
        stringTokenizer = new StringTokenizer(chaine, "/");
        stringTokenizer.nextToken();
        return stringTokenizer.nextToken();
    }

    public static int getNumberFromString(String str){
        try {
            return  Integer.parseInt(str);
        }catch (Exception e){}
        return 0;
    }

    public static LocalDate getDateFromString(String str) {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dateTime = LocalDate.parse(str.substring(0, 10), formatter);
        return dateTime;
    }

    public static LocalDate getEndDate(String month, String year){
        gregorianCalendar.set(Calendar.MONTH, getNumberFromString(month));
        gregorianCalendar.set(Calendar.YEAR, getNumberFromString(year));
        gregorianCalendar.set(Calendar.DAY_OF_MONTH, gregorianCalendar.getMaximum(Calendar.DAY_OF_MONTH));
        return LocalDate.parse(getDateFromCalendar(gregorianCalendar), formatter);
    }

    public static LocalDate getStartDate(String day, String month, String year){
        chaine = day + "/" + month + "/" + year;
        dateTime = LocalDate.parse(chaine, formatter);
        return dateTime;
    }

    public static String getDateFromCalendar(Calendar calendar){
        String day = changeDateNumberFormat(calendar.get(Calendar.DAY_OF_MONTH) + "");
        String month = changeDateNumberFormat(calendar.get(Calendar.MONTH)+"");
        return  day + "/"
                + month + "/"
                + calendar.get(Calendar.YEAR);
    }

    public static String changeDateNumberFormat(String str){
        int num = Integer.parseInt(str);
        chaine = num < 10 ? "0"+num : num+"";
        return chaine;
    }

    public static void verifyRequriedField(WebElement item){
        if(item.getAttribute("value").isEmpty())
            throw new IllegalStateException("element is empty !");
    }

    public static String changeEncodingToUTF8(String chaine){
        try {
            return new String(chaine.getBytes(), "UTF8");
        } catch (UnsupportedEncodingException e) {return chaine;}
    }
}
