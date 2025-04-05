import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] filmAdlari = new String[10];
        String[] filmTurleri = new String[10];
        int[] filmSureleri = new int[10];
        int filmSayisi = 0;

        String[] musteriAdlari = new String[20];
        String[] musteriMailleri = new String[20];
        int[] biletler = new int[20];
        int musteriSayisi = 0;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1- Film Ekle\n2- Müşteri Ekle\n3- Bilet Kaydı\n4- Listele\n0- Çıkış");
            System.out.print("Seçim: ");
            int secim = input.nextInt();
            input.nextLine();

            if (secim == 1) {
                if (filmSayisi < 10) {
                    System.out.print("Film adı: ");
                    filmAdlari[filmSayisi] = input.nextLine();

                    System.out.print("Film süresi (dakika): ");
                    filmSureleri[filmSayisi] = input.nextInt();
                    input.nextLine();

                    System.out.print("Film türü: ");
                    filmTurleri[filmSayisi] = input.nextLine();

                    filmSayisi++;
                    System.out.println("Film eklendi.");
                } else {
                    System.out.println("Film limiti doldu.");
                }
            }

            else if (secim == 2) {
                if (musteriSayisi < 20) {
                    System.out.print("Müşteri adı: ");
                    musteriAdlari[musteriSayisi] = input.nextLine();

                    System.out.print("Müşteri e-posta: ");
                    musteriMailleri[musteriSayisi] = input.nextLine();

                    biletler[musteriSayisi] = -1; // henüz film yok
                    musteriSayisi++;
                    System.out.println("Müşteri eklendi.");
                } else {
                    System.out.println("Müşteri limiti doldu.");
                }
            }

            else if (secim == 3) {
                if (musteriSayisi == 0 || filmSayisi == 0) {
                    System.out.println("Önce film ve müşteri ekleyin.");
                    continue;
                }

                System.out.println("Müşteriler:");
                for (int i = 0; i < musteriSayisi; i++)
                    System.out.println(i + "- " + musteriAdlari[i]);

                System.out.print("Müşteri numarası: ");
                int mIndex = input.nextInt();

                System.out.println("Filmler:");
                for (int i = 0; i < filmSayisi; i++)
                    System.out.println(i + "- " + filmAdlari[i] + " (" + filmTurleri[i] + ", " + filmSureleri[i] + " dk)");

                System.out.print("Film numarası: ");
                int fIndex = input.nextInt();

                biletler[mIndex] = fIndex;
                System.out.println("Bilet kaydedildi.");
            }

            else if (secim == 4) {
                System.out.println("--- Bilet Listesi ---");
                for (int i = 0; i < musteriSayisi; i++) {
                    if (biletler[i] >= 0)
                        System.out.println(filmAdlari[biletler[i]] + " (" + filmTurleri[biletler[i]] + ", " + filmSureleri[biletler[i]] + " dk)");
                    else System.out.println("Henüz seçilmedi");
                    System.out.println(musteriAdlari[i] + " - " + musteriMailleri[i] + " | Film: ");
                }
            }

            else if (secim == 0) {
                System.out.println("Programdan çıkılıyor...");
                break;
            }

            else {
                System.out.println("Geçersiz seçim.");
            }
        }

        input.close();
    }
}