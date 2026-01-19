import java.util.ArrayList;

public class BankaHesabi {
    // 1. Features
    public double bakiye;
    public ArrayList<String> gecmis;

    // 2. Constructor
    public BankaHesabi(double ilkBakiye) {
        this.bakiye = ilkBakiye;
        this.gecmis = new ArrayList<>();
    }

    // 3. Methods
    public void paraYatir(double miktar) {
        if (miktar > 0) {
            this.bakiye += miktar;
            this.gecmis.add(miktar + " TL yatırıldı.");
        }
    }

    public void paraCek(double miktar) {
        if (miktar > 0 && miktar <= this.bakiye) {
            this.bakiye -= miktar;
            this.gecmis.add(miktar + " TL para çekildi");
            System.out.println("İşlem başarılı.");
        } else {
            System.out.println("Hata: Yetersiz bakiye veya geçersiz miktar.");
        }
    }
}