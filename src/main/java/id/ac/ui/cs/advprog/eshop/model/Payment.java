package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class Payment {
    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        return null;
    }

    public Payment setStatus(Payment payment, String status) {
        return null;
    }

    public Payment getPayment(String paymentId) {
        return null;
    }

    public Payment getAllPayments() {
        return null;
    }
}
