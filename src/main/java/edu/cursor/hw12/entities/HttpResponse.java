package edu.cursor.hw12.entities;

import lombok.Data;

@Data
public class HttpResponse {
    private final String code;
    private final String message;
    private final boolean isError;
}
