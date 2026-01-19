package pertemuan6;
import java.util.ArrayList;

public class ManajemenUKM {

    protected String nama, nim, prodi, noWA;
    protected String ukm, subUKM, level, kontak;

    ArrayList<String> daftarUKM = new ArrayList<>();
    ArrayList<String> daftarSubUKM = new ArrayList<>();
    ArrayList<String> daftarLevel = new ArrayList<>();

    public ManajemenUKM() {
        daftarUKM.add("Olahraga");
        daftarUKM.add("Seni");
        daftarUKM.add("Akademik");
        daftarUKM.add("Sosial");

        daftarLevel.add("Pemula");
        daftarLevel.add("Standar");
        daftarLevel.add("Mahir");
    }


    public boolean cekNIM() {
        return nim != null && nim.length() == 11;
    }

    public boolean cekNoWA() {
        return noWA != null && noWA.length() >= 11 && noWA.length() <= 13;
    }


    public void tampilUKM() {
        System.out.println("\n=== DAFTAR UKM ===");
        for (int i = 0; i < daftarUKM.size(); i++) {
            System.out.println((i + 1) + ". " + daftarUKM.get(i));
        }
    }


    public void pilihUKM(int pilihan) {
        daftarSubUKM.clear();

        if (pilihan > 0 && pilihan <= daftarUKM.size()) {
            ukm = daftarUKM.get(pilihan - 1);

            switch (ukm.toLowerCase()) {
                case "olahraga":
                    daftarSubUKM.add("Badminton");
                    daftarSubUKM.add("Futsal");
                    daftarSubUKM.add("Voli");
                    daftarSubUKM.add("Taekwondo");
                    daftarSubUKM.add("Basket");
                    daftarSubUKM.add("Karate");
                    break;
                case "seni":
                    daftarSubUKM.add("Dance Modern");
                    daftarSubUKM.add("Dance Tradisional");
                    daftarSubUKM.add("UKM Band");
                    break;
                case "akademik":
                    daftarSubUKM.add("Karya Ilmiah");
                    daftarSubUKM.add("Debat");
                    daftarSubUKM.add("Programming Club");
                    break;
                case "sosial":
                    daftarSubUKM.add("IKMI");
                    daftarSubUKM.add("HIMPALA");
                    break;
            }
        }
    }

    public void tampilSubUKM() {
        System.out.println("\n=== DAFTAR SUB UKM ===");
        for (int i = 0; i < daftarSubUKM.size(); i++) {
            System.out.println((i + 1) + ". " + daftarSubUKM.get(i));
        }
    }

 
    public void pilihSubUKM(int pilihan) {
        if (pilihan > 0 && pilihan <= daftarSubUKM.size()) {
            subUKM = daftarSubUKM.get(pilihan - 1);

            switch (subUKM.toLowerCase()) {
                case "badminton": kontak = "081234567801 (Rizky)"; break;
                case "futsal": kontak = "081234567802 (Andi)"; break;
                case "voli": kontak = "081234567803 (Bima)"; break;
                case "taekwondo": kontak = "081234567804 (Satria)"; break;
                case "basket": kontak = "081234567805 (Kevin)"; break;
                case "karate": kontak = "081234567806 (Doni)"; break;
                case "dance modern":
                case "dance tradisional": kontak = "081234567807 (Ayu)"; break;
                case "ukm band": kontak = "081234567808 (Rama)"; break;
                case "ikmi": kontak = "081234567809 (Fajar)"; break;
                case "himpala": kontak = "081234567810 (Yoga)"; break;
                default: kontak = "Tidak tersedia";
            }
        }
    }


    public void tampilLevel() {
        System.out.println("\n=== LEVEL KEAHLIAN ===");
        for (int i = 0; i < daftarLevel.size(); i++) {
            System.out.println((i + 1) + ". " + daftarLevel.get(i));
        }
    }

    // Pilih Level
    public void pilihLevel(int pilihan) {
        if (ukm != null && ukm.equalsIgnoreCase("akademik")) {
            level = "Tidak Berlaku";
        } else if (pilihan > 0 && pilihan <= daftarLevel.size()) {
            level = daftarLevel.get(pilihan - 1);
        }
    }

    public void cetak() {
        System.out.println(getOutput());
    }

public String getOutput() {
        return "=== DATA PENDAFTARAN UKM ===\n" +
        "Nama     : " + nama + "\n" +
        "NIM      : " + nim + " (" + (cekNIM() ? "VALID" : "TIDAK VALID") + ")\n" +
        "Prodi    : " + prodi + "\n" +
        "No WA    : " + noWA + " (" + (cekNoWA() ? "VALID" : "TIDAK VALID") + ")\n" +
        "UKM      : " + ukm + "\n" +
        "Sub UKM  : " + subUKM + "\n" +
        "Level    : " + level + "\n" +
        "Kontak   : " + kontak;
    }
}

