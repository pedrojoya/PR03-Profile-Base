package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr03.utils.KeyboardUtils;
import es.iessaladillo.pedrojoya.pr03.utils.SnackbarUtils;
import es.iessaladillo.pedrojoya.pr03.utils.ValidationUtils;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPhonenumber;
    private EditText txtAddress;
    private EditText txtWeb;
    private ImageView imgAvatar;
    private TextView lblAvatar;
    private Database database = Database.getInstance();
    private TextView lblText;
    private ImageView imgEmail;
    private ImageView imgPhonenumber;
    private ImageView imgAddress;
    private ImageView imgWeb;
    private TextView lblName;
    private TextView lblEmail;
    private TextView lblPhonenumber;
    private TextView lblAddress;
    private TextView lblWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO
        initView();
    }

    private void initView() {
        lblAvatar = ActivityCompat.requireViewById(this, R.id.lblAvatar);
        imgAvatar = ActivityCompat.requireViewById(this, R.id.imgAvatar);
        txtName = ActivityCompat.requireViewById(this, R.id.txtName);
        txtEmail = ActivityCompat.requireViewById(this, R.id.txtEmail);
        txtPhonenumber = ActivityCompat.requireViewById(this, R.id.txtPhonenumber);
        txtAddress = ActivityCompat.requireViewById(this, R.id.txtAddress);
        txtWeb = ActivityCompat.requireViewById(this, R.id.txtWeb);
        lblName = ActivityCompat.requireViewById(this, R.id.lblName);
        lblEmail = ActivityCompat.requireViewById(this, R.id.lblEmail);
        lblPhonenumber = ActivityCompat.requireViewById(this, R.id.lblPhonenumber);
        lblAddress = ActivityCompat.requireViewById(this, R.id.lblAddress);
        lblWeb = ActivityCompat.requireViewById(this, R.id.lblWeb);
        imgEmail = ActivityCompat.requireViewById(this, R.id.imgEmail);
        imgPhonenumber = ActivityCompat.requireViewById(this, R.id.imgPhonenumber);
        imgAddress = ActivityCompat.requireViewById(this, R.id.imgAddress);
        imgWeb = ActivityCompat.requireViewById(this, R.id.imgWeb);
        lblText = ActivityCompat.requireViewById(this, R.id.lblText);


        avatarDefault();

        imgAvatar.setOnClickListener(v -> changeImg());

        lblAvatar.setOnClickListener(v -> changeImg());

        txtName.requestFocus();
        changeFocus();
        validateOnChange();
        editorAction();
    }

    private void validateOnChange() {
        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @SuppressLint("ResourceAsColor")
            @Override
            public void afterTextChanged(Editable s) {
                if (txtName.getText().toString().isEmpty()) {
                    txtName.setError(getString(R.string.main_invalid_data));
                    lblName.setTextColor(getResources().getColor(R.color.colorError));
                } else {
                    lblName.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }
        });
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
                    txtEmail.setError(getString(R.string.main_invalid_data));
                    lblEmail.setTextColor(getResources().getColor(R.color.colorError));
                    imgEmail.setEnabled(false);
                    imgEmail.setColorFilter(getResources().getColor(R.color.colorError));
                } else {
                    lblEmail.setTextColor(getResources().getColor(R.color.colorBlack));
                    imgEmail.setEnabled(true);
                    imgEmail.setColorFilter(getResources().getColor(R.color.colorBlack));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        txtPhonenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString())) {
                    txtPhonenumber.setError(getString(R.string.main_invalid_data));
                    lblPhonenumber.setTextColor(getResources().getColor(R.color.colorError));
                    imgPhonenumber.setEnabled(false);
                    imgPhonenumber.setColorFilter(getResources().getColor(R.color.colorError));
                } else {
                    lblPhonenumber.setTextColor(getResources().getColor(R.color.colorBlack));
                    imgPhonenumber.setEnabled(true);
                    imgPhonenumber.setColorFilter(getResources().getColor(R.color.colorBlack));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        txtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if (txtAddress.getText().toString().isEmpty()) {
                    txtAddress.setError(getString(R.string.main_invalid_data));
                    lblAddress.setTextColor(getResources().getColor(R.color.colorError));
                    imgAddress.setEnabled(false);
                    imgAddress.setColorFilter(getResources().getColor(R.color.colorError));
                } else {
                    lblAddress.setTextColor(getResources().getColor(R.color.colorBlack));
                    imgAddress.setEnabled(true);
                    imgAddress.setColorFilter(getResources().getColor(R.color.colorBlack));
                }
            }
        });
        txtWeb.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) {
                    txtWeb.setError(getString(R.string.main_invalid_data));
                    lblWeb.setTextColor(getResources().getColor(R.color.colorError));
                    imgWeb.setEnabled(false);
                    imgWeb.setColorFilter(getResources().getColor(R.color.colorError));
                } else {
                    lblWeb.setTextColor(getResources().getColor(R.color.colorBlack));
                    imgWeb.setEnabled(true);
                    imgWeb.setColorFilter(getResources().getColor(R.color.colorBlack));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void editorAction() {
        txtWeb.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save();
                return true;
            }
            return false;
        });
        KeyboardUtils.hideSoftKeyboard(this);
    }

    private void changeFocus() {
        txtName.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblName.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                lblName.setTypeface(Typeface.DEFAULT);
            }
        });
        txtEmail.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblEmail.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                lblEmail.setTypeface(Typeface.DEFAULT);
            }
        });
        txtPhonenumber.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblPhonenumber.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                lblPhonenumber.setTypeface(Typeface.DEFAULT);
            }
        });
        txtAddress.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblAddress.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                lblAddress.setTypeface(Typeface.DEFAULT);
            }
        });
        txtWeb.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                lblWeb.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                lblWeb.setTypeface(Typeface.DEFAULT);
            }
        });
    }

    private void avatarDefault() {
        imgAvatar.setImageResource(database.getDefaultAvatar().getImageResId());
        imgAvatar.setTag(database.getDefaultAvatar().getImageResId());
        lblAvatar.setText(database.getDefaultAvatar().getName());
    }

    private void changeImg() {
        Avatar avatar = database.getRandomAvatar();
        imgAvatar.setImageResource(avatar.getImageResId());
        imgAvatar.setTag(avatar.getImageResId());
        lblAvatar.setText(avatar.getName());
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

    private boolean validate() {
        boolean resultado = true;
        if (txtName.getText().toString().isEmpty()) {
            txtName.setError(getString(R.string.main_invalid_data));
            lblName.setTextColor(getResources().getColor(R.color.colorError));
            resultado = false;
        }
        if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
            txtEmail.setError(getString(R.string.main_invalid_data));
            lblEmail.setTextColor(getResources().getColor(R.color.colorError));
            imgEmail.setEnabled(false);
            imgEmail.setColorFilter(getResources().getColor(R.color.colorError));
            resultado = false;
        }
        if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString())) {
            txtPhonenumber.setError(getString(R.string.main_invalid_data));
            lblPhonenumber.setTextColor(getResources().getColor(R.color.colorError));
            imgPhonenumber.setEnabled(false);
            imgPhonenumber.setColorFilter(getResources().getColor(R.color.colorError));
            resultado = false;
        }
        if (txtAddress.getText().toString().isEmpty()) {
            txtAddress.setError(getString(R.string.main_invalid_data));
            lblAddress.setTextColor(getResources().getColor(R.color.colorError));
            imgAddress.setEnabled(false);
            imgAddress.setColorFilter(getResources().getColor(R.color.colorError));
            resultado = false;
        }
        if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) {
            txtWeb.setError(getString(R.string.main_invalid_data));
            lblWeb.setTextColor(getResources().getColor(R.color.colorError));
            imgWeb.setEnabled(false);
            imgWeb.setColorFilter(getResources().getColor(R.color.colorError));
            resultado = false;
        }
        return resultado;
    }
    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/
    private void save() {
        // TODO
        if (!validate()) {
            SnackbarUtils.snackbar(lblText, getString(R.string.main_error_saving));
        } else {
            SnackbarUtils.snackbar(lblText, getString(R.string.main_saved_succesfully));
        }
        KeyboardUtils.hideSoftKeyboard(this);
    }

}
