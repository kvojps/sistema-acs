package br.upe.acs.controller;

import br.upe.acs.controller.responses.ViaCepResposta;
import br.upe.acs.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/addresses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AddressController {

    private final AddressService service;

    @Operation(summary = "Buscar endereço completo por cep")
    @GetMapping("/{cep}")
    public ResponseEntity<?> findAddressByCep(@PathVariable String cep) {
        return ResponseEntity.ok(new ViaCepResposta(service.findAddressByCep(cep)));
    }
}
