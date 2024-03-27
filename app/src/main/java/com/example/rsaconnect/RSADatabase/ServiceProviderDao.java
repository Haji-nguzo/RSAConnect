package com.example.rsaconnect.RSADatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.rsaconnect.ServiceProvider;

import java.util.List;


@Dao
public interface ServiceProviderDao {
    @Insert
    void insert (ServiceProvider serviceProvider);

    @Query("SELECT * FROM service_provider")
    List<ServiceProvider> getAllProvider();
}
