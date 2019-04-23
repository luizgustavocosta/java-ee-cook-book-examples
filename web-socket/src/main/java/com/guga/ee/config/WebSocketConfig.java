package com.guga.ee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Creates the in-memory message broker with one or more destinations for sending and receiving messages.
     * In this example, there are two destination prefixes defined: topic and queue.
     * They follow the convention that destinations for messages to be carried on to all subscribed clients via
     * the pub-sub model should be prefixed with topic.
     * On the other hand, destinations for private messages are typically prefixed by queue.
     *
     * Defines the prefix app that is used to filter destinations handled by methods annotated with @MessageMapping
     * which you will implement in a controller. The controller, after processing the message, will send it to the broker.
     *
     * @param config MessageBrokerRegistry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Configure Spring to enable WebSocket and STOMP messaging
     * STOMP - Simple Text Oriented Message Protocol
     *
     * @param registry StompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
        // For your domain
        //registry.addEndpoint("/anyEndPoint").setAllowedOrigins("domain.com").withSockJS();
    }

}
