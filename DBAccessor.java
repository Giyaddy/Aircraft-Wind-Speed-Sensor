/**
 * Write a description of class DBAccessor here.
 * 
 * @author (M. Hilal Mubarrak) 
 * @author (Giyaddy Ilmi Alavan)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;

public class DBAccessor
{
   private static DBAccessor dbAccessor = null;
   private static boolean isAuthorized = false;
   private static final String accessKey = "123456789";
   private static final String password = "password";
   
   public static DBAccessor getInstance(){
       
        if (dbAccessor == null){
            dbAccessor = new DBAccessor();
        }
        
        return dbAccessor;
   }
   
   public static void authorize(String key, String pass){
   
       if (accessKey.equals(key) && password.equals(pass)){
           isAuthorized = true;
       }
       else{
           isAuthorized = false;
       }
   }
   
   //untuk menuliskan data ke dalam database
   public static void saveToDB(Aircraft a, Wind w){
       
       if (isAuthorized == true){
           
           try{

               String filename = "database/database.txt";
               FileWriter fw = new FileWriter(filename, true);
               fw.write(a.getAllData()+w.getAllData()+"\n");
               fw.close();
           }
           catch(Exception e){System.out.println(e);}
           System.out.println("Data is stored to database...\n");
       }
       else{
           System.out.println("Sorry, your access is prohibited..\n");
       }
   }
           
   //method ini untuk membaca isi database dan mengembalikannya ke class lain
    public static ArrayList<String> readDB(){
        ArrayList<String> sensorDataFiles = new ArrayList<String>();
        
        try{
            Scanner scanner = new Scanner(new File("database/database.txt"));

            if (isAuthorized==true){
            //membaca file per baris dan simpan ke dalam arraylist
            while (scanner.hasNextLine()){
               String line = scanner.nextLine();
               sensorDataFiles.add(line);
            }
            //elemen pertama adalah headder dari file, jadi dihapus saja
            sensorDataFiles.remove(0);
            }
    
            else{
                sensorDataFiles.add("No Data Available...");
            }
        }catch(Exception e){System.out.println(e);}
        
        return sensorDataFiles;
    }
}