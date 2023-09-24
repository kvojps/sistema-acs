package br.upe.acs.controller;

import br.upe.acs.controller.responses.ViaCepResposta;
import br.upe.acs.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/address")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService service;

    @GetMapping("/{cep}")
    public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {
        return ResponseEntity.ok(new ViaCepResposta(service.findAddressByCep(cep)));
    }
}
