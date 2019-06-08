package com.raj.kafka;

import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.raj.kafka.constants.IKafkaConstant;
import com.raj.kafka.constants.IKafkaConstant.IProducer;
import com.raj.kafka.model.Employee;

/**
 * 
 * @author Rajendar
 *
 */
public class KafkaMsgProducer implements Runnable{

	private Producer<String, Employee> producer;
	public KafkaMsgProducer(Producer<String, Employee> producer) {
		this.producer =producer;
	}
	@Override
	public void run() {
		for (int index = 0; index < IKafkaConstant.IProducer.MESSAGE_COUNT; index++) {
			ProducerRecord<String, Employee> record = new ProducerRecord<String, Employee>(IProducer.TOPIC_NAME,  new Employee(index, "This is record No. : " + index, new Date()));
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
				+ " with offset " + metadata.offset());
			} 
			catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} 
			catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}
