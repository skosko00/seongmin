package com.kh.java.run;

import javax.swing.SwingUtilities;

import com.kh.java.view.ProductView;

public class TestMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ProductView();				
			}
		});
	}

}
