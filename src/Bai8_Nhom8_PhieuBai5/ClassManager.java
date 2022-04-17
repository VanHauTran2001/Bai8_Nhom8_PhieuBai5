
package Bai8_Nhom8_PhieuBai5;

import java.util.ArrayList;
import java.util.Scanner;


public class ClassManager {
    static Scanner sc = new Scanner(System.in);
    private ArrayList<PhongHoc> phongHocs;

    public ClassManager() {
        phongHocs = new ArrayList<>();
    }

    public ArrayList<PhongHoc> getPhongHocs() {
        return phongHocs;
    }

    public void setPhongHocs(ArrayList<PhongHoc> phongHocs) {
        this.phongHocs = phongHocs;
    }
    
  
    public int soPhongHoc(){
        return phongHocs.size();
    }
}
