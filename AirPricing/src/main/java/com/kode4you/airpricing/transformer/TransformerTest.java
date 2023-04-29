package com.kode4you.airpricing.transformer;

import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class TransformerTest extends AbstractTransformer {

    @Override
    protected Object doTransform(Message<?> message) {
        return null;
    }
}
