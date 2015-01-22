package alvion.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Toshiba on 19.01.2015.
 */
public class App {

    public static void main(String[] args) throws IOException {

        Set<String> strings = new HashSet<>();
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


        Search search = new Search();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str  = reader.readLine();

        Set<String> result;
        result = search.search(str, strings);

        System.out.println(result);
    }
}
