package api;

import dao.ReceiptTagDao;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class NewTests {

    @Test
    public void daoCallTest(){

        ReceiptTagDao mockedDao = mock(ReceiptTagDao.class);

        mockedDao.receiptTagExists("red", 1);
        mockedDao.receiptExists(3);
        mockedDao.insertTag("blue", 2);
        mockedDao.deleteTag("orange", 1);
        mockedDao.getAllReceiptsByTag("blue");


        verify(mockedDao).receiptTagExists("red", 1);
        verify(mockedDao).receiptExists(3);
        verify(mockedDao).insertTag("blue", 2);
        verify(mockedDao).deleteTag("orange",1);
        verify(mockedDao).getAllReceiptsByTag("blue");
    }

}
