package pe.edu.utp.aed.week11.HanoiTowersProblem;

public class TestHanoi {
    public static void main(String[] args) {
        Tower start = new Tower("start");
        Tower end = new Tower("end");
        Tower aux = new Tower("aux");

        start.addDisk(4);
        start.addDisk(3);
        start.addDisk(2);
        start.addDisk(1);

        Hanoi.solveHanoi(start, end, aux);
    }
}
