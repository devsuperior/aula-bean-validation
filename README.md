# Estudo de caso com Spring Boot e Bean Validation

#### DevSuperior - Alexandre Oliveira

Siga-nos:

https://instagram.com/devsuperior.ig

https://youtube.com/devsuperior

## Observação: 

Este projeto utilizou como base o repositório aula-camadas (https://github.com/devsuperior/aula-camadas).

## Dependências Maven

### Pegue o pom.xml completo para Spring Boot versão 2.6.0 no link abaixo:
https://github.com/devsuperior/aula-bean-validation/blob/main/pom.xml

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

## SQL para seed da base de dados de teste

```sql
INSERT INTO tb_user (name, email, phone, birth_date, balance, password) VALUES ('Maria', 'maria@gmail.com', '99970-8499', TIMESTAMP WITH TIME ZONE '1990-07-13T20:50:00Z', 100.0, '12345678');
INSERT INTO tb_user (name, email, phone, birth_date, balance, password) VALUES ('Joao', 'joao@gmail.com', '99442-9090', TIMESTAMP WITH TIME ZONE '1996-08-20T20:50:00Z', 10.0, '2564282');
```

## FindAll e Insert no UserService

```java
@Transactional(readOnly = true)
public List<UserDTO> findAll() {
  List<User> list = repository.findAll();
  return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
}
  
@Transactional()
public UserDTO insert(UserInsertDTO dto) {
  User entity = new User();
  copyDtoToEntity(dto, entity);
  entity.setPassword(dto.getPassword());
  entity = repository.save(entity);
  return new UserDTO(entity);
}
 
private void copyDtoToEntity(UserDTO dto, User entity) {
  entity.setName(dto.getName());
  entity.setEmail(dto.getEmail());
  entity.setPhone(dto.getPhone());
  entity.setBirthDate(dto.getBirthDate());
  entity.setBalance(dto.getBalance());
}
```

## FindAll e Insert no UserController

```java
@GetMapping
public ResponseEntity<List<UserDTO>> findAll() {
  List<UserDTO> list = service.findAll();
  return ResponseEntity.ok().body(list);
}

@PostMapping
public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto) {
  UserDTO newDto = service.insert(dto);
  URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(newDto.getId()).toUri();
   return ResponseEntity.created(uri).body(newDto);
}

```

## Links úteis:

- Jakarta Bean Validation: https://beanvalidation.org/
- API Java Doc: https://docs.jboss.org/hibernate/beanvalidation/spec/2.0/api/
- Exemplos utilizando Bean Validation: https://www.baeldung.com/javax-validation
- Diferença @NotNull, NotEmpty e @NotBlank: https://www.baeldung.com/java-bean-validation-not-null-empty-blank
- Regex: https://www.regexlib.com/
- Validação Regex: https://regexr.com/
