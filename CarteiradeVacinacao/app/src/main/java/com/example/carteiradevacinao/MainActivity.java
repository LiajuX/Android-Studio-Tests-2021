package com.example.carteiradevacinao;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public DatabaseManager db;
    public ArrayList<Vaccine> vaccines = new ArrayList<>();
    public Integer currentId = 0;
    public Integer totalVaccines = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.db = new DatabaseManager(this, "base", null, 1);
        startDatabase();
        showOnScreen();
    }

    public void startDatabase() {
        this.db.insertVaccine(1, "Tríplice bacteriana", "10022003", "Posto de Saúde Santa Cruz", 1);
        this.db.insertVaccine(2, "Tríplice viral", "10012004", "UBS Eldorado", 1);
        this.db.insertVaccine(3, "Hepatite A", "28012004", "UBS Alphaville", 1);
    }

    public void showOnScreen() {
        Cursor c = db.listAllVaccines();

        if (c.getCount() > 0) {
            c.moveToFirst();
            totalVaccines = c.getCount();
            currentId = 0;

            vaccines.clear();

            do {
                Vaccine vac = new Vaccine();
                vac.setId_vaccine(c.getInt(c.getColumnIndex("ID_VACCINE")));
                vac.setName(c.getString(c.getColumnIndex("NAME")));
                vac.setDate(c.getString(c.getColumnIndex("DATE")));
                vac.setClinic(c.getString(c.getColumnIndex("CLINIC")));
                vac.setDose(c.getInt(c.getColumnIndex("DOSE")));

                vaccines.add(vac);

            } while(c.moveToNext());
        }
    }

    // onClick do botão "próximo"
    public void showNextVaccine(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText name = findViewById(R.id.inputName);
        EditText date = findViewById(R.id.inputDate);
        EditText clinic = findViewById(R.id.inputClinic);
        EditText dose = findViewById(R.id.inputDose);

        Vaccine c = vaccines.get(currentId);

        id.setText(c.getId_vaccine().toString());
        name.setText(c.getName());
        date.setText(c.getDate());
        clinic.setText(c.getClinic());
        dose.setText(c.getDose().toString());

        currentId++;

        if (currentId == totalVaccines) {
            currentId = 0;
        }
    }

    // onClick do botão "atualizar"
    public void updateVaccine(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText name = findViewById(R.id.inputName);
        EditText date = findViewById(R.id.inputDate);
        EditText clinic = findViewById(R.id.inputClinic);
        EditText dose = findViewById(R.id.inputDose);

        this.db.updateVaccine(
            new Integer(id.getText().toString()),
            name.getText().toString(),
            date.getText().toString(),
            clinic.getText().toString(),
            new Integer(dose.getText().toString())
        );

        showOnScreen();
    }

    // onClick do botão "apagar"
    public void deleteVaccine(View view) {
        EditText id = findViewById(R.id.inputID);

        this.db.deleteVaccine(id.getText().toString());

        showOnScreen();
    }

    // onClick do botão "novo"
    public void newVaccine(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText name = findViewById(R.id.inputName);
        EditText date = findViewById(R.id.inputDate);
        EditText clinic = findViewById(R.id.inputClinic);
        EditText dose = findViewById(R.id.inputDose);

        id.setText("");
        name.setText("");
        date.setText("");
        clinic.setText("");
        dose.setText("");
    }

    // onClick do botão "inserir"
    public void insertNewVaccine(View view) {
        EditText id = findViewById(R.id.inputID);
        EditText name = findViewById(R.id.inputName);
        EditText date = findViewById(R.id.inputDate);
        EditText clinic = findViewById(R.id.inputClinic);
        EditText dose = findViewById(R.id.inputDose);

        this.db.insertVaccine(
            new Integer(id.getText().toString()),
            name.getText().toString(),
            date.getText().toString(),
            clinic.getText().toString(),
            new Integer(dose.getText().toString())
        );

        showOnScreen();
    }
}