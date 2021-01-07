/**
 * Write a description of class TesSensor here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
import java.lang.Math;

public class TesSensor
{
    public static void main(String[] args){

        String[] aircraft_type = {"A-300", "A-320", "A-330", "B-737", "B-747", "B-777", "DC-8", "DC-9", "DC-10"};
        String[] wind_direction = {"LEFT", "RIGHT", "FRONT", "BEHIND"};
        SensorController controller = new SensorController();
        WindSpeedSensor sensor_angin = new WindSpeedSensor();
        AircraftSpeedSensor sensor_pesawat = new AircraftSpeedSensor();

        int number = 10; //kita akan simulasikan sensor input 10 data pesawat dan angin
        
        //mengaktifkan controller. state awal adalah off
        controller.status();
        controller.activate();
        controller.status();
        
        for (int i=0; i<number; i++){

            int flaps, slats, takeoff_speed, wind_speed, wind_trace_speed;
            double trim_tab;
            
            //nilai flaps dari rentang 5-40
            flaps = 5 + (int)(Math.random()*40);
            
            //slats hanya bernilai 1-20
            slats = 1 + (int)(Math.random()*20);

            //takeoff_speed rentang 130-190
            takeoff_speed = 130 + (int)(Math.random()*190);

            //wind_speed rentang 1-40 knot
            wind_speed = 1 + (int)(Math.random()*40);

            //wind_trace_speed rentang 1-15
            wind_trace_speed = 1 + (int)(Math.random()*15);

            //trim_tab berkisar 0.0-4.0
            trim_tab = (double)(Math.random()*40)/10.0;
            trim_tab = Math.round(trim_tab*10)/10.0; //hanya ambil 1 angka di belakang koma
            System.out.println(trim_tab);
            //ambil secara acak elemen pada array aircraft_type
            int aircraft_arrayPos = (int)(Math.random()*aircraft_type.length);

            //ambil secara acak elemen pada array wind_direction
            int wind_arrayPos = (int)(Math.random()*wind_direction.length);

            //buat object Aircraft dan Wind
            Aircraft pesawat = new Aircraft(aircraft_type[aircraft_arrayPos], flaps, slats, trim_tab, takeoff_speed);
            Wind angin = new Wind(wind_speed, wind_trace_speed, wind_direction[wind_arrayPos]);

            //disini seolah-olah kedua sensor menangkap data angin dan pesawat
            sensor_pesawat.setAircraftData(pesawat);
            sensor_angin.setWindData(angin);
            controller.setAllSensor(sensor_pesawat, sensor_angin);

            //pindah ke state kirim data
            controller.saveToDB();
            controller.status();

            //pindah ke mode idle
            controller.idle();
            controller.status();

            //controller pindah kembali ke mode on
            controller.reactivate();
            controller.status();
        }

        //controller dipadamkan setelah semua data dikirimkan
        controller.shutDown();
        controller.status();
    }
}
