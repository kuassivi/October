package com.kuassivi.example.october.base;

import com.kuassivi.october.mvp.OctoberCompatActivity;
import com.kuassivi.october.mvp.contract.Presentable;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class BaseCompatActivity<P extends Presentable> extends OctoberCompatActivity<P> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMessage(@NonNull String msg) {
        showSnackbar(msg, Color.GREEN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showError(@NonNull String msg) {
        showSnackbar(msg, Color.RED);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showWarning(@NonNull String msg) {
        showSnackbar(msg, Color.YELLOW);
    }

    public void showKeyboard() {
        if (!isFinishing()) {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);

            // Checks if no view has focus:
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                inputManager.showSoftInput(currentFocus, InputMethodManager.SHOW_FORCED);
            }
        }
    }

    public void hideKeyboard() {
        if (!isFinishing()) {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);

            // Checks if no view has focus:
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                inputManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading() {
    }

    private void showSnackbar(String msg, int color) {
        // Hides keyboard to let the user view the snackbar message
        hideKeyboard();

        // Prevent Activity finish
        if (!isFinishing()) {
            Snackbar snack = buildSnackbar(msg);
            if (snack != null) {
                snack.getView()
                     .setBackgroundColor(color);
                snack.show();
            }
        }
    }

    private Snackbar buildSnackbar(String msg) {
        Snackbar snack = null;
        View content = findViewById(android.R.id.content);
        if (content != null) {
            snack = Snackbar.make(content, msg, Snackbar.LENGTH_LONG);
            TextView snackbarText = (TextView)
                    snack.getView()
                         .findViewById(
                                 android.support.design.R.id.snackbar_text);
            snackbarText.setTextColor(Color.BLACK);
            snack.getView().setMinimumHeight(130);
        }

        return snack;
    }
}
