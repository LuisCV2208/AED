package pe.edu.utp.aed.week11.HanoiTowersProblem;

public class Hanoi {

    private static Tower start_;
    private static Tower end_;
    private static Tower aux_;

    public static void solveHanoi(Tower start, Tower end, Tower aux) {
        start_ = start;
        end_ = end;
        aux_ = aux;
        print2();
        hanoi(start.size(), start, end, aux);
    }

    private static void hanoi(int n, Tower start, Tower end, Tower aux) {
        if (n == 1) {
            end.addDisk(start.getDisk());
            print2();
        } else {
            hanoi(n - 1, start, aux, end);
            end.addDisk(start.getDisk());
            print2();
            hanoi(n - 1, aux, end, start);
        }
    }

    public static void print2() {
        System.out.printf("%-24s %-24s %-24s\n", start_, end_, aux_);
    }

    public static void print(Tower t1, Tower t2, Tower t3) {
        System.out.printf("%-24s %-24s %-24s\n",
                t1.getRole().equals("start") ? t1 :
                        t2.getRole().equals("start") ? t2 : t3,
                t2.getRole().equals("end") ? t2 :
                        t1.getRole().equals("end") ? t1 : t3,
                t3.getRole().equals("aux") ? t3 :
                        t2.getRole().equals("aux") ? t2 : t1);
    }

}
