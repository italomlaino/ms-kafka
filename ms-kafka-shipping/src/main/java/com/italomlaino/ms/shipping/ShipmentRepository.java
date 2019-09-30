package com.italomlaino.ms.shipping;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Long> {
}
