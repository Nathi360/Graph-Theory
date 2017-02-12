//package Countach;

import java.util.Iterator;
import java.util.Stack;

abstract class Traversal
{
    protected Stack <String> visited;
    protected abstract void traverse();
    protected abstract String getPath();
    protected abstract Boolean allVisited();
    protected abstract String getToStartVertex();
}
