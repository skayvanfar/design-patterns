package BasePatterns.ServiceStubOrMockObject;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Service Stub
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/20/2017.
 */
public class TestTaxService implements TaxService {

    private static Set exemptions = new HashSet();

    public TaxInfo getSalesTaxInfo(String productCode, Address addr, Money saleAmount) {
        BigDecimal rate = getRate(productCode, addr);
        return new TaxInfo(rate, saleAmount.multiply(rate));
    }

    public static void addExemption(String productCode, String stateCode) {
        exemptions.add(getExemptionKey(productCode, stateCode));
    }

    private static Object getExemptionKey(String productCode, Object stateCode) {
        return null;
    }

    public static void reset() {
        exemptions.clear();
    }

    private static BigDecimal getRate(String productCode, Address addr) {
        if (exemptions.contains(getExemptionKey(productCode, addr.getStateCode()))) {
            return EXEMPT_RATE;
        } else {
            return FLAT_RATE;
        }
    }
}
