package bar.sio.camping.controllers;

import bar.sio.camping.Model.Creneau;
import bar.sio.camping.service.CreneauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
public class CreneauController {
    @Autowired
    private CreneauService creneauService;

    @GetMapping
    public ResponseEntity<List<Creneau>> getAllCreneaux() {
        return ResponseEntity.ok(creneauService.getAllCreneaux());
    }
}