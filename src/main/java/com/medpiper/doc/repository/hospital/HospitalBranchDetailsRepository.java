package com.medpiper.doc.repository.hospital;

import com.medpiper.doc.domain.hospital.HospitalBranchDetails;
import com.medpiper.doc.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface HospitalBranchDetailsRepository extends JpaRepository<HospitalBranchDetails,Integer>
{
    @Query(value="SELECT * FROM hospital_branch_details d WHERE d.hospital_id=?1",nativeQuery = true)
    public List<HospitalBranchDetails> getHospitalBranchDetails(@Param("hospital_id") int hospitalId) throws ResourceNotFoundException;

    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "UPDATE hospital_branch_details de set  " +
            "info_address =?," +
            "info_town_city =?," +
            "info_state =?," +
            "info_pincode =?," +
            " info_district =?," +
            "info_established_year =? " +
            "info_sub_district =? " +
            "info_hospital_registration_no =? " +
            "contact_land_line =? " +
            "contact_hospital_secondary_email =? " +
            "contact_mobile_number =? " +
            "contact_website =? " +
            "contact_emergencynumber =? " +
            "contact_name =? " +
            "contact_help_line_number =? " +
            "contact_designation =? " +
            "health_care_provider_type =? " +
            "where de.hospital_id = ?",nativeQuery = true)
    void updateHospitalBranchDetails(@Param("info_address") String infoAddress,
                                     @Param("info_town_city") String infoTownCity,
                                     @Param("info_state") String infoState,
                                     @Param("info_pincode") int infoPincode,
                                     @Param("info_district") String infoDistrict,
                                     @Param("info_established_year") String infoEstablishedYear,
                                     @Param("info_sub_district") String infoSubDistrict,
                                     @Param("info_hospital_registration_no") String infoHospitalRegistrationNo,
                                     @Param("contact_land_line") int contactLandLine,
                                     @Param("contact_hospital_secondary_email") String contactHospitalSecondaryEmail,
                                     @Param("contact_mobile_number") int contactMobileNumber,
                                     @Param("contact_website") String contactWebsite,
                                     @Param("contact_emergencynumber") int contactEmergencynumber,
                                     @Param("contact_name") String contactName,
                                     @Param("contact_help_line_number") int contactHelpLineNumber,
                                     @Param("contact_designation") String contactDesignation,
                                     @Param("health_care_provider_type") String healthCareProviderType,
                                     @Param("hospital_id") int hospitalId)
                                     throws ResourceNotFoundException;
}
