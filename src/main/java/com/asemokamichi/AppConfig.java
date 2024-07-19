package com.asemokamichi;

import com.asemokamichi.exception.GoodsExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("com.asemokamichi");
        register(GoodsExceptionMapper.class);
    }


}
