package br.com.gof.chain_of_responsability;

public class OrcCommander extends RequestHandler {
    public OrcCommander(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (RequestType.DEFEND_CASTLE == req.getRequestType()) {
            printHandling(req);
            req.markHandled();
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc commander";
    }
}
