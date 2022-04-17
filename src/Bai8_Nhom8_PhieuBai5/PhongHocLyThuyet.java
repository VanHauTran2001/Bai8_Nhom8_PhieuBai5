
package Bai8_Nhom8_PhieuBai5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class PhongHocLyThuyet extends PhongHoc implements Serializable{
    ArrayList<PhongHoc> phongHocs = new ArrayList<>();
    private String mayChieu;

    public PhongHocLyThuyet( String maPhong, String dayNha, double dienTich, int soBongDen,String mayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.mayChieu = mayChieu;
    }

    public PhongHocLyThuyet() {
    }
    public PhongHocLyThuyet(String maPhong){
        super(maPhong);
    }
    public String getMayChieu() {
        return mayChieu;
    }

    public void setMayChieu(String mayChieu) {
        this.mayChieu = mayChieu;
    }

    

    @Override
    public void nhap(ArrayList<PhongHoc> dsPhongHoc) {
        Scanner sc = new Scanner(System.in);
        super.nhap(dsPhongHoc); 
        System.out.println("Nhap may chieu :");
        mayChieu = sc.nextLine();
    }
    
    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-15s %-17s \n",mayChieu,kiemTraDatChuan());
    }
    
    
    public static void inTieuDe() {
        PhongHoc.inTieuDe();
        System.out.printf("%-15s %-17s \n" ,"May chieu","Dat chuan");
    }

    @Override
    public String kiemTraDatChuan() {
     int soBong = (int) (dienTich%10);
        if(soBongDen >= soBong && mayChieu.equalsIgnoreCase("co")){
            return "Dat Chuan!";
        }else{
            return "Khong Dat Chuan!";
        }       
    }

    @Override
    public String toString() {
        return "PhongHocLyThuyet{" + "phongHocs=" + phongHocs.toString() + ", mayChieu=" + mayChieu + '}';
    }
    
}
