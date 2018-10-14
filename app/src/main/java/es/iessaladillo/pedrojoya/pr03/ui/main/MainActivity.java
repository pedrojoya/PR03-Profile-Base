package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr03.utils.ValidationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODONT
        ImageView imgAvatar = findViewById(R.id.imgAvatar);
        TextView nameAvatar = findViewById(R.id.lblAvatar);
        setDefault(imgAvatar, nameAvatar);

        //NAME
        TextView lblName = findViewById(R.id.lblName);
        lblName.setTypeface(Typeface.DEFAULT_BOLD);
        EditText txtName = findViewById(R.id.txtName);
        //EMAIL
        TextView lblEmail = findViewById(R.id.lblEmail);
        EditText txtEmail = findViewById(R.id.txtEmail);
        ImageView imgEmail = findViewById(R.id.imgEmail);
        imgEmail.setTag(R.drawable.ic_email_24dp);
        //PHONENUMBER
        TextView lblPhonenumber = findViewById(R.id.lblPhonenumber);
        EditText txtPhonenumber = findViewById(R.id.txtPhonenumber);
        ImageView imgPhonenumber = findViewById(R.id.imgPhonenumber);
        imgPhonenumber.setTag(R.drawable.ic_call_24dp);
        //ADDRESS
        TextView lblAddress = findViewById(R.id.lblAddress);
        EditText txtAddress = findViewById(R.id.txtAddress);
        ImageView imgAddress = findViewById(R.id.imgAddress);
        imgAddress.setTag(R.drawable.ic_map_24dp);
        //WEB
        TextView lblWeb = findViewById(R.id.lblWeb);
        EditText txtWeb = findViewById(R.id.txtWeb);
        ImageView imgWeb = findViewById(R.id.imgWeb);
        imgWeb.setTag(R.drawable.ic_web_24dp);

        //Focus Listeners
        txtName.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) lblName.setTypeface(Typeface.DEFAULT_BOLD);
            else lblName.setTypeface(Typeface.DEFAULT);
        });
        txtEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblEmail.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblEmail.setTypeface(Typeface.DEFAULT);
        });
        txtPhonenumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblPhonenumber.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblPhonenumber.setTypeface(Typeface.DEFAULT);
        });
        txtAddress.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblAddress.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblAddress.setTypeface(Typeface.DEFAULT);
        });
        txtWeb.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblWeb.setTypeface(Typeface.DEFAULT_BOLD);
            } else lblWeb.setTypeface(Typeface.DEFAULT);
        });

        //Text change Listeners
        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    txtName.setError("Missing name");
                    lblName.setEnabled(false);
                } else lblName.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
                    txtEmail.setError(getString(R.string.error_data));
                    lblEmail.setEnabled(false);
                    imgEmail.setEnabled(false);
                } else {
                    lblEmail.setEnabled(true);
                    imgEmail.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString())) {
                    txtPhonenumber.setError(getString(R.string.error_data));
                    lblPhonenumber.setEnabled(false);
                    imgPhonenumber.setEnabled(false);
                } else {
                    lblPhonenumber.setEnabled(true);
                    imgPhonenumber.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    txtAddress.setError(getString(R.string.error_data));
                    lblAddress.setEnabled(false);
                    imgAddress.setEnabled(false);
                } else {
                    lblAddress.setEnabled(true);
                    imgAddress.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        txtWeb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) {
                    txtWeb.setError(getString(R.string.error_data));
                    lblWeb.setEnabled(false);
                    imgWeb.setEnabled(false);
                } else {
                    lblWeb.setEnabled(true);
                    imgWeb.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //When pressing done button.

        //When pressing IME done button.
        txtWeb.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                save();
                return true;
            }
        });
        //When pressing avatar image or name.
        imgAvatar.setOnClickListener(v -> setRandom(imgAvatar,nameAvatar));
        nameAvatar.setOnClickListener(v -> setRandom(imgAvatar,nameAvatar));
    }

    // DO NOT TOUCH
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // DO NOT TOUCH
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnuSave) {
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/
    private void save() {
        // TODO

    }

    private void setDefault(ImageView avatarImg, TextView avatarName) {
        Avatar defAvatar = Database.getInstance().getDefaultAvatar();
        avatarImg.setImageResource(defAvatar.getImageResId());
        avatarImg.setTag(defAvatar.getImageResId());
        avatarName.setText(defAvatar.getName());
    }

    private void setRandom(ImageView avatarImg, TextView avatarName){
        Avatar rndAvatar = Database.getInstance().getRandomAvatar();
        avatarImg.setImageResource(rndAvatar.getImageResId());
        avatarImg.setTag(rndAvatar.getImageResId());
        avatarName.setText(rndAvatar.getName());
    }
}
