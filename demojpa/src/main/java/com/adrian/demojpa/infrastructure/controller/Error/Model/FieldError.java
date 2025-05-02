package com.adrian.demojpa.infrastructure.controller.Error.Model;


public class FieldError {
    private String field;
    private String error;

    public FieldError(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getError() {
        return error;
    }

    public void setMessage(String error) {
        this.error = error;
    }
}
