CREATE DATABASE adisyon;
USE adisyon;

CREATE TABLE masalar (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numara INT UNIQUE NOT NULL,
    durum VARCHAR(20) NOT NULL,
    toplam_tutar DOUBLE default 0
);

CREATE TABLE siparisler (
    id INT AUTO_INCREMENT PRIMARY KEY,
    urun_adi VARCHAR(100) NOT NULL,
    fiyat DOUBLE NOT NULL,
    miktar INT NOT NULL,
    toplam_fiyat DOUBLE AS (fiyat * miktar) STORED,
    masa_id INT NOT NULL
);

CREATE TABLE odemeler (
    id INT AUTO_INCREMENT PRIMARY KEY,
    toplam_tutar DOUBLE NOT NULL,
    odeme_tarihi DATE,
    odeme_sekli VARCHAR(20) default ('nakit') ,
    status INT NOT NULL default 0, 
    masa_id INT NOT NULL
);