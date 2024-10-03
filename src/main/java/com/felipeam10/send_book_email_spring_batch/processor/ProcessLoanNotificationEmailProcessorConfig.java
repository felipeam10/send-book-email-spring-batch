package com.felipeam10.send_book_email_spring_batch.processor;

import com.felipeam10.send_book_email_spring_batch.domain.UserBookLoan;
import com.felipeam10.send_book_email_spring_batch.util.GenerateBookReturnDate;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessLoanNotificationEmailProcessorConfig {

    @Bean
    public ItemProcessor<UserBookLoan, Mail> processLoanNotificationEmailProcessor() {
        return new ItemProcessor<UserBookLoan, Mail>() {

            @Override
            public Mail process(UserBookLoan loan) throws Exception {
                Email from = new Email("youremail@here.com", "Library UFU");
                Email to = new Email(loan.getUser().getEmail());
                Content content = new Content("text/plain", generateEmailText(loan));
                Mail mail = new Mail(from, "Book return notification", to, content);
                Thread.sleep(1000);
                return mail;
            }

            private String generateEmailText(UserBookLoan loan) {
                StringBuilder writer = new StringBuilder();
                writer.append(String.format("Dear, %s, registration %d\n", loan.getUser().getName(), loan.getUser().getId()));
                writer.append(String.format("we inform you that the deadline for returning the book %s it's tomorrow (%s) \n", loan.getBook().getName(), GenerateBookReturnDate.getDate(loan.getLoan_date())));
                writer.append("We ask that you renew the book or return it as soon as possible.\n");
                writer.append("The Library is open from Monday to Friday, from 9am to 5pm.\n\n");
                writer.append("Yours sincerely,\n");
                writer.append("Loan and return sector\n");
                writer.append("Library UFU");
                return writer.toString();
            }

        };

    }

}

