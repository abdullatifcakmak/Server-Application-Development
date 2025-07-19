package GL.AdisyonSistemi.Controllers;


import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Models.Entities.Siparis;
import GL.AdisyonSistemi.Services.Contracts.OdemeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-adisyon/odemeler")
public class OdemeController {

    private final OdemeServiceInterface odemeService;

    @Autowired
    public OdemeController(OdemeServiceInterface odemeService) {
        this.odemeService = odemeService;
    }

    @GetMapping
    public List<Odeme> getAllOdemeler() {
        return odemeService.findAll();
    }

    @GetMapping("/api-adisyon/{id}")
    public ResponseEntity<Odeme> getOdemeById(@PathVariable Integer id) {
        Odeme odeme = odemeService.findById(id);
        if (odeme != null) {
            return new ResponseEntity<>(odeme, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Odeme> createOdeme(@RequestBody Odeme odeme) {
        odemeService.save(odeme);
        return new ResponseEntity<>(odeme, HttpStatus.CREATED);
    }

    @PutMapping("/api-adisyon/{id}")
    public ResponseEntity<Odeme> updateOdeme(@PathVariable Integer id, @RequestBody Odeme odeme) {
        odeme.setId(id);
        odemeService.odemeYap(odeme);
        return new ResponseEntity<>(odeme, HttpStatus.OK);
    }

    @DeleteMapping("/api-adisyon/{id}")
    public ResponseEntity<Void> deleteOdeme(@PathVariable Integer id) {
        odemeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api-adisyon/siparis/{id}")
    public ResponseEntity<Siparis> getSiparisByOdemeId(@PathVariable Integer id) {
        return new ResponseEntity<>(odemeService.findSiparisOdemeId(id), HttpStatus.OK);
    }

    @GetMapping("/api-adisyon/masa/{id}")
    public ResponseEntity<Masa> getMasaByOdemeId(@PathVariable Integer id) {
        return new ResponseEntity<>(odemeService.findMasaOdemeId(id), HttpStatus.OK);
    }
}
