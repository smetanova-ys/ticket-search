package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);

    Offer first = new Offer(1, 169, "SVO", "BTS", 185);
    Offer second = new Offer(2, 102, "SVO", "BTS", 185);
    Offer third = new Offer(3, 240, "AER", "VIE", 300);
    Offer fourth = new Offer(4, 125, "SVO", "BTS", 180);
    Offer fifth = new Offer(5, 425, "MOW", "TYO", 1440);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldSearchBy() {
        Offer[] actual = manager.searchBy("MOW", "TYO");
        Offer[] expected = new Offer[]{fifth};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBySeveral() {
        Offer[] actual = manager.searchBy("SVO", "BTS");
        Offer[] expected = new  Offer[]{second, fourth, first};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchByNotExist() {
        Offer[] actual = manager.searchBy("AER", "TYO");
        Offer[] expected = new Offer[]{};

        assertArrayEquals(actual, expected);
    }

}