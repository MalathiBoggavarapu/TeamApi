package com.tempo.teamapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NoDataFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNoRecordFoundException(ex: NoDataFoundException?): ErrorResponse {
        val errorResponse = ErrorResponse()
        errorResponse.message = "No Record Found"
        return errorResponse
    }

    @ExceptionHandler(BadRequestException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBadRequestException(ex: BadRequestException?): ErrorResponse {
        val errorResponse = ErrorResponse()
        errorResponse.message = "Bad request"
        return errorResponse
    }

    @ExceptionHandler(InternalServerError::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleNoRecordFoundException(ex: InternalServerError?): ErrorResponse {
        val errorResponse = ErrorResponse()
        errorResponse.message = "Failed to process the request"
        return errorResponse
    }
}