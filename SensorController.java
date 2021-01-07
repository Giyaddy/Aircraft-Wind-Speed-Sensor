/**
 * Write a description of class SensorController here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public class SensorController {
    
    private static AircraftSpeedSensor aircraftSpeedSensor;
    private static WindSpeedSensor windSpeedSensor;
    private String status = "off";
    private State offState;
    private State onState;
    private State sendDataState;
    private State idleState;
    private State sensorState;
    
    //membuat object sensor controller dan mengaktifkannya
    public SensorController(){
        offState = new OffState(this);
        onState = new OnState(this);
        sendDataState = new SendDataState(this);
        idleState = new IdleState(this);

        //state awal saat object dibuat
        sensorState = offState;
    }

    public void setAllSensor(AircraftSpeedSensor a, WindSpeedSensor w){
        aircraftSpeedSensor = a;
        windSpeedSensor = w;
        this.status = "on";
    }

    //memindahkan state ke state berikutnya
    public void setNextState(State sensorState){
        this.sensorState = sensorState;
    }

    public State getOffState(){
        return offState;
    }

    public State getOnState(){
        return onState;
    }

    public State getSendDataState(){
        return sendDataState;
    }

    public State getIdleState(){
        return idleState;
    }

    //menuliskan ulang semua method pada interface State

    public void activate(){
        sensorState.activate();
    }
    
    public void shutDown(){
        sensorState.shutDown();
    }

    public void reactivate(){
        sensorState.reactivate();
    }

    public void saveToDB(){
        sensorState.saveToDB();
    }

    public void idle(){
        sensorState.idle();
    }

    public void status(){
        System.out.println(sensorState);
    }
    
    public static Aircraft getAircraftData(){
       Aircraft a = aircraftSpeedSensor.sendToController();
       return a;
    }
    
    public static Wind getWindData(){
      Wind w = windSpeedSensor.sendToController();
      return w;
    }
}