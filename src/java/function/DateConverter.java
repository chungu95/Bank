/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class DateConverter {

    public static Date date(String dateString) {
        Date sqlDate = null;
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date startDate = df.parse(dateString);
            sqlDate = new Date(startDate.getTime());
            System.out.println(sqlDate);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return sqlDate;
    }

    /**
     * @return current date by sql.date
     */
    public static Date getCurrentDate() {
        java.util.Date date = Calendar.getInstance().getTime();
        return new Date(date.getTime());
    }
    
    public static String getShipDate(int increation){
        Calendar car = Calendar.getInstance();
        car.add(Calendar.DATE, increation); 
        return (String.format("%02d", car.get(Calendar.DAY_OF_MONTH)) + "-" + String.format("%02d", car.get(Calendar.MONTH)) + "-" + car.get(Calendar.YEAR));
    }

    public static String getFormatDate() {
        Calendar car = Calendar.getInstance();
        return (String.format("%02d", car.get(Calendar.DAY_OF_MONTH)) + "-" + String.format("%02d", car.get(Calendar.MONTH)) + "-" + car.get(Calendar.YEAR));
    }

}
