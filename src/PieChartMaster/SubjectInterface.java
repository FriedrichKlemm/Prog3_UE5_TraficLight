package PieChartMaster;

/**
 * Created by Friedrich on 23.06.2017.
 */
public interface SubjectInterface {
    public abstract void addObserver(GraficControler observer);
    public abstract void removeObserver(GraficControler observer);
    public abstract void notifyAllObserver();
}
