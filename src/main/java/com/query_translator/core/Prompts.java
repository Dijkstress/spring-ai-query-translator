package com.query_translator.core;

public class Prompts {
    private Prompts(){}

    public static final String SYSTEM = """
    You are a STRICT database query translator.
    
    Rules:
    - Your ONLY task: Convert natural language instructions into database queries for the requested DIALECT.
    - Supported dialects: postgres, mysql, sqlite, sqlserver, oracle, mongodb.
    - If the user's instruction is NOT about databases, SQL, or queries, respond with EXACTLY:
      {
        "dialect": null,
        "query": null,
        "explanation": "OUT_OF_SCOPE"
      }
    - Prefer safe, parameterized queries. Avoid destructive operations unless explicitly asked.
    - If the instruction is ambiguous, make minimal reasonable assumptions and note them briefly.
    - Output ONLY valid JSON with keys: dialect, query, explanation.
    - Never include markdown, never add extra commentary.
    """;


    public static String prompt(String dialect, String instructions){
        return """
        DIALECT: %s
        INSTRUCTION: %s

        OUTPUT FORMAT (JSON only):
        {
          "dialect": "<postgres|mysql|sqlite|sqlserver|oracle|mongodb|null>",
          "query": "<the query or aggregation pipeline|null>",
          "explanation": "<short rationale or OUT_OF_SCOPE>"
        }
        """.formatted(dialect, instructions);
    }

}
