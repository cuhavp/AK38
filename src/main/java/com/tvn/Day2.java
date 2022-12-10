package com.tvn;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        Student A = new Student("Nguyen Van A","male");
        A.info();
        A.setMath(5);
        A.setChemistry(6);
        A.setPhysics(7);
//        A.info();

        Student B = new Student("Nguyen Van B","male");
        B.setMath(1);
        B.setChemistry(1);
        B.setPhysics(1);
//        B.info();

        List<Student> classA = new ArrayList<>();
        classA.add(A);
        classA.add(B);

        Student maxPoint = classA.stream()
                .min(Comparator.comparing(Student::total))
                .orElseThrow();
        maxPoint.info();


    }
    /**
     * public class SinhVien {
     *     private String maSV;
     *     private String hoTen;
     *     private boolean gioiTinh;
     *     private double diemToan;
     *     private double diemLy;
     *     private double diemHoa;
     * }
     */
}
