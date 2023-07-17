package com.api.service;

import com.api.dto.ClienteResponseDTO;
import org.springframework.data.domain.Pageable;

public interface ListClientService {

     ClienteResponseDTO list(Long id);

}
