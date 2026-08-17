import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Ogrenci {
    private String id;
    private String ad;
    private String soyad;
    private String bolum;
    private int yas;
    private double ortalama;

    public Ogrenci(String id, String ad, String soyad, String bolum, int yas, double ortalama) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.bolum = bolum;
        this.yas = yas;
        this.ortalama = ortalama;
    }

    public String getId() { return id; }
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }
    public String getBolum() { return bolum; }
    public void setBolum(String bolum) { this.bolum = bolum; }
    public int getYas() { return yas; }
    public void setYas(int yas) { this.yas = yas; }
    public double getOrtalama() { return ortalama; }
    public void setOrtalama(double ortalama) { this.ortalama = ortalama; }

    public void bilgileriYazdir() {
        System.out.println("ID: " + id + " | Ad: " + ad + " " + soyad + " | Bölüm: " + bolum + " | Yaş: " + yas + " | Ortalama: " + ortalama);
    }

    public String toCsvFormat() {
        return id + "," + ad + "," + soyad + "," + bolum + "," + yas + "," + ortalama;
    }
}

class OgrenciBilgiSistemi {
    private List<Ogrenci> ogrenciler;
    private final String dosyaAdi = "ogrenciler.txt";
    private Scanner scanner;

    public OgrenciBilgiSistemi(Scanner scanner) {
        this.ogrenciler = new ArrayList<>();
        this.scanner = scanner;
        dosyadanOku();
    }

    private boolean idVarMi(String id) {
        for (Ogrenci o : ogrenciler) {
            if (o.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void ogrenciEkle() {
        System.out.println("\n Yeni Öğrenci Ekle ");
        System.out.print("Öğrenci ID: ");
        String id = scanner.nextLine().trim();

        if (idVarMi(id)) {
            System.out.println(" Hata: Bu ID numarası kullanılıyor");
            return;
        }

        System.out.print("Ad: ");
        String ad = scanner.nextLine().trim();
        System.out.print("Soyad: ");
        String soyad = scanner.nextLine().trim();
        System.out.print("Bölüm: ");
        String bolum = scanner.nextLine().trim();

        try {
            System.out.print("Yaş: ");
            int yas = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Not Ortalaması (0-100 veya 0-4): ");
            double ortalama = Double.parseDouble(scanner.nextLine().trim());

            ogrenciler.add(new Ogrenci(id, ad, soyad, bolum, yas, ortalama));
            System.out.println("Öğrenci eklendi.");
        } catch (NumberFormatException e) {
            System.out.println(" Hata: Yanlış karakter");
        }
    }

    public void ogrenciSil() {
        System.out.println("\n Öğrenci Sil");
        System.out.print("Silinecek Öğrenci ID: ");
        String id = scanner.nextLine().trim();

        for (int i = 0; i < ogrenciler.size(); i++) {
            if (ogrenciler.get(i).getId().equalsIgnoreCase(id)) {
                ogrenciler.remove(i);
                System.out.println(" " + id + " IDsi olan öğrenci sistemden silindi.");
                return;
            }
        }
        System.out.println(" Öğrenci bulunamadı.");
    }

    public void ogrenciGuncelle() {
        System.out.println("\n Öğrenci Güncelle ");
        System.out.print("Güncellenecek Öğrenci ID: ");
        String id = scanner.nextLine().trim();

        for (Ogrenci o : ogrenciler) {
            if (o.getId().equalsIgnoreCase(id)) {
                System.out.println("Mevcut Bilgiler:");
                o.bilgileriYazdir();
                System.out.println("\nYeni bilgileri giriniz ");

                System.out.print("Yeni Ad [" + o.getAd() + "]: ");
                String ad = scanner.nextLine().trim();
                if (!ad.isEmpty()) {
                    o.setAd(ad);
                }

                System.out.print("Yeni Soyad [" + o.getSoyad() + "]: ");
                String soyad = scanner.nextLine().trim();
                if (!soyad.isEmpty()) {
                    o.setSoyad(soyad);
                }

                System.out.print("Yeni Bölüm [" + o.getBolum() + "]: ");
                String bolum = scanner.nextLine().trim();
                if (!bolum.isEmpty()) {
                    o.setBolum(bolum);
                }

                System.out.print("Yeni Yaş [" + o.getYas() + "]: ");
                String yasStr = scanner.nextLine().trim();
                if (!yasStr.isEmpty()) {
                    try {
                        o.setYas(Integer.parseInt(yasStr));
                    } catch (NumberFormatException e) {
                        System.out.println(" yanliş deger veri silinmedi .");
                    }
                }

                System.out.print("Yeni Ortalama [" + o.getOrtalama() + "]: ");
                String ortStr = scanner.nextLine().trim();
                if (!ortStr.isEmpty()) {
                    try {
                        o.setOrtalama(Double.parseDouble(ortStr));
                    } catch (NumberFormatException e) {
                        System.out.println(" Geçersiz ortalama, eski değer korundu.");
                    }
                }

                System.out.println(" Öğrenci bilgileri güncellendi.");
                return;
            }
        }
        System.out.println(" Bu IDye sahip öğrenci bulunamadı.");
    }

    public void ogrenciListele() {
        System.out.println("\n........................");
        System.out.println("KAYITLI ÖĞRENCİ LİSTESİ");
        System.out.println("...........................");

        if (ogrenciler.isEmpty()) {
            System.out.println("Sistemde kayıtlı öğrenci bulunmamaktadır.");
            return;
        }

        for (Ogrenci o : ogrenciler) {
            o.bilgileriYazdir();
        }
    
    }

    public void ogrenciAra() {
        System.out.println("\n Öğrenci Ara");
        System.out.print("Aramak istediğiniz Öğrenci Adı: ");
        String arama = scanner.nextLine().trim().toLowerCase();
        List<Ogrenci> bulunanlar = new ArrayList<>();

        for (Ogrenci o : ogrenciler) {
            if (o.getId().toLowerCase().equals(arama) || o.getAd().toLowerCase().contains(arama)) {
                bulunanlar.add(o);
            }
        }

        if (!bulunanlar.isEmpty()) {
            System.out.println("\nToplam " + bulunanlar.size() + " sonuç bulundu:");
            for (Ogrenci o : bulunanlar) {
                o.bilgileriYazdir();
            }
        } else {
            System.out.println("Eşleşen öğrenci bulunamadı.");
        }
    }

    public void ortalamayaGoreSirala() {
        if (ogrenciler.isEmpty()) {
            System.out.println("Sistemde sıralanacak öğrenci yok.");
            return;
        }

        List<Ogrenci> siraliListe = new ArrayList<>(ogrenciler);
        siraliListe.sort((a, b) -> Double.compare(b.getOrtalama(), a.getOrtalama()));
 
        System.out.println("\n Başarı Sıralaması ");
        int sira = 1;
        for (Ogrenci o : siraliListe) {
            System.out.print(sira + ". ");
            o.bilgileriYazdir();
            sira++;
        }
    }

    public void enBasariliVeBasarisiz() {
        if (ogrenciler.isEmpty()) {
            System.out.println("Sistemde öğrenci bulunmamaktadır.");
            return;

            Ogrenci enBasarisiz = ogrenciler.get(0);

            for (Ogrenci o : ogrenciler) {
              if (o.getOrtalama() < enBasarisiz.getOrtalama()) {
              enBasarisiz = o;
    }
}
        }
            Ogrenci enBasarili = ogrenciler.get(0);

            for (Ogrenci o : ogrenciler) {
            if (o.getOrtalama() > enBasarili.getOrtalama()) {
             enBasarili = o;
    }
}
d

        System.out.println("\n EN BAŞARILI VE EN BAŞARISIZ ÖĞRENCİ ");
        System.out.println(".........................................-");
        System.out.println(" En Başarılı Öğrenci:");
        enBasarili.bilgileriYazdir();
        System.out.println("\nEn Düşük Ortalamaya Sahip Öğrenci:");
        enBasarisiz.bilgileriYazdir();
    }

    public void dosyayaKaydet() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dosyaAdi))) {
            for (Ogrenci o : ogrenciler) {
                writer.println(o.toCsvFormat());
            }
            System.out.println(" Tüm veriler '" + dosyaAdi + "' dosyasına kaydedildi.");
        } catch (IOException e) {
            System.out.println(" Dosya kaydedilmedi " + e.getMessage());
        }
    }

    private void dosyadanOku() {
        File file = new File(dosyaAdi);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] parcalar = satir.trim().split(",");
                if (parcalar.length == 6) {
                    String id = parcalar[0];
                    String ad = parcalar[1];
                    String soyad = parcalar[2];
                    String bolum = parcalar[3];
                    int yas = Integer.parseInt(parcalar[4]);
                    double ortalama = Double.parseDouble(parcalar[5]);
                    ogrenciler.add(new Ogrenci(id, ad, soyad, bolum, yas, ortalama));
                }
            }
        } catch (Exception e) {
            System.out.println(" Dosya okunmadi " + e.getMessage());
        }
    }
}

public class OgrenciSıstemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OgrenciBilgiSistemi sistem = new OgrenciBilgiSistemi(scanner);

        while (true) {
            System.out.println("\n........ ÖĞRENCİ YÖNETİM SİSTEMİ .........");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Öğrenci Sil");
            System.out.println("3. Öğrenci Güncelle");
            System.out.println("4. Öğrenci Listele");
            System.out.println("5. Öğrenci Ara (ID veya İsim)");
            System.out.println("6. Ortalamaya Göre Sırala");
            System.out.println("7. En Başarılı ve En Başarısız Öğrenci ");
            System.out.println("8. Öğrenci Bilgilerini Dosyaya Kaydet");
            System.out.println("9. Programdan Çık");
            System.out.print("Seçiminiz (1-9): ");

            String secim = scanner.nextLine().trim();

            if (secim.equals("1")) {
                sistem.ogrenciEkle();
            } else if (secim.equals("2")) {
                sistem.ogrenciSil();
            } else if (secim.equals("3")) {
                sistem.ogrenciGuncelle();
            } else if (secim.equals("4")) {
                sistem.ogrenciListele();
            } else if (secim.equals("5")) {
                sistem.ogrenciAra();
            } else if (secim.equals("6")) {
                sistem.ortalamayaGoreSirala();
            } else if (secim.equals("7")) {
                sistem.enBasariliVeBasarisiz();
            } else if (secim.equals("8")) {
                sistem.dosyayaKaydet();
            } else if (secim.equals("9")) {
                System.out.print("Çıkmadan önce değişiklikler kaydedilsin mi? (E/H): ");
                String onay = scanner.nextLine().trim();
                if (onay.equalsIgnoreCase("e")) {
                    sistem.dosyayaKaydet();
                }
                System.out.println(" Sistemden çıkılıyor. ;)");
                scanner.close();
                break;
            } else {
                System.out.println("Geçersiz seçim! Lütfen 1-9 arasında bir değer giriniz.");
            }
        }
    }
}