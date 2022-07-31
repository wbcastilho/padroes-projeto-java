package br.com.gof;

import br.com.gof.builder.*;
import br.com.gof.chain_of_responsability.OrcKing;
import br.com.gof.chain_of_responsability.Request;
import br.com.gof.chain_of_responsability.RequestType;
import br.com.gof.facade.Facade;
import br.com.gof.observer.Hobbits;
import br.com.gof.observer.Orcs;
import br.com.gof.observer.Weather;
import br.com.gof.proxy.IvoryTower;
import br.com.gof.proxy.Wizard;
import br.com.gof.proxy.WizardTowerProxy;
import br.com.gof.singleton.SingletonEager;
import br.com.gof.singleton.SingletonLazy;
import br.com.gof.singleton.SingletonLazyHolder;
import br.com.gof.strategy.*;

public class Main {
    public static void main(String[] args) {
        // Singleton
        System.out.println("--- Singleton ---");
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        System.out.println();

        // Strategy
        System.out.println("--- Strategy ---");
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);
        robo.mover();
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        System.out.println();

        // Facade
        System.out.println("--- Facade ---");
        Facade facade = new Facade();
        facade.migrarCliente("Welber", "37014-500");
        System.out.println();

        // Proxy
        System.out.println("--- Proxy ---");
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
        System.out.println();

        // Builder
        System.out.println("--- Builder ---");
        var mage = new Hero.Builder(Profession.MAGE, "Riobard")
                .withHairColor(HairColor.BLACK)
                .withWeapon(Weapon.DAGGER)
                .build();
        System.out.println(mage.toString());

        var warrior = new Hero.Builder(Profession.WARRIOR, "Amberjill")
                .withHairColor(HairColor.BLOND)
                .withHairType(HairType.LONG_CURLY).withArmor(Armor.CHAIN_MAIL).withWeapon(Weapon.SWORD)
                .build();
        System.out.println(warrior.toString());

        var thief = new Hero.Builder(Profession.THIEF, "Desmond")
                .withHairType(HairType.BALD)
                .withWeapon(Weapon.BOW)
                .build();
        System.out.println(thief.toString());
        System.out.println();

        // Observer
        System.out.println("--- Observer ---");
        var weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());

        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        System.out.println();

        // Chain of Reponsavility
        System.out.println("--- Chain of Reponsavility ---");
        var king = new OrcKing();
        king.makeRequest(new Request(RequestType.DEFEND_CASTLE, "defend castle"));
        king.makeRequest(new Request(RequestType.TORTURE_PRISONER, "torture prisoner"));
        king.makeRequest(new Request(RequestType.COLLECT_TAX, "collect tax"));
    }
}
