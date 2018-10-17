package es.iessaladillo.pedrojoya.pr03.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import es.iessaladillo.pedrojoya.pr03.R;
import es.iessaladillo.pedrojoya.pr03.data.local.Database;
import es.iessaladillo.pedrojoya.pr03.data.local.model.Avatar;
import es.iessaladillo.pedrojoya.pr03.utils.ValidationUtils;

import static es.iessaladillo.pedrojoya.pr03.R.id.mnuSave;
import static es.iessaladillo.pedrojoya.pr03.R.menu.activity_main;

public class MainActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPhonenumber;
    private EditText txtAddress;
    private EditText txtWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //AVATAR
        ImageView imgAvatar = ActivityCompat.requireViewById(this, R.id.imgAvatar);
        TextView nameAvatar = ActivityCompat.requireViewById(this, R.id.lblAvatar);
        setDefault(imgAvatar, nameAvatar);
        //NAME
        TextView lblName = ActivityCompat.requireViewById(this, R.id.lblName);
        lblName.setTypeface(Typeface.DEFAULT_BOLD);
        txtName = ActivityCompat.requireViewById(this, R.id.txtName);
        //EMAIL
        TextView lblEmail = ActivityCompat.requireViewById(this, R.id.lblEmail);
        txtEmail = ActivityCompat.requireViewById(this, R.id.txtEmail);
        ImageView imgEmail = ActivityCompat.requireViewById(this, R.id.imgEmail);
        imgEmail.setTag(R.drawable.ic_email_24dp);
        //PHONENUMBER
        TextView lblPhonenumber = ActivityCompat.requireViewById(this, R.id.lblPhonenumber);
        txtPhonenumber = ActivityCompat.requireViewById(this, R.id.txtPhonenumber);
        ImageView imgPhonenumber = ActivityCompat.requireViewById(this, R.id.imgPhonenumber);
        imgPhonenumber.setTag(R.drawable.ic_call_24dp);
        //ADDRESS
        TextView lblAddress = ActivityCompat.requireViewById(this, R.id.lblAddress);
        txtAddress = ActivityCompat.requireViewById(this, R.id.txtAddress);
        ImageView imgAddress = ActivityCompat.requireViewById(this, R.id.imgAddress);
        imgAddress.setTag(R.drawable.ic_map_24dp);
        //WEB
        TextView lblWeb = ActivityCompat.requireViewById(this, R.id.lblWeb);
        txtWeb = ActivityCompat.requireViewById(this, R.id.txtWeb);
        ImageView imgWeb = ActivityCompat.requireViewById(this, R.id.imgWeb);
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
                    txtName.setError(getString(R.string.main_invalid_data));
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
                    txtEmail.setError(getString(R.string.main_invalid_data));
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
                    txtPhonenumber.setError(getString(R.string.main_invalid_data));
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
                    txtAddress.setError(getString(R.string.main_invalid_data));
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
                    txtWeb.setError(getString(R.string.main_invalid_data));
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

        //When pressing IME done button.
        txtWeb.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                save();
                // LLÉVATE ESTAS LÍNEAS A UN MÉTODO DE UNA CLASE DE UTILIDAD KeyboardUtils
                InputMethodManager imm =
                        (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                Objects.requireNonNull(imm).hideSoftInputFromWindow(v.getWindowToken(), 0);
                return true;
            }
            return false;
        });

        //When pressing avatar image or name.
        imgAvatar.setOnClickListener(v -> setRandom(imgAvatar, nameAvatar));
        nameAvatar.setOnClickListener(v -> setRandom(imgAvatar, nameAvatar));
    }

    // DO NOT TOUCH
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // DO NOT TOUCH
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == mnuSave) {
            save();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Checks if form is valid or not and shows a Snackbar accordingly
     **/
    private void save() {
        // LOS TODO LOS DEBES QUITAR CUANDO LOS HAYAS IMPLEMENTADO
        // TODO
        boolean validation = true;
        if (txtName.getText().toString().equals("")) {
            validation = false;
            txtName.setText("");
        }
        if (txtEmail.getText().toString().equals("")) {
            validation = false;
            txtEmail.setText("");
        } else if (!ValidationUtils.isValidEmail(txtEmail.getText().toString())) {
            validation = false;
        }
        if (txtPhonenumber.getText().toString().equals("")) {
            validation = false;
            txtPhonenumber.setText("");
        } else if (!ValidationUtils.isValidPhone(txtPhonenumber.getText().toString()))
            validation = false;

        if (txtAddress.getText().toString().equals("")) {
            validation = false;
            txtAddress.setText("");
        }
        if (txtWeb.getText().toString().equals("")) {
            validation = false;
            txtWeb.setText("");
        } else if (!ValidationUtils.isValidUrl(txtWeb.getText().toString())) validation = false;


        // USA getString() EN VEZ DE getText() Y ASI NO TIENES QUE PONER EL toString()
        if (validation) {
            Snackbar.make(txtWeb, getText(R.string.main_saved_succesfully).toString(), Snackbar.LENGTH_SHORT).show();
        } else
            Snackbar.make(txtWeb, getText(R.string.main_error_saving).toString(), Snackbar.LENGTH_SHORT).show();
    }

    private void setDefault(ImageView avatarImg, TextView avatarName) {
        Avatar defAvatar = Database.getInstance().getDefaultAvatar();
        avatarImg.setImageResource(defAvatar.getImageResId());
        avatarImg.setTag(defAvatar.getImageResId());
        avatarName.setText(defAvatar.getName());
    }

    private void setRandom(ImageView avatarImg, TextView avatarName) {
        Avatar rndAvatar = Database.getInstance().getRandomAvatar();
        avatarImg.setImageResource(rndAvatar.getImageResId());
        avatarImg.setTag(rndAvatar.getImageResId());
        avatarName.setText(rndAvatar.getName());
    }
}
