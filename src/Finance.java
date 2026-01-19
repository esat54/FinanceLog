import java.util.ArrayList;
import java.util.Scanner;

public class Finance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double bakiye = 100;
        boolean calisiyor = true;
        ArrayList<String> gecmis = new ArrayList<>();

        System.out.println("--- Finans Uygulamasına Hoşgeldiniz ---");

        while (calisiyor) {
            menuGoster();
            int secim = scanner.nextInt();

            switch (secim) {
                case 1 -> {
                    System.out.print("Yatırmak istediğiniz tutar: ");
                    double miktar = scanner.nextDouble();
                    bakiye = paraYatir(bakiye, miktar);
                    bakiyeGoster(bakiye);
                    gecmis.add(miktar + " TL para yatırıldı");
                }
                case 2 -> {
                    System.out.print("Çekmek istediğiniz tutar: ");
                    double miktar = scanner.nextDouble();
                    bakiye = paraCek(bakiye, miktar);
                    bakiyeGoster(bakiye);
                    gecmis.add(miktar + " TL para çekildi");
                }
                case 3 -> bakiyeGoster(bakiye);
                case 4 -> {
                    System.out.println("--- SON 5 İŞLEM ---");
                    if (gecmis.isEmpty()) {
                        System.out.println("Henüz bir işlem yapılmamış");
                    } else {
                        int toplamislem = gecmis.size();
                        int baslangic = Math.max(0, toplamislem - 5);


                        for (int i = baslangic; i < toplamislem; i++) {
                            System.out.println("- " + gecmis.get(i));
                        }
                        ;
                    }
                }
                case 5 -> {
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    calisiyor = false;
                }
                default -> System.out.println("Hatalı seçim! Lütfen 1-5 arası bir sayı giriniz.");
            }
        }
        scanner.close();
    }


    public static void menuGoster() {
        System.out.println("\n1- Para Yatır");
        System.out.println("2- Para Çek");
        System.out.println("3- Bakiye Sorgulama");
        System.out.println("4- Geçmiş 5 işlemi göster");
        System.out.println("5- Çıkış");
        System.out.print("Seçiminiz: ");
    }

    public static void bakiyeGoster(double miktar) {
        System.out.println("Güncel Bakiyen: " + miktar + " TL");
    }

    public static double paraYatir(double bakiye, double miktar) {
        if (miktar > 0) {
            return miktar + bakiye;
        } else {
            System.out.println("Yatırılacak miktar 0'dan büyük olmalıdır.");
            return bakiye;
        }
    }

    public static double paraCek(double mevcutBakiye, double miktar) {
        if (miktar <= 0) {
            System.out.println("Hata: Geçersiz miktar.");
            return mevcutBakiye;
        }

        if (miktar > mevcutBakiye) {
            System.out.println("Hata: Yetersiz bakiye! İşlem gerçekleştirilemedi.");
            return mevcutBakiye;
        } else {
            System.out.println("İşlem başarılı. " + miktar + " TL çekildi.");
            return mevcutBakiye - miktar;
        }
    }
}