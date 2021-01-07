/**
 * Write a description of class TesDataIterator here.
 * 
 * @author (M. Hilal Mubarrak)
 * @version (a version number or a date)
 */
public class TesDataDisplayer
{
   public static void main(String[] args){

      DataDisplayer displayer = new DataDisplayer();
      Iterator iterator = displayer.createIterator();

      //disini kita gunakan iterator yang telah kita buat sebelumnya
      System.out.println("------------All Data From Both Sensor------------");
      while(iterator.hasNext()){
         System.out.println(iterator.next());
      }
   }
}
