package com.hairplace.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
<<<<<<< HEAD:src/main/java/com/hairplace/model/User.java
@Table(name = "users")
public class User implements Serializable{
=======
@Table(name = "usuario")
public class UserModel implements Serializable{
>>>>>>> ed31c02358971532a817bcf51c84087fd2af24b2:src/main/java/com/hairplace/model/UserModel.java

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "nome", unique = false, nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", unique = false, nullable = false)
    private String password;

<<<<<<< HEAD:src/main/java/com/hairplace/model/User.java
	public long getId() {
		return id;
	}
=======
    @Column(name = "celular", unique = false, nullable = false)
    private String numberCellphone;

    @Column(name = "cpf", unique = false, nullable = false)
    private String cpf;

    @Column(name = "data_nascimento", unique = false, nullable = false)
    private Date birthDate;
>>>>>>> ed31c02358971532a817bcf51c84087fd2af24b2:src/main/java/com/hairplace/model/UserModel.java

}
