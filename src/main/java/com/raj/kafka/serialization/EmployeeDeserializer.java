/**
 * 
 */
package com.raj.kafka.serialization;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.apache.kafka.common.serialization.Deserializer;

import com.raj.kafka.exception.SerialazationException;
import com.raj.kafka.model.Employee;

/**
 * @author Rajendar
 *
 */
public class EmployeeDeserializer implements Deserializer<Employee> {

	private String encoding = "UTF8";
	SimpleDateFormat parserSDF=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.getDefault());
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

		if(Objects.nonNull(configs)) {
			String propName = isKey ?"key.serializer.encoding" : "value.serializer.encoding";
			Object encodingValue = configs.get(propName);
			if (encodingValue == null)
				encodingValue = configs.get("serializer.encoding");
			if (encodingValue instanceof String)
				encoding = (String) encodingValue;
		}

	}

	@Override
	public Employee deserialize(String topic, byte[] data) {

		if(Objects.isNull(data))
			return null;

		ByteBuffer buffer = ByteBuffer.wrap(data);
		int id = buffer.getInt();
		int nameLenght = buffer.getInt();
		byte nameBytes[] = new byte[nameLenght];
		buffer.get(nameBytes);

		try {
			String empName = new String(nameBytes, encoding);
			int dateLenght = buffer.getInt();
			byte dateBytes[] = new byte[dateLenght];
			buffer.get(dateBytes);
			String strDob = new String(dateBytes, encoding);
			Date dob = parserSDF.parse(strDob);
			return new Employee(id, empName, dob);
		} catch (UnsupportedEncodingException | ParseException e) {
			throw new SerialazationException(e);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
