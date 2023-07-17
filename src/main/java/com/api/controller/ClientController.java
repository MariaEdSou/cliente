package com.api.controller;

import com.api.dto.ClientRequestDTO;
import com.api.dto.ClienteResponseDTO;
import com.api.dto.ClientRequestUpdateDTO;
import com.api.service.CreateClientService;
import com.api.service.ListClientService;
import com.api.service.UpdateClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v1/client")
public class ClientController {

    @Autowired
    CreateClientService service;
    @Autowired
    ListClientService listservice;
    @Autowired
    UpdateClientService updateService;

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody @Valid final ClientRequestDTO dto)
            throws URISyntaxException {
        final var clientId = service.start(dto);
        return ResponseEntity.created(new URI("/v1/client" + clientId)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> list(@PathVariable Long id) {
        ClienteResponseDTO clienteResponseDTO = listservice.list(id);
        return ResponseEntity.ok(clienteResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ClientRequestUpdateDTO dto)
            throws URISyntaxException {
        updateService.updateClient(id, dto);
        return ResponseEntity.ok().build();
    }


}