/**
 * This file is part of the Embeded TP.
 *
 * (c) Mickael Gaillard <mickael.gaillard@tactfactory.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.tactfactory.testpremier;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText qtView;
	private TextView resultView;
	
	long perfStartTime;
	long perfEndTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		
		// Common component
		this.qtView 	= (EditText) this.findViewById(R.id.qt);
		this.resultView = (TextView) this.findViewById(R.id.textresult);
		
		// Connect button engine
		final Button btn_c = (Button) this.findViewById(R.id.btnc);
		btn_c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AsyncTask<Void, Void, String>() {

					@Override
					protected String doInBackground(Void... params) {
						EngineC engine = new EngineC();
						
						int qt = MainActivity.this.getQuantity();
						String result = engine.calculate(qt);
						perfEndTime = System.nanoTime();
						
						return result;
					}

					@Override
					protected void onPostExecute(String result) {
						super.onPostExecute(result);
						
						MainActivity.this.displayPrimes(result);
					}
					
					
				}.execute();
			}
		});
		
		final Button btn_java = (Button) this.findViewById(R.id.btnjava);
		btn_java.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new AsyncTask<Void, Void, String>() {

					@Override
					protected String doInBackground(Void... params) {
						EngineJava engine = new EngineJava();
						
						int qt = MainActivity.this.getQuantity();
						String result = engine.calculate(qt);
						perfEndTime = System.nanoTime();
						
						return result;
					}

					@Override
					protected void onPostExecute(String result) {
						super.onPostExecute(result);
						
						MainActivity.this.displayPrimes(result);
					}
					
					
				}.execute();
			}
		});
	}
	
	/**
	 * Get enter quantity
	 * @param qtView
	 * @return
	 */
	private int getQuantity() {
		int qt = 0;
		
		if (this.qtView != null) {
			String value = this.qtView.getText().toString();
			
			if (value != "")
				try {
					qt = Integer.parseInt(value);
				} catch (Exception e) {
					// Nothing to do (default = 0)
				}
		}
		
		// Protect CPU
		if (qt > 1000)
			qt = 1000;
		
		this.perfStartTime = System.nanoTime();
		
		return qt;
	}

	/**
	 * Display to Activity calculated result
	 * @param result
	 */
	protected void displayPrimes(String result) {
		long perfDuration = this.perfEndTime - this.perfStartTime;
		
		if (this.resultView != null && result != null && result.length() > 0) {
			this.resultView.setText(String.format("Time : %d\n%s", perfDuration, result));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
