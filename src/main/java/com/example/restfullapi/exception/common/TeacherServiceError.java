package com.example.restfullapi.exception.common;

public enum TeacherServiceError {

    TEACHER_NOT_FOUND(404,"TEACHER NOT FOUND");

    private TeacherServiceError(int errorCode, String errMessage){
        this.errorCode = errorCode;
        this.errorMessage = errMessage;
    }

    private final int errorCode;
    private final String errorMessage;

    public int getErrorCode() { return errorCode; }

    public String getErrorMessage() { return errorMessage; }

}
