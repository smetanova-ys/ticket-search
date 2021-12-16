package ru.netology.manager;

import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

public class OfferManager {
    private OfferRepository repository;

    public OfferManager(OfferRepository repository) {
        this.repository = repository;
    }

    public void add(Offer item) {
        repository.save(item);
    }

    public Offer[] searchBy(String from, String to) {
        Offer[] items = new Offer[0];
        for (Offer item : repository.findAll()) {
            if (item.getDepartureAirport() == from && item.getArrivalAirport() == to) {
                Offer[] tmp = new Offer[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }
        }
        Arrays.sort(items);
        return items;
    }
}
