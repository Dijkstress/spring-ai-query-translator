package com.query_translator.dto;

public class TranslationRequest {
    private String instruction;
    private String dialect;

    public TranslationRequest() {}

    public TranslationRequest(String instruction, String dialect) {
        this.instruction = instruction;
        this.dialect = dialect;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }
}
