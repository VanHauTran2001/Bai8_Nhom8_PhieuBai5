
package Bai8_Nhom8_PhieuBai5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class PhongThiNghiem extends PhongHoc implements Serializable{
    ArrayList<PhongHoc> phongHocs = new ArrayList<>();
    private String chuyenNganh;
    private int sucChua;
    private String bonRua;

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen,String chuyenNganh, int sucChua, String bonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.bonRua = bonRua;
    }
    public PhongThiNghiem(String maPhong){
        super(maPhong);
    }
    public PhongThiNghiem() {
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getBonRua() {
        return bonRua;
    }

    public void setBonRua(String bonRua) {
        this.bonRua = bonRua;
    }

    @Override
    public String kiemTraDatChuan() {
        int soBong = (int) (dienTich%10);
       
        if(soBongDen >= soBong && bonRua.equalsIgnoreCase("co")){
            return "Dat Chuan!";
        }else{
            return "Khong Dat Chuan!";
        }  
    }

    @Override
    public void nhap(ArrayList<PhongHoc> dsPhongHoc) {
        Scanner sc = new Scanner(System.in);
        super.nhap(dsPhongHoc); 
        System.out.println("Nhap chuyen nganh :");
        chuyenNganh = sc.nextLine();
        System.out.println("Nhap suc chua :");
        sucChua = sc.nextInt();
        System.out.println("Nhap bon rua :");
        bonRua = sc.nextLine();
    }
    
    @Override
    public void xuat() {
        super.xuat(); 
        System.out.printf("%-15s %-13d %-13s %-17s \n" , chuyenNganh,sucChua,bonRua,kiemTraDatChuan());
    }
    public static void inTieuDe(){
       PhongHoc.inTieuDe();
        System.out.printf("%-15s %-13s %-13s %-17s \n","Chuyen nganh","Suc chua","Bon rua","Dat chuan");
    }

    @Override
    public String toString() {
        return "PhongThiNghiem{" + "phongHocs=" + phongHocs.toString() + ", chuyenNganh=" + chuyenNganh + ", sucChua=" + sucChua + ", bonRua=" + bonRua + '}';
    }
    
}
