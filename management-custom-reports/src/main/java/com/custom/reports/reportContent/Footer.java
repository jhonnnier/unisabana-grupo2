package com.custom.reports.reportContent;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Footer {
    String companyName;
    String companyAddress;
    String companyEmail;
    String companyPhone;
}
