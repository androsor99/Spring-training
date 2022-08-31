package com.androsor.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * The {@code EntityListener}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 12:22
 */
@Component
public class EntityListener {

    @EventListener
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.println("Entity: " + entityEvent);
    }
}
