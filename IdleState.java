/**
 * Write a description of class IdleState here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */

public class IdleState implements State{
    
    private SensorController controller;

    public IdleState(SensorController controller){
        this.controller = controller;
    }

    //agar tidak ambigu maka function ini tidak digunakan dan diganti dengan reactivate()
    public void activate(){
        System.out.println("Activation can't be done. Use Reactivate instead..");
    }

    //jika data telah dikirim maka sensor boleh dipadamkan
    public void shutDown(){
        System.out.println("Sensor will shutdown in seconds..");
        controller.setNextState(controller.getOffState());
    }

    //untuk stay di idle mode
    public void idle(){
        System.out.println("Sensor is already in idle mode..");
    }

    //pengiriman data mustahil dilakukan jika sensor masih dalam idle mode dan belum aktif
    public void saveToDB(){
        System.out.println("Sensor can't send any data in idle mode..");
    }

    public void reactivate(){
        controller.setNextState(controller.getOnState());
    }

    public String toString(){
        return "Sensor is in idle mode. Reactivation or shutdown is legal..";
    }
}