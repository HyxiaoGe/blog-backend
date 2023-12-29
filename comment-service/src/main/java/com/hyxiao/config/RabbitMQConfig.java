package com.hyxiao.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String COMMENT_EXCHANGE = "comment-exchange";  // 交换机名称
    public static final String COMMENT_QUEUE = "comment-queue";  // 队列名称
    public static final String COMMENT_KEY = "comment-key";  // routingKey

    //  定义一个队列，名称为comment-queue, durable为true, 表示持久化, RabbitMQ重启后队列仍然存在
    @Bean(COMMENT_QUEUE)
    public Queue queue() {
        return QueueBuilder.durable(COMMENT_QUEUE).build();
    }

    @Bean(COMMENT_EXCHANGE)
    public TopicExchange commentExchange() {
        // 定义一个Topic类型的交换机，名称为comment-exchange
        // 交换机的作用是接收消息并且转发到绑定的队列，交换机不存储消息，在启动时创建，重启后仍然存在
        // 交换机的类型有direct, topic, headers, fanout四种
        // direct: 通过routingKey完全匹配的消息才会被转发到绑定的队列
        // topic: 通过routingKey模糊匹配的消息才会被转发到绑定的队列
        // headers: 通过headers匹配的消息才会被转发到绑定的队列
        // fanout: 不需要routingKey, 所有消息都会被转发到绑定的队列
        return ExchangeBuilder.directExchange(COMMENT_EXCHANGE).durable(true).build();
    }

    // 创建绑定关系
    @Bean
    public Binding commentBinding(@Qualifier(COMMENT_QUEUE) Queue queue, @Qualifier(COMMENT_EXCHANGE) Exchange exchange) {
        // 定义一个绑定，将comment-queue队列绑定到comment-exchange交换机上，routingKey为comment-key
        // 交换机根据routingKey的类型将消息转发到绑定的队列
        return BindingBuilder.bind(queue).to(exchange).with(COMMENT_KEY).noargs();
    }

}
