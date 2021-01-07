
/**
 * Write a description of class AircraftSpeedSensor here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 */
public class AircraftSpeedSensor implements AircraftSensor{
    
    private Aircraft aircraftData;
    
    public AircraftSpeedSensor(){}
    
    //mengambil object data aircraft yang diberikan
    public void setAircraftData(Aircraft aircraftData){
        this.aircraftData = aircraftData;
    }
    
    //memperlihatkan informasi aircraft
    public void showDataInfo(){
        aircraftData.aircraftInformation();
    }
    
    public Aircraft sendToController(){
        return aircraftData;
    }
    
}
