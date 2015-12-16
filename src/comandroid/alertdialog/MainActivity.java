package comandroid.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button simpleDialog;
	private Button simpleListDialog;
	private Button singleChoiceDialog;
	private Button multiChoiceDialog;
	private Button customAdapterDialog;
	private Button customViewDialog;
	private AlertDialog.Builder builder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		simpleDialog = (Button) findViewById(R.id.btn_simple_dialog);
		simpleListDialog = (Button) findViewById(R.id.btn_simple_list_dialog);
		singleChoiceDialog = (Button) findViewById(R.id.btn_single_choice_dialog);
		multiChoiceDialog = (Button) findViewById(R.id.btn_multi_choice_dialog);
		customAdapterDialog = (Button) findViewById(R.id.btn_custome_adapter_dialog);
		customAdapterDialog = (Button) findViewById(R.id.btn_custome_view_dialog);
		simpleDialog.setOnClickListener(new Listener());
		simpleListDialog.setOnClickListener(new Listener());
		singleChoiceDialog.setOnClickListener(new Listener());
		multiChoiceDialog.setOnClickListener(new Listener());
		// customAdapterDialog.setOnClickListener(new Listener());
		// customViewDialog.setOnClickListener(new Listener());

	}

	public class Listener implements android.view.View.OnClickListener {
		public void onClick(View view) { // TODO Auto-generated method stub
			switch (view.getId()) {
			case R.id.btn_simple_dialog:
				showSimpleDialog(view);
				break;
			case R.id.btn_simple_list_dialog:
				showSimpleListDialog(view);
				break;
			case R.id.btn_single_choice_dialog:
				showSingleChoiceDialog(view);
				break;
			case R.id.btn_multi_choice_dialog:
				showMultiChoiceDialog(view);
				break;

			}
		}
	}


	private void showSimpleDialog(View view) {
		builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle(R.string.simple_dialog);
		builder.setMessage(R.string.dialog_message);
		builder.setPositiveButton(R.string.positive_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								R.string.toast_positive, Toast.LENGTH_SHORT)
								.show();
					}
				});
		builder.setNegativeButton(R.string.negative_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								R.string.toast_negative, Toast.LENGTH_SHORT)
								.show();
					}
				});
		builder.setCancelable(true);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showSimpleListDialog(View view) {
		builder = new AlertDialog.Builder(MainActivity.this);
		builder.setTitle(R.string.simple_list_dialog);
		final String[] Items = { "疯狂Java讲义", "疯狂Android讲义", "Spring核心技术",
				"物联网工程导论" };
		builder.setItems(Items, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"你选中了 《" + Items[i] + "》", Toast.LENGTH_SHORT).show();
			}
		});
		builder.setPositiveButton(R.string.positive_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"你选中了 《" + Items[i] + "》", Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setNegativeButton(R.string.negative_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								R.string.toast_negative, Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setCancelable(true);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showSingleChoiceDialog(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.simple_choice_dialog);
		final String[] Items = { "疯狂Java讲义", "疯狂Android讲义", "Spring核心技术",
				"物联网工程导论" };
		builder.setSingleChoiceItems(Items, 1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(),
								"你选中了 《" + Items[i] + "》", Toast.LENGTH_SHORT)
								.show();
					}
				});
		builder.setPositiveButton(R.string.positive_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"你选中了 《" + Items[i] + "》", Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setNegativeButton(R.string.negative_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								R.string.toast_negative, Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setCancelable(true);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void showMultiChoiceDialog(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.multi_choice_dialog);
		final String[] Items = { "疯狂Java讲义", "疯狂Android讲义", "Spring核心技术",
				"物联网工程导论" };
		builder.setMultiChoiceItems(Items, new boolean[] { true, false, false,
				true }, new DialogInterface.OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialogInterface, int i,
					boolean b) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),
						"你选中了" + Items[i] + "" + b, Toast.LENGTH_SHORT).show();
			}
		});
		builder.setPositiveButton(R.string.positive_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								"你选中了 《" + Items[i] + "》", Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setNegativeButton(R.string.negative_button,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						// TODO Auto-generated method stub
//						Toast.makeText(getApplicationContext(),
//								R.string.toast_negative, Toast.LENGTH_SHORT)
//								.show();
					}
				});
		builder.setCancelable(true);
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
