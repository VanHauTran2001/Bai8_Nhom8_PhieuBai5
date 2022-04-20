
package Bai8_Nhom8_PhieuBai5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class QuanLyPhongHoc {
    static Scanner sc = new Scanner(System.in);
//    static PhongHoc[] phongHocs = {
//        new PhongHocLyThuyet("LT1","C1", 50, 5,"co"),
//        new PhongMayTinh("MT1","T1",40,4,7),
//        new PhongThiNghiem("TN1", "A1", 30, 3,"IT",15,"khong")
//    };
    static String fileName = "D:\\JavaCore\\Bai8_Nhom8_PhieuBai5\\phongthi.txt";
    static DBClass db = new DBClass();
    static ArrayList<PhongHoc> phongHocs = new ArrayList<>();
    static PhongHoc ph;
    public static void main(String[] args) throws Exception{
        int n ;
        do {            
            showMenu();
            System.out.println("Nhap lua chon cua ban :");
            n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1:
                    nhapDS();
                    break;
                case 2:
                    timKiem(phongHocs);
                    break;
                case 3:
                    show();
                    break;
                case 4:
                    showPhongDatChuan();
                    break;
                case 5:
                    tangDanTheoDayNha();
                    break;
                case 6:
                    giamDanTheoDienTich();
                    break;
                case 7:
                    tangdanTheoSoBongDen();
                    break;
                case 8:
                    updateMayTinh(phongHocs);
                    break;
                case 9:
                    xoaPhongHocTheoMaPhong();
                    break;
                case 10:
                    inTongSoPhong();
                    break;
                case 11:
                    showPhong60May();
                    break;
                case 12 :
                    luuFile();
                case 13 :
                    docFile();
                case 14:
                    System.exit(0);
                    break;
            }
        } while (true);
       
    }

    private static void show() {
        System.out.println("\n------------DANH SACH PHONG HOC LY THUYET-------------");
        PhongHocLyThuyet.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongHocLyThuyet){
                ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongMayTinh){
                ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG THI NGHIEM -------------");
        PhongThiNghiem.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongThiNghiem){
                ph.xuat();
            }
        }
    }
    private static void showMenu() {
        System.out.println("------------------MENU-----------------");
        System.out.println("1.Them mot phong vao danh sach");
        System.out.println("2.Tim kiem phong theo ma");
        System.out.println("3.In danh sach tat ca cac phong");
        System.out.println("4.In danh sach tat ca cac phong dat chuan");
        System.out.println("5.Sap xep danh sach tang dan theo cot day nha");
        System.out.println("6.Sap xep danh sach giam dan theo cot dien tich");
        System.out.println("7.Sap xep danh sach tang dan theo cot so bong den");
        System.out.println("8.Cap nhat so may tinh cho mot phong may tinh khi biet ma phong");
        System.out.println("9.Xoa mot phong hoc khi biet ma");
        System.out.println("10.In ra tong so phong hoc");
        System.out.println("11.In ra danh sach cac phong may co 60 may");
        System.out.println("12.Luu thong tin phong hoc vao File");
        System.out.println("13.Doc thong tin phong hoc tu File");
        System.out.println("13.Thoat !");
        System.out.println("----------------------------------------");
    }

    private static void nhapDS() {
                    System.out.println("1.Nhap danh sach phong hoc ly thuyet");
                    System.out.println("2.Nhap danh sach phong may tinh");
                    System.out.println("3.Nhap danh sach phong thi nghiem");
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        case 1:                        
                            ph = new PhongHocLyThuyet();
                            ph.nhap(phongHocs);
                            phongHocs.add(ph);                           
                            break;
                        case 2:
                            
                            ph = new PhongMayTinh();                              
                            ph.nhap(phongHocs);
                            phongHocs.add(ph);                          
                            break;
                        case 3:
                           
                            ph = new PhongThiNghiem();                            
                            ph.nhap(phongHocs);
                            phongHocs.add(ph);                          
                            break;  
                    }
    }

    private static void timKiem(ArrayList<PhongHoc> listPH) throws Exception{
                   
                    System.out.println("Nhap phong ban muon tim kiem :");
                    System.out.println("1.Tim kiem phong hoc ly thuyet");
                    System.out.println("2.Tim kiem phong may tinh");
                    System.out.println("3.Tim kiem phong thi nghiem");
             
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        
                        case 1:                        
                            
                            System.out.println("Nhap ma phong can tim :");
                            String maPhongLT = sc.nextLine();
                            
                            ph = new PhongHocLyThuyet(maPhongLT);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong tim thay ma phong " + maPhongLT);
                            }else{
                                PhongHocLyThuyet.inTieuDe();
                                for (PhongHoc phongHoc : listPH) {
                                    if(phongHoc.getMaPhong().equalsIgnoreCase(maPhongLT))
                                    {
                                        phongHoc.xuat();
                                    }
                                }
                                
                            } 
                            break;
                        case 2:
                            System.out.println("Nhap ma phong can tim :");
                            String maPhongMT = sc.nextLine();
                            sc.nextLine();
                            ph = new PhongMayTinh(maPhongMT);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong co ma phong can tim kiem !");
                            }else{
                                PhongMayTinh.inTieuDe();
                                for (PhongHoc phongHoc : listPH) {
                                    if(phongHoc.getMaPhong().equalsIgnoreCase(maPhongMT)){
                                        phongHoc.xuat();
                                    }
                                }
                            }                           
                            break;
                        case 3:
                           System.out.println("Nhap ma phong can tim :");
                            String maPhongTN = sc.nextLine();
                            
                            ph = new PhongThiNghiem(maPhongTN);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong co ma phong can tim kiem !");
                            }else{
                                PhongThiNghiem.inTieuDe();
                                for (PhongHoc phongHoc : listPH) {
                                    if(phongHoc.getMaPhong().equalsIgnoreCase(maPhongTN)){
                                        phongHoc.xuat();
                                    }
                                }
                            }                         
                            break;  
                        }
                 }

    private static void showPhongDatChuan() {
        System.out.println("==============DANH SACH CAC PHONG DAT CHUAN==============");
        System.out.println("\n------------DANH SACH PHONG HOC LY THUYET-------------");
        PhongHocLyThuyet.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongHocLyThuyet){
                if(ph.kiemTraDatChuan()=="Dat Chuan!"){
                    ph.xuat();
                }
                
            }
        }
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongMayTinh){
                if(ph.kiemTraDatChuan()=="Dat Chuan!"){
                    ph.xuat();
                }
            }
        }
        System.out.println("\n------------DANH SACH PHONG THI NGHIEM -------------");
        PhongThiNghiem.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongThiNghiem){
                if(ph.kiemTraDatChuan()=="Dat Chuan!"){
                    ph.xuat();
                }
            }
        }
    }

    private static void tangDanTheoDayNha() {
        System.out.println("==============DANH SACH TANG DAN THEO DAY NHA==============");
        Collections.sort(phongHocs,new Comparator<PhongHoc>(){
            @Override
            public int compare(PhongHoc o1, PhongHoc o2) {
               
              return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
                
            }
            
        });
        System.out.println("\n------------DANH SACH PHONG HOC LY THUYET-------------");
        PhongHocLyThuyet.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongHocLyThuyet){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongMayTinh){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG THI NGHIEM -------------");
        PhongThiNghiem.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongThiNghiem){  
                    ph.xuat();
            }         
        }
    }

    private static void giamDanTheoDienTich() {
        System.out.println("==============DANH SACH GIAM DAN THEO DIEN TICH==============");
        Collections.sort(phongHocs,new Comparator<PhongHoc>(){
            @Override
            public int compare(PhongHoc o2, PhongHoc o1) {
               
              return o1.soBongDen < o2.soBongDen ? 1:-1;
                
            }
            
        });
        System.out.println("\n------------DANH SACH PHONG HOC LY THUYET-------------");
        PhongHocLyThuyet.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongHocLyThuyet){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongMayTinh){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG THI NGHIEM -------------");
        PhongThiNghiem.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongThiNghiem){  
                    ph.xuat();
            }         
        }
    }

    private static void tangdanTheoSoBongDen() {
        System.out.println("==============DANH SACH TANG DAN THEO SO BONG DEN==============");
        Collections.sort(phongHocs,new Comparator<PhongHoc>(){
            @Override
            public int compare(PhongHoc o1, PhongHoc o2) {
               
                return o1.soBongDen > o2.soBongDen ? 1:-1;
            }
            
        });
        System.out.println("\n------------DANH SACH PHONG HOC LY THUYET-------------");
        PhongHocLyThuyet.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongHocLyThuyet){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongMayTinh){
                    ph.xuat();
            }
        }
        System.out.println("\n------------DANH SACH PHONG THI NGHIEM -------------");
        PhongThiNghiem.inTieuDe();
        for(PhongHoc ph : phongHocs){
            if(ph instanceof PhongThiNghiem){  
                    ph.xuat();
            }         
        }
    }

    private static void updateMayTinh(ArrayList<PhongHoc> listPH) {
        String suaTT;
        System.out.println("Nhap vao ma phong muon chinh sua thong tin:");             
        suaTT = sc.nextLine();
        

        for (PhongHoc phongHoc : listPH) {
                if(phongHoc.getMaPhong().equals(suaTT))
                {
                    System.out.println("Nhap vao so may tinh moi :");
                    ((PhongMayTinh) phongHoc).setSoMayTinh(Integer.parseInt(sc.nextLine()));
                }           
        }
    }

    private static void xoaPhongHocTheoMaPhong() {

                    System.out.println("Nhap phong ban muon xoa :");
                    System.out.println("1.Xoa phong hoc ly thuyet");
                    System.out.println("2.Xoa phong may tinh");
                    System.out.println("3.Xoa phong thi nghiem");
             
                    int choose = Integer.parseInt(sc.nextLine());
                    switch (choose) {
                        
                        case 1:                        
                            
                            System.out.println("Nhap ma phong can xoa :");
                            String maPhongLT = sc.nextLine();
                            
                            ph = new PhongHocLyThuyet(maPhongLT);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong tim thay ma phong " + maPhongLT);
                            }else{
                                System.out.println("Ban co chac chan muon xoa phong co ma phong " + maPhongLT + " khong ? ");
                                System.out.println("1.Co");
                                System.out.println("2.Khong");
                                int luaChonXoa = Integer.parseInt(sc.nextLine());
                                switch (luaChonXoa) {
                                    case 1:
                                        phongHocs.remove(ph);
                                        System.out.println("Xoa thanh cong !");
                                        break;
                                    case 2:
                                        break;
                                }
                                
                                
                            } 
                            break;
                        case 2:
                            System.out.println("Nhap ma phong can xoa :");
                            String maPhongMT = sc.nextLine();
                            
                            ph = new PhongMayTinh(maPhongMT);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong co ma phong can tim kiem !");
                            }else{
                                System.out.println("Ban co chac chan muon xoa phong co ma phong " + maPhongMT + " khong ? ");
                                System.out.println("1.Co");
                                System.out.println("2.Khong");
                                int luaChonXoa = Integer.parseInt(sc.nextLine());
                                switch (luaChonXoa) {
                                    case 1:
                                        phongHocs.remove(ph);
                                        System.out.println("Xoa thanh cong !");
                                        break;
                                    case 2:
                                        break;
                                }
                                
                            }                           
                            break;
                        case 3:
                           System.out.println("Nhap ma phong can xoa :");
                            String maPhongTN = sc.nextLine();
                            
                            ph = new PhongThiNghiem(maPhongTN);
                            if(!phongHocs.contains(ph)){
                                System.out.println("Khong co ma phong can tim kiem !");
                            }else{
                                System.out.println("Ban co chac chan muon xoa phong co ma phong " + maPhongTN + " khong ? ");
                                System.out.println("1.Co");
                                System.out.println("2.Khong");
                                int luaChonXoa = Integer.parseInt(sc.nextLine());
                                switch (luaChonXoa) {
                                    case 1:
                                        phongHocs.remove(ph);
                                        System.out.println("Xoa thanh cong !");
                                        break;
                                    case 2:
                                        break;
                                }
                                
                            }                         
                            break;  
                        }
    }

    private static void inTongSoPhong() {
        System.out.println("Tong so phong hoc la : " + phongHocs.size());
    }

    private static void showPhong60May() {
        
        System.out.println("============DANH SACH PHONG MAY CO 60 MAY=============");
        System.out.println("\n------------DANH SACH PHONG MAY TINH-------------");
        PhongMayTinh.inTieuDe();
        for (PhongHoc phongHoc : phongHocs) {
            if(phongHoc instanceof PhongMayTinh){
                if(((PhongMayTinh) phongHoc).soMayTinh==60){
                    phongHoc.xuat();
                }
            }
        }
    }
    private static void luuFile(){
        try {
            System.out.println("Nhap phong hoc ban muon luu");
            System.out.println("1.Phong hoc ly thuyet");
            System.out.println("2.Phong hoc may tinh");
            System.out.println("3.Phong thi nghiem");
            System.out.println("4.Thoat");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    ph = new PhongHocLyThuyet();
                    db.luuFile(fileName,ph);
                    System.out.println("Luu file thanh cong !");
                    break;
                case 2:
                    ph = new PhongMayTinh();
                    db.luuFile(fileName,ph);
                    System.out.println("Luu file thanh cong !");
                    break;
                case 3:
                    ph = new PhongThiNghiem();
                    db.luuFile(fileName,ph);
                    System.out.println("Luu file thanh cong !");
                    break;
                case 4:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static void docFile() {
        try {
            System.out.println("Nhap phong hoc ban muon doc file");
            System.out.println("1.Phong hoc ly thuyet");
            System.out.println("2.Phong hoc may tinh");
            System.out.println("3.Phong thi nghiem");
            System.out.println("4.Thoat");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    ph = new PhongHocLyThuyet();
                    ph = (PhongHocLyThuyet) db.docFile(fileName);
                    System.out.println(ph.toString());
                    break;
                case 2:
                    ph = new PhongMayTinh();
                    ph = (PhongMayTinh) db.docFile(fileName);
                    System.out.println(ph.toString());
                    break;
                case 3:
                    ph = new PhongThiNghiem();
                    ph = (PhongThiNghiem) db.docFile(fileName);
                    System.out.println(ph.toString());
                    break;
                case 4:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
