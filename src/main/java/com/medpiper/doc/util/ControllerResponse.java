package com.medpiper.doc.util;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@lombok.ToString
@lombok.Setter
@lombok.Getter
public class ControllerResponse<T> {

    private boolean isSuccess = true;

    private int statusCode = Constants.ERROR_CODE_SUCCESS;

    private String errorMessage;

    private String message;



    private List<String> errorMessages = new ArrayList<>();

    private T data;

    public ControllerResponse() {
    }

    public ControllerResponse(T data) {
        this.data = data;
    }

    public ControllerResponse(T data, boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public ControllerResponse(List<String> errorMessages) {
        this.errorMessages = errorMessages;
        this.isSuccess = false;
    }

    public ControllerResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ControllerResponse(boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }

    public void addErrorMessage(String errorMessage) {
        if (!this.errorMessages.contains(errorMessage)) {
            this.errorMessages.add(errorMessage);
        }
    }
}
