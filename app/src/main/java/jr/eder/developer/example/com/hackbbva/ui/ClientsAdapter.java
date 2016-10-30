package jr.eder.developer.example.com.hackbbva.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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
        private View rootView;
        private TextView txtTitulo;
        private TextView txtSubtitulo;
        private View mContainer;

        public TitularesViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            txtTitulo = (TextView) itemView.findViewById(R.id.LblTitulo);
            txtSubtitulo = (TextView) itemView.findViewById(R.id.LblSubTitulo);
            mContainer = itemView.findViewById(R.id.layout_container);

        }

        /**
         * Set text to the headers and also set the background .
         **/
        public void bindTitular(Cliente cliente) {
            txtTitulo.setText(visita.getNombre());
            txtSubtitulo.setText(visita.getDireccion());
            if (visita.getTipo().trim().equalsIgnoreCase(Constants.VISITA_TIPO_PROGRAMADA)) {
                mContainer.setBackgroundColor(mContainer.getResources().getColor(R.color.visita_programada));
            } else if (visita.getTipo().trim().equalsIgnoreCase(Constants.VISITA_TIPO_FINALIZADA)) {
                mContainer.setBackgroundColor(mContainer.getResources().getColor(R.color.visitas_finalizadas));
            } else {
                mContainer.setBackgroundColor(mContainer.getResources().getColor(R.color.white));
            }
            rootView.setOnClickListener(AdaptadorVisitas.this);
        }
        public int checkClientStatus(Cliente cliente){
            int status =0;
            switch (status) {
                case 1:
                    status=0;
                    break;
                case 2:
                    status=1;
                case 3:
                    status=2;
                    break;
                case 4:
                    status=3;
                    break;
            }
            return status;
        }
    }
}
