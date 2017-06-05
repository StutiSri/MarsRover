package org.tw.marsrover;

/**
 * Created by stutis on 6/5/17.
 */
public enum Orientation {
    N, E, W, S;

    static {
        N.left = W;
        W.left = S;
        S.left = E;
        E.left = N;

        N.right = E;
        E.right = S;
        S.right = W;
        W.right = N;

    }

    Orientation left;
    Orientation right;
}
