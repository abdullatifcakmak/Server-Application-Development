 CREATE TABLE `kullanicilar` ( 
  `kullanici_adi` varchar(50) NOT NULL, 
  `kullanici_sifre` varchar(68) NOT NULL, 
  `aktif` tinyint NOT NULL, 
PRIMARY KEY (`kullanici_adi`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


 INSERT INTO kullanicilar (kullanici_adi, kullanici_sifre, aktif) 
VALUES  
('latif','$2a$10$Chz/kmeqO3NP3KJ8no0TI.h9BiIN/IW8AQ8few8MvZU71.Y3fwABu',1), 
('gizem','$2a$10$Chz/kmeqO3NP3KJ8no0TI.h9BiIN/IW8AQ8few8MvZU71.Y3fwABu',1), 
('sinan','$2a$10$Chz/kmeqO3NP3KJ8no0TI.h9BiIN/IW8AQ8few8MvZU71.Y3fwABu',1); 


CREATE TABLE `roller` ( 
  `kullanici_adi` varchar(50) NOT NULL, 
  `yetki` varchar(50) NOT NULL, 
UNIQUE KEY `roller_idx_1` (`kullanici_adi`,`yetki`), 
CONSTRAINT `roller_ibfk_1`  
FOREIGN KEY (`kullanici_adi`)  
REFERENCES `kullanicilar` (`kullanici_adi`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


 INSERT INTO roller ( kullanici_adi, yetki ) 
VALUES  
('latif','ROLE_ADMIN'), 
('gizem','ROLE_USER'), 
('sinan','ROLE_USER'); 



ALTER TABLE odemeler
ADD COLUMN siparis_id INT UNIQUE;

ALTER TABLE odemeler
ADD CONSTRAINT fk_siparis FOREIGN KEY (siparis_id) REFERENCES siparisler(id) ON DELETE CASCADE;
