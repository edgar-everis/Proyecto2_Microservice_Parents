package com.main.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Parents")
public class Parents {

  @NotEmpty
  @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
  private LocalDate birthdate;

  @NotEmpty private String document;

  @NotEmpty private String fullname;

  @NotEmpty private String gender;

  @Id private String id;

  @NotEmpty private String idfamily;

  @NotEmpty private String idstudent;

  @NotEmpty private String typedoc;
}
