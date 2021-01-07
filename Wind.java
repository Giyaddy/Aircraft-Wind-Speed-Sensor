
/**
 * Write a description of class Wind here.
 * 
 * @author (M. Hilal Mubarrak) 
 * @version (a version number or a date)
 */

enum Wind_Direction{
    LEFT, RIGHT, FRONT, BEHIND;
}

public class Wind{
    
    private int windSpeed;
    private Wind_Direction windDirection;
    private int windTraceSpeed;
    
    public Wind(int ws, int wts, String wp){
        this.windSpeed = ws;
        this.windDirection = Wind_Direction.valueOf(wp);
        this.windTraceSpeed = wts;
    }
    
    public void windInformation(){
        
        System.out.println("Wind Information : ");
        System.out.println("Speed : "+windSpeed);
        System.out.println("Wind Direction : "+windDirection);
        System.out.println("Wind Trace Speed : "+windTraceSpeed);
    }
    
    public String getAllData(){
        String s = windSpeed+","+windDirection+","+windTraceSpeed;
        return s;
    }
}
