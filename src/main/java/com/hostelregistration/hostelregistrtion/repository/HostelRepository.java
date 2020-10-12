package com.hostelregistration.hostelregistrtion.repository;

import com.hostelregistration.hostelregistrtion.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel,String> {


}
