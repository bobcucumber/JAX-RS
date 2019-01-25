package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.container.*;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

@Provider
@PreMatching
//public class RedirectFilter implements ContainerRequestFilter {
public class RedirectFilter {

//    @Override
//    public void filter(ContainerRequestContext reqContext) throws IOException {
//
//        // redirect conditionally
//    	System.out.println("path1=" + reqContext.getUriInfo().getPath());
//
//        if (shouldRedirect(reqContext)) {
////            reqContext.setRequestUri(URI.create("injectdemo/redirect"));
////            reqContext.setRequestUri(URI.create("/webapi/injectdemo/context"));
//            reqContext.setRequestUri(URI.create("/messenger/webapi/injectdemo/redirect"));
//        	System.out.println("path2=" + reqContext.getUriInfo().getPath());
//        }
//    	System.out.println("path3=" + reqContext.getUriInfo().getPath());
//
//    }

    private boolean shouldRedirect(ContainerRequestContext reqContext) {
        //todo it should be conditional return
    	UriInfo uriInfo = reqContext.getUriInfo();
    	String path = uriInfo.getPath();
    	System.out.println("path=" + path);
    	if (path.equalsIgnoreCase("injectdemo/context")) {
    		return true;
    	}
        return false;
    }
}
