package fr.izy.moonapi.events;

/**
 * @author iZy
 * @version 1.0
 * @since 1.0
 *
 * This enumeration is a list of all existing priorities for an event.
 */
public enum ListenerPriority {

    /**
     * Theses following priorities are executed in the same order as they are declared.
     */
    HIGHEST, HIGH, NORMAL, LOW, LOWEST;
}
