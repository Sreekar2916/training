package com.uniquehire.cafe.repository;

import com.uniquehire.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTableName(String tableName);

    // select * from order where table_name = "Table-2"
    @Query("select o from Order o where o.tableName= :tableName")
    List<Order> findWithTableName(String tableName);

    @Query(value = "select * from orders where table_name=:tableName", nativeQuery = true)
    List<Order> findWithTableNameNativeQuery(String tableName);

    Optional<Order> findByCreatedBy(String createdBy);

}
