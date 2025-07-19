package GL.AdisyonSistemi.Controllers;



import GL.AdisyonSistemi.Models.Entities.Masa;
import GL.AdisyonSistemi.Models.Entities.Odeme;
import GL.AdisyonSistemi.Services.Contracts.MasaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-adisyon/masalar")
public class MasaController {

    private final MasaServiceInterface masaService;

    @Autowired
    public MasaController(MasaServiceInterface masaService) {
        this.masaService = masaService;
    }

    @GetMapping
    public List<Masa> getAllMasas() {
        return masaService.findAll();
    }

    @GetMapping("/api-adisyon/{id}")
    public ResponseEntity<Masa> getMasaById(@PathVariable Integer id) {
        Masa masa = masaService.findById(id);
        if (masa != null) {
            return new ResponseEntity<>(masa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Masa> createMasa(@RequestBody Masa masa) {
        masaService.save(masa);
        return new ResponseEntity<>(masa, HttpStatus.CREATED);
    }

    @PutMapping("/api-adisyon/{id}")
    public ResponseEntity<Masa> updateMasa(@PathVariable Integer id, @RequestBody Masa masa) {
        masa.setId(id);
        masaService.update(masa);
        return new ResponseEntity<>(masa, HttpStatus.OK);
    }

    @DeleteMapping("/api-adisyon/{id}")
    public ResponseEntity<Void> deleteMasa(@PathVariable Integer id) {
        masaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api-adisyon/odemeler/{id}")
    public List<Odeme> getOdemelerMasa(@PathVariable Integer id) {
        return masaService.findOdemeByMasa(id);

    }

}


