package com.kode4you.airpricing.transformer;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TransformerTest extends AbstractTransformer {

    @Override
    protected Object doTransform(Message<?> message) {
        return MessageBuilder.withPayload(message.getPayload())
                .copyHeaders(message.getHeaders())
                .build();
    }
}
