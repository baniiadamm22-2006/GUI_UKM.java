package pertemuan6;
import java.util.Scanner;

public class mainUKM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenUKM data = new ManajemenUKM();

        System.out.println("=== SISTEM PENDAFTARAN UKM UEU ===");
        System.out.print("Nama  : ");
        data.nama = input.nextLine();

        System.out.print("NIM   : ");
        data.nim = input.nextLine();

        System.out.print("Prodi : ");
        data.prodi = input.nextLine();

        System.out.print("No WA : ");
        data.noWA = input.nextLine();

        // Pilih UKM
        data.tampilUKM();
        System.out.print("Pilih UKM : ");
        int pilihUKM = input.nextInt();
        data.pilihUKM(pilihUKM);

        // Pilih Sub UKM
        data.tampilSubUKM();
        System.out.print("Pilih Sub UKM : ");
        int pilihSub = input.nextInt();
        data.pilihSubUKM(pilihSub);

        // Pilih Level
        data.tampilLevel();
        System.out.print("Pilih Level : ");
        int pilihLevel = input.nextInt();
        data.pilihLevel(pilihLevel);

        // Cetak data
        data.cetak();

        input.close();
    }
}
