package com.ardakaplan.rdalibrarytest.ui.language;

import android.widget.Toast;

import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalogger.RDALogger;

import java.util.Random;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by Arda Kaplan at 4/6/2019
 * <p>
 * arda.kaplan09@gmail.com
 */
public class LanguageTestActivity extends RDAActivity {

    @Inject
    LanguageManager languageManager;

    @OnClick(R.id.language_test_activity_button_changeLanguage)
    void clickedChangeLanguage() {

        Random random = new Random();

        LanguageManager.Language selectedLanguage = LanguageManager.getAllDefinedLanguage().get(random.nextInt(LanguageManager.getAllDefinedLanguage().size()));

        RDALogger.info("SET LANGUAGE -> " + selectedLanguage);

        Toast.makeText(this, selectedLanguage.name(), Toast.LENGTH_SHORT).show();

        languageManager.setSelectedLanguage(selectedLanguage);
    }

    @OnClick(R.id.language_test_activity_button_getSelectedLanguage)
    void clickedGetSelectedLanguage() {

        Toast.makeText(this, languageManager.getSelectedLanguage().name(), Toast.LENGTH_SHORT).show();

        RDALogger.info("SELECTED LANGUAGE -> " + languageManager.getSelectedLanguage());
    }

    @Override
    public int getLayout() {
        return R.layout.activity_language_test;
    }
}
