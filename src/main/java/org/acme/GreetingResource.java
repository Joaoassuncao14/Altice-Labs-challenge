package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


@Path("/labseq")
public class GreetingResource {
private Map<BigInteger, BigInteger> memorize = new HashMap<>();
    
    @GET
    @Path("/{value}")
    public BigInteger getValue(@PathParam("value") BigInteger value) {
        return calculeSequence(value);
    }
    
    public BigInteger calculeSequence (BigInteger n ){
        if(memorize.containsKey(n)){
            return memorize.get(n);
        }
        BigInteger result;
        if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.valueOf(2))){
            result = BigInteger.ZERO;
        } else if(n.equals(BigInteger.ONE) || n.equals(BigInteger.valueOf(3))){
            result = BigInteger.ONE;
        } else {
            result = calculeSequence(n.subtract(BigInteger.valueOf(4)))
                .add(calculeSequence(n.subtract(BigInteger.valueOf(3))));
        }
        memorize.put(n, result);
        return result;
    } 
}
