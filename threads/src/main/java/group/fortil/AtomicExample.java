package group.fortil;


import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        // Création d'un AtomicInteger avec une valeur initiale de 0
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Incrémentation atomique de l'entier
        System.out.println("Valeur initiale : " + atomicInt.get());
        atomicInt.incrementAndGet(); // Incrémente l'entier de manière atomique
        System.out.println("Après incrémentation : " + atomicInt.get());

        // Décrémentation atomique de l'entier
        atomicInt.decrementAndGet(); // Décrémente l'entier de manière atomique
        System.out.println("Après décrémentation : " + atomicInt.get());

        // Ajout d'une valeur atomique à l'entier
        atomicInt.addAndGet(5); // Ajoute 5 à l'entier de manière atomique
        System.out.println("Après ajout : " + atomicInt.get());

        // Comparaison et mise à jour atomiques
        int expectedValue = 5;
        int newValue = 10;
        boolean updated = atomicInt.compareAndSet(expectedValue, newValue); // Si la valeur est 5, met à jour à 10 de manière atomique
        System.out.println("Comparaison et mise à jour atomiques : " + updated);
        System.out.println("Nouvelle valeur : " + atomicInt.get());
    }
}
