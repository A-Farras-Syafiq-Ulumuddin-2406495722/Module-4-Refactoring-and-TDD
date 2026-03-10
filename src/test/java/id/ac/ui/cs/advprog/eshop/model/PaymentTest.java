package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private List<Product> products;
    private Order order;

    @BeforeEach
    void setup() {
        this.products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4837-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);

        this.order = new Order("13652556-0128-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
    }

    @Test
    void testCreatePaymentEmptyArg() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment(null, "", null, null);
        });
    }

    @Test
    void testCreatePaymentDefault() {
        Map<String, String> data = new HashMap<>();
        data.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("PAY-001", "VOUCHER", "PENDING", data);

        assertEquals("PAY-001", payment.id);
        assertEquals("VOUCHER", payment.method);
        assertEquals("PENDING", payment.status);
    }

    @Test
    void testCreatePaymentInvalidMethod() {
        Payment payment = new Payment("PAY-002", "INVALID_TYPE", "PENDING", new HashMap<>());

        assertThrows(IllegalArgumentException.class, () -> {
            payment.checkMethod("INVALID_TYPE");
        });
    }

    @Test
    void testCreatePaymentByVoucherSuccess() {
        Map<String, String> data = new HashMap<>();
        data.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("PAY-003", "VOUCHER", "PENDING", data);
        payment.setStatus("SUCCESS", data);

        assertEquals("SUCCESS", payment.status);
    }

    @Test
    void testCreatePaymentByVoucherRejected() {
        Map<String, String> data = new HashMap<>();
        data.put("voucherCode", "EXPIRED_CODE");

        Payment payment = new Payment("PAY-004", "VOUCHER", "PENDING", data);

        payment.setStatus("REJECTED", data);

        assertEquals("REJECTED", payment.status);
    }

    @Test
    void testCreatePaymentByBankSuccess() {
        Map<String, String> data = new HashMap<>();
        data.put("bankName", "Bank Central");
        data.put("referenceCode", "123456789");

        Payment payment = new Payment("PAY-005", "BANK_TRANSFER", "PENDING", data);
        payment.setStatus("SUCCESS", data);

        assertEquals("SUCCESS", payment.status);
    }

    @Test
    void testCreatePaymentByBankRejected() {
        Map<String, String> data = new HashMap<>();
        data.put("bankName", "Bank Central");
        data.put("referenceCode", "");

        Payment payment = new Payment("PAY-006", "BANK_TRANSFER", "PENDING", data);
        payment.setStatus("REJECTED", data);

        assertEquals("REJECTED", payment.status);
    }

}