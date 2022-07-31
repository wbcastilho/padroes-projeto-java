package br.com.gof.chain_of_responsability;

public class OrcKing {
    private RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}
