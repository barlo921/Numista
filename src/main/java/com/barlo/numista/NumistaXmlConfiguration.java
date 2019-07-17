package com.barlo.numista;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring/spring-db.xml", "classpath:/spring/spring-app.xml"})
public class NumistaXmlConfiguration {
}
