import java.util.Scanner;

public class Finance {
    public static void main(String[] args) {
        System.out.println("Hoşgeldiniz \nLütfen bir rakam seçiniz");

        Scanner scanner = new Scanner(System.in);

        double bakiye = 100;
        boolean calisiyor = true;

        while (calisiyor) {

            System.out.println("1- Para Yatır\n2- Para çek\n3- Bakiye sorgulama\n4- Çıkış");

            System.out.print("----------------------------- \n");
            int secim = scanner.nextInt();


            switch (secim) {
                case 1 -> {
                    System.out.print("Yatırmak istediğiniz tutarı giriniz :");
                    double girenpara = scanner.nextDouble();

                    bakiye += girenpara;
                    System.out.println("Total bakiyeniz :" + bakiye);
                }

                case 2 -> {
                    System.out.print("Çekmek istediğiniz tutarı giriniz :");
                    double cekilenpara = scanner.nextDouble();

                    if (bakiye < cekilenpara) {
                        System.out.println("Bakiye yeresiz");
                    } else {
                        bakiye -= cekilenpara;
                        System.out.println("Total bakiyeniz :" + bakiye);
                    }
                }

                case 3 -> System.out.println("Total Bakiyeniz :" + bakiye);

                case 4 -> {
                    System.out.println("Çıkış yapılıyor..");
                    calisiyor = false;
                }
            }
        }
    }
}