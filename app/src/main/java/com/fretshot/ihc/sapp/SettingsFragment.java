package com.fretshot.ihc.sapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;
import static com.fretshot.ihc.sapp.SettingsActivity.KEY_CONTACTO;
import static com.fretshot.ihc.sapp.SettingsActivity.KEY_CONTACTO_EMERGENCIA;


public class SettingsFragment extends PreferenceFragmentCompat {

    public static String number;
    public static String name;
    public static Preference button;
    public static Preference contacto_emergencia;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        setPreferencesFromResource(R.xml.preferences, rootKey);

        PreferenceManager.setDefaultValues(getActivity().getApplicationContext(), R.xml.preferences, false);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String contacto_emergencia_fragment = sharedPreferences.getString(SettingsActivity.KEY_CONTACTO_EMERGENCIA,null);

        contacto_emergencia = findPreference(KEY_CONTACTO_EMERGENCIA);
        contacto_emergencia.setVisible(false);

        button = findPreference(KEY_CONTACTO);
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                Intent chooseContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                chooseContact.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(chooseContact, 9);

                Toast.makeText(getContext(), "Seleccione un Contacto de Emergencia", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        if(contacto_emergencia_fragment==null){
            Snackbar.make(getActivity().findViewById(android.R.id.content),"Contacto de Emergencia NO DEFINIDO", Snackbar.LENGTH_INDEFINITE).show();
        }else{
            Snackbar.make(getActivity().findViewById(android.R.id.content),"Contacto de Emergencia: "+contacto_emergencia_fragment, Snackbar.LENGTH_INDEFINITE).show();
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 9:
                    Cursor cursor;
                    try {
                        Uri uri = data.getData();
                        cursor = getActivity().getApplicationContext().getContentResolver().query(uri, null, null, null, null);
                        cursor.moveToFirst();
                        int  phoneIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        int  nameIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                        number = cursor.getString(phoneIndex);
                        name = cursor.getString(nameIndex);

                        button.setSummary(number);

                        Snackbar.make(getActivity().findViewById(android.R.id.content),"Contacto de Emergencia:  "+name+" "+number, Snackbar.LENGTH_INDEFINITE).show();

                        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext()).edit();
                        editor.putString(KEY_CONTACTO_EMERGENCIA,number);
                        editor.commit();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else {
            Log.e("Failed", "Not able to pick contact");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        android.support.v4.app.NavUtils.navigateUpFromSameTask(getActivity());
        }
    }