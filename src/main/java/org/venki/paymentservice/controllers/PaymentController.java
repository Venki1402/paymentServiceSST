package org.venki.paymentservice.controllers;

import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.*;
import org.venki.paymentservice.dtos.InitiatePaymentRequestDto;
import org.venki.paymentservice.services.PaymentService;

@RestController
@RequestMapping("/payment") public class PaymentController {
    //dependency injection
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping("/test")
    public String test(){
        return "Its Working!";
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDto initiatePaymentRequestDto) throws RazorpayException {
        long orderId = initiatePaymentRequestDto.getOrderId();
        String mailId = initiatePaymentRequestDto.getMailId();
        return paymentService.initiatePayment(orderId,mailId);
    }

}
