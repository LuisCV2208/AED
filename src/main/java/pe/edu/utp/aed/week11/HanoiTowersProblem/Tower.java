package pe.edu.utp.aed.week11.HanoiTowersProblem;

import java.util.Stack;

public class Tower {
    private String role;
    private Stack<Integer> disks = new Stack<>();

    public String getRole() {
        return role;
    }

    public Tower(String roleName) {
        this.role = roleName;
    }

    public void addDisk(Integer disk) {
        disks.push(disk);
    }

    public Integer getDisk() {
        return disks.pop();
    }

    public int size() {
        return disks.size();
    }

    @Override
    public String toString() {
        return disks.toString();
    }
}
