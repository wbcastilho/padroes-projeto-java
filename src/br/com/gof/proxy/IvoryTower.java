package br.com.gof.proxy;

public class IvoryTower implements WizardTower{
    @Override
    public void enter(Wizard wizard) {
        System.out.println(wizard + " entra na torre.");
    }
}
