package jr.eder.developer.example.com.hackbbva.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jr.eder.developer.example.com.hackbbva.MainActivity;
import jr.eder.developer.example.com.hackbbva.R;
import jr.eder.developer.example.com.hackbbva.SeguridadActivity;

public class ChooseActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_posibles_clientes)
    public void startClients(){
        Intent intent = new Intent(this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }
    @OnClick(R.id.btn_seguridad)
    public void startSeguridad(){
        Intent intent = new Intent(this,
                SeguridadActivity.class);
        startActivity(intent);
        finish();
    }
}
