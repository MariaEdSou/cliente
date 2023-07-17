package com.api.mapper;

import com.api.dto.ClientRequestDTO;
import com.api.dto.ClienteResponseDTO;
import com.api.model.ClientModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientModel toModel(ClientRequestDTO clientDTO);

    ClienteResponseDTO toDTO(ClientModel clientModel);
}
