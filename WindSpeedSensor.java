
/**
 * Write a description of class WindSpeedSensor here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public class WindSpeedSensor implements WindSensor{
    
    private Wind windData;
    
    public void WindSpeedSensor(){}
    
    public void setWindData(Wind windData){
        this.windData = windData;
    }
    
    public Wind sendToController(){
        return windData;
    }
    
    public void showDataInfo(){
        windData.windInformation();
    }
    
}
