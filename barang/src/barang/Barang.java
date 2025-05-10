
package barang;

import java.util.Scanner;

/**
 *
 * @author Adolfridus Juniarius Darminto Baru
 * NIM 2301010361
 */
public class Barang {
    private String id;
    private String nama;
    private int jumlah;
    // Constructor default
    public Barang() {
        this.id = "";
        this.nama = "";
        this.jumlah = 0;
    }
    // Constructor overloading
    public Barang(String id, String nama, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
    }
    // Getter & Setter
    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public int getJumlah() {
        return jumlah;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    // Overridable method
    public void tampilkanInfo() {
        System.out.println("ID Barang  : " + id);
        System.out.println("Nama Barang: " + nama);
        System.out.println("Jumlah     : " + jumlah);
        System.out.println("-----------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Barang[] barangList = new Barang[100];
        int jumlahData = 0;

        int pilihan;
        do {
            System.out.println("=== MENU Aplikasi Barang ===");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Tampilkan Data Barang");
            System.out.println("3. Ubah Data Barang");
            System.out.println("4. Hapus Data Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // clear buffer

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan ID Barang: ");
                    String id = input.nextLine();
                    System.out.print("Masukkan Nama Barang: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Jumlah Barang: ");
                    int jumlah = input.nextInt();
                    input.nextLine();

                    barangList[jumlahData] = new Barang(id, nama, jumlah);
                    jumlahData++;
                    System.out.println("Data barang berhasil ditambahkan.\n");
                }
                case 2 -> {
                     if (jumlahData == 0) {
                     System.out.println("Belum ada data barang.\n");
                     } else {
                     System.out.println("=== DAFTAR BARANG ===");
                     System.out.printf("%-5s %-10s %-20s %-10s\n", "No", "ID", "Nama", "Jumlah");
                     for (int i = 0; i < jumlahData; i++) {
                     System.out.printf("%-5d %-10s %-20s %-10d\n",
                     (i + 1),barangList[i].getId(),
                             barangList[i].getNama(),
                             barangList[i].getJumlah()
                     );
                 }
                     System.out.println();
              }
            }

                case 3 -> {
                    System.out.print("Masukkan ID Barang yang ingin diubah: ");
                    String idCari = input.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahData; i++) {
                        if (barangList[i].getId().equals(idCari)) {
                            System.out.print("Masukkan Nama Baru: ");
                            String namaBaru = input.nextLine();
                            System.out.print("Masukkan Jumlah Baru: ");
                            int jumlahBaru = input.nextInt();
                            input.nextLine();

                            barangList[i].setNama(namaBaru);
                            barangList[i].setJumlah(jumlahBaru);
                            System.out.println("Data berhasil diubah.\n");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Data tidak ditemukan.\n");
                    }
                }
                case 4 -> {
                    System.out.print("Masukkan ID Barang yang ingin dihapus: ");
                    String idCari = input.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahData; i++) {
                        if (barangList[i].getId().equals(idCari)) {
                            // Geser array
                            for (int j = i; j < jumlahData - 1; j++) {
                                barangList[j] = barangList[j + 1];
                            }
                            barangList[jumlahData - 1] = null;
                            jumlahData--;
                            System.out.println("Data berhasil dihapus.\n");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Data tidak ditemukan.\n");
                    }
                }
                case 5 -> System.out.println("Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.\n");
            }
        } while (pilihan != 5);

        input.close();
    }
}
  
 

