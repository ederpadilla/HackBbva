package jr.eder.developer.example.com.hackbbva.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jr.eder.developer.example.com.hackbbva.MainActivity;
import jr.eder.developer.example.com.hackbbva.R;
import jr.eder.developer.example.com.hackbbva.models.Cliente;
import jr.eder.developer.example.com.hackbbva.models.Sospechosos;

public class PotentialRobersActivity extends AppCompatActivity {
    @BindView(R.id.recviewRobers)
    RecyclerView recyclerView;
    List<Sospechosos> clienteList;
    SuspectAdapter suspectAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potential_robers);
        ButterKnife.bind(this);
        initRecView();
    }


        private void initRecView() {
            clienteList= new ArrayList<Sospechosos>();
            recyclerView.setHasFixedSize(true);
            recyclerView.setItemAnimator(new SlideInLeftAnimator());
            recyclerView.getItemAnimator().setAddDuration(800);
            recyclerView.getItemAnimator().setRemoveDuration(800);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
            suspectAdapter = new SuspectAdapter(clienteList,this);
            recyclerView.setAdapter(suspectAdapter);
            Sospechosos sospechosos = new Sospechosos(0,"sdsdf");
            Sospechosos sospechosos1 = new Sospechosos(1,"sdsasddf");
            Sospechosos sospechosos2 = new Sospechosos(2,"sdsfdf");
            Sospechosos sospechosos3 = new Sospechosos(3,"sdsdfrf");
            clienteList.add(sospechosos);
            clienteList.add(sospechosos1);
            clienteList.add(sospechosos2);
            clienteList.add(sospechosos3);
            suspectAdapter.notifyDataSetChanged();
            suspectAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("Perfil activity", "Pulsado el elemento " + recyclerView.getChildAdapterPosition(v));
                    Sospechosos cliente = clienteList.get(recyclerView.getChildAdapterPosition(v));
                    Intent intent = new Intent(PotentialRobersActivity.this,MainActivity.class);
                    intent.putExtra("Algo",cliente.getId());
                    startActivity(intent);
                    finish();
                }
            });
        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,
                ChooseActionActivity.class);
        startActivity(intent);
        finish();
    }
}
