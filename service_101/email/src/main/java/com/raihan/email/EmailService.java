package com.raihan.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired(required = false)
    private JavaMailSender mailSender;

    @RabbitListener(queues = "order_queue")
    public void sendMail(Order order) {
        try {
            System.out.println("Order received\nPreparing to send email for: " + order.getProduct());

            // SimpleMailMessage message = new SimpleMailMessage();
            // message.setFrom("rahmatjevi1@gmail.com");
            // message.setTo("rahmatjevi1@gmail.com");
            // message.setSubject("Hey User, you have an order for " + order.getProduct());
            // message.setText("Order Details:\nID " + order.getId() +
            //         "\nCustomer ID: " + order.getCustomer_id() +
            //         "\nProduct ID: " + order.getProduct_id() +
            //         "\nProduct: " + order.getProduct() +
            //         "\nCost: " + order.getCost() +
            //         "\n<img src='https://i1.sndcdn.com/artworks-x8zI2HVC2pnkK7F5-4xKLyA-t500x500.jpg'>");
            // mailSender.send(message);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom("rahmatjevi1@gmail.com");
            helper.setTo("juandanastrido01@gmail.com");
            helper.setSubject("Hey User, you have an order for " + order.getProduct());

            String htmlContent = String.format(
                    "<html>" +
                            "<body>" +
                            "<h2>Order Details:</h2>" +
                            "<p><strong>ID:</strong> %d</p>" +
                            "<p><strong>Customer ID:</strong> %d</p>" +
                            "<p><strong>Product ID:</strong> %d</p>" +
                            "<p><strong>Product:</strong> %s</p>" +
                            "<p><strong>Cost:</strong> $%.2f</p>" +
                            "<iframe width=\"853\" height=\"480\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ?autoplay=1\" title=\"Rick Astley - Never Gonna Give You Up (Official Video) (4K Remaster)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>"
                            +
                            "</body>" +
                            "</html>",
                    order.getId(),
                    order.getCustomer_id(),
                    order.getProduct_id(),
                    order.getProduct(),
                    order.getCost());

            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
            System.out.println("Mail sent");
        } catch (jakarta.mail.MessagingException e) {
            System.err.println("Failed to send email:" + e.getMessage());
        }
    }

}
