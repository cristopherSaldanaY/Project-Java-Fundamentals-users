package com.project.javafundamentals.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "phones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "cel_number", unique = true)
    private String celNumber;

    @Column(name = "code_city")
    private String codCity;

    @Column(name = "code_country")
    private String codCountry;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id) && Objects.equals(celNumber, phone.celNumber) && Objects.equals(codCity, phone.codCity) && Objects.equals(codCountry, phone.codCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, celNumber, codCity, codCountry);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("id=").append(id);
        sb.append(", celNumber='").append(celNumber).append('\'');
        sb.append(", codCity='").append(codCity).append('\'');
        sb.append(", codCountry='").append(codCountry).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
