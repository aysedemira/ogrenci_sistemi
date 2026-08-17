# Öğrenci Yönetim Sistemi

Bu proje, öğrencilerin bilgilerinin kayıt altında tutulması ve yönetilmesi amacıyla hazırlanmış basit bir **Öğrenci Yönetim Sistemi** projesidir.

Proje Java programlama dili kullanılarak geliştirilmiştir. Projede temel olarak **OOP, ArrayList, metotlar, döngüler, koşullar ve dosya işlemleri** kullanılmıştır.

## Projenin Amacı

Bu projenin amacı;

* Öğrenci eklemek
* Öğrenci bilgilerini güncellemek
* Öğrencileri listelemek
* Öğrenci aramak
* Öğrenci bilgilerini dosyaya kaydetmek

gibi temel işlemleri gerçekleştirmektir.

## Öğrenci Bilgileri

Sistemde her öğrenci için aşağıdaki bilgiler tutulmaktadır:

* ID
* Ad Soyad
* Bölüm
* Yaş
* Not Ortalaması

Her öğrenciye farklı bir ID verilmesi sağlanmıştır. Aynı ID'nin tekrar kullanılmasına izin verilmemektedir.

## Özellikler

### Öğrenci Ekleme

Kullanıcıdan öğrencinin ID, ad soyad, bölüm, yaş ve not ortalaması bilgileri alınarak sisteme eklenir.

### Öğrenci Güncelleme

ID üzerinden öğrenci bulunarak öğrencinin ad soyad, bölüm, yaş ve ortalama bilgileri değiştirilebilir.

### Öğrenci Listeleme

Sistemde bulunan bütün öğrenciler ekrana düzenli bir şekilde yazdırılır.

### Öğrenci Arama

Öğrenciler ID veya isim kullanılarak aranabilir.

### Dosya İşlemleri

Öğrenci bilgileri `ogrenciler.txt` dosyasına kaydedilir.

Program tekrar çalıştırıldığında dosyadaki öğrenciler okunarak sisteme tekrar eklenir. Böylece program kapatıldığında bilgiler kaybolmaz.

## Menü

Program çalıştırıldığında aşağıdaki menü kullanıcıya gösterilir:

```text
==========================================
       ÖĞRENCİ YÖNETİM SİSTEMİ
==========================================
1. Öğrenci Ekle
2. Öğrenci Sil
3. Öğrenci Güncelle
4. Öğrenci Listele
5. Öğrenci Ara
6. Ortalamaya Göre Sırala
7. Dosyaya Kaydet
8. Çıkış
==========================================
```

## Proje Yapısı

```text
OgrenciSistemi
│
├── OgrenciSistemi.java
├── ogrenciler.txt
└── README.md
```

`OgrenciSistemi.java` → Projenin Java kodlarının bulunduğu dosyadır.

`ogrenciler.txt` → Öğrenci bilgilerinin kaydedildiği dosyadır.

`README.md` → Proje hakkında bilgilerin bulunduğu dosyadır.

## OOP Kullanımı

Projede `Ogrenci` adında bir sınıf oluşturulmuştur.

Bu sınıf içerisinde öğrencinin:

```text
id
adSoyad
bolum
yas
ortalama
```

bilgileri tutulmaktadır.

Her öğrenci için `Ogrenci` sınıfından yeni bir nesne oluşturulmaktadır.

## Sıralama

Öğrencileri not ortalamasına göre sıralamak için temel bir **Bubble Sort** algoritması kullanılmıştır.

En yüksek not ortalamasına sahip öğrenci listenin başında olacak şekilde sıralama yapılmaktadır.

## Dosya Kaydetme

Program içerisinde yapılan öğrenci kayıtları `ogrenciler.txt` dosyasına kaydedilir.

Örnek kayıt:

```text
1,Ayşe Demir ,Yazılım Mühendisliği,20,82.5
2,Ege Ulaş ,Makine Mühendisliği,19,91.0
```

## Öğrenilen Konular

Bu proje sayesinde aşağıdaki konularda pratik yapılmıştır:

* Class ve Object
* Constructor
* OOP mantığı
* ArrayList kullanımı
* Metot oluşturma
* For döngüsü
* If-Else kullanımı
* Veri arama
* Veri silme
* Veri güncelleme
* Sıralama algoritması
* Dosyaya veri yazma
* Dosyadan veri okuma

## Sonuç

Bu proje, temel Java konularını kullanarak gerçek hayattaki bir öğrenci kayıt sisteminin basit bir şekilde nasıl oluşturulabileceğini göstermektedir.

Projenin amacı sadece çalışan bir program yapmak değil, aynı zamanda **OOP ve veri yönetimi mantığını öğrenmek ve uygulamaktır.**
