package com.curso.v0;

import java.util.HashMap;

// Component interface, the get access method search for certain credentials depending on the decorator
public interface Component {
	boolean getAccess(HashMap<String, String> accessTokens);
}
