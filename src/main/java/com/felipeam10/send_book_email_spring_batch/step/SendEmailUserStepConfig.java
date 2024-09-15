package com.felipeam10.send_book_email_spring_batch.step;

import com.felipeam10.send_book_email_spring_batch.domain.UserBookLoan;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SendEmailUserStepConfig {

    @Autowired
    @Qualifier("transactionManagerApp") // Qualifier define a anotação para identificar a dependência
    private PlatformTransactionManager transactionManager;
    @Bean
    public Step sendEmailUserStep(ItemReader<UserBookLoan> readUserWithLoansCloseToReturnReader,
            JobRepository jobRepository) {
        return new StepBuilder("sendEmailUserStep", jobRepository)
                .<UserBookLoan, UserBookLoan>chunk(1, transactionManager)
                .reader(readUserWithLoansCloseToReturnReader)
                .build();
    }
}
