package api;

import objects.Consumption;

import java.lang.reflect.Field;

/**
 * 
 * @author TsvetanSpasov
 * @version 1.0
 * 
 */

public class CreateBuilder {

	public static final String NOT_NULL = "NOT NULL";
	public static final String UNIQUE = "UNIQUE";
	public static final String PRIMARY_KEY = "PRIMARY KEY";

	public CreateBuilder() {
	}

	public String createSQLQuery(String[] data) {
		StringBuilder createQuery = new StringBuilder();
		if (data[0] == null) {
			return null;
		} else {
			// first drop the table if exists
			createQuery.append("DROP TABLE " + data[0] + "; \n");

			// than create the table
			createQuery.append("CREATE TABLE " + data[0] + "(\n");
			createQuery.append("ID INT NOT NULL IDENTITY(1, 1),\n");
		}
		String sep = ":";
		String[] columns;
		int index = 1;

		while (index != data.length) {
			columns = data[index].split(sep);
			createQuery.append(columns[0]);
			createQuery.append(" ");
			createQuery.append(columns[1]);
			createQuery.append(", \n");
			index++;
		}
		createQuery.append(PRIMARY_KEY + "( ID )");
		createQuery.append("\n");
		createQuery.append(");");

		return createQuery.toString();
	}

	public static void main(String[] args) {
		CreateBuilder c = new CreateBuilder();
		System.out.println(c.createSQLQuery(args));

		System.out.println();

		Consumption example = new Consumption("ABSC", true, 123);
		InsertBuilder insertConstumption = new InsertBuilder(example.getClass()
				.getSimpleName());
		Field[] fields = example.getClass().getDeclaredFields();

		insertConstumption.set(fields[0].getName(), example.getDeviceID());
		insertConstumption.set(fields[1].getName(), example.isCarbonNeutral());
		insertConstumption.set(fields[2].getName(),
				Float.toString(example.getValue()));
		System.out.println(insertConstumption.toString());

	}
}
