package alvion.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SearchTest {

    private Search search;
    private  Set<String> strings;

    @Before
    public void setUp() throws Exception {
        search = new Search();

        strings = new HashSet<>();
        strings.add("AccountantController.js");
        strings.add("AccountantListController.js");
        strings.add("ActivateCompanyController.js");
        strings.add("AddCompanyController.js");
        strings.add("AddParticipantController.js");
        strings.add("BeneficiaryModalController.js");
        strings.add("CalculationDiffController.js");
        strings.add("ChangesController.js");
        strings.add("CompanyController.js");
        strings.add("CompanyListController.js");
        strings.add("ConfirmController.js");
        strings.add("CreditBalanceController.js");
        strings.add("ExportParticipantController.js");
        strings.add("InvoiceController.js");
        strings.add("InvoiceListController.js");
        strings.add("IrpjCodeController.js");
        strings.add("ItemController.js");
        strings.add("ItemDescriptionsController.js");
        strings.add("ItemLeaderConfirmation.js");
        strings.add("ItemListController.js");
        strings.add("MainController.js");
        strings.add("NationalSimpleSelectionController.js");
        strings.add("ParticipantController.js");
        strings.add("ParticipantListController.js");
        strings.add("ReferenceController.js");
        strings.add("SelectParticipantController.js");
        strings.add("TitleController.js");
        strings.add("TurboCodesModalController.js");
    }

    @Test
    public void testSearch() throws Exception {
        Set<String> result;

        result = search.search("IC", strings);
        assertEquals(7, result.size());

        result = search.search("cipantCon", strings);
        assertEquals(5, result.size());

        result = search.search("InC", strings);
        assertEquals(2, result.size());

        result = search.search("item", strings);
        assertEquals(4, result.size());

        result = search.search("itemdes", strings);
        assertEquals(1, result.size());

        result = search.search("Com", strings);
        assertEquals(4, result.size());

        result = search.search("zaxcv", strings);
        assertEquals(0, result.size());
    }
}