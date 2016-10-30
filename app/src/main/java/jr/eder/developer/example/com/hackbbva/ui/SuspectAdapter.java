package jr.eder.developer.example.com.hackbbva.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import jr.eder.developer.example.com.hackbbva.models.Sospechosos;

/**
 * Created by ederpadilla on 30/10/16.
 */

public class SuspectAdapter extends RecyclerView.Adapter<SuspectAdapter.TitularesViewHolder>
        implements View.OnClickListener{

    private View.OnClickListener listener;
    private List<Sospechosos> datos;
    private Context context;

    public SuspectAdapter(List<Sospechosos> datos, Context context) {
        this.datos = datos;
        this.context = context;
    }


    @Override
    public SuspectAdapter.TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_rec_cliente, viewGroup, false);
        SuspectAdapter.TitularesViewHolder titularesViewHolder = new SuspectAdapter.TitularesViewHolder(itemView);
        return titularesViewHolder;
    }
    @Override
    public void onBindViewHolder(SuspectAdapter.TitularesViewHolder viewHolder, int pos) {
        Sospechosos item = datos.get(pos);
        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
        Log.e("entra al click ","tio");
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
        Log.e("entra al click ","tio");
        TitularesViewHolder titularesViewHolder = new TitularesViewHolder(view);

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
        private View rootView;

        public TitularesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            rootView = itemView;
        }

        /**
         * Set text to the headers and also set the background .
         **/
        public void bindTitular(Sospechosos cliente) {
            rootView.setOnClickListener(SuspectAdapter.this);
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
