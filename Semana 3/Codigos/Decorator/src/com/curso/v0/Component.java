package com.curso.v0;

import java.util.HashMap;

public interface Component {
	boolean getAccess(HashMap<String, String> accessTokens);
}
