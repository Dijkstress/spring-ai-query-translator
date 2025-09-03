package com.query_translator.controller;

import com.query_translator.dto.TranslationRequest;
import com.query_translator.service.TranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/translate")
@CrossOrigin(origins = "*")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @PostMapping
    public ResponseEntity<String> getTranslation(@RequestBody TranslationRequest translationRequest) {
        String response = translationService.translate(
                translationRequest.getDialect(),
                translationRequest.getInstruction()
        );
        return ResponseEntity.ok(response);
    }
}
