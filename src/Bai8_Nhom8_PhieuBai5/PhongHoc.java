
package Bai8_Nhom8_PhieuBai5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public abstract class PhongHoc implements Serializable{
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc() {
    }

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public PhongHoc(String maPhong) {
        this.maPhong = maPhong;
    }
    
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) throws Exception{
        if(maPhong==null){
            throw new Exception("Ma phong khong duoc de trong !");
        }
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public double getDienTich(){
        return dienTich;
    }

    public void setDienTich(double dienTich) throws Exception{
        if(dienTich<0){
            throw new Exception("Dien tich >0");
        }
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
            
        }
        final PhongHoc otherPhongHoc = (PhongHoc) obj;
        if(!Objects.equals(this.maPhong,otherPhongHoc.maPhong)){
            return false;
        }
        return true;
        
    }
    
    public void nhap(ArrayList<PhongHoc> dsPhongHoc){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        try {
            System.out.println("Nhap ma phong :");
            do {                
                flag = true;
                setMaPhong(sc.nextLine());
                for(int i=0;i<dsPhongHoc.size();i++){
                    if(dsPhongHoc.get(i).getMaPhong().equalsIgnoreCase(this.maPhong)){
                        flag = false;
                        System.out.println("Nhap lai :");
                        break;
                    }
                }
            } while (!flag);
            
        } catch (Exception e) {
            System.out.println("Loi :" + e.toString());
        }      
        System.out.println("Nhap day nha :");
        dayNha = sc.nextLine();
        try {
            System.out.println("Nhap dien tich :");
            setDienTich(sc.nextDouble());
        } catch (Exception e1) {
            System.out.println("Loi :" + e1.toString());
        }
        System.out.println("Nhap so bong den :");
        soBongDen = sc.nextInt();
    }
    public abstract String kiemTraDatChuan();
    
    public void xuat(){
        System.out.printf("%-10s %-10s %-10.1f %-14d " , maPhong,dayNha,dienTich,soBongDen);
    }
    public static void inTieuDe(){
        System.out.printf("%-10s %-10s %-10s %-14s " , "Ma phong","Day nha","Dien tich","So bong den");
    }

    @Override
    public String toString() {
        return "PhongHoc{" + "maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen=" + soBongDen + '}';
    }
    
}
