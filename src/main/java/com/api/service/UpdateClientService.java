package com.api.service;

import com.api.dto.ClientRequestUpdateDTO;

public interface UpdateClientService {

    void updateClient(Long id, ClientRequestUpdateDTO dto);
}
