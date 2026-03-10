package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;

import java.util.Map;
import java.util.Objects;

public class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    public Payment(String id, String method, String status, Map<String, String> paymentData) {
        this.id = id;
        this.status = status;
        this.paymentData = paymentData;

        checkMethod(method);
        setStatus(method, paymentData);

    }

    public void checkMethod(String method) {
        if (PaymentMethod.contains(method)) {
            this.method = method;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setStatus(String method, Map<String, String> paymentData) {
        if (Objects.equals(method, PaymentMethod.VOUCHER.getValue())) {
            checkVoucherMethod(paymentData.get("voucherCode"));
            return;
        }

        if (Objects.equals(method, PaymentMethod.BANK.getValue())) {
            checkBankMethod(paymentData.get("bankName"), paymentData.get("referenceCode"));
        }
    }

    public void checkVoucherMethod(String code) {
        long digitCount = code.chars().filter(Character::isDigit).count();

        if (code.length() != 16 || !code.contains("ESHOP") || digitCount < 8 || digitCount > 11) {
            this.status = "REJECTED";
        } else {
            this.status = "SUCCESS";
        }
    }

    public void checkBankMethod(String bankName, String referenceCode) {
        if (bankName.isEmpty() || referenceCode.isEmpty()) {
            this.status = "REJECTED";
        } else {
            this.status = "SUCCESS";
        }
    }

}
