package com.raj.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Producer;

import com.raj.kafka.api.IKafkaClient;
import com.raj.kafka.constants.IKafkaConstant.IConsumer;
import com.raj.kafka.model.Employee;
import com.raj.kafka.service.KafkaConsumerClient;
import com.raj.kafka.service.KafkaProducerClient;

public class MainApp {

	public static void main(String[] args) {

		IKafkaClient<Producer<String,Employee>> kafkaProducerClient = new
				KafkaProducerClient<String,Employee>("producer-config");

		Producer<String, Employee> client = kafkaProducerClient.getClient();

		KafkaMsgProducer kafkaMsgProducer = new KafkaMsgProducer(client); new
		Thread(kafkaMsgProducer).start();

		IKafkaClient<Consumer<String,Employee>> kafkaConsumerClient = new KafkaConsumerClient<String,Employee>("consumer-config",IConsumer.TOPIC_NAME);
		Consumer<String,Employee> consumer = kafkaConsumerClient.getClient();
		KafkaMsgConsumer kafkaMsgConsumer = new KafkaMsgConsumer(consumer);

		new Thread(kafkaMsgConsumer).start();
 
	}

}
