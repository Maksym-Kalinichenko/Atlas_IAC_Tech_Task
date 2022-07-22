package com.booking;

import com.booking.BookingTest.HotelSearchPage;
import com.booking.BookingTest.ValidEmail;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    private static void Reflection_Booking(Class thisFile, boolean position) {
        String text;
        try(FileWriter writer = new FileWriter("Reflection_Booking_Text.txt", position)){
            text = "\t\t\t-------\n";
            System.out.print(text);
            writer.write(text);

            text = "ClassName == " + thisFile.getName()+"\n";
            System.out.print(text);
            writer.write(text);

            text = "SuperclassName == " + thisFile.getSuperclass()+"\n";
            System.out.print(text);
            writer.write(text);

            text = "PackageName == " + thisFile.getPackage()+"\n";
            System.out.print(text);
            writer.write(text);

            Field[] fields = thisFile.getFields();
            for (Field field : fields) {
                text = "Public fields are ==" + field.getName()+"\n";
                System.out.print(text);
                writer.write(text);
            }

            Field[] privateFields = thisFile.getFields();
            for (Field field : privateFields) {
                text = "Private fields are == " + field.getName()+"\n";
                System.out.print(text);
                writer.write(text);

            }

            Method[] methods = thisFile.getDeclaredMethods();
            for (Method method : methods) {
                text = "Methods:::" + method.getName()+"\n";
                System.out.print(text);
                writer.write(text);

            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws  SecurityException {

        Class<HotelSearchPage> HotelSearchPageClass = HotelSearchPage.class;
        Class<ValidEmail> ValidEmailClass =  ValidEmail.class;

        Reflection_Booking(HotelSearchPageClass, false);
        Reflection_Booking(ValidEmailClass,true);


    }


}
