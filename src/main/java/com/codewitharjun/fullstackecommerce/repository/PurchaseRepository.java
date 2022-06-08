package com.codewitharjun.fullstackecommerce.repository;

import com.codewitharjun.fullstackecommerce.model.Purchase;
import com.codewitharjun.fullstackecommerce.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("select " +
            "prd.name as name, pur.price as price, pur.purchaseTime as purchaseTime " +
            "from Purchase pur left join Product prd on prd.id=pur.productId " +
            "where pur.userId = :userId")
    List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);


}
