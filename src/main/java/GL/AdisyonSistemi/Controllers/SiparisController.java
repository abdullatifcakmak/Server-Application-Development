package GL.AdisyonSistemi.Controllers;


import GL.AdisyonSistemi.Models.Entities.Siparis;
import GL.AdisyonSistemi.Models.dto.updateSiparisDto;
import GL.AdisyonSistemi.Services.Contracts.SiparisServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-adisyon/siparisler")
public class SiparisController {

    private final SiparisServiceInterface siparisService;

    @Autowired
    public SiparisController(SiparisServiceInterface siparisService) {
        this.siparisService = siparisService;
    }

    @GetMapping
    public List<Siparis> getAllSiparisler() {
        return siparisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siparis> getSiparisById(@PathVariable Integer id) {
        Siparis siparis = siparisService.findById(id);
        if (siparis != null) {
            return new ResponseEntity<>(siparis, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Siparis> createSiparis(@RequestBody Siparis siparis) {
        siparisService.save(siparis);
        return new ResponseEntity<>(siparis, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Siparis> updateSiparis(@PathVariable Integer id, @RequestBody updateSiparisDto siparisDto) {
        Siparis siparis=siparisDto.getSiparis();
        siparisService.update(siparis,siparisDto.getOdemeId());
        return new ResponseEntity<>(siparis, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiparis(@PathVariable Integer id) {
        siparisService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}