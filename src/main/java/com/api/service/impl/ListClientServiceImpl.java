package com.api.service.impl;

import com.api.dto.ClienteResponseDTO;
import com.api.exceptions.BusinessException;
import com.api.mapper.ClientMapper;
import com.api.model.ClientModel;
import com.api.repository.ClientModelRepository;
import com.api.service.ListClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@Log4j2
public class ListClientServiceImpl implements ListClientService {

    @Autowired
    private ClientModelRepository repository;

    @Autowired
    private ClientMapper mapper;


    @Override
    public ClienteResponseDTO list(Long id) {
        Optional<ClientModel> clientModelOptional = repository.findById(id);

        if (clientModelOptional.isPresent()) {
            ClienteResponseDTO clienteResponseDTO = mapper.toDTO(clientModelOptional.get());
            log.info("listing client, client:{}", clienteResponseDTO);
            return clienteResponseDTO;
        }

        throw new BusinessException(NOT_FOUND, "Cliente nao esta presente");
    }
}
