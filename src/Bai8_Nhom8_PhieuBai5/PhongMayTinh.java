
package Bai8_Nhom8_PhieuBai5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class PhongMayTinh extends PhongHoc implements Serializable{
    ArrayList<PhongHoc> phongHocs = new ArrayList<>();
    public int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen,int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public PhongMayTinh() {
    }
    public PhongMayTinh(String maPhong){
        super(maPhong);
    }
    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

   

    @Override
    public void nhap(ArrayList<PhongHoc> dsPhongHoc) {
        Scanner sc = new Scanner(System.in);
        super.nhap(dsPhongHoc); 
        System.out.println("Nhap so may tinh :");
        soMayTinh = Integer.parseInt(sc.nextLine());
    }
    
    @Override
    public void xuat() {
        super.xuat(); 
        System.out.printf("%-15d %-17s \n" , soMayTinh , kiemTraDatChuan());
    }
    public static void inTieuDe(){
        PhongHoc.inTieuDe();
        System.out.printf("%-15s %-17s \n","So may tinh","Dat chuan");
    }
    @Override
    public String kiemTraDatChuan() {
      
       
        if(((dienTich/soBongDen)>=10) && dienTich/soMayTinh>=1.5){
            return "Dat Chuan!";
        }else{
            return "Khong Dat Chuan!";
        }  
    }

    @Override
    public String toString() {
        return "PhongMayTinh{" + "phongHocs=" + phongHocs.toString() + ", soMayTinh=" + soMayTinh + '}';
    }
    
}
