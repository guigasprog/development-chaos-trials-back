package com.chaos_trials.api.application.dto.token_key;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TokenKeyDTO {

    @JsonProperty("token")
    private String token;

    @JsonProperty("key")
    private String key;
}
