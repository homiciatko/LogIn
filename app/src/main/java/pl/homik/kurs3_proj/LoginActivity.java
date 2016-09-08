package pl.homik.kurs3_proj;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextUser)
    public EditText loginText;
    @BindView(R.id.editTextPassword)
    public EditText passwordText;
    @BindView(R.id.editTextNumber)
    public EditText magicNumberText;
//    @BindView(R.id.loginButton)
//    public Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    public void loginClicked(View view) {
        String login, password;
        String magicNumber;





//        try {
            login = loginText.getText().toString();
            password = passwordText.getText().toString();
            magicNumber = magicNumberText.getText().toString();
//            magicNumber = Integer.parseInt(magicNumberText.getText().toString());
            if (emptyValuesCheckout(login, password, magicNumber)) {
                showDialog("brak pol", "wypełnij wszystkie pola", R.layout.dialog);
            } else if (!loginCheckOut(login, password)) {
                showDialog("zle dane", "bledne dane logowania", R.layout.dialog);


            } else {

            }

//        } catch(NumberFormatException e) {
//            Toast.makeText(this,"Number format Exception",Toast.LENGTH_LONG).show();

//        } catch(IllegalArgumentException e) {
//            Toast.makeText(this,"Illegal Exception",Toast.LENGTH_LONG).show();
//        }

    }



    public boolean emptyValuesCheckout(String login, String password, String magicNumber) {
        if (login == null || password == null || magicNumber == null)
            return true;
        return false;
    }

    public boolean loginCheckOut(String login, String password) {
        if (login.equals("oscar") && password.equals("password12"))
            return true;
        return false;
    }

    public void showDialog(String dialogTitle, String dialogText, int layoutResID) {
        final Dialog dialog = new Dialog(LoginActivity.this);
        TextView textInDialog = (TextView) dialog.findViewById(R.id.textViewInDialog);
        Button buttonInDialog = ButterKnife.findById(dialog, R.id.buttonInDialog);
        textInDialog.setText(dialogText);

//        buttonInDialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });


        dialog.setContentView(layoutResID);
        dialog.setTitle(dialogTitle);

        dialog.show();
        Toast.makeText(LoginActivity.this,dialogText,Toast.LENGTH_SHORT).show();


    }




}
