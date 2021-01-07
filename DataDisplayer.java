/**
 * Write a description of class DBAccessor here.
 * 
 * @author (M. Hilal Mubarrak) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class DataDisplayer implements IContainer{

    private ArrayList<String> allData = new ArrayList<String>();
    private DBAccessor db = DBAccessor.getInstance();
    // private Iterator i;

    public DataDisplayer(){
        db.authorize("123456789", "password");
        this.allData = db.readDB(); //hasil pembacaan dari database disimpan disini
        // i = allData.iterator();
    }

    public Iterator createIterator(){
        DataIterator iterator = new DataIterator();
        return iterator;
    }

    private class DataIterator implements Iterator{
        private int index = 0;

        public boolean hasNext(){

            if (index < allData.size()){
                return true;
            }
            else{
                return false;
            }
        }

        public Object next(){
            if (this.hasNext()){
                return allData.get(index++);
            }
            else{
                return null;
            }
        }

    }

}