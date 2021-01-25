/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Fahmi Habibi
 */
public class PengolahData {
    ArrayList<ProfilKaryawan> dataKaryawan = new ArrayList<ProfilKaryawan>();
    Scanner input = new Scanner(System.in);
    
    int option;
    String kode;
    String nama;
    
    // Menu
    public void menu() throws ParseException{
        boolean menu = true;
        
        while(menu){
            System.out.println(">>>>>>><<<<<<<");
            System.out.println("Data Karyawan");
            System.out.println("^^^^^^^^^^^^^^");
            System.out.println("Menu : ");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Lihat Data");
            System.out.println("5. Exit");
            System.out.print("Pilihan Menu : ");
            this.option = input.nextInt();
            input.nextLine();
            switch(option){
                case 1:
                    char case1 = 'y';
                    while(case1 == 'y'){
                        tambahData();
                    }
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    tampilData();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("XXX Menu yang anda pilih tidak ada XXX");
            }
       }
    }
    
    public void subMenu(String submenu){
        System.out.println(" ");
        System.out.println("Pilih SubMenu");
        System.out.println("1. Kembali ke menu utama ");
        System.out.println("2. " + submenu + " data lagi");
        System.out.println("");
        System.out.print("Menu Pilihan : ");
        option = input.nextInt();   
    }
    
    // Tambah Data Karyawan
    public void tambahData() throws ParseException{
        String tgl, bln, thn;
        String date;
        String alamat;
        String gol;
        int usia;
        int status;
        int jumlahAnak;

        input.nextLine();
        System.out.println(">>Masukkan Data Karyawan<<");
        System.out.print("Masukkan Kode Karyawan    : ");
        this.kode = input.nextLine();
        System.out.print("Masukkan Nama Karyawan    : ");
        this.nama = input.nextLine();
        System.out.print("Masukkan Alamat           : ");
        alamat = input.nextLine();
        System.out.println("Masukkan Tanggal Lahir");
        System.out.print("      Tanggal : ");
        tgl = input.nextLine();
        System.out.print("      Bulan   : ");
        bln = input.nextLine();
        System.out.print("      Tahun   : ");
        thn = input.nextLine();
        System.out.print("Masukkan Golongan (A/B/C) : ");
        gol = input.nextLine();
        System.out.print("Masukkan Status 1.menikah/0.belum : ");
        status = input.nextInt();
        System.out.print("Masukkan Jumlah Anak      : ");
        jumlahAnak = input.nextInt();

        // Date Converter
        date = tgl+"-"+bln+"-"+thn;
        Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
//        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
//        date = format.format(date1);
        
        Date kini = new Date();
        usia = kini.getYear()-date1.getYear();
        if (kini.getMonth()- date1.getMonth() < 0){
            usia -= 1;
        }
        
        this.dataKaryawan.add(new ProfilKaryawan(kode, nama, gol, usia, status, jumlahAnak));
        
        this.subMenu("Tambah");
        switch(option){
            case 1:
                this.menu();
                break;
            case 2:
                tambahData();
                break;
            default:
                this.menu();
                break;
        }
    }
      
    // Hapus Data Karyawan
    public void hapusData()throws ParseException{
        boolean ditemukan = false;
        int index = -1;
        
        System.out.println("");
        System.out.print("Kode Karyawan yang ingin di hapus : ");
        this.kode = input.nextLine();
        System.out.println("...");

        for(int i=0; i<this.dataKaryawan.size(); i++){
            if (this.dataKaryawan.get(i).kodeKaryawan.equals(kode)){
                index = i;
                ditemukan = true;
            }
        }
        if (ditemukan == true){
            this.dataKaryawan.removeIf(item -> item.kodeKaryawan.equals(kode));
            System.out.println("[Data Karyawan dengan Kode " + kode + " berhasil dihapus]");
        }else {
            System.out.println("______________XXX_______________");
            System.out.println("[Data Karyawan tidak ditemukan]");
            System.out.println("             |v-v|              ");
        }
        
        this.subMenu("Hapus");
        switch(option){
            case 1:
                this.menu();
                break;
            case 2:
                hapusData();
                break;
            default:
                this.menu();
                break;
        }
    }
    
    // Cari Data Karyawan
    public void cariData(){
        boolean ditemukan = false;
        int index = -1;
        
        System.out.println("");
        System.out.println("Cari Data Karyawan");
        System.out.print("Masukkan Kode Karyawan : ");
        this.kode = input.nextLine();
        System.out.println("...");

        for(int i=0; i<this.dataKaryawan.size(); i++){
            if (this.dataKaryawan.get(i).kodeKaryawan.equals(kode)){
                index = i;
                ditemukan = true;
            }
        }
        
        if (ditemukan == true){
            this.dataKaryawan.get(index).print();
            this.dataKaryawan.get(index).printGaji();
        } else {
            System.out.println("______________XXX_______________");
            System.out.println("[Data Karyawan tidak ditemukan]");
            System.out.println("             |v-v|              ");
        }
    }
    
    // Tampilkan Data
    public void tampilData(){
        int index = 0;
        System.out.println("==============================");
        
        if (this.dataKaryawan.isEmpty()){
            System.out.println("____________000______________");
            System.out.println("    Data Karyawan Kosong    ");
            System.out.println("            ---              ");
        } else{
            System.out.println("DATA KARYAWAN");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.print("KODE KARY \t");
            System.out.print("NAMA KARY \t");
            System.out.print("GOL \t");
            System.out.print("USIA \t");
            System.out.print("STATUS NIKAH \t");
            System.out.println("JUMLAH ANAK \t");
            System.out.println("--------------------------------------------------------------------------------");
            for(ProfilKaryawan item: this.dataKaryawan){
                item.dataPrint();
                index++;
            }
            System.out.println("");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Jumlah Karyawan yang terdaftar = "+ index);
        }
    }
}


    