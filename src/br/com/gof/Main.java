package br.com.gof;

import br.com.gof.facade.Facade;
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

        // Strategy
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

        // Facade
        Facade facade = new Facade();
        facade.migrarCliente("Welber", "37014-500");

        // Proxy
        var proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }
}
