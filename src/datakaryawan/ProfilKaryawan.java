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
public class ProfilKaryawan extends Karyawan {
    String kodeKaryawan;
    String namaKaryawan;
    String gol;
    String statusHubungan;
    private long gajiPokok;
    
    ProfilKaryawan(String kode, String nama, String gol, int usia, int status, int jumlahAnak){
        this.kodeKaryawan = kode;
        this.namaKaryawan = nama;
        this.gol = gol;
        if (status == 1){
            this.status = status;
            this.statusHubungan = "Menikah";
        }else if(status == 0){
            this.status = status;
            this.statusHubungan = "Belum Menikah";
        }
        this.usia = usia;
        this.jumlahAnak = jumlahAnak;
    }
    void dataPrint(){
        System.out.print(this.kodeKaryawan + "\t\t");
        System.out.print(this.namaKaryawan + "\t\t");
        System.out.print(this.gol + "\t");
        System.out.print(this.usia + "\t");
        System.out.print(this.statusHubungan + "\t\t");
        System.out.print(this.jumlahAnak + "\t\t");
        System.out.println("");

    }
    void print(){
        System.out.println("Kode Karyawan   : " + this.kodeKaryawan);
        System.out.println("Nama Karyawan   : " + this.namaKaryawan);
        System.out.println("Golongan        : " + this.gol);
        System.out.println("Usia            : " + this.usia);
        System.out.println("Status Menikah  : " + this.statusHubungan);
        System.out.println("Jumlah Anak     : " + this.jumlahAnak);

    }
    
    @Override
    public long getGajiPokok(){
        switch(gol){
            case "A":
                gajiPokok = 5000000;
                break;
            case "B":
                gajiPokok = 6000000;
                break;
            case "C":
                gajiPokok = 7000000;
                break;
        }
        return gajiPokok;
    }
    
    public void printGaji(){
        System.out.println("-----------------------------------------");
        System.out.println("Gaji Pokok              : Rp " + this.getGajiPokok());
        System.out.println("Tunjangan Istri/Suami   : RP " + this.getTunjanganMenikah(status));
        System.out.println("Tunjangan Pegawai       : Rp " + this.getTunjanganPegawai());
        System.out.println("Tunjangan Anak          : Rp " + this.getTunjanganAnak(jumlahAnak));
        System.out.println("-----------------------------------------  +");
        System.out.println("Gaji Kotor              : Rp " + this.getGajiKotor());
        System.out.println("Potongan                : Rp " + this.getPotongan());
        System.out.println("-----------------------------------------  -");
        System.out.println("Gaji Bersih             : Rp " + this.getGajiBersih());    
    }
}
