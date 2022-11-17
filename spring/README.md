### Overview of SpringTest contexts

https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring

https://www.baeldung.com/spring-tests
https://www.baeldung.com/spring-tests#5-using-test-slices
https://spring.io/blog/2016/08/30/custom-test-slice-with-spring-boot-1-4

# Test Auto-configuration Annotations
https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html#appendix.test-auto-configuration
- Full application
- Test Slices
  - Documentation
    - https://github.com/spring-projects/spring-boot/tree/main/spring-boot-project/spring-boot-test-autoconfigure/src/main/java/org/springframework/boot/test/autoconfigure
  - Slices
    - @DataJpaTest
    - @DataMongoTest
    - @JsonTest
    - @JdbcTest
    - @WebMvcTest

- SecurityTest
  - https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/test-method.html
  - @PreAuthorize("authenticated")
  - @WithMockUser
    - https://docs.spring.io/spring-security/site/docs/5.0.x/reference/html/test-method.html

