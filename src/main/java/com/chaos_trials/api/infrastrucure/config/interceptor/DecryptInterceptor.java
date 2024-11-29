package com.chaos_trials.api.infrastrucure.config.interceptor;

import com.chaos_trials.api.domain.model.account.Account;
import com.chaos_trials.api.domain.model.rsa_key.RSAKey;
import com.chaos_trials.api.domain.repository.account.AccountRepository;
import com.chaos_trials.api.domain.repository.rsa_key.RSAKeyRepository;
import com.chaos_trials.api.util.jwt.JwtUtil;
import com.chaos_trials.api.util.rsa.RSAUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.util.Optional;

@Component
public class DecryptInterceptor implements HandlerInterceptor {

    private final AccountRepository accountRepository;
    private final RSAKeyRepository keyRepository;
    private final JwtUtil jwtUtils;

    public DecryptInterceptor(AccountRepository accountRepository,
                              RSAKeyRepository keyRepository,
                              JwtUtil jwtUtils) {
        this.accountRepository = accountRepository;
        this.keyRepository = keyRepository;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String encryptedData = extractEncryptedData(request);
        System.out.println("Entrou aq no interceptor");
        if(request.getRequestURI().startsWith("/auth/")) {
            if (encryptedData != null) {
                String username = jwtUtils.getEmailFromToken(request);

                Optional<Account> accountOptional = accountRepository.findFirstByEmailOrUsername(username);

                if (accountOptional.isPresent()) {
                    Account account = accountOptional.get();

                    Optional<RSAKey> keyOptional = keyRepository.findById(account.getUuid());

                    if (keyOptional.isPresent()) {
                        RSAKey key = keyOptional.get();
                        String decryptedData = RSAUtil.decrypt(encryptedData, key.getPrivateKey());

                        request.setAttribute("decryptedData", decryptedData);
                    } else {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Chave privada não encontrada para a conta.");
                        return false;
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Conta não encontrada.");
                    return false;
                }
            }
        }
        return true;
    }

    private String extractEncryptedData(HttpServletRequest request) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        String body = stringBuilder.toString();

        JsonNode jsonNode = new ObjectMapper().readTree(body);
        return jsonNode.get("data").asText();
    }
}

