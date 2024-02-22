import java.util.*;
import java.time.*;
import java.time.format.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data diri
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        char jenisKelamin;
        do {
            System.out.print("Masukkan jenis kelamin (P/L): ");
            jenisKelamin = scanner.next().charAt(0);
            if (jenisKelamin != 'L' && jenisKelamin != 'P') {
                System.out.println("Jenis kelamin yang dimasukkan tidak valid. Silakan masukkan 'L' atau 'P'.");
            }
        } while (jenisKelamin != 'L' && jenisKelamin != 'P');

        String jenisKelaminLengkap = (jenisKelamin == 'L') ? "laki-laki" : "perempuan";

        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
        String tanggalLahirStr = scanner.next();

        // Menghitung umur menggunakan java.time
        LocalDate tanggalLahir = null;
        try {
            tanggalLahir = LocalDate.parse(tanggalLahirStr, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Format tanggal salah. Harap masukkan tanggal dengan format yyyy-MM-dd.");
            return;
        }
        LocalDate tanggalSekarang = LocalDate.now();
        int umur = Period.between(tanggalLahir, tanggalSekarang).getYears();

        // Output data diri
        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Tanggal Lahir: " + tanggalLahir.format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        System.out.println("Umur: " + umur + " tahun");

        scanner.close();
    }
}
