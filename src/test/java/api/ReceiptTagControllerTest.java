package api;

import controllers.ReceiptTagController;
import dao.ReceiptTagDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReceiptTagControllerTest {

    @Test
    public void getReceiptsByTagTest(){
        ReceiptTagDao mockedDao = mock(ReceiptTagDao.class);
        ReceiptTagController receiptTagController = new ReceiptTagController(mockedDao);


        List<ReceiptResponse> receiptResponses = new ArrayList<>();
        Assert.assertEquals(receiptResponses, receiptTagController.getReceiptsByTag("test"));
    }
}
