package br.com.fiap.sprint1.JavaSprint1WhitelabelAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter@Setter
@NoArgsConstructor

@Entity
@Table(name="JV_SPRINT1_SERVICE_FEEDBACK")
public class ServiceFeedBack {

    @Id
    @GeneratedValue
    @Column(name = "service_feedback_id")
    private Long id;

    @Column(name = "commentary", nullable = false, length = 250)
    private String name;

    @Column(name = "rating", length = 5)
    private Double rating;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
