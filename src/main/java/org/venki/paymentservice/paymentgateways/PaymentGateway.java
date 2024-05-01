package org.venki.paymentservice.paymentgateways;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    public String generatePaymentLink(Long orderId, String mailId) throws RazorpayException;
}
