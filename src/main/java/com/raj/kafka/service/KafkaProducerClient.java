/**
 * 
 */
package com.raj.kafka.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.utils.PropLoader;

/**
 * @author Rajendar
 *
 */
public class KafkaProducerClient<K, V> implements IKafkaClient<Producer<K, V>>{

	private final String propertyFileName;
	
	public KafkaProducerClient(String propertyFileName) {
		this.propertyFileName=propertyFileName;
	}
	

	@Override
	public Producer<K, V> getClient() {
        return new KafkaProducer<>(PropLoader.loadProperties(propertyFileName));
	}
}
