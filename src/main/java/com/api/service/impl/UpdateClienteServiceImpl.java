package com.api.service.impl;

import com.api.dto.ClientRequestUpdateDTO;
import com.api.mapper.ClientMapper;
import com.api.model.ClientModel;
import com.api.repository.ClientModelRepository;
import com.api.service.UpdateClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
public class UpdateClienteServiceImpl implements UpdateClientService {
    @Autowired
    private ClientModelRepository repository;

    @Transactional
    @Override
    public void updateClient(@PathVariable Long id, ClientRequestUpdateDTO dto) {
        ClientModel clientModel = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CLIENT NOT FOUND"));
        if (dto.getEmail() != null) {
            clientModel.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            clientModel.setPhone(dto.getPhone());
        }
        repository.save(clientModel);
        log.info("UPDATE CLIENT, {} ", clientModel.getId());
    }
}
