package com.example.camp_exam_webbrowser;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	private EditText textUrl;
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textUrl = (EditText) findViewById(R.id.text_url);
		textUrl.setText("http://google.com");
		textUrl.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() != KeyEvent.ACTION_DOWN) {
					return false;
				}

				boolean processed = false;

				switch (keyCode) {
				case KeyEvent.KEYCODE_ENTER:
					webView.loadUrl(textUrl.getText().toString());

					processed = true;

					break;

				default:

					break;
				}

				return processed;
			}

		});

		webView = (WebView) findViewById(R.id.webview);
		webView.setWebViewClient(new WebViewClient());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}