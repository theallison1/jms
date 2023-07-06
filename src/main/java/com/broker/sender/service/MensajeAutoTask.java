package com.broker.sender.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jms.core.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

@EnableScheduling
@Service
public class MensajeAutoTask {

    @Autowired
    private JmsTemplate jmsTemplate;
    Logger LOG = org.slf4j.LoggerFactory.getLogger(MensajeAutoTask.class);

    @Scheduled(fixedRate = 5000)
    private void enviarMensaje(){
    	
        jmsTemplate.convertAndSend("mensaje", "hola");
        LOG.info("Mensaje enviado ");
    }
}