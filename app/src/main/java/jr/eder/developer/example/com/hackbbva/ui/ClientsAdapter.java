package jr.eder.developer.example.com.hackbbva.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import jr.eder.developer.example.com.hackbbva.R;
import jr.eder.developer.example.com.hackbbva.models.Cliente;

/**
 * Created by ederpadilla on 30/10/16.
 */

public class ClientsAdapter extends RecyclerView.Adapter<ClientsAdapter.TitularesViewHolder>
        implements View.OnClickListener{

    private View.OnClickListener listener;
    private List<Cliente> datos;
    private Context context;

    public ClientsAdapter(List<Cliente> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }


    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rec_cliente, viewGroup, false);

        TitularesViewHolder titularesViewHolder = new TitularesViewHolder(itemView);
        return titularesViewHolder;
    }
    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Cliente item = datos.get(pos);
        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);

    }
    public class TitularesViewHolder
            extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_status)
         TextView tv_status;
        @BindView(R.id.img_status)
         ImageView imgv_status;
        @BindView(R.id.layout_container)
         LinearLayout linearLayout;
        @BindView(R.id.client_image)
        CircleImageView client_image;

        public TitularesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        /**
         * Set text to the headers and also set the background .
         **/
        public void bindTitular(Cliente cliente) {
            if (cliente.getEstado()==0){
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.bluewhitesix));
                tv_status.setText("Bajo potencial");
                imgv_status.setImageResource(R.drawable.ic_sentiment_dissatisfied);
            }else if (cliente.getEstado()==1){
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.bluewhitefive));
                tv_status.setText("Potencial Medio");
                imgv_status.setImageResource(R.drawable.ic_sentiment_neutral);
            }else if(cliente.getEstado()==2){
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.bluewhitefive));
                tv_status.setText("Potencial medio");
                imgv_status.setImageResource(R.drawable.ic_sentiment_neutral);
            }else if (cliente.getEstado()==3){
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.bluewhitefour));
                tv_status.setText("Buen potencial");
                imgv_status.setImageResource(R.drawable.ic_sentiment_yes);
            }

        }

    }
}
