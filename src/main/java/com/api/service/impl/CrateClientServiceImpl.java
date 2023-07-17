package com.api.service.impl;

import com.api.dto.ClientRequestDTO;
import com.api.mapper.ClientMapper;
import com.api.model.ClientModel;
import com.api.repository.ClientModelRepository;
import com.api.service.CreateClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class CrateClientServiceImpl implements CreateClientService {

    @Autowired
    private ClientModelRepository repository;

    @Autowired
    private ClientMapper mapper;


    @Override
    public Long start(ClientRequestDTO dto) {
        log.info("Saving client, client:{}");
        final ClientModel client = mapper.toModel(dto);
        repository.save(client);
        log.info("Saved order:{}", client);
        return client.getId();
    }





}
