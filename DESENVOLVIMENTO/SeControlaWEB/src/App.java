import endpoint.ConectadoEndPoint;
import endpoint.HelloWorldEndPoint;
import endpoint.UsuarioEndpoint;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/")
//The java class declares root resource and provider classes
public class App extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(ConectadoEndPoint.class);
        h.add(HelloWorldEndPoint.class );
        h.add(UsuarioEndpoint.class);
        return h;
    }

}

