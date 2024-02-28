package org.example;

public class Copier {

    private ISource src;
    private IDestination dest;

    public Copier(ISource src, IDestination dest) {
        this.src = src;
        this.dest = dest;
    }

    public void Copy() {

        // src.ReadChar() gets set from the mock test
        char c = src.ReadChar();

        while (c != '\n') {
            dest.WriteChar(c);
            c = src.ReadChar();
        }
    }

}
