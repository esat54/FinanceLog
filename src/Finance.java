import java.util.Scanner;

public class Finance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankaHesabi hesabim = new BankaHesabi(100);

        boolean calisiyor = true;

        System.out.println("--- Finans Uygulamasına Hoşgeldiniz ---");

        while (calisiyor) {
            menuGoster();
            int secim = scanner.nextInt();

            switch (secim) {
                case 1 -> {
                    System.out.print("Yatırmak istediğiniz tutar: ");
                    double miktar = scanner.nextDouble();

                    hesabim.paraYatir(miktar);
                }
                case 2 -> {
                    System.out.print("Çekmek istediğiniz tutar: ");
                    double miktar = scanner.nextDouble();

                    hesabim.paraCek(miktar);
                }
                case 3 -> {
                    System.out.println("Güncel Bakiyen: " + hesabim.bakiye + " TL");
                }
                case 4 -> {
                    System.out.println("--- SON 5 İŞLEM ---");
                    if (hesabim.gecmis.isEmpty()) {
                        System.out.println("Henüz bir işlem yapılmamış");
                    } else {
                        int toplamislem = hesabim.gecmis.size();
                        int baslangic = Math.max(0, toplamislem - 5);


                        for (int i = baslangic; i < toplamislem; i++) {
                            System.out.println("- " + hesabim.gecmis.get(i));
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
}