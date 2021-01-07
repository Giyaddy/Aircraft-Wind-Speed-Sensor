/**
 * Write a description of class SendDataState here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public class SendDataState implements State{
    
    private SensorController controller;
    private DBAccessor db;
    
    public SendDataState(SensorController controller){
        this.controller = controller;
    }

    //sensor tidak mungkin diaktifkan lagi jika ia sudah aktif
    public void activate(){
        System.out.println("Sensor has been activated. You don't need to do this step..");
    }

    //sensor tidak boleh dipadamkan jika sedang kirim data
    public void shutDown(){
        System.out.println("Sensor is still sending the data. Shutdown action is illegal..");
    }

    //sensor ada pada state ini, sehingga cukup print status saja
    public void saveToDB(){
        System.out.println("Sending...");
    }
    //sensor melakukan pengiriman data di sini sekaligus switch ke mode idle setelah pengiriman
    public void idle(){
        db = DBAccessor.getInstance();
        db.authorize("123456789", "password");
        db.saveToDB(controller.getAircraftData(), controller.getWindData());

        controller.setNextState(controller.getIdleState());
    }

    //sensor tidak mungkin diaktifkan ulang saat pengiriman berlangsung
    public void reactivate(){
        System.out.println("Reactivation is illegal. Sensor is sending the data..");
    }

    public String toString(){
        return "Sensor is sending the data to database..";
    }
}