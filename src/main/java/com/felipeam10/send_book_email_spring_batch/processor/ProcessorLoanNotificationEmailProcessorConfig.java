package com.felipeam10.send_book_email_spring_batch.processor;

import com.felipeam10.send_book_email_spring_batch.domain.UserBookLoan;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorLoanNotificationEmailProcessorConfig {

    @Bean
    public ItemProcessor<UserBookLoan, Mail> processLoanNotificationEmailProcessor() {
        return new ItemProcessor<UserBookLoan, Mail>() {
            @Override
            public Mail process(UserBookLoan loan) throws Exception {
                Email from = new Email("felipeam10@hotmail.com", "Biblioteca UFU");
                Email to = new Email(loan.getUser().getEmail());
                Content content = new Content("text/plain", generateEmailText(loan));
                Mail mail = new Mail(from, "Notificação devolução livro", to, content);
                Thread.sleep(1000);
                return null;
            }

            private String generateEmailText(UserBookLoan loan) {
                StringBuilder writer = new StringBuilder();
                writer.append(String.format("Prezado(a), %s, matricula %d\n", loan.getUser().getName(), loan.getUser().getId()));
                writer.append(String.format("Informamos que o prazo de devolução do livro %s é amanhã (%s) \n", loan.getBook().getName(), GenerateBookReturnDate.getDate(loan.getLoan_date())));
                writer.append("Solicitamos que você renove o livro ou devolva, assim que possível.\n");
                writer.append("A Biblioteca UFU está funcionando de segunda a sexta, das 9h às 17h.\n\n");
                writer.append("Atenciosamente,\n");
                writer.append("Setor de empréstimo e devolução\n");
                writer.append("BIBLIOTECA MUNICIPAL");
                return writer.toString();
            }
        };
    }
}
