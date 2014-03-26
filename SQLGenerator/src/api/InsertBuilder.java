package api;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder for building SQL insert statements.
 * 
 * @author TsvetanSpasov
 */
public class InsertBuilder {

	private String table;
	private List<String> columns = new ArrayList<String>();
	private List<String> values = new ArrayList<String>();

	/**
	 * Constructor.
	 * 
	 * @param table
	 *            Name of the table into which we'll be inserting.
	 */
	public InsertBuilder(String table) {
		this.table = table;
	}

	/**
	 * Inserts a column name, value pair into the SQL.
	 * 
	 * @param column
	 *            Name of the table column.
	 * @param value
	 * */
	public InsertBuilder set(String column, String value) {
		columns.add(column);
		values.add(value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(table)
				.append(" (");
		appendList(sql, columns, "", ", ");
		sql.append(") VALUES (");
		appendList(sql, values, "", ", ");
		sql.append(")");
		return sql.toString();
	}

	private static void appendList(StringBuilder sql, List<?> list, String init,
			String sep) {

		boolean first = true;

		for (Object s : list) {
			if (first) {
				sql.append(init);
			} else {
				sql.append(sep);
			}
			sql.append(s);
			first = false;
		}
	}
}
