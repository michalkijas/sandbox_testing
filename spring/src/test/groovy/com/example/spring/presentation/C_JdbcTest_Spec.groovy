package com.example.spring.presentation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.jdbc.Sql

/**
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/data/jdbc/DataJdbcTest.html
 * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.autoconfigured-spring-data-jdbc
 *
 * Using this annotation will disable full auto-configuration and instead apply only configuration relevant to JDBC tests.
 *
 * By default, tests annotated with @JdbcTest are transactional and roll back at the end of each test.
 * They also use an embedded in-memory database (replacing any explicit or usually auto-configured DataSource).
 * The @AutoConfigureTestDatabase annotation can be used to override these settings.
 */

/**
 * For tests that only require a DataSource and do not use Spring Data JDBC.
 * No Entities or Repositories are scanned
 */
@JdbcTest
class C_JdbcTest_Spec extends TestBaseSpec {

    @Autowired
    private JdbcTemplate jdbcTemplate

    @Sql(["classpath:sql/test_schema.sql", "classpath:sql/test_data.sql"])
    def "should run only data context"() {
        when:
            def count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM BOOKS", Integer.class)
        then:
            count == 1
    }

}
