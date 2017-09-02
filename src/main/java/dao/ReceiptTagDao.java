package dao;

import api.ReceiptResponse;
import generated.tables.records.ReceiptTagsRecord;
import generated.tables.records.ReceiptsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Delete;
import org.jooq.Row;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.RECEIPTS;
import static generated.Tables.RECEIPT_TAGS;
import static java.util.stream.Collectors.toList;

public class ReceiptTagDao {
    DSLContext dsl;

    public ReceiptTagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public boolean receiptExists(int _receiptID){
        List<ReceiptsRecord> receiptFromID = dsl
                .select()
                .from(RECEIPTS)
                .where(RECEIPTS.ID.eq(_receiptID))
                .fetchInto(ReceiptsRecord.class);

        List<ReceiptResponse> receiptRecord = receiptFromID.stream().map(ReceiptResponse::new).collect(toList());
        boolean exists = false;
        if (receiptRecord.size() == 1){
            exists = true;
        }
        return exists;
    }

    public boolean receiptTagExists(String _tagName, int _receiptID){
        List<ReceiptsRecord> receiptFromTagAndID = dsl
                .select()
                .from(RECEIPTS
                        .join(RECEIPT_TAGS)
                        .on(RECEIPTS.ID.eq(RECEIPT_TAGS.RECEIPT_ID)))
                .where(RECEIPT_TAGS.TAG.eq(_tagName)
                        .and(RECEIPT_TAGS.RECEIPT_ID.eq(_receiptID)))
                .fetchInto(ReceiptsRecord.class);

        List<ReceiptResponse> receiptRecord = receiptFromTagAndID.stream().map(ReceiptResponse::new).collect(toList());
        boolean exists = false;
        if (receiptRecord.size() == 1){
            exists = true;
        }
        return exists;
    }

    public void insertTag(String _tagName, int _receiptID){
        ReceiptTagsRecord receiptTagsRecord = dsl
                .insertInto(RECEIPT_TAGS, RECEIPT_TAGS.TAG, RECEIPT_TAGS.RECEIPT_ID)
                .values(_tagName, _receiptID)
                .returning(RECEIPT_TAGS.ID)
                .fetchOne();
    }

    public void deleteTag(String _tagName, int _receiptID){
        ReceiptTagsRecord receiptTagsRecord = dsl
                .delete(RECEIPT_TAGS)
                .where(RECEIPT_TAGS.TAG.eq(_tagName).and(RECEIPT_TAGS.RECEIPT_ID.eq(_receiptID)))
                .returning(RECEIPT_TAGS.ID)
                .fetchOne();
    }

    public List<ReceiptsRecord> getAllReceiptsByTag(String _tagName){
        return dsl
                .select()
                .from(RECEIPTS
                .join(RECEIPT_TAGS)
                .on(RECEIPTS.ID.eq(RECEIPT_TAGS.RECEIPT_ID)))
                .where(RECEIPT_TAGS.TAG.eq(_tagName))
                .orderBy(RECEIPT_TAGS.RECEIPT_ID)
                .fetchInto(ReceiptsRecord.class);
    }
}
