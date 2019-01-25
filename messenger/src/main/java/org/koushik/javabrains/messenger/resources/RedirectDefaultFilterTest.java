package org.koushik.javabrains.messenger.resources;


import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.internal.ModelProcessorUtil.Method;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.mockito.*;

public class RedirectDefaultFilterTest extends JerseyTest {

    @Mock
    private ResourceInfo resourceInfo;
    
    @Override
    protected Application configure() {
//        return new ResourceConfig(RedirectDefaultFilter.class);
        return new ResourceConfig(RedirectDefaultFilter.class, DefaultResource.class);
    }

    @Test
    public void ordersPathParamTest() {
    	   
        System.out.println("test_response0=");
        WebTarget target = target("injectdemo/context");
//        WebTarget target = target("");
        URI uri = target.getUri();
        System.out.println("uri.getPath()=" + uri.getPath());
        
        Builder request = target.request();

//        String response = target.request().get(String.class);
        Response response = target.request().get(Response.class);
        
        System.out.println("test_response=" + response);
        System.out.println("test_response_getHeaders=" + response.getHeaders());
        System.out.println("test_response_getHeaders2=" + response.getHeaderString("TestHeader"));
        System.out.println("test_response_entity=" + response.getEntity());
        String readEntity = response.readEntity(String.class);
        System.out.println("test_response_Read_entity=" + readEntity);
//        assertThat(readEntity, is("return from doPost2"));
        assertEquals(readEntity, "return from doPost2");
        
    }

}
