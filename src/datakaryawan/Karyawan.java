/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

/**
 *
 * @author Fahmi Habibi
 */
public abstract class Karyawan {
    String kode;
    String nama;
    int status;
    int usia;
    int jumlahAnak;
    
    public abstract long getGajiPokok();
    
    public long getTunjanganMenikah(int status1){
        long tunjanganMenikah;
        this.status = status1;
        if (status == 1){
            tunjanganMenikah = this.getGajiPokok() * 10 / 100; 
        } else {
            tunjanganMenikah = 0;
        }
        return tunjanganMenikah;
    }
    
    public long getTunjanganPegawai(){
        long tunjanganPegawai;
        if (usia > 30){
            tunjanganPegawai = this.getGajiPokok() * 15 / 100;
        } else{
            tunjanganPegawai = 0;
        }
        return tunjanganPegawai;
    }
    
    public long getTunjanganAnak(int jumlahAnak){
        this.jumlahAnak = jumlahAnak;
        long tunjanganAnak = this.getGajiPokok() * 5 / 100 * this.jumlahAnak;
        return tunjanganAnak;
    }
    
    public long getTunjanganTotal(){
        long tunjanganTotal = this.getTunjanganAnak(jumlahAnak) + this.getTunjanganMenikah(status)+ this.getTunjanganPegawai();
        return tunjanganTotal;
    }
    
    public long getGajiKotor(){
        long gajiKotor = this.getGajiPokok() + this.getTunjanganTotal();
        return gajiKotor;
    }
    
    public long getPotongan(){
        long potongan = this.getGajiKotor() * 10 / 4 / 100;
        return potongan;
    }
    
    public long getGajiBersih(){
        long gajiBersih = this.getGajiKotor() - this.getPotongan();
        return gajiBersih;
    }
}
