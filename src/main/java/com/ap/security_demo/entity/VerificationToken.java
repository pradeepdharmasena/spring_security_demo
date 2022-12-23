package com.ap.security_demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION_TIME = 10;
    @Id
    @SequenceGenerator(
            name = "verification_token_sequence",
            sequenceName = "verification_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "verification_token_sequence"
    )
    private long id;
    private String token;
    private Date expireDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_USER_VERIFICATION_TOKEN"))
    private Users user;

    public VerificationToken(Users user, String token){
        super();
        this.user = user;
        this.token = token;
        this.expireDate = calculateExpireDate(EXPIRATION_TIME);
    }

    public VerificationToken(String token){
        super();
        this.token = token;
    }

    private Date calculateExpireDate(int expTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expTime);

        return new Date(calendar.getTime().getTime());
    }

}
