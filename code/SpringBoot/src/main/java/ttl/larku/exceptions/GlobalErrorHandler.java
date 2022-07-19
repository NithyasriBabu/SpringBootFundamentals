package ttl.larku.exceptions;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import ttl.larku.controllers.rest.RestResultGeneric;

/**
 * @author whynot
 */
@RestControllerAdvice
public class GlobalErrorHandler {


    /**
     * Handle BadRequest (400) errors.
     *
     * From ResponseEntityExceptionHandler::handleExceptions, there are the
     * exceptions that result from 400 Bad Request status codes.  We are
     * trapping them all here just for fun.  We could handle them
     * separately here, or override the corresponding methods in
     * LastStopHandler
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class,
            ServletRequestBindingException.class, TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            MissingServletRequestPartException.class,
            BindException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected RestResultGeneric<?> handleBadRequestException(Exception ex, WebRequest request) {
        RestResultGeneric<?> rr = RestResultGeneric.ofError("Unexpected Exception: " + ex);

        return rr;
    }
}