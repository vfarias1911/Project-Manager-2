package com.java360.pmanager.domain.applicationservice;

import com.java360.pmanager.domain.document.ApiKey;
import com.java360.pmanager.domain.repository.ApiKeyRepository;
import com.java360.pmanager.infrastructure.dto.ApiKeyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    //O ApiKeyDTO contém a estrutura recebida do cliente
    public ApiKey createApiKey(ApiKeyDTO apiKeyDTO){

        ApiKey apiKey = ApiKey
                .builder()
                .name(apiKeyDTO.getName())
                .value(UUID.randomUUID().toString())
                .expiresWhen(
                        OffsetDateTime
                                .now()
                                .plusDays(2)
                                .toInstant()
                )
                .build();

        apiKeyRepository.save(apiKey);
        return apiKey;

    }
}
