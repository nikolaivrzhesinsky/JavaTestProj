package com.objects;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.objects")
@PropertySource("music.properties")

public class SpringConfig {

}
