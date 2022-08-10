package com.example.sandbox_spock.books;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomersService {

    public List<String> findCustomers() {
        return List.of("Customer 1", "Customer 2");
    }

}
