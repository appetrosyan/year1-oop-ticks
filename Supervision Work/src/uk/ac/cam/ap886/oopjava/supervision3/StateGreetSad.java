package uk.ac.cam.ap886.oopjava.supervision3;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

public class StateGreetSad implements StateGreet {

	@Override
	public void greet(StateContext context) {
		System.out.println("Thanks for noticing me. ");
		context.setState(new StateGreetHappy());
	}

}
