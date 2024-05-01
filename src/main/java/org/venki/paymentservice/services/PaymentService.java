package org.venki.paymentservice.services;

import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;
import org.venki.paymentservice.paymentgateways.PaymentGateway;

@Service
public class PaymentService {

    //dependency injection
    private PaymentGateway paymentGateway;
    public PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId, String mailId) throws RazorpayException {
        return paymentGateway.generatePaymentLink(orderId,mailId);
    }
}
