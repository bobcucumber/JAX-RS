package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.container.*;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

@Provider
@PreMatching
public class RedirectDefaultFilter implements ContainerRequestFilter, ContainerResponseFilter {

//        @Context HttpServletRequest httpServletRequest;
//    @Context HttpServletResponse httpServletResponse;

    @Override
    public void filter(ContainerRequestContext reqContext) throws IOException {
        // when new api is good, do not redirect to default one (old api implementation)

        System.out.println("Request Filter path1=" + reqContext.getUriInfo().getPath());

        if (shouldRedirect(reqContext)) {
//            reqContext.setRequestUri(URI.create("/messenger/webapi/injectdemo/redirect"));
            reqContext.setRequestUri(URI.create("/messenger/webapi/injectdemo2/default"));
//            reqContext.setRequestUri(URI.create("/injectdemo2/default"));
//            System.out.println("path2=" + reqContext.getUriInfo().getPath());

            // redirect one endpoint doing nothing


        }
        System.out.println("Request Filter path2=" + reqContext.getUriInfo().getPath());

    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext,
                       ContainerResponseContext containerResponseContext) throws IOException {

        System.out.println("Response Filter path1=" + containerRequestContext.getUriInfo().getPath());

        if (shouldRedirect(containerRequestContext)) {
//            reqContext.setRequestUri(URI.create("/messenger/webapi/injectdemo/redirect"));
//            System.out.println("path2=" + reqContext.getUriInfo().getPath());

            // default voting api (old api implementation)
        	doPost(containerRequestContext, containerResponseContext);

        }
        System.out.println("Response Filter entity=" + containerResponseContext.getEntity());
        
        containerResponseContext.getHeaders().add("testHeader", "Header");

    }


    protected void doPost(ContainerRequestContext containerRequestContext,
            ContainerResponseContext containerResponseContext) {
        System.out.println("In old doPost");
        System.out.println("containerResponseContext.getEntity()=" + containerResponseContext.getEntity());
//        System.out.println("httpServletResponse.getStatus()=" + httpServletResponse.getStatus());
        containerResponseContext.setEntity("return from doPost2");
        containerResponseContext.setStatus(201);
//        System.out.println("httpServletResponse.getStatus2()=" + httpServletResponse.getStatus());
//        httpServletResponse.setStatus(203);
        System.out.println("containerResponseContext.getStatus()=" + containerResponseContext.getStatus());

    }

    private boolean shouldRedirect(ContainerRequestContext reqContext) {
        return true;

//        UriInfo uriInfo = reqContext.getUriInfo();
//        String path = uriInfo.getPath();
//        System.out.println("path=" + path);
//        if (path.equalsIgnoreCase("injectdemo/context")) {
//            return true;
//        }
//        return false;
    }
}
