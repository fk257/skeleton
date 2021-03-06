/**
 * This class is generated by jOOQ
 */
package generated.tables.records;


import generated.tables.ReceiptTags;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReceiptTagsRecord extends TableRecordImpl<ReceiptTagsRecord> implements Record3<Integer, String, Integer> {

	private static final long serialVersionUID = 687802760;

	/**
	 * Setter for <code>public.receipt_tags.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.receipt_tags.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.receipt_tags.tag</code>.
	 */
	public void setTag(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.receipt_tags.tag</code>.
	 */
	public String getTag() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.receipt_tags.receipt_id</code>.
	 */
	public void setReceiptId(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.receipt_tags.receipt_id</code>.
	 */
	public Integer getReceiptId() {
		return (Integer) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, String, Integer> fieldsRow() {
		return (Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row3<Integer, String, Integer> valuesRow() {
		return (Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return ReceiptTags.RECEIPT_TAGS.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return ReceiptTags.RECEIPT_TAGS.TAG;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return ReceiptTags.RECEIPT_TAGS.RECEIPT_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getTag();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getReceiptId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReceiptTagsRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReceiptTagsRecord value2(String value) {
		setTag(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReceiptTagsRecord value3(Integer value) {
		setReceiptId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ReceiptTagsRecord values(Integer value1, String value2, Integer value3) {
		value1(value1);
		value2(value2);
		value3(value3);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ReceiptTagsRecord
	 */
	public ReceiptTagsRecord() {
		super(ReceiptTags.RECEIPT_TAGS);
	}

	/**
	 * Create a detached, initialised ReceiptTagsRecord
	 */
	public ReceiptTagsRecord(Integer id, String tag, Integer receiptId) {
		super(ReceiptTags.RECEIPT_TAGS);

		setValue(0, id);
		setValue(1, tag);
		setValue(2, receiptId);
	}
}
