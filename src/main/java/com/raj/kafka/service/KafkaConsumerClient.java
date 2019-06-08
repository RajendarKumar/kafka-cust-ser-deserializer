/**
 * 
 */
package com.raj.kafka.service;

import java.util.Collections;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.utils.PropLoader;

/**
 * @author Rajendar
 *
 */
public class KafkaConsumerClient<K, V> implements IKafkaClient<Consumer<K, V>>{

	private final String propertyFileName;
	private final String topic;
	
	public KafkaConsumerClient(String propertyFileName, String topic) {
		this.propertyFileName = propertyFileName;
		this.topic = topic;
	}


	@Override
	public Consumer<K, V> getClient() {
		Consumer<K, V> consumer = new KafkaConsumer<>(PropLoader.loadProperties(propertyFileName));
		consumer.subscribe(Collections.singletonList(topic));
		return consumer;
	}
}
