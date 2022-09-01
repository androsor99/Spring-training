package com.androsor.spring.listener.entity;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * The {@code EntityEvent}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createDate 31.08.2022 12:15
 */

public class EntityEvent extends ApplicationEvent {

    @Getter
    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }
}
