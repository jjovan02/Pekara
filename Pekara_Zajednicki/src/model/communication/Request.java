package model.communication;

import java.io.Serializable;

public class Request implements Serializable {
    private Operation operation;
    private Object argument;

    public Request() {
    }

    public Request(Operation operation, Object argument) {
        this.operation = operation;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public Operation getOperation() {
        return operation;
    }
}
