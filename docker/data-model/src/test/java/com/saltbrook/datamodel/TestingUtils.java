package com.saltbrook.datamodel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestingUtils {
	
	private static final int GIS_SRID = 4326;
	
	private static GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING),
			GIS_SRID);
	
	private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	public static ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		JtsModule jtsModule = new JtsModule(getGeometryFactory());
		objectMapper.registerModule(jtsModule);
		
		return objectMapper;
	}
	
	public static Point createPoint(double x, double y) {
		return geometryFactory.createPoint(new Coordinate(x, y));
	}
	
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date, dateFormatter);
	}
	
	private static GeometryFactory getGeometryFactory() {
		return geometryFactory;
	}
	
}
