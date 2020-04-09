package fr.quidquid.micronaut.intercept_issue;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
@Intercept
public class Endpoint extends EndpointSuperClass {

    @Get("/a")
    @Produces(value = MediaType.TEXT_PLAIN)
    public MutableHttpResponse<String> a() {
        return HttpResponse.ok("Hi");
    }

    @Get("/b")
    @Produces(value = MediaType.TEXT_PLAIN)
    public MutableHttpResponse<Object> b() {
        return send("Hi");
    }

}
