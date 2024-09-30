package com.produit.service;

import com.produit.model.Produit;
import com.produit.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }


    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit getProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Desolate product not exist");
        }
        return optionalProduit.get();
    }

    public String deleteProduitById(Long id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Suppression imposible l'id n'existe pas");
        }
        produitRepository.delete(optionalProduit.get());
        return "Produit supprimer";

    }

    public Produit editProduit(Long id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isEmpty()) {
            throw new RuntimeException("Modification impossible");
        }
        Produit produitAModifier = optionalProduit.get();
        produitAModifier.setName(produit.getName());
        produitAModifier.setPrice(produit.getPrice());
        return produitRepository.save(produitAModifier);
    }
}
