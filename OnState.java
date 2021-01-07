/**
 * Write a description of class OnState here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public class OnState implements State{

    private SensorController controller;

    public OnState(SensorController controller){
        this.controller = controller;
    }

    //apabila sensor telah diaktifkan, maka tidak perlu aktifkan ulang
    public void activate(){
        System.out.println("Sensor has been activated. You don't need to do this step..");
    }

    //sensor bisa dipadamkan jika berada di state ini
    public void shutDown(){
        System.out.println("Sensor will shutdown in seconds..");
       controller.setNextState(controller.getOffState());
    }

    //sensor juga bisa diganti ke mode idle jika baru saja diaktifkan
    public void idle(){
        System.out.println("Sensor will switch to idle mode..");
        controller.setNextState(controller.getIdleState());
    }

    //sensor tidak mungkin diaktifkan ulang jika ia sendiri masih aktif
    public void reactivate(){
        System.out.println("Sensor has been activated. You don't need to do this step..");
    }

    //sensor pindah ke state pengiriman data
    public void saveToDB(){
        controller.setNextState(controller.getSendDataState());
    }

    //return toString
    public String toString(){
        return "Sensor is activated. Gathering data from both sub-sensor..";
    }
}