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

public class PotentialClientsActivity extends AppCompatActivity {

    @BindView(R.id.recviewclients)
    RecyclerView recyclerView;

    public List<Cliente> clienteList;
    public ClientsAdapter clientsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potential_clients);
        ButterKnife.bind(this);
        initRecView();
    }

    private void initRecView() {
        clienteList= new ArrayList<Cliente>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new SlideInLeftAnimator());
        recyclerView.getItemAnimator().setAddDuration(800);
        recyclerView.getItemAnimator().setRemoveDuration(800);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        clientsAdapter= new ClientsAdapter(clienteList,this);
        recyclerView.setAdapter(clientsAdapter);
        Cliente cliente = new  Cliente (0,"sdf");
        Cliente cliente1 = new Cliente (1,"sdf");
        Cliente cliente2 = new Cliente (2,"sdf");
        Cliente cliente3 = new Cliente (3,"sdf");
        clienteList.add(cliente);
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);
        clientsAdapter.notifyDataSetChanged();
        clientsAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Perfil activity", "Pulsado el elemento " + recyclerView.getChildAdapterPosition(v));
                Cliente cliente = clienteList.get(recyclerView.getChildAdapterPosition(v));
                Intent intent = new Intent(PotentialClientsActivity.this,MainActivity.class);
                intent.putExtra("Algo",cliente.getEstado());
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
