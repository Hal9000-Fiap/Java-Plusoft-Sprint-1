package br.com.fiap.sprint1.JavaSprint1WhitelabelAPI.model;

import br.com.fiap.sprint1.JavaSprint1WhitelabelAPI.dto.response.CreateResponseDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_SPRINT1_RESPONSE")
@EntityListeners(AuditingEntityListener.class)
public class Response {

    @Id
    @GeneratedValue
    @Column(name = "response_id")
    private Long id;

    @Column(name = "message", nullable = false, length = 250)
    private String message;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reclamation_id", nullable = false)
    private Reclamation reclamation;

    public Response(CreateResponseDTO responseDTO) {
        message = responseDTO.message();
    }

}
