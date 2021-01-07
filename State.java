/**
 * Write a description of interface State here.
 * 
 * @author (Giyaddy Ilmi Alavan) 
 * @version (a version number or a date)
 */
public interface State{

    public void activate();
    public void shutDown();
    public void idle();
    public void reactivate();
    public void saveToDB();
}