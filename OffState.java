/**
 * Write a description of class OffState here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public class OffState implements State{

    private SensorController controller;

    public OffState(SensorController controller){
        this.controller = controller;
    }

    //state dimana sensor diaktifkan
    public void activate(){
        controller.setNextState(controller.getOnState());
    }

    //jika sensor mati tentu saja tidak bisa dipadamkan
    public void shutDown(){
        System.out.println("An inactivate sensor can't be turned off..");
    }

    //switch ke mode idle tidak bisa dilakukan jika sensor padam
    public void idle(){
        System.out.println("An inactivate sensor can't be change into idle mode..");
    }

    public void reactivate(){
        System.out.println("Sensor need to be in idle mode for reactivation..");
    }

    public void saveToDB(){
        System.out.println("An inactivate sensor can't send any of the data..");
    }

    public String toString(){
        return "Sensor is turned off. Activate it first before use it..";
    }
}