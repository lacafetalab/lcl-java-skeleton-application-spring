package pe.lacafetalab.pao.shared.utils;

import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class CSVUtils {

	public static CsvSchema buildCsvSchema(String headers, String separator, boolean strictHeaders) {
		CsvSchema.Builder schemaBuilder = CsvSchema.builder();
		List.of(headers.split(separator)).stream().forEach(schemaBuilder::addColumn);
		CsvSchema schema = schemaBuilder.setUseHeader(true).build();
		schema = schema.withStrictHeaders(strictHeaders);
		return schema;
	}

}
