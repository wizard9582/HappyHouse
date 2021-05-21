package com.happyhouse.backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.happyhouse.backend.model.repo.AddressRepo;


@Configuration
@EnableAspectJAutoProxy // aspectj를 사용하기 위해서 proxy 객체를 만들어주세요~
@MapperScan(basePackageClasses = AddressRepo.class)
@EnableTransactionManagement // @Transactional을 @Service에서 사용하기 위해서 필요
public class ApplicationConfig {

}
