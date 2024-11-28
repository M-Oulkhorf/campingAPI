package bar.sio.camping.controllers;

import bar.sio.camping.Model.Participer;
import bar.sio.camping.service.ParticiperService;
import bar.sio.camping.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creneaux")
public class ParticiperController {

    @Autowired
    private ParticiperService participerService;

    @GetMapping("/{creneauId}/campeurs")
    public ResponseEntity<List<Utilisateur>> getCampeursByCreneau(@PathVariable int creneauId) {
        List<Utilisateur> campeurs = participerService.getCampeursByCreneauId(creneauId);
        return ResponseEntity.ok(campeurs);
    }

    @PostMapping ("/{campeurId}/{creneauId}")
    public ResponseEntity<Participer> participerAuCreneau(@RequestBody Participer participer){
        Participer participeCreneau = participerService.participeCreneau(participer);
        return ResponseEntity.status(HttpStatus.CREATED).body(participeCreneau);
    }


}
