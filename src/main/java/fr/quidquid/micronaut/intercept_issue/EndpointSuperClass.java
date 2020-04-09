package fr.quidquid.micronaut.intercept_issue;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;


@Singleton
public class EndpointSuperClass {

    // *****************************************
    // GOOD PATH HANDLERS

    public MutableHttpResponse<Object> send(String to_send) {
        return send(to_send, 200);
    }

    public MutableHttpResponse<Object> send(String to_send, int status) {
        return HttpResponse
                .status(HttpStatus.valueOf(status))
                .body(to_send);
    }

    @Error
    public MutableHttpResponse<Object> handle_error(Exception e) {
        return send(e.getMessage(), 500);
    }


}
