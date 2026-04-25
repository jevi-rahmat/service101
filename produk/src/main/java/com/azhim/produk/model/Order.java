package com.azhim.produk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idPelanggan;
    private Long idProduk;
    private int jumlah;
    private double harga;
    private double totalHarga;

    @PrePersist
    @PreUpdate
    private void calculateTotalHarga() {
        this.totalHarga = this.harga * this.jumlah;
    }
}
