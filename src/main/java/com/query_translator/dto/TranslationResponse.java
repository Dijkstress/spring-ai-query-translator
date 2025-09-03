package com.query_translator.dto;

public class TranslationResponse {
    private String dialect;
    private String query;
    private String explanation;

    public TranslationResponse() {}

    public TranslationResponse(String dialect, String query, String explanation) {
        this.dialect = dialect;
        this.query = query;
        this.explanation = explanation;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
